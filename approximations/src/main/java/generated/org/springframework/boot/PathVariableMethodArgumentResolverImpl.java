package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.usvm.api.Engine;

@Approximate(org.springframework.web.servlet.mvc.method.annotation.PathVariableMethodArgumentResolver.class)
public class PathVariableMethodArgumentResolverImpl {

    private static boolean argIsInjected(String typeName) {
        return typeName.equals("org.springframework.ui.Model")
                || typeName.equals("org.springframework.ui.ModelMap")
                || typeName.contains("java.util.Map") // TODO: Map<String, Object>
                || typeName.contains("org.springframework.validation.BindingResult");
    }

    private static Object createSymbolic(Class<?> type) {
        if (type == boolean.class)
            return Engine.makeSymbolicBoolean();
        if (type == int.class)
            return Engine.makeSymbolicInt();
        if (type == long.class)
            return Engine.makeSymbolicLong();
        if (type == float.class)
            return Engine.makeSymbolicFloat();
        if (type == byte.class)
            return Engine.makeSymbolicByte();
        if (type == char.class)
            return Engine.makeSymbolicChar();
        if (type == short.class)
            return Engine.makeSymbolicShort();

        return Engine.makeSymbolic(type);
    }

    public final Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer,
                                        NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {
        Class<?> paramType = parameter.getParameterType();
        return createSymbolic(paramType);
    }
}
