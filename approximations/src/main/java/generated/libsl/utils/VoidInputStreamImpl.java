package generated.libsl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.lang.SuppressWarnings;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import stub.libsl.utils.VoidInputStream;

@SuppressWarnings("unused")
@Approximate(VoidInputStream.class)
public final class VoidInputStreamImpl extends InputStream {

    public volatile boolean closed;

    public VoidInputStreamImpl(boolean p1) {
        this.closed = p1;
    }

    public int available() throws java.io.IOException {
        if (this.closed)
            throw new IOException("Stream closed");

        return 0;
    }

    public void close() throws java.io.IOException {
        this.closed = true;
    }

    public synchronized void mark(int readLimit) {
    }

    @SuppressWarnings("RedundantMethodOverride")
    public boolean markSupported() {
        return false;
    }

    public int read() throws java.io.IOException {
        if (this.closed)
            throw new IOException("Stream closed");

        return -1;
    }

    public int read(@NotNull byte[] b) throws java.io.IOException {
        if (b.length == 0)
            return 0;

        if (this.closed)
            throw new IOException("Stream closed");

        return -1;
    }

    public int read(@NotNull byte[] b, int off, int len) throws java.io.IOException {
        SymbolicInputStreamImpl._checkFromIndexSize(off, len, b.length);
        if (len == 0)
            return 0;

        if (this.closed)
            throw new IOException("Stream closed");

        return -1;
    }

    public byte[] readAllBytes() throws java.io.IOException {
        if (this.closed)
            throw new IOException("Stream closed");

        return new byte[0];
    }

    public int readNBytes(byte[] b, int off, int len) throws java.io.IOException {
        SymbolicInputStreamImpl._checkFromIndexSize(off, len, b.length);
        if (this.closed)
            throw new IOException("Stream closed");

        return 0;
    }

    public byte[] readNBytes(int len) throws java.io.IOException {
        if (len < 0)
            throw new IllegalArgumentException("len < 0");

        if (this.closed)
            throw new IOException("Stream closed");

        return new byte[0];
    }

    public synchronized void reset() throws java.io.IOException {
        throw new IOException("mark/reset not supported");
    }

    public long skip(long n) throws java.io.IOException {
        if (this.closed)
            throw new IOException("Stream closed");

        return 0L;
    }

    public long transferTo(OutputStream output) throws java.io.IOException {
        if (output == null)
            throw new NullPointerException();

        if (this.closed)
            throw new IOException("Stream closed");

        return 0L;
    }
}
