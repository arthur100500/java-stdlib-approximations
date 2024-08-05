package stub.java.util.stream;

import java.lang.LinkageError;
import java.lang.Runnable;
import java.util.DoubleSummaryStatistics;
import java.util.OptionalDouble;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
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

import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;

public class DoubleStreamStub extends BaseStreamStub<Double> implements DoubleStream {

    @SuppressWarnings("unused")
    public DoubleStreamStub(
        double[] storage,
        SymbolicList<Runnable> closeHandlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        super(closeHandlers, isParallel, linkedOrConsumed);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public DoubleStreamStub(double[] storage, SymbolicList<Runnable> closeHandlers, boolean isParallel) {
        super(closeHandlers, isParallel, false);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public DoubleStreamStub(double[] storage, SymbolicList<Runnable> closeHandlers) {
        super(closeHandlers, false, false);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public DoubleStreamStub(double[] storage) {
        super(Engine.makeSymbolicList(), false, false);
        throw new LinkageError();
    }

    protected int _getLength() {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub filter(@NotNull DoublePredicate predicate) {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub map(@NotNull DoubleUnaryOperator mapper) {
        throw new LinkageError();
    }

    @NotNull
    public <T> StreamStub<T> mapToObj(@NotNull DoubleFunction<? extends T> mapper) {
        throw new LinkageError();
    }

    @NotNull
    public LongStreamStub mapToLong(@NotNull DoubleToLongFunction mapper) {
        throw new LinkageError();
    }

    @NotNull
    public IntStreamStub mapToInt(@NotNull DoubleToIntFunction mapper) {
        throw new LinkageError();
    }

    public DoubleStream flatMap(@NotNull DoubleFunction<? extends DoubleStream> mapper) {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub sorted() {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub distinct() {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub peek(@NotNull DoubleConsumer _action) {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub limit(long maxSize) {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub skip(long n) {
        throw new LinkageError();
    }

    public void forEach(DoubleConsumer _action) {
        throw new LinkageError();
    }

    public void forEachOrdered(DoubleConsumer _action) {
        throw new LinkageError();
    }

    public double[] toArray() {
        throw new LinkageError();
    }

    public double reduce(double identity, DoubleBinaryOperator accumulator) {
        throw new LinkageError();
    }

    public OptionalDouble reduce(DoubleBinaryOperator accumulator) {
        throw new LinkageError();
    }

    public <R> R collect(Supplier<R> supplier, ObjDoubleConsumer<R> accumulator, BiConsumer<R, R> combiner) {
        throw new LinkageError();
    }

    public OptionalDouble min() {
        throw new LinkageError();
    }

    public OptionalDouble max() {
        throw new LinkageError();
    }

    public long count() {
        throw new LinkageError();
    }

    public boolean anyMatch(DoublePredicate predicate) {
        throw new LinkageError();
    }

    public boolean allMatch(DoublePredicate predicate) {
        throw new LinkageError();
    }

    public boolean noneMatch(DoublePredicate predicate) {
        throw new LinkageError();
    }

    public OptionalDouble findFirst() {
        throw new LinkageError();
    }

    public OptionalDouble findAny() {
        throw new LinkageError();
    }

    @NotNull
    public PrimitiveIterator.OfDouble iterator() {
        throw new LinkageError();
    }

    @NotNull
    public Spliterator.OfDouble spliterator() {
        throw new LinkageError();
    }

    public boolean isParallel() {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub sequential() {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub parallel() {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub unordered() {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub onClose(@NotNull Runnable closeHandler) {
        throw new LinkageError();
    }

    public void close() {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub dropWhile(@NotNull DoublePredicate predicate) {
        throw new LinkageError();
    }

    @NotNull
    public DoubleStreamStub takeWhile(@NotNull DoublePredicate predicate) {
        throw new LinkageError();
    }

    public double sum() {
        throw new LinkageError();
    }

    public OptionalDouble average() {
        throw new LinkageError();
    }

    public DoubleSummaryStatistics summaryStatistics() {
        throw new LinkageError();
    }

    public Stream<Double> boxed() {
        throw new LinkageError();
    }
}
