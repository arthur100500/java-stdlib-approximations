package generated.java.util.stream;

import generated.java.util.array.LongArrayIteratorImpl;
import generated.java.util.array.LongArraySpliteratorImpl;
import generated.runtime.LibSLGlobals;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.stream.*;

@Approximate(LongStreamStub.class)
public class LongStreamImpl extends BaseStreamImpl<Long> implements LongStream {

    public long[] storage;

    public LongStreamImpl(
        long[] storage,
        SymbolicList<Runnable> closeHandlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        super(closeHandlers, isParallel, linkedOrConsumed);
        this.storage = storage;
    }

    public LongStreamImpl(long[] storage, SymbolicList<Runnable> closeHandlers, boolean isParallel) {
        this(storage, closeHandlers, isParallel, false);
    }

    public LongStreamImpl(long[] storage, SymbolicList<Runnable> closeHandlers) {
        this(storage, closeHandlers, false);
    }

    public LongStreamImpl(long[] storage) {
        this(storage, Engine.makeSymbolicList());
    }

    private long[] _getStorage() {
        long[] storage = this.storage;
        Engine.assume(storage != null);
        return storage;
    }

    protected int _getLength() {
        return _getStorage().length;
    }

    private LongStreamImpl _copy(long[] storage) {
        return new LongStreamImpl(storage, _getCloseHandlers(), isParallel, false);
    }

    private LongStreamImpl _copy() {
        return _copy(_getStorage());
    }

    private void _actionApply(LongConsumer _action) {
        if (_action == null)
            throw new NullPointerException();

        long[] storage = _getStorage();
        for (long j : storage) {
            _action.accept(j);
        }
    }

    private OptionalLong _findFirst() {
        long[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalLong.empty();

        long first = storage[0];
        return OptionalLong.of(first);
    }

    private long _sum() {
        long[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return 0;

        long result = 0;
        for (long l : storage) {
            result += l;
        }

        return result;
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public LongStreamImpl filter(@NotNull LongPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        long[] storage = _getStorage();
        int length = storage.length;
        long[] filteredStorage = Arrays.copyOf(storage, length);
        int filteredLength = 0;
        for (long e : storage) {
            if (predicate.test(e)) {
                filteredStorage[filteredLength] = e;
                filteredLength++;
            }
        }

        Engine.assume(filteredLength <= length);
        long[] resultStorage = Arrays.copyOf(filteredStorage, filteredLength);
        return _copy(resultStorage);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public LongStreamImpl map(@NotNull LongUnaryOperator mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        long[] storage = _getStorage();
        int length = storage.length;
        long[] mappedStorage = new long[length];
        for (int i = 0; i < length; i++) {
            mappedStorage[i] = mapper.applyAsLong(storage[i]);
        }

        return _copy(mappedStorage);
    }

    @NotNull
    @SuppressWarnings({"unchecked", "ConstantValue"})
    public <T> StreamStubImpl<T> mapToObj(@NotNull LongFunction<? extends T> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        long[] storage = _getStorage();
        int length = storage.length;
        T[] objStorage = (T[]) new Object[length];
        for (int i = 0; i < length; i++) {
            objStorage[i] = mapper.apply(storage[i]);
        }

        return _copyToObjStream(objStorage);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public IntStreamImpl mapToInt(@NotNull LongToIntFunction mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        long[] storage = _getStorage();
        int length = storage.length;
        int[] mappedStorage = new int[length];
        for (int i = 0; i < length; i++) {
            mappedStorage[i] = mapper.applyAsInt(storage[i]);
        }

        return _copyToIntStream(mappedStorage);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public DoubleStreamImpl mapToDouble(@NotNull LongToDoubleFunction mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        long[] storage = _getStorage();
        int length = storage.length;
        double[] mappedStorage = new double[length];
        for (int i = 0; i < length; i++) {
            mappedStorage[i] = mapper.applyAsDouble(storage[i]);
        }

        return _copyToDoubleStream(mappedStorage);
    }

    @NotNull
    @SuppressWarnings({"ConstantValue", "DataFlowIssue"})
    public LongStream flatMap(@NotNull LongFunction<? extends LongStream> mapper) {
        // TODO: approximate
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        LongStream result = Engine.makeSymbolic(LongStream.class);
        Engine.assume(result != null);
        return result;
    }

    @NotNull
    public LongStreamImpl sorted() {
        super.evaluate();

        long[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return _copy();

        int outerLimit = length - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = length - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                long a = storage[j];
                long b = storage[idxB];
                if (a > b) {
                    storage[j] = b;
                    storage[idxB] = a;
                }
            }
        }

        return _copy();
    }

    @NotNull
    public LongStreamImpl distinct() {
        super.evaluate();

        long[] storage = _getStorage();
        long[] distinctStorage;
        int length = storage.length;
        if (length == 0) {
            distinctStorage = Arrays.copyOf(storage, 0);
            return _copy(distinctStorage);
        }

        int distinctLength = 0;
        distinctStorage = Arrays.copyOf(storage, length);
        LibSLRuntime.Map<Long, Object> visited = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        for (long item : storage) {
            if (!visited.hasKey(item)) {
                visited.set(item, LibSLGlobals.SOMETHING);
                distinctStorage[distinctLength] = item;
                distinctLength++;
            }
        }

        Engine.assume(distinctLength <= length);
        long[] resultStorage = Arrays.copyOf(distinctStorage, distinctLength);
        return _copy(resultStorage);
    }

    @NotNull
    public LongStreamImpl peek(@NotNull LongConsumer _action) {
        super.evaluate();
        _actionApply(_action);
        return _copy();
    }

    @NotNull
    public LongStreamImpl limit(long maxSize) {
        super.evaluate();

        int maxSizeInt = (int) maxSize;

        if (maxSizeInt < 0)
            throw new IllegalArgumentException();

        if (maxSizeInt == 0)
            return _copy(Arrays.copyOf(_getStorage(), 0));

        long[] storage = _getStorage();
        int length = storage.length;
        if (maxSizeInt > length)
            return _copy();

        long[] limitStorage = Arrays.copyOf(storage, maxSizeInt);
        return _copy(limitStorage);
    }

    @NotNull
    public LongStreamImpl skip(long n) {
        super.evaluate();

        int offset = (int) n;

        if (offset < 0)
            throw new IllegalArgumentException();

        if (offset == 0)
            return _copy();

        long[] storage = _getStorage();
        int length = storage.length;
        if (offset >= length)
            return _copy(Arrays.copyOf(_getStorage(), 0));

        long[] skipStorage = Arrays.copyOfRange(storage, offset, length);
        return _copy(skipStorage);
    }

    public void forEach(LongConsumer _action) {
        super.evaluate();
        _actionApply(_action);
    }

    public void forEachOrdered(LongConsumer _action) {
        forEach(_action);
    }

    public long[] toArray() {
        super.evaluate();
        return _getStorage();
    }

    public long reduce(long identity, LongBinaryOperator accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        long result = identity;
        long[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return result;

        for (long item : storage) {
            result = accumulator.applyAsLong(result, item);
        }

        return result;
    }

    public OptionalLong reduce(LongBinaryOperator accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        long[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalLong.empty();

        long value = storage[0];
        for (int i = 1; i < length; i++) {
            value = accumulator.applyAsLong(value, storage[i]);
        }

        return OptionalLong.of(value);
    }

    public <R> R collect(Supplier<R> supplier, ObjLongConsumer<R> accumulator, BiConsumer<R, R> combiner) {
        super.evaluate();

        if (supplier == null)
            throw new NullPointerException();

        if (accumulator == null)
            throw new NullPointerException();

        if (combiner == null)
            throw new NullPointerException();

        R result = supplier.get();
        long[] storage = _getStorage();
        for (long item : storage) {
            accumulator.accept(result, item);
        }

        return result;
    }

    public OptionalLong min() {
        super.evaluate();

        long[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalLong.empty();

        long min = storage[0];
        for (int i = 1; i < length; i++) {
            long item = storage[i];
            if (min > item)
                min = item;
        }

        return OptionalLong.of(min);
    }

    public OptionalLong max() {
        super.evaluate();

        long[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalLong.empty();

        long max = storage[0];
        for (int i = 1; i < length; i++) {
            long item = storage[i];
            if (max < item)
                max = item;
        }

        return OptionalLong.of(max);
    }

    public long count() {
        return super.count();
    }

    public boolean anyMatch(LongPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        long[] storage = _getStorage();
        for (long item : storage) {
            if (predicate.test(item))
                return true;
        }

        return false;
    }

    public boolean allMatch(LongPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        long[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return true;

        for (long item : storage) {
            if (!predicate.test(item))
                return false;
        }

        return true;
    }

    public boolean noneMatch(LongPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        long[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return true;

        for (long item : storage) {
            if (predicate.test(item))
                return false;
        }

        return true;
    }

    public OptionalLong findFirst() {
        super.evaluate();
        return _findFirst();
    }

    public OptionalLong findAny() {
        return findFirst();
    }

    @NotNull
    public PrimitiveIterator.OfLong iterator() {
        super.evaluate();
        return new LongArrayIteratorImpl(_getStorage());
    }

    @NotNull
    public Spliterator.OfLong spliterator() {
        super.evaluate();
        long[] storage = _getStorage();
        return new LongArraySpliteratorImpl(storage, spliteratorCharacteristics);
    }

    public boolean isParallel() {
        return super.isParallel();
    }

    @NotNull
    public LongStreamImpl sequential() {
        return (LongStreamImpl) super.sequential();
    }

    @NotNull
    public LongStreamImpl parallel() {
        return (LongStreamImpl) super.parallel();
    }

    @NotNull
    public LongStreamImpl unordered() {
        super.evaluate();
        return _copy();
    }

    @NotNull
    public LongStreamImpl onClose(@NotNull Runnable closeHandler) {
        return (LongStreamImpl) super.onClose(closeHandler);
    }

    public void close() {
        super.close();
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public LongStreamImpl dropWhile(@NotNull LongPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        long[] storage = _getStorage();
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
        long[] newStorage = Arrays.copyOf(storage, newLength);
        return _copy(newStorage);
    }

    @NotNull
    @SuppressWarnings("ConstantValue")
    public LongStreamImpl takeWhile(@NotNull LongPredicate predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        long[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return _copy(Arrays.copyOf(storage, 0));

        int takeLength = 0;
        while (takeLength < length && predicate.test(storage[takeLength])) {
            takeLength++;
        }

        if (takeLength == length)
            return _copy();

        long[] newStorage = Arrays.copyOf(storage, takeLength);
        return _copy(newStorage);
    }

    public DoubleStreamImpl asDoubleStream() {
        super.evaluate();

        long[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return _copyToDoubleStream(new double[0]);

        double[] newStorage = new double[length];
        LibSLRuntime.ArrayActions.copy(storage, 0, newStorage, 0, length);
        return _copyToDoubleStream(newStorage);
    }

    public long sum() {
        super.evaluate();
        return _sum();
    }

    public OptionalDouble average() {
        super.evaluate();

        long[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return OptionalDouble.empty();

        double curSum = _sum();
        double divisionResult = curSum / length;
        return OptionalDouble.of(divisionResult);
    }

    public LongSummaryStatistics summaryStatistics() {
        super.evaluate();

        long[] storage = _getStorage();
        LongSummaryStatistics result = new LongSummaryStatistics();
        for (long j : storage) {
            result.accept(j);
        }

        return result;
    }

    public Stream<Long> boxed() {
        super.evaluate();

        long[] storage = _getStorage();
        int length = storage.length;
        Long[] integerArray = new Long[length];
        for (int i = 0; i < length; i++) {
            integerArray[i] = storage[i];
        }

        return _copyToObjStream(integerArray);
    }
}
