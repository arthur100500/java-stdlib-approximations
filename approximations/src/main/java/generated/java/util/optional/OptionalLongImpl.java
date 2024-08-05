package generated.java.util.optional;

import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.lang.String;
import java.util.NoSuchElementException;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.LongStream;

import generated.java.util.stream.LongStreamImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.util.OptionalLong.class)
public final class OptionalLongImpl {
    private static final OptionalLongImpl EMPTY = new OptionalLongImpl(0, false);

    static {
        Engine.assume(true);
    }

    public long value;

    public boolean isPresent;

    public OptionalLongImpl(long value, boolean isPresent) {
        this.value = value;
        this.isPresent = isPresent;
    }

    private OptionalLongImpl() {
        LibSLRuntime.error("Private constructor call");
    }

    private OptionalLongImpl(long x) {
        LibSLRuntime.error("Private constructor call");
    }

    public static OptionalLongImpl empty() {
        return EMPTY;
    }

    public static OptionalLongImpl of(long x) {
        return new OptionalLongImpl(x);
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (Engine.typeIs(other, OptionalLongImpl.class)) {
            OptionalLongImpl otherOptional = (OptionalLongImpl) other;
            long otherValue = otherOptional.value;
            boolean otherPresent = otherOptional.isPresent;
            if (this.isPresent && otherPresent)
                return this.value == otherValue;

            return this.isPresent == otherPresent;
        }

        return false;
    }

    public long getAsLong() {
        if (!this.isPresent)
            throw new NoSuchElementException("No value present");

        return this.value;
    }

    public int hashCode() {
        if (this.isPresent)
            return LibSLRuntime.hashCode(this.value);

        return 0;
    }

    public void ifPresent(LongConsumer consumer) {
        if (!this.isPresent)
            return;

        if (consumer == null)
            throw new NullPointerException();

        consumer.accept(this.value);
    }

    public void ifPresentOrElse(LongConsumer consumer, Runnable emptyAction) {
        if (this.isPresent) {
            if (consumer == null)
                throw new NullPointerException();

            consumer.accept(this.value);
        } else {
            if (emptyAction == null)
                throw new NullPointerException();

            emptyAction.run();
        }
    }

    public boolean isEmpty() {
        return !this.isPresent;
    }

    public boolean isPresent() {
        return this.isPresent;
    }

    public long orElse(long other) {
        if (this.isPresent)
            return this.value;

        return other;
    }

    public long orElseGet(LongSupplier supplier) {
        if (this.isPresent)
            return this.value;

        return supplier.getAsLong();
    }

    public long orElseThrow() {
        if (!this.isPresent)
            throw new NoSuchElementException("No value present");

        return this.value;
    }

    public long orElseThrow(Supplier<? extends Throwable> exceptionSupplier) throws Throwable {
        if (exceptionSupplier == null)
            throw new NullPointerException();

        if (!this.isPresent)
            throw exceptionSupplier.get();

        return this.value;
    }

    public LongStream stream() {
        long[] items;
        if (this.isPresent) {
            items = new long[1];
            items[0] = this.value;
        } else {
            items = new long[0];
        }

        return new LongStreamImpl(items);
    }

    public String toString() {
        if (this.isPresent) {
            String valueStr = LibSLRuntime.toString(this.value);
            return "OptionalLong[".concat(valueStr).concat("]");
        }

        return "OptionalLong.empty";
    }
}
