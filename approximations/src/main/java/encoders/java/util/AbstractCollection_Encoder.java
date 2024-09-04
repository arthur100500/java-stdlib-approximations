package encoders.java.util;

import generated.java.util.list.ArrayListImpl;
import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

import java.util.AbstractCollection;

@EncoderFor(AbstractCollection.class)
public class AbstractCollection_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object object) {
        return new ArrayListImpl<>();
    }
}
