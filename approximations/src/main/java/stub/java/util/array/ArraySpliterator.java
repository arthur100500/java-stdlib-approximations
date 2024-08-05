package stub.java.util.array;

import java.lang.LinkageError;
import java.lang.Object;
import java.lang.SuppressWarnings;
import java.util.Comparator;
import java.util.function.Consumer;

public final class ArraySpliterator<E> extends AbstractArraySpliterator<E> {

    @SuppressWarnings("unused")
    public ArraySpliterator(E[] array, int index, int fence, int characteristics) {
        super(index, fence, characteristics);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public ArraySpliterator(E[] arr, int additionalCharacteristics) {
        this(arr, 0, -1, additionalCharacteristics);
        throw new LinkageError();
    }

    @SuppressWarnings({"ProtectedMemberInFinalClass", "unused"})
    protected ArraySpliterator<E> _create(int index, int fence) {
        throw new LinkageError();
    }

    protected E _getItem(int index) {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public int characteristics() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public long estimateSize() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void forEachRemaining(Consumer<? super E> action) {
        throw new LinkageError();
    }

    public Comparator<Object> getComparator() {
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

    @SuppressWarnings("RedundantMethodOverride")
    public boolean tryAdvance(Consumer<? super E> action) {
        throw new LinkageError();
    }

    public ArraySpliterator<E> trySplit() {
        throw new LinkageError();
    }
}
