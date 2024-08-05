package generated.java.util.zip;

import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.AssertionError;
import java.lang.NullPointerException;
import java.lang.SuppressWarnings;
import java.nio.ByteBuffer;
import java.util.zip.Checksum;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import sun.nio.ch.DirectBuffer;

@SuppressWarnings("unused")
@Approximate(java.util.zip.CRC32.class)
public class CRC32 implements Checksum {
    static {
        Engine.assume(true);
    }

    public int crc;

    public CRC32(int value) {
        this.crc = value;
    }

    public CRC32() {
        this(0);
    }

    private void _updateCheck(byte[] b, int off, int len) {
        if (b == null)
            throw new NullPointerException();

        if (off < 0 || len < 0 || off > b.length - len)
            throw new ArrayIndexOutOfBoundsException();
    }

    private int _updateByteBuffer(long addr) {
        if (addr == 0L)
            throw new NullPointerException();

        return Engine.makeSymbolicInt();
    }

    @SuppressWarnings("ConstantValue")
    private void _updateBytesCheck(byte[] b, int off, int len) {
        if (len == 0)
            return;

        if (b == null)
            throw new NullPointerException();

        int b_size = b.length;
        Engine.assume(b_size >= 0);
        if (off < 0 || off >= b_size)
            throw new ArrayIndexOutOfBoundsException(off);

        int endIndex = off + len - 1;
        if (endIndex < 0 || endIndex >= b_size)
            throw new ArrayIndexOutOfBoundsException(endIndex);
    }

    public long getValue() {
        return ((long) this.crc) & 4294967295L;
    }

    public void reset() {
        this.crc = 0;
    }

    @SuppressWarnings({"ConstantValue", "PatternVariableCanBeUsed"})
    public void update(ByteBuffer buffer) {
        int pos = buffer.position();
        int limit = buffer.limit();
        if (pos > limit)
            throw new AssertionError();

        int rem = limit - pos;
        if (rem <= 0)
            return;

        if (buffer instanceof DirectBuffer) {
            DirectBuffer directBuffer = (DirectBuffer) buffer;
            long address = directBuffer.address();
            this.crc = _updateByteBuffer(address);
            buffer.position(limit);
            return;
        }

        if (buffer.hasArray()) {
            int off = buffer.arrayOffset() + pos;
            byte[] bufferArray = buffer.array();
            _updateBytesCheck(bufferArray, off, rem);
            this.crc = Engine.makeSymbolicInt();
            buffer.position(limit);
            return;
        }

        int len = 4096;
        int b_rem = buffer.remaining();
        if (b_rem < len)
            len = b_rem;
        byte[] b = new byte[len];
        int b_size = b.length;
        Engine.assume(b_size >= 0);
        while (buffer.hasRemaining()) {
            int length = buffer.remaining();
            if (b_size < length)
                length = b_size;
            buffer.get(b, 0, length);
            _updateCheck(b, 0, length);
            _updateBytesCheck(b, 0, length);
        }
        this.crc = Engine.makeSymbolicInt();
        buffer.position(limit);
    }

    @SuppressWarnings("ConstantValue")
    public void update(byte[] b) {
        int len = b.length;
        Engine.assume(len >= 0);
        _updateCheck(b, 0, len);
        _updateBytesCheck(b, 0, len);
        this.crc = Engine.makeSymbolicInt();
    }

    public void update(byte[] b, int off, int len) {
        _updateCheck(b, off, len);
        _updateBytesCheck(b, off, len);
        this.crc = Engine.makeSymbolicInt();
    }

    public void update(int b) {
        this.crc = Engine.makeSymbolicInt();
    }
}
