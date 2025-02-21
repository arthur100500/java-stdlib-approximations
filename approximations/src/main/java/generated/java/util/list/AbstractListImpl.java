package generated.java.util.list;

import java.lang.Comparable;
import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import generated.java.util.AbstractCollectionImpl;
import generated.java.util.stream.StreamStubImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;

@Approximate(java.util.AbstractList.class)
public abstract class AbstractListImpl<E> extends AbstractCollectionImpl<E> implements List<E> {

    public AbstractListImpl(SymbolicList<E> storage, int modCount) {
        super(modCount);
        _setStorage(storage);
    }

    public AbstractListImpl(Collection<? extends E> c) {
        super(0);

        if (c == null)
            throw new NullPointerException();

        _setStorage(Engine.makeSymbolicList());
        _addAllElements(0, c);
    }

    public AbstractListImpl(int initialCapacity) {
        super(0);

        if (initialCapacity < 0)
            throw new IllegalArgumentException();

        _setStorage(Engine.makeSymbolicList());
    }

    public abstract SymbolicList<E> _getStorage();

    public abstract void _setStorage(SymbolicList<E> storage);

    public boolean _isValidIndex(int index, int length) {
        return index >= 0 && index < length;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean _isValidIndex(int index) {
        return _isValidIndex(index, _getStorage().size());
    }

    public void _checkValidIndex(int index, int length) {
        if (!_isValidIndex(index, length))
            throw new IndexOutOfBoundsException();
    }

    public void _checkValidIndex(int index) {
        _checkValidIndex(index, _getStorage().size());
    }

    public boolean _isValidAddIndex(int index) {
        return index >= 0 && index <= _getStorage().size();
    }

    public void _checkValidAddIndex(int index) {
        if (!_isValidAddIndex(index))
            throw new IndexOutOfBoundsException();
    }

    @SuppressWarnings({"DataFlowIssue", "unchecked"})
    public boolean _addAllElements(int index, Collection<? extends E> c) {
        SymbolicList<E> storage = _getStorage();
        int oldLength = storage.size();
        if (c instanceof AbstractListImpl) {
            AbstractListImpl<E> other = (AbstractListImpl<E>) c;
            SymbolicList<E> otherStorage = other._getStorage();
            Engine.assume(otherStorage != null);
            int otherLength = otherStorage.size();
            Engine.assume(otherLength >= 0);
            otherStorage.copy(storage, 0, index, otherLength);
        } else {
            for (E item : c) {
                storage.insert(index, item);
                index++;
            }
        }

        _incrementModCount();
        return oldLength != storage.size();
    }

    public void _subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException();

        if (toIndex > size)
            throw new IndexOutOfBoundsException();

        if (fromIndex > toIndex)
            throw new IllegalArgumentException();
    }

    public E _deleteElement(int index) {
        SymbolicList<E> storage = _getStorage();
        E result = storage.get(index);
        storage.remove(index);
        _incrementModCount();
        return result;
    }

    public E _checkedDeleteElement(int index) {
        _checkValidIndex(index);
        return _deleteElement(index);
    }

    public void _addElement(int index, E element) {
        _getStorage().insert(index, element);
        _incrementModCount();
    }

    public void _checkedAddElement(int index, E element) {
        _checkValidAddIndex(index);
        _addElement(index, element);
    }

    public E _setElement(int index, E element) {
        SymbolicList<E> storage = _getStorage();
        E oldValue = storage.get(index);
        storage.set(index, element);
        return oldValue;
    }

    public E _checkedSetElement(int index, E element) {
        _checkValidIndex(index);
        return _setElement(index, element);
    }

    public E _uncheckedGet(int index) {
        return _getStorage().get(index);
    }

    public E _checkedGet(int index) {
        _checkValidIndex(index);
        return _uncheckedGet(index);
    }

    public void _replaceAllRange(UnaryOperator<E> op, int i, int end) {
        int expectedModCount = _getModCount();
        SymbolicList<E> storage = _getStorage();
        while (_getModCount() == expectedModCount && i < end) {
            E oldItem = storage.get(i);
            E newItem = op.apply(oldItem);
            storage.set(i, newItem);
            i++;
        }
        _checkForModification(expectedModCount);
    }

    public boolean _removeIf(Predicate<? super E> filter, int start, int end) {
        if (filter == null)
            throw new NullPointerException();

        SymbolicList<E> storage = _getStorage();
        int oldLength = storage.size();
        int expectedModCount = _getModCount();
        Engine.assume(start <= end);
        for (int i = end - 1; i > start; i--) {
            E item = storage.get(i);
            if (filter.test(item))
                storage.remove(i);
        }

        _checkForModification(expectedModCount);
        return oldLength != storage.size();
    }

    public boolean _equalsStorage(SymbolicList<E> otherStorage, int from, int to) {
        SymbolicList<E> storage = _getStorage();
        for (int i = from; i < to; i++) {
            E a = otherStorage.get(i);
            E b = storage.get(i);
            if (!LibSLRuntime.equals(a, b))
                return false;
        }
        return true;
    }

    public boolean _equalsRange(List<E> other, int from, int to) {
        if (other instanceof SubListImpl<?>) {
            SubListImpl<E> otherSubList = (SubListImpl<E>) other;
            AbstractListImpl<E> otherRoot = otherSubList.list;
            SymbolicList<E> otherStorage = otherRoot._getStorage();
            if (to != otherSubList.length)
                return false;

            return _equalsStorage(otherStorage, from, to);
        }

        if (other instanceof AbstractListImpl<?>) {
            AbstractListImpl<E> otherList = (AbstractListImpl<E>) other;
            SymbolicList<E> otherStorage = otherList._getStorage();
            if (to != otherStorage.size())
                return false;

            return _equalsStorage(otherStorage, from, to);
        }

        SymbolicList<E> storage = _getStorage();
        Iterator<E> iter = other.iterator();
        boolean result = true;
        int i = from;
        while (result && i < to && iter.hasNext()) {
            E a = iter.next();
            E b = storage.get(i);
            result = LibSLRuntime.equals(a, b);
            i++;
        }

        return result && !iter.hasNext();
    }

    protected Object[] _mapToArray() {
        SymbolicList<E> storage = _getStorage();
        int count = storage.size();
        Object[] items = new Object[count];
        for (int i = 0; i < count; i++) {
            items[i] = storage.get(i);
        }
        return items;
    }

    @SuppressWarnings("unchecked")
    private Stream<E> _makeStream(boolean parallel) {
        E[] items = (E[]) _mapToArray();
        return new StreamStubImpl<>(items, parallel);
    }

    @SuppressWarnings({"ConstantValue", "unchecked"})
    public boolean _batchRemove(Collection<?> c, boolean complement, int start, int end) {
        if (c == null)
            throw new NullPointerException();

        SymbolicList<E> storage = _getStorage();
        int oldLength = storage.size();
        if (oldLength == 0 || start >= end)
            return false;

        int otherLength = c.size();
        if (otherLength == 0) {
            if (!complement)
                return false;

            _setStorage(Engine.makeSymbolicList());
            _incrementModCount();
            return true;
        }

        Engine.assume(otherLength > 0);
        start--;
        end--;
        if (c instanceof List) {
            SymbolicList<E> otherStorage = ((AbstractListImpl<E>) c)._getStorage();
            Engine.assume(otherStorage != null);
            boolean changed = false;
            for (int i = end; i > start; i--) {
                Object item = storage.get(i);
                int storageSize = storage.size();
                int index = LibSLRuntime.ListActions.find(otherStorage, item, 0, storageSize);
                boolean notExists = index == -1;
                if (notExists == complement) {
                    _checkedDeleteElement(i);
                    changed = true;
                }
            }
            return changed;
        }

        boolean changed = false;
        for (int i = end; i > start; i--) {
            Object item = storage.get(i);
            if (c.contains(item) != complement) {
                _checkedDeleteElement(i);
                changed = true;
            }
        }

        return changed;
    }

    @SuppressWarnings("unchecked")
    public void _do_sort(int start, int end, Comparator<? super E> c) {
        if (start >= end) {
            _incrementModCount();
            return;
        }
        SymbolicList<E> storage = _getStorage();
        int expectedModCount = _getModCount();
        Engine.assume(start >= 0);
        Engine.assume(end > 0);
        int outerLimit = end - 1;
        for (int i = start; i < outerLimit; i++) {
            int innerLimit = end - i - 1;
            for (int j = start; j < innerLimit; j++) {
                int idxB = j + 1;
                E a = storage.get(j);
                E b = storage.get(idxB);
                if (c != null && c.compare(a, b) > 0 || c == null && ((Comparable<E>) a).compareTo(b) > 0) {
                    storage.set(j, b);
                    storage.set(idxB, a);
                }
            }
        }
        _checkForModification(expectedModCount);
    }

    public boolean _add(E e) {
        SymbolicList<E> storage = _getStorage();
        storage.insert(storage.size(), e);
        _incrementModCount();
        return true;
    }

    public void _add(int index, E element) {
        _checkedAddElement(index, element);
    }

    public boolean _addAll(@NotNull Collection<? extends E> c) {
        return _addAllElements(_getStorage().size(), c);
    }

    public boolean _addAll(int index, @NotNull Collection<? extends E> c) {
        _checkValidAddIndex(index);
        return _addAllElements(index, c);
    }

    public void _clear() {
        _setStorage(Engine.makeSymbolicList());
        _incrementModCount();
    }

    @SuppressWarnings("unchecked")
    public Object _clone() throws CloneNotSupportedException {
        AbstractListImpl<E> clonedList = (AbstractListImpl<E>) super.clone();
        SymbolicList<E> storageCopy = Engine.makeSymbolicList();
        SymbolicList<E> storage = _getStorage();
        storage.copy(storageCopy, 0, 0, storage.size());
        clonedList._setStorage(storageCopy);
        clonedList._setModCount(0);
        return clonedList;
    }

    public boolean _contains(Object o) {
        return indexOf(o) != -1;
    }

    @SuppressWarnings({"DataFlowIssue", "unchecked"})
    public boolean _containsAll(@NotNull Collection<?> c) {
        if (c instanceof AbstractListImpl<?>) {
            SymbolicList<E> otherStorage = ((AbstractListImpl<E>) c)._getStorage();
            Engine.assume(otherStorage != null);
            int otherLength = otherStorage.size();
            Engine.assume(otherLength >= 0);
            boolean result = true;
            int i = 0;
            while (result && i < otherLength) {
                E item = otherStorage.get(i);
                result = contains(item);
                i++;
            }
            return result;
        }

        for (Object o : c) {
            if (!contains(o))
                return false;
        }

        return true;
    }

    public void _ensureCapacity(int minCapacity) {
        _incrementModCount();
    }

    @SuppressWarnings("unchecked")
    public boolean _equals(Object other) {
        if (other == this)
            return true;

        if (other instanceof AbstractListImpl<?>) {
            AbstractListImpl<E> otherList = (AbstractListImpl<E>) other;
            int expectedModCount = _getModCount();
            int otherExpectedModCount = otherList._getModCount();
            SymbolicList<E> otherStorage = otherList._getStorage();
            SymbolicList<E> storage = _getStorage();
            int size = storage.size();
            int otherSize = otherStorage.size();
            boolean result = size == otherSize && LibSLRuntime.equals(storage, otherStorage);
            otherList._checkForModification(otherExpectedModCount);
            _checkForModification(expectedModCount);
            return result;
        }

        return false;
    }

    public void _forEach(Consumer<? super E> _action) {
        if (_action == null)
            throw new NullPointerException();

        int expectedModCount = this._getModCount();
        int i = 0;
        SymbolicList<E> storage = _getStorage();
        while (this._getModCount() == expectedModCount && i < storage.size()) {
            E item = storage.get(i);
            _action.accept(item);
            i++;
        }
        _checkForModification(expectedModCount);
    }

    public E _get(int index) {
        return _checkedGet(index);
    }

    public int _hashCode() {
        return LibSLRuntime.hashCode(_getStorage());
    }

    public int _indexOf(Object o) {
        SymbolicList<E> storage = _getStorage();
        return LibSLRuntime.ListActions.find(storage, o, 0, storage.size());
    }

    public boolean _isEmpty() {
        return _getStorage().size() == 0;
    }

    @NotNull
    public Iterator<E> _iterator() {
        return new ListIteratorStubImpl<>(this);
    }

    public int _lastIndexOf(Object o) {
        SymbolicList<E> storage = _getStorage();
        int size = storage.size();
        if (size == 0)
            return -1;

        Engine.assume(size > 0);
        for (int i = size - 1; i > -1; i--) {
            E e = storage.get(i);
            if (LibSLRuntime.equals(o, e)) {
                return i;
            }
        }
        return -1;
    }

    @NotNull
    public ListIterator<E> _listIterator() {
        return new ListIteratorStubImpl<>(this);
    }

    @NotNull
    public ListIterator<E> _listIterator(int index) {
        _checkValidIndex(index);
        return new ListIteratorStubImpl<>(this, index);
    }

    public Stream<E> _parallelStream() {
        return _makeStream(true);
    }

    public boolean _remove(Object o) {
        int index = indexOf(o);
        if (index == -1)
            return false;

        _deleteElement(index);
        return true;

    }

    public E _remove(int index) {
        return _checkedDeleteElement(index);
    }

    public boolean _removeAll(@NotNull Collection<?> c) {
        return _batchRemove(c, false, 0, _getStorage().size());
    }

    public boolean _removeIf(Predicate<? super E> filter) {
        return _removeIf(filter, 0, _getStorage().size());
    }

    public void _replaceAll(UnaryOperator<E> op) {
        if (op == null)
            throw new NullPointerException();

        _replaceAllRange(op, 0, _getStorage().size());
        _incrementModCount();
    }

    public boolean _retainAll(@NotNull Collection<?> c) {
        return _batchRemove(c, true, 0, _getStorage().size());
    }

    public E _set(int index, E element) {
        return _checkedSetElement(index, element);
    }

    public int _size() {
        return _getStorage().size();
    }

    public void _sort(Comparator<? super E> c) {
        _do_sort(0, _getStorage().size(), c);
    }

    public Spliterator<E> _spliterator() {
        return new ListSpliteratorStubImpl<>(this);
    }

    public Stream<E> _stream() {
        return _makeStream(false);
    }

    @NotNull
    public List<E> _subList(int fromIndex, int toIndex) {
        _subListRangeCheck(fromIndex, toIndex, _getStorage().size());
        return new SubListImpl<>(this, fromIndex, toIndex);
    }

    @NotNull
    public Object[] _toArray() {
        return _mapToArray();
    }

    public <T> T[] _toArray(IntFunction<T[]> generator) {
        return super._toArray(generator);
    }

    @NotNull
    public <T> T[] _toArray(@NotNull T[] array) {
        return super._toArray(array);
    }

    public String _toString() {
        return LibSLRuntime.toString(_getStorage());
    }
}
