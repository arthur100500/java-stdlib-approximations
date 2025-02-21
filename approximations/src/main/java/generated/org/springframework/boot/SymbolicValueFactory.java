package generated.org.springframework.boot;

import org.usvm.api.Engine;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SymbolicValueFactory {

    private static Object createSymbolicWithSameType(Class<?> type, boolean makeNullable) {
        if (makeNullable)
            return Engine.makeNullableSymbolic(type);

        return Engine.makeSymbolic(type);
    }

    private static Object createSymbolicSubtype(Class<?> type, boolean makeNullable) {
        if (makeNullable)
            return Engine.makeNullableSymbolicSubtype(type);

        return Engine.makeSymbolicSubtype(type);
    }

    public static Object createSymbolic(Class<?> type, boolean makeNullable) {
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

        if (type.isArray())
            return Engine.makeSymbolicArray(type, Engine.makeSymbolicInt());

        if (type.isInterface() || Modifier.isAbstract(type.getModifiers())) {
            if (type.isAssignableFrom(ArrayList.class))
                return createSymbolicWithSameType(ArrayList.class, makeNullable);
            if (type.isAssignableFrom(HashSet.class))
                return createSymbolicWithSameType(HashSet.class, makeNullable);
            if (type.isAssignableFrom(HashMap.class))
                return createSymbolicWithSameType(HashMap.class, makeNullable);

            return createSymbolicSubtype(type, makeNullable);
        }

        return createSymbolicWithSameType(type, makeNullable);
    }
}
