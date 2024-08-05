package generated.java.util.set;

import generated.java.util.AbstractCollectionImpl;
import generated.java.util.stream.StreamStubImpl;
import generated.runtime.LibSLGlobals;

import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
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
import runtime.LibSLRuntime;

@Approximate(java.util.AbstractSet.class)
public abstract class AbstractSetImpl<E> extends AbstractCollectionImpl<E> implements Set<E> {

    public LibSLRuntime.Map<E, Object> storage;

    private boolean isHashSet;

    private static <E> LibSLRuntime.Map.Container<E, Object> createContainer(boolean isHashSet) {
        if (isHashSet)
            return new LibSLRuntime.HashMapContainer<>();

        return new LibSLRuntime.IdentityMapContainer<>();
    }

    private static <E> LibSLRuntime.Map<E, Object> createStorage(boolean isHashSet) {
        return new LibSLRuntime.Map<>(createContainer(isHashSet));
    }

    public AbstractSetImpl(LibSLRuntime.Map<E, Object> storage, int modCount, boolean isHashSet) {
        super(modCount);
        this.storage = storage;
        this.isHashSet = isHashSet;
    }

    public AbstractSetImpl(boolean isHashSet) {
        this(createStorage(isHashSet), 0, isHashSet);
    }

    @SuppressWarnings("unused")
    public AbstractSetImpl(boolean isHashSet, Collection<? extends E> c) {
        this(isHashSet);
        _addAllElements(c);
    }

    @SuppressWarnings("unused")
    public AbstractSetImpl(boolean isHashSet, int initialCapacity) {
        super(0);

        if (initialCapacity < 0)
            throw new IllegalArgumentException();

        this.storage = createStorage(isHashSet);
        this.isHashSet = isHashSet;
    }

    @SuppressWarnings("unused")
    public AbstractSetImpl(boolean isHashSet, int initialCapacity, float loadFactor) {
        super(0);

        if (initialCapacity < 0)
            throw new IllegalArgumentException();

        if (loadFactor <= 0 || loadFactor != loadFactor)
            throw new IllegalArgumentException();

        this.storage = createStorage(isHashSet);
        this.isHashSet = isHashSet;
    }

    @SuppressWarnings("unused")
    public AbstractSetImpl(int initialCapacity, float loadFactor, boolean dummy) {
        super(0);
        LibSLRuntime.error("Private constructor call");
    }

    public LibSLRuntime.Map<E, Object> _getStorage() {
        LibSLRuntime.Map<E, Object> storage = this.storage;
        Engine.assume(storage != null);
        return storage;
    }

    private void _add(E key) {
        _getStorage().set(key, LibSLGlobals.SOMETHING);
    }

    @SuppressWarnings("unchecked")
    public boolean _addAllElements(Collection<? extends E> c) {
        LibSLRuntime.Map<E, Object> storage = _getStorage();
        int lengthBeforeAdd = storage.size();

        if (c instanceof AbstractSetImpl<?>) {
            AbstractSetImpl<E> other = (AbstractSetImpl<E>) c;
            LibSLRuntime.Map<E, Object> otherStorage = other._getStorage();
            storage.union(otherStorage);
        } else {
            for (E key : c) {
                if (!storage.hasKey(key))
                    _add(key);
            }
        }

        if (lengthBeforeAdd != storage.size()) {
            this.modCount++;
            return true;
        }

        return false;
    }

    protected Object[] _mapToArray() {
        int size = _getStorage().size();
        Object[] items = new Object[size];
        LibSLRuntime.Map<E, Object> unseen = _getStorage().duplicate();
        for (int i = 0; i < size; i++) {
            E key = unseen.anyKey();
            unseen.remove(key);
            items[i] = key;
        }
        return items;
    }

    @SuppressWarnings("unchecked")
    public Stream<E> _makeStream(boolean parallel) {
        E[] items = (E[]) _mapToArray();
        return new StreamStubImpl<>(items, parallel);
    }

    public boolean add(E obj) {
        LibSLRuntime.Map<E, Object> storage = _getStorage();
        this.modCount++;
        if (storage.hasKey(obj))
            return false;

        storage.set(obj, LibSLGlobals.SOMETHING);
        return true;
    }

    public void clear() {
        this.storage = createStorage(this.isHashSet);
        this.modCount++;
    }

    @SuppressWarnings("unchecked")
    public Object clone() throws CloneNotSupportedException {
        AbstractSetImpl<E> clonedSet = (AbstractSetImpl<E>) super.clone();
        clonedSet.modCount = 0;
        clonedSet.storage = _getStorage().duplicate();
        return clonedSet;
    }

    @SuppressWarnings("unchecked")
    public boolean contains(Object obj) {
        if (isEmpty())
            return false;

        return _getStorage().hasKey((E) obj);
    }

    public boolean isEmpty() {
        return _getStorage().size() == 0;
    }

    @NotNull
    public Iterator<E> iterator() {
        LibSLRuntime.Map<E, Object> unseenKeys = _getStorage().duplicate();
        return new Set_IteratorImpl<>(this.modCount, unseenKeys, this, null);
    }

    @SuppressWarnings("unchecked")
    public boolean remove(Object elem) {
        E typedElem = (E) elem;
        LibSLRuntime.Map<E, Object> storage = _getStorage();
        if (storage.hasKey(typedElem)) {
            storage.remove(typedElem);
            this.modCount++;
            return true;
        }

        return false;
    }

    public int size() {
        return _getStorage().size();
    }

    public Spliterator<E> spliterator() {
        return new Set_SpliteratorImpl<>(this);
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (!(other instanceof Set))
            return false;

        int expectedModCount = this.modCount;
        AbstractSetImpl<E> otherSet = (AbstractSetImpl<E>) other;
        int otherExpectedModCount = otherSet.modCount;
        LibSLRuntime.Map<E, Object> otherStorage = otherSet._getStorage();

        LibSLRuntime.Map<E, Object> storage = _getStorage();
        if (storage.size() != otherStorage.size())
            return false;

        boolean result = LibSLRuntime.equals(storage, otherStorage);
        otherSet._checkForModification(otherExpectedModCount);
        this._checkForModification(expectedModCount);

        return result;
    }

    public int hashCode() {
        return LibSLRuntime.hashCode(_getStorage());
    }

    @SuppressWarnings({"ConstantValue", "unchecked"})
    public boolean removeAll(@NotNull Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }

        int expectedModCount = this.modCount;
        int otherSize = c.size();
        LibSLRuntime.Map<E, Object> storage = _getStorage();
        int lengthBeforeRemoving = storage.size();
        if (storage.size() > otherSize) {
            for (Object key : c) {
                E eKey = (E) key;
                if (storage.hasKey(eKey))
                    storage.remove(eKey);
            }
        } else {
            LibSLRuntime.Map<E, Object> unseenKeys = storage.duplicate();
            int i = 0;
            while (i < lengthBeforeRemoving) {
                E key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                if (c.contains(key)) {
                    storage.remove(key);
                }
                i++;
            }
        }
        _checkForModification(expectedModCount);
        this.modCount++;
        return lengthBeforeRemoving != storage.size();
    }

    @NotNull
    public Object[] toArray() {
        return super.toArray();
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        return super.toArray(array);
    }

    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }

    @SuppressWarnings("unchecked")
    public boolean containsAll(@NotNull Collection<?> c) {
        LibSLRuntime.Map<E, Object> storage = _getStorage();
        for (Object key : c) {
            if (!storage.hasKey((E) key))
                return false;
        }

        return true;
    }

    public boolean addAll(@NotNull Collection<? extends E> c) {
        return _addAllElements(c);
    }

    @SuppressWarnings("ConstantValue")
    public boolean retainAll(@NotNull Collection<?> c) {
        if (c == null)
            throw new NullPointerException();

        LibSLRuntime.Map<E, Object> storage = _getStorage();
        int lengthBeforeAdd = storage.size();
        LibSLRuntime.Map<E, Object> unseenKeys = storage.duplicate();
        int i = 0;
        while (i < lengthBeforeAdd) {
            E key = unseenKeys.anyKey();
            unseenKeys.remove(key);
            if (!c.contains(key))
                storage.remove(key);
            i++;
        }
        if (lengthBeforeAdd != storage.size()) {
            this.modCount++;
            return true;
        }

        return false;
    }

    public boolean removeIf(Predicate<? super E> filter) {
        if (filter == null)
            throw new NullPointerException();

        LibSLRuntime.Map<E, Object> storage = _getStorage();
        int lengthBeforeAdd = storage.size();
        int expectedModCount = this.modCount;
        LibSLRuntime.Map<E, Object> unseenKeys = storage.duplicate();
        int i = 0;
        while (i < lengthBeforeAdd) {
            E key = unseenKeys.anyKey();
            unseenKeys.remove(key);
            if (filter.test(key))
                storage.remove(key);
            i++;
        }
        _checkForModification(expectedModCount);
        if (lengthBeforeAdd != storage.size()) {
            this.modCount++;
            return true;
        }

        return false;
    }

    public void forEach(Consumer<? super E> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        LibSLRuntime.Map<E, Object> storage = _getStorage();
        int count = storage.size();
        int expectedModCount = this.modCount;
        LibSLRuntime.Map<E, Object> unseenKeys = storage.duplicate();
        int i = 0;
        while (i < count) {
            E key = unseenKeys.anyKey();
            unseenKeys.remove(key);
            userAction.accept(key);
            i++;
        }
        _checkForModification(expectedModCount);
    }

    public Stream<E> stream() {
        return _makeStream(false);
    }

    public Stream<E> parallelStream() {
        return _makeStream(true);
    }

    public String toString() {
        LibSLRuntime.Map<E, Object> storage = _getStorage();
        int count = storage.size();
        if (count == 0)
            return "[]";

        Engine.assume(count > 0);
        String result = "[";
        LibSLRuntime.Map<E, Object> unseen = storage.duplicate();
        while (count != 0) {
            E key = unseen.anyKey();
            unseen.remove(key);
            result = result.concat(LibSLRuntime.toString(key));
            if (count > 1)
                result = result.concat(", ");
            count--;
        }

        return result.concat("]");
    }
}
