package generated.java.util.list;

import java.io.Serial;
import java.io.Serializable;
import java.lang.Object;
import java.lang.String;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;

@SuppressWarnings("unused")
@Approximate(java.util.ArrayList.class)
public class ArrayListImpl<E> extends AbstractListImpl<E> implements RandomAccess, Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = 8683452581122892189L;

    static {
        Engine.assume(true);
    }

    @SuppressWarnings("unused")
    public ArrayListImpl(SymbolicList<E> storage, int modCount) {
        super(storage, modCount);
    }

    @SuppressWarnings("unused")
    public ArrayListImpl() {
        super(Engine.makeSymbolicList(), 0);
    }

    @SuppressWarnings("unused")
    public ArrayListImpl(Collection<? extends E> c) {
        super(c);
    }

    @SuppressWarnings("unused")
    public ArrayListImpl(int initialCapacity) {
        super(initialCapacity);
    }

    public boolean add(E e) {
        return super._add(e);
    }

    public void add(int index, E element) {
        super._add(index, element);
    }

    public boolean addAll(@NotNull Collection<? extends E> c) {
        return super._addAll(c);
    }

    public boolean addAll(int index, @NotNull Collection<? extends E> c) {
        return super._addAll(index, c);
    }

    public void clear() {
        super._clear();
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Object clone() throws CloneNotSupportedException {
        return super._clone();
    }

    public boolean contains(Object o) {
        return super._contains(o);
    }

    public boolean containsAll(@NotNull Collection<?> c) {
        return super._containsAll(c);
    }

    public void ensureCapacity(int minCapacity) {
        super._ensureCapacity(minCapacity);
    }

    @SuppressWarnings("EqualsDoesntCheckParameterClass")
    public boolean equals(Object other) {
        return Engine.typeIs(other, ArrayListImpl.class) && super._equals(other);
    }

    public void forEach(Consumer<? super E> _action) {
        super._forEach(_action);
    }

    public E get(int index) {
        return super._get(index);
    }

    public int hashCode() {
        return super._hashCode();
    }

    public int indexOf(Object o) {
        return super._indexOf(o);
    }

    public boolean isEmpty() {
        return super._isEmpty();
    }

    @NotNull
    public Iterator<E> iterator() {
        return super._iterator();
    }

    public int lastIndexOf(Object o) {
        return super._lastIndexOf(o);
    }

    @NotNull
    public ListIterator<E> listIterator() {
        return super._listIterator();
    }

    @NotNull
    public ListIterator<E> listIterator(int index) {
        return super._listIterator(index);
    }

    @NotNull
    public Stream<E> parallelStream() {
        return super._parallelStream();
    }

    public boolean remove(Object o) {
        return super._remove(o);
    }

    public E remove(int index) {
        return super._remove(index);
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        return super._removeAll(c);
    }

    public boolean removeIf(@NotNull Predicate<? super E> filter) {
        return super._removeIf(filter);
    }

    public void replaceAll(@NotNull UnaryOperator<E> op) {
        super._replaceAll(op);
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        return super._retainAll(c);
    }

    public E set(int index, E element) {
        return super._set(index, element);
    }

    public int size() {
        return super._size();
    }

    public void sort(Comparator<? super E> c) {
        super._sort(c);
    }

    @NotNull
    public Spliterator<E> spliterator() {
        return super._spliterator();
    }

    @NotNull
    public Stream<E> stream() {
        return super._stream();
    }

    @NotNull
    public List<E> subList(int fromIndex, int toIndex) {
        return super._subList(fromIndex, toIndex);
    }

    @NotNull
    public Object[] toArray() {
        return super._toArray();
    }

    public <T> T[] toArray(@NotNull IntFunction<T[]> generator) {
        return super._toArray(generator);
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        return super._toArray(array);
    }

    public String toString() {
        return super._toString();
    }
}
