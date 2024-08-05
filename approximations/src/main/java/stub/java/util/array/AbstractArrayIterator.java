package stub.java.util.array;

import stub.java.util.AbstractIterator;

import java.util.function.Consumer;

public abstract class AbstractArrayIterator<E> extends AbstractIterator<E> {

    @SuppressWarnings("unused")
    AbstractArrayIterator(int cursor) {
        super(0);
        throw new LinkageError();
    }

    protected final int _parentModCount() {
        throw new LinkageError();
    }

    abstract protected int _getLength();

    abstract protected E _getItem(int index);

    @SuppressWarnings("unused")
    protected boolean _isEmpty() {
        throw new LinkageError();
    }

    public boolean hasNext() {
        throw new LinkageError();
    }

    public E next() {
        throw new LinkageError();
    }

    public void remove() {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer<? super E> userAction) {
        throw new LinkageError();
    }
}
