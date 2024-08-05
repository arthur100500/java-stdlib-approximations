package generated.java.util.list;

import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import stub.java.util.list.SubListSpliteratorStub;

@Approximate(SubListSpliteratorStub.class)
public final class SubListSpliteratorStubImpl<E> extends ListSpliteratorStubImpl<E> {

    public SubListImpl<E> subList;

    public SubListSpliteratorStubImpl(
        AbstractListImpl<E> list,
        SubListImpl<E> subList,
        int index,
        int fence,
        int expectedModCount
    ) {
        super(list, subList.offset + index, fence, expectedModCount);
        this.subList = subList;
    }

    public SubListSpliteratorStubImpl(SubListImpl<E> subList, int index) {
        this(subList._getList(), subList, index, -1, 0);
    }

    public SubListSpliteratorStubImpl(SubListImpl<E> subList) {
        this(subList, 0);
    }

    protected SubListSpliteratorStubImpl<E> _create(int index, int fence) {
        return new SubListSpliteratorStubImpl<>(this.list, subList, index, fence, this.expectedModCount);
    }

    protected int _parentModCount() {
        return this.subList.modCount;
    }

    protected int _storageSize() {
        return subList._endIndex();
    }

    public int characteristics() {
        return super.characteristics();
    }

    public long estimateSize() {
        return super.estimateSize();
    }

    public void forEachRemaining(Consumer<? super E> _action) {
        super.forEachRemaining(_action);
    }

    public long getExactSizeIfKnown() {
        return super.getExactSizeIfKnown();
    }

    public boolean tryAdvance(Consumer<? super E> _action) {
        return super.tryAdvance(_action);
    }

    public SubListSpliteratorStubImpl<E> trySplit() {
        return (SubListSpliteratorStubImpl<E>) super.trySplit();
    }
}
