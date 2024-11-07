package generated.java.util;

import generated.java.util.map.ConcurrentHashMapImpl;
import org.jacodb.approximation.annotation.Approximate;

import java.util.Properties;

@Approximate(Properties.class)
public class PropertiesImpl {

    @SuppressWarnings("FieldCanBeLocal")
    private final ConcurrentHashMapImpl<Object, Object> map;
    protected Properties defaults;

    private PropertiesImpl(Properties defaults, int initialCapacity) {
        this.map = new ConcurrentHashMapImpl<>(initialCapacity);
        this.defaults = defaults;
    }
}
