package decoders.java.util;

import org.jacodb.api.jvm.JcClassOrInterface;
import org.jacodb.api.jvm.JcField;
import org.jacodb.api.jvm.JcMethod;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.Collections;
import java.util.List;
import java.util.OptionalLong;

@DecoderFor(OptionalLong.class)
public class OptionalLong_Decoder implements ObjectDecoder {
    private volatile JcField cached_OptionalLong_present = null;
    private volatile JcField cached_OptionalLong_value = null;
    private volatile JcMethod cached_OptionalLong_of = null;
    private volatile JcMethod cached_OptionalLong_empty = null;

    @SuppressWarnings({"unchecked", "ForLoopReplaceableByForEach"})
    @Override
    public <T> T createInstance(final JcClassOrInterface approx,
                                final ObjectData<T> approxData,
                                final DecoderApi<T> decoder) {
        JcField f_present = cached_OptionalLong_present;
        // TODO: add synchronization if needed
        if (f_present == null) {
            JcField f_value = null;
            final List<JcField> fields = approx.getDeclaredFields();
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
            cached_OptionalLong_present = f_present;
            cached_OptionalLong_value = f_value;
        }

        if (approxData.getBooleanField(f_present)) {
            JcMethod m_of = cached_OptionalLong_of;
            // TODO: add synchronization if needed
            if (m_of == null) {
                final List<JcMethod> methods = approx.getDeclaredMethods();
                for (int i = 0, c = methods.size(); i < c; i++) {
                    JcMethod m = methods.get(i);

                    if (!m.isStatic()) continue;
                    if (!"of".equals(m.getName())) continue;

                    cached_OptionalLong_of = m_of = m;
                    break;
                }
            }

            final long value = approxData.getLongField(cached_OptionalLong_value);
            return decoder.invokeMethod(m_of, Collections.singletonList(
                    decoder.createLongConst(value)
            ));
        } else {
            JcMethod m_empty = cached_OptionalLong_empty;
            // TODO: add synchronization if needed
            if (m_empty == null) {
                final List<JcMethod> methods = approx.getDeclaredMethods();
                for (int i = 0, c = methods.size(); i < c; i++) {
                    JcMethod m = methods.get(i);

                    if (!m.isStatic()) continue;
                    if (!"empty".equals(m.getName())) continue;

                    cached_OptionalLong_empty = m_empty = m;
                    break;
                }
            }

            return decoder.invokeMethod(m_empty, (List<T>) Collections.EMPTY_LIST);
        }
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approx,
                                       final ObjectData<T> approxData,
                                       final T instance,
                                       final DecoderApi<T> decoder) {
        // nothing
    }
}
