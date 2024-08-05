package stub.java.util.stream;

import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;

import java.lang.LinkageError;
import java.lang.Object;
import java.lang.Runnable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
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

public class StreamStub<E> extends BaseStreamStub<E> implements Stream<E> {

    @SuppressWarnings("unused")
    public StreamStub(
        E[] storage,
        SymbolicList<Runnable> handlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        super(handlers, isParallel, linkedOrConsumed);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public StreamStub(E[] storage, SymbolicList<Runnable> handlers, boolean isParallel) {
        super(handlers, isParallel, false);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public StreamStub(E[] storage, boolean isParallel) {
        super(Engine.makeSymbolicList(), isParallel, false);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public StreamStub(E[] storage, SymbolicList<Runnable> handlers) {
        super(handlers, false, false);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public StreamStub(E[] storage) {
        super(Engine.makeSymbolicList(), false, false);
        throw new LinkageError();
    }

    protected int _getLength() {
        throw new LinkageError();
    }

    public Stream<E> filter(Predicate<? super E> predicate) {
        throw new LinkageError();
    }

    public <T> Stream<T> map(Function<? super E, ? extends T> mapper) {
        throw new LinkageError();
    }

    public IntStream mapToInt(ToIntFunction<? super E> mapper) {
        throw new LinkageError();
    }

    public LongStream mapToLong(ToLongFunction<? super E> mapper) {
        throw new LinkageError();
    }

    public DoubleStream mapToDouble(ToDoubleFunction<? super E> mapper) {
        throw new LinkageError();
    }

    public <R> Stream<R> flatMap(Function<? super E, ? extends Stream<? extends R>> mapper) {
        throw new LinkageError();
    }

    public IntStream flatMapToInt(Function<? super E, ? extends IntStream> mapper) {
        throw new LinkageError();
    }

    public LongStream flatMapToLong(Function<? super E, ? extends LongStream> mapper) {
        throw new LinkageError();
    }

    public DoubleStream flatMapToDouble(Function<? super E, ? extends DoubleStream> mapper) {
        throw new LinkageError();
    }

    public StreamStub<E> distinct() {
        throw new LinkageError();
    }

    public StreamStub<E> sorted() {
        throw new LinkageError();
    }

    public StreamStub<E> sorted(Comparator<? super E> comparator) {
        throw new LinkageError();
    }

    public StreamStub<E> peek(Consumer<? super E> _action) {
        throw new LinkageError();
    }

    public StreamStub<E> limit(long maxSize) {
        throw new LinkageError();
    }

    public StreamStub<E> skip(long n) {
        throw new LinkageError();
    }

    public void forEach(Consumer<? super E> _action) {
        throw new LinkageError();
    }

    public void forEachOrdered(Consumer<? super E> _action) {
        throw new LinkageError();
    }

    @NotNull
    public Object[] toArray() {
        throw new LinkageError();
    }

    @NotNull
    public <T> T[] toArray(IntFunction<T[]> generator) {
        throw new LinkageError();
    }

    public E reduce(E identity, BinaryOperator<E> accumulator) {
        throw new LinkageError();
    }

    @NotNull
    public Optional<E> reduce(BinaryOperator<E> accumulator) {
        throw new LinkageError();
    }

    public <T> T reduce(T identity, BiFunction<T, ? super E, T> accumulator, BinaryOperator<T> combiner) {
        throw new LinkageError();
    }

    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super E> accumulator, BiConsumer<R, R> combiner) {
        throw new LinkageError();
    }

    public <R, A> R collect(Collector<? super E, A, R> collector) {
        throw new LinkageError();
    }

    @NotNull
    public Optional<E> min(Comparator<? super E> comparator) {
        throw new LinkageError();
    }

    @NotNull
    public Optional<E> max(Comparator<? super E> comparator) {
        throw new LinkageError();
    }

    public long count() {
        throw new LinkageError();
    }

    public boolean anyMatch(Predicate<? super E> predicate) {
        throw new LinkageError();
    }

    public boolean allMatch(Predicate<? super E> predicate) {
        throw new LinkageError();
    }

    public boolean noneMatch(Predicate<? super E> predicate) {
        throw new LinkageError();
    }

    @NotNull
    public Optional<E> findFirst() {
        throw new LinkageError();
    }

    @NotNull
    public Optional<E> findAny() {
        throw new LinkageError();
    }

    @NotNull
    public Iterator<E> iterator() {
        throw new LinkageError();
    }

    @NotNull
    public Spliterator<E> spliterator() {
        throw new LinkageError();
    }

    public boolean isParallel() {
        throw new LinkageError();
    }

    @NotNull
    public StreamStub<E> sequential() {
        throw new LinkageError();
    }

    @NotNull
    public StreamStub<E> parallel() {
        throw new LinkageError();
    }

    @NotNull
    public StreamStub<E> unordered() {
        throw new LinkageError();
    }

    @NotNull
    public StreamStub<E> onClose(@NotNull Runnable handler) {
        throw new LinkageError();
    }

    public void close() {
        throw new LinkageError();
    }

    public StreamStub<E> dropWhile(Predicate<? super E> predicate) {
        throw new LinkageError();
    }

    public StreamStub<E> takeWhile(Predicate<? super E> predicate) {
        throw new LinkageError();
    }
}
