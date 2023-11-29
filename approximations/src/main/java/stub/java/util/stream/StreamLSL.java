// Generated by the LibSL translator.  DO NOT EDIT!
// source: ?
//
package stub.java.util.stream;

import java.lang.InternalError;
import java.lang.Object;
import java.lang.Runnable;
import java.lang.SuppressWarnings;
import java.lang.Void;
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
import java.util.stream.BaseStream;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import runtime.LibSLRuntime;

@SuppressWarnings({"all", "unchecked"})
public class StreamLSL implements LibSLRuntime.HasAutomaton, Stream {
    private StreamLSL(Void a, Void b) {
        super();
    }

    public Stream filter(Predicate predicate) {
        throw new InternalError();
    }

    public Stream map(Function mapper) {
        throw new InternalError();
    }

    public IntStream mapToInt(ToIntFunction mapper) {
        throw new InternalError();
    }

    public LongStream mapToLong(ToLongFunction mapper) {
        throw new InternalError();
    }

    public DoubleStream mapToDouble(ToDoubleFunction mapper) {
        throw new InternalError();
    }

    public Stream flatMap(Function mapper) {
        throw new InternalError();
    }

    public IntStream flatMapToInt(Function mapper) {
        throw new InternalError();
    }

    public LongStream flatMapToLong(Function mapper) {
        throw new InternalError();
    }

    public DoubleStream flatMapToDouble(Function mapper) {
        throw new InternalError();
    }

    public Stream distinct() {
        throw new InternalError();
    }

    public Stream sorted() {
        throw new InternalError();
    }

    public Stream sorted(Comparator comparator) {
        throw new InternalError();
    }

    public Stream peek(Consumer _action) {
        throw new InternalError();
    }

    public Stream limit(long maxSize) {
        throw new InternalError();
    }

    public Stream skip(long n) {
        throw new InternalError();
    }

    public void forEach(Consumer _action) {
        throw new InternalError();
    }

    public void forEachOrdered(Consumer _action) {
        throw new InternalError();
    }

    public Object[] toArray() {
        throw new InternalError();
    }

    public Object[] toArray(IntFunction generator) {
        throw new InternalError();
    }

    public Object reduce(Object identity, BinaryOperator accumulator) {
        throw new InternalError();
    }

    public Optional reduce(BinaryOperator accumulator) {
        throw new InternalError();
    }

    public Object reduce(Object identity, BiFunction accumulator, BinaryOperator combiner) {
        throw new InternalError();
    }

    public Object collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner) {
        throw new InternalError();
    }

    public Object collect(Collector collector) {
        throw new InternalError();
    }

    public Optional min(Comparator comparator) {
        throw new InternalError();
    }

    public Optional max(Comparator comparator) {
        throw new InternalError();
    }

    public long count() {
        throw new InternalError();
    }

    public boolean anyMatch(Predicate predicate) {
        throw new InternalError();
    }

    public boolean allMatch(Predicate predicate) {
        throw new InternalError();
    }

    public boolean noneMatch(Predicate predicate) {
        throw new InternalError();
    }

    public Optional findFirst() {
        throw new InternalError();
    }

    public Optional findAny() {
        throw new InternalError();
    }

    public Iterator iterator() {
        throw new InternalError();
    }

    public Spliterator spliterator() {
        throw new InternalError();
    }

    public boolean isParallel() {
        throw new InternalError();
    }

    public BaseStream sequential() {
        throw new InternalError();
    }

    public BaseStream parallel() {
        throw new InternalError();
    }

    public BaseStream unordered() {
        throw new InternalError();
    }

    public BaseStream onClose(Runnable arg0) {
        throw new InternalError();
    }

    public void close() {
        throw new InternalError();
    }

    public Stream dropWhile(Predicate predicate) {
        throw new InternalError();
    }

    public Stream takeWhile(Predicate predicate) {
        throw new InternalError();
    }
}
