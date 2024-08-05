package generated.libsl.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.NullPointerException;
import java.lang.SuppressWarnings;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import stub.libsl.utils.VoidOutputStream;

@SuppressWarnings("unused")
@Approximate(VoidOutputStream.class)
public final class VoidOutputStreamImpl extends OutputStream {

    public volatile boolean closed;

    public VoidOutputStreamImpl(boolean p1) {
        this.closed = p1;
    }

    public void close() {
        this.closed = true;
    }

    @SuppressWarnings({"RedundantMethodOverride", "RedundantThrows"})
    public void flush() throws java.io.IOException { }

    @SuppressWarnings("ConstantValue")
    public void write(@NotNull byte[] b) throws java.io.IOException {
        if (b == null)
            throw new NullPointerException();
        if (this.closed)
            throw new IOException("Stream closed");
    }

    public void write(@NotNull byte[] b, int off, int len) throws java.io.IOException {
        SymbolicInputStreamImpl._checkFromIndexSize(off, len, b.length);
        if (this.closed)
            throw new IOException("Stream closed");
    }

    public void write(int b) throws java.io.IOException {
        if (this.closed)
            throw new IOException("Stream closed");
    }
}
