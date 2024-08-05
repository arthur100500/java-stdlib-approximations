package generated.java.util.set;

import java.io.Serial;
import java.io.Serializable;
import java.lang.Object;
import java.lang.String;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;

@SuppressWarnings("unused")
@Approximate(java.util.LinkedHashSet.class)
public class LinkedHashSetImpl<E> extends HashSetImpl<E> implements Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = -2851667679971038690L;

    static {
        Engine.assume(true);
    }

    public LinkedHashSetImpl() {
        super();
    }

    public LinkedHashSetImpl(Collection<? extends E> c) {
        super(c);
    }

    public LinkedHashSetImpl(int initialCapacity) {
        super(initialCapacity);
    }

    public LinkedHashSetImpl(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public boolean add(E obj) {
        return super.add(obj);
    }

    public void clear() {
        super.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean contains(Object obj) {
        return super.contains(obj);
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @NotNull
    public Iterator<E> iterator() {
        return super.iterator();
    }

    public boolean remove(Object elem) {
        return super.remove(elem);
    }

    public int size() {
        return super.size();
    }

    public Spliterator<E> spliterator() {
        return super.spliterator();
    }

    public boolean equals(Object other) {
        return Engine.typeIs(other, LinkedHashSetImpl.class) && super.equals(other);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        return super.removeAll(c);
    }

    @NotNull
    public Object[] toArray() {
        return super.toArray();
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] a) {
        return super.toArray(a);
    }

    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }

    public boolean containsAll(@NotNull Collection<?> c) {
        return super.containsAll(c);
    }

    public boolean addAll(@NotNull Collection<? extends E> c) {
        return super.addAll(c);
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        return super.retainAll(c);
    }

    public boolean removeIf(Predicate<? super E> filter) {
        return super.removeIf(filter);
    }

    public void forEach(Consumer<? super E> userAction) {
        super.forEach(userAction);
    }

    public Stream<E> stream() {
        return super.stream();
    }

    public Stream<E> parallelStream() {
        return super.parallelStream();
    }

    public String toString() {
        return super.toString();
    }
}
