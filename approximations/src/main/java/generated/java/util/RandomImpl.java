package generated.java.util;

import generated.java.util.stream.DoubleStreamImpl;
import generated.java.util.stream.IntStreamImpl;
import generated.java.util.stream.LongStreamImpl;
import generated.runtime.LibSLGlobals;

import java.io.*;
import java.lang.IllegalArgumentException;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.util.Random.class)
public class RandomImpl implements Serializable {

    @Serial
    private static final long serialVersionUID = 3905348978240129619L;

    @Serial
    private static final ObjectStreamField[] serialPersistentFields = {};

    static {
        Engine.assume(true);
    }

    public RandomImpl() {
        Engine.assume(true);
    }

    public RandomImpl(long seed) {
        Engine.assume(true);
    }

    private int[] _generateRandomIntegerArrayWithBounds(int size, int randomNumberOrigin, int randomNumberBound) {
        int[] result = Engine.makeSymbolicIntArray(size);
        for (int i = 0; i < size; i++) {
            int item = result[i];
            Engine.assume(item >= randomNumberOrigin);
            Engine.assume(item < randomNumberBound);
        }
        return result;
    }

    private long[] _generateRandomLongArrayWithBounds(int size, long randomNumberOrigin, long randomNumberBound) {
        long[] result = Engine.makeSymbolicLongArray(size);
        for (int i = 0; i < size; i++) {
            long item = result[i];
            Engine.assume(item >= randomNumberOrigin);
            Engine.assume(item < randomNumberBound);
        }
        return result;
    }

    private double[] _generateRandomDoubleArrayWithBounds(int size, double randomNumberOrigin, double randomNumberBound) {
        double[] result = Engine.makeSymbolicDoubleArray(size);
        for (int i = 0; i < size; i++) {
            double item = result[i];
            Engine.assume(item >= randomNumberOrigin);
            Engine.assume(item < randomNumberBound);
        }
        return result;
    }

    public DoubleStream doubles() {
        double[] items = _generateRandomDoubleArrayWithBounds(LibSLGlobals.RANDOM_STREAM_SIZE_MAX, 0, 1);
        return new DoubleStreamImpl(items);
    }

    public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        if (randomNumberOrigin >= randomNumberBound)
            throw new IllegalArgumentException();

        double[] items = _generateRandomDoubleArrayWithBounds(LibSLGlobals.RANDOM_STREAM_SIZE_MAX, randomNumberOrigin, randomNumberBound);
        return new DoubleStreamImpl(items);
    }

    public DoubleStream doubles(long streamSize) {
        int size = (int) streamSize;
        if (size < 0)
            throw new IllegalArgumentException();

        if (size > LibSLGlobals.RANDOM_STREAM_SIZE_MAX)
            size = LibSLGlobals.RANDOM_STREAM_SIZE_MAX;
        return new DoubleStreamImpl(Engine.makeSymbolicDoubleArray(size));
    }

    public DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        int size = (int) streamSize;
        if (size < 0)
            throw new IllegalArgumentException();

        if (randomNumberOrigin >= randomNumberBound)
            throw new IllegalArgumentException();

        if (size > LibSLGlobals.RANDOM_STREAM_SIZE_MAX)
            size = LibSLGlobals.RANDOM_STREAM_SIZE_MAX;

        double[] items = _generateRandomDoubleArrayWithBounds(size, randomNumberOrigin, randomNumberBound);
        return new DoubleStreamImpl(items);
    }

    public IntStream ints() {
        int[] items = Engine.makeSymbolicIntArray(LibSLGlobals.RANDOM_STREAM_SIZE_MAX);
        return new IntStreamImpl(items);
    }

    public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        if (randomNumberOrigin >= randomNumberBound)
            throw new IllegalArgumentException();

        int[] items = _generateRandomIntegerArrayWithBounds(LibSLGlobals.RANDOM_STREAM_SIZE_MAX, randomNumberOrigin, randomNumberBound);
        return new IntStreamImpl(items);
    }

    public IntStream ints(long streamSize) {
        int size = (int) streamSize;
        if (size < 0)
            throw new IllegalArgumentException();

        if (size > LibSLGlobals.RANDOM_STREAM_SIZE_MAX)
            size = LibSLGlobals.RANDOM_STREAM_SIZE_MAX;

        int[] items = Engine.makeSymbolicIntArray(size);
        return new IntStreamImpl(items);
    }

    public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        int size = ((int) streamSize);
        if (size < 0)
            throw new IllegalArgumentException();

        if (randomNumberOrigin >= randomNumberBound)
            throw new IllegalArgumentException();

        if (size > LibSLGlobals.RANDOM_STREAM_SIZE_MAX)
            size = LibSLGlobals.RANDOM_STREAM_SIZE_MAX;

        int[] items = _generateRandomIntegerArrayWithBounds(size, randomNumberOrigin, randomNumberBound);
        return new IntStreamImpl(items);
    }

    public LongStream longs() {
        long[] items = Engine.makeSymbolicLongArray(LibSLGlobals.RANDOM_STREAM_SIZE_MAX);
        return new LongStreamImpl(items);
    }

    public LongStream longs(long streamSize) {
        int size = (int) streamSize;
        if (size < 0)
            throw new IllegalArgumentException();

        if (size > LibSLGlobals.RANDOM_STREAM_SIZE_MAX)
            size = LibSLGlobals.RANDOM_STREAM_SIZE_MAX;

        return new LongStreamImpl(Engine.makeSymbolicLongArray(size));
    }

    public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        if (randomNumberOrigin >= randomNumberBound)
            throw new IllegalArgumentException();

        long[] items = _generateRandomLongArrayWithBounds(LibSLGlobals.RANDOM_STREAM_SIZE_MAX, randomNumberOrigin, randomNumberBound);
        return new LongStreamImpl(items);
    }

    public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        int size = (int) streamSize;
        if (size < 0)
            throw new IllegalArgumentException();

        if (randomNumberOrigin >= randomNumberBound)
            throw new IllegalArgumentException();

        if (size > LibSLGlobals.RANDOM_STREAM_SIZE_MAX)
            size = LibSLGlobals.RANDOM_STREAM_SIZE_MAX;

        return new LongStreamImpl(_generateRandomLongArrayWithBounds(size, randomNumberOrigin, randomNumberBound));
    }

    public boolean nextBoolean() {
        return Engine.makeSymbolicBoolean();
    }

    public void nextBytes(byte[] bytes) {
        int numBytes = bytes.length;
        byte[] symbolicArray = Engine.makeSymbolicByteArray(numBytes);
        LibSLRuntime.ArrayActions.copy(symbolicArray, 0, bytes, 0, numBytes);
    }

    public double nextDouble() {
        double result = Engine.makeSymbolicDouble();
        Engine.assume(0.0d <= result);
        Engine.assume(result < 1.0d);
        return result;
    }

    public float nextFloat() {
        float result = Engine.makeSymbolicFloat();
        Engine.assume(0.0f <= result);
        Engine.assume(result < 1.0f);
        return result;
    }

    public synchronized double nextGaussian() {
        double result = Engine.makeSymbolicDouble();
        boolean isNaN = result != result;
        Engine.assume(!isNaN);
        return result;
    }

    public int nextInt() {
        return Engine.makeSymbolicInt();
    }

    public int nextInt(int bound) {
        if (bound <= 0)
            throw new IllegalArgumentException("bound must be positive");

        int result = Engine.makeSymbolicInt();
        Engine.assume(0 <= result);
        Engine.assume(result < bound);
        return result;
    }

    public long nextLong() {
        return Engine.makeSymbolicLong();
    }

    public synchronized void setSeed(long seed) {
        Engine.assume(true);
    }
}
