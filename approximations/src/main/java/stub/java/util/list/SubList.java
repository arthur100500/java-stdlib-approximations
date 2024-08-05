package stub.java.util.list;

import generated.java.util.list.AbstractListImpl;
import generated.java.util.list.SubListImpl;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.lang.LinkageError;
import java.lang.Object;
import java.lang.String;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public final class SubList<E> extends AbstractList<E> implements RandomAccess, Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = 8683452581122892189L;

    @SuppressWarnings("unused")
    private SubList(AbstractListImpl<E> list, SubListImpl<E> parent, int offset, int length, int modCount) {
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public SubList(AbstractListImpl<E> list, int fromIndex, int toIndex) {
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public AbstractListImpl<E> _getList() {
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public int _endIndex() {
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public boolean _addAllElements(int index, Collection<? extends E> c) {
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public void _updateSizeAndModCount(int sizeChange) {
        throw new LinkageError();
    }

    @SuppressWarnings({"unused", "ProtectedMemberInFinalClass"})
    protected Object[] _mapToArray() {
        throw new LinkageError();
    }

    public void add(int index, E element) {
        throw new LinkageError();
    }

    public boolean add(E e) {
        throw new LinkageError();
    }

    public boolean addAll(@NotNull Collection<? extends E> c) {
        throw new LinkageError();
    }

    public boolean addAll(int index, @NotNull Collection<? extends E> c) {
        throw new LinkageError();
    }

    public void clear() {
        throw new LinkageError();
    }

    public Object clone() throws CloneNotSupportedException {
        throw new LinkageError();
    }

    public boolean contains(Object o) {
        throw new LinkageError();
    }

    public boolean containsAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public boolean equals(Object o) {
        throw new LinkageError();
    }

    public void forEach(Consumer<? super E> _action) {
        throw new LinkageError();
    }

    public E get(int index) {
        throw new LinkageError();
    }

    public int hashCode() {
        throw new LinkageError();
    }

    public int indexOf(Object o) {
        throw new LinkageError();
    }

    public boolean isEmpty() {
        throw new LinkageError();
    }

    @NotNull
    public Iterator<E> iterator() {
        throw new LinkageError();
    }

    public int lastIndexOf(Object o) {
        throw new LinkageError();
    }

    @NotNull
    public ListIterator<E> listIterator() {
        throw new LinkageError();
    }

    @NotNull
    public ListIterator<E> listIterator(int index) {
        throw new LinkageError();
    }

    public Stream<E> parallelStream() {
        throw new LinkageError();
    }

    public boolean remove(Object o) {
        throw new LinkageError();
    }

    public E remove(int index) {
        throw new LinkageError();
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public boolean removeIf(Predicate<? super E> filter) {
        throw new LinkageError();
    }

    public void replaceAll(UnaryOperator<E> operator) {
        throw new LinkageError();
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        throw new LinkageError();
    }

    public int size() {
        throw new LinkageError();
    }

    public void sort(Comparator<? super E> c) {
        throw new LinkageError();
    }

    public Spliterator<E> spliterator() {
        throw new LinkageError();
    }

    public Stream<E> stream() {
        throw new LinkageError();
    }

    @NotNull
    public List<E> subList(int fromIndex, int toIndex) {
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
