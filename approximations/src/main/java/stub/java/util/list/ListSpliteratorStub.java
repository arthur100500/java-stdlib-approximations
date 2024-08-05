package stub.java.util.list;

import generated.java.util.list.AbstractListImpl;

import java.lang.LinkageError;
import java.util.Spliterators;
import java.util.function.Consumer;

public class ListSpliteratorStub<E> extends Spliterators.AbstractSpliterator<E> {

    @SuppressWarnings("unused")
    protected ListSpliteratorStub(AbstractListImpl<E> list, int index, int fence, int expectedModCount) {
        super(fence - index, expectedModCount);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public ListSpliteratorStub(AbstractListImpl<E> list) {
        this(list, 0, -1, 0);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    protected ListSpliteratorStub<E> _create(int index, int fence) {
        throw new LinkageError();
    }

    protected int _parentModCount() {
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    protected int _storageSize() {
        throw new LinkageError();
    }

    public int characteristics() {
        throw new LinkageError();
    }

    public long estimateSize() {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer<? super E> _action) {
        throw new LinkageError();
    }

    public long getExactSizeIfKnown() {
        throw new LinkageError();
    }

    public boolean tryAdvance(Consumer<? super E> _action) {
        throw new LinkageError();
    }

    public ListSpliteratorStub<E> trySplit() {
        throw new LinkageError();
    }
}
