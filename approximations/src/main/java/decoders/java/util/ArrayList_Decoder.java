package decoders.java.util;

import org.jacodb.api.jvm.JcClassOrInterface;
import org.jacodb.api.jvm.JcField;
import org.jacodb.api.jvm.JcMethod;
import org.jacodb.api.jvm.JcParameter;
import org.usvm.api.SymbolicList;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("ForLoopReplaceableByForEach")
@DecoderFor(ArrayList.class)
public class ArrayList_Decoder implements ObjectDecoder {
    private volatile JcField cached_ArrayList_storage = null;
    private volatile JcMethod cached_ArrayList_ctor = null;
    private volatile JcMethod cached_ArrayList_add = null;

    @SuppressWarnings({"unchecked"})
    @Override
    public <T> T createInstance(final JcClassOrInterface approx,
                                final ObjectData<T> approxData,
                                final DecoderApi<T> decoder) {
        JcMethod m_ctor = cached_ArrayList_ctor;
        // TODO: add synchronization if needed
        if (m_ctor == null) {
            JcMethod m_add = null;
            final List<JcMethod> methods = approx.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i < c; i++) {
                JcMethod m = methods.get(i);

                if (m.isConstructor()) {
                    if (m_ctor == null) {
                        if (!m.getParameters().isEmpty()) continue;

                        cached_ArrayList_ctor = m_ctor = m;
                    }
                } else {
                    if (m_add == null) {
                        if (!"add".equals(m.getName())) continue;

                        List<JcParameter> params = m.getParameters();
                        if (params.size() != 1) continue;

                        cached_ArrayList_add = m_add = m;
                    }
                }

                if (m_ctor != null && m_add != null)
                    break;
            }
        }

        return decoder.invokeMethod(m_ctor, (List<T>) Collections.EMPTY_LIST);
    }

    private static List<JcField> getAllFields(JcClassOrInterface clazz) {
        JcClassOrInterface superclass = clazz.getSuperClass();
        if (superclass == null) {
            return clazz.getDeclaredFields();
        }
        List<JcField> declaredFields = clazz.getDeclaredFields();
        declaredFields.addAll(getAllFields(superclass));
        return declaredFields;
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approx,
                                       final ObjectData<T> approxData,
                                       final T instance,
                                       final DecoderApi<T> decoder) {
        JcField f_storage = cached_ArrayList_storage;
        // TODO: add synchronization if needed
        if (f_storage == null) {
            final List<JcField> fields = getAllFields(approx);
            for (int i = 0, c = fields.size(); i < c; i++) {
                JcField f = fields.get(i);
                if ("storage".equals(f.getName())) {
                    cached_ArrayList_storage = f_storage = f;
                    break;
                }
            }
        }

        if (approxData.getObjectField(f_storage) == null)
            return; // ignore invalid containers

        final SymbolicList<T> storage = approxData.decodeSymbolicListField(f_storage);
        if (storage == null)
            return; // ignore invalid container

        for (int i = 0, c = storage.size(); i < c; i++) {
            List<T> args = new ArrayList<>();
            args.add(instance);
            args.add(storage.get(i));

            decoder.invokeMethod(cached_ArrayList_add, args);
        }
    }
}
