package stub.java.util.set;

import generated.java.util.set.AbstractSetImpl;
import runtime.LibSLRuntime;
import stub.java.util.AbstractIterator;

import java.lang.LinkageError;
import java.lang.Object;
import java.util.function.Consumer;

public final class Set_Iterator<E> extends AbstractIterator<E> {

    @SuppressWarnings("unused")
    public Set_Iterator(
        int expectedModCount,
        LibSLRuntime.Map<E, Object> unseen,
        AbstractSetImpl<E> set,
        E currentKey
    ) {
        super(expectedModCount);
        throw new LinkageError();
    }

    protected int _parentModCount() {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer<? super E> userAction) {
        throw new LinkageError();
    }

    public boolean hasNext() {
        throw new LinkageError();
    }

    public E next() {
        throw new LinkageError();
    }

    public void remove() {
        throw new LinkageError();
    }
}
