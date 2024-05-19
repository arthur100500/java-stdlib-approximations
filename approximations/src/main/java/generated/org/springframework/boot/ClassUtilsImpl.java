package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.util.ClassUtils;

@Approximate(ClassUtils.class)
public abstract class ClassUtilsImpl {

    private static String getMainPackageName() {
        throw new IllegalStateException("'getMainPackageName' should be approximated");
    }

    public static String getPackageName(Class<?> clazz) {
        if (clazz.getName().equals("StartSpringTestClass"))
            return ClassUtilsImpl.getMainPackageName();

        return clazz.getPackageName();
    }
}
