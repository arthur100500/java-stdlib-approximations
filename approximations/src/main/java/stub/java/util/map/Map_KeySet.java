package stub.java.util.map;

import generated.java.util.map.AbstractMapImpl;
import org.jetbrains.annotations.NotNull;
import runtime.LibSLRuntime;

import java.lang.LinkageError;
import java.lang.Object;
import java.lang.String;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

@SuppressWarnings("RedundantMethodOverride")
public final class Map_KeySet<K, V> extends Map_ContentsSet<K, V, K> {

    public Map_KeySet(AbstractMapImpl<K, V> parent) {
        super(parent);
        throw new LinkageError();
    }

    K _contentByKey(LibSLRuntime.Map<K, Map.Entry<K, V>> storage, K key) {
        throw new LinkageError();
    }

    public boolean add(K e) {
        throw new LinkageError();
    }

    public boolean addAll(@NotNull Collection<? extends K> c) {
        throw new LinkageError();
    }

    public void clear() {
        throw new LinkageError();
    }

    boolean _containsInStorage(LibSLRuntime.Map<K, Map.Entry<K, V>> storage, Object o) {
        throw new LinkageError();
    }

    public boolean contains(Object key) {
        throw new LinkageError();
    }

    public boolean containsAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public boolean equals(Object other) {
        throw new LinkageError();
    }

    public void forEach(Consumer<? super K> userAction) {
        throw new LinkageError();
    }

    public int hashCode() {
        throw new LinkageError();
    }

    public boolean isEmpty() {
        throw new LinkageError();
    }

    @NotNull
    public Iterator<K> iterator() {
        throw new LinkageError();
    }

    public Stream<K> parallelStream() {
        throw new LinkageError();
    }

    public boolean remove(Object key) {
        throw new LinkageError();
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public boolean removeIf(Predicate<? super K> filter) {
        throw new LinkageError();
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public int size() {
        throw new LinkageError();
    }

    public Spliterator<K> spliterator() {
        throw new LinkageError();
    }

    public Stream<K> stream() {
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
