package generated.java.util.optional;

import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.lang.String;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import generated.java.util.stream.StreamStubImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.util.Optional.class)
public final class OptionalImpl<T> {

    private static final OptionalImpl<?> EMPTY = new OptionalImpl<>(null);

    static {
        Engine.assume(true);
    }

    public T value;

    private OptionalImpl(T value) {
        this.value = value;
    }

    private OptionalImpl() {
        LibSLRuntime.error("Private constructor call");
    }

    @SuppressWarnings("unchecked")
    public static <T> OptionalImpl<T> empty() {
        return (OptionalImpl<T>) EMPTY;
    }

    public static <T> OptionalImpl<T> of(T obj) {
        return new OptionalImpl<>(obj);
    }

    public static <T> OptionalImpl<T> ofNullable(T obj) {
        if (obj == null)
            return empty();

        return new OptionalImpl<>(obj);
    }

    @SuppressWarnings({"unchecked", "EqualsWhichDoesntCheckParameterClass"})
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (Engine.typeIs(other, OptionalImpl.class)) {
            T otherValue = ((OptionalImpl<T>) other).value;
            return LibSLRuntime.equals(this.value, otherValue);
        }

        return false;
    }

    public OptionalImpl<T> filter(Predicate<? super T> predicate) {
        if (predicate == null)
            throw new NullPointerException();

        if (isEmpty())
            return this;

        if (predicate.test(this.value))
            return this;

        return empty();
    }

    @SuppressWarnings("unchecked")
    public <U> OptionalImpl<U> flatMap(Function<? super T, ? extends OptionalImpl<? extends U>> mapper) {
        if (mapper == null)
            throw new NullPointerException();

        if (isEmpty())
            return empty();

        OptionalImpl<U> result = (OptionalImpl<U>) mapper.apply(this.value);
        if (result == null)
            throw new NullPointerException();

        return result;
    }

    public T get() {
        if (isEmpty())
            throw new NoSuchElementException("No value present");

        return this.value;
    }

    public int hashCode() {
        return LibSLRuntime.hashCode(this.value);
    }

    public void ifPresent(Consumer<? super T> consumer) {
        if (isEmpty())
            return;

        if (consumer == null)
            throw new NullPointerException();

        consumer.accept(this.value);
    }

    public void ifPresentOrElse(Consumer<? super T> consumer, Runnable emptyAction) {
        if (isPresent()) {
            if (consumer == null)
                throw new NullPointerException();

            consumer.accept(this.value);
            return;
        }

        if (emptyAction == null)
            throw new NullPointerException();

        emptyAction.run();
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    public boolean isPresent() {
        return !isEmpty();
    }

    public <U> OptionalImpl<U> map(Function<? super T, ? extends U> mapper) {
        if (mapper == null)
            throw new NullPointerException();

        if (isEmpty())
            return empty();

        U mappedValue = mapper.apply(this.value);
        if (mappedValue == null)
            return empty();

        return new OptionalImpl<>(mappedValue);
    }

    @SuppressWarnings("unchecked")
    public OptionalImpl<T> or(Supplier<? extends OptionalImpl<? extends T>> supplier) {
        if (supplier == null)
            throw new NullPointerException();

        if (isPresent())
            return this;

        OptionalImpl<T> result = (OptionalImpl<T>) supplier.get();
        if (result == null)
            throw new NullPointerException();

        return result;
    }

    public T orElse(T other) {
        if (isEmpty())
            return other;

        return this.value;
    }

    public T orElseGet(Supplier<? extends T> supplier) {
        if (isEmpty())
            return supplier.get();

        return this.value;
    }

    public T orElseThrow() {
        if (isEmpty())
            throw new NoSuchElementException("No value present");

        return this.value;
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (isEmpty())
            throw exceptionSupplier.get();

        return this.value;
    }

    @SuppressWarnings("unchecked")
    public Stream<T> stream() {
        T[] items;
        if (isEmpty()) {
            items = (T[]) new Object[0];
        } else {
            items = (T[]) new Object[1];
            items[0] = this.value;
        }
        return new StreamStubImpl<>(items);
    }

    public String toString() {
        if (isEmpty())
            return "Optional.empty";

        String valueStr = LibSLRuntime.toString(this.value);
        return "Optional[".concat(valueStr).concat("]");
    }
}
