package encoders.util;

import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

import java.util.ArrayList;

@EncoderFor(ArrayList.class)
public class ArrayList_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object list) {
        generated.java.util.ArrayList result = new generated.java.util.ArrayList();
        result.addAll(((ArrayList<?>) list).stream().toList());
        return result;
    }
}
