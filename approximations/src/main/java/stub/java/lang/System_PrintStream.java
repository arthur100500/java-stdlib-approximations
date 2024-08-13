package stub.java.lang;

import org.jetbrains.annotations.NotNull;

import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.CharSequence;
import java.lang.LinkageError;
import java.lang.Object;
import java.lang.String;
import java.util.Locale;

public final class System_PrintStream extends PrintStream {

    @SuppressWarnings({"DataFlowIssue", "unused"})
    public System_PrintStream(boolean closed, boolean error) {
        super((OutputStream) null);
        throw new LinkageError();
    }

    public System_PrintStream append(CharSequence csq) {
        throw new LinkageError();
    }

    public System_PrintStream append(CharSequence csq, int start, int end) {
        throw new LinkageError();
    }

    public System_PrintStream append(char c) {
        throw new LinkageError();
    }

    public boolean checkError() {
        throw new LinkageError();
    }

    public void close() {
        throw new LinkageError();
    }

    public void flush() {
        throw new LinkageError();
    }

    public System_PrintStream format(Locale l, @NotNull String format, Object... args) {
        throw new LinkageError();
    }

    public System_PrintStream format(@NotNull String format, Object... args) {
        throw new LinkageError();
    }

    public void print(Object obj) {
        throw new LinkageError();
    }

    public void print(String s) {
        throw new LinkageError();
    }

    public void print(boolean b) {
        throw new LinkageError();
    }

    public void print(char c) {
        throw new LinkageError();
    }

    public void print(@NotNull char[] s) {
        throw new LinkageError();
    }

    public void print(double d) {
        throw new LinkageError();
    }

    public void print(float f) {
        throw new LinkageError();
    }

    public void print(int i) {
        throw new LinkageError();
    }

    public void print(long l) {
        throw new LinkageError();
    }

    public System_PrintStream printf(Locale l, @NotNull String format, Object... args) {
        throw new LinkageError();
    }

    public System_PrintStream printf(@NotNull String format, Object... args) {
        throw new LinkageError();
    }

    public void println() {
        throw new LinkageError();
    }

    public void println(Object x) {
        throw new LinkageError();
    }

    public void println(String x) {
        throw new LinkageError();
    }

    public void println(boolean x) {
        throw new LinkageError();
    }

    public void println(char x) {
        throw new LinkageError();
    }

    public void println(@NotNull char[] x) {
        throw new LinkageError();
    }

    public void println(double x) {
        throw new LinkageError();
    }

    public void println(float x) {
        throw new LinkageError();
    }

    public void println(int x) {
        throw new LinkageError();
    }

    public void println(long x) {
        throw new LinkageError();
    }

    public void write(byte[] b) throws java.io.IOException {
        throw new LinkageError();
    }

    public void write(@NotNull byte[] buf, int off, int len) {
        throw new LinkageError();
    }

    public void write(int b) {
        throw new LinkageError();
    }
}
