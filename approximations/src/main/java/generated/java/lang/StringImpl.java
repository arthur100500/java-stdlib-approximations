package generated.java.lang;

import java.io.Serializable;
import java.lang.Object;
import java.lang.StringIndexOutOfBoundsException;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.lang.String.class)
public class StringImpl implements Serializable {

    @java.io.Serial
    private static final long serialVersionUID = -6849794470754667710L;

    private static final int STRING_LENGTH_MAX = 50;

    public byte[] value;

    public int length;

    public StringImpl(byte[] value, int length) {
        this.value = value;
        this.length = length;
    }

    public StringImpl() {
        this(new byte[0], 0);
    }

    public StringImpl(StringImpl original) {
        this(original.value, original.length);
    }

    public StringImpl(byte[] bytes) {
        int len = bytes.length;
        this.length = len;
        this.value = new byte[len];
        LibSLRuntime.ArrayActions.copy(bytes, 0, this.value, 0, len);
    }

    public static java.lang.String copyValueOf(char[] data) {
        return LibSLRuntime.toString(data);
    }

    public static java.lang.String copyValueOf(char[] data, int offset, int count) {
        char[] segment = new char[count];
        LibSLRuntime.ArrayActions.copy(data, offset, segment, 0, count);
        return LibSLRuntime.toString(segment);
    }

    public static java.lang.String valueOf(Object x) {
        return LibSLRuntime.toString(x);
    }

    public static java.lang.String valueOf(boolean x) {
        return LibSLRuntime.toString(x);
    }

    public static java.lang.String valueOf(char x) {
        return LibSLRuntime.toString(x);
    }

    public static java.lang.String valueOf(char[] data) {
        return LibSLRuntime.toString(data);
    }

    public static java.lang.String valueOf(char[] data, int offset, int count) {
        char[] segment = new char[count];
        LibSLRuntime.ArrayActions.copy(data, offset, segment, 0, count);
        return LibSLRuntime.toString(segment);
    }

    public static java.lang.String valueOf(double x) {
        return LibSLRuntime.toString(x);
    }

    public static java.lang.String valueOf(float x) {
        return LibSLRuntime.toString(x);
    }

    public static java.lang.String valueOf(int x) {
        return LibSLRuntime.toString(x);
    }

    public static java.lang.String valueOf(long x) {
        return LibSLRuntime.toString(x);
    }

    @SuppressWarnings("DataFlowIssue")
    public StringImpl concat(StringImpl str) {
        Engine.assume(this.value != null);
        Engine.assume(this.value.length <= STRING_LENGTH_MAX);
        Engine.assume(this.length == this.value.length);
        byte[] otherVal = str.value;
        int otherLen = otherVal.length;
        if (otherLen == 0)
            return this;

        int newLength = this.length + otherLen;
        byte[] newValue = new byte[newLength];
        LibSLRuntime.ArrayActions.copy(this.value, 0, newValue, 0, this.length);
        LibSLRuntime.ArrayActions.copy(otherVal, 0, newValue, this.length, otherLen);
        return new StringImpl(newValue, newLength);
    }

    @SuppressWarnings("DataFlowIssue")
    public byte[] getBytes() {
        Engine.assume(this.value != null);
        Engine.assume(this.value.length <= STRING_LENGTH_MAX);
        Engine.assume(this.length == this.value.length);
        return this.value;
    }

    @SuppressWarnings("DataFlowIssue")
    public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
        if (srcBegin < 0)
            throw new StringIndexOutOfBoundsException(srcBegin);
        if (this.length < srcEnd)
            throw new StringIndexOutOfBoundsException(srcEnd);
        int count = srcEnd - srcBegin;
        if (count < 0)
            throw new StringIndexOutOfBoundsException(count);
        Engine.assume(this.value != null);
        Engine.assume(this.value.length <= STRING_LENGTH_MAX);
        Engine.assume(this.length == this.value.length);
        LibSLRuntime.ArrayActions.copy(this.value, srcBegin, dst, dstBegin, count);
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int length() {
        return this.length;
    }
}
