package generated.java.util.set;

import java.io.Serial;
import java.io.Serializable;
import java.lang.Object;
import java.lang.String;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@Approximate(java.util.HashSet.class)
public class HashSetImpl<E> extends AbstractSetImpl<E> implements Cloneable, Serializable {

    @Serial
    private static final long serialVersionUID = -5024744406713321676L;

    private LibSLRuntime.Map<E, Object> storage;

    private int modCount;

    static {
        Engine.assume(true);
    }

    public HashSetImpl() {
        super(true);
    }

    public HashSetImpl(Collection<? extends E> c) {
        super(true, c);
    }

    public HashSetImpl(int initialCapacity) {
        super(true, initialCapacity);
    }

    public HashSetImpl(int initialCapacity, float loadFactor) {
        super(true, initialCapacity, loadFactor);
    }

    @SuppressWarnings("unused")
    private HashSetImpl(int initialCapacity, float loadFactor, boolean dummy) {
        super(initialCapacity, loadFactor, dummy);
    }

    public LibSLRuntime.Map<E, Object> _getStorage() {
        LibSLRuntime.Map<E, Object> storage = this.storage;
        Engine.assume(storage != null);
        return storage;
    }

    public void _setStorage(LibSLRuntime.Map<E, Object> storage) {
        this.storage = storage;
    }

    protected boolean _isHashSet() {
        return true;
    }

    public int _getModCount() {
        return modCount;
    }

    protected void _setModCount(int newModCount) {
        this.modCount = newModCount;
    }

    public boolean add(E obj) {
        return super._add(obj);
    }

    public void clear() {
        super._clear();
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Object clone() throws CloneNotSupportedException {
        return super._clone();
    }

    public boolean contains(Object obj) {
        return super._contains(obj);
    }

    public boolean isEmpty() {
        return super._isEmpty();
    }

    @NotNull
    public Iterator<E> iterator() {
        return super._iterator();
    }

    public boolean remove(Object elem) {
        return super._remove(elem);
    }

    public int size() {
        return super._size();
    }

    @NotNull
    public Spliterator<E> spliterator() {
        return super._spliterator();
    }

    @SuppressWarnings("EqualsDoesntCheckParameterClass")
    public boolean equals(Object other) {
        return Engine.typeIs(other, HashSetImpl.class) && super._equals(other);
    }

    public int hashCode() {
        return super._hashCode();
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        return super._removeAll(c);
    }

    @NotNull
    public Object[] toArray() {
        return super._toArray();
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] a) {
        return super._toArray(a);
    }

    public <T> T[] toArray(@NotNull IntFunction<T[]> generator) {
        return super._toArray(generator);
    }

    public boolean containsAll(@NotNull Collection<?> c) {
        return super._containsAll(c);
    }

    public boolean addAll(@NotNull Collection<? extends E> c) {
        return super._addAll(c);
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        return super._retainAll(c);
    }

    public boolean removeIf(@NotNull Predicate<? super E> filter) {
        return super._removeIf(filter);
    }

    public void forEach(Consumer<? super E> userAction) {
        super._forEach(userAction);
    }

    @NotNull
    public Stream<E> stream() {
        return super._stream();
    }

    @NotNull
    public Stream<E> parallelStream() {
        return super._parallelStream();
    }

    public String toString() {
        return super._toString();
    }
}
