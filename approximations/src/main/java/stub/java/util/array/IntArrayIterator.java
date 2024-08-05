package stub.java.util.array;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class IntArrayIterator extends AbstractArrayIterator<Integer> implements PrimitiveIterator.OfInt {

    @SuppressWarnings("unused")
    public IntArrayIterator(int[] storage, int cursor) {
        super(cursor);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public IntArrayIterator(int[] storage) {
        this(storage, 0);
        throw new LinkageError();
    }

    protected int _getLength() {
        throw new LinkageError();
    }

    protected Integer _getItem(int index) {
        throw new LinkageError();
    }

    public boolean hasNext() {
        throw new LinkageError();
    }

    public Integer next() {
        throw new LinkageError();
    }

    public int nextInt() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void remove() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void forEachRemaining(Consumer<? super Integer> action) {
        throw new LinkageError();
    }

    public void forEachRemaining(IntConsumer action) {
        throw new LinkageError();
    }
}
