package stub.java.util.map;

import generated.java.util.map.AbstractMapImpl;
import org.jetbrains.annotations.NotNull;
import runtime.LibSLRuntime;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

@SuppressWarnings("RedundantMethodOverride")
public final class Map_EntrySet<K, V> extends Map_ContentsSet<K, V, Map.Entry<K, V>> {

    public Map_EntrySet(AbstractMapImpl<K, V> parent) {
        super(parent);
    }

    Map.Entry<K, V> _contentByKey(LibSLRuntime.Map<K, Map.Entry<K, V>> storage, K key) {
        throw new LinkageError();
    }

    public boolean add(Map.Entry<K, V> e) {
        throw new LinkageError();
    }

    public boolean addAll(@NotNull Collection<? extends Map.Entry<K, V>> c) {
        throw new LinkageError();
    }

    public void clear() {
        throw new LinkageError();
    }

    boolean _containsInStorage(LibSLRuntime.Map<K, Map.Entry<K, V>> storage, Object o) {
        throw new LinkageError();
    }

    public boolean contains(Object o) {
        throw new LinkageError();
    }

    public boolean containsAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public boolean equals(Object other) {
        throw new LinkageError();
    }

    public void forEach(Consumer<? super Map.Entry<K, V>> userAction) {
        throw new LinkageError();
    }

    public int hashCode() {
        throw new LinkageError();
    }

    public boolean isEmpty() {
        throw new LinkageError();
    }

    @NotNull
    public Iterator<Map.Entry<K, V>> iterator() {
        throw new LinkageError();
    }

    public Stream<Map.Entry<K, V>> parallelStream() {
        throw new LinkageError();
    }

    public boolean remove(Object o) {
        throw new LinkageError();
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public boolean removeIf(Predicate<? super Map.Entry<K, V>> filter) {
        throw new LinkageError();
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public int size() {
        throw new LinkageError();
    }

    public Spliterator<Map.Entry<K, V>> spliterator() {
        throw new LinkageError();
    }

    public Stream<Map.Entry<K, V>> stream() {
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
