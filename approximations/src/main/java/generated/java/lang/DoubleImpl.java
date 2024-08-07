package generated.java.lang;

import java.io.Serial;
import java.io.Serializable;
import java.lang.Comparable;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.lang.Double.class)
public final class DoubleImpl implements Comparable<DoubleImpl>, Serializable {

    @Serial
    private static final long serialVersionUID = -9172774392245257468L;

    public static final int BYTES = 8;

    public static final int SIZE = 64;

    public static final int MAX_EXPONENT = 1023;

    public static final int MIN_EXPONENT = -1022;

    public static final double MAX_VALUE = 1.7976931348623157E308d;

    public static final double MIN_VALUE = 4.9E-324d;

    public static final double MIN_NORMAL = 2.2250738585072014E-308d;

    @SuppressWarnings({"divzero", "NumericOverflow"})
    public static final double POSITIVE_INFINITY = 1.0d / 0.0d;

    @SuppressWarnings({"divzero", "NumericOverflow"})
    public static final double NEGATIVE_INFINITY = -1.0d / 0.0d;

    @SuppressWarnings("divzero")
    public static final double NaN = 0.0d / 0.0d;

    static {
        Engine.assume(true);
    }

    public double value;

    public DoubleImpl(double value) {
        this.value = value;
    }

    private static boolean _isNan(double d) {
        return d != d;
    }

    private static long _getRawBits(double v) {
        if (_isNan(v))
            return 9221120237041090560L;

        if (1.0d / v == NEGATIVE_INFINITY)
            return -9223372036854775808L;

        if (v == 0.0d)
            return 0L;

        if (v == POSITIVE_INFINITY)
            return 9218868437227405312L;

        if (v == NEGATIVE_INFINITY)
            return -4503599627370496L;

        long result = Engine.makeSymbolicLong();
        Engine.assume(result != 9221120237041090560L);
        Engine.assume(result != -9223372036854775808L);
        Engine.assume(result != 0L);
        Engine.assume(result != 9218868437227405312L);
        Engine.assume(result != -4503599627370496L);
        if (v < 0.0d) {
            Engine.assume(result < 0L);
        } else {
            Engine.assume(result > 0L);
        }

        return result;
    }

    private static double _parse(String str) throws java.lang.NumberFormatException {
        if (str == null) {
            throw new NullPointerException();
        }

        LibSLRuntime.todo();
        return 0.0d;
    }

    public static int compare(double a, double b) {
        if (a == b || _isNan(a) || _isNan(b))
            return 0;

        if (a < b)
            return -1;

        return 1;
    }

    public static long doubleToLongBits(double value) {
        return _getRawBits(value);
    }

    public static long doubleToRawLongBits(double value) {
        return _getRawBits(value);
    }

    public static int hashCode(double value) {
        return (int) _getRawBits(value);
    }

    public static boolean isFinite(double d) {
        if (d <= 0.0d)
            d = 0.0d - d;
        return d <= MAX_VALUE;
    }

    public static boolean isInfinite(double v) {
        return (v == POSITIVE_INFINITY) || (v == NEGATIVE_INFINITY);
    }

    public static boolean isNaN(double v) {
        return _isNan(v);
    }

    public static double longBitsToDouble(long value) {
        if (value == 9221120237041090560L)
            return NaN;

        if (value == -9223372036854775808L)
            return -0.0d;

        if (value == 0L)
            return 0.0d;

        if (value == 9218868437227405312L)
            return POSITIVE_INFINITY;

        if (value == -4503599627370496L)
            return NEGATIVE_INFINITY;

        double result = Engine.makeSymbolicDouble();
        Engine.assume(result != 0.0d);
        Engine.assume(result == result);
        Engine.assume(result != POSITIVE_INFINITY);
        Engine.assume(result != NEGATIVE_INFINITY);
        if (value < 0L) {
            Engine.assume(result < 0.0d);
        } else {
            Engine.assume(result > 0.0d);
        }
        return result;
    }

    @SuppressWarnings("ManualMinMaxCalculation")
    public static double max(double a, double b) {
        if (_isNan(a))
            return a;

        if (a == 0.0d && b == 0.0d && (1.0d / a) == NEGATIVE_INFINITY)
            return b;

        if (a >= b)
            return a;

        return b;
    }

    @SuppressWarnings("ManualMinMaxCalculation")
    public static double min(double a, double b) {
        if (_isNan(a))
            return a;

        if (a == 0.0d && b == 0.0d && (1.0d / b) == NEGATIVE_INFINITY)
            return b;

        if (a <= b)
            return a;

        return b;
    }

    public static double sum(double a, double b) {
        return a + b;
    }

    @SuppressWarnings({"ConstantValue", "DataFlowIssue"})
    public static String toHexString(double d) {
        if (_isNan(d))
            return "NaN";

        if (d == POSITIVE_INFINITY)
            return "Infinity";

        if (d == NEGATIVE_INFINITY)
            return "-Infinity";

        if ((1.0d / d) == NEGATIVE_INFINITY)
            return "-0x0.0p0";

        if (d == 0.0f)
            return "0x0.0p0";

        if (d == 1.0f)
            return "0x1.0p0";

        if (d == -1.0f)
            return "-0x1.0p0";

        String result = Engine.makeSymbolic(String.class);
        Engine.assume(result != null);
        int len = result.length();
        Engine.assume(len >= 7);
        Engine.assume(len <= 22);
        return result;
    }

    public static String toString(double d) {
        return LibSLRuntime.toString(d);
    }

    public static DoubleImpl valueOf(double d) {
        return new DoubleImpl(d);
    }

    public byte byteValue() {
        return (byte) this.value;
    }

    public int compareTo(DoubleImpl anotherDoubleImpl) {
        return compare(this.value, anotherDoubleImpl.value);
    }

    public double doubleValue() {
        return this.value;
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object obj) {
        if (Engine.typeIs(obj, DoubleImpl.class))
            return this.value == ((DoubleImpl) obj).value;

        return false;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public int hashCode() {
        return (int) _getRawBits(this.value);
    }

    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return isInfinite(this.value);
    }

    public boolean isNaN() {
        return isNaN(this.value);
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
