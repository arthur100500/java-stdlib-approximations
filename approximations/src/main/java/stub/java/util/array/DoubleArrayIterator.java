package stub.java.util.array;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public class DoubleArrayIterator extends AbstractArrayIterator<Double> implements PrimitiveIterator.OfDouble {

    @SuppressWarnings("unused")
    public DoubleArrayIterator(double[] storage, int cursor) {
        super(cursor);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public DoubleArrayIterator(double[] storage) {
        this(storage, 0);
        throw new LinkageError();
    }

    protected int _getLength() {
        throw new LinkageError();
    }

    protected Double _getItem(int index) {
        throw new LinkageError();
    }

    public boolean hasNext() {
        throw new LinkageError();
    }

    public Double next() {
        throw new LinkageError();
    }

    public double nextDouble() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void remove() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void forEachRemaining(Consumer<? super Double> userAction) {
        throw new LinkageError();
    }

    public void forEachRemaining(DoubleConsumer action) {
        throw new LinkageError();
    }
}
