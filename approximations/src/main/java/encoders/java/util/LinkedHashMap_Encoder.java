package encoders.java.util;

import generated.java.util.map.LinkedHashMapImpl;
import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

import java.util.LinkedHashMap;

@SuppressWarnings("unused")
@EncoderFor(LinkedHashMap.class)
public class LinkedHashMap_Encoder implements ObjectEncoder {

    @SuppressWarnings("unchecked")
    @Override
    public Object encode(Object object) {
        LinkedHashMap<Object, Object> map = (LinkedHashMap<Object, Object>) object;
        return new LinkedHashMapImpl<>(map);
    }
}
