package generated.java.lang;

import java.io.Serial;
import java.io.Serializable;
import java.lang.CharSequence;
import java.lang.Character;
import java.lang.Comparable;
import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;
import java.lang.NegativeArraySizeException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.OutOfMemoryError;
import java.lang.String;
import java.lang.StringBuffer;
import java.lang.StringIndexOutOfBoundsException;
import java.util.stream.IntStream;

import generated.java.util.stream.IntStreamImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.lang.StringBuilder.class)
public final class StringBuilderImpl implements Serializable, Comparable<StringBuilderImpl>, CharSequence {
    // TODO: unify with StringBufferImpl: create approximation on 'AbstractStringBuilder' (it's private)

    @Serial
    private static final long serialVersionUID = 4383685877147921099L;

    private static final int STRING_BUILDER_LENGTH_MAX = 100;

    static {
        Engine.assume(true);
    }

    byte[] value;

    byte coder;

    int byteCount;

    private StringBuilderImpl(byte[] value, int byteCount) {
        this.value = value;
        this.byteCount = byteCount;
        this.coder = StringImpl._currentCoder();
    }

    public StringBuilderImpl() {
        this(new byte[STRING_BUILDER_LENGTH_MAX], 0);
    }

    public StringBuilderImpl(CharSequence seq) {
        if (seq == null)
            throw new NullPointerException();

        this.value = new byte[STRING_BUILDER_LENGTH_MAX];
        this.byteCount = 0;
        _appendCharSequence(seq);
    }

    public StringBuilderImpl(String str) {
        if (str == null)
            throw new NullPointerException();

        this.value = new byte[STRING_BUILDER_LENGTH_MAX];
        this.byteCount = 0;
        _appendCharSequence(str);
    }

    public StringBuilderImpl(int cap) {
        if (cap < 0)
            throw new NegativeArraySizeException();

        if (cap > 1073741823)
            throw new OutOfMemoryError("Requested array size exceeds VM limit");

        this.value = new byte[STRING_BUILDER_LENGTH_MAX];
        this.byteCount = 0;
    }

    private static String _getString(CharSequence seq) {
        if (seq instanceof String)
            return (String) seq;

        return LibSLRuntime.toString(seq);
    }

    private static CharSequence _getCharSequence(CharSequence seq) {
        if (seq == null)
            return "null";

        return seq;
    }

    private static CharSequence _getCharSequence(Object obj) {
        if (obj == null)
            return "null";

        return LibSLRuntime.toString(obj);
    }

    private static CharSequence _getCharSequence(boolean b) {
        if (b)
            return "true";

        return "false";
    }

    private int _charPosToBytePos(int charPos) {
        return charPos << coder;
    }

    private int _bytePosToCharPos(int charPos) {
        return charPos >> coder;
    }

    private static void _checkRangeBounds(int start, int end, int rightBound) {
        if (start < 0 || start > end || end > rightBound)
            throw new IndexOutOfBoundsException();
    }

    private static void _checkSeqBounds(CharSequence seq, int seqStart, int seqEnd) {
        _checkRangeBounds(seqStart, seqEnd, seq.length());
    }

    private void _checkByteOffset(int byteOffset) {
        if (byteOffset < 0 || byteOffset > this.byteCount)
            throw new IndexOutOfBoundsException();
    }

    private void _checkCharOffset(int charOffset) {
        _checkByteOffset(_charPosToBytePos(charOffset));
    }

    private int _getByteSeqLength(int byteOffset, int byteSeqStart, int byteSeqEnd) {
        int availableBytes = this.value.length - byteOffset;
        int byteSeqLength = byteSeqEnd - byteSeqStart;
        if (byteSeqLength > availableBytes)
            byteSeqLength = availableBytes;

        return byteSeqLength;
    }

    // TODO: unify _appendCharSequence with _appendChars #Approx
    private void _appendCharSequence(CharSequence seq, int seqStart, int seqEnd) {
        _checkSeqBounds(seq, seqStart, seqEnd);

        int byteSeqStart = _charPosToBytePos(seqStart);
        int byteSeqEnd = _charPosToBytePos(seqEnd);
        int byteSeqLength = _getByteSeqLength(byteCount, byteSeqStart, byteSeqEnd);
        String str = _getString(seq);
        byte[] bytes = str.getBytes();
        LibSLRuntime.ArrayActions.copy(bytes, byteSeqStart, this.value, byteCount, byteSeqLength);
        this.byteCount += byteSeqLength;
    }

    private void _appendChars(char[] seq, int seqStart, int seqEnd) {
        _checkRangeBounds(seqStart, seqEnd, seq.length);

        int byteSeqStart = _charPosToBytePos(seqStart);
        int byteSeqEnd = _charPosToBytePos(seqEnd);
        int byteSeqLength = _getByteSeqLength(byteCount, byteSeqStart, byteSeqEnd);
        byte[] bytes = StringImpl._getBytes(seq);
        LibSLRuntime.ArrayActions.copy(bytes, byteSeqStart, this.value, byteCount, byteSeqLength);
        this.byteCount += byteSeqLength;
    }

    private void _appendCharSequence(CharSequence seq) {
        _appendCharSequence(seq, 0, seq.length());
    }

    private StringImpl _asString(int posStart, int posEnd) {
        int bytePosStart = _charPosToBytePos(posStart);
        int bytePosEnd = _charPosToBytePos(posEnd);
        int byteLength = bytePosEnd - bytePosStart;
        if (byteLength == 0)
            return StringImpl._emptyString;

        if (bytePosStart == 0 && bytePosEnd == this.value.length)
            return new StringImpl(this.value);

        byte[] bytes = new byte[byteLength];
        LibSLRuntime.ArrayActions.copy(this.value, bytePosStart, bytes, 0, byteLength);
        return new StringImpl(bytes);
    }

    public StringImpl _asString() {
        return _asString(0, this.byteCount);
    }

    // TODO: unify _insertCharSequence with _insertChars #Approx
    private void _insertCharSequence(int offset, CharSequence seq, int seqStart, int seqEnd) {
        _checkSeqBounds(seq, seqStart, seqEnd);

        int byteOffset = _charPosToBytePos(offset);
        _checkByteOffset(byteOffset);

        int byteSeqStart = _charPosToBytePos(seqStart);
        int byteSeqEnd = _charPosToBytePos(seqEnd);
        int availableBytes = this.value.length - byteOffset;
        int byteLength = byteSeqEnd - byteSeqStart;
        if (byteLength > availableBytes)
            byteLength = availableBytes;

        if (byteLength <= 0)
            return;

        int availableForLeftovers = availableBytes - byteLength;
        if (availableForLeftovers > 0) {
            int rightLeftovers = this.byteCount - byteOffset;
            if (rightLeftovers > availableForLeftovers)
                rightLeftovers = availableForLeftovers;

            if (rightLeftovers > 0)
                // Moving bytes, that would be replaced, beyond right bound of insertion
                LibSLRuntime.ArrayActions.copy(this.value, byteOffset, this.value, byteOffset + byteLength, rightLeftovers);
        }

        String str = _getString(seq);
        byte[] bytes = str.getBytes();
        LibSLRuntime.ArrayActions.copy(bytes, byteSeqStart, this.value, byteOffset, byteLength);
        this.byteCount += byteLength;
    }

    @SuppressWarnings("SameParameterValue")
    private void _insertChars(int offset, char[] chars, int seqStart, int seqEnd) {
        _checkRangeBounds(seqStart, seqEnd, chars.length);

        int byteOffset = _charPosToBytePos(offset);
        _checkByteOffset(byteOffset);

        int byteSeqStart = _charPosToBytePos(seqStart);
        int byteSeqEnd = _charPosToBytePos(seqEnd);
        int availableBytes = this.value.length - byteOffset;
        int byteLength = byteSeqEnd - byteSeqStart;
        if (byteLength > availableBytes)
            byteLength = availableBytes;

        if (byteLength <= 0)
            return;

        int availableForLeftovers = availableBytes - byteLength;
        if (availableForLeftovers > 0) {
            int rightLeftovers = this.byteCount - byteOffset;
            if (rightLeftovers > availableForLeftovers)
                rightLeftovers = availableForLeftovers;

            if (rightLeftovers > 0)
                // Moving bytes, that would be replaced, beyond right bound of insertion
                LibSLRuntime.ArrayActions.copy(this.value, byteOffset, this.value, byteOffset + byteLength, rightLeftovers);
        }

        byte[] bytes = StringImpl._getBytes(chars);
        LibSLRuntime.ArrayActions.copy(bytes, byteSeqStart, this.value, byteOffset, byteLength);
        this.byteCount += byteLength;
    }

    private void _insertCharSequence(int offset, CharSequence seq) {
        _insertCharSequence(offset, seq, 0, seq.length());
    }

    private void _deleteChars(int start, int end) {
        int byteStart = _charPosToBytePos(start);
        int byteEnd = _charPosToBytePos(end);
        _checkRangeBounds(byteStart, byteEnd, this.byteCount);

        int leftovers = this.byteCount - byteEnd;
        if (leftovers > 0)
            LibSLRuntime.ArrayActions.copy(this.value, byteEnd, this.value, byteStart, leftovers);
        int deletedBytesSize = byteEnd - byteStart;
        this.byteCount -= deletedBytesSize;
    }

    @SuppressWarnings("DataFlowIssue")
    private void _assumeInvariants() {
        Engine.assume(this.value != null);
        Engine.assume(this.value.length <= STRING_BUILDER_LENGTH_MAX);
        Engine.assume(this.byteCount <= this.value.length);
        Engine.assume(this.byteCount >= 0);
        Engine.assume(this.coder == StringImpl._currentCoder());
    }

    public StringBuilderImpl append(CharSequence seq) {
        _assumeInvariants();
        seq = _getCharSequence(seq);
        _appendCharSequence(seq);

        return this;
    }

    public StringBuilderImpl append(CharSequence seq, int start, int end) {
        _assumeInvariants();
        seq = _getCharSequence(seq);
        _appendCharSequence(seq, start, end);

        return this;
    }

    public StringBuilderImpl append(Object obj) {
        _assumeInvariants();
        CharSequence seq = _getCharSequence(obj);
        _appendCharSequence(seq);

        return this;
    }

    public StringBuilderImpl append(String str) {
        _assumeInvariants();
        CharSequence seq = _getCharSequence(str);
        _appendCharSequence(seq);

        return this;
    }

    public StringBuilderImpl append(StringBuffer sb) {
        _assumeInvariants();
        CharSequence seq = _getCharSequence(sb);
        _appendCharSequence(seq);

        return this;
    }

    public StringBuilderImpl append(boolean x) {
        _assumeInvariants();
        CharSequence seq = _getCharSequence(x);
        _appendCharSequence(seq);

        return this;
    }

    public StringBuilderImpl append(char x) {
        _assumeInvariants();
        if (this.byteCount < this.value.length) {
            StringImpl._addCharToBytes(value, byteCount, x);
            this.byteCount++;
        }

        return this;
    }

    public StringBuilderImpl append(char[] chars) {
        _assumeInvariants();
        _appendChars(chars, 0, chars.length);

        return this;
    }

    public StringBuilderImpl append(char[] chars, int offset, int len) {
        _assumeInvariants();
        _appendChars(chars, offset, len);

        return this;
    }

    public StringBuilderImpl append(double x) {
        _assumeInvariants();
        String seq = LibSLRuntime.toString(x);
        _appendCharSequence(seq);

        return this;
    }

    public StringBuilderImpl append(float x) {
        _assumeInvariants();
        String seq = LibSLRuntime.toString(x);
        _appendCharSequence(seq);

        return this;
    }

    public StringBuilderImpl append(int x) {
        _assumeInvariants();
        String seq = LibSLRuntime.toString(x);
        _appendCharSequence(seq);

        return this;
    }

    public StringBuilderImpl append(long x) {
        _assumeInvariants();
        String seq = LibSLRuntime.toString(x);
        _appendCharSequence(seq);

        return this;
    }

    public StringBuilderImpl appendCodePoint(int codePoint) {
        // TODO: fix #Approx
        _assumeInvariants();
        int cnt = this.byteCount;
        int len = this.value.length;
        if (Character.isBmpCodePoint(codePoint)) {
            if (cnt + 1 <= len) {
                value[cnt] = (byte) codePoint;
                this.byteCount = cnt + 1;
            }
        } else {
            if (Character.isValidCodePoint(codePoint)) {
                if (cnt + 2 <= len) {
                    value[cnt + 1] = (byte) Character.lowSurrogate(codePoint);
                    value[cnt] = (byte) Character.highSurrogate(codePoint);
                    this.byteCount = cnt + 2;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        return this;
    }

    public int capacity() {
        _assumeInvariants();
        return _bytePosToCharPos(this.value.length);
    }

    public char charAt(int index) {
        // TODO: fix #Approx
        _assumeInvariants();
        index = _charPosToBytePos(index);
        if (index < 0 || index >= this.byteCount)
            throw new StringIndexOutOfBoundsException();

        return (char) value[index];
    }

    @NotNull
    public IntStream chars() {
        // TODO: fix #Approx
        _assumeInvariants();
        int len = this.byteCount;
        int[] intValues = new int[len];
        for (int i = 0; i < len; i++) {
            intValues[i] = value[i];
        }

        return new IntStreamImpl(intValues);
    }

    public int codePointAt(int index) {
        _assumeInvariants();
        if (index < 0 || index >= this.byteCount)
            throw new StringIndexOutOfBoundsException(index);

        // TODO: support code points #Approx
        return 0;
    }

    public int codePointBefore(int index) {
        _assumeInvariants();
        int i = index - 1;
        if (i < 0 || i >= this.byteCount)
            throw new StringIndexOutOfBoundsException(index);

        // TODO: support code points #Approx
        return 0;
    }

    public int codePointCount(int beginIndex, int endIndex) {
        _assumeInvariants();
        if (beginIndex < 0 || beginIndex > endIndex || endIndex > this.byteCount)
            throw new IndexOutOfBoundsException();

        // TODO: support code points #Approx
        return 0;
    }

    @NotNull
    public IntStream codePoints() {
        // TODO: support code points #Approx
        _assumeInvariants();
        int len = this.byteCount;
        int[] intValues = new int[len];
        for (int i = 0; i < len; i++) {
            intValues[i] = value[i];
        }
        return new IntStreamImpl(intValues);
    }

    public int compareTo(@NotNull StringBuilderImpl another) {
        _assumeInvariants();
        if (another == this)
            return 0;

        // TODO: implement compareTo in StringImpl #Approx
        String thisString = _asString().toString();
        String anotherString = another._asString().toString();
        return thisString.compareTo(anotherString);
    }

    public StringBuilderImpl delete(int start, int end) {
        _assumeInvariants();
        _deleteChars(start, end);

        return this;
    }

    public StringBuilderImpl deleteCharAt(int index) {
        _assumeInvariants();
        _deleteChars(index, index + 1);

        return this;
    }

    public void ensureCapacity(int minimumCapacity) {
        Engine.assume(true);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        // TODO: fix #Approx
        _assumeInvariants();
        if (srcBegin < 0 || srcBegin > srcEnd || srcEnd > this.byteCount)
            throw new StringIndexOutOfBoundsException();
        int len = srcEnd - srcBegin;
        if (dst == null)
            throw new NullPointerException();
        if (dstBegin < 0 || dstBegin + len > dst.length)
            throw new IndexOutOfBoundsException();
        if (len > 0)
            LibSLRuntime.ArrayActions.copy(this.value, srcBegin, dst, dstBegin, len);
    }

    public char[] getValue() {
        _assumeInvariants();
        return StringImpl._getChars(this.value);
    }

    public int indexOf(String str) {
        _assumeInvariants();
        // TODO: implement indexOf in StringImpl #Approx
        return _asString().toString().indexOf(str);
    }

    public int indexOf(String str, int fromIndex) {
        _assumeInvariants();
        // TODO: implement indexOf in StringImpl #Approx
        return _asString().toString().indexOf(str, fromIndex);
    }

    public StringBuilderImpl insert(int dstOffset, CharSequence s) {
        _assumeInvariants();
        _insertCharSequence(dstOffset, s);

        return this;
    }

    public StringBuilderImpl insert(int dstOffset, CharSequence s, int start, int end) {
        _assumeInvariants();
        _insertCharSequence(dstOffset, s, start, end);

        return this;
    }

    public StringBuilderImpl insert(int dstOffset, Object obj) {
        _assumeInvariants();
        CharSequence seq = _getCharSequence(obj);
        _insertCharSequence(dstOffset, seq);

        return this;
    }

    public StringBuilderImpl insert(int dstOffset, String s) {
        _assumeInvariants();
        _insertCharSequence(dstOffset, s);

        return this;
    }

    public StringBuilderImpl insert(int dstOffset, boolean x) {
        _assumeInvariants();
        CharSequence seq = _getCharSequence(x);
        _insertCharSequence(dstOffset, seq);

        return this;
    }

    public StringBuilderImpl insert(int dstOffset, char x) {
        _assumeInvariants();
        CharSequence seq = _getCharSequence(x);
        _insertCharSequence(dstOffset, seq, 0, 1);

        return this;
    }

    public StringBuilderImpl insert(int dstOffset, char[] x) {
        _assumeInvariants();
        _insertChars(dstOffset, x, 0, x.length);

        return this;
    }

    public StringBuilderImpl insert(int index, char[] str, int offset, int len) {
        _assumeInvariants();
        char[] arr = new char[len];
        LibSLRuntime.ArrayActions.copy(str, offset, arr, 0, len);
        _insertChars(index, arr, 0, len);

        return this;
    }

    public StringBuilderImpl insert(int dstOffset, double x) {
        _assumeInvariants();
        String s = LibSLRuntime.toString(x);
        _insertCharSequence(dstOffset, s);

        return this;
    }

    public StringBuilderImpl insert(int dstOffset, float x) {
        _assumeInvariants();
        String s = LibSLRuntime.toString(x);
        _insertCharSequence(dstOffset, s);

        return this;
    }

    public StringBuilderImpl insert(int dstOffset, int x) {
        _assumeInvariants();
        String s = LibSLRuntime.toString(x);
        _insertCharSequence(dstOffset, s);

        return this;
    }

    public StringBuilderImpl insert(int dstOffset, long x) {
        _assumeInvariants();
        String s = LibSLRuntime.toString(x);
        _insertCharSequence(dstOffset, s);

        return this;
    }

    public int lastIndexOf(String str) {
        _assumeInvariants();
        return _asString().toString().lastIndexOf(str, this.byteCount);
    }

    public int lastIndexOf(String str, int fromIndex) {
        _assumeInvariants();
        return _asString().toString().lastIndexOf(str, fromIndex);
    }

    public int length() {
        _assumeInvariants();
        return this.byteCount;
    }

    public int offsetByCodePoints(int index, int codePointOffset) {
        _assumeInvariants();
        if (index < 0 || index > this.byteCount)
            throw new IndexOutOfBoundsException();

        // TODO: support code points #Approx
        return 0;
    }

    public StringBuilderImpl replace(int start, int end, String s) {
        _assumeInvariants();
        _deleteChars(start, end);
        _insertCharSequence(start, s);

        return this;
    }

    public StringBuilderImpl reverse() {
        _assumeInvariants();
        if (this.byteCount == 0)
            return this;

        // TODO: implement #Approx
//        boolean hasSurrogates = false;
//        int n = this.byteCount - 1;
//        for (int i = (n - 1) >> 1; i > -1; i--) {
//            int k = n - i;
//            byte cj = value[i];
//            byte ck = value[k];
//            value[i] = ck;
//            value[k] = cj;
//            if (Character.isSurrogate(cj) || Character.isSurrogate(ck)) {
//                hasSurrogates = true;
//            }
//        }
//        if (!hasSurrogates)
//            return this;
//
//        for (int i = 0; i < n; i++) {
//            char c2 = value[i];
//            if (Character.isLowSurrogate(c2)) {
//                char c1 = value[i + 1];
//                if (Character.isHighSurrogate(c1)) {
//                    value[i] = c1;
//                    i++;
//                    value[i] = c2;
//                }
//            }
//        }

        return this;
    }

    public void setCharAt(int index, char x) {
        _assumeInvariants();
        if (index < 0 || index >= this.byteCount)
            throw new StringIndexOutOfBoundsException();

        StringImpl._addCharToBytes(value, index, x);
    }

    public void setLength(int newLength) {
        _assumeInvariants();
        newLength = _charPosToBytePos(newLength);
        int maxLength = this.value.length;
        if (newLength > maxLength)
            newLength = maxLength;

        if (newLength < 0)
            throw new StringIndexOutOfBoundsException();

        if (newLength < this.byteCount) {
            this.byteCount = newLength;
            return;
        }

        if (newLength > this.byteCount) {
            LibSLRuntime.ArrayActions.fillRange(this.value, this.byteCount, newLength, ((byte) 0));
            this.byteCount = newLength;
        }
    }

    @NotNull
    public CharSequence subSequence(int start, int end) {
        _assumeInvariants();
        // TODO: fix #Approx
        if (start < 0 || start > end || end > this.byteCount)
            throw new StringIndexOutOfBoundsException();

        return _asString(start, end).toString();
    }

    public String substring(int start) {
        _assumeInvariants();
        // TODO: fix #Approx
        if (start < 0 || start > this.byteCount)
            throw new StringIndexOutOfBoundsException();

        return _asString(start, this.byteCount).toString();
    }

    public String substring(int start, int end) {
        _assumeInvariants();
        // TODO: fix #Approx
        if (start < 0 || start > end || end > this.byteCount)
            throw new StringIndexOutOfBoundsException();

        return _asString(start, end).toString();
    }

    @NotNull
    public String toString() {
        _assumeInvariants();
        return _asString().toString();
    }

    public void trimToSize() {
        _assumeInvariants();
    }
}
