package generated.org.springframework.boot;

import generated.org.springframework.boot.pinnedValues.PinnedValueSource;
import generated.org.springframework.boot.pinnedValues.PinnedValueStorage;
import generated.org.springframework.boot.resolvers.ResolverUtils;
import jakarta.servlet.ServletRequest;
import org.jacodb.approximation.annotation.Approximate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.util.ObjectUtils;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.support.DefaultDataBinderFactory;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.usvm.api.Engine;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Approximate(ServletRequestDataBinder.class)
public class ServletRequestDataBinderImpl extends ServletRequestDataBinder {

    private static final String FIELD_SEPARATOR = ".";
    private static final int MAX_ARRAY_INDEX = 2;
    private static final int MAX_DEPTH = 5;

    public ServletRequestDataBinderImpl(Object target) {
        super(target);
    }

    public void bind(ServletRequest request) {
        symbolicBind(
                getTarget(),
                getType(),
                "",
                0
        );
        SpringApplicationImpl._println("Bind finished");
    }

    private Class<?> getType() {
        if (getTargetType() != null)
            return getTargetType().toClass();

        if (getTarget() != null)
            return getTarget().getClass();

        return null;
    }

    private static Map<String, List<String>> _getFieldTypes(Class<?> target) {
        throw new IllegalStateException("This method must be approximated");
    }

    private Object getInputData(String name, Class<?> clazz) {
        return PinnedValueStorage.getPinnedValue(PinnedValueSource.REQUEST_PARAM, name, clazz);
    }

    private static void writeField(Object target, String fieldName, Object value) {
        Field field = ReflectionUtils.findField(target.getClass(), fieldName);
        field.setAccessible(true);
        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            SpringApplicationImpl._println(String.format(
                    "Warning! Field %s of class %s could not be set due to IllegalAccessException!",
                    fieldName,
                    target.getClass().getName()
            ));
        }
    }

    private Object allocateDefault(Class<?> clazz) {
        try {
            Constructor<?> ctor = clazz.getDeclaredConstructor();
            return BeanUtils.instantiateClass(ctor);
        } catch (NoSuchMethodException e) {
            SpringApplicationImpl._println(String.format(
                    "Warning! Class %s has no default parameterless constructor!",
                    clazz.getName()
            ));
        }
        return null;
    }

        private void writeArrayIndex(
            Object target,
            String arrayFieldName,
            int index,
            Object value
    ) {
        // TODO: #AA
        SpringApplicationImpl._println("Warning! Writing array indices is unsupported yet");
    }

    private boolean canWriteField(String fieldName, Class<?> fieldType) {
        List<Class<?>> prohibitedTypes = List.of(Set.class);
        if (prohibitedTypes.stream().anyMatch(t -> t.isAssignableFrom(fieldType)))
            return false;
        String[] allowed = getAllowedFields();
        String[] disallowed = getDisallowedFields();
        return ((ObjectUtils.isEmpty(allowed) || PatternMatchUtils.simpleMatch(allowed, fieldName)) &&
                (ObjectUtils.isEmpty(disallowed) || !PatternMatchUtils.simpleMatch(disallowed, fieldName.toLowerCase())));
    }

    private void symbolicBind(
            Object target,
            Class<?> clazz,
            String prefix,
            int depth
    ) {
        // TODO: Later check: primitive arrays, boxed types #AA
//        if (Engine.makeSymbolicBoolean()) {
//            return;
//        }

        if (clazz == null)
            return;

        if (depth > MAX_DEPTH)
            return;

        Map<String, List<String>> fieldData = _getFieldTypes(clazz);

        for (String fieldName : fieldData.keySet()) {
            List<String> typeAndGenerics = fieldData.get(fieldName);
            String className = typeAndGenerics.get(0);
            String fieldFullName = prefix.isEmpty()
                    ? fieldName
                    : prefix + FIELD_SEPARATOR + fieldName;
            SpringApplicationImpl._println(String.format("Writing %s with depth %d", fieldFullName, depth));
            try {
                Class<?> fieldType = clazz.getClassLoader().loadClass(className);

                if (!canWriteField(fieldName, fieldType)) {
                    continue;
                }

                if (ResolverUtils.isPrimitive(fieldType)) {
                    Object value = getInputData(fieldFullName, fieldType);
                    Engine.assume(value != null);
                    writeField(target, fieldName, value);
                    continue;
                }

                if (fieldType.isArray() || Collection.class.isAssignableFrom(fieldType)) {
                    String genericTypeArg = typeAndGenerics.get(1);
                    Class<?> elementType = clazz.getClassLoader().loadClass(genericTypeArg);;

                    for (int i = 0; i < MAX_ARRAY_INDEX; i++) {
                        Object value = allocateDefault(elementType);
                        String nameWithIndex = String.format("%s[%d]", fieldFullName, i);

//                        if (Engine.makeSymbolicBoolean()) {
//                            return;
//                        }

                        writeArrayIndex(target, fieldName, i, value);
                        symbolicBind(value, elementType, nameWithIndex, depth + 1);
                    }
                    continue;
                }

                Object value = allocateDefault(fieldType);
                writeField(target, fieldName, value);
                symbolicBind(value, fieldType, fieldFullName, depth + 1);

            } catch (ClassNotFoundException e) {
                SpringApplicationImpl._println(String.format("Warning! Class %s was not found! (%s)", className, e));
            }
        }
    }
}
