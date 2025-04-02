package encoders.java.util;

import generated.java.util.map.ConcurrentHashMapImpl;
import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

import java.util.concurrent.ConcurrentHashMap;

@EncoderFor(ConcurrentHashMap.class)
public class ConcurrentHashMap_Encoder implements ObjectEncoder {

    @SuppressWarnings("unchecked")
    @Override
    public Object encode(Object object) {
        ConcurrentHashMap<Object, Object> map = (ConcurrentHashMap<Object, Object>) object;
        return new ConcurrentHashMapImpl<>(map);
    }
}
