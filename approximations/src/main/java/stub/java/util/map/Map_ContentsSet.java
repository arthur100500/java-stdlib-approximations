package stub.java.util.map;

import generated.java.util.map.AbstractMapImpl;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

@SuppressWarnings("RedundantMethodOverride")
public abstract class Map_ContentsSet<K, V, Content> extends Map_Contents<K, V, Content> implements Set<Content> {

    public Map_ContentsSet(AbstractMapImpl<K, V> map) {
        super(map);
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

    public boolean contains(Object obj) {
        throw new LinkageError();
    }

    public boolean containsAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    Set<?> _equalsTypeCheck(Object other) {
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
