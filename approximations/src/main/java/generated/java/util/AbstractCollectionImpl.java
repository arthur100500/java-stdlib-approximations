package generated.java.util;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.function.IntFunction;

@Approximate(java.util.AbstractCollection.class)
public abstract class AbstractCollectionImpl<E> implements Collection<E> {

    public transient int modCount;

    public AbstractCollectionImpl(int modCount) {
        this.modCount = modCount;
    }

    abstract protected Object[] _mapToArray();

    protected void _checkForModification(int expectedModCount) {
        if (this.modCount != expectedModCount)
            throw new ConcurrentModificationException();
    }

    abstract public int size();

    @NotNull
    public Object[] toArray() {
        return _mapToArray();
    }

    @SuppressWarnings("unchecked")
    private <T> T[] _toArray(T[] array, int size) {
        Object[] contents = _mapToArray();
        Engine.assume(size == contents.length);

        if (array.length < size)
            return (T[]) Arrays.copyOf(contents, size, array.getClass());

        LibSLRuntime.ArrayActions.copy(contents, 0, array, 0, size);
        return array;
    }

    public <T> T[] toArray(IntFunction<T[]> generator) {
        int size = size();
        T[] array = generator.apply(size);

        return _toArray(array, size);
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        int size = size();
        return _toArray(array, size);
    }

    abstract public String toString();
}
