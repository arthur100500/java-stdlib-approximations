package generated.java.util.optional;

import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Runnable;
import java.lang.String;
import java.util.NoSuchElementException;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

import generated.java.util.stream.DoubleStreamImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.util.OptionalDouble.class)
public final class OptionalDoubleImpl {

    private static final OptionalDoubleImpl EMPTY = new OptionalDoubleImpl(0.0d, false);

    static {
        Engine.assume(true);
    }

    public double value;

    public boolean isPresent;

    public OptionalDoubleImpl(double value, boolean isPresent) {
        this.value = value;
        this.isPresent = isPresent;
    }

    private OptionalDoubleImpl() {
        LibSLRuntime.error("Private constructor call");
    }

    private OptionalDoubleImpl(double x) {
        LibSLRuntime.error("Private constructor call");
    }

    public static OptionalDoubleImpl empty() {
        return EMPTY;
    }

    public static OptionalDoubleImpl of(double x) {
        return new OptionalDoubleImpl(x, true);
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (Engine.typeIs(other, OptionalDoubleImpl.class)) {
            OptionalDoubleImpl otherOptional = (OptionalDoubleImpl) other;
            double otherValue = otherOptional.value;
            boolean otherPresent = otherOptional.isPresent;
            if (this.isPresent && otherPresent)
                return LibSLRuntime.equals(this.value, otherValue);

            return this.isPresent == otherPresent;
        }

        return false;
    }

    public double getAsDouble() {
        if (!this.isPresent)
            throw new NoSuchElementException("No value present");

        return this.value;
    }

    public int hashCode() {
        if (this.isPresent)
            return LibSLRuntime.hashCode(this.value);

        return 0;
    }

    public void ifPresent(DoubleConsumer consumer) {
        if (!this.isPresent)
            return;

        if (consumer == null)
            throw new NullPointerException();

        consumer.accept(this.value);
    }

    public void ifPresentOrElse(DoubleConsumer consumer, Runnable emptyAction) {
        if (this.isPresent) {
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
        return !this.isPresent;
    }

    public boolean isPresent() {
        return this.isPresent;
    }

    public double orElse(double other) {
        if (this.isPresent)
            return this.value;

        return other;
    }

    public double orElseGet(DoubleSupplier supplier) {
        if (this.isPresent)
            return this.value;

        return supplier.getAsDouble();
    }

    public double orElseThrow() {
        if (!this.isPresent)
            throw new NoSuchElementException("No value present");

        return this.value;
    }

    public double orElseThrow(Supplier<? extends Throwable> exceptionSupplier) throws Throwable {
        if (exceptionSupplier == null)
            throw new NullPointerException();

        if (!this.isPresent)
            throw exceptionSupplier.get();

        return this.value;
    }

    public DoubleStream stream() {
        double[] items;
        if (this.isPresent) {
            items = new double[1];
            items[0] = this.value;
        } else {
            items = new double[0];
        }

        return new DoubleStreamImpl(items);
    }

    public String toString() {
        if (this.isPresent) {
            String valueStr = LibSLRuntime.toString(this.value);
            return "OptionalDouble[".concat(valueStr).concat("]");
        }

        return "OptionalDouble.empty";
    }
}
