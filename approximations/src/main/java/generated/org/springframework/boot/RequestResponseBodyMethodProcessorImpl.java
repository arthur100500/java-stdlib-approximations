package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import static generated.org.springframework.boot.SymbolicValueFactory.createSymbolic;

@Approximate(RequestResponseBodyMethodProcessor.class)
public class RequestResponseBodyMethodProcessorImpl {

    // TODO: Write handleReturnValue and remove this
    //    public Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer, NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {
    //        Class<?> paramType = parameter.getParameterType();
    //        RequestBody annotation = parameter.getParameterAnnotation(RequestBody.class);
    //        boolean required = true;
    //        if (annotation != null)
    //            required = annotation.required();
    //        return createSymbolic(paramType, !required);
    //    }
}
