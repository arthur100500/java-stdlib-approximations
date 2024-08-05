package encoders.java.util;

import generated.java.lang.StringImpl;
import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

@EncoderFor(java.lang.String.class)
public class String_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object object) {
        return new StringImpl(((String) object).getBytes());
    }
}
