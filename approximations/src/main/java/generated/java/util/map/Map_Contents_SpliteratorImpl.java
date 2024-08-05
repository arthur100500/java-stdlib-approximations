package generated.java.util.map;

import generated.java.util.AbstractSpliteratorImpl;
import generated.runtime.LibSLGlobals;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.map.Map_Contents_Spliterator;

import java.util.Map;
import java.util.function.Consumer;

import static runtime.LibSLRuntime.error;

@Approximate(Map_Contents_Spliterator.class)
public class Map_Contents_SpliteratorImpl<K, V, Content> extends AbstractSpliteratorImpl<Content> {

    Map_ContentsImpl<K, V, Content> contents;

    SymbolicList<K> seenKeys;

    SymbolicList<K> unseenKeys;

    Map_Contents_SpliteratorImpl(
        Map_ContentsImpl<K, V, Content> contents,
        SymbolicList<K> seenKeys,
        SymbolicList<K> unseenKeys,
        int index,
        int fence,
        int expectedModCount
    ) {
        super(index, fence, expectedModCount);
        this.contents = contents;
        this.seenKeys = seenKeys;
        this.unseenKeys = unseenKeys;
    }

    public Map_Contents_SpliteratorImpl(Map_ContentsImpl<K, V, Content> contents) {
        this(contents, Engine.makeSymbolicList(), null, 0, -1, 0);
    }

    protected AbstractSpliteratorImpl<Content> _create(int index, int fence) {
        return null;
    }

    Map_Contents_SpliteratorImpl<K, V, Content> _createSpliterator(
        SymbolicList<K> seenKeys,
        SymbolicList<K> unseenKeys,
        int index,
        int fence,
        int expectedModCount
    ) {
        return new Map_Contents_SpliteratorImpl<>(this.contents, seenKeys, unseenKeys, index, fence, expectedModCount);
    }

    private Map_ContentsImpl<K, V, Content> _getContents() {
        Map_ContentsImpl<K, V, Content> result = this.contents;
        Engine.assume(result != null);
        return result;
    }

    private AbstractMapImpl<K, V> _getMap() {
        AbstractMapImpl<K, V> result = _getContents().map;
        Engine.assume(result != null);
        return result;
    }

    protected int _parentModCount() {
        return _getMap().modCount;
    }

    protected int _storageSize() {
        return _getContents().getStorage().size();
    }

    protected int _defaultCharacteristics() {
        return 0;
    }

    public int characteristics() {
        if (this.fence < 0 || this.index == 0 && this.fence == _storageSize())
            return LibSLGlobals.SPLITERATOR_SIZED | _defaultCharacteristics();

        return _defaultCharacteristics();
    }

    public long estimateSize() {
        return super.estimateSize();
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

    private LibSLRuntime.Map<K, Map.Entry<K, V>> _removeSeenKeys() {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getContents().getStorage().duplicate();
        int size = _checkSizeOfSeenKeys();
        for (int i = 0; i < size; i++) {
            K key = seenKeys.get(i);
            storage.remove(key);
        }

        return storage;
    }

    public void forEachRemaining(Consumer<? super Content> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        int fence = _getFence();
        Map_ContentsImpl<K, V, Content> contents = _getContents();
        if (unseenKeys != null) {
            _checkSizeOfSeenKeys();
            int size = _checkSizeOfUnseenKeys();
            LibSLRuntime.Map<K, Map.Entry<K, V>> storage = contents.getStorage();
            for (int i = 0; i < size; i++) {
                K key = unseenKeys.get(i);
                userAction.accept(contents._contentByKey(storage, key));
            }
            unseenKeys.copy(seenKeys, 0, 0, size);
        } else {
            LibSLRuntime.Map<K, Map.Entry<K, V>> unseenStorage = _removeSeenKeys();
            for (int i = this.index; i < fence; i++) {
                K key = unseenStorage.anyKey();
                userAction.accept(contents._contentByKey(unseenStorage, key));
                unseenStorage.remove(key);
                seenKeys.insert(i, key);
            }
        }

        this.index = fence;
        _checkForModification();
    }

    public long getExactSizeIfKnown() {
        return super.getExactSizeIfKnown();
    }

    public boolean tryAdvance(Consumer<? super Content> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        int hi = _getFence();
        if (this.index >= hi)
            return false;

        Map_ContentsImpl<K, V, Content> contents = _getContents();
        if (unseenKeys != null) {
            _checkSizeOfSeenKeys();
            _checkSizeOfUnseenKeys();
            K key = unseenKeys.get(0);
            LibSLRuntime.Map<K, Map.Entry<K, V>> storage = contents.getStorage();
            userAction.accept(contents._contentByKey(storage, key));
            unseenKeys.remove(0);
            seenKeys.insert(this.index, key);
        } else {
            LibSLRuntime.Map<K, Map.Entry<K, V>> unseenStorage = _removeSeenKeys();
            K key = unseenStorage.anyKey();
            userAction.accept(contents._contentByKey(unseenStorage, key));
            seenKeys.insert(this.index, key);
        }

        this.index++;
        _checkForModification();

        return true;
    }

    public Map_Contents_SpliteratorImpl<K, V, Content> trySplit() {
        int hi = _getFence();
        int lo = this.index;
        int mid = (hi + lo) >>> 1;
        if (lo >= mid)
            return null;

        LibSLRuntime.Map<K, Map.Entry<K, V>> unseenStorage = _removeSeenKeys();
        SymbolicList<K> newUnseenKeys = Engine.makeSymbolicList();
        SymbolicList<K> newSeenKeys = Engine.makeSymbolicList();

        int j = 0;
        for (int i = lo; i < mid; i++) {
            K key = unseenStorage.anyKey();
            seenKeys.insert(i, key);
            newUnseenKeys.insert(j++, key);
        }

        this.index = mid;
        return _createSpliterator(newSeenKeys, newUnseenKeys, lo, mid, this.expectedModCount);
    }
}
