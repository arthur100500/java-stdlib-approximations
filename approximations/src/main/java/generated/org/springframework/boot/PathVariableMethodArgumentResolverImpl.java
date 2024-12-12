package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import static generated.org.springframework.boot.SymbolicValueFactory.createSymbolic;

@Approximate(org.springframework.web.servlet.mvc.method.annotation.PathVariableMethodArgumentResolver.class)
public class PathVariableMethodArgumentResolverImpl {

    public final Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer,
                                        NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {
        Class<?> paramType = parameter.getParameterType();
        MockHttpServletRequest req = webRequest.getNativeRequest(MockHttpServletRequest.class);
        // TODO: mb rework #CM
        String path = (String) req.getAttribute("org.springframework.web.servlet.HandlerMapping.bestMatchingPattern");
        PathVariable annotation = parameter.getParameterAnnotation(PathVariable.class);
        String name = annotation.name();
        if (name.isEmpty())
            name = parameter.getParameterName();
//        boolean required = true;
//        if (annotation != null)
//            required = annotation.required();
        if (path.contains("{" + name + "}"))
            return createSymbolic(paramType, false);

        return null;
    }
}
