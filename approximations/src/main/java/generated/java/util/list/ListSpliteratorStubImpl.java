package generated.java.util.list;

import generated.java.util.AbstractSpliteratorImpl;
import generated.runtime.LibSLGlobals;
import java.lang.NullPointerException;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import stub.java.util.list.ListSpliteratorStub;

@Approximate(ListSpliteratorStub.class)
public class ListSpliteratorStubImpl<E> extends AbstractSpliteratorImpl<E> {

    public AbstractListImpl<E> list;

    protected ListSpliteratorStubImpl(AbstractListImpl<E> list, int index, int fence, int expectedModCount) {
        super(index, fence, expectedModCount);
        Engine.assume(list != null);
        this.list = list;
    }

    public ListSpliteratorStubImpl(AbstractListImpl<E> list) {
        this(list, 0, -1, 0);
    }

    private AbstractListImpl<E> _getList() {
        AbstractListImpl<E> result = this.list;
        Engine.assume(result != null);
        return result;
    }

    protected ListSpliteratorStubImpl<E> _create(int index, int fence) {
        return new ListSpliteratorStubImpl<>(this.list, index, fence, this.expectedModCount);
    }

    protected int _parentModCount() {
        return _getList().modCount;
    }

    protected int _storageSize() {
        return _getList()._getStorage().size();
    }

    protected int _characteristics() {
        return LibSLGlobals.SPLITERATOR_ORDERED | LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_SUBSIZED;
    }

    @SuppressWarnings("MagicConstant")
    public int characteristics() {
        return _characteristics();
    }

    public long estimateSize() {
        return super._estimateSize();
    }

    protected void _forEachRemaining(Consumer<? super E> _action) {
        if (_action == null)
            throw new NullPointerException();

        SymbolicList<E> storage = _getList()._getStorage();
        int fence = _getFence();
        for (int i = this.index; i < fence; i++) {
            E item = storage.get(i);
            _action.accept(item);
        }
        this.index = fence;
        _checkForModification();
    }

    public void forEachRemaining(Consumer<? super E> _action) {
        _forEachRemaining(_action);
    }

    public long getExactSizeIfKnown() {
        return super._getExactSizeIfKnown();
    }

    protected boolean _tryAdvance(Consumer<? super E> _action) {
        if (_action == null)
            throw new NullPointerException();

        int fence = _getFence();
        int current = this.index;
        if (current >= fence)
            return false;

        this.index = current + 1;
        SymbolicList<E> storage = _getList()._getStorage();
        E item = storage.get(current);
        _action.accept(item);
        _checkForModification();

        return true;
    }

    public boolean tryAdvance(Consumer<? super E> _action) {
        return _tryAdvance(_action);
    }

    public ListSpliteratorStubImpl<E> trySplit() {
        return (ListSpliteratorStubImpl<E>) super._trySplit();
    }
}
