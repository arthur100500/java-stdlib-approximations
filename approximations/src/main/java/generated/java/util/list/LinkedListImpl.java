package generated.java.util.list;

import java.io.Serial;
import java.io.Serializable;
import java.lang.Object;
import java.lang.String;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;

@Approximate(java.util.LinkedList.class)
public class LinkedListImpl<E> extends AbstractListImpl<E> implements Deque<E>, Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = 876323262645176354L;

    static {
        Engine.assume(true);
    }

    @SuppressWarnings("unused")
    public LinkedListImpl(SymbolicList<E> storage, int modCount) {
        super(storage, modCount);
    }

    @SuppressWarnings("unused")
    public LinkedListImpl() {
        super();
    }

    @SuppressWarnings("unused")
    public LinkedListImpl(Collection<? extends E> c) {
        super(c);
    }

    private E _unlinkFirst() {
        if (!_isValidIndex(0))
            throw new NoSuchElementException();

        return _deleteElement(0);
    }

    private E _getFirstElement() {
        if (!_isValidIndex(0))
            throw new NoSuchElementException();

        return _get(0);
    }

    public boolean add(E e) {
        return super.add(e);
    }

    public void add(int index, E element) {
        super.add(index, element);
    }

    public boolean addAll(@NotNull Collection<? extends E> c) {
        return super.addAll(c);
    }

    public boolean addAll(int index, @NotNull Collection<? extends E> c) {
        return super.addAll(index, c);
    }

    public void addFirst(E e) {
        _addElement(0, e);
    }

    public void addLast(E e) {
        _addElement(_getStorage().size(), e);
    }

    public void clear() {
        super.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean contains(Object o) {
        return super.contains(o);
    }

    @SuppressWarnings("SlowListContainsAll")
    public boolean containsAll(@NotNull Collection<?> c) {
        return super.containsAll(c);
    }

    @NotNull
    public Iterator<E> descendingIterator() {
        return new LinkedList_DescendingIteratorImpl<>(this);
    }

    public E element() {
        return _getFirstElement();
    }

    public boolean equals(Object o) {
        return Engine.typeIs(o, LinkedListImpl.class) && super.equals(o);
    }

    public void forEach(Consumer<? super E> _action) {
        super.forEach(_action);
    }

    public E get(int index) {
        return super.get(index);
    }

    public E getFirst() {
        return _getFirstElement();
    }

    public E getLast() {
        return super.get(_getStorage().size() - 1);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public int indexOf(Object o) {
        return super.indexOf(o);
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @NotNull
    public Iterator<E> iterator() {
        return super.iterator();
    }

    public int lastIndexOf(Object o) {
        return super.lastIndexOf(o);
    }

    @NotNull
    public ListIterator<E> listIterator() {
        return super.listIterator();
    }

    @NotNull
    public ListIterator<E> listIterator(int index) {
        return super.listIterator(index);
    }

    public boolean offer(E e) {
        return add(e);
    }

    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    public Stream<E> parallelStream() {
        return super.parallelStream();
    }

    public E peek() {
        if (isEmpty())
            return null;

        return _get(0);
    }

    public E peekFirst() {
        return peek();
    }

    public E peekLast() {
        int size = _getStorage().size();
        if (size == 0)
            return null;

        return _get(size - 1);
    }

    public E poll() {
        if (isEmpty())
            return null;

        return _deleteElement(0);
    }

    public E pollFirst() {
        return poll();
    }

    public E pollLast() {
        int size = _getStorage().size();
        if (size == 0)
            return null;

        return _deleteElement(size - 1);
    }

    public E pop() {
        return _unlinkFirst();
    }

    public void push(E e) {
        _addElement(0, e);
    }

    public E remove() {
        return _unlinkFirst();
    }

    public boolean remove(Object o) {
        return super.remove(o);
    }

    public E remove(int index) {
        return super.remove(index);
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        return super.removeAll(c);
    }

    public E removeFirst() {
        return remove();
    }

    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    public boolean removeIf(Predicate<? super E> filter) {
        return super.removeIf(filter);
    }

    public E removeLast() {
        int size = _getStorage().size();
        if (size == 0) {
            throw new NoSuchElementException();
        }

        return _deleteElement(size - 1);
    }

    public boolean removeLastOccurrence(Object o) {
        SymbolicList<E> storage = _getStorage();
        int size = storage.size();
        if (size == 0)
            return false;

        Engine.assume(size > 0);
        int index;
        for (index = size - 1; index >= 0; index--) {
            Object item = storage.get(index);
            if (LibSLRuntime.equals(item, o)) {
                break;
            }
        }

        if (index != -1) {
            storage.remove(index);
            this.modCount++;
            return true;
        }

        return false;
    }

    public void replaceAll(UnaryOperator<E> op) {
        super.replaceAll(op);
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        return super.retainAll(c);
    }

    public E set(int index, E element) {
        return super.set(index, element);
    }

    public int size() {
        return super.size();
    }

    public void sort(Comparator<? super E> c) {
        super.sort(c);
    }

    public Spliterator<E> spliterator() {
        return super.spliterator();
    }

    public Stream<E> stream() {
        return super.stream();
    }

    @NotNull
    public List<E> subList(int fromIndex, int toIndex) {
        return super.subList(fromIndex, toIndex);
    }

    @NotNull
    public Object[] toArray() {
        return super.toArray();
    }

    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] a) {
        return super.toArray(a);
    }

    public String toString() {
        return super.toString();
    }
}
