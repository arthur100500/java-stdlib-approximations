package decoders.java.util;

import org.jacodb.api.jvm.JcClassOrInterface;
import org.jacodb.api.jvm.JcField;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;
import stub.java.util.map.AbstractMap_Entry;

import java.util.List;

@DecoderFor(AbstractMap_Entry.class)
public class AbstractMap_Entry_Decoder implements ObjectDecoder {
    private volatile JcField cached_Entry_value = null;

    @SuppressWarnings({"ForLoopReplaceableByForEach"})
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

        return approxData.getObjectField(f_value) != null
                ? approxData.decodeField(f_value)
                : null;
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approx,
                                       final ObjectData<T> approxData,
                                       final T instance,
                                       final DecoderApi<T> decoder) {
    }
}
