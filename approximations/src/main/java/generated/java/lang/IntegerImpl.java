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
@Approximate(java.lang.Integer.class)
public final class IntegerImpl implements Comparable<IntegerImpl>, Serializable {

    @Serial
    private static final long serialVersionUID = 1360826667806852920L;

    public static final int MIN_VALUE = -2147483648;

    public static final int MAX_VALUE = 2147483647;

    public static final int SIZE = 32;

    public static final int BYTES = 4;

    public static final char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    public static final char[] DigitTens = { '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9' };

    public static final char[] DigitOnes = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public static final int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 2147483647 };

    static {
        Engine.assume(true);
    }

    private final int value;

    public IntegerImpl(int value) {
        this.value = value;
    }

    private static int _parse(String str) throws java.lang.NumberFormatException {
        if (str == null)
            throw new NullPointerException();
        LibSLRuntime.todo();
        return 0;
    }

    public static int bitCount(int i) {
        i = i - ((i >>> 1) & 1431655765);
        i = (i & 858993459) + ((i >>> 2) & 858993459);
        i = (i + (i >>> 4)) & 252645135;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 63;
    }

    @SuppressWarnings("UseCompareMethod")
    public static int compare(int x, int y) {
        if (x == y)
            return 0;

        if (x < y)
            return -1;

        return 1;
    }

    public static int compareUnsigned(int x, int y) {
        x += MIN_VALUE;
        y += MIN_VALUE;
        return compare(x, y);
    }

    public static int divideUnsigned(int dividend, int divisor) {
        long unsignedDividend = ((long) dividend) & 4294967295L;
        long unsignedDivisor = ((long) divisor) & 4294967295L;
        return (int) (unsignedDividend / unsignedDivisor);
    }

    public static int hashCode(int value) {
        return value;
    }

    public static int highestOneBit(int i) {
        i |= i >> 1;
        i |= i >> 2;
        i |= i >> 4;
        i |= i >> 8;
        i |= i >> 16;
        return i - (i >>> 1);
    }

    public static int lowestOneBit(int i) {
        return i & -i;
    }

    @SuppressWarnings("ManualMinMaxCalculation")
    public static int max(int a, int b) {
        if (a > b)
            return a;

        return b;
    }

    @SuppressWarnings("ManualMinMaxCalculation")
    public static int min(int a, int b) {
        if (a < b)
            return a;

        return b;
    }

    public static int numberOfLeadingZeros(int i) {
        if (i == 0)
            return 32;

        int result = 1;
        if ((i >>> 16) == 0) {
            result += 16;
            i <<= 16;
        }
        if ((i >>> 24) == 0) {
            result += 8;
            i <<= 8;
        }
        if ((i >>> 28) == 0) {
            result += 4;
            i <<= 4;
        }
        if ((i >>> 30) == 0) {
            result += 2;
            i <<= 2;
        }
        result -= i >>> 31;

        return result;
    }

    public static int numberOfTrailingZeros(int i) {
        if (i == 0)
            return 32;

        int y;
        int result = 31;
        y = i << 16;
        if (y != 0) {
            result -= 16;
            i = y;
        }
        y = i << 8;
        if (y != 0) {
            result -= 8;
            i = y;
        }
        y = i << 4;
        if (y != 0) {
            result -= 4;
            i = y;
        }
        y = i << 2;
        if (y != 0) {
            result -= 2;
            i = y;
        }
        result -= (i << 1) >>> 31;

        return result;
    }

    public static int remainderUnsigned(int dividend, int divisor) {
        long unsignedDividend = ((long) dividend) & 4294967295L;
        long unsignedDivisor = ((long) divisor) & 4294967295L;
        return (int) (unsignedDividend % unsignedDivisor);
    }

    public static int reverse(int i) {
        i = (((i & 1431655765) << 1) | (i >>> 1)) & 1431655765;
        i = (((i & 858993459) << 2) | (i >>> 2)) & 858993459;
        i = (((i & 252645135) << 4) | (i >>> 4)) & 252645135;
        i = (i << 24) | ((i & 65280) << 8) | ((i >>> 8) & 65280) | (i >>> 24);
        return i;
    }

    public static int reverseBytes(int i) {
        return (i >>> 24) | ((i >> 8) & 65280) | ((i << 8) & 16711680) | (i << 24);
    }

    public static int rotateLeft(int i, int distance) {
        return (i << distance) | (i >>> -distance);
    }

    public static int rotateRight(int i, int distance) {
        return (i >>> distance) | (i << -distance);
    }

    public static int signum(int i) {
        return (i >> 31) | (-i >>> 31);
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static String toString(int i) {
        return LibSLRuntime.toString(i);
    }

    public static long toUnsignedLong(int x) {
        return ((long) x) & 4294967295L;
    }

    // TODO: intern values from -128 to 128
    public static IntegerImpl valueOf(int i) {
        return new IntegerImpl(i);
    }

    public byte byteValue() {
        return (byte) this.value;
    }

    public int compareTo(IntegerImpl anotherInteger) {
        return compare(this.value, anotherInteger.value);
    }

    public double doubleValue() {
        return this.value;
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object obj) {
        if (Engine.typeIs(obj, IntegerImpl.class))
            return this.value == ((IntegerImpl) obj).value;

        return false;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return this.value;
    }

    public short shortValue() {
        return (short) this.value;
    }

    public String toString() {
        return LibSLRuntime.toString(this.value);
    }
}
