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

import java.util.*;

import static org.usvm.api.decoder.DecoderUtils.findStorageField;

@SuppressWarnings("ForLoopReplaceableByForEach")
@DecoderFor(LinkedList.class)
public class LinkedList_Decoder implements ObjectDecoder {
    private volatile JcMethod cached_LinkedList_ctor = null;
    private volatile JcField cached_LinkedList_storage = null;
    private volatile JcMethod cached_LinkedList_add = null;

    @SuppressWarnings("unchecked")
    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        JcMethod m_ctor = cached_LinkedList_ctor;
        // TODO: add synchronization if needed
        if (m_ctor == null) {
            JcMethod m_add = null;
            final List<JcMethod> methods = approximation.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i < c; i++) {
                JcMethod m = methods.get(i);

                if (m.isConstructor()) {
                    if (m_ctor == null) {
                        if (!m.getParameters().isEmpty()) continue;

                        cached_LinkedList_ctor = m_ctor = m;
                    }
                } else {
                    if (m_add == null) {
                        if (!"add".equals(m.getName())) continue;

                        List<JcParameter> params = m.getParameters();
                        if (params.size() != 1) continue;
                        if (!"java.lang.Object".equals(params.get(0).getType().getTypeName())) continue;

                        cached_LinkedList_add = m_add = m;
                    }
                }

                if (m_ctor != null && m_add != null)
                    break;
            }
        }

        return decoder.invokeMethod(m_ctor, (List<T>) Collections.EMPTY_LIST);
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approximation,
                                       final ObjectData<T> approximationData,
                                       final T outputInstance,
                                       final DecoderApi<T> decoder) {
        JcField f_storage = cached_LinkedList_storage;
        // TODO: add synchronization if needed
        if (f_storage == null) {
            cached_LinkedList_storage = f_storage = findStorageField(approximation);
        }

        if (approximationData.getObjectField(f_storage) == null)
            return;

        final SymbolicList<T> storage = approximationData.decodeSymbolicListField(f_storage);
        if (storage == null)
            return;

        for (int i = 0, c = storage.size(); i < c; i++) {
            ArrayList<T> args = new ArrayList<>();
            args.add(outputInstance);
            args.add(storage.get(i));
            decoder.invokeMethod(cached_LinkedList_add, args);
        }
    }
}
