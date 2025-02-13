package generated.java.util.set;

import generated.java.util.AbstractSpliteratorImpl;
import generated.runtime.LibSLGlobals;
import java.lang.NullPointerException;
import java.lang.Object;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.set.Set_Spliterator;

import static runtime.LibSLRuntime.error;

@Approximate(Set_Spliterator.class)
public final class Set_SpliteratorImpl<E> extends AbstractSpliteratorImpl<E> {

    AbstractSetImpl<E> set;

    SymbolicList<E> seenKeys;

    SymbolicList<E> unseenKeys;

    public int index;

    public int fence;

    public int expectedModCount;

    Set_SpliteratorImpl(
        AbstractSetImpl<E> set,
        SymbolicList<E> seenKeys,
        SymbolicList<E> unseenKeys,
        int index,
        int fence,
        int expectedModCount
    ) {
        super(index, fence, expectedModCount);
        this.set = set;
        this.seenKeys = seenKeys;
        this.unseenKeys = unseenKeys;
    }

    public Set_SpliteratorImpl(AbstractSetImpl<E> set) {
        this(set, Engine.makeSymbolicList(), null, 0, -1, 0);
    }

    protected int _getIndex() {
        return index;
    }

    protected void _setIndex(int newIndex) {
        this.index = newIndex;
    }

    protected int _getFence() {
        return fence;
    }

    protected void _setFence(int newFence) {
        this.fence = newFence;
    }

    protected int _getExpectedModCount() {
        return expectedModCount;
    }

    protected void _setExpectedModCount(int newExpectedModCount) {
        this.expectedModCount = newExpectedModCount;
    }

    protected AbstractSpliteratorImpl<E> _create(int index, int fence) {
        return null;
    }

    private AbstractSetImpl<E> _getSet() {
        AbstractSetImpl<E> result = this.set;
        Engine.assume(result != null);
        return result;
    }

    protected int _parentModCount() {
        return _getSet()._getModCount();
    }

    protected int _storageSize() {
        return _getSet()._getStorage().size();
    }

    protected int _characteristics() {
        if (this.fence < 0 || this.index == 0 && this.fence == _storageSize())
            return LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_DISTINCT;

        return LibSLGlobals.SPLITERATOR_DISTINCT;
    }

    @SuppressWarnings("MagicConstant")
    public int characteristics() {
        return _characteristics();
    }

    public long estimateSize() {
        return super._estimateSize();
    }

    private int _checkSizeOfUnseenKeys() {
        int size = unseenKeys.size();
        if (size != estimateSize())
            error("invariant violation");

        return size;
    }

    private int _checkSizeOfSeenKeys() {
        int size = seenKeys.size();
        if (size != index)
            error("invariant violation");

        return size;
    }

    private LibSLRuntime.Map<E, Object> _removeSeenKeys() {
        LibSLRuntime.Map<E, Object> storage = _getSet()._getStorage().duplicate();
        int size = _checkSizeOfSeenKeys();
        for (int i = 0; i < size; i++) {
            E key = seenKeys.get(i);
            storage.remove(key);
        }

        return storage;
    }

    protected void _forEachRemaining(Consumer<? super E> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        int fence = _fence();
        if (unseenKeys != null) {
            _checkSizeOfSeenKeys();
            int size = _checkSizeOfUnseenKeys();
            for (int i = 0; i < size; i++) {
                E key = unseenKeys.get(i);
                userAction.accept(key);
            }
            unseenKeys.copy(seenKeys, 0, 0, size);
        } else {
            LibSLRuntime.Map<E, Object> unseenStorage = _removeSeenKeys();
            for (int i = this.index; i < fence; i++) {
                E key = unseenStorage.anyKey();
                userAction.accept(key);
                unseenStorage.remove(key);
                seenKeys.insert(i, key);
            }
        }

        this.index = fence;
        _checkForModification();
    }

    public void forEachRemaining(Consumer<? super E> userAction) {
        _forEachRemaining(userAction);
    }

    public long getExactSizeIfKnown() {
        return super._getExactSizeIfKnown();
    }

    protected boolean _tryAdvance(Consumer<? super E> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        int hi = _fence();
        if (this.index >= hi)
            return false;

        if (unseenKeys != null) {
            _checkSizeOfSeenKeys();
            _checkSizeOfUnseenKeys();
            E key = unseenKeys.get(0);
            userAction.accept(key);
            unseenKeys.remove(0);
            seenKeys.insert(this.index, key);
        } else {
            LibSLRuntime.Map<E, Object> unseenStorage = _removeSeenKeys();
            E key = unseenStorage.anyKey();
            userAction.accept(key);
            seenKeys.insert(this.index, key);
        }

        this.index++;
        _checkForModification();

        return true;
    }

    public boolean tryAdvance(Consumer<? super E> userAction) {
        return _tryAdvance(userAction);
    }

    protected Set_SpliteratorImpl<E> _trySplit() {
        int hi = _fence();
        int lo = this.index;
        int mid = (hi + lo) >>> 1;
        if (lo >= mid)
            return null;

        LibSLRuntime.Map<E, Object> unseenStorage = _removeSeenKeys();
        SymbolicList<E> newUnseenKeys = Engine.makeSymbolicList();
        SymbolicList<E> newSeenKeys = Engine.makeSymbolicList();

        int j = 0;
        for (int i = lo; i < mid; i++) {
            E key = unseenStorage.anyKey();
            seenKeys.insert(i, key);
            newUnseenKeys.insert(j++, key);
        }

        this.index = mid;
        return new Set_SpliteratorImpl<>(this.set, newSeenKeys, newUnseenKeys, lo, mid, this.expectedModCount);
    }

    public Set_SpliteratorImpl<E> trySplit() {
        return _trySplit();
    }
}
