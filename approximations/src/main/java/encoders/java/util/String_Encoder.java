package encoders.java.util;

import generated.java.lang.StringImpl;
import org.usvm.concrete.api.encoder.EncoderFor;
import org.usvm.concrete.api.encoder.ObjectEncoder;

import java.lang.reflect.Field;

@EncoderFor(java.lang.String.class)
public class String_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object object) {
        String string = (String) object;
        Field arrayField;
        try {
            arrayField = String.class.getDeclaredField("value");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        arrayField.setAccessible(true);
        boolean isDefault;
        try {
            isDefault = arrayField.get(string) == null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        byte[] bytes = isDefault ? new byte[0] : string.getBytes();
        return new StringImpl(bytes);
    }
}
