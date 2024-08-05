package generated.java.util.list;

import java.util.function.Consumer;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import stub.java.util.list.SubListIteratorStub;

@Approximate(SubListIteratorStub.class)
public final class SubListIteratorStubImpl<E> extends ListIteratorStubImpl<E> {

    private final SubListImpl<E> subList;

    private final int startIndex;

    private int endIndex;

    public SubListIteratorStubImpl(
        AbstractListImpl<E> list,
        SubListImpl<E> subList,
        int cursor,
        int expectedModCount,
        int offset,
        int length
    ) {
        super(list, cursor + offset, expectedModCount);
        Engine.assume(list != null);
        Engine.assume(subList != null);
        this.subList = subList;
        this.startIndex = offset;
        this.endIndex = offset + length;
    }

    public SubListIteratorStubImpl(SubListImpl<E> subList, int index) {
        this(subList._getList(), subList, index, subList.modCount, subList.offset, subList.length);
    }

    public SubListIteratorStubImpl(SubListImpl<E> subList) {
        this(subList, 0);
    }

    protected int _getSize(SymbolicList<E> storage) {
        return endIndex;
    }

    private SubListImpl<E> _getSubList() {
        SubListImpl<E> subList = this.subList;
        Engine.assume(subList != null);
        return subList;
    }

    public boolean hasPrevious() {
        return this.cursor > startIndex;
    }

    public int nextIndex() {
        return super.nextIndex();
    }

    public int previousIndex() {
        return super.previousIndex();
    }

    public boolean hasNext() {
        return _hasNext(endIndex);
    }

    public E next() {
        return super.next();
    }

    public E previous() {
        return super.previous();
    }

    public void remove() {
        super.remove();
        _getSubList()._updateSizeAndModCount(-1);
    }

    public void set(E e) {
        super.set(e);
    }

    public void add(E e) {
        super.add(e);
        _getSubList()._updateSizeAndModCount(1);
        this.endIndex++;
    }

    public void forEachRemaining(Consumer<? super E> userAction) {
        super.forEachRemaining(userAction);
    }
}
