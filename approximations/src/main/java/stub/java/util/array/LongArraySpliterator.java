package stub.java.util.array;

import java.lang.LinkageError;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class LongArraySpliterator extends AbstractArraySpliterator<Long> implements Spliterator.OfLong {

    @SuppressWarnings("unused")
    public LongArraySpliterator(long[] array, int index, int fence, int characteristics) {
        super(index, fence, characteristics);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public LongArraySpliterator(long[] arr, int additionalCharacteristics) {
        this(arr, 0, arr.length, additionalCharacteristics);
        throw new LinkageError();
    }

    @SuppressWarnings({"unused", "ProtectedMemberInFinalClass"})
    protected LongArraySpliterator _create(int index, int fence) {
        throw new LinkageError();
    }

    protected Long _getItem(int index) {
        throw new LinkageError();
    }

    public int characteristics() {
        throw new LinkageError();
    }

    public long estimateSize() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void forEachRemaining(Consumer<? super Long> action) {
        throw new LinkageError();
    }

    public void forEachRemaining(LongConsumer action) {
        throw new LinkageError();
    }

    public Comparator<? super Long> getComparator() {
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

    public boolean tryAdvance(LongConsumer action) {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public boolean tryAdvance(Consumer<? super Long> action) {
        throw new LinkageError();
    }

    public LongArraySpliterator trySplit() {
        throw new LinkageError();
    }
}
