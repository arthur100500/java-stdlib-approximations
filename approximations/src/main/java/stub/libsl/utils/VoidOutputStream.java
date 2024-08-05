package stub.libsl.utils;

import org.jetbrains.annotations.NotNull;

import java.io.OutputStream;
import java.lang.LinkageError;
import java.lang.SuppressWarnings;

@SuppressWarnings("RedundantThrows")
public final class VoidOutputStream extends OutputStream {

    @SuppressWarnings("unused")
    public VoidOutputStream(boolean p1) {
        throw new LinkageError();
    }

    public void close() {
        throw new LinkageError();
    }

    public void flush() throws java.io.IOException {
        throw new LinkageError();
    }

    public void write(@NotNull byte[] b) throws java.io.IOException {
        throw new LinkageError();
    }

    public void write(@NotNull byte[] b, int off, int len) throws java.io.IOException {
        throw new LinkageError();
    }

    public void write(int b) throws java.io.IOException {
        throw new LinkageError();
    }
}
