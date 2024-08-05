package stub.java.util.map;

import java.util.Map;

public class AbstractMap_Entry<K, V> implements Map.Entry<K, V> {

    @SuppressWarnings("unused")
    public AbstractMap_Entry(Map.Entry<K, V> entry) {
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public AbstractMap_Entry(K key, V value) {
        throw new LinkageError();
    }

    public boolean equals(Object other) {
        throw new LinkageError();
    }

    public K getKey() {
        throw new LinkageError();
    }

    public V getValue() {
        throw new LinkageError();
    }

    public int hashCode() {
        throw new LinkageError();
    }

    public V setValue(V value) {
        throw new LinkageError();
    }

    public String toString() {
        throw new LinkageError();
    }
}
