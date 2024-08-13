package decoders.java.util;

import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

import org.jacodb.api.jvm.JcClassOrInterface;
import org.jacodb.api.jvm.JcField;
import org.jacodb.api.jvm.JcMethod;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

@DecoderFor(OptionalDouble.class)
public class OptionalDouble_Decoder implements ObjectDecoder {
    private volatile JcField cached_OptionalDouble_value = null;
    private volatile JcField cached_OptionalDouble_present = null;
    private volatile JcMethod cached_OptionalDouble_of = null;
    private volatile JcMethod cached_OptionalDouble_empty = null;

    @SuppressWarnings({"unchecked", "ForLoopReplaceableByForEach"})
    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        JcField f_present = cached_OptionalDouble_present;
        // TODO: add synchronization if needed
        if (f_present == null) {
            JcField f_value = null;
            final List<JcField> fields = approximation.getDeclaredFields();
            for (int i = 0, c = fields.size(); i < c; i++) {
                JcField f = fields.get(i);
                String name = f.getName();

                if ("value".equals(name)) {
                    f_value = f;
                } else if ("isPresent".equals(name)) {
                    f_present = f;
                }

                if (f_value != null && f_present != null)
                    break;
            }
            cached_OptionalDouble_present = f_present;
            cached_OptionalDouble_value = f_value;
        }

        if (approximationData.getBooleanField(f_present)) {
            JcMethod m_of = cached_OptionalDouble_of;
            // TODO: add synchronization if needed
            if (m_of == null) {
                final List<JcMethod> methods = approximation.getDeclaredMethods();
                for (int i = 0, c = methods.size(); i < c; i++) {
                    JcMethod m = methods.get(i);

                    if (!m.isStatic()) continue;
                    if (!"of".equals(m.getName())) continue;

                    cached_OptionalDouble_of = m_of = m;
                    break;
                }
            }

            final double value = approximationData.getDoubleField(cached_OptionalDouble_value);
            return decoder.invokeMethod(m_of, Collections.singletonList(
                    decoder.createDoubleConst(value)
            ));
        } else {
            JcMethod m_empty = cached_OptionalDouble_empty;
            // TODO: add synchronization if needed
            if (m_empty == null) {
                final List<JcMethod> methods = approximation.getDeclaredMethods();
                for (int i = 0, c = methods.size(); i < c; i++) {
                    JcMethod m = methods.get(i);

                    if (!m.isStatic()) continue;
                    if (!"empty".equals(m.getName())) continue;

                    cached_OptionalDouble_empty = m_empty = m;
                    break;
                }
            }
            return decoder.invokeMethod(m_empty, (List<T>) Collections.EMPTY_LIST);
        }
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approximation,
                                       final ObjectData<T> approximationData,
                                       final T outputInstance,
                                       final DecoderApi<T> decoder) {
        // nothing
    }
}
