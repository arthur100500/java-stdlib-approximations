package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import static generated.org.springframework.boot.SymbolicValueFactory.createSymbolic;

@Approximate(org.springframework.web.method.annotation.RequestParamMethodArgumentResolver.class)
public class RequestParamMethodArgumentResolverImpl {

    public final Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer,
                                        NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {
        Class<?> paramType = parameter.getParameterType();
        return createSymbolic(paramType);
    }
}
