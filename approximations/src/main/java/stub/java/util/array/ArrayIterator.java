package stub.java.util.array;

import java.util.function.Consumer;

public class ArrayIterator<E> extends AbstractArrayIterator<E> {

    @SuppressWarnings("unused")
    public ArrayIterator(E[] storage, int cursor) {
        super(cursor);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public ArrayIterator(E[] storage) {
        this(storage, 0);
        throw new LinkageError();
    }

    protected int _getLength() {
        throw new LinkageError();
    }

    protected E _getItem(int index) {
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
