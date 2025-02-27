package generated.org.springframework.boot.pinnedValues;

public class PinnedValueStorage {
    private static void _writePinnedInner(String pinnedSourceName, String name, Object source, Class<?> clazz) {
        throw new IllegalStateException("This method must be approximated");
    }

    private static Object _readPinnedInner(String pinnedSourceName, String name, Class<?> clazz) {
        throw new IllegalStateException("This method must be approximated");
    }

    public static void writePinnedValue(PinnedValueSource source, Object value) {
        writePinnedValue(source, null, value);
    }

    public static void writePinnedValue(PinnedValueSource source, String name, Object value) {
        Class<?> clazz = Object.class;
        // TODO: Consult about name() usage #AA
        _writePinnedInner(source.name(), name, value, clazz);
    }

    public static <T> T getPinnedValue(PinnedValueSource source, Class<?> clazz) {
        return getPinnedValue(source, null, clazz);
    }

    @SuppressWarnings({"unchecked"})
    public static <T> T getPinnedValue(PinnedValueSource source, String name, Class<?> clazz) {
        return (T)_readPinnedInner(source.name(), name, clazz);
    }
}
