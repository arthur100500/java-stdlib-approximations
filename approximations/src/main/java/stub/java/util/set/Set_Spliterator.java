package stub.java.util.set;

import java.lang.LinkageError;
import java.lang.SuppressWarnings;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

import generated.java.util.AbstractSpliteratorImpl;
import generated.java.util.set.AbstractSetImpl;
import generated.java.util.set.Set_SpliteratorImpl;
import org.usvm.api.SymbolicList;

public final class Set_Spliterator<E> extends Spliterators.AbstractSpliterator<E> {

    @SuppressWarnings("unused")
    Set_Spliterator(
        AbstractSetImpl<E> set,
        SymbolicList<E> seenKeys,
        SymbolicList<E> unseenKeys,
        int index,
        int fence,
        int expectedModCount
    ) {
        super(fence - index, 0);
        throw new LinkageError();
    }

    public Set_Spliterator(AbstractSetImpl<E> set) {
        super(0, 0);
        throw new LinkageError();
    }

    @SuppressWarnings("ProtectedMemberInFinalClass")
    protected AbstractSpliteratorImpl<E> _create(int index, int fence) {
        throw new LinkageError();
    }

    @SuppressWarnings("ProtectedMemberInFinalClass")
    protected int _parentModCount() {
        throw new LinkageError();
    }

    @SuppressWarnings("ProtectedMemberInFinalClass")
    protected int _storageSize() {
        throw new LinkageError();
    }

    public int characteristics() {
        throw new LinkageError();
    }

    public long estimateSize() {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer<? super E> userAction) {
        throw new LinkageError();
    }

    public long getExactSizeIfKnown() {
        throw new LinkageError();
    }

    public boolean tryAdvance(Consumer<? super E> userAction) {
        throw new LinkageError();
    }

    public Set_SpliteratorImpl<E> trySplit() {
        throw new LinkageError();
    }
}
