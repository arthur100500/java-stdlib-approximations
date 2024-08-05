package stub.java.util.array;

import java.lang.LinkageError;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

@SuppressWarnings("unused")
public final class DoubleArraySpliterator extends AbstractArraySpliterator<Double> implements Spliterator.OfDouble {

    public DoubleArraySpliterator(double[] array, int index, int fence, int characteristics) {
        super(index, fence, characteristics);
        throw new LinkageError();
    }

    public DoubleArraySpliterator(double[] arr, int additionalCharacteristics) {
        this(arr, 0, -1, additionalCharacteristics);
        throw new LinkageError();
    }

    @SuppressWarnings("ProtectedMemberInFinalClass")
    protected DoubleArraySpliterator _create(int index, int fence) {
        throw new LinkageError();
    }

    protected Double _getItem(int index) {
        throw new LinkageError();
    }

    public int characteristics() {
        throw new LinkageError();
    }

    public long estimateSize() {
        throw new LinkageError();
    }

    public void forEachRemaining(DoubleConsumer _action) {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void forEachRemaining(Consumer<? super Double> action) {
        throw new LinkageError();
    }

    public Comparator<? super Double> getComparator() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public long getExactSizeIfKnown() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public boolean hasCharacteristics(int _characteristics) {
        throw new LinkageError();
    }

    public boolean tryAdvance(DoubleConsumer _action) {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public boolean tryAdvance(Consumer<? super Double> action) {
        throw new LinkageError();
    }

    public DoubleArraySpliterator trySplit() {
        throw new LinkageError();
    }
}
