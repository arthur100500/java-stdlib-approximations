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

    public int characteristics() {
        return LibSLGlobals.SPLITERATOR_ORDERED | LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_SUBSIZED;
    }

    public long estimateSize() {
        return super.estimateSize();
    }

    public void forEachRemaining(Consumer<? super E> _action) {
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

    public long getExactSizeIfKnown() {
        return super.getExactSizeIfKnown();
    }

    public boolean tryAdvance(Consumer<? super E> _action) {
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

    public ListSpliteratorStubImpl<E> trySplit() {
        return (ListSpliteratorStubImpl<E>) super.trySplit();
    }
}
