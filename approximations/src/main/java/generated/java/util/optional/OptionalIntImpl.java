package generated.java.util.optional;

import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.lang.String;
import java.util.NoSuchElementException;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import generated.java.util.stream.IntStreamImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.util.OptionalInt.class)
public final class OptionalIntImpl {

    private static final OptionalIntImpl EMPTY = new OptionalIntImpl(0, false);

    static {
        Engine.assume(true);
    }

    public int value;

    public boolean isPresent;

    public OptionalIntImpl(int value, boolean isPresent) {
        this.value = value;
        this.isPresent = isPresent;
    }

    private OptionalIntImpl() {
        LibSLRuntime.error("Private constructor call");
    }

    private OptionalIntImpl(int x) {
        LibSLRuntime.error("Private constructor call");
    }

    public static OptionalIntImpl empty() {
        return EMPTY;
    }

    public static OptionalIntImpl of(int x) {
        return new OptionalIntImpl(x, true);
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (Engine.typeIs(other, OptionalIntImpl.class)) {
            OptionalIntImpl otherOptional = (OptionalIntImpl) other;
            int otherValue = otherOptional.value;
            boolean otherPresent = otherOptional.isPresent;
            if (this.isPresent && otherPresent)
                return this.value == otherValue;

            return this.isPresent == otherPresent;
        }

        return false;
    }

    public int getAsInt() {
        if (!this.isPresent)
            throw new NoSuchElementException("No value present");

        return this.value;
    }

    public int hashCode() {
        if (this.isPresent)
            return LibSLRuntime.hashCode(this.value);

        return 0;
    }

    public void ifPresent(IntConsumer consumer) {
        if (!this.isPresent)
            return;

        if (consumer == null)
            throw new NullPointerException();

        consumer.accept(this.value);
    }

    public void ifPresentOrElse(IntConsumer consumer, Runnable emptyAction) {
        if (this.isPresent) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            consumer.accept(this.value);
            return;
        }

        if (emptyAction == null) {
            throw new NullPointerException();
        }
        emptyAction.run();
    }

    public boolean isEmpty() {
        return !this.isPresent;
    }

    public boolean isPresent() {
        return this.isPresent;
    }

    public int orElse(int other) {
        if (this.isPresent)
            return this.value;

        return other;
    }

    public int orElseGet(IntSupplier supplier) {
        if (this.isPresent)
            return this.value;

        return supplier.getAsInt();
    }

    public int orElseThrow() {
        if (!this.isPresent)
            throw new NoSuchElementException("No value present");

        return this.value;
    }

    public int orElseThrow(Supplier<? extends Throwable> exceptionSupplier) throws Throwable {
        if (exceptionSupplier == null)
            throw new NullPointerException();

        if (!this.isPresent)
            throw exceptionSupplier.get();

        return this.value;
    }

    public IntStream stream() {
        int[] items;
        if (this.isPresent) {
            items = new int[1];
            items[0] = this.value;
        } else {
            items = new int[0];
        }
        return new IntStreamImpl(items);
    }

    public String toString() {
        if (this.isPresent) {
            String valueStr = LibSLRuntime.toString(this.value);
            return "OptionalInt[".concat(valueStr).concat("]");
        }

        return "OptionalInt.empty";
    }
}
