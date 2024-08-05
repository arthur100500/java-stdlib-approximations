package generated.java.util;

import org.jacodb.approximation.annotation.Approximate;
import stub.java.util.AbstractIterator;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

@Approximate(AbstractIterator.class)
public abstract class AbstractIteratorImpl<E> implements Iterator<E> {

    public int expectedModCount;

    public AbstractIteratorImpl(int expectedModCount) {
        this.expectedModCount = expectedModCount;
    }

    abstract protected int _parentModCount();

    protected void _checkForModification() {
        if (_parentModCount() != this.expectedModCount)
            throw new ConcurrentModificationException();
    }
}
