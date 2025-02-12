package decoders.java.util;

import org.jacodb.api.jvm.JcClassOrInterface;
import org.jacodb.api.jvm.JcField;
import org.usvm.api.decoder.*;
import stub.java.util.map.AbstractMap_Entry;

import java.util.List;

@DecoderFor(AbstractMap_Entry.class)
public class AbstractMap_Entry_Decoder implements ObjectDecoder {
    private volatile JcField cached_Entry_value = null;

    @SuppressWarnings({"ForLoopReplaceableByForEach", "unchecked"})
    @Override
    public <T> T createInstance(final JcClassOrInterface approx,
                                final ObjectData<T> approxData,
                                final DecoderApi<T> decoder) {
        JcField f_value = cached_Entry_value;
        // TODO: add synchronization if needed
        if (f_value == null) {
            final List<JcField> fields = approx.getDeclaredFields();
            for (int i = 0, c = fields.size(); i < c; i++) {
                JcField f = fields.get(i);
                if ("value".equals(f.getName())) {
                    cached_Entry_value = f_value = f;
                    break;
                }
            }
        }

        T value = approxData.decodeField(f_value);
        return (T) new InternalMapEntry<T, T>(value);
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approx,
                                       final ObjectData<T> approxData,
                                       final T instance,
                                       final DecoderApi<T> decoder) {
    }
}
