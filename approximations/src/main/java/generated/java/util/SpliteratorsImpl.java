package generated.java.util;

import generated.java.util.array.ArraySpliteratorImpl;
import generated.java.util.array.DoubleArraySpliteratorImpl;
import generated.java.util.array.IntArraySpliteratorImpl;
import generated.java.util.array.LongArraySpliteratorImpl;
import generated.runtime.LibSLGlobals;
import java.lang.Object;
import java.util.Spliterator;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

@SuppressWarnings("unused")
@Approximate(java.util.Spliterators.class)
public final class SpliteratorsImpl {

    static {
        Engine.assume(true);
    }

    private SpliteratorsImpl() { }

    public static final int _characteristics = LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_SUBSIZED;

    @SuppressWarnings("unchecked")
    public static <T> Spliterator<T> spliterator(Object[] arr, int additionalCharacteristics) {
        return new ArraySpliteratorImpl<>((T[]) arr, additionalCharacteristics);
    }

    @SuppressWarnings("unchecked")
    public static <T> Spliterator<T> spliterator(Object[] arr, int fromIndex, int toIndex, int additionalCharacteristics) {
        return new ArraySpliteratorImpl<>((T[]) arr, fromIndex, toIndex, additionalCharacteristics);
    }

    public static Spliterator.OfDouble spliterator(double[] arr, int additionalCharacteristics) {
        return new DoubleArraySpliteratorImpl(arr, additionalCharacteristics);
    }

    public static Spliterator.OfDouble spliterator(double[] arr, int fromIndex, int toIndex, int additionalCharacteristics) {
        return new DoubleArraySpliteratorImpl(arr, fromIndex, toIndex, additionalCharacteristics);
    }

    public static Spliterator.OfInt spliterator(int[] arr, int additionalCharacteristics) {
        return new IntArraySpliteratorImpl(arr, additionalCharacteristics);
    }

    public static Spliterator.OfInt spliterator(int[] arr, int fromIndex, int toIndex, int additionalCharacteristics) {
        return new IntArraySpliteratorImpl(arr, fromIndex, toIndex, additionalCharacteristics);
    }

    public static Spliterator.OfLong spliterator(long[] arr, int additionalCharacteristics) {
        return new LongArraySpliteratorImpl(arr, additionalCharacteristics);
    }

    public static Spliterator.OfLong spliterator(long[] arr, int fromIndex, int toIndex, int additionalCharacteristics) {
        return new LongArraySpliteratorImpl(arr, fromIndex, toIndex, additionalCharacteristics);
    }
}
