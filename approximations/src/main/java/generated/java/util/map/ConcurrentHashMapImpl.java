package generated.java.util.map;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@Approximate(ConcurrentHashMap.class)
public class ConcurrentHashMapImpl<K, V> extends AbstractMapImpl<K, V> implements ConcurrentMap<K, V>, Serializable {

    @Serial
    private static final long serialVersionUID = 7249069246763182397L;

    static {
        Engine.assume(true);
    }

    @SuppressWarnings("unused")
    public ConcurrentHashMapImpl() {
        super(true);
    }

    public ConcurrentHashMapImpl(Map<K, V> m) {
        super(true, m);
    }

    @SuppressWarnings("unused")
    public ConcurrentHashMapImpl(int initialCapacity) {
        super(true, initialCapacity);
    }

    @SuppressWarnings("unused")
    public ConcurrentHashMapImpl(int initialCapacity, float loadFactor) {
        super(true, initialCapacity, loadFactor);
    }

    public void clear() {
        super.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public V compute(K key, @NotNull BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return super.compute(key, remappingFunction);
    }

    public V computeIfAbsent(K key, @NotNull Function<? super K, ? extends V> mappingFunction) {
        return super.computeIfAbsent(key, mappingFunction);
    }

    public V computeIfPresent(K key, @NotNull BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return super.computeIfPresent(key, remappingFunction);
    }

    public boolean containsKey(Object key) {
        return super.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return super.containsValue(value);
    }

    @NotNull
    public Set<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    public boolean equals(Object other) {
        return Engine.typeIs(other, ConcurrentHashMapImpl.class) && super.equals(other);
    }

    public void forEach(BiConsumer<? super K, ? super V> userAction) {
        super.forEach(userAction);
    }

    public V get(Object key) {
        return super.get(key);
    }

    public V getOrDefault(Object key, V defaultValue) {
        return super.getOrDefault(key, defaultValue);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @NotNull
    public Set<K> keySet() {
        return super.keySet();
    }

    public V merge(K key, @NotNull V value, @NotNull BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return super.merge(key, value, remappingFunction);
    }

    public V put(K key, V value) {
        return super.put(key, value);
    }

    public void putAll(@NotNull Map<? extends K, ? extends V> m) {
        super.putAll(m);
    }

    public V putIfAbsent(@NotNull K key, V value) {
        return super.putIfAbsent(key, value);
    }

    public V remove(Object key) {
        return super.remove(key);
    }

    public boolean remove(@NotNull Object key, Object value) {
        return super.remove(key, value);
    }

    public V replace(@NotNull K key, @NotNull V value) {
        return super.replace(key, value);
    }

    public boolean replace(@NotNull K key, @NotNull V oldValue, @NotNull V newValue) {
        return super.replace(key, oldValue, newValue);
    }

    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        super.replaceAll(function);
    }

    public int size() {
        return super.size();
    }

    public String toString() {
        return super.toString();
    }

    @NotNull
    public Collection<V> values() {
        return super.values();
    }
}
