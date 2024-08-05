package encoders.java.util;

import generated.java.lang.ThreadLocalImpl;
import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

@EncoderFor(java.lang.ThreadLocal.class)
public class ThreadLocal_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object object) {
        return new ThreadLocalImpl<>();
    }
}
