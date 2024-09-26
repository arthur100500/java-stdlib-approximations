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

    static final byte UTF16 = 1;

    static final byte LATIN1 = 0;

    // Enforce coder == UTF8
    static final boolean COMPACT_STRINGS = true;

    private final byte[] value;

    // TODO: everywhere add assume 'coder == LATIN1' #Approx
    private final byte coder;

    public static StringImpl _emptyString = new StringImpl(new byte[] {});

    public static byte _currentCoder() {
        return COMPACT_STRINGS ? LATIN1 : UTF16;
    }

    public static void _addCharToBytes(byte[] bytes, int index, char value) {
        if (COMPACT_STRINGS) {
            Engine.assume(value <= 0xFF);
            bytes[index] = (byte) value;
        } else {
            bytes[index++] = (byte) value;
            bytes[index] = (byte) (value >> 8);
        }
    }

    public static byte[] _getBytes(char[] chars) {
        int size = chars.length << _currentCoder();
        byte[] bytes = new byte[size];
        if (COMPACT_STRINGS) {
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                Engine.assume(c <= 0xFF);
                bytes[i] = (byte) chars[i];
            }
        } else {
            int byteIndex = 0;
            for (char c : chars) {
                bytes[byteIndex++] = (byte) c;
                bytes[byteIndex] = (byte) (c >> 8);
                byteIndex++;
            }
        }

        return bytes;
    }

    public static char[] _getChars(byte[] bytes) {
        int size = bytes.length >> _currentCoder();
        char[] chars = new char[size];
        if (COMPACT_STRINGS) {
            for (int i = 0; i < bytes.length; i++) {
                byte c = bytes[i];
                chars[i] = (char) bytes[i];
            }
        } else {
            int byteIndex = 0;
            for (int i = 0; i < chars.length; i++) {
                char c = (char) (((char) bytes[byteIndex++]) | (((char) bytes[byteIndex++]) << 8));
            }
        }

        return chars;
    }

    private StringImpl(byte[] value, byte coder) {
        Engine.assume(coder == _currentCoder());
        this.value = value;
        this.coder = coder;
    }

    public StringImpl() {
        this(new byte[0], _currentCoder());
    }

    public StringImpl(StringImpl original) {
        this(original.value, original.coder);
    }

    public StringImpl(byte[] bytes) {
        int len = bytes.length;
        this.value = new byte[len];
        this.coder = _currentCoder();
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
    private void _assumeInvariants() {
        Engine.assume(this.value != null);
        Engine.assume(this.value.length <= STRING_LENGTH_MAX);
        Engine.assume(this.coder == _currentCoder());
    }

    public StringImpl concat(StringImpl str) {
        _assumeInvariants();

        byte[] otherVal = str.value;
        int otherLen = otherVal.length;
        if (otherLen == 0)
            return this;

        int newLength = this.value.length + otherLen;
        byte[] newValue = new byte[newLength];
        LibSLRuntime.ArrayActions.copy(this.value, 0, newValue, 0, this.value.length);
        LibSLRuntime.ArrayActions.copy(otherVal, 0, newValue, this.value.length, otherLen);
        return new StringImpl(newValue, _currentCoder());
    }

    public byte[] getBytes() {
        _assumeInvariants();

        return this.value;
    }

    public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
        if (srcBegin < 0)
            throw new StringIndexOutOfBoundsException(srcBegin);
        if (this.value.length < srcEnd)
            throw new StringIndexOutOfBoundsException(srcEnd);
        int count = srcEnd - srcBegin;
        if (count < 0)
            throw new StringIndexOutOfBoundsException(count);
        _assumeInvariants();
        LibSLRuntime.ArrayActions.copy(this.value, srcBegin, dst, dstBegin, count);
    }
}
