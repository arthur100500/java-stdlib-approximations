package decoders.java.util;

import org.jacodb.api.jvm.*;
import org.usvm.api.SymbolicMap;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@DecoderFor(LinkedHashSet.class)
public class LinkedHashSet_Decoder implements ObjectDecoder {
    private volatile JcMethod[] cachedMethods = null;
    private volatile JcMethod cached_LinkedHashSet_ctor = null;
    private volatile JcMethod cached_LinkedHashSet_add = null;
    private volatile JcField cached_LinkedHashSet_storage = null;
    private volatile JcField cached_Map_map = null;
    private volatile JcField cached_HashMapContainer_map = null;

    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        JcMethod m_ctor = cached_LinkedHashSet_ctor;
        // TODO: add synchronization if needed
        if (m_ctor == null) {
            final List<JcMethod> methodList = approximation.getDeclaredMethods();
            final int methodCount = methodList.size();
            JcMethod[] methods = new JcMethod[methodCount];
            cachedMethods = methods = methodList.toArray(methods);

            for (int i = 0; i != methodCount; i++) {
                JcMethod m = methods[i];

                if (m.isConstructor()) {
                    List<JcParameter> params = m.getParameters();

                    // example: looking for java.util.LinkedHashSet.LinkedHashSet()
                    if (!params.isEmpty()) continue;

                    // update global "cache" and stop the search
                    cached_LinkedHashSet_ctor = m_ctor = m;
                    break;
                }
            }
        }

        // prepare parameters "in-place" and construct a new call
        final ArrayList<T> args = new ArrayList<>();
        return decoder.invokeMethod(m_ctor, args);
    }

    private static List<JcField> getAllFields(JcClassOrInterface clazz) {
        JcClassOrInterface superclass = clazz.getSuperClass();
        if (superclass == null) {
            return clazz.getDeclaredFields();
        }
        List<JcField> declaredFields = new ArrayList<>(clazz.getDeclaredFields());
        declaredFields.addAll(getAllFields(superclass));
        return declaredFields;
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approximation,
                                       final ObjectData<T> approximationData,
                                       final T outputInstance,
                                       final DecoderApi<T> decoder) {
        JcField f_hs_storage = cached_LinkedHashSet_storage;
        // TODO: add synchronization if needed
        if (f_hs_storage == null) {
            final List<JcField> fields = getAllFields(approximation);
            for (int i = 0, c = fields.size(); i != c; i++) {
                JcField field = fields.get(i);
                String fieldName = field.getName();

                if (!"storage".equals(fieldName)) continue;

                // early termination
                cached_LinkedHashSet_storage = f_hs_storage = field;
                break;
            }
        }

        // skip empty or erroneous objects
        final ObjectData<T> storageData = approximationData.getObjectField(f_hs_storage);
        if (storageData == null)
            return;

        // get primary method
        JcMethod m_add = cached_LinkedHashSet_add;
        // TODO: add synchronization if needed
        if (m_add == null) {
            final JcMethod[] methods = cachedMethods;
            for (int i = 0, c = methods.length; i != c; i++) {
                JcMethod m = methods[i];

                if (!"add".equals(m.getName())) continue;
                List<JcParameter> params = m.getParameters();
                if (params.size() != 1) continue;
                if (!"java.lang.Object".equals(params.get(0).getType().getTypeName())) continue;

                m_add = m;
                break;
            }
            cached_LinkedHashSet_add = m_add;
        }

        // prepare field references (inlined)
        JcField f_m_map = cached_Map_map;
        // TODO: add synchronization if needed
        if (f_m_map == null) {
            JcClasspath cp = approximation.getClasspath();
            {
                List<JcField> fields = cp.findClassOrNull("runtime.LibSLRuntime$Map").getDeclaredFields();
                for (int i = 0, c = fields.size(); i != c; i++) {
                    JcField field = fields.get(i);

                    if ("map".equals(field.getName())) {
                        cached_Map_map = f_m_map = field;
                        break;
                    }
                }
            }
            {
                List<JcField> fields = cp.findClassOrNull("runtime.LibSLRuntime$HashMapContainer").getDeclaredFields();
                for (int i = 0, c = fields.size(); i != c; i++) {
                    JcField field = fields.get(i);

                    if ("map".equals(field.getName())) {
                        cached_HashMapContainer_map = field;
                        break;
                    }
                }
            }
        }

        // get and parse the underlying symbolic map
        final ObjectData<T> rtMapContainerData = storageData.getObjectField(f_m_map);
        if (rtMapContainerData == null)
            return; // ignore invalid container

        final SymbolicMap<T, T> map = rtMapContainerData.decodeSymbolicMapField(cached_HashMapContainer_map);
        if (map == null)
            return; // ignore invalid container

        int length = map.size();
        if (length == Integer.MAX_VALUE)
            return; // ignore invalid container

        while (length > 0) {
            T key = map.anyKey();

            List<T> args = new ArrayList<>();
            args.add(outputInstance);
            args.add(key);
            decoder.invokeMethod(m_add, args);

            map.remove(key);
            length--;
        }
    }
}
