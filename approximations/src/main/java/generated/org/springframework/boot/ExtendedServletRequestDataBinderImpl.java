package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import java.lang.reflect.Field;

import static generated.org.springframework.boot.SymbolicValueFactory.createSymbolic;

@Approximate(ExtendedServletRequestDataBinder.class)
public class ExtendedServletRequestDataBinderImpl extends DataBinderImpl {

    private static boolean _isPrimitive(Class<?> type) {
        return type.isPrimitive() || String.class.equals(type);
    }

    protected void applyPropertyValues(MutablePropertyValues mpvs) throws IllegalAccessException {
        Class<?> currentClass = target.getClass();
        while (currentClass != Object.class) {
            for (Field field : currentClass.getDeclaredFields()) {
                Class<?> fieldType = field.getType();
                if (_isPrimitive(fieldType))
                    field.set(target, createSymbolic(fieldType, false));
            }
            currentClass = currentClass.getSuperclass();
        }
    }
}
