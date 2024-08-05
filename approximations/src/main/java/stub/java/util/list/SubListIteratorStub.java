package stub.java.util.list;

import generated.java.util.list.AbstractListImpl;
import generated.java.util.list.SubListImpl;
import org.usvm.api.SymbolicList;

import java.lang.LinkageError;
import java.util.function.Consumer;

public final class SubListIteratorStub<E> extends ListIteratorStub<E> {

    @SuppressWarnings("unused")
    public SubListIteratorStub(
        AbstractListImpl<E> list,
        SubListImpl<E> subList,
        int cursor,
        int expectedModCount,
        int offset,
        int length
    ) {
        super(list);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public SubListIteratorStub(SubListImpl<E> subList, int index) {
        super(subList, index);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public SubListIteratorStub(SubListImpl<E> subList) {
        super(subList);
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    protected int _getSize(SymbolicList<E> storage) {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public boolean hasPrevious() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public int nextIndex() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public int previousIndex() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public boolean hasNext() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public E next() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public E previous() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void remove() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void set(E e) {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void add(E e) {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void forEachRemaining(Consumer<? super E> userAction) {
        throw new LinkageError();
    }
}
