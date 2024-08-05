package stub.java.util.map;

import generated.java.util.map.AbstractMapImpl;
import org.jetbrains.annotations.NotNull;
import runtime.LibSLRuntime;

import java.lang.LinkageError;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

@SuppressWarnings("RedundantMethodOverride")
public class Map_Values<K, V> extends Map_Contents<K, V, V> {

    public Map_Values(AbstractMapImpl<K, V> parent) {
        super(parent);
        throw new LinkageError();
    }

    V _contentByKey(LibSLRuntime.Map<K, Map.Entry<K, V>> storage, K key) {
        throw new LinkageError();
    }

    public boolean add(V e) {
        throw new LinkageError();
    }

    public boolean addAll(@NotNull Collection<? extends V> c) {
        throw new LinkageError();
    }

    public void clear() {
        throw new LinkageError();
    }

    boolean _containsInStorage(LibSLRuntime.Map<K, Map.Entry<K, V>> storage, Object value) {
        throw new LinkageError();
    }

    public boolean contains(Object value) {
        throw new LinkageError();
    }

    public boolean containsAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public void forEach(Consumer<? super V> userAction) {
        throw new LinkageError();
    }

    public boolean isEmpty() {
        throw new LinkageError();
    }

    @NotNull
    public Iterator<V> iterator() {
        throw new LinkageError();
    }

    public Stream<V> parallelStream() {
        throw new LinkageError();
    }

    public boolean remove(Object value) {
        throw new LinkageError();
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public boolean removeIf(Predicate<? super V> filter) {
        throw new LinkageError();
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public int size() {
        throw new LinkageError();
    }

    public Spliterator<V> spliterator() {
        throw new LinkageError();
    }

    public Stream<V> stream() {
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
