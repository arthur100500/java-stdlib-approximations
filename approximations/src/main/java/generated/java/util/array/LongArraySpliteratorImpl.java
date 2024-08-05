package generated.java.util.array;

import java.lang.NullPointerException;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import stub.java.util.array.LongArraySpliterator;

@Approximate(LongArraySpliterator.class)
public final class LongArraySpliteratorImpl extends AbstractArraySpliteratorImpl<Long> implements Spliterator.OfLong {

    public long[] array;

    public LongArraySpliteratorImpl(long[] array, int index, int fence, int characteristics) {
        super(index, fence, characteristics);
        Engine.assume(array != null);
        this.array = array;
    }

    public LongArraySpliteratorImpl(long[] arr, int additionalCharacteristics) {
        this(arr, 0, arr.length, additionalCharacteristics);
    }

    protected LongArraySpliteratorImpl _create(int index, int fence) {
        return new LongArraySpliteratorImpl(this.array, index, fence, this.characteristics);
    }

    private long[] _getArray() {
        long[] array = this.array;
        Engine.assume(array != null);
        return array;
    }

    @SuppressWarnings("DataFlowIssue")
    protected Long _getItem(int index) {
        Engine.assume(array != null);
        return array[index];
    }

    public int characteristics() {
        return super.characteristics();
    }

    public long estimateSize() {
        return super.estimateSize();
    }

    public void forEachRemaining(Consumer<? super Long> action) {
        super.forEachRemaining(action);
    }

    public void forEachRemaining(LongConsumer action) {
        if (action == null)
            throw new NullPointerException();

        long[] array = _getArray();
        int current = this.index;
        this.index = this.fence;
        for (int i = current; i < this.fence; i++) {
            long item = array[i];
            action.accept(item);
        }
    }

    public Comparator<? super Long> getComparator() {
        return super.getComparator();
    }

    public long getExactSizeIfKnown() {
        return super.getExactSizeIfKnown();
    }

    public boolean hasCharacteristics(int characteristics) {
        return super.hasCharacteristics(characteristics);
    }

    public boolean tryAdvance(LongConsumer action) {
        if (action == null)
            throw new NullPointerException();

        int current = this.index;
        if (current < this.fence) {
            this.index = current + 1;
            long item = _getArray()[current];
            action.accept(item);
            return true;
        }

        return false;
    }

    public boolean tryAdvance(Consumer<? super Long> action) {
        return super.tryAdvance(action);
    }

    public LongArraySpliteratorImpl trySplit() {
        return (LongArraySpliteratorImpl) super.trySplit();
    }
}
