package stub.java.util.list;

import generated.java.util.list.AbstractListImpl;
import generated.java.util.list.SubListImpl;

import java.lang.LinkageError;
import java.util.function.Consumer;

public final class SubListSpliteratorStub<E> extends ListSpliteratorStub<E> {

    @SuppressWarnings("unused")
    public SubListSpliteratorStub(
        AbstractListImpl<E> list,
        SubListImpl<E> subList,
        int index,
        int fence,
        int expectedModCount
    ) {
        super(list, index, fence, expectedModCount);
        throw new LinkageError();
    }

    public SubListSpliteratorStub(SubListImpl<E> subList, int index) {
        this(subList._getList(), subList, index, -1, 0);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public SubListSpliteratorStub(SubListImpl<E> subList) {
        this(subList, 0);
        throw new LinkageError();
    }

    protected SubListSpliteratorStub<E> _create(int index, int fence) {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    protected int _parentModCount() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    protected int _storageSize() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public int characteristics() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public long estimateSize() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void forEachRemaining(Consumer<? super E> _action) {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public long getExactSizeIfKnown() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public boolean tryAdvance(Consumer<? super E> _action) {
        throw new LinkageError();
    }

    public SubListSpliteratorStub<E> trySplit() {
        throw new LinkageError();
    }
}
