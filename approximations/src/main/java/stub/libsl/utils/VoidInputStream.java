package stub.libsl.utils;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.LinkageError;
import java.lang.SuppressWarnings;

@SuppressWarnings("RedundantThrows")
public final class VoidInputStream extends InputStream {

    @SuppressWarnings("unused")
    public VoidInputStream(boolean p1) {
        throw new LinkageError();
    }

    public int available() throws java.io.IOException {
        throw new LinkageError();
    }

    public void close() throws java.io.IOException {
        throw new LinkageError();
    }

    public synchronized void mark(int readLimit) {
        throw new LinkageError();
    }

    public boolean markSupported() {
        throw new LinkageError();
    }

    public int read() throws java.io.IOException {
        throw new LinkageError();
    }

    public int read(@NotNull byte[] b) throws java.io.IOException {
        throw new LinkageError();
    }

    public int read(@NotNull byte[] b, int off, int len) throws java.io.IOException {
        throw new LinkageError();
    }

    public byte[] readAllBytes() throws java.io.IOException {
        throw new LinkageError();
    }

    public int readNBytes(byte[] b, int off, int len) throws java.io.IOException {
        throw new LinkageError();
    }

    public byte[] readNBytes(int len) throws java.io.IOException {
        throw new LinkageError();
    }

    public synchronized void reset() throws java.io.IOException {
        throw new LinkageError();
    }

    public long skip(long n) throws java.io.IOException {
        throw new LinkageError();
    }

    public long transferTo(OutputStream output) throws java.io.IOException {
        throw new LinkageError();
    }
}
