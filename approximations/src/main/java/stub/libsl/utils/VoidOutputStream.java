// Generated by the LibSL translator.  DO NOT EDIT!
// source: ?
//
package stub.libsl.utils;

import java.io.OutputStream;
import java.lang.InternalError;
import java.lang.SuppressWarnings;
import java.lang.Void;
import runtime.LibSLRuntime;

@SuppressWarnings({"all", "unchecked"})
public final class VoidOutputStream extends OutputStream implements LibSLRuntime.HasAutomaton {
    private VoidOutputStream(Void a, Void b) {
        super();
    }

    public void close() {
        throw new InternalError();
    }

    public void flush() throws java.io.IOException {
        throw new InternalError();
    }

    public void write(byte[] b) throws java.io.IOException {
        throw new InternalError();
    }

    public void write(byte[] b, int off, int len) throws java.io.IOException {
        throw new InternalError();
    }

    public void write(int b) throws java.io.IOException {
        throw new InternalError();
    }
}