package generated.java.util.array;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import stub.java.util.array.ArrayIterator;

import java.util.function.Consumer;

@Approximate(ArrayIterator.class)
public class ArrayIteratorImpl<E> extends AbstractArrayIteratorImpl<E> {

    private final E[] storage;

    public ArrayIteratorImpl(E[] storage, int cursor) {
        super(cursor);
        this.storage = storage;
    }

    public ArrayIteratorImpl(E[] storage) {
        this(storage, 0);
    }

    @SuppressWarnings({"DataFlowIssue", "ConstantValue"})
    private E[] _getStorage() {
        E[] storage = this.storage;
        Engine.assume(storage != null);
        Engine.assume(storage.length >= 0);
        return storage;
    }

    protected int _getLength() {
        return _getStorage().length;
    }

    protected E _getItem(int index) {
        return _getStorage()[index];
    }

    public boolean hasNext() {
        return super.hasNext();
    }

    public E next() {
        return super.next();
    }

    public void remove() {
        super.remove();
    }

    public void forEachRemaining(Consumer<? super E> userAction) {
        super.forEachRemaining(userAction);
    }
}
