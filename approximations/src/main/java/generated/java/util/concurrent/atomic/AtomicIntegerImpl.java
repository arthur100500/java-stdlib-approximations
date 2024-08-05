package generated.java.util.concurrent.atomic;

import java.io.Serial;
import java.io.Serializable;
import java.lang.String;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.util.concurrent.atomic.AtomicInteger.class)
public class AtomicIntegerImpl implements Serializable {

    @Serial
    private static final long serialVersionUID = 6214790243416807050L;

    static {
        Engine.assume(true);
    }

    private volatile int value;

    public AtomicIntegerImpl(int initialValue) {
        this.value = initialValue;
    }

    public AtomicIntegerImpl() {
        this(0);
    }

    public final int accumulateAndGet(int x, IntBinaryOperator accumulatorFunction) {
        int result = accumulatorFunction.applyAsInt(this.value, x);
        this.value = result;
        return result;
    }

    public final int addAndGet(int delta) {
        int result = this.value + delta;
        this.value = result;
        return result;
    }

    public byte byteValue() {
        return (byte) this.value;
    }

    public final int compareAndExchange(int expectedValue, int newValue) {
        int result = this.value;
        if (result == expectedValue)
            this.value = newValue;

        return result;
    }

    public final int compareAndExchangeAcquire(int expectedValue, int newValue) {
        return compareAndExchange(expectedValue, newValue);
    }

    public final int compareAndExchangeRelease(int expectedValue, int newValue) {
        return compareAndExchange(expectedValue, newValue);
    }

    public final boolean compareAndSet(int expectedValue, int newValue) {
        boolean result = this.value == expectedValue;
        if (result)
            this.value = newValue;

        return result;
    }

    public final int decrementAndGet() {
        int result = this.value - 1;
        this.value = result;
        return result;
    }

    public double doubleValue() {
        return this.value;
    }

    public float floatValue() {
        return this.value;
    }

    public final int get() {
        return this.value;
    }

    public final int getAcquire() {
        return this.value;
    }

    public final int getAndAccumulate(int x, IntBinaryOperator accumulatorFunction) {
        int result = this.value;
        this.value = accumulatorFunction.applyAsInt(result, x);
        return result;
    }

    public final int getAndAdd(int delta) {
        int result = this.value;
        this.value = result + delta;

        return result;
    }

    public final int getAndDecrement() {
        int result = this.value;
        this.value = result - 1;

        return result;
    }

    public final int getAndIncrement() {
        int result = this.value;
        this.value = result + 1;

        return result;
    }

    public final int getAndSet(int newValue) {
        int result = this.value;
        this.value = newValue;

        return result;
    }

    public final int getAndUpdate(IntUnaryOperator updateFunction) {
        int result = this.value;
        this.value = updateFunction.applyAsInt(result);

        return result;
    }

    public final int getOpaque() {
        return this.value;
    }

    public final int getPlain() {
        return this.value;
    }

    public final int incrementAndGet() {
        int result = this.value + 1;
        this.value = result;

        return result;
    }

    public int intValue() {
        return this.value;
    }

    public final void lazySet(int newValue) {
        this.value = newValue;
    }

    public long longValue() {
        return this.value;
    }

    public final void set(int newValue) {
        this.value = newValue;
    }

    public final void setOpaque(int newValue) {
        this.value = newValue;
    }

    public final void setPlain(int newValue) {
        this.value = newValue;
    }

    public final void setRelease(int newValue) {
        this.value = newValue;
    }

    public short shortValue() {
        return (short) this.value;
    }

    public String toString() {
        return LibSLRuntime.toString(this.value);
    }

    public final int updateAndGet(IntUnaryOperator updateFunction) {
        int result = updateFunction.applyAsInt(this.value);
        this.value = result;

        return result;
    }

    public final boolean weakCompareAndSet(int expectedValue, int newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetAcquire(int expectedValue, int newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetPlain(int expectedValue, int newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetRelease(int expectedValue, int newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetVolatile(int expectedValue, int newValue) {
        return compareAndSet(expectedValue, newValue);
    }
}
