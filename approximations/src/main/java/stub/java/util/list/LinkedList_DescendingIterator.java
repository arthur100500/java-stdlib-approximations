package stub.java.util.list;

import generated.java.util.list.LinkedListImpl;

import java.lang.LinkageError;
import java.util.function.Consumer;

public final class LinkedList_DescendingIterator<E> extends ListIteratorStub<E> {

    public LinkedList_DescendingIterator(LinkedListImpl<E> list) {
        super(list);
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
    public void remove() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void forEachRemaining(Consumer<? super E> userAction) {
        throw new LinkageError();
    }
}
