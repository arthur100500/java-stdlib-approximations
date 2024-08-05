package stub.java.util;

import java.util.Iterator;

public abstract class AbstractIterator<E> implements Iterator<E> {

    @SuppressWarnings("unused")
    public AbstractIterator(int expectedModCount) {
        throw new LinkageError();
    }

    abstract protected int _parentModCount();

    protected void _checkForModification() {
        throw new LinkageError();
    }
}
