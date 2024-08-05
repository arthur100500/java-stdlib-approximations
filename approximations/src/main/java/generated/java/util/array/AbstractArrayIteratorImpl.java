package generated.java.util.array;

import generated.java.util.AbstractIteratorImpl;
import org.jacodb.approximation.annotation.Approximate;
import stub.java.util.array.AbstractArrayIterator;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

@Approximate(AbstractArrayIterator.class)
public abstract class AbstractArrayIteratorImpl<E> extends AbstractIteratorImpl<E> {

    public int cursor;

    AbstractArrayIteratorImpl(int cursor) {
        super(0);
        this.cursor = cursor;
    }

    protected final int _parentModCount() {
        return 0;
    }

    abstract protected int _getLength();

    abstract protected E _getItem(int index);

    protected boolean _isEmpty() {
        return this.cursor >= _getLength();
    }

    public boolean hasNext() {
        return !_isEmpty();
    }

    public E next() {
        if (this.cursor >= _getLength())
            throw new NoSuchElementException();

        return _getItem(this.cursor++);
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void forEachRemaining(Consumer<? super E> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        int length = _getLength();
        if (this.cursor >= length)
            return;

        while (this.cursor < length) {
            E item = _getItem(this.cursor++);
            userAction.accept(item);
        }
    }
}
