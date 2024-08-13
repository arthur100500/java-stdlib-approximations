package generated.java.util.concurrent.atomic;

import java.io.Serial;
import java.io.Serializable;
import java.lang.String;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

@SuppressWarnings("unused")
@Approximate(java.util.concurrent.atomic.AtomicBoolean.class)
public class AtomicBooleanImpl implements Serializable {

    @Serial
    private static final long serialVersionUID = 4654671469794556979L;

    private static final int FALSE = 0;

    private static final int TRUE = 1;

    static {
        Engine.assume(true);
    }

    private volatile int value;

    public AtomicBooleanImpl(int value) {
        this.value = value;
    }

    public AtomicBooleanImpl() {
        this(FALSE);
    }

    private static int _valueFromBool(boolean value) {
        return value ? TRUE : FALSE;
    }

    public AtomicBooleanImpl(boolean initialValue) {
        this(_valueFromBool(initialValue));
    }

    public final boolean compareAndExchange(boolean expectedValue, boolean newValue) {
        boolean result = get();
        if (result == expectedValue)
            set(newValue);

        return result;
    }

    public final boolean compareAndExchangeAcquire(boolean expectedValue, boolean newValue) {
        return compareAndExchange(expectedValue, newValue);
    }

    public final boolean compareAndExchangeRelease(boolean expectedValue, boolean newValue) {
        return compareAndExchange(expectedValue, newValue);
    }

    public final boolean compareAndSet(boolean expectedValue, boolean newValue) {
        boolean currentValue = get();
        if (currentValue != expectedValue)
            return false;

        set(newValue);
        return true;
    }

    public final boolean get() {
        return this.value != FALSE;
    }

    public final boolean getAcquire() {
        return get();
    }

    public final boolean getAndSet(boolean newValue) {
        boolean result = get();
        set(newValue);

        return result;
    }

    public final boolean getOpaque() {
        return get();
    }

    public final boolean getPlain() {
        return get();
    }

    public final void set(boolean newValue) {
        this.value = _valueFromBool(newValue);
    }

    public final void lazySet(boolean newValue) {
        set(newValue);
    }

    public final void setOpaque(boolean newValue) {
        set(newValue);
    }

    public final void setPlain(boolean newValue) {
        set(newValue);
    }

    public final void setRelease(boolean newValue) {
        set(newValue);
    }

    public String toString() {
        if (this.value == TRUE)
            return "true";

        return "false";
    }

    public boolean weakCompareAndSet(boolean expectedValue, boolean newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetAcquire(boolean expectedValue, boolean newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public boolean weakCompareAndSetPlain(boolean expectedValue, boolean newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetRelease(boolean expectedValue, boolean newValue) {
        return compareAndSet(expectedValue, newValue);
    }

    public final boolean weakCompareAndSetVolatile(boolean expectedValue, boolean newValue) {
        return compareAndSet(expectedValue, newValue);
    }
}
