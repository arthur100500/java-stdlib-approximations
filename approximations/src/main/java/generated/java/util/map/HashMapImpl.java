package generated.java.util.map;

import java.io.Serial;
import java.io.Serializable;
import java.lang.Object;
import java.lang.String;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

@Approximate(java.util.HashMap.class)
public class HashMapImpl<K, V> extends AbstractMapImpl<K, V> implements Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = 362498820763181265L;

    static {
        Engine.assume(true);
    }

    @SuppressWarnings("unused")
    public HashMapImpl() {
        super(true);
    }

    public HashMapImpl(Map<? extends K, ? extends V> m) {
        super(true, m);
    }

    @SuppressWarnings("unused")
    public HashMapImpl(int initialCapacity) {
        super(true, initialCapacity);
    }

    @SuppressWarnings("unused")
    public HashMapImpl(int initialCapacity, float loadFactor) {
        super(true, initialCapacity, loadFactor);
    }

    public void clear() {
        super._clear();
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Object clone() throws CloneNotSupportedException {
        return super._clone();
    }

    public V compute(K key, @NotNull BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return super._compute(key, remappingFunction);
    }

    public V computeIfAbsent(K key, @NotNull Function<? super K, ? extends V> mappingFunction) {
        return super._computeIfAbsent(key, mappingFunction);
    }

    public V computeIfPresent(K key, @NotNull BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return super._computeIfPresent(key, remappingFunction);
    }

    public boolean containsKey(Object key) {
        return super._containsKey(key);
    }

    public boolean containsValue(Object value) {
        return super._containsValue(value);
    }

    @NotNull
    public Set<Map.Entry<K, V>> entrySet() {
        return super._entrySet();
    }

    @SuppressWarnings("EqualsDoesntCheckParameterClass")
    public boolean equals(Object other) {
        return Engine.typeIs(other, HashMapImpl.class) && super._equals(other);
    }

    public void forEach(BiConsumer<? super K, ? super V> userAction) {
        super._forEach(userAction);
    }

    public V get(Object key) {
        return super._get(key);
    }

    public V getOrDefault(Object key, V defaultValue) {
        return super._getOrDefault(key, defaultValue);
    }

    public int hashCode() {
        return super._hashCode();
    }

    public boolean isEmpty() {
        return super._isEmpty();
    }

    @NotNull
    public Set<K> keySet() {
        return super._keySet();
    }

    public V merge(K key, @NotNull V value, @NotNull BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return super._merge(key, value, remappingFunction);
    }

    public V put(K key, V value) {
        return super._put(key, value);
    }

    public void putAll(@NotNull Map<? extends K, ? extends V> m) {
        super._putAll(m);
    }

    public V putIfAbsent(K key, V value) {
        return super._putIfAbsent(key, value);
    }

    public V remove(Object key) {
        return super._remove(key);
    }

    public boolean remove(Object key, Object value) {
        return super._remove(key, value);
    }

    public V replace(K key, V value) {
        return super._replace(key, value);
    }

    public boolean replace(K key, V oldValue, V newValue) {
        return super._replace(key, oldValue, newValue);
    }

    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        super._replaceAll(function);
    }

    public int size() {
        return super._size();
    }

    public String toString() {
        return super._toString();
    }

    @NotNull
    public Collection<V> values() {
        return super._values();
    }
}
