package generated.java.util;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

import java.util.ConcurrentModificationException;
import java.util.Spliterator;
import java.util.function.Consumer;

@Approximate(java.util.Spliterators.AbstractSpliterator.class)
public abstract class AbstractSpliteratorImpl<E> implements Spliterator<E> {

    public int index;

    public int fence;

    public int expectedModCount;

    public AbstractSpliteratorImpl(int index, int fence, int expectedModCount) {
        Engine.assume(index >= 0);
        this.index = index;
        this.fence = fence;
        this.expectedModCount = expectedModCount;
    }

    abstract protected AbstractSpliteratorImpl<E> _create(int index, int fence);

    abstract protected int _parentModCount();

    protected final void _eval() {
        this.expectedModCount = _parentModCount();
    }

    abstract protected int _storageSize();

    protected int _getFence() {
        if (this.fence < 0) {
            _eval();
            this.fence = _storageSize();
            Engine.assume(this.fence >= 0);
        }

        return this.fence;
    }

    protected void _checkForModification() {
        if (_parentModCount() != expectedModCount)
            throw new ConcurrentModificationException();
    }

    public abstract int characteristics();

    public long estimateSize() {
        return getExactSizeIfKnown();
    }

    public abstract void forEachRemaining(Consumer<? super E> userAction);

    public long getExactSizeIfKnown() {
        return _getFence() - this.index;
    }

    public abstract boolean tryAdvance(Consumer<? super E> userAction);

    public AbstractSpliteratorImpl<E> trySplit() {
        int hi = _getFence();
        int lo = this.index;
        int mid = (lo + hi) >>> 1;
        if (lo >= mid)
            return null;

        this.index = mid;
        return _create(lo, mid);
    }
}
