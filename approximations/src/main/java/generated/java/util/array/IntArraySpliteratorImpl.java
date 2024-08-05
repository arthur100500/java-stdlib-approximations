package generated.java.util.array;

import java.lang.NullPointerException;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import stub.java.util.array.IntArraySpliterator;

@Approximate(IntArraySpliterator.class)
public final class IntArraySpliteratorImpl extends AbstractArraySpliteratorImpl<Integer> implements Spliterator.OfInt {

    public int[] array;

    public IntArraySpliteratorImpl(int[] array, int index, int fence, int characteristics) {
        super(index, fence, characteristics);
        Engine.assume(array != null);
        this.array = array;
    }

    public IntArraySpliteratorImpl(int[] arr, int additionalCharacteristics) {
        this(arr, 0, arr.length, additionalCharacteristics);
    }

    protected IntArraySpliteratorImpl _create(int index, int fence) {
        return new IntArraySpliteratorImpl(this.array, index, fence, this.characteristics);
    }

    private int[] _getArray() {
        int[] array = this.array;
        Engine.assume(array != null);
        return array;
    }

    @SuppressWarnings("DataFlowIssue")
    protected Integer _getItem(int index) {
        Engine.assume(array != null);
        return array[index];
    }

    public int characteristics() {
        return super.characteristics();
    }

    public long estimateSize() {
        return super.estimateSize();
    }

    public void forEachRemaining(Consumer<? super Integer> action) {
        super.forEachRemaining(action);
    }

    public void forEachRemaining(IntConsumer action) {
        if (action == null)
            throw new NullPointerException();

        int[] array = _getArray();
        int current = this.index;
        this.index = this.fence;
        for (int i = current; i < this.fence; i++) {
            int item = array[i];
            action.accept(item);
        }
    }

    public Comparator<? super Integer> getComparator() {
        return super.getComparator();
    }

    public long getExactSizeIfKnown() {
        return super.getExactSizeIfKnown();
    }

    public boolean hasCharacteristics(int characteristics) {
        return super.hasCharacteristics(characteristics);
    }

    public boolean tryAdvance(IntConsumer action) {
        if (action == null)
            throw new NullPointerException();

        int current = this.index;
        if (current < this.fence) {
            this.index = current + 1;
            int item = _getArray()[current];
            action.accept(item);
            return true;
        }

        return false;
    }

    public boolean tryAdvance(Consumer<? super Integer> action) {
        return super.tryAdvance(action);
    }

    public IntArraySpliteratorImpl trySplit() {
        return (IntArraySpliteratorImpl) super.trySplit();
    }
}
