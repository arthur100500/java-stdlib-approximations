package generated.org.springframework.boot.resolvers;

import generated.org.springframework.boot.pinnedValues.PinnedValueSource;
import generated.org.springframework.boot.pinnedValues.PinnedValueStorage;
import org.jacodb.approximation.annotation.Approximate;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMethodArgumentResolver;

@Approximate(PathVariableMethodArgumentResolver.class)
public class PathVariableMethodArgumentResolverImpl {
    @Nullable
    protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
        if (parameter.getParameterName() == null)
            return null;

        if (!request.getContextPath().contains(String.format("{%s}", parameter.getParameterName())))
            return null;

        return PinnedValueStorage.getPinnedValue(PinnedValueSource.REQUEST_PATH_VARIABLE, name, String.class);
    }
}

