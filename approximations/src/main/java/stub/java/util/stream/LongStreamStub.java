package stub.java.util.stream;

import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;

import java.lang.LinkageError;
import java.lang.Runnable;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
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

public class LongStreamStub extends BaseStreamStub<Long> implements LongStream {

    @SuppressWarnings("unused")
    public LongStreamStub(
        long[] storage,
        SymbolicList<Runnable> closeHandlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        super(closeHandlers, isParallel, linkedOrConsumed);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public LongStreamStub(long[] storage, SymbolicList<Runnable> closeHandlers, boolean isParallel) {
        super(closeHandlers, isParallel, false);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public LongStreamStub(long[] storage, SymbolicList<Runnable> closeHandlers) {
        super(closeHandlers, false, false);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public LongStreamStub(long[] storage) {
        super(Engine.makeSymbolicList(), false, false);
        throw new LinkageError();
    }

    protected int _getLength() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub filter(@NotNull LongPredicate predicate) {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub map(@NotNull LongUnaryOperator mapper) {
        throw new LinkageError();
    }

    @NotNull
    public <T> StreamStub<T> mapToObj(@NotNull LongFunction<? extends T> mapper) {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub mapToInt(@NotNull LongToIntFunction mapper) {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub mapToDouble(@NotNull LongToDoubleFunction mapper) {
        throw new LinkageError();
    }

    @NotNull
    public LongStream flatMap(@NotNull LongFunction<? extends LongStream> mapper) {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub sorted() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub distinct() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub peek(@NotNull LongConsumer _action) {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub limit(long maxSize) {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub skip(long n) {
        throw new LinkageError();
    }

    public void forEach(LongConsumer _action) {
        throw new LinkageError();
    }

    public void forEachOrdered(LongConsumer _action) {
        throw new LinkageError();
    }

    public long[] toArray() {
        throw new LinkageError();
    }

    public long reduce(long identity, LongBinaryOperator accumulator) {
        throw new LinkageError();
    }

    public OptionalLong reduce(LongBinaryOperator accumulator) {
        throw new LinkageError();
    }

    public <R> R collect(Supplier<R> supplier, ObjLongConsumer<R> accumulator, BiConsumer<R, R> combiner) {
        throw new LinkageError();
    }

    public OptionalLong min() {
        throw new LinkageError();
    }

    public OptionalLong max() {
        throw new LinkageError();
    }

    public long count() {
        throw new LinkageError();
    }

    public boolean anyMatch(LongPredicate predicate) {
        throw new LinkageError();
    }

    public boolean allMatch(LongPredicate predicate) {
        throw new LinkageError();
    }

    public boolean noneMatch(LongPredicate predicate) {
        throw new LinkageError();
    }

    public OptionalLong findFirst() {
        throw new LinkageError();
    }

    public OptionalLong findAny() {
        throw new LinkageError();
    }

    @NotNull
    public PrimitiveIterator.OfLong iterator() {
        throw new LinkageError();
    }

    @NotNull
    public Spliterator.OfLong spliterator() {
        throw new LinkageError();
    }

    public boolean isParallel() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub sequential() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub parallel() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub unordered() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub onClose(@NotNull Runnable closeHandler) {
        throw new LinkageError();
    }

    public void close() {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub dropWhile(@NotNull LongPredicate predicate) {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub takeWhile(@NotNull LongPredicate predicate) {
        throw new LinkageError();
    }

    public DoubleStreamStub asDoubleStream() {
        throw new LinkageError();
    }

    public long sum() {
        throw new LinkageError();
    }

    public OptionalDouble average() {
        throw new LinkageError();
    }

    public LongSummaryStatistics summaryStatistics() {
        throw new LinkageError();
    }

    public Stream<Long> boxed() {
        throw new LinkageError();
    }
}
