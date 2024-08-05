package generated.java.util.array;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import stub.java.util.array.IntArrayIterator;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

@Approximate(IntArrayIterator.class)
public class IntArrayIteratorImpl extends AbstractArrayIteratorImpl<Integer> implements PrimitiveIterator.OfInt {

    private final int[] storage;

    public IntArrayIteratorImpl(int[] storage, int cursor) {
        super(cursor);
        this.storage = storage;
    }

    public IntArrayIteratorImpl(int[] storage) {
        this(storage, 0);
    }

    @SuppressWarnings({"DataFlowIssue", "ConstantValue"})
    private int[] _getStorage() {
        int[] storage = this.storage;
        Engine.assume(storage != null);
        Engine.assume(storage.length >= 0);
        return storage;
    }

    protected int _getLength() {
        return _getStorage().length;
    }

    protected Integer _getItem(int index) {
        return _getStorage()[index];
    }

    public boolean hasNext() {
        return super.hasNext();
    }

    public Integer next() {
        return super.next();
    }

    public int nextInt() {
        if (_isEmpty())
            throw new NoSuchElementException();

        return _getStorage()[this.cursor++];
    }

    public void remove() {
        super.remove();
    }

    public void forEachRemaining(Consumer<? super Integer> action) {
        super.forEachRemaining(action);
    }

    public void forEachRemaining(IntConsumer action) {
        if (action == null)
            throw new NullPointerException();

        int[] storage = _getStorage();
        int length = storage.length;
        if (this.cursor >= length)
            return;

        while (this.cursor < length) {
            int item = storage[this.cursor++];
            action.accept(item);
        }
    }
}
