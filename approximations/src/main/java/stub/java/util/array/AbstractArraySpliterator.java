package stub.java.util.array;

import java.util.Comparator;
import java.util.Spliterators;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public abstract class AbstractArraySpliterator<E> extends Spliterators.AbstractSpliterator<E> {

    public AbstractArraySpliterator(int index, int fence, int characteristics) {
        super(fence - index, characteristics);
        throw new LinkageError();
    }

    protected int _parentModCount() {
        throw new LinkageError();
    }

    protected int _storageSize() {
        throw new LinkageError();
    }

    protected int _getFence() {
        throw new LinkageError();
    }

    protected void _checkForModification() {
        throw new LinkageError();
    }

    public boolean hasCharacteristics(int _characteristics) {
        throw new LinkageError();
    }

    public int characteristics() {
        throw new LinkageError();
    }

    public long estimateSize() {
        throw new LinkageError();
    }

    abstract protected E _getItem(int index);

    public void forEachRemaining(Consumer<? super E> _action) {
        throw new LinkageError();
    }

    public Comparator<? super E> getComparator() {
        throw new LinkageError();
    }

    public long getExactSizeIfKnown() {
        throw new LinkageError();
    }

    public boolean tryAdvance(Consumer<? super E> _action) {
        throw new LinkageError();
    }

    public AbstractArraySpliterator<E> trySplit() {
        throw new LinkageError();
    }
}
