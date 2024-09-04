package generated.java.util.map;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.Nullable;
import org.springframework.util.ConcurrentReferenceHashMap;
import runtime.LibSLRuntime;

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
        return super.get(key);
    }

    @Nullable
    public V getOrDefault(@Nullable Object key, @Nullable V defaultValue) {
        return super.getOrDefault(key, defaultValue);
    }

    public boolean containsKey(@Nullable Object key) {
        return super.containsKey(key);
    }

    @Nullable
    public V put(@Nullable K key, @Nullable V value) {
        return super.put(key, value);
    }

    @Nullable
    public V putIfAbsent(@Nullable K key, @Nullable V value) {
        return super.putIfAbsent(key, value);
    }

    @Nullable
    public V remove(@Nullable Object key) {
        return super.remove(key);
    }

    public boolean remove(@Nullable Object key, @Nullable final Object value) {
        return super.remove(key, value);
    }

    public boolean replace(@Nullable K key, @Nullable final V oldValue, @Nullable final V newValue) {
        return super.replace(key, oldValue, newValue);
    }

    @Nullable
    public V replace(@Nullable K key, @Nullable final V value) {
        return super.replace(key, value);
    }

    public void clear() {
        super.clear();
    }

    public void purgeUnreferencedEntries() {
        LibSLRuntime.not_implemented();
    }

    public int size() {
        return super.size();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @NotNull
    public Set<Entry<K, V>> entrySet() {
        return super.entrySet();
    }
}
