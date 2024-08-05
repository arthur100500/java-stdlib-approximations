package decoders.java.lang;

import org.jacodb.api.jvm.JcClassOrInterface;
import org.jacodb.api.jvm.JcMethod;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.Collections;
import java.util.List;

@SuppressWarnings({"ForLoopReplaceableByForEach", "removal"})
@DecoderFor(SecurityManager.class)
public final class SecurityManager_Decoder implements ObjectDecoder {
    private volatile JcMethod cached_SecurityManager_ctor = null;

    @SuppressWarnings({"unchecked", "SizeReplaceableByIsEmpty"})
    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        JcMethod ctor = cached_SecurityManager_ctor;
        // TODO: add synchronization if needed
        if (ctor == null) {
            final List<JcMethod> methods = approximation.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i < c; i++) {
                JcMethod m = methods.get(i);

                if (m.isConstructor() && m.getParameters().size() == 0) {
                    cached_SecurityManager_ctor = ctor = m;
                    break;
                }
            }
        }

        return decoder.invokeMethod(ctor, (List<T>) Collections.EMPTY_LIST);
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approximation,
                                       final ObjectData<T> approximationData,
                                       final T outputInstance,
                                       final DecoderApi<T> decoder) {
        // nothing
    }
}
