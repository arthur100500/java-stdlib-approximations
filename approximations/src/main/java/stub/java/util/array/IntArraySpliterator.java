package stub.java.util.array;

import generated.java.util.array.IntArraySpliteratorImpl;

import java.lang.LinkageError;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class IntArraySpliterator extends AbstractArraySpliterator<Integer> implements Spliterator.OfInt {

    @SuppressWarnings("unused")
    public IntArraySpliterator(int[] array, int index, int fence, int characteristics) {
        super(index, fence, characteristics);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public IntArraySpliterator(int[] arr, int additionalCharacteristics) {
        this(arr, 0, arr.length, additionalCharacteristics);
        throw new LinkageError();
    }

    @SuppressWarnings({"ProtectedMemberInFinalClass", "unused"})
    protected IntArraySpliteratorImpl _create(int index, int fence) {
        throw new LinkageError();
    }

    protected Integer _getItem(int index) {
        throw new LinkageError();
    }

    public int characteristics() {
        throw new LinkageError();
    }

    public long estimateSize() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void forEachRemaining(Consumer<? super Integer> action) {
        throw new LinkageError();
    }

    public void forEachRemaining(IntConsumer action) {
        throw new LinkageError();
    }

    public Comparator<? super Integer> getComparator() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public long getExactSizeIfKnown() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public boolean hasCharacteristics(int characteristics) {
        throw new LinkageError();
    }

    public boolean tryAdvance(IntConsumer action) {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public boolean tryAdvance(Consumer<? super Integer> action) {
        throw new LinkageError();
    }

    public IntArraySpliterator trySplit() {
        throw new LinkageError();
    }
}
