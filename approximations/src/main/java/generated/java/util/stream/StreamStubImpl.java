package generated.java.util.stream;

import generated.java.util.array.ArrayIteratorImpl;
import generated.java.util.array.ArraySpliteratorImpl;
import generated.runtime.LibSLGlobals;

import java.lang.Comparable;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.stream.StreamStub;

@Approximate(StreamStub.class)
public class StreamStubImpl<E> extends BaseStreamImpl<E> implements Stream<E> {

    private final E[] storage;

    public StreamStubImpl(
        E[] storage,
        SymbolicList<Runnable> handlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        super(handlers, isParallel, linkedOrConsumed);
        this.storage = storage;
    }

    public StreamStubImpl(E[] storage, SymbolicList<Runnable> handlers, boolean isParallel) {
        this(storage, handlers, isParallel, false);
    }

    public StreamStubImpl(E[] storage, boolean isParallel) {
        this(storage, Engine.makeSymbolicList(), isParallel);
    }

    public StreamStubImpl(E[] storage, SymbolicList<Runnable> handlers) {
        this(storage, handlers, false);
    }

    public StreamStubImpl(E[] storage) {
        this(storage, Engine.makeSymbolicList());
    }

    @SuppressWarnings({"ConstantValue", "DataFlowIssue"})
    private E[] _getStorage() {
        E[] storage = this.storage;
        Engine.assume(storage != null);
        Engine.assume(storage.length >= 0);
        return storage;
    }

    protected int _getLength() {
        return _getStorage().length;
    }

    private <T> StreamStubImpl<T> _copy(T[] storage) {
        return new StreamStubImpl<>(storage, _getCloseHandlers(), isParallel, false);
    }

    private StreamStubImpl<E> _copy() {
        return _copy(_getStorage());
    }

    private void _actionApply(Consumer<? super E> _action) {
        if (_action == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
        for (E e : storage) {
            _action.accept(e);
        }
    }

    private Optional<E> _findFirst() {
        E[] storage = _getStorage();

        if (storage.length == 0)
            return Optional.empty();

        E first = storage[0];
        return Optional.ofNullable(first);
    }

    public Stream<E> filter(Predicate<? super E> predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
        int length = storage.length;
        E[] filteredStorage = Arrays.copyOf(storage, length);
        int filteredLength = 0;
        for (E e : storage) {
            if (predicate.test(e)) {
                filteredStorage[filteredLength] = e;
                filteredLength++;
            }
        }

        Engine.assume(filteredLength <= length);
        E[] resultStorage = Arrays.copyOf(filteredStorage, filteredLength);
        return _copy(resultStorage);
    }

    @SuppressWarnings("unchecked")
    public <T> Stream<T> map(Function<? super E, ? extends T> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
        int length = storage.length;
        T[] mappedStorage = (T[]) new Object[length];
        for (int i = 0; i < length; i++) {
            mappedStorage[i] = mapper.apply(storage[i]);
        }

        return _copy(mappedStorage);
    }

    public IntStream mapToInt(ToIntFunction<? super E> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
        int length = storage.length;
        int[] mappedStorage = new int[length];
        for (int i = 0; i < length; i++) {
            mappedStorage[i] = mapper.applyAsInt(storage[i]);
        }

        return _copyToIntStream(mappedStorage);
    }

    public LongStream mapToLong(ToLongFunction<? super E> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
        int length = storage.length;
        long[] mappedStorage = new long[length];
        for (int i = 0; i < length; i++) {
            mappedStorage[i] = mapper.applyAsLong(storage[i]);
        }

        return _copyToLongStream(mappedStorage);
    }

    public DoubleStream mapToDouble(ToDoubleFunction<? super E> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
        int length = storage.length;
        double[] mappedStorage = new double[length];
        for (int i = 0; i < length; i++) {
            mappedStorage[i] = mapper.applyAsDouble(storage[i]);
        }

        return _copyToDoubleStream(mappedStorage);
    }

    @SuppressWarnings({"unchecked", "ConstantValue"})
    public <R> Stream<R> flatMap(Function<? super E, ? extends Stream<? extends R>> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        // TODO: approximate
        Stream<R> result = Engine.makeSymbolic(Stream.class);
        Engine.assume(result != null);
        return result;
    }

    @SuppressWarnings("ConstantValue")
    public IntStream flatMapToInt(Function<? super E, ? extends IntStream> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        // TODO: approximate
        IntStream result = Engine.makeSymbolic(IntStream.class);
        Engine.assume(result != null);
        return result;
    }

    @SuppressWarnings("ConstantValue")
    public LongStream flatMapToLong(Function<? super E, ? extends LongStream> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        // TODO: approximate
        LongStream result = Engine.makeSymbolic(LongStream.class);
        Engine.assume(result != null);
        return result;
    }

    @SuppressWarnings("ConstantValue")
    public DoubleStream flatMapToDouble(Function<? super E, ? extends DoubleStream> mapper) {
        super.evaluate();

        if (mapper == null)
            throw new NullPointerException();

        // TODO: approximate
        DoubleStream result = Engine.makeSymbolic(DoubleStream.class);
        Engine.assume(result != null);
        return result;
    }

    public StreamStubImpl<E> distinct() {
        super.evaluate();

        E[] storage = _getStorage();
        E[] distinctStorage;
        int length = storage.length;
        if (length == 0) {
            distinctStorage = Arrays.copyOf(storage, 0);
            return _copy(distinctStorage);
        }

        int distinctLength = 0;
        distinctStorage = Arrays.copyOf(storage, length);
        LibSLRuntime.Map<E, Object> visited = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        for (E item : storage) {
            if (!visited.hasKey(item)) {
                Engine.assume(item != null);
                visited.set(item, LibSLGlobals.SOMETHING);
                distinctStorage[distinctLength] = item;
                distinctLength++;
            }
        }

        Engine.assume(distinctLength <= length);
        E[] resultStorage = Arrays.copyOf(distinctStorage, distinctLength);
        return _copy(resultStorage);
    }

    @SuppressWarnings("unchecked")
    public StreamStubImpl<E> sorted() {
        super.evaluate();

        E[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return _copy();

        int outerLimit = length - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = length - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                Comparable<E> a = (Comparable<E>) storage[j];
                E b = storage[idxB];
                if (a.compareTo(b) > 0) {
                    storage[j] = b;
                    storage[idxB] = (E) a;
                }
            }
        }

        return _copy();
    }

    public StreamStubImpl<E> sorted(Comparator<? super E> comparator) {
        super.evaluate();

        E[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return _copy();

        int outerLimit = length - 1;
        for (int i = 0; i < outerLimit; i++) {
            int innerLimit = length - i - 1;
            for (int j = 0; j < innerLimit; j++) {
                int idxB = j + 1;
                E a = storage[j];
                E b = storage[idxB];
                if (comparator.compare(a, b) > 0) {
                    storage[j] = b;
                    storage[idxB] = a;
                }
            }
        }

        return _copy();
    }

    public StreamStubImpl<E> peek(Consumer<? super E> _action) {
        super.evaluate();
        _actionApply(_action);
        return _copy();
    }

    public StreamStubImpl<E> limit(long maxSize) {
        super.evaluate();

        int maxSizeInt = (int) maxSize;

        if (maxSizeInt < 0)
            throw new IllegalArgumentException();

        if (maxSizeInt == 0)
            return _copy(Arrays.copyOf(_getStorage(), 0));

        E[] storage = _getStorage();
        int length = storage.length;
        if (maxSizeInt > length)
            return _copy();

        E[] limitStorage = Arrays.copyOf(storage, maxSizeInt);
        return _copy(limitStorage);
    }

    public StreamStubImpl<E> skip(long n) {
        super.evaluate();

        int offset = (int) n;

        if (offset < 0)
            throw new IllegalArgumentException();

        if (offset == 0)
            return _copy();

        E[] storage = _getStorage();
        int length = storage.length;
        if (offset >= length)
            return _copy(Arrays.copyOf(_getStorage(), 0));

        E[] skipStorage = Arrays.copyOfRange(storage, offset, length);
        return _copy(skipStorage);
    }

    public void forEach(Consumer<? super E> _action) {
        super.evaluate();
        _actionApply(_action);
    }

    public void forEachOrdered(Consumer<? super E> _action) {
        forEach(_action);
    }

    @NotNull
    public Object[] toArray() {
        super.evaluate();
        return _getStorage();
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(IntFunction<T[]> generator) {
        super.evaluate();
        E[] storage = _getStorage();
        int length = storage.length;

        T[] array = generator.apply(length);
        if (array.length < length)
            return (T[]) Arrays.copyOf(storage, length, array.getClass());

        LibSLRuntime.ArrayActions.copy(storage, 0, array, 0, length);
        return array;
    }

    public E reduce(E identity, BinaryOperator<E> accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        E result = identity;
        E[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return result;

        for (E item : storage) {
            result = accumulator.apply(result, item);
        }

        return result;
    }

    @NotNull
    public Optional<E> reduce(BinaryOperator<E> accumulator) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return Optional.empty();

        E value = storage[0];
        for (int i = 1; i < length; i++) {
            value = accumulator.apply(value, storage[i]);
        }

        return Optional.of(value);
    }

    public <T> T reduce(T identity, BiFunction<T, ? super E, T> accumulator, BinaryOperator<T> combiner) {
        super.evaluate();

        if (accumulator == null)
            throw new NullPointerException();

        if (combiner == null)
            throw new NullPointerException();

        T result = identity;
        E[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return result;

        for (E item : storage) {
            result = accumulator.apply(result, item);
        }

        return result;
    }

    private <R> R _collect(Supplier<R> supplier, BiConsumer<R, ? super E> accumulator) {
        R result = supplier.get();
        E[] storage = _getStorage();
        for (E item : storage) {
            accumulator.accept(result, item);
        }

        return result;
    }

    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super E> accumulator, BiConsumer<R, R> combiner) {
        super.evaluate();

        if (supplier == null)
            throw new NullPointerException();

        if (accumulator == null)
            throw new NullPointerException();

        if (combiner == null)
            throw new NullPointerException();

        return _collect(supplier, accumulator);
    }

    public <R, A> R collect(Collector<? super E, A, R> collector) {
        super.evaluate();

        if (collector == null)
            throw new NullPointerException();

        return collector.finisher().apply(_collect(collector.supplier(), collector.accumulator()));
    }

    @NotNull
    public Optional<E> min(Comparator<? super E> comparator) {
        super.evaluate();

        if (comparator == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return Optional.empty();

        E min = storage[0];
        for (int i = 1; i < length; i++) {
            E item = storage[i];
            if (comparator.compare(min, item) > 0)
                min = item;
        }

        return Optional.ofNullable(min);
    }

    @NotNull
    public Optional<E> max(Comparator<? super E> comparator) {
        super.evaluate();

        if (comparator == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return Optional.empty();

        E max = storage[0];
        for (int i = 1; i < length; i++) {
            E item = storage[i];
            if (comparator.compare(max, item) < 0)
                max = item;
        }

        return Optional.ofNullable(max);
    }

    public long count() {
        super.evaluate();
        return _getStorage().length;
    }

    public boolean anyMatch(Predicate<? super E> predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
        for (E item : storage) {
            if (predicate.test(item))
                return true;
        }

        return false;
    }

    public boolean allMatch(Predicate<? super E> predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return true;

        for (E item : storage) {
            if (!predicate.test(item))
                return false;
        }

        return true;
    }

    public boolean noneMatch(Predicate<? super E> predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return true;

        for (E item : storage) {
            if (predicate.test(item))
                return false;
        }

        return true;
    }

    @NotNull
    public Optional<E> findFirst() {
        super.evaluate();
        return  _findFirst();
    }

    @NotNull
    public Optional<E> findAny() {
        return findFirst();
    }

    @NotNull
    public Iterator<E> iterator() {
        super.evaluate();
        return new ArrayIteratorImpl<>(_getStorage());
    }

    @NotNull
    public Spliterator<E> spliterator() {
        super.evaluate();
        E[] storage = _getStorage();
        int characteristics = LibSLGlobals.SPLITERATOR_ORDERED | LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_SUBSIZED;
        return new ArraySpliteratorImpl<>(storage, characteristics);
    }

    public boolean isParallel() {
        return this.isParallel;
    }

    @NotNull
    public StreamStubImpl<E> sequential() {
        return (StreamStubImpl<E>) super.sequential();
    }

    @NotNull
    public StreamStubImpl<E> parallel() {
        return (StreamStubImpl<E>) super.parallel();
    }

    @NotNull
    public StreamStubImpl<E> unordered() {
        super.evaluate();
        return _copy();
    }

    @NotNull
    public StreamStubImpl<E> onClose(@NotNull Runnable handler) {
        return (StreamStubImpl<E>) super.onClose(handler);
    }

    public void close() {
        super.close();
    }

    public StreamStubImpl<E> dropWhile(Predicate<? super E> predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
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
        E[] newStorage = Arrays.copyOf(storage, newLength);
        return _copy(newStorage);
    }

    public StreamStubImpl<E> takeWhile(Predicate<? super E> predicate) {
        super.evaluate();

        if (predicate == null)
            throw new NullPointerException();

        E[] storage = _getStorage();
        int length = storage.length;
        if (length == 0)
            return _copy(Arrays.copyOf(storage, 0));

        int takeLength = 0;
        while (takeLength < length && predicate.test(storage[takeLength])) {
            takeLength++;
        }

        if (takeLength == length)
            return _copy();

        E[] newStorage = Arrays.copyOf(storage, takeLength);
        return _copy(newStorage);
    }
}
