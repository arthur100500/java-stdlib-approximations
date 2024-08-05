package stub.java.util.map;

import generated.java.util.map.AbstractMapImpl;
import org.jetbrains.annotations.NotNull;
import runtime.LibSLRuntime;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public abstract class Map_Contents<K, V, Content> extends AbstractCollection<Content> {

    public Map_Contents(AbstractMapImpl<K, V> map) {
        throw new LinkageError();
    }

    LibSLRuntime.Map<K, Map.Entry<K, V>> getStorage() {
        throw new LinkageError();
    }

    abstract Content _contentByKey(LibSLRuntime.Map<K, Map.Entry<K, V>> storage, K key);

    protected Object[] _mapToArray() {
        throw new LinkageError();
    }

    public boolean add(Content e) {
        throw new LinkageError();
    }

    public boolean addAll(@NotNull Collection<? extends Content> c) {
        throw new LinkageError();
    }

    public void clear() {
        throw new LinkageError();
    }

    abstract boolean _containsInStorage(LibSLRuntime.Map<K, Map.Entry<K, V>> storage, Object o);

    public boolean contains(Object obj) {
        throw new LinkageError();
    }

    public boolean containsAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    Collection<?> _equalsTypeCheck(Object other) {
        throw new LinkageError();
    }

    public boolean equals(Object other) {
        throw new LinkageError();
    }

    public void forEach(Consumer<? super Content> userAction) {
        throw new LinkageError();
    }

    public int hashCode() {
        throw new LinkageError();
    }

    public boolean isEmpty() {
        throw new LinkageError();
    }

    @NotNull
    public Iterator<Content> iterator() {
        throw new LinkageError();
    }

    public Stream<Content> parallelStream() {
        throw new LinkageError();
    }

    public abstract boolean remove(Object o);

    public boolean removeAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public boolean removeIf(Predicate<? super Content> filter) {
        throw new LinkageError();
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public int size() {
        throw new LinkageError();
    }

    public Spliterator<Content> spliterator() {
        throw new LinkageError();
    }

    public Stream<Content> stream() {
        throw new LinkageError();
    }

    @NotNull
    public Object[] toArray() {
        throw new LinkageError();
    }

    public <T> T[] toArray(IntFunction<T[]> generator) {
        throw new LinkageError();
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        throw new LinkageError();
    }

    public String toString() {
        throw new LinkageError();
    }
}
