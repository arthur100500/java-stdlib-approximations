package generated.java.util.array;

import java.util.Comparator;
import java.util.function.Consumer;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import stub.java.util.array.ArraySpliterator;

@Approximate(ArraySpliterator.class)
public final class ArraySpliteratorImpl<E> extends AbstractArraySpliteratorImpl<E> {

    public E[] array;

    public ArraySpliteratorImpl(E[] array, int index, int fence, int characteristics) {
        super(index, fence, characteristics);
        Engine.assume(array != null);
        this.array = array;
    }

    @SuppressWarnings("unused")
    public ArraySpliteratorImpl(E[] arr, int additionalCharacteristics) {
        this(arr, 0, arr.length, additionalCharacteristics);
    }

    protected ArraySpliteratorImpl<E> _create(int index, int fence) {
        return new ArraySpliteratorImpl<>(this.array, index, fence, this.characteristics);
    }

    @SuppressWarnings("DataFlowIssue")
    protected E _getItem(int index) {
        Engine.assume(array != null);
        return array[index];
    }

    public int characteristics() {
        return super.characteristics();
    }

    public long estimateSize() {
        return super.estimateSize();
    }

    public void forEachRemaining(Consumer<? super E> action) {
        super.forEachRemaining(action);
    }

    public Comparator<? super E> getComparator() {
        return super.getComparator();
    }

    public long getExactSizeIfKnown() {
        return super.getExactSizeIfKnown();
    }

    public boolean hasCharacteristics(int characteristics) {
        return super.hasCharacteristics(characteristics);
    }

    public boolean tryAdvance(Consumer<? super E> action) {
        return super.tryAdvance(action);
    }

    public ArraySpliteratorImpl<E> trySplit() {
        return (ArraySpliteratorImpl<E>) super.trySplit();
    }
}
