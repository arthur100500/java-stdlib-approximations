package generated.org.springframework.boot.resolvers;

import generated.org.springframework.boot.pinnedValues.PinnedValueSource;
import generated.org.springframework.boot.pinnedValues.PinnedValueStorage;
import org.jacodb.approximation.annotation.Approximate;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.RequestHeaderMethodArgumentResolver;

@Approximate(RequestHeaderMethodArgumentResolver.class)
public class RequestHeaderMethodArgumentResolverImpl {
    protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
        return ResolverUtils.getNonEmptySymbolicString(PinnedValueSource.REQUEST_HEADER, name);
    }
}
