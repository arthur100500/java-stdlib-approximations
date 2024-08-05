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
import java.lang.StringIndexOutOfBoundsException;
import java.util.stream.IntStream;

import generated.java.util.stream.IntStreamImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.lang.StringBuffer.class)
public final class StringBufferImpl implements Serializable, Comparable<StringBufferImpl>, CharSequence {

    @Serial
    private static final long serialVersionUID = 3388685877147921107L;

    private static final int STRING_BUFFER_LENGTH_MAX = 50;

    static {
        Engine.assume(true);
    }

    public char[] value;

    public int count = 0;

    public StringBufferImpl(char[] value, int count) {
        this.value = value;
        this.count = count;
    }

    public StringBufferImpl() {
        this(new char[STRING_BUFFER_LENGTH_MAX], 0);
    }

    public StringBufferImpl(CharSequence seq) {
        if (seq == null)
            throw new NullPointerException();
        this.value = new char[STRING_BUFFER_LENGTH_MAX];
        _appendCharSequence(seq, 0, seq.length());
    }

    public StringBufferImpl(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.value = new char[STRING_BUFFER_LENGTH_MAX];
        _appendCharSequence(str, 0, str.length());
    }

    public StringBufferImpl(int cap) {
        if (cap < 0)
            throw new NegativeArraySizeException();
        if (cap > 1073741823)
            throw new OutOfMemoryError("Requested array size exceeds VM limit");
        this.value = new char[STRING_BUFFER_LENGTH_MAX];
    }

    private void _appendCharSequence(CharSequence seq, int seqStart, int seqEnd) {
        if (seqStart < 0 || seqStart > seqEnd || seqEnd > seq.length())
            throw new IndexOutOfBoundsException();
        int available = this.value.length - this.count;
        int len = seqEnd - seqStart;
        if (len > available)
            len = available;
        if (len <= 0)
            return;

        String str;
        if (seq instanceof String) {
            str = (String) seq;
        } else {
            str = LibSLRuntime.toString(seq);
        }
        char[] chars = str.toCharArray();
        LibSLRuntime.ArrayActions.copy(chars, seqStart, this.value, this.count, len);
        this.count += len;
    }

    private String _asString(int posStart, int posEnd) {
        int len = posEnd - posStart;
        if (len == 0)
            return "";

        char[] symbols = new char[len];
        LibSLRuntime.ArrayActions.copy(this.value, posStart, symbols, 0, len);
        return LibSLRuntime.toString(this.value);
    }

    public String _asString() {
        int len = this.count;
        if (len == 0)
            return "";

        if (len == this.value.length)
            return LibSLRuntime.toString(this.value);

        char[] symbols = new char[len];
        LibSLRuntime.ArrayActions.copy(this.value, 0, symbols, 0, len);
        return LibSLRuntime.toString(this.value);
    }

    private void _insertCharSequence(int offset, CharSequence seq, int seqStart, int seqEnd) {
        if (seqStart < 0 || seqStart > seqEnd || seqEnd > seq.length() || offset > this.count)
            throw new IndexOutOfBoundsException();

        int available = this.value.length - offset;
        int len = seqEnd - seqStart;
        if (len > available)
            len = available;

        if (len <= 0)
            return;

        int availableForLeftovers = available - len;
        if (availableForLeftovers > 0) {
            int rightLeftovers = this.count - offset;
            if (rightLeftovers > availableForLeftovers)
                rightLeftovers = availableForLeftovers;
            if (rightLeftovers > 0) {
                int rightIndex = offset + 1;
                LibSLRuntime.ArrayActions.copy(this.value, rightIndex, this.value, rightIndex + len, rightLeftovers);
            }
        }
        String str;
        if (seq instanceof String) {
            str = (String) seq;
        } else {
            str = LibSLRuntime.toString(seq);
        }
        char[] chars = str.toCharArray();
        LibSLRuntime.ArrayActions.copy(chars, seqStart, this.value, offset, len);
        this.count += len;
    }

    private void _deleteChars(int start, int end) {
        if (start < 0 || start > end || end > this.count)
            throw new IndexOutOfBoundsException();

        int leftovers = this.count - end;
        if (leftovers > 0)
            LibSLRuntime.ArrayActions.copy(this.value, end, this.value, start, leftovers);
        this.count -= end - start;
    }

    @SuppressWarnings("DataFlowIssue")
    private void _assumeInvariants() {
        Engine.assume(this.value != null);
        Engine.assume(this.value.length <= STRING_BUFFER_LENGTH_MAX);
        Engine.assume(this.count <= this.value.length);
        Engine.assume(this.count >= 0);
    }

    public synchronized StringBufferImpl append(CharSequence seq) {
        _assumeInvariants();
        if (seq == null) {
            _appendCharSequence("null", 0, 4);
        } else {
            _appendCharSequence(seq, 0, seq.length());
        }
        return this;
    }

    @SuppressWarnings("ReplaceNullCheck")
    public synchronized StringBufferImpl append(CharSequence seq, int start, int end) {
        _assumeInvariants();
        if (seq == null) {
            _appendCharSequence("null", start, end);
        } else {
            _appendCharSequence(seq, start, end);
        }
        return this;
    }

    public synchronized StringBufferImpl append(Object obj) {
        _assumeInvariants();
        if (obj == null) {
            _appendCharSequence("null", 0, 4);
        } else {
            String seq = LibSLRuntime.toString(obj);
            _appendCharSequence(seq, 0, seq.length());
        }
        return this;
    }

    public synchronized StringBufferImpl append(String str) {
        _assumeInvariants();
        if (str == null) {
            _appendCharSequence("null", 0, 4);
        } else {
            _appendCharSequence(str, 0, str.length());
        }
        return this;
    }

    public synchronized StringBufferImpl append(java.lang.StringBuffer sb) {
        _assumeInvariants();
        if (sb == null) {
            _appendCharSequence("null", 0, 4);
        } else {
            String seq = LibSLRuntime.toString(sb);
            _appendCharSequence(seq, 0, seq.length());
        }
        return this;
    }

    public synchronized StringBufferImpl append(boolean x) {
        _assumeInvariants();
        if (x) {
            _appendCharSequence("true", 0, 4);
        } else {
            _appendCharSequence("false", 0, 5);
        }
        return this;
    }

    public synchronized StringBufferImpl append(char x) {
        _assumeInvariants();
        if (this.count < this.value.length) {
            value[this.count] = x;
            this.count++;
        }
        return this;
    }

    public synchronized StringBufferImpl append(char[] str) {
        _assumeInvariants();
        String seq = LibSLRuntime.toString(str);
        _appendCharSequence(seq, 0, seq.length());
        return this;
    }

    public synchronized StringBufferImpl append(char[] str, int offset, int len) {
        _assumeInvariants();
        String seq = LibSLRuntime.toString(str);
        _appendCharSequence(seq, offset, len);
        return this;
    }

    public synchronized StringBufferImpl append(double x) {
        _assumeInvariants();
        String seq = LibSLRuntime.toString(x);
        _appendCharSequence(seq, 0, seq.length());
        return this;
    }

    public synchronized StringBufferImpl append(float x) {
        _assumeInvariants();
        String seq = LibSLRuntime.toString(x);
        _appendCharSequence(seq, 0, seq.length());
        return this;
    }

    public synchronized StringBufferImpl append(int x) {
        _assumeInvariants();
        String seq = LibSLRuntime.toString(x);
        _appendCharSequence(seq, 0, seq.length());
        return this;
    }

    public synchronized StringBufferImpl append(long x) {
        _assumeInvariants();
        String seq = LibSLRuntime.toString(x);
        _appendCharSequence(seq, 0, seq.length());
        return this;
    }

    public synchronized StringBufferImpl appendCodePoint(int codePoint) {
        _assumeInvariants();
        int cnt = this.count;
        int len = this.value.length;
        if (Character.isBmpCodePoint(codePoint)) {
            if (cnt + 1 <= len) {
                value[cnt] = (char) codePoint;
                this.count = cnt + 1;
            }
        } else {
            if (Character.isValidCodePoint(codePoint)) {
                if (cnt + 2 <= len) {
                    value[cnt + 1] = Character.lowSurrogate(codePoint);
                    value[cnt] = Character.highSurrogate(codePoint);
                    this.count = cnt + 2;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        return this;
    }

    public synchronized int capacity() {
        _assumeInvariants();
        return this.value.length;
    }

    public synchronized char charAt(int index) {
        _assumeInvariants();
        if (index < 0 || index >= this.count)
            throw new StringIndexOutOfBoundsException();
        return value[index];
    }

    @NotNull
    public IntStream chars() {
        _assumeInvariants();
        int len = this.count;
        int[] intValues = new int[len];
        for (int i = 0; i < len; i++) {
            intValues[i] = value[i];
        }

        return new IntStreamImpl(intValues);
    }

    public synchronized int codePointAt(int index) {
        _assumeInvariants();
        if (index < 0 || index >= this.count)
            throw new StringIndexOutOfBoundsException(index);
        return Character.codePointAt(this.value, index, this.count);
    }

    public synchronized int codePointBefore(int index) {
        _assumeInvariants();
        int i = index - 1;
        if (i < 0 || i >= this.count)
            throw new StringIndexOutOfBoundsException(index);
        return Character.codePointBefore(this.value, index, 0);
    }

    public synchronized int codePointCount(int beginIndex, int endIndex) {
        _assumeInvariants();
        if (beginIndex < 0 || beginIndex > endIndex || endIndex > this.count)
            throw new IndexOutOfBoundsException();
        return Character.codePointCount(this.value, beginIndex, endIndex - beginIndex);
    }

    @NotNull
    public IntStream codePoints() {
        _assumeInvariants();
        int len = this.count;
        int[] intValues = new int[len];
        for (int i = 0; i < len; i++) {
            intValues[i] = value[i];
        }
        return new IntStreamImpl(intValues);
    }

    public synchronized int compareTo(@NotNull StringBufferImpl another) {
        _assumeInvariants();
        if (another == this)
            return 0;

        String thisString = _asString();
        String anotherString = another._asString();
        return thisString.compareTo(anotherString);
    }

    public synchronized StringBufferImpl delete(int start, int end) {
        _assumeInvariants();
        _deleteChars(start, end);
        return this;
    }

    public synchronized StringBufferImpl deleteCharAt(int index) {
        _assumeInvariants();
        _deleteChars(index, index + 1);
        return this;
    }

    public synchronized void ensureCapacity(int minimumCapacity) {
        Engine.assume(true);
    }

    public synchronized void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        _assumeInvariants();
        if (srcBegin < 0 || srcBegin > srcEnd || srcEnd > this.count)
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
        return this.value;
    }

    public int indexOf(String str) {
        _assumeInvariants();
        return _asString().indexOf(str);
    }

    public synchronized int indexOf(String str, int fromIndex) {
        _assumeInvariants();
        return _asString().indexOf(str, fromIndex);
    }

    public StringBufferImpl insert(int dstOffset, CharSequence s) {
        _assumeInvariants();
        if (s == null) {
            _insertCharSequence(dstOffset, "null", 0, 4);
        } else {
            _insertCharSequence(dstOffset, s, 0, s.length());
        }
        return this;
    }

    @SuppressWarnings("ReplaceNullCheck")
    public synchronized StringBufferImpl insert(int dstOffset, CharSequence s, int start, int end) {
        _assumeInvariants();
        if (s == null) {
            _insertCharSequence(dstOffset, "null", start, end);
        } else {
            _insertCharSequence(dstOffset, s, start, end);
        }
        return this;
    }

    public synchronized StringBufferImpl insert(int dstOffset, Object obj) {
        _assumeInvariants();
        if (obj == null) {
            _insertCharSequence(dstOffset, "null", 0, 4);
        } else {
            String s = LibSLRuntime.toString(obj);
            _insertCharSequence(dstOffset, s, 0, s.length());
        }
        return this;
    }

    public synchronized StringBufferImpl insert(int dstOffset, String s) {
        _assumeInvariants();
        if (s == null) {
            _insertCharSequence(dstOffset, "null", 0, 4);
        } else {
            _insertCharSequence(dstOffset, s, 0, s.length());
        }
        return this;
    }

    public StringBufferImpl insert(int dstOffset, boolean x) {
        _assumeInvariants();
        String s = LibSLRuntime.toString(x);
        _insertCharSequence(dstOffset, s, 0, s.length());
        return this;
    }

    public synchronized StringBufferImpl insert(int dstOffset, char x) {
        _assumeInvariants();
        String s = LibSLRuntime.toString(x);
        _insertCharSequence(dstOffset, s, 0, 1);
        return this;
    }

    public synchronized StringBufferImpl insert(int dstOffset, char[] x) {
        _assumeInvariants();
        String s = LibSLRuntime.toString(x);
        _insertCharSequence(dstOffset, s, 0, s.length());
        return this;
    }

    public synchronized StringBufferImpl insert(int index, char[] str, int offset, int len) {
        _assumeInvariants();
        char[] arr = new char[len];
        LibSLRuntime.ArrayActions.copy(str, offset, arr, 0, len);
        String s = LibSLRuntime.toString(arr);
        _insertCharSequence(index, s, 0, len);
        return this;
    }

    public StringBufferImpl insert(int dstOffset, double x) {
        _assumeInvariants();
        String s = LibSLRuntime.toString(x);
        _insertCharSequence(dstOffset, s, 0, s.length());
        return this;
    }

    public StringBufferImpl insert(int dstOffset, float x) {
        _assumeInvariants();
        String s = LibSLRuntime.toString(x);
        _insertCharSequence(dstOffset, s, 0, s.length());
        return this;
    }

    public StringBufferImpl insert(int dstOffset, int x) {
        _assumeInvariants();
        String s = LibSLRuntime.toString(x);
        _insertCharSequence(dstOffset, s, 0, s.length());
        return this;
    }

    public StringBufferImpl insert(int dstOffset, long x) {
        _assumeInvariants();
        String s = LibSLRuntime.toString(x);
        _insertCharSequence(dstOffset, s, 0, s.length());
        return this;
    }

    public int lastIndexOf(String str) {
        _assumeInvariants();
        return _asString().lastIndexOf(str, this.count);
    }

    public synchronized int lastIndexOf(String str, int fromIndex) {
        _assumeInvariants();
        return _asString().lastIndexOf(str, fromIndex);
    }

    public synchronized int length() {
        _assumeInvariants();
        return this.count;
    }

    public synchronized int offsetByCodePoints(int index, int codePointOffset) {
        _assumeInvariants();
        if (index < 0 || index > this.count)
            throw new IndexOutOfBoundsException();
        return Character.offsetByCodePoints(this.value, 0, this.count, index, codePointOffset);
    }

    public synchronized StringBufferImpl replace(int start, int end, String s) {
        _assumeInvariants();
        _deleteChars(start, end);
        if (s == null) {
            _insertCharSequence(start, "null", 0, 4);
        } else {
            _insertCharSequence(start, s, 0, s.length());
        }
        return this;
    }

    public synchronized StringBufferImpl reverse() {
        _assumeInvariants();
        if (this.count == 0)
            return this;

        boolean hasSurrogates = false;
        int n = this.count - 1;
        for (int i = (n - 1) >> 1; i > -1; i--) {
            int k = n - i;
            char cj = value[i];
            char ck = value[k];
            value[i] = ck;
            value[k] = cj;
            if (Character.isSurrogate(cj) || Character.isSurrogate(ck))
                hasSurrogates = true;
        }

        if (!hasSurrogates)
            return this;

        for (int i = 0; i < n; i++) {
            char c2 = value[i];
            if (Character.isLowSurrogate(c2)) {
                char c1 = value[i + 1];
                if (Character.isHighSurrogate(c1)) {
                    value[i] = c1;
                    i++;
                    value[i] = c2;
                }
            }
        }
        return this;
    }

    public synchronized void setCharAt(int index, char x) {
        _assumeInvariants();
        if (index < 0 || index >= this.count)
            throw new StringIndexOutOfBoundsException();
        value[index] = x;
    }

    public synchronized void setLength(int newLength) {
        _assumeInvariants();
        int maxLength = this.value.length;
        if (newLength > maxLength)
            newLength = maxLength;
        if (newLength < 0)
            throw new StringIndexOutOfBoundsException();

        if (newLength < this.count) {
            this.count = newLength;
            return;
        }

        if (newLength > this.count) {
            LibSLRuntime.ArrayActions.fillRange(this.value, this.count, newLength, ((char) 0));
            this.count = newLength;
        }
    }

    @NotNull
    public synchronized CharSequence subSequence(int start, int end) {
        _assumeInvariants();
        if (start < 0 || start > end || end > this.count)
            throw new StringIndexOutOfBoundsException();

        return _asString(start, end);
    }

    public synchronized String substring(int start) {
        _assumeInvariants();
        if (start < 0 || start > this.count)
            throw new StringIndexOutOfBoundsException();

        return _asString(start, this.count);
    }

    public synchronized String substring(int start, int end) {
        _assumeInvariants();
        if (start < 0 || start > end || end > this.count)
            throw new StringIndexOutOfBoundsException();

        return _asString(start, end);
    }

    @NotNull
    public synchronized String toString() {
        _assumeInvariants();
        return _asString();
    }

    public synchronized void trimToSize() {
        _assumeInvariants();
    }
}
