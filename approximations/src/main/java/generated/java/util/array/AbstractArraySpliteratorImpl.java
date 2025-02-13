package generated.java.util.array;

import generated.java.util.AbstractSpliteratorImpl;
import generated.java.util.SpliteratorsImpl;
import generated.runtime.LibSLGlobals;
import org.jacodb.approximation.annotation.Approximate;
import stub.java.util.array.AbstractArraySpliterator;

import java.util.Comparator;
import java.util.function.Consumer;

@Approximate(AbstractArraySpliterator.class)
public abstract class AbstractArraySpliteratorImpl<E> extends AbstractSpliteratorImpl<E> {

    public int characteristics;

    public int index;

    public int fence;

    public int expectedModCount;

    public AbstractArraySpliteratorImpl(int index, int fence, int characteristics) {
        super(index, fence, 0);
        this.characteristics = characteristics | SpliteratorsImpl._characteristics;
    }

    protected int _getIndex() {
        return index;
    }

    protected void _setIndex(int newIndex) {
        this.index = newIndex;
    }

    protected int _getFence() {
        return fence;
    }

    protected void _setFence(int newFence) {
        this.fence = newFence;
    }

    protected int _getExpectedModCount() {
        return expectedModCount;
    }

    protected void _setExpectedModCount(int newExpectedModCount) {
        this.expectedModCount = newExpectedModCount;
    }

    protected int _parentModCount() {
        return 0;
    }

    protected int _storageSize() {
        return this.fence;
    }

    protected int _fence() {
        return this.fence;
    }

    protected void _checkForModification() {
    }

    @SuppressWarnings("MagicConstant")
    public boolean hasCharacteristics(int _characteristics) {
        return (this.characteristics & _characteristics) == _characteristics;
    }

    protected int _characteristics() {
        return this.characteristics;
    }

    @SuppressWarnings("MagicConstant")
    public int characteristics() {
        return _characteristics();
    }

    public long estimateSize() {
        return super._estimateSize();
    }

    abstract protected E _getItem(int index);

    public void forEachRemaining(Consumer<? super E> _action) {
        _forEachRemaining(_action);
    }

    protected void _forEachRemaining(Consumer<? super E> _action) {
        if (_action == null)
            throw new NullPointerException();

        int current = this.index;
        this.index = this.fence;
        for (int i = current; i < this.fence; i++) {
            E item = _getItem(i);
            _action.accept(item);
        }
    }

    @SuppressWarnings("MagicConstant")
    public Comparator<? super E> getComparator() {
        if (hasCharacteristics(LibSLGlobals.SPLITERATOR_SORTED))
            return null;

        throw new IllegalStateException();
    }

    public long getExactSizeIfKnown() {
        return super._getExactSizeIfKnown();
    }

    public boolean tryAdvance(Consumer<? super E> _action) {
        return _tryAdvance(_action);
    }

    protected boolean _tryAdvance(Consumer<? super E> _action) {
        if (_action == null)
            throw new NullPointerException();

        int current = this.index;
        if (current >= this.fence)
            return false;

        this.index = current + 1;
        E item = _getItem(current);
        _action.accept(item);
        return true;
    }

    public AbstractArraySpliteratorImpl<E> trySplit() {
        return (AbstractArraySpliteratorImpl<E>) super._trySplit();
    }
}
