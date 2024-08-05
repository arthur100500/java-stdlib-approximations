package generated.java.util.map;

import generated.java.util.AbstractCollectionImpl;
import generated.java.util.stream.StreamStubImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;
import stub.java.util.map.Map_Contents;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Approximate(Map_Contents.class)
public abstract class Map_ContentsImpl<K, V, Content> extends AbstractCollectionImpl<Content> {

    public AbstractMapImpl<K, V> map;

    public Map_ContentsImpl(AbstractMapImpl<K, V> map) {
        super(0);
        this.map = map;
    }

    @SuppressWarnings("DataFlowIssue")
    LibSLRuntime.Map<K, Map.Entry<K, V>> getStorage() {
        Engine.assume(this.map != null);
        return this.map._getStorage();
    }

    abstract Content _contentByKey(LibSLRuntime.Map<K, Map.Entry<K, V>> storage, K key);

    @SuppressWarnings("ConstantValue")
    protected Object[] _mapToArray() {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = getStorage();
        int storageSize = storage.size();
        Object[] result = new Object[storageSize];
        if (storageSize == 0)
            return result;

        Engine.assume(storageSize > 0);
        LibSLRuntime.Map<K, Map.Entry<K, V>> unseen = storage.duplicate();
        for (int i = 0; i < storageSize; i++) {
            K curKey = unseen.anyKey();
            result[i] = _contentByKey(storage, curKey);
            unseen.remove(curKey);
        }
        return result;
    }

    public boolean add(Content e) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(@NotNull Collection<? extends Content> c) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.map.clear();
    }

    abstract boolean _containsInStorage(LibSLRuntime.Map<K, Map.Entry<K, V>> storage, Object o);

    public boolean contains(Object obj) {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = getStorage();
        if (storage.size() == 0)
            return false;

        return _containsInStorage(storage, obj);
    }

    public boolean containsAll(@NotNull Collection<?> c) {
        if (c == this || c.isEmpty())
            return true;

        for (Object elem : c) {
            if (!contains(elem))
                return false;
        }

        return true;
    }

    Collection<?> _equalsTypeCheck(Object other) {
        if (other instanceof Collection<?>)
            return (Collection<?>) other;

        return null;
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object other) {
        if (other == this)
            return true;

        Collection<?> c = _equalsTypeCheck(other);
        if (c == null)
            return false;

        if (getStorage().size() != c.size())
            return false;

        return containsAll(c);
    }

    public void forEach(Consumer<? super Content> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = getStorage();
        int size = storage.size();
        if (size == 0)
            return;

        Engine.assume(size > 0);
        int expectedModCount = this.map.modCount;
        LibSLRuntime.Map<K, Map.Entry<K, V>> unseen = storage.duplicate();
        for (int i = 0; i < size; i++) {
            K key = unseen.anyKey();
            userAction.accept(_contentByKey(storage, key));
            unseen.remove(key);
        }
        this.map._checkForModification(expectedModCount);
    }

    public int hashCode() {
        return LibSLRuntime.hashCode(getStorage());
    }

    public boolean isEmpty() {
        return getStorage().size() == 0;
    }

    @NotNull
    public Iterator<Content> iterator() {
        return new Map_Contents_IteratorImpl<>(this, getStorage().duplicate(), this.map.modCount);
    }

    @SuppressWarnings("unchecked")
    public Stream<Content> parallelStream() {
        Content[] items = (Content[]) _mapToArray();
        return new StreamStubImpl<>(items, true);
    }

    public abstract boolean remove(Object o);

    @SuppressWarnings("ConstantValue")
    public boolean removeAll(@NotNull Collection<?> c) {
        if (c == null)
            throw new NullPointerException();

        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = getStorage();
        int startStorageSize = storage.size();
        int cSize = c.size();
        if (startStorageSize == 0 || cSize == 0)
            return false;

        if (startStorageSize <= cSize) {
            LibSLRuntime.Map<K, Map.Entry<K, V>> unseen = storage.duplicate();
            for (int i = 0; i < startStorageSize; i++) {
                K key = unseen.anyKey();
                if (c.contains(_contentByKey(storage, key))) {
                    storage.remove(key);
                    this.map.modCount++;
                }
                unseen.remove(key);
            }

            return startStorageSize != storage.size();
        }

        for (Object key : c) {
            remove(key);
        }

        return startStorageSize != storage.size();
    }

    public boolean removeIf(Predicate<? super Content> filter) {
        if (filter == null)
            throw new NullPointerException();

        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = getStorage();
        int startStorageSize = storage.size();
        if (startStorageSize == 0)
            return false;

        LibSLRuntime.Map<K, Map.Entry<K, V>> unseen = storage.duplicate();
        for (int i = 0; i < startStorageSize; i++) {
            K curKey = unseen.anyKey();
            if (filter.test(_contentByKey(storage, curKey))) {
                storage.remove(curKey);
                this.map.modCount++;
            }
            unseen.remove(curKey);
        }

        return startStorageSize != storage.size();
    }

    @SuppressWarnings("ConstantValue")
    public boolean retainAll(@NotNull Collection<?> c) {
        if (c == null)
            throw new NullPointerException();

        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = getStorage();
        int startStorageSize = storage.size();
        int cSize = c.size();
        if (startStorageSize == 0 || cSize == 0)
            return false;

        LibSLRuntime.Map<K, Map.Entry<K, V>> unseen = storage.duplicate();
        for (int i = 0; i < startStorageSize; i++) {
            K curKey = unseen.anyKey();
            if (!c.contains(_contentByKey(storage, curKey))) {
                storage.remove(curKey);
                this.map.modCount++;
            }
        }

        return startStorageSize != storage.size();
    }

    public int size() {
        return this.map.size();
    }

    public Spliterator<Content> spliterator() {
        return new Map_Contents_SpliteratorImpl<>(this);
    }

    @SuppressWarnings("unchecked")
    public Stream<Content> stream() {
        Content[] items = (Content[]) _mapToArray();
        return new StreamStubImpl<>(items);
    }

    @NotNull
    public Object[] toArray() {
        return super.toArray();
    }

    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        return super.toArray(array);
    }

    public String toString() {
        LibSLRuntime.Map<K, Map.Entry<K, V>> storage = getStorage();
        int size = storage.size();
        if (size == 0)
            return "[]";

        String result = "[";
        LibSLRuntime.Map<K, Map.Entry<K, V>> unseen = storage.duplicate();
        Engine.assume(size > 0);
        int lastIndex = size - 1;
        for (int i = 0; i < size; i++) {
            K key = unseen.anyKey();
            unseen.remove(key);
            result = result.concat(LibSLRuntime.toString(_contentByKey(storage, key)));
            if (i != lastIndex)
                result = result.concat(", ");
        }

        return result.concat("]");
    }
}
