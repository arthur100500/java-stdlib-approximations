package stub.java.util.stream;

import org.jetbrains.annotations.NotNull;
import org.usvm.api.SymbolicList;

@SuppressWarnings("unused")
public abstract class BaseStreamStub<E> {

    public BaseStreamStub(
        SymbolicList<Runnable> closeHandlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        throw new LinkageError();
    }

    protected SymbolicList<Runnable> _getCloseHandlers() {
        throw new LinkageError();
    }

    protected <T> StreamStub<T> _copyToObjStream(T[] storage) {
        throw new LinkageError();
    }

    protected IntStreamStub _copyToIntStream(int[] storage) {
        throw new LinkageError();
    }

    protected LongStreamStub _copyToLongStream(long[] storage) {
        throw new LinkageError();
    }

    protected DoubleStreamStub _copyToDoubleStream(double[] storage) {
        throw new LinkageError();
    }

    public void evaluate() {
        throw new LinkageError();
    }

    public boolean isParallel() {
        throw new LinkageError();
    }

    @NotNull
    public BaseStreamStub<E> sequential() {
        throw new LinkageError();
    }

    @NotNull
    public BaseStreamStub<E> parallel() {
        throw new LinkageError();
    }

    abstract protected int _getLength();

    public long count() {
        throw new LinkageError();
    }

    @NotNull
    public BaseStreamStub<E> onClose(@NotNull Runnable closeHandler) {
        throw new LinkageError();
    }

    public void close() {
        throw new LinkageError();
    }
}
