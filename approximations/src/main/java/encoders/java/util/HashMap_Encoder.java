package encoders.java.util;

import generated.java.util.map.HashMapImpl;
import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

import java.util.HashMap;

@SuppressWarnings("unused")
@EncoderFor(HashMap.class)
public class HashMap_Encoder implements ObjectEncoder {

    @SuppressWarnings("unchecked")
    @Override
    public Object encode(Object object) {
        HashMap<Object, Object> map = (HashMap<Object, Object>) object;
        return new HashMapImpl<>(map);
    }
}
