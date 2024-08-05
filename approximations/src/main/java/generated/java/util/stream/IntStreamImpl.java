package generated.java.util.stream;

import generated.java.util.array.IntArrayIteratorImpl;
import generated.java.util.array.IntArraySpliteratorImpl;
import generated.runtime.LibSLGlobals;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.stream.*;

@Approximate(IntStreamStub.class)
public class IntStreamImpl extends BaseStreamImpl<Integer> implements IntStream {

    public int[] storage;

    public IntStreamImpl(
        int[] storage,
        SymbolicList<Runnable> closeHandlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        super(closeHandlers, isParallel, linkedOrConsumed);
        this.storage = storage;
    }

    public IntStreamImpl(int[] storage, SymbolicList<Runnable> closeHandlers, boolean isParallel) {
        this(storage, closeHandlers, isParallel, false);
    }

    public IntStreamImpl(int[] storage, SymbolicList<Runnable> closeHandlers) {
        this(storage, closeHandlers, false);
    }

    public IntStreamImpl(int[] storage) {
        this(storage, Engine.makeSymbolicList());
    }

    private int[] _getStorage() {
        int[] storage = this.storage;
        Engine.assume(storage != null);
        return storage;
    }

    protected int _getLength() {
        return _getStorage().length;
    }

    private IntStreamImpl _copy(int[] storage) {
        return new IntStreamImpl(storage, _getCloseHandlers(), isParallel, linkedOrConsumed);
    }

    private IntStreamImpl _copy() {
        return _copy(_getStorage());
    }

    private void _actionApply(IntConsumer _action) {
        if (_action == null)
            throw new NullPointerException();

        int[] storage = _getStorage();
        for (int j : storage) {
            _action.accept(j);
        }
    }

    private OptionalInt _findFirst() {
        int[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalInt.empty();

        int first = storage[0];
        return OptionalInt.of(first);
    }

    private int _sum() {
        int[] storage = _getStorage();
        int result = 0;
        for (int j : storage) {
            result += j;
        }
        return result;
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public IntStreamImpl filter(@NotNull IntPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        int[] storage = _getStorage();
        int length = storage.length;
        int[] filteredStorage = Arrays.copyOf(storage, length);
        int filteredLength = 0;
        for (int e : storage) {
            if (predicate.test(e)) {
                filteredStorage[filteredLength] = e;
                filteredLength++;
            }
        }

        Engine.assume(filteredLength <= length);
        int[] resultStorage = Arrays.copyOf(filteredStorage, filteredLength);
        return _copy(resultStorage);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public IntStreamImpl map(@NotNull IntUnaryOperator mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        int[] storage = _getStorage();
        int length = storage.length;
        int[] mappedStorage = new int[length];
        for (int i = 0; i < length; i++) {
            mappedStorage[i] = mapper.applyAsInt(storage[i]);
        }

        return _copy(mappedStorage);
    }

    @NotNull
    @SuppressWarnings({"unchecked", "ConstantValue"})
    public <T> StreamStubImpl<T> mapToObj(@NotNull IntFunction<? extends T> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        int[] storage = _getStorage();
        int length = storage.length;
        T[] objStorage = (T[]) new Object[length];
        for (int i = 0; i < length; i++) {
            objStorage[i] = mapper.apply(storage[i]);
        }

        return _copyToObjStream(objStorage);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public LongStreamImpl mapToLong(@NotNull IntToLongFunction mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        int[] storage = _getStorage();
        int length = storage.length;
        long[] mappedStorage = new long[length];
        for (int i = 0; i < length; i++) {
            mappedStorage[i] = mapper.applyAsLong(storage[i]);
        }

        return _copyToLongStream(mappedStorage);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public DoubleStreamImpl mapToDouble(@NotNull IntToDoubleFunction mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        int[] storage = _getStorage();
        int length = storage.length;
        double[] mappedStorage = new double[length];
        for (int i = 0; i < length; i++) {
            mappedStorage[i] = mapper.applyAsDouble(storage[i]);
        }

        return _copyToDoubleStream(mappedStorage);
    }

    @NotNull
    @SuppressWarnings({"ConstantValue", "DataFlowIssue"})
    public IntStream flatMap(@NotNull IntFunction<? extends IntStream> mapper) {
        // TODO: approximate
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        IntStream result = Engine.makeSymbolic(IntStream.class);
        Engine.assume(result != null);
        return result;
    }

    @NotNull
    public IntStreamImpl sorted() {
        super.evaluate();

        int[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return _copy();

        int outerLimit = length - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = length - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                int a = storage[j];
                int b = storage[idxB];
                if (a > b) {
                    storage[j] = b;
                    storage[idxB] = a;
                }
            }
        }

        return _copy();
    }

    @NotNull
    public IntStreamImpl distinct() {
        super.evaluate();

        int[] storage = _getStorage();
        int[] distinctStorage;
        int length = storage.length;
        if (length == 0) {
            distinctStorage = Arrays.copyOf(storage, 0);
            return _copy(distinctStorage);
        }

        int distinctLength = 0;
        distinctStorage = Arrays.copyOf(storage, length);
        LibSLRuntime.Map<Integer, Object> visited = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        for (int item : storage) {
            if (!visited.hasKey(item)) {
                visited.set(item, LibSLGlobals.SOMETHING);
                distinctStorage[distinctLength] = item;
                distinctLength++;
            }
        }

        Engine.assume(distinctLength <= length);
        int[] resultStorage = Arrays.copyOf(distinctStorage, distinctLength);
        return _copy(resultStorage);
    }

    @NotNull
    public IntStreamImpl peek(@NotNull IntConsumer _action) {
        super.evaluate();
        _actionApply(_action);
        return _copy();
    }

    @NotNull
    public IntStreamImpl limit(long maxSize) {
        super.evaluate();

        int maxSizeInt = (int) maxSize;

        if (maxSizeInt < 0)
            throw new IllegalArgumentException();

        if (maxSizeInt == 0)
            return _copy(Arrays.copyOf(_getStorage(), 0));

        int[] storage = _getStorage();
        int length = storage.length;
        if (maxSizeInt > length)
            return _copy();

        int[] limitStorage = Arrays.copyOf(storage, maxSizeInt);
        return _copy(limitStorage);
    }

    @NotNull
    public IntStreamImpl skip(long n) {
        super.evaluate();

        int offset = (int) n;

        if (offset < 0)
            throw new IllegalArgumentException();

        if (offset == 0)
            return _copy();

        int[] storage = _getStorage();
        int length = storage.length;
        if (offset >= length)
            return _copy(Arrays.copyOf(_getStorage(), 0));

        int[] skipStorage = Arrays.copyOfRange(storage, offset, length);
        return _copy(skipStorage);
    }

    public void forEach(IntConsumer _action) {
        super.evaluate();
        _actionApply(_action);
    }

    public void forEachOrdered(IntConsumer _action) {
        forEach(_action);
    }

    public int[] toArray() {
        super.evaluate();
        return _getStorage();
    }

    public int reduce(int identity, IntBinaryOperator accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        int result = identity;
        int[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return result;

        for (int item : storage) {
            result = accumulator.applyAsInt(result, item);
        }

        return result;
    }

    public OptionalInt reduce(IntBinaryOperator accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        int[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalInt.empty();

        int value = storage[0];
        for (int i = 1; i < length; i++) {
            value = accumulator.applyAsInt(value, storage[i]);
        }

        return OptionalInt.of(value);
    }

    public <R> R collect(Supplier<R> supplier, ObjIntConsumer<R> accumulator, BiConsumer<R, R> combiner) {
        super.evaluate();

        if (supplier == null)
            throw new NullPointerException();

        if (accumulator == null)
            throw new NullPointerException();

        if (combiner == null)
            throw new NullPointerException();

        R result = supplier.get();
        int[] storage = _getStorage();
        for (int item : storage) {
            accumulator.accept(result, item);
        }

        return result;
    }

    public OptionalInt min() {
        super.evaluate();

        int[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalInt.empty();

        int min = storage[0];
        for (int i = 1; i < length; i++) {
            int item = storage[i];
            if (min > item)
                min = item;
        }

        return OptionalInt.of(min);
    }

    public OptionalInt max() {
        super.evaluate();

        int[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalInt.empty();

        int max = storage[0];
        for (int i = 1; i < length; i++) {
            int item = storage[i];
            if (max < item)
                max = item;
        }

        return OptionalInt.of(max);
    }

    public long count() {
        return super.count();
    }

    public boolean anyMatch(IntPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        int[] storage = _getStorage();
        for (int item : storage) {
            if (predicate.test(item))
                return true;
        }

        return false;
    }

    public boolean allMatch(IntPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        int[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return true;

        for (int item : storage) {
            if (!predicate.test(item))
                return false;
        }

        return true;
    }

    public boolean noneMatch(IntPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        int[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return true;

        for (int item : storage) {
            if (predicate.test(item))
                return false;
        }

        return true;
    }

    public OptionalInt findFirst() {
        super.evaluate();
        return _findFirst();
    }

    public OptionalInt findAny() {
        return findFirst();
    }

    @NotNull
    public PrimitiveIterator.OfInt iterator() {
        super.evaluate();
        return new IntArrayIteratorImpl(_getStorage());
    }

    @NotNull
    public Spliterator.OfInt spliterator() {
        super.evaluate();
        int[] storage = _getStorage();
        return new IntArraySpliteratorImpl(storage, spliteratorCharacteristics);
    }

    public boolean isParallel() {
        return super.isParallel();
    }

    @NotNull
    public IntStreamImpl sequential() {
        return (IntStreamImpl) super.sequential();
    }

    @NotNull
    public IntStreamImpl parallel() {
        return (IntStreamImpl) super.parallel();
    }

    @NotNull
    public IntStreamImpl unordered() {
        super.evaluate();
        return _copy();
    }

    @NotNull
    public IntStreamImpl onClose(@NotNull Runnable closeHandler) {
        return (IntStreamImpl) super.onClose(closeHandler);
    }

    public void close() {
        super.close();
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public IntStreamImpl dropWhile(@NotNull IntPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        int[] storage = _getStorage();
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
        int[] newStorage = Arrays.copyOf(storage, newLength);
        return _copy(newStorage);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public IntStreamImpl takeWhile(@NotNull IntPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        int[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return _copy(Arrays.copyOf(storage, 0));

        int takeLength = 0;
        while (takeLength < length && predicate.test(storage[takeLength])) {
            takeLength++;
        }

        if (takeLength == length)
            return _copy();

        int[] newStorage = Arrays.copyOf(storage, takeLength);
        return _copy(newStorage);
    }

    public LongStreamImpl asLongStream() {
        super.evaluate();

        int[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return _copyToLongStream(new long[0]);

        long[] newStorage = new long[length];
        LibSLRuntime.ArrayActions.copy(storage, 0, newStorage, 0, length);
        return _copyToLongStream(newStorage);
    }

    public DoubleStreamImpl asDoubleStream() {
        super.evaluate();

        int[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return _copyToDoubleStream(new double[0]);

        double[] newStorage = new double[length];
        LibSLRuntime.ArrayActions.copy(storage, 0, newStorage, 0, length);
        return _copyToDoubleStream(newStorage);
    }

    public int sum() {
        super.evaluate();
        return _sum();
    }

    public OptionalDouble average() {
        super.evaluate();

        int[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalDouble.empty();

        double curSum = _sum();
        double divisionResult = curSum / length;
        return OptionalDouble.of(divisionResult);
    }

    public IntSummaryStatistics summaryStatistics() {
        super.evaluate();

        int[] storage = _getStorage();
        IntSummaryStatistics result = new IntSummaryStatistics();
        for (int j : storage) {
            result.accept(j);
        }

        return result;
    }

    public Stream<Integer> boxed() {
        super.evaluate();

        int[] storage = _getStorage();
        int length = storage.length;
        Integer[] integerArray = new Integer[length];
        for (int i = 0; i < length; i++) {
            integerArray[i] = storage[i];
        }

        return _copyToObjStream(integerArray);
    }
}
