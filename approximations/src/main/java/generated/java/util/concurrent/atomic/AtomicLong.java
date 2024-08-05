package generated.java.util.concurrent.atomic;

import java.io.Serial;
import java.io.Serializable;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.util.concurrent.atomic.AtomicLong.class)
public class AtomicLong implements Serializable {

    @Serial
    private static final long serialVersionUID = 1927816293512124184L;

    static {
        Engine.assume(true);
    }

    private volatile long value;

    public AtomicLong(long initialValue) {
        this.value = initialValue;
    }

    public AtomicLong() {
        this(0L);
    }

    public final long accumulateAndGet(long x, LongBinaryOperator accumulatorFunction) {
        long result = accumulatorFunction.applyAsLong(this.value, x);
        this.value = result;

        return result;
    }

    public final long addAndGet(long delta) {
        long result = this.value + delta;
        this.value = result;

        return result;
    }

    public byte byteValue() {
        return (byte) this.value;
    }

    public final long compareAndExchange(long expectedValue, long newValue) {
        long result = this.value;
        if (result == expectedValue)
            this.value = newValue;

        return result;
    }

    public final long compareAndExchangeAcquire(long expectedValue, long newValue) {
        return compareAndExchange(expectedValue, newValue);
    }

    public final long compareAndExchangeRelease(long expectedValue, long newValue) {
        return compareAndExchange(expectedValue, newValue);
    }

    public final boolean compareAndSet(long expectedValue, long newValue) {
        boolean result = this.value == expectedValue;
        if (result)
            this.value = newValue;

        return result;
    }

    public final long decrementAndGet() {
        long result = this.value - 1L;
        this.value = result;

        return result;
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public final long get() {
        return this.value;
    }

    public final long getAcquire() {
        return this.value;
    }

    public final long getAndAccumulate(long x, LongBinaryOperator accumulatorFunction) {
        long result = this.value;
        this.value = accumulatorFunction.applyAsLong(result, x);

        return result;
    }

    public final long getAndAdd(long delta) {
        long result = this.value;
        this.value = result + delta;

        return result;
    }

    public final long getAndDecrement() {
        long result = this.value;
        this.value = result - 1L;

        return result;
    }

    public final long getAndIncrement() {
        long result = this.value;
        this.value = result + 1L;

        return result;
    }

    public final long getAndSet(long newValue) {
        long result = this.value;
        this.value = newValue;

        return result;
    }

    public final long getAndUpdate(LongUnaryOperator updateFunction) {
        long result = this.value;
        this.value = updateFunction.applyAsLong(result);

        return result;
    }

    public final long getOpaque() {
        return this.value;
    }

    public final long getPlain() {
        return this.value;
    }

    public final long incrementAndGet() {
        long result = this.value + 1L;
        this.value = result;

        return result;
    }

    public int intValue() {
        return (int) this.value;
    }

    public long longValue() {
        return this.value;
    }

    public final void set(long newValue) {
        this.value = newValue;
    }

    public final void lazySet(long newValue) {
        set(newValue);
    }

    public final void setOpaque(long newValue) {
        set(newValue);
    }

    public final void setPlain(long newValue) {
        set(newValue);
    }

    public final void setRelease(long newValue) {
        set(newValue);
    }

    public short shortValue() {
        return (short) this.value;
    }

    public String toString() {
        return LibSLRuntime.toString(this.value);
    }

    public final long updateAndGet(LongUnaryOperator updateFunction) {
        long result = updateFunction.applyAsLong(this.value);
        this.value = result;

        return result;
    }

    public final boolean weakCompareAndSet(long expectedValue, long newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetAcquire(long expectedValue, long newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetPlain(long expectedValue, long newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetRelease(long expectedValue, long newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetVolatile(long expectedValue, long newValue) {
        return compareAndSet(expectedValue, newValue);
    }
}
