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

    static final byte UTF16  = 1;

    // Enforce coder == UTF16
    static final boolean COMPACT_STRINGS = false;

    private final byte[] value;

    private final byte coder;

    public StringImpl(byte[] value, byte coder) {
        this.value = value;
        this.coder = coder;
    }

//    @SuppressWarnings("ConstantValue")
//    public StringImpl(char[] value, int offset, int count) {
//        if (value == null)
//            throw new NullPointerException();
//
//        int size = value.length;
//        if (length < 0 || offset < 0 || size < 0 || size > length - offset)
//            throw new IndexOutOfBoundsException();
//
//        char[] newValue = new char[count];
//        LibSLRuntime.ArrayActions.copy(value, offset, newValue, 0, count);
//    }

    public StringImpl() {
        this(new byte[0], UTF16);
    }

    public StringImpl(StringImpl original) {
        this(original.value, original.coder);
    }

    public StringImpl(byte[] bytes) {
        int len = bytes.length;
        this.value = new byte[len];
        this.coder = UTF16;
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
        byte[] otherVal = str.value;
        int otherLen = otherVal.length;
        if (otherLen == 0)
            return this;

        int newLength = this.value.length + otherLen;
        byte[] newValue = new byte[newLength];
        LibSLRuntime.ArrayActions.copy(this.value, 0, newValue, 0, this.value.length);
        LibSLRuntime.ArrayActions.copy(otherVal, 0, newValue, this.value.length, otherLen);
        return new StringImpl(newValue, UTF16);
    }

    @SuppressWarnings("DataFlowIssue")
    public byte[] getBytes() {
        Engine.assume(this.value != null);
        Engine.assume(this.value.length <= STRING_LENGTH_MAX);
        return this.value;
    }

    @SuppressWarnings("DataFlowIssue")
    public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
        if (srcBegin < 0)
            throw new StringIndexOutOfBoundsException(srcBegin);
        if (this.value.length < srcEnd)
            throw new StringIndexOutOfBoundsException(srcEnd);
        int count = srcEnd - srcBegin;
        if (count < 0)
            throw new StringIndexOutOfBoundsException(count);
        Engine.assume(this.value.length <= STRING_LENGTH_MAX);
        LibSLRuntime.ArrayActions.copy(this.value, srcBegin, dst, dstBegin, count);
    }
}
