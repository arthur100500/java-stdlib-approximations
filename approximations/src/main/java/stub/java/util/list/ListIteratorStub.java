package stub.java.util.list;

import generated.java.util.list.AbstractListImpl;
import org.usvm.api.SymbolicList;
import stub.java.util.AbstractIterator;

import java.lang.LinkageError;
import java.util.ListIterator;
import java.util.function.Consumer;

public class ListIteratorStub<E> extends AbstractIterator<E> implements ListIterator<E> {

    @SuppressWarnings("unused")
    public ListIteratorStub(AbstractListImpl<E> list, int index, int expectedModCount) {
        super(expectedModCount);
        throw new LinkageError();
    }

    public ListIteratorStub(AbstractListImpl<E> list, int index) {
        this(list, index, list.modCount);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public ListIteratorStub(AbstractListImpl<E> list) {
        this(list, 0);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    protected AbstractListImpl<E> _getList() {
        throw new LinkageError();
    }

    protected int _parentModCount() {
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    protected int _getSize(SymbolicList<E> storage) {
        throw new LinkageError();
    }

    public boolean hasPrevious() {
        throw new LinkageError();
    }

    public int nextIndex() {
        throw new LinkageError();
    }

    public int previousIndex() {
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    protected boolean _hasNext(int size) {
        throw new LinkageError();
    }

    public boolean hasNext() {
        throw new LinkageError();
    }

    public E next() {
        throw new LinkageError();
    }

    public E previous() {
        throw new LinkageError();
    }

    public void remove() {
        throw new LinkageError();
    }

    public void set(E e) {
        throw new LinkageError();
    }

    public void add(E e) {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer<? super E> userAction) {
        throw new LinkageError();
    }
}
