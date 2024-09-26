package encoders.java.util;

import generated.java.lang.StringBuilderImpl;
import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

@EncoderFor(java.lang.StringBuilder.class)
public class StringBuilder_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object object) {
        StringBuilder sb = (StringBuilder) object;
        return new StringBuilderImpl(sb.toString());
    }
}
