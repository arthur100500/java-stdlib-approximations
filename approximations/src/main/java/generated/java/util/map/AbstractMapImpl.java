package generated.java.util.map;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@Approximate(java.util.AbstractMap.class)
public abstract class AbstractMapImpl<K, V> implements Map<K, V> {

    static <K, V> LibSLRuntime.Map.Container<K, Map.Entry<K, V>> _createContainer(boolean isHashMap) {
        if (isHashMap)
            return new LibSLRuntime.HashMapContainer<>();

        return new LibSLRuntime.IdentityMapContainer<>();
    }

    static <K, V> LibSLRuntime.Map<K, Map.Entry<K, V>> _createStorage(boolean isHashMap) {
        return new LibSLRuntime.Map<>(_createContainer(isHashMap));
    }

    public AbstractMapImpl(boolean isHashMap) {
        _setStorage(_createStorage(isHashMap));
        _setModCount(0);
    }

    public AbstractMapImpl(boolean isHashMap, Map<? extends K, ? extends V> m) {
        this(isHashMap);
        _addAllElements(m);
    }

    public AbstractMapImpl(boolean isHashMap, int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException();

        _setStorage(_createStorage(isHashMap));
        _setModCount(0);
    }

    @SuppressWarnings("ExpressionComparedToItself")
    public AbstractMapImpl(boolean isHashMap, int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException();

        if (loadFactor <= 0 || loadFactor != loadFactor)
            throw new IllegalArgumentException();

        _setStorage(_createStorage(isHashMap));
        _setModCount(0);
    }

    public abstract LibSLRuntime.Map<K, Map.Entry<K, V>> _getStorage();

    public abstract void _setStorage(LibSLRuntime.Map<K, Map.Entry<K, V>> storage);

    abstract protected int _getModCount();

    abstract protected void _setModCount(int newModCount);

    abstract protected boolean _isHashMap();

    protected void _incrementModCount() {
        _setModCount(_getModCount() + 1);
    }

    @SuppressWarnings("unchecked")
    private void _addAllElements(Map<? extends K, ? extends V> m) {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        if (m instanceof AbstractMapImpl<?, ?>) {
            AbstractMapImpl<K, V> other = (AbstractMapImpl<K, V>) m;
            LibSLRuntime.Map<K, Map.Entry<K, V>> otherStorage = other._getStorage();
            storage.union(otherStorage);
            return;
        }

        Set<? extends Entry<? extends K, ? extends V>> entrySet = m.entrySet();
        for (Entry<? extends K, ? extends V> oEntry : entrySet) {
            K key = oEntry.getKey();
            V value = oEntry.getValue();
            if (storage.hasKey(key)) {
                Entry<K, V> entry = storage.get(key);
                entry.setValue(value);
            } else {
                Entry<K, V> entry = new AbstractMap_EntryImpl<>(key, value);
                storage.set(key, entry);
            }
            _incrementModCount();
        }
    }

    public void _checkForModification(int expectedModCount) {
        if (_getModCount() != expectedModCount)
            throw new ConcurrentModificationException();
    }

    public void _clear() {
        _incrementModCount();
        _setStorage(_createStorage(_isHashMap()));
    }

    @SuppressWarnings("unchecked")
    public Object _clone() throws CloneNotSupportedException {
        AbstractMapImpl<K, V> clonedMap = (AbstractMapImpl<K, V>) super.clone();
        clonedMap._setStorage(_getStorage().duplicate());
        clonedMap._setModCount(0);
        return clonedMap;
    }

    private Map.Entry<K, V> _getEntry(K key) {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        if (storage.hasKey(key))
            return storage.get(key);

        return null;
    }

    private V _getEntryValueIfNotNull(Map.Entry<K, V> entry, V defaultValue) {
        if (entry != null)
            return entry.getValue();

        return defaultValue;
    }

    private V _getEntryValueIfNotNull(Map.Entry<K, V> entry) {
        return _getEntryValueIfNotNull(entry, null);
    }

    private void _update(K key, Map.Entry<K, V> entry, V newValue) {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        if (newValue == null) {
            storage.remove(key);
        } else {
            if (entry != null) {
                entry.setValue(newValue);
            } else {
                entry = new AbstractMap_EntryImpl<>(key, newValue);
                storage.set(key, entry);
            }
        }
    }

    @SuppressWarnings("ConstantValue")
    public V _compute(K key, @NotNull BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        if (remappingFunction == null)
            throw new NullPointerException();

        Map.Entry<K, V> entry = _getEntry(key);
        V oldValue = _getEntryValueIfNotNull(entry);

        int expectedModCount = _getModCount();
        V newValue = remappingFunction.apply(key, oldValue);
        _checkForModification(expectedModCount);
        _update(key, entry, newValue);

        return newValue;
    }

    @SuppressWarnings("ConstantValue")
    public V _computeIfAbsent(K key, @NotNull Function<? super K, ? extends V> mappingFunction) {
        if (mappingFunction == null)
            throw new NullPointerException();

        Map.Entry<K, V> entry = _getEntry(key);
        V oldValue = _getEntryValueIfNotNull(entry);

        if (oldValue != null)
            return oldValue;

        int expectedModCount = _getModCount();
        V newValue = mappingFunction.apply(key);
        _checkForModification(expectedModCount);
        _update(key, entry, newValue);

        return newValue;
    }

    @SuppressWarnings("ConstantValue")
    public V _computeIfPresent(K key, @NotNull BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        if (remappingFunction == null)
            throw new NullPointerException();

        Map.Entry<K, V> entry = _getEntry(key);
        V oldValue = _getEntryValueIfNotNull(entry);

        if (oldValue == null)
            return oldValue;

        int expectedModCount = _getModCount();
        V newValue = remappingFunction.apply(key, oldValue);
        _checkForModification(expectedModCount);
        _update(key, entry, newValue);

        return newValue;
    }

    @SuppressWarnings("unchecked")
    public boolean _containsKey(Object key) {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        return storage.size() != 0 && storage.hasKey((K) key);
    }

    public boolean _containsValue(Object value) {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        int storageSize = storage.size();
        if (storageSize == 0)
            return false;

        LibSLRuntime.Map<K, Map.Entry<K, V>> unseen = storage.duplicate();
        while (storageSize != 0) {
            K curKey = unseen.anyKey();
            Map.Entry<K, V> entry = unseen.get(curKey);
            V curValue = entry.getValue();
            if (LibSLRuntime.equals(curValue, value))
                return true;

            unseen.remove(curKey);
            storageSize--;
        }

        return false;
    }

    @NotNull
    public Set<Map.Entry<K, V>> _entrySet() {
        return new Map_EntrySetImpl<>(this);
    }

    @SuppressWarnings({"unchecked", "ConstantValue"})
    public boolean _equals(Object other) {
        if (other == this)
            return true;

        if (!(other instanceof Map))
            return false;

        Map<K, V> m = (Map<K, V>) other;
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        int thisLength = storage.size();
        if (thisLength != m.size())
            return false;

        Engine.assume(thisLength >= 0);
        try {
            LibSLRuntime.Map<K, Map.Entry<K, V>> unseen = storage.duplicate();
            while (thisLength > 0) {
                K key = unseen.anyKey();
                Map.Entry<K, V> entry = unseen.get(key);
                V value = entry.getValue();
                if (value == null && m.get(key) != null)
                    return false;
                if (value == null && !m.containsKey(key))
                    return false;
                if (value != null && !LibSLRuntime.equals(value, m.get(key)))
                    return false;

                unseen.remove(key);
                thisLength--;
            }
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }

        return true;
    }

    public void _forEach(BiConsumer<? super K, ? super V> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        int storageSize = storage.size();
        if (storageSize == 0)
            return;

        Engine.assume(storageSize > 0);
        int expectedModCount = _getModCount();
        LibSLRuntime.Map<K, Map.Entry<K, V>> unseen = storage.duplicate();
        for (int i = 0; i < storageSize; i++) {
            K curKey = unseen.anyKey();
            Map.Entry<K, V> entry = unseen.get(curKey);
            V curValue = entry.getValue();
            userAction.accept(curKey, curValue);
            unseen.remove(curKey);
        }
        _checkForModification(expectedModCount);
    }

    @SuppressWarnings("unchecked")
    public V _get(Object key) {
        return _getEntryValueIfNotNull(_getEntry((K) key));
    }

    @SuppressWarnings("unchecked")
    public V _getOrDefault(Object key, V defaultValue) {
        return _getEntryValueIfNotNull(_getEntry((K) key), defaultValue);
    }

    public int _hashCode() {
        return LibSLRuntime.hashCode(_getStorage());
    }

    public boolean _isEmpty() {
        return _getStorage().size() == 0;
    }

    @NotNull
    public Set<K> _keySet() {
        return new Map_KeySetImpl<>(this);
    }

    @SuppressWarnings("ConstantValue")
    public V _merge(K key, @NotNull V value, @NotNull BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        if (value == null)
            throw new NullPointerException();

        if (remappingFunction == null)
            throw new NullPointerException();

        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        if (storage.hasKey(key)) {
            Map.Entry<K, V> entry = storage.get(key);
            V oldValue = entry.getValue();
            V result;
            if (oldValue == null) {
                result = value;
            } else {
                int expectedModCount = _getModCount();
                result = remappingFunction.apply(oldValue, value);
                _checkForModification(expectedModCount);
            }
            if (result == null) {
                storage.remove(key);
            } else {
                entry.setValue(result);
            }
            return result;
        }

        Map.Entry<K, V> entry = new AbstractMap_EntryImpl<>(key, value);
        storage.set(key, entry);
        _incrementModCount();
        return value;
    }

    public V _put(K key, V value) {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        if (storage.hasKey(key)) {
            Map.Entry<K, V> entry = storage.get(key);
            V result = entry.getValue();
            entry.setValue(value);
            return result;
        }

        Map.Entry<K, V> entry = new AbstractMap_EntryImpl<>(key, value);
        storage.set(key, entry);
        _incrementModCount();

        return null;
    }

    @SuppressWarnings("ConstantValue")
    public void _putAll(@NotNull Map<? extends K, ? extends V> m) {
        if (m == null)
            throw new NullPointerException();

        _addAllElements(m);
    }

    public V _putIfAbsent(K key, V value) {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        if (storage.hasKey(key)) {
            Map.Entry<K, V> entry = storage.get(key);
            return entry.getValue();
        }

        Map.Entry<K, V> entry = new AbstractMap_EntryImpl<>(key, value);
        storage.set(key, entry);
        _incrementModCount();

        return null;
    }

    @SuppressWarnings("unchecked")
    public V _remove(Object key) {
        K typedKey = (K) key;
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        if (storage.hasKey(typedKey)) {
            Map.Entry<K, V> entry = storage.get(typedKey);
            V result = entry.getValue();
            storage.remove(typedKey);
            _incrementModCount();
            return result;
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    public boolean _remove(Object key, Object value) {
        K typedKey = (K) key;
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        if (storage.hasKey(typedKey)) {
            Map.Entry<K, V> entry = storage.get(typedKey);
            V curValue = entry.getValue();
            if (LibSLRuntime.equals(curValue, value)) {
                storage.remove(typedKey);
                _incrementModCount();
                return true;
            }
        }

        return false;
    }

    public V _replace(K key, V value) {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        if (storage.hasKey(key)) {
            Map.Entry<K, V> entry = storage.get(key);
            V result = entry.getValue();
            entry.setValue(value);
            return result;
        }

        return null;
    }

    public boolean _replace(K key, V oldValue, V newValue) {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        if (storage.hasKey(key)) {
            Map.Entry<K, V> entry = storage.get(key);
            V curValue = entry.getValue();
            if (LibSLRuntime.equals(curValue, oldValue)) {
                entry.setValue(newValue);
                return true;
            }
        }

        return false;
    }

    public void _replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        if (function == null)
            throw new NullPointerException();

        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        int size = storage.size();
        if (size == 0)
            return;

        Engine.assume(size > 0);
        int expectedModCount = _getModCount();
        LibSLRuntime.Map<K, Map.Entry<K, V>> unseen = storage.duplicate();
        for (int i = 0; i < size; i++) {
            K key = unseen.anyKey();
            Map.Entry<K, V> entry = unseen.get(key);
            entry.setValue(function.apply(key, entry.getValue()));
            unseen.remove(key);
        }
        _checkForModification(expectedModCount);
    }

    public int _size() {
        return _getStorage().size();
    }

    public String _toString() {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = _getStorage();
        int size = storage.size();
        if (size == 0)
            return "{}";

        Engine.assume(size > 0);
        String result = "{";
        LibSLRuntime.Map<K, Map.Entry<K, V>> unseen = storage.duplicate();
        Engine.assume(size > 0);
        int lastIndex = size - 1;
        for (int i = 0; i < size; i++) {
            K key = unseen.anyKey();
            Map.Entry<K, V> entry = unseen.get(key);
            unseen.remove(key);
            result = result.concat(LibSLRuntime.toString(entry));
            if (i != lastIndex)
                result = result.concat(", ");
        }

        return result.concat("}");
    }

    @NotNull
    public Collection<V> _values() {
        return new Map_ValuesImpl<>(this);
    }

}
