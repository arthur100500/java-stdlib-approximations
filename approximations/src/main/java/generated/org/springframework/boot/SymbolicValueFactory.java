package generated.org.springframework.boot;

import org.usvm.api.Engine;

public class SymbolicValueFactory {
    public static Object createSymbolic(Class<?> type) {
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

        return Engine.makeNullableSymbolic(type);
    }
}
