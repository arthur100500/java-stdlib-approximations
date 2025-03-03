package encoders.java.util;

import generated.java.util.set.HashSetImpl;
import org.usvm.concrete.api.encoder.EncoderFor;
import org.usvm.concrete.api.encoder.ObjectEncoder;

import java.util.HashSet;
import java.util.Set;

@EncoderFor(HashSet.class)
public class HashSet_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object object) {
        Set<?> set = (Set<?>) object;
        return new HashSetImpl<>(set);
    }
}
