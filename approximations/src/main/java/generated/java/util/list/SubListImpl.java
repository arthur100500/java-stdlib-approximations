package generated.java.util.list;

import java.io.Serial;
import java.io.Serializable;
import java.lang.Object;
import java.lang.String;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import generated.java.util.stream.StreamStubImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.list.SubList;

@Approximate(SubList.class)
public final class SubListImpl<E> extends AbstractListImpl<E> implements RandomAccess, Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = 8683452581122892189L;

    public transient AbstractListImpl<E> list;

    public SubListImpl<E> parentSubList;

    public int offset;

    public int length;

    public int modCount;

    @SuppressWarnings("DataFlowIssue")
    private SubListImpl(AbstractListImpl<E> list, SubListImpl<E> parent, int offset, int length, int modCount) {
        Engine.assume(list != null);
        Engine.assume(offset >= 0);
        Engine.assume(length >= 0);
        Engine.assume(offset + length <= list._getStorage().size());
        this.list = list;
        this.parentSubList = parent;
        this.offset = offset;
        this.length = length;
        this.modCount = modCount;
    }

    public SubListImpl(AbstractListImpl<E> list, int fromIndex, int toIndex) {
        this(list, null, fromIndex, toIndex - fromIndex, 0);
    }

    public AbstractListImpl<E> _getList() {
        AbstractListImpl<E> result = this.list;
        Engine.assume(result != null);
        return result;
    }

    private int _effectiveIndex(int index) {
        return this.offset + index;
    }

    public int _endIndex() {
        return _effectiveIndex(this.length);
    }

    public boolean _addAllElements(int index, Collection<? extends E> c) {
        list._checkValidIndex(index, this.length);
        int effectiveIndex = _effectiveIndex(index);
        AbstractListImpl<E> list = _getList();
        if (c.isEmpty())
            return false;

        list._checkForModification(this.modCount);
        list._addAllElements(effectiveIndex, c);
        _updateSizeAndModCount(c.size());

        return true;
    }

    public void _updateSizeAndModCount(int sizeChange) {
        this.length += sizeChange;
        AbstractListImpl<E> list = _getList();
        this.modCount = list.modCount;
        SubListImpl<E> parentSubList = this.parentSubList;
        while (parentSubList != null) {
            parentSubList.length += sizeChange;
            parentSubList.modCount = this.modCount;
            parentSubList = parentSubList.parentSubList;
        }
    }

    private int _indexOfElement(AbstractListImpl<E> list, Object o) {
        return LibSLRuntime.ListActions.find(list._getStorage(), o, this.offset, _endIndex());
    }

    private int _indexOfElement(Object o) {
        AbstractListImpl<E> list = _getList();
        list._checkForModification(this.modCount);
        int index = _indexOfElement(list, o);
        if (index != -1)
            return index - this.offset;

        return -1;
    }

    protected Object[] _mapToArray() {
        AbstractListImpl<E> list = _getList();
        list._checkForModification(this.modCount);
        SymbolicList<E> storage = list._getStorage();
        Object[] items = new Object[this.length];
        int endIndex = _endIndex();
        for (int i = this.offset; i < endIndex; i++) {
            items[i] = storage.get(i);
        }
        return items;
    }

    @SuppressWarnings("unchecked")
    private Stream<E> _makeStream(boolean parallel) {
        E[] items = (E[]) _mapToArray();
        return new StreamStubImpl<>(items, parallel);
    }

    private boolean _batchRemove(Collection<?> c, boolean complement) {
        AbstractListImpl<E> list = _getList();
        list._checkForModification(this.modCount);
        if (isEmpty())
            return false;

        SymbolicList<E> storage = list._getStorage();
        int oldRootLength = storage.size();
        if (list._batchRemove(c, complement, this.offset, _endIndex())) {
            int newRootLength = storage.size();
            _updateSizeAndModCount(newRootLength - oldRootLength);
            return true;
        }

        return false;
    }

    public void add(int index, E element) {
        AbstractListImpl<E> list = _getList();
        list._checkForModification(this.modCount);
        int effectiveIndex = _effectiveIndex(index);
        list._checkedAddElement(effectiveIndex, element);
        _updateSizeAndModCount(1);
    }

    public boolean add(E e) {
        add(this.length, e);
        return true;
    }

    public boolean addAll(@NotNull Collection<? extends E> c) {
        return _addAllElements(this.length, c);
    }

    public boolean addAll(int index, @NotNull Collection<? extends E> c) {
        return _addAllElements(index, c);
    }

    public void clear() {
        AbstractListImpl<E> list = _getList();
        list._checkForModification(this.modCount);
        int size = this.length;
        if (size == 0)
            return;

        Engine.assume(size > 0);
        int end = this.offset - 1;
        int start = end + size;
        SymbolicList<E> rootStorage = list._getStorage();
        for (int i = start; i > end; i--) {
            rootStorage.remove(i);
        }
        list.modCount++;
        _updateSizeAndModCount(-size);
    }

    @SuppressWarnings("unchecked")
    public Object clone() throws CloneNotSupportedException {
        SubListImpl<E> cloned = (SubListImpl<E>) super.clone();
        cloned.list = (AbstractListImpl<E>) this.list.clone();
        cloned.parentSubList = (SubListImpl<E>) this.parentSubList.clone();
        cloned.modCount = 0;
        return cloned;
    }

    public boolean contains(Object o) {
        return _indexOfElement(o) != -1;
    }

    @SuppressWarnings({"unchecked"})
    public boolean containsAll(@NotNull Collection<?> c) {
        if (c.isEmpty())
            return true;

        AbstractListImpl<E> list = _getList();
        SymbolicList<E> rootStorage = list._getStorage();
        int start = this.offset;
        int end = _endIndex();
        if (c instanceof SubListImpl<?>) {
            SubListImpl<E> otherSubList = (SubListImpl<E>) c;
            AbstractListImpl<E> otherRoot = otherSubList._getList();
            SymbolicList<E> otherStorage = otherRoot._getStorage();
            int otherOffset = otherSubList.offset;
            int otherEnd = otherOffset + otherSubList.length;
            Engine.assume(otherOffset >= 0);
            Engine.assume(otherEnd >= 0);
            for (int i = otherOffset; i < otherEnd; i++) {
                E item = otherStorage.get(i);
                if (LibSLRuntime.ListActions.find(rootStorage, item, start, end) == -1)
                    return false;
            }

            return true;
        }

        for (Object item : c) {
            if (LibSLRuntime.ListActions.find(rootStorage, item, start, end) == -1)
                return false;
        }

        return true;
    }

    @SuppressWarnings({"unchecked", "EqualsWhichDoesntCheckParameterClass"})
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (o == null || !Engine.typeIs(o, SubListImpl.class))
            return false;

        SubListImpl<E> other = (SubListImpl<E>) o;
        int otherLength = other.length;
        Engine.assume(otherLength >= 0);
        if (this.length != otherLength)
            return false;

        AbstractListImpl<E> list = _getList();
        boolean result = list._equalsRange(other, this.offset, _endIndex());
        list._checkForModification(this.modCount);

        return result;
    }

    public void forEach(Consumer<? super E> _action) {
        if (isEmpty())
            return;

        Engine.assume(this.length > 0);
        AbstractListImpl<E> list = _getList();
        SymbolicList<E> rootStorage = list._getStorage();
        int expectedModCount = list.modCount;
        this.modCount = expectedModCount;
        int end = _endIndex();
        list._checkForModification(expectedModCount);
        for (int i = this.offset; i < end; i++) {
            _action.accept(rootStorage.get(i));
            list._checkForModification(expectedModCount);
        }
    }

    public E get(int index) {
        AbstractListImpl<E> list = _getList();
        list._checkValidIndex(index, this.length);
        list._checkForModification(this.modCount);
        int effectiveIndex = _effectiveIndex(index);
        return list._getStorage().get(effectiveIndex);
    }

    public int hashCode() {
        int result = 1;
        if (isEmpty())
            return result;

        Engine.assume(this.length > 0);
        AbstractListImpl<E> list = _getList();
        SymbolicList<E> rootStorage = list._getStorage();
        result = LibSLRuntime.hashCode(rootStorage, this.offset, _endIndex());
        list._checkForModification(this.modCount);

        return result;
    }

    public int indexOf(Object o) {
        return _indexOfElement(o);
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    @NotNull
    public Iterator<E> iterator() {
        return new SubListIteratorStubImpl<>(this);
    }

    public int lastIndexOf(Object o) {
        AbstractListImpl<E> list = _getList();
        list._checkForModification(this.modCount);
        if (isEmpty())
            return -1;

        Engine.assume(this.length > 0);
        int end = _endIndex();
        SymbolicList<E> rootStorage = list._getStorage();
        int result = LibSLRuntime.ListActions.findBack(rootStorage, o, this.offset, end);
        if (result == -1)
            return result;

        result -= this.offset;
        return result;
    }

    @NotNull
    public ListIterator<E> listIterator() {
        return new SubListIteratorStubImpl<>(this);
    }

    @NotNull
    public ListIterator<E> listIterator(int index) {
        return new SubListIteratorStubImpl<>(this, index);
    }

    public Stream<E> parallelStream() {
        return _makeStream(true);
    }

    public boolean remove(Object o) {
        AbstractListImpl<E> list = _getList();
        int index = _indexOfElement(list, o);
        if (index == -1)
            return false;

        list._checkForModification(this.modCount);
        list._checkedDeleteElement(index);
        _updateSizeAndModCount(-1);

        return true;
    }

    public E remove(int index) {
        AbstractListImpl<E> list = _getList();
        list._checkValidIndex(index, this.length);
        list._checkForModification(this.modCount);
        int effectiveIndex = _effectiveIndex(index);
        E result = list._checkedDeleteElement(effectiveIndex);
        _updateSizeAndModCount(-1);

        return result;
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        return _batchRemove(c, false);
    }

    public boolean removeIf(Predicate<? super E> filter) {
        AbstractListImpl<E> list = _getList();
        list._checkForModification(this.modCount);
        if (isEmpty())
            return false;

        SymbolicList<E> storage = list._getStorage();
        int oldRootLength = storage.size();
        if (list._removeIf(filter, this.offset, _endIndex())) {
            int newRootLength = storage.size();
            _updateSizeAndModCount(newRootLength - oldRootLength);
            return true;
        }

        return false;
    }

    public void replaceAll(UnaryOperator<E> operator) {
        if (operator == null)
            throw new NullPointerException();

        _getList()._replaceAllRange(operator, this.offset, _endIndex());
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        return _batchRemove(c, true);
    }

    public E set(int index, E element) {
        AbstractListImpl<E> list = _getList();
        list._checkValidIndex(index, this.length);
        list._checkForModification(this.modCount);
        SymbolicList<E> parentStorage = list._getStorage();
        int effectiveIndex = _effectiveIndex(index);
        E oldValue = parentStorage.get(effectiveIndex);
        parentStorage.set(effectiveIndex, element);

        return oldValue;
    }

    public int size() {
        _getList()._checkForModification(this.modCount);
        return this.length;
    }

    public void sort(Comparator<? super E> c) {
        AbstractListImpl<E> list = _getList();
        list._do_sort(this.offset, _endIndex(), c);
        this.modCount = list.modCount;
    }

    public Spliterator<E> spliterator() {
        return new SubListSpliteratorStubImpl<>(this);
    }

    public Stream<E> stream() {
        return _makeStream(false);
    }

    @NotNull
    public List<E> subList(int fromIndex, int toIndex) {
        AbstractListImpl<E> list = _getList();
        list._subListRangeCheck(fromIndex, toIndex, this.length);

        return new SubListImpl<>(list, this, _effectiveIndex(fromIndex), toIndex - fromIndex, this.modCount);
    }

    @NotNull
    public Object[] toArray() {
        return super.toArray();
    }

    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        return super.toArray(array);
    }

    public String toString() {
        if (this.length == 0)
            return "[]";

        String result = "[";
        AbstractListImpl<E> list = _getList();
        SymbolicList<E> rootStorage = list._getStorage();
        int end = _endIndex();
        int counter = this.length;
        for (int i = this.offset; i < end; i++) {
            E item = rootStorage.get(i);
            result = result.concat(LibSLRuntime.toString(item));
            counter--;
            if (counter != 0)
                result = result.concat(", ");
        }

        return result.concat("]");
    }
}
