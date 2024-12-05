package generated.org.springframework.boot.resolvers;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import stub.java.util.map.RequestMap;

@Approximate(PathVariableMapMethodArgumentResolverImpl.class)
public class PathVariableMapMethodArgumentResolverImpl {
    public Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {
        return new RequestMap("PATH");
    }
}
