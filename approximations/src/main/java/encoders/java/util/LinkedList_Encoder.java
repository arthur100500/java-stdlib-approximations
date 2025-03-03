package encoders.java.util;

import generated.java.util.list.LinkedListImpl;
import org.usvm.concrete.api.encoder.EncoderFor;
import org.usvm.concrete.api.encoder.ObjectEncoder;

import java.util.LinkedList;

@EncoderFor(LinkedList.class)
public class LinkedList_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object object) {
        LinkedList<?> list = (LinkedList<?>) object;
        return new LinkedListImpl<>(list);
    }
}
