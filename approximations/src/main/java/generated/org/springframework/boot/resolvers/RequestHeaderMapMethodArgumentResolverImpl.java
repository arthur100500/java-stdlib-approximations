package generated.org.springframework.boot.resolvers;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.RequestHeaderMapMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import stub.java.util.map.RequestMap;
import stub.java.util.map.RequestMultiValueMap;

@Approximate(RequestHeaderMapMethodArgumentResolver.class)
public class RequestHeaderMapMethodArgumentResolverImpl {

    public Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {
        Class<?> paramType = parameter.getParameterType();

        if (MultiValueMap.class.isAssignableFrom(paramType))
            return new RequestMultiValueMap("HEADER");

        return new RequestMap("HEADER");
    }
}
