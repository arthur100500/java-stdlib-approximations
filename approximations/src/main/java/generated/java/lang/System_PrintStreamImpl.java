package generated.java.lang;

import java.io.PrintStream;
import java.lang.CharSequence;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.lang.StringIndexOutOfBoundsException;
import java.util.Locale;

import generated.libsl.utils.VoidOutputStreamImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import stub.java.lang.System_PrintStream;

@Approximate(System_PrintStream.class)
public final class System_PrintStreamImpl {

    public boolean closed;

    public boolean error;

    public System_PrintStreamImpl(boolean closed, boolean error) {
        this.closed = closed;
        this.error = error;
    }

    private void _checkClosed() {
        if (this.closed)
            this.error = true;
    }

    public System_PrintStreamImpl append(CharSequence csq) {
        _checkClosed();
        return this;
    }

    public System_PrintStreamImpl append(CharSequence csq, int start, int end) {
        if (csq == null)
            csq = "null";
        int size = csq.length();
        if (start < 0 || end >= size)
            throw new StringIndexOutOfBoundsException();
        _checkClosed();

        return this;
    }

    public System_PrintStreamImpl append(char c) {
        _checkClosed();
        return this;
    }

    public boolean checkError() {
        return this.error;
    }

    public void close() {
        this.closed = true;
    }

    public void flush() {
        _checkClosed();
    }

    @SuppressWarnings("ConstantValue")
    public System_PrintStreamImpl format(Locale l, @NotNull String format, Object... args) {
        if (format == null)
            throw new NullPointerException();
        _checkClosed();

        return this;
    }

    @SuppressWarnings("ConstantValue")
    public System_PrintStreamImpl format(@NotNull String format, Object... args) {
        if (format == null)
            throw new NullPointerException();
        _checkClosed();

        return this;
    }

    public void print(Object obj) {
        _checkClosed();
    }

    public void print(String s) {
        _checkClosed();
    }

    public void print(boolean b) {
        _checkClosed();
    }

    public void print(char c) {
        _checkClosed();
    }

    @SuppressWarnings("ConstantValue")
    public void print(@NotNull char[] s) {
        if (s == null)
            throw new NullPointerException();
        _checkClosed();
    }

    public void print(double d) {
        _checkClosed();
    }

    public void print(float f) {
        _checkClosed();
    }

    public void print(int i) {
        _checkClosed();
    }

    public void print(long l) {
        _checkClosed();
    }

    @SuppressWarnings("ConstantValue")
    public System_PrintStreamImpl printf(Locale l, @NotNull String format, Object... args) {
        if (l == null || format == null || args == null)
            throw new NullPointerException();
        _checkClosed();

        return this;
    }

    @SuppressWarnings("ConstantValue")
    public System_PrintStreamImpl printf(@NotNull String format, Object... args) {
        if (format == null || args == null)
            throw new NullPointerException();
        _checkClosed();
        return this;
    }

    public void println() {
        _checkClosed();
    }

    public void println(Object x) {
        _checkClosed();
    }

    public void println(String x) {
        _checkClosed();
    }

    public void println(boolean x) {
        _checkClosed();
    }

    public void println(char x) {
        _checkClosed();
    }

    @SuppressWarnings("ConstantValue")
    public void println(@NotNull char[] x) {
        if (x == null)
            throw new NullPointerException();
        _checkClosed();
    }

    public void println(double x) {
        _checkClosed();
    }

    public void println(float x) {
        _checkClosed();
    }

    public void println(int x) {
        _checkClosed();
    }

    public void println(long x) {
        _checkClosed();
    }

    @SuppressWarnings("RedundantThrows")
    public void write(byte[] b) throws java.io.IOException {
        if (b == null)
            throw new NullPointerException();
        _checkClosed();
    }

    @SuppressWarnings("ConstantValue")
    public void write(@NotNull byte[] buf, int off, int len) {
        if (buf == null)
            throw new NullPointerException();
        int size = buf.length;
        if (off < 0 || off + len > size)
            throw new IndexOutOfBoundsException();
        _checkClosed();
    }

    public void write(int b) {
        _checkClosed();
    }
}
