package generated.java.util.array;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import stub.java.util.array.DoubleArrayIterator;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

@Approximate(DoubleArrayIterator.class)
public class DoubleArrayIteratorImpl extends AbstractArrayIteratorImpl<Double> implements PrimitiveIterator.OfDouble {

    private final double[] storage;

    public DoubleArrayIteratorImpl(double[] storage, int cursor) {
        super(cursor);
        this.storage = storage;
    }

    public DoubleArrayIteratorImpl(double[] storage) {
        this(storage, 0);
    }

    @SuppressWarnings({"DataFlowIssue", "ConstantValue"})
    private double[] _getStorage() {
        double[] storage = this.storage;
        Engine.assume(storage != null);
        Engine.assume(storage.length >= 0);
        return storage;
    }

    protected int _getLength() {
        return _getStorage().length;
    }

    protected Double _getItem(int index) {
        return _getStorage()[index];
    }

    public boolean hasNext() {
        return super.hasNext();
    }

    public Double next() {
        return super.next();
    }

    public double nextDouble() {
        if (_isEmpty())
            throw new NoSuchElementException();

        return _getStorage()[this.cursor++];
    }

    public void remove() {
        super.remove();
    }

    public void forEachRemaining(Consumer<? super Double> userAction) {
        super.forEachRemaining(userAction);
    }

    public void forEachRemaining(DoubleConsumer action) {
        if (action == null)
            throw new NullPointerException();

        double[] storage = _getStorage();
        int length = storage.length;
        if (this.cursor >= length)
            return;

        while (this.cursor < length) {
            double item = storage[this.cursor++];
            action.accept(item);
        }
    }
}
