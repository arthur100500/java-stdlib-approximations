package generated.java.lang;

import java.io.Serial;
import java.io.Serializable;
import java.lang.Comparable;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.lang.Float.class)
public final class FloatImpl implements Comparable<FloatImpl>, Serializable {

    @Serial
    private static final long serialVersionUID = -2671257302660747028L;

    public static final int BYTES = 4;

    public static final int SIZE = 32;

    public static final int MAX_EXPONENT = 127;

    public static final int MIN_EXPONENT = -126;

    public static final float MAX_VALUE = 3.4028235E38f;

    public static final float MIN_VALUE = 1.4E-45f;

    public static final float MIN_NORMAL = 1.17549435E-38f;

    @SuppressWarnings({"NumericOverflow", "divzero"})
    public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;

    @SuppressWarnings({"divzero", "NumericOverflow"})
    public static final float POSITIVE_INFINITY = 1.0f / 0.0f;

    @SuppressWarnings("divzero")
    public static final float NaN = 0.0f / 0.0f;

    static {
        Engine.assume(true);
    }

    public float value;

    public FloatImpl(float value) {
        this.value = value;
    }

    public FloatImpl(double v) {
        this.value = ((float) v);
    }

    private static boolean _isNan(float f) {
        return f != f;
    }

    private static int _getRawBits(float v) {
        if (_isNan(v))
            return 2143289344;

        if (1.0f / v == NEGATIVE_INFINITY)
            return -2147483648;

        if (v == 0.0f)
            return 0;

        if (v == POSITIVE_INFINITY)
            return 2139095040;

        if (v == NEGATIVE_INFINITY)
            return -8388608;

        int result = Engine.makeSymbolicInt();
        Engine.assume(result != 2143289344);
        Engine.assume(result != -2147483648);
        Engine.assume(result != 0);
        Engine.assume(result != 2139095040);
        Engine.assume(result != -8388608);
        if (v < 0.0f) {
            Engine.assume(result < 0);
        } else {
            Engine.assume(result > 0);
        }
        return result;
    }

    private static float _parse(String str) throws java.lang.NumberFormatException {
        if (str == null) {
            throw new NullPointerException();
        }
        LibSLRuntime.todo();
        return 0.0f;
    }

    public static int compare(float a, float b) {
        if (a == b || _isNan(a) || _isNan(b))
            return 0;

        if (a < b)
            return -1;

        return 1;
    }

    public static int floatToIntBits(float value) {
        return _getRawBits(value);
    }

    public static int floatToRawIntBits(float value) {
        return _getRawBits(value);
    }

    public static int hashCode(float value) {
        return _getRawBits(value);
    }

    public static float intBitsToFloat(int value) {
        if (value == 2143289344)
            return NaN;

        if (value == -2147483648)
            return -0.0f;

        if (value == 0)
            return 0.0f;

        if (value == 2139095040)
            return POSITIVE_INFINITY;

        if (value == -8388608)
            return NEGATIVE_INFINITY;

        float result = Engine.makeSymbolicFloat();
        Engine.assume(result != 0.0f);
        Engine.assume(result == result);
        Engine.assume(result != POSITIVE_INFINITY);
        Engine.assume(result != NEGATIVE_INFINITY);
        if (value < 0) {
            Engine.assume(result < 0.0f);
        } else {
            Engine.assume(result > 0.0f);
        }
        return result;
    }

    public static boolean isFinite(float f) {
        if (f <= 0.0f)
            f = 0.0f - f;

        return f <= MAX_VALUE;
    }

    public static boolean isInfinite(float v) {
        return v == POSITIVE_INFINITY || v == NEGATIVE_INFINITY;
    }

    public static boolean isNaN(float v) {
        return _isNan(v);
    }

    @SuppressWarnings("ManualMinMaxCalculation")
    public static float max(float a, float b) {
        if (_isNan(a))
            return a;

        if (a == 0.0f && b == 0.0f && (1.0f / a) == NEGATIVE_INFINITY)
            return b;

        if (a >= b)
            return a;

        return b;
    }

    @SuppressWarnings("ManualMinMaxCalculation")
    public static float min(float a, float b) {
        if (_isNan(a))
            return a;

        if (a == 0.0f && b == 0.0f && (1.0f / b) == NEGATIVE_INFINITY)
            return b;

        if (a <= b)
            return a;

        return b;
    }

    public static float sum(float a, float b) {
        return a + b;
    }

    @SuppressWarnings({"ConstantValue", "DataFlowIssue"})
    public static String toHexString(float f) {
        if (f != f)
            return "NaN";

        if (f == POSITIVE_INFINITY)
            return "Infinity";

        if (f == NEGATIVE_INFINITY)
            return "-Infinity";

        if (1.0f / f == NEGATIVE_INFINITY)
            return "-0x0.0p0";

        if (f == 0.0f)
            return "0x0.0p0";

        if (f == 1.0f)
            return "0x1.0p0";

        if (f == -1.0f)
            return "-0x1.0p0";

        String result = Engine.makeSymbolic(String.class);
        Engine.assume(result != null);
        int len = result.length();
        Engine.assume(len >= 7);
        Engine.assume(len <= 14);
        return result;
    }

    public static String toString(float f) {
        return LibSLRuntime.toString(f);
    }

    public static FloatImpl valueOf(float f) {
        return new FloatImpl(f);
    }

    public byte byteValue() {
        return (byte) this.value;
    }

    public int compareTo(FloatImpl anotherFloatImpl) {
        return compare(this.value, anotherFloatImpl.value);
    }

    public double doubleValue() {
        return this.value;
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object obj) {
        if (Engine.typeIs(obj, FloatImpl.class))
            return this.value == ((FloatImpl) obj).value;

        return false;
    }

    public float floatValue() {
        return this.value;
    }

    public int hashCode() {
        return _getRawBits(this.value);
    }

    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return isInfinite(this.value);
    }

    public boolean isNaN() {
        return _isNan(this.value);
    }

    public long longValue() {
        return (long) this.value;
    }

    public short shortValue() {
        return (short) this.value;
    }

    public String toString() {
        return LibSLRuntime.toString(this.value);
    }
}
