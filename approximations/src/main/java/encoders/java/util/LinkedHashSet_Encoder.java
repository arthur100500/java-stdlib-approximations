package encoders.java.util;

import generated.java.util.set.LinkedHashSetImpl;
import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

import java.util.LinkedHashSet;

@EncoderFor(LinkedHashSet.class)
public class LinkedHashSet_Encoder implements ObjectEncoder {

    @Override
    @SuppressWarnings("unchecked")
    public Object encode(Object object) {
        LinkedHashSet<Object> set = (LinkedHashSet<Object>) object;
        return new LinkedHashSetImpl<>(set);
    }
}
