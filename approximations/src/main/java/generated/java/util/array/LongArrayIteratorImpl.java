package generated.java.util.array;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import stub.java.util.array.LongArrayIterator;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

@Approximate(LongArrayIterator.class)
public class LongArrayIteratorImpl extends AbstractArrayIteratorImpl<Long> implements PrimitiveIterator.OfLong {

    private final long[] storage;

    public LongArrayIteratorImpl(long[] storage, int cursor) {
        super(cursor);
        this.storage = storage;
    }

    public LongArrayIteratorImpl(long[] storage) {
        this(storage, 0);
    }

    @SuppressWarnings({"DataFlowIssue", "ConstantValue"})
    private long[] _getStorage() {
        long[] storage = this.storage;
        Engine.assume(storage != null);
        Engine.assume(storage.length >= 0);
        return storage;
    }

    protected int _getLength() {
        return _getStorage().length;
    }

    protected Long _getItem(int index) {
        return _getStorage()[index];
    }

    public boolean hasNext() {
        return super.hasNext();
    }

    public Long next() {
        return super.next();
    }

    public long nextLong() {
        if (_isEmpty())
            throw new NoSuchElementException();

        return _getStorage()[this.cursor++];
    }

    public void remove() {
        super.remove();
    }

    public void forEachRemaining(Consumer<? super Long> action) {
        super.forEachRemaining(action);
    }

    public void forEachRemaining(LongConsumer action) {
        if (action == null)
            throw new NullPointerException();

        long[] storage = _getStorage();
        int length = storage.length;
        if (this.cursor >= length)
            return;

        while (this.cursor < length) {
            long item = storage[this.cursor++];
            action.accept(item);
        }
    }
}
