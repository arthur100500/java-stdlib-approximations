// Generated by the LibSL translator.  DO NOT EDIT!
// source: ?
//
package generated.java.util.concurrent.atomic;

import java.io.Serializable;
import java.lang.String;
import java.lang.Void;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

/**
 * AtomicIntegerAutomaton for LSLAtomicInteger ~> java.util.concurrent.atomic.AtomicInteger
 */
@Approximate(java.util.concurrent.atomic.AtomicInteger.class)
public class AtomicInteger implements LibSLRuntime.Automaton, Serializable {
    private static final long serialVersionUID = 6214790243416807050L;

    static {
        Engine.assume(true);
    }

    private byte __$lsl_state = __$lsl_States.Allocated;

    private volatile int value;

    @LibSLRuntime.AutomatonConstructor
    public AtomicInteger(Void __$lsl_token, final byte p0, final int p1) {
        this.__$lsl_state = p0;
        this.value = p1;
    }

    @LibSLRuntime.AutomatonConstructor
    public AtomicInteger(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Allocated, 0);
    }

    /**
     * [CONSTRUCTOR] AtomicIntegerAutomaton::LSLAtomicInteger(LSLAtomicInteger) -> LSLAtomicInteger
     */
    public AtomicInteger() {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            this.value = 0;
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] AtomicIntegerAutomaton::LSLAtomicInteger(LSLAtomicInteger, int) -> LSLAtomicInteger
     */
    public AtomicInteger(int initialValue) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            this.value = initialValue;
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::accumulateAndGet(LSLAtomicInteger, int, IntBinaryOperator) -> int
     */
    public final int accumulateAndGet(int x, IntBinaryOperator accumulatorFunction) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = accumulatorFunction.applyAsInt(this.value, x);
            this.value = result;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::addAndGet(LSLAtomicInteger, int) -> int
     */
    public final int addAndGet(int delta) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value + delta;
            this.value = result;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::byteValue(LSLAtomicInteger) -> byte
     */
    public byte byteValue() {
        byte result = ((byte) 0);
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((byte) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::compareAndExchange(LSLAtomicInteger, int, int) -> int
     */
    public final int compareAndExchange(int expectedValue, int newValue) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
            if (result == expectedValue) {
                this.value = newValue;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::compareAndExchangeAcquire(LSLAtomicInteger, int, int) -> int
     */
    public final int compareAndExchangeAcquire(int expectedValue, int newValue) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
            if (result == expectedValue) {
                this.value = newValue;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::compareAndExchangeRelease(LSLAtomicInteger, int, int) -> int
     */
    public final int compareAndExchangeRelease(int expectedValue, int newValue) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
            if (result == expectedValue) {
                this.value = newValue;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::compareAndSet(LSLAtomicInteger, int, int) -> boolean
     */
    public final boolean compareAndSet(int expectedValue, int newValue) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value == expectedValue;
            if (result) {
                this.value = newValue;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::decrementAndGet(LSLAtomicInteger) -> int
     */
    public final int decrementAndGet() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value - 1;
            this.value = result;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::doubleValue(LSLAtomicInteger) -> double
     */
    public double doubleValue() {
        double result = 0.0d;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((double) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::floatValue(LSLAtomicInteger) -> float
     */
    public float floatValue() {
        float result = 0.0f;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((float) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::get(LSLAtomicInteger) -> int
     */
    public final int get() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::getAcquire(LSLAtomicInteger) -> int
     */
    public final int getAcquire() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::getAndAccumulate(LSLAtomicInteger, int, IntBinaryOperator) -> int
     */
    public final int getAndAccumulate(int x, IntBinaryOperator accumulatorFunction) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
            this.value = accumulatorFunction.applyAsInt(result, x);
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::getAndAdd(LSLAtomicInteger, int) -> int
     */
    public final int getAndAdd(int delta) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
            this.value = result + delta;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::getAndDecrement(LSLAtomicInteger) -> int
     */
    public final int getAndDecrement() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
            this.value = result - 1;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::getAndIncrement(LSLAtomicInteger) -> int
     */
    public final int getAndIncrement() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
            this.value = result + 1;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::getAndSet(LSLAtomicInteger, int) -> int
     */
    public final int getAndSet(int newValue) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
            this.value = newValue;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::getAndUpdate(LSLAtomicInteger, IntUnaryOperator) -> int
     */
    public final int getAndUpdate(IntUnaryOperator updateFunction) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
            this.value = updateFunction.applyAsInt(result);
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::getOpaque(LSLAtomicInteger) -> int
     */
    public final int getOpaque() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::getPlain(LSLAtomicInteger) -> int
     */
    public final int getPlain() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::incrementAndGet(LSLAtomicInteger) -> int
     */
    public final int incrementAndGet() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value + 1;
            this.value = result;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::intValue(LSLAtomicInteger) -> int
     */
    public int intValue() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::lazySet(LSLAtomicInteger, int) -> void
     */
    public final void lazySet(int newValue) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            this.value = newValue;
        }
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::longValue(LSLAtomicInteger) -> long
     */
    public long longValue() {
        long result = 0L;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((long) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::set(LSLAtomicInteger, int) -> void
     */
    public final void set(int newValue) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            this.value = newValue;
        }
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::setOpaque(LSLAtomicInteger, int) -> void
     */
    public final void setOpaque(int newValue) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            this.value = newValue;
        }
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::setPlain(LSLAtomicInteger, int) -> void
     */
    public final void setPlain(int newValue) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            this.value = newValue;
        }
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::setRelease(LSLAtomicInteger, int) -> void
     */
    public final void setRelease(int newValue) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            this.value = newValue;
        }
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::shortValue(LSLAtomicInteger) -> short
     */
    public short shortValue() {
        short result = ((short) 0);
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((short) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::toString(LSLAtomicInteger) -> String
     */
    public String toString() {
        String result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = LibSLRuntime.toString(this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::updateAndGet(LSLAtomicInteger, IntUnaryOperator) -> int
     */
    public final int updateAndGet(IntUnaryOperator updateFunction) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = updateFunction.applyAsInt(this.value);
            this.value = result;
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::weakCompareAndSet(LSLAtomicInteger, int, int) -> boolean
     */
    public final boolean weakCompareAndSet(int expectedValue, int newValue) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value == expectedValue;
            if (result) {
                this.value = newValue;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::weakCompareAndSetAcquire(LSLAtomicInteger, int, int) -> boolean
     */
    public final boolean weakCompareAndSetAcquire(int expectedValue, int newValue) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value == expectedValue;
            if (result) {
                this.value = newValue;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::weakCompareAndSetPlain(LSLAtomicInteger, int, int) -> boolean
     */
    public final boolean weakCompareAndSetPlain(int expectedValue, int newValue) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value == expectedValue;
            if (result) {
                this.value = newValue;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::weakCompareAndSetRelease(LSLAtomicInteger, int, int) -> boolean
     */
    public final boolean weakCompareAndSetRelease(int expectedValue, int newValue) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value == expectedValue;
            if (result) {
                this.value = newValue;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] AtomicIntegerAutomaton::weakCompareAndSetVolatile(LSLAtomicInteger, int, int) -> boolean
     */
    public final boolean weakCompareAndSetVolatile(int expectedValue, int newValue) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value == expectedValue;
            if (result) {
                this.value = newValue;
            }
        }
        return result;
    }

    public static final class __$lsl_States {
        public static final byte Allocated = (byte) 0;

        public static final byte Initialized = (byte) 1;
    }

    @Approximate(AtomicInteger.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}