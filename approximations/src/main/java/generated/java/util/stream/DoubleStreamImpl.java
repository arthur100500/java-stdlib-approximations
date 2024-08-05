package generated.java.util.stream;

import generated.java.util.array.DoubleArrayIteratorImpl;
import generated.java.util.array.DoubleArraySpliteratorImpl;
import generated.runtime.LibSLGlobals;
import java.lang.Double;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.stream.*;
import generated.java.lang.DoubleImpl;

@Approximate(DoubleStreamStub.class)
public class DoubleStreamImpl extends BaseStreamImpl<Double> implements DoubleStream {

    private final double[] storage;

    public DoubleStreamImpl(
        double[] storage,
        SymbolicList<Runnable> closeHandlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        super(closeHandlers, isParallel, linkedOrConsumed);
        this.storage = storage;
    }

    public DoubleStreamImpl(double[] storage, SymbolicList<Runnable> closeHandlers, boolean isParallel) {
        this(storage, closeHandlers, isParallel, false);
    }

    public DoubleStreamImpl(double[] storage, SymbolicList<Runnable> closeHandlers) {
        this(storage, closeHandlers, false);
    }

    public DoubleStreamImpl(double[] storage) {
        this(storage, Engine.makeSymbolicList());
    }

    private double[] _getStorage() {
        double[] storage = this.storage;
        Engine.assume(storage != null);
        return storage;
    }

    protected int _getLength() {
        return _getStorage().length;
    }

    private DoubleStreamImpl _copy(double[] storage) {
        return new DoubleStreamImpl(storage, _getCloseHandlers(), isParallel, linkedOrConsumed);
    }

    private DoubleStreamImpl _copy() {
        return _copy(_getStorage());
    }

    private void _actionApply(DoubleConsumer _action) {
        if (_action == null)
            throw new NullPointerException();

        double[] storage = _getStorage();
        for (double v : storage) {
            _action.accept(v);
        }
    }

    private OptionalDouble _findFirst() {
        double[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalDouble.empty();

        double first = storage[0];
        return OptionalDouble.of(first);
    }

    private double _sum() {
        double[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return 0;

        double result = 0;
        boolean anyNaN = false;
        boolean anyPositiveInfinity = false;
        boolean anyNegativeInfinity = false;
        for (double element : storage) {
            result += element;
            if (element != element)
                anyNaN = true;
            if (element == DoubleImpl.POSITIVE_INFINITY)
                anyPositiveInfinity = true;
            if (element == DoubleImpl.NEGATIVE_INFINITY)
                anyNegativeInfinity = true;
        }

        if (anyNaN)
            return DoubleImpl.NaN;

        if (anyPositiveInfinity && anyNegativeInfinity)
            return DoubleImpl.NaN;

        if (anyPositiveInfinity && (result == DoubleImpl.NEGATIVE_INFINITY))
            return DoubleImpl.NaN;

        if (anyNegativeInfinity && (result == DoubleImpl.POSITIVE_INFINITY))
            return DoubleImpl.NaN;

        return result;
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public DoubleStreamImpl filter(@NotNull DoublePredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        double[] storage = _getStorage();
        int length = storage.length;
        double[] filteredStorage = Arrays.copyOf(storage, length);
        int filteredLength = 0;
        for (double e : storage) {
            if (predicate.test(e)) {
                filteredStorage[filteredLength] = e;
                filteredLength++;
            }
        }

        Engine.assume(filteredLength <= length);
        double[] resultStorage = Arrays.copyOf(filteredStorage, filteredLength);
        return _copy(resultStorage);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public DoubleStreamImpl map(@NotNull DoubleUnaryOperator mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        double[] storage = _getStorage();
        int length = storage.length;
        double[] mappedStorage = new double[length];
        for (int i = 0; i < length; i++) {
            mappedStorage[i] = mapper.applyAsDouble(storage[i]);
        }

        return _copy(mappedStorage);
    }

    @NotNull
    @SuppressWarnings({"unchecked", "ConstantValue"})
    public <T> StreamStubImpl<T> mapToObj(@NotNull DoubleFunction<? extends T> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        double[] storage = _getStorage();
        int length = storage.length;
        T[] objStorage = (T[]) new Object[length];
        for (int i = 0; i < length; i++) {
            objStorage[i] = mapper.apply(storage[i]);
        }

        return _copyToObjStream(objStorage);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public LongStreamImpl mapToLong(@NotNull DoubleToLongFunction mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        double[] storage = _getStorage();
        int length = storage.length;
        long[] mappedStorage = new long[length];
        for (int i = 0; i < length; i++) {
            mappedStorage[i] = mapper.applyAsLong(storage[i]);
        }

        return _copyToLongStream(mappedStorage);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public IntStreamImpl mapToInt(@NotNull DoubleToIntFunction mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        double[] storage = _getStorage();
        int length = storage.length;
        int[] mappedStorage = new int[length];
        for (int i = 0; i < length; i++) {
            mappedStorage[i] = mapper.applyAsInt(storage[i]);
        }

        return _copyToIntStream(mappedStorage);
    }

    @SuppressWarnings("ConstantValue")
    public DoubleStream flatMap(@NotNull DoubleFunction<? extends DoubleStream> mapper) {
        // TODO: approximate
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        DoubleStream result = Engine.makeSymbolic(DoubleStream.class);
        Engine.assume(result != null);
        return result;
    }

    @NotNull
    public DoubleStreamImpl sorted() {
        super.evaluate();

        double[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return _copy();

        int outerLimit = length - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = length - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                double a = storage[j];
                double b = storage[idxB];
                if (a > b) {
                    storage[j] = b;
                    storage[idxB] = a;
                }
            }
        }

        return _copy();
    }

    @NotNull
    public DoubleStreamImpl distinct() {
        super.evaluate();

        double[] storage = _getStorage();
        double[] distinctStorage;
        int length = storage.length;
        if (length == 0) {
            distinctStorage = Arrays.copyOf(storage, 0);
            return _copy(distinctStorage);
        }

        int distinctLength = 0;
        distinctStorage = Arrays.copyOf(storage, length);
        LibSLRuntime.Map<Double, Object> visited = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        for (double item : storage) {
            if (!visited.hasKey(item)) {
                visited.set(item, LibSLGlobals.SOMETHING);
                distinctStorage[distinctLength] = item;
                distinctLength++;
            }
        }

        Engine.assume(distinctLength <= length);
        double[] resultStorage = Arrays.copyOf(distinctStorage, distinctLength);
        return _copy(resultStorage);
    }

    @NotNull
    public DoubleStreamImpl peek(@NotNull DoubleConsumer _action) {
        super.evaluate();
        _actionApply(_action);
        return _copy();
    }

    @NotNull
    public DoubleStreamImpl limit(long maxSize) {
        super.evaluate();

        int maxSizeInt = (int) maxSize;

        if (maxSizeInt < 0)
            throw new IllegalArgumentException();

        if (maxSizeInt == 0)
            return _copy(Arrays.copyOf(_getStorage(), 0));

        double[] storage = _getStorage();
        int length = storage.length;
        if (maxSizeInt > length)
            return _copy();

        double[] limitStorage = Arrays.copyOf(storage, maxSizeInt);
        return _copy(limitStorage);
    }

    @NotNull
    public DoubleStreamImpl skip(long n) {
        super.evaluate();

        int offset = (int) n;

        if (offset < 0)
            throw new IllegalArgumentException();

        if (offset == 0)
            return _copy();

        double[] storage = _getStorage();
        int length = storage.length;
        if (offset >= length)
            return _copy(Arrays.copyOf(_getStorage(), 0));

        double[] skipStorage = Arrays.copyOfRange(storage, offset, length);
        return _copy(skipStorage);
    }

    public void forEach(DoubleConsumer _action) {
        super.evaluate();
        _actionApply(_action);
    }

    public void forEachOrdered(DoubleConsumer _action) {
        forEach(_action);
    }

    public double[] toArray() {
        super.evaluate();
        return _getStorage();
    }

    public double reduce(double identity, DoubleBinaryOperator accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        double result = identity;
        double[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return result;

        for (double item : storage) {
            result = accumulator.applyAsDouble(result, item);
        }

        return result;
    }

    public OptionalDouble reduce(DoubleBinaryOperator accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        double[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalDouble.empty();

        double value = storage[0];
        for (int i = 1; i < length; i++) {
            value = accumulator.applyAsDouble(value, storage[i]);
        }

        return OptionalDouble.of(value);
    }

    public <R> R collect(Supplier<R> supplier, ObjDoubleConsumer<R> accumulator, BiConsumer<R, R> combiner) {
        super.evaluate();

        if (supplier == null)
            throw new NullPointerException();

        if (accumulator == null)
            throw new NullPointerException();

        if (combiner == null)
            throw new NullPointerException();

        R result = supplier.get();
        double[] storage = _getStorage();
        for (double item : storage) {
            accumulator.accept(result, item);
        }

        return result;
    }

    public OptionalDouble min() {
        super.evaluate();

        double[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalDouble.empty();

        double min = storage[0];
        for (int i = 1; i < length; i++) {
            double item = storage[i];
            if (min > item)
                min = item;
        }

        return OptionalDouble.of(min);
    }

    public OptionalDouble max() {
        super.evaluate();

        double[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalDouble.empty();

        double max = storage[0];
        for (int i = 1; i < length; i++) {
            double item = storage[i];
            if (max < item)
                max = item;
        }

        return OptionalDouble.of(max);
    }

    public long count() {
        return super.count();
    }

    public boolean anyMatch(DoublePredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        double[] storage = _getStorage();
        for (double item : storage) {
            if (predicate.test(item))
                return true;
        }

        return false;
    }

    public boolean allMatch(DoublePredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        double[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return true;

        for (double item : storage) {
            if (!predicate.test(item))
                return false;
        }

        return true;
    }

    public boolean noneMatch(DoublePredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        double[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return true;

        for (double item : storage) {
            if (predicate.test(item))
                return false;
        }

        return true;
    }

    public OptionalDouble findFirst() {
        super.evaluate();
        return _findFirst();
    }

    public OptionalDouble findAny() {
        return findFirst();
    }

    @NotNull
    public PrimitiveIterator.OfDouble iterator() {
        super.evaluate();
        return new DoubleArrayIteratorImpl(_getStorage());
    }

    @NotNull
    public Spliterator.OfDouble spliterator() {
        super.evaluate();
        double[] storage = _getStorage();
        return new DoubleArraySpliteratorImpl(storage, spliteratorCharacteristics);
    }

    public boolean isParallel() {
        return super.isParallel();
    }

    @NotNull
    public DoubleStreamImpl sequential() {
        return (DoubleStreamImpl) super.sequential();
    }

    @NotNull
    public DoubleStreamImpl parallel() {
        return (DoubleStreamImpl) super.parallel();
    }

    @NotNull
    public DoubleStreamImpl unordered() {
        super.evaluate();
        return _copy();
    }

    @NotNull
    public DoubleStreamImpl onClose(@NotNull Runnable closeHandler) {
        return (DoubleStreamImpl) super.onClose(closeHandler);
    }

    public void close() {
        super.close();
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public DoubleStreamImpl dropWhile(@NotNull DoublePredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        double[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return _copy(Arrays.copyOf(storage, 0));

        int dropLength = 0;
        while (dropLength < length && predicate.test(storage[dropLength])) {
            dropLength++;
        }

        if (dropLength == 0)
            return _copy();

        int newLength = length - dropLength;
        double[] newStorage = Arrays.copyOf(storage, newLength);
        return _copy(newStorage);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public DoubleStreamImpl takeWhile(@NotNull DoublePredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        double[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return _copy(Arrays.copyOf(storage, 0));

        int takeLength = 0;
        while (takeLength < length && predicate.test(storage[takeLength])) {
            takeLength++;
        }

        if (takeLength == length)
            return _copy();

        double[] newStorage = Arrays.copyOf(storage, takeLength);
        return _copy(newStorage);
    }

    public double sum() {
        super.evaluate();
        return _sum();
    }

    public OptionalDouble average() {
        super.evaluate();

        double[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalDouble.empty();

        double curSum = _sum();
        double divisionResult = curSum / length;
        return OptionalDouble.of(divisionResult);
    }

    public DoubleSummaryStatistics summaryStatistics() {
        super.evaluate();

        double[] storage = _getStorage();
        DoubleSummaryStatistics result = new DoubleSummaryStatistics();
        for (double v : storage) {
            result.accept(v);
        }

        return result;
    }

    public Stream<Double> boxed() {
        super.evaluate();

        double[] storage = _getStorage();
        int length = storage.length;
        Double[] doubleArray = new Double[length];
        for (int i = 0; i < length; i++) {
            doubleArray[i] = storage[i];
        }

        return _copyToObjStream(doubleArray);
    }
}
