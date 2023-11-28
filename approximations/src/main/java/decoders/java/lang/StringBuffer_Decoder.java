package decoders.java.lang;

import org.jacodb.api.JcClassOrInterface;
import org.jacodb.api.JcField;
import org.jacodb.api.JcMethod;
import org.jacodb.api.JcParameter;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.ArrayList;
import java.util.List;

@DecoderFor(StringBuffer.class)
public final class StringBuffer_Decoder implements ObjectDecoder {
    private volatile JcMethod cached_StringBuffer_ctor = null;
    private volatile JcField cached_StringBuffer_value = null;

    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        JcMethod ctor = cached_StringBuffer_ctor;
        // TODO: add synchronization if needed
        if (ctor == null) {
            // looking for constructor and data field
            final List<JcMethod> methods = approximation.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i != c; i++) {
                JcMethod m = methods.get(i);

                if (!m.isConstructor()) continue;

                List<JcParameter> params = m.getParameters();
                if (params.size() != 1) continue;
                if (!"java.lang.String".equals(params.get(0).getType().getTypeName())) continue;

                cached_StringBuffer_ctor = ctor = m;
                break;
            }

            final List<JcField> fields = approximation.getDeclaredFields();
            for (int i = 0, c = fields.size(); i != c; i++) {
                JcField f = fields.get(i);
                if ("storage".equals(f.getName())) {
                    cached_StringBuffer_value = f;
                    break;
                }
            }
        }

        // extract the info
        final JcField f_value = cached_StringBuffer_value;
        final T value = approximationData.getObjectField(f_value) != null
                ? approximationData.decodeField(f_value)
                : decoder.createStringConst("");

        // assemble into a call
        final List<T> args = new ArrayList<>();
        args.add(value);
        return decoder.invokeMethod(ctor, args);
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approximation,
                                       final ObjectData<T> approximationData,
                                       final T outputInstance,
                                       final DecoderApi<T> decoder) {
        // nothing
    }
}
