package decoders.java.util;

import org.jacodb.api.jvm.*;
import org.usvm.api.SymbolicMap;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@DecoderFor(HashSet.class)
public final class HashSet_Decoder implements ObjectDecoder {
    private volatile JcMethod[] cachedMethods = null;
    private volatile JcMethod cached_HashSet_ctor = null;
    private volatile JcMethod cached_HashSet_add = null;
    private volatile JcField cached_HashSet_storage = null;
    private volatile JcField cached_Map_map = null;
    private volatile JcField cached_HashMapContainer_map = null;

    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        JcMethod ctor = cached_HashSet_ctor;
        // TODO: add synchronization if needed
        if (ctor == null) {
            final List<JcMethod> methodList = approximation.getDeclaredMethods();
            final int methodCount = methodList.size();
            JcMethod[] methods = new JcMethod[methodCount];
            cachedMethods = methods = methodList.toArray(methods);

            for (int i = 0; i != methodCount; i++) {
                JcMethod m = methods[i];

                if (m.isConstructor()) {
                    List<JcParameter> params = m.getParameters();

                    // example: looking for java.util.HashSet.HashSet(int, float)
                    if (params.size() != 2) continue;
                    if (!"int".equals(params.get(0).getType().getTypeName())) continue;
                    if (!"float".equals(params.get(1).getType().getTypeName())) continue;

                    // update global "cache" and stop the search
                    cached_HashSet_ctor = ctor = m;
                    break;
                }
            }
        }

        // prepare parameters "in-place" and construct a new call
        final List<T> args = new ArrayList<>(2);
        args.add(decoder.createIntConst(16));
        args.add(decoder.createFloatConst(0.75f));
        return decoder.invokeMethod(ctor, args);
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approximation,
                                       final ObjectData<T> approximationData,
                                       final T outputInstance,
                                       final DecoderApi<T> decoder) {
        JcField f_hs_storage = cached_HashSet_storage;
        // TODO: add synchronization if needed
        if (f_hs_storage == null) {
            final List<JcField> fields = approximation.getDeclaredFields();
            for (int i = 0, c = fields.size(); i != c; i++) {
                JcField field = fields.get(i);
                String fieldName = field.getName();

                if (!"storage".equals(fieldName)) continue;

                // early termination
                cached_HashSet_storage = f_hs_storage = field;
                break;
            }
        }

        // skip erroneous objects
        final ObjectData<T> storageData = approximationData.getObjectField(f_hs_storage);
        if (storageData == null)
            return;

        // get primary method
        JcMethod m_add = cached_HashSet_add;
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
            cached_HashSet_add = m_add;
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
            return; // ignore invalid containers

        final SymbolicMap<T, T> map = rtMapContainerData.decodeSymbolicMapField(cached_HashMapContainer_map);
        if (map == null)
            return; // ignore invalid containers

        int length = map.size();
        if (length == Integer.MAX_VALUE)
            return; // ignore invalid containers

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
