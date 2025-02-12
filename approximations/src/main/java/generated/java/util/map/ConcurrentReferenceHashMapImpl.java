package generated.java.util.map;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.Nullable;
import org.springframework.util.ConcurrentReferenceHashMap;
import runtime.LibSLRuntime;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

@SuppressWarnings("unused")
@Approximate(org.springframework.util.ConcurrentReferenceHashMap.class)
public class ConcurrentReferenceHashMapImpl<K, V> extends AbstractMapImpl<K, V> implements ConcurrentMap<K, V> {

    public ConcurrentReferenceHashMapImpl() {
        super(true);
    }

    public ConcurrentReferenceHashMapImpl(Map<? extends K, ? extends V> m) {
        super(true, m);
    }

    public ConcurrentReferenceHashMapImpl(int initialCapacity) {
        super(true, initialCapacity);
    }

    public ConcurrentReferenceHashMapImpl(int initialCapacity, float loadFactor) {
        super(true, initialCapacity, loadFactor);
    }

    public ConcurrentReferenceHashMapImpl(int initialCapacity, int concurrencyLevel) {
        this(initialCapacity);
    }

    public ConcurrentReferenceHashMapImpl(int initialCapacity, ConcurrentReferenceHashMap.ReferenceType referenceType) {
        this(initialCapacity);
    }

    public ConcurrentReferenceHashMapImpl(int initialCapacity, float loadFactor, int concurrencyLevel) {
        this(initialCapacity, loadFactor);
    }

    public ConcurrentReferenceHashMapImpl(int initialCapacity, float loadFactor, int concurrencyLevel, ConcurrentReferenceHashMap.ReferenceType referenceType) {
        this(initialCapacity, loadFactor);
    }

    @Nullable
    public V get(@Nullable Object key) {
        return super._get(key);
    }

    @Nullable
    public V getOrDefault(@Nullable Object key, @Nullable V defaultValue) {
        return super._getOrDefault(key, defaultValue);
    }

    public boolean containsKey(@Nullable Object key) {
        return super._containsKey(key);
    }

    public boolean containsValue(Object value) {
        return super._containsValue(value);
    }

    @Nullable
    public V put(@Nullable K key, @Nullable V value) {
        return super._put(key, value);
    }

    @Nullable
    public V putIfAbsent(@Nullable K key, @Nullable V value) {
        return super._putIfAbsent(key, value);
    }

    @Nullable
    public V remove(@Nullable Object key) {
        return super._remove(key);
    }

    public void putAll(@NotNull Map<? extends K, ? extends V> m) {
        super._putAll(m);
    }

    public boolean remove(@Nullable Object key, @Nullable final Object value) {
        return super._remove(key, value);
    }

    public boolean replace(@Nullable K key, @Nullable final V oldValue, @Nullable final V newValue) {
        return super._replace(key, oldValue, newValue);
    }

    @Nullable
    public V replace(@Nullable K key, @Nullable final V value) {
        return super._replace(key, value);
    }

    public void clear() {
        super._clear();
    }

    @NotNull
    public Set<K> keySet() {
        return super._keySet();
    }

    @NotNull
    public Collection<V> values() {
        return super._values();
    }

    public void purgeUnreferencedEntries() {
        LibSLRuntime.not_implemented();
    }

    public int size() {
        return super._size();
    }

    public boolean isEmpty() {
        return super._isEmpty();
    }

    @NotNull
    public Set<Entry<K, V>> entrySet() {
        return super._entrySet();
    }
}
