package generated.java.util.array;

import java.lang.NullPointerException;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import stub.java.util.array.DoubleArraySpliterator;

@Approximate(DoubleArraySpliterator.class)
public final class DoubleArraySpliteratorImpl extends AbstractArraySpliteratorImpl<Double> implements Spliterator.OfDouble {

    public double[] array;

    public DoubleArraySpliteratorImpl(double[] array, int index, int fence, int characteristics) {
        super(index, fence, characteristics);
        Engine.assume(array != null);
        this.array = array;
    }

    public DoubleArraySpliteratorImpl(double[] arr, int additionalCharacteristics) {
        this(arr, 0, arr.length, additionalCharacteristics);
    }

    protected DoubleArraySpliteratorImpl _create(int index, int fence) {
        return new DoubleArraySpliteratorImpl(this.array, index, fence, this.characteristics);
    }

    private double[] _getArray() {
        double[] array = this.array;
        Engine.assume(array != null);
        return array;
    }

    @SuppressWarnings("DataFlowIssue")
    protected Double _getItem(int index) {
        Engine.assume(array != null);
        return array[index];
    }

    public int characteristics() {
        return super.characteristics();
    }

    public long estimateSize() {
        return super.estimateSize();
    }

    public void forEachRemaining(DoubleConsumer action) {
        if (action == null)
            throw new NullPointerException();

        double[] array = _getArray();
        int current = this.index;
        this.index = this.fence;
        for (int i = current; i < this.fence; i++) {
            double item = array[current];
            action.accept(item);
        }
    }

    public void forEachRemaining(Consumer<? super Double> action) {
        super.forEachRemaining(action);
    }

    public Comparator<? super Double> getComparator() {
        return super.getComparator();
    }

    public long getExactSizeIfKnown() {
        return super.getExactSizeIfKnown();
    }

    public boolean hasCharacteristics(int characteristics) {
        return super.hasCharacteristics(characteristics);
    }

    public boolean tryAdvance(DoubleConsumer action) {
        if (action == null)
            throw new NullPointerException();

        int current = this.index;
        if (current < this.fence) {
            this.index = current + 1;
            double item = _getArray()[current];
            action.accept(item);
            return true;
        }

        return false;
    }

    public boolean tryAdvance(Consumer<? super Double> action) {
        return super.tryAdvance(action);
    }

    public DoubleArraySpliteratorImpl trySplit() {
        return (DoubleArraySpliteratorImpl) super.trySplit();
    }
}
