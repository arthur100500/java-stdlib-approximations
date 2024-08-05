package generated.java.util.concurrent.atomic;

import java.io.Serial;
import java.io.Serializable;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.util.concurrent.atomic.AtomicReference.class)
public class AtomicReference implements Serializable {

    @Serial
    private static final long serialVersionUID = -1848883965231344442L;

    static {
        Engine.assume(true);
    }

    private transient volatile Object value;

    public AtomicReference(Object obj) {
        this.value = obj;
    }

    public AtomicReference() {
        this(null);
    }

    public final Object accumulateAndGet(Object x, BinaryOperator<Object> accumulatorFunction) {
        Object result = accumulatorFunction.apply(this.value, x);
        this.value = result;

        return result;
    }

    public final Object compareAndExchange(Object expectedValue, Object newValue) {
        Object result = this.value;
        if (result == expectedValue)
            this.value = newValue;

        return result;
    }

    public final Object compareAndExchangeAcquire(Object expectedValue, Object newValue) {
        return compareAndExchange(expectedValue, newValue);
    }

    public final Object compareAndExchangeRelease(Object expectedValue, Object newValue) {
        return compareAndExchange(expectedValue, newValue);
    }

    public final boolean compareAndSet(Object expectedValue, Object newValue) {
        boolean result = this.value == expectedValue;
        if (result)
            this.value = newValue;

        return result;
    }

    public final Object get() {
        return this.value;
    }

    public final Object getAcquire() {
        return this.value;
    }

    public final Object getAndAccumulate(Object x, BinaryOperator<Object> accumulatorFunction) {
        Object result = this.value;
        this.value = accumulatorFunction.apply(result, x);

        return result;
    }

    public final Object getAndSet(Object newValue) {
        Object result = this.value;
        this.value = newValue;

        return result;
    }

    public final Object getAndUpdate(UnaryOperator<Object> updateFunction) {
        Object result = this.value;
        this.value = updateFunction.apply(result);

        return result;
    }

    public final Object getOpaque() {
        return this.value;
    }

    public final Object getPlain() {
        return this.value;
    }

    public final void set(Object newValue) {
        this.value = newValue;
    }

    public final void lazySet(Object newValue) {
        this.value = newValue;
    }

    public final void setOpaque(Object newValue) {
        this.value = newValue;
    }

    public final void setPlain(Object newValue) {
        this.value = newValue;
    }

    public final void setRelease(Object newValue) {
        this.value = newValue;
    }

    public String toString() {
        return LibSLRuntime.toString(this.value);
    }

    public final Object updateAndGet(UnaryOperator<Object> updateFunction) {
        Object result = updateFunction.apply(this.value);
        this.value = result;

        return result;
    }

    public final boolean weakCompareAndSet(Object expectedValue, Object newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetAcquire(Object expectedValue, Object newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetPlain(Object expectedValue, Object newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetRelease(Object expectedValue, Object newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetVolatile(Object expectedValue, Object newValue) {
        return compareAndSet(expectedValue, newValue);
    }
}
