package stub.java.util.array;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public class LongArrayIterator extends AbstractArrayIterator<Long> implements PrimitiveIterator.OfLong {

    @SuppressWarnings("unused")
    public LongArrayIterator(long[] storage, int cursor) {
        super(cursor);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public LongArrayIterator(long[] storage) {
        this(storage, 0);
        throw new LinkageError();
    }

    protected int _getLength() {
        throw new LinkageError();
    }

    protected Long _getItem(int index) {
        throw new LinkageError();
    }

    public boolean hasNext() {
        throw new LinkageError();
    }

    public Long next() {
        throw new LinkageError();
    }

    public long nextLong() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void remove() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void forEachRemaining(Consumer<? super Long> action) {
        throw new LinkageError();
    }

    public void forEachRemaining(LongConsumer action) {
        throw new LinkageError();
    }
}
