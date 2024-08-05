package encoders.java.util;

import generated.java.util.list.ArrayListImpl;
import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

import java.util.ArrayList;

@EncoderFor(ArrayList.class)
public class ArrayList_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object list) {
        ArrayListImpl<Object> result = new ArrayListImpl<>();
        result.addAll(((ArrayList<?>) list).stream().toList());
        return result;
    }
}
