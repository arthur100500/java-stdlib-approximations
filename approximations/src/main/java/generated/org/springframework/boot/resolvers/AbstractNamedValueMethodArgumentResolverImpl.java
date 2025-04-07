package generated.org.springframework.boot.resolvers;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.lang.Nullable;
import org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver;

@Approximate(AbstractNamedValueMethodArgumentResolver.class)
public class AbstractNamedValueMethodArgumentResolverImpl {
    @Nullable
    private Object handleNullValue(String name, @Nullable Object value, Class<?> paramType) {
        // well be propagated to convertIfNecessary and symbolized there
        return value;
    }
}
