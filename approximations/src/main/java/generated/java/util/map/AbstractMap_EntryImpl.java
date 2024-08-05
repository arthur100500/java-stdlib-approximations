package generated.java.util.map;

import java.lang.Object;
import java.lang.String;
import java.util.Map;

import org.jacodb.approximation.annotation.Approximate;
import runtime.LibSLRuntime;
import stub.java.util.map.AbstractMap_Entry;

@Approximate(AbstractMap_Entry.class)
public class AbstractMap_EntryImpl<K, V> implements Map.Entry<K, V> {

    public K key;

    public V value;

    @SuppressWarnings("unused")
    public AbstractMap_EntryImpl(Map.Entry<K, V> entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    @SuppressWarnings("unused")
    public AbstractMap_EntryImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (other instanceof Map.Entry) {
            Map.Entry<Object, Object> oEntry = ((Map.Entry<Object, Object>) other);
            Object otherKey = oEntry.getKey();
            Object otherValue = oEntry.getValue();
            return LibSLRuntime.equals(this.key, otherKey) && LibSLRuntime.equals(this.value, otherValue);
        }

        return false;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public int hashCode() {
        return LibSLRuntime.hashCode(this.key) ^ LibSLRuntime.hashCode(this.value);
    }

    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    public String toString() {
        return LibSLRuntime.toString(this.key).concat("=").concat(LibSLRuntime.toString(this.value));
    }
}
