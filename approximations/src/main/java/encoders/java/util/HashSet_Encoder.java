package encoders.java.util;

import generated.java.util.set.HashSetImpl;
import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@EncoderFor(HashSet.class)
public class HashSet_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object object) {
        HashSetImpl<Object> result = new HashSetImpl<>();
        result.addAll(Arrays.asList(((Set<?>) object).toArray()));
        return result;
    }
}
