package generated.libsl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.lang.SuppressWarnings;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;
import stub.libsl.utils.SymbolicInputStream;

@Approximate(SymbolicInputStream.class)
public final class SymbolicInputStreamImpl extends InputStream {

    public final int maxSize;

    public final boolean supportMarks;

    public volatile int dataSize;

    public volatile byte[] data;

    public volatile boolean closed;

    public volatile int pos;

    public int markPos;

    public int markLimit;

    public SymbolicInputStreamImpl(
        int maxSize,
        boolean supportMarks,
        int dataSize,
        byte[] data,
        boolean closed,
        int pos,
        int markPos,
        int markLimit8
    ) {
        this.maxSize = maxSize;
        this.supportMarks = supportMarks;
        this.dataSize = dataSize;
        this.data = data;
        this.closed = closed;
        this.pos = pos;
        this.markPos = markPos;
        this.markLimit = markLimit8;
    }

    private void _initBuffer() {
        if (this.data != null)
            return;

        Engine.assume(this.maxSize > 0);
        int newSize = Engine.makeSymbolicInt();
        Engine.assume(0 <= newSize);
        Engine.assume(newSize < this.maxSize);
        this.dataSize = newSize;
        if (newSize == 0) {
            this.data = new byte[0];
        } else {
            this.data = Engine.makeSymbolicByteArray(newSize);
        }
        Engine.assume(this.data != null);
        Engine.assume(this.dataSize == this.data.length);
    }

    public static void _checkFromIndexSize(int fromIndex, int size, int length) {
        if (length < 0 || fromIndex < 0 || size < 0 || size > length - fromIndex) {
            throw new IndexOutOfBoundsException("Range [%s, %<s + %s) out of bounds for length %s");
        }
    }

    private void _checkClosed() throws IOException {
        if (this.closed)
            throw new IOException("Stream closed");
    }

    @SuppressWarnings("NonAtomicOperationOnVolatileField")
    private void _updatePosition(int delta) {
        this.pos += delta;
        if (this.markPos != -1 && this.pos >= this.markLimit)
            this.markPos = -1;
    }

    private int _moveDataTo(byte[] dest, int offset, int count) {
        int available = this.dataSize - this.pos;
        if (available != 0) {
            Engine.assume(available > 0);
            if (available < count)
                count = available;
            LibSLRuntime.ArrayActions.copy(this.data, this.pos, dest, offset, count);
            _updatePosition(count);
            return count;
        }

        return 0;
    }

    public int available() throws java.io.IOException {
        _checkClosed();
        _initBuffer();

        Engine.assume(this.dataSize >= 0);
        return this.dataSize - this.pos;
    }

    public void close() throws java.io.IOException {
        this.closed = true;
    }

    public void mark(int readLimit) {
        if (this.supportMarks) {
            this.markPos = this.pos;
            this.markLimit = readLimit;
        }
    }

    public boolean markSupported() {
        return this.supportMarks;
    }

    public int read() throws java.io.IOException {
        _checkClosed();
        _initBuffer();

        Engine.assume(this.dataSize >= 0);
        return -1;
    }

    @SuppressWarnings("ConstantValue")
    public int read(@NotNull byte[] b) throws java.io.IOException {
        int len = b.length;
        if (len == 0)
            return 0;

        Engine.assume(len > 0);
        _checkClosed();
        _initBuffer();
        Engine.assume(this.dataSize >= 0);
        return _moveDataTo(b, 0, len);
    }

    public int read(@NotNull byte[] b, int off, int len) throws java.io.IOException {
        _checkFromIndexSize(off, len, b.length);
        if (len == 0)
            return 0;

        _checkClosed();
        _initBuffer();
        Engine.assume(this.dataSize >= 0);
        return _moveDataTo(b, off, len);
    }

    public byte[] readAllBytes() throws java.io.IOException {
        _checkClosed();
        _initBuffer();
        Engine.assume(this.dataSize >= 0);
        if (this.pos == 0) {
            _updatePosition(this.dataSize);
            return this.data;
        }

        if (this.pos == this.dataSize)
            return new byte[0];

        int len = this.dataSize - this.pos;
        Engine.assume(len > 0);
        byte[] result = new byte[len];
        _moveDataTo(result, 0, len);
        return result;
    }

    public int readNBytes(byte[] b, int off, int len) throws java.io.IOException {
        _checkFromIndexSize(off, len, b.length);
        _checkClosed();
        _initBuffer();
        Engine.assume(this.dataSize >= 0);
        if (len == 0)
            return 0;

        return _moveDataTo(b, off, len);
    }

    public byte[] readNBytes(int len) throws java.io.IOException {
        if (len < 0)
            throw new IllegalArgumentException("len < 0");
        _checkClosed();
        _initBuffer();
        Engine.assume(this.dataSize >= 0);
        if (len == 0)
            return new byte[0];

        byte[] result = new byte[len];
        _moveDataTo(result, 0, len);
        return result;
    }

    public void reset() throws java.io.IOException {
        if (!this.supportMarks)
            throw new IOException("mark/reset not supported");

        _checkClosed();
        _initBuffer();
        Engine.assume(this.dataSize >= 0);
        if (this.markPos < 0)
            throw new IOException("Resetting to invalid mark");
        this.pos = this.markPos;
    }

    public long skip(long n) throws java.io.IOException {
        _checkClosed();
        _initBuffer();
        Engine.assume(this.dataSize >= 0);
        return 0L;
    }

    public long transferTo(OutputStream output) throws java.io.IOException {
        if (output == null)
            throw new NullPointerException();
        _checkClosed();
        _initBuffer();
        Engine.assume(this.dataSize >= 0);
        return 0L;
    }
}
