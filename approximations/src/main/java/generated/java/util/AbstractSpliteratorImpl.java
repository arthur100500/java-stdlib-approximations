package generated.java.util;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

import java.util.ConcurrentModificationException;
import java.util.Spliterator;
import java.util.function.Consumer;

@Approximate(java.util.Spliterators.AbstractSpliterator.class)
public abstract class AbstractSpliteratorImpl<E> implements Spliterator<E> {

    public AbstractSpliteratorImpl(int index, int fence, int expectedModCount) {
        Engine.assume(index >= 0);
        _setIndex(index);
        _setFence(fence);
        _setExpectedModCount(expectedModCount);
    }

    abstract protected int _getIndex();

    abstract protected void _setIndex(int newIndex);

    abstract protected int _getFence();

    abstract protected void _setFence(int newFence);

    abstract protected int _getExpectedModCount();

    abstract protected void _setExpectedModCount(int newExpectedModCount);

    abstract protected AbstractSpliteratorImpl<E> _create(int index, int fence);

    abstract protected int _parentModCount();

    protected final void _eval() {
        _setExpectedModCount(_parentModCount());
    }

    abstract protected int _storageSize();

    protected int _fence() {
        if (this._getFence() < 0) {
            _eval();
            _setFence(_storageSize());
            Engine.assume(this._getFence() >= 0);
        }

        return this._getFence();
    }

    protected void _checkForModification() {
        if (_parentModCount() != _getExpectedModCount())
            throw new ConcurrentModificationException();
    }

    protected abstract int _characteristics();

    public long _estimateSize() {
        return _getExactSizeIfKnown();
    }

    protected abstract void _forEachRemaining(Consumer<? super E> userAction);

    public long _getExactSizeIfKnown() {
        return _fence() - _getIndex();
    }

    protected abstract boolean _tryAdvance(Consumer<? super E> userAction);

    protected AbstractSpliteratorImpl<E> _trySplit() {
        int hi = _fence();
        int lo = _getIndex();
        int mid = (lo + hi) >>> 1;
        if (lo >= mid)
            return null;

        _setIndex(mid);
        return _create(lo, mid);
    }
}
