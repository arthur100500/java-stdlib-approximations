package generated.java.util.stream;

import generated.runtime.LibSLGlobals;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import stub.java.util.stream.BaseStreamStub;

@Approximate(BaseStreamStub.class)
public abstract class BaseStreamImpl<E> {

    private SymbolicList<Runnable> closeHandlers;

    public boolean isParallel;

    public boolean linkedOrConsumed;

    public int spliteratorCharacteristics =
        LibSLGlobals.SPLITERATOR_ORDERED
            | LibSLGlobals.SPLITERATOR_IMMUTABLE
            | LibSLGlobals.SPLITERATOR_SIZED
            | LibSLGlobals.SPLITERATOR_SUBSIZED;

    public BaseStreamImpl(
        SymbolicList<Runnable> closeHandlers,
        boolean isParallel,
        boolean linkedOrConsumed
    ) {
        this.closeHandlers = closeHandlers;
        this.isParallel = isParallel;
        this.linkedOrConsumed = linkedOrConsumed;
    }

    protected SymbolicList<Runnable> _getCloseHandlers() {
        SymbolicList<Runnable> closeHandlers = this.closeHandlers;
        Engine.assume(closeHandlers != null);
        return closeHandlers;
    }

    protected <T> StreamStubImpl<T> _copyToObjStream(T[] storage) {
        return new StreamStubImpl<>(storage, _getCloseHandlers(), isParallel, linkedOrConsumed);
    }

    protected IntStreamImpl _copyToIntStream(int[] storage) {
        return new IntStreamImpl(storage, _getCloseHandlers(), isParallel, linkedOrConsumed);
    }

    protected LongStreamImpl _copyToLongStream(long[] storage) {
        return new LongStreamImpl(storage, _getCloseHandlers(), isParallel, linkedOrConsumed);
    }

    protected DoubleStreamImpl _copyToDoubleStream(double[] storage) {
        return new DoubleStreamImpl(storage, _getCloseHandlers(), isParallel, linkedOrConsumed);
    }

    public void evaluate() {
        if (this.linkedOrConsumed)
            throw new IllegalStateException();

        this.linkedOrConsumed = true;
    }

    public boolean isParallel() {
        return this.isParallel;
    }

    @NotNull
    public BaseStreamImpl<E> sequential() {
        this.isParallel = false;
        return this;
    }

    @NotNull
    public BaseStreamImpl<E> parallel() {
        this.isParallel = true;
        return this;
    }

    abstract protected int _getLength();

    public long count() {
        evaluate();
        return _getLength();
    }

    @NotNull
    public BaseStreamImpl<E> onClose(@NotNull Runnable closeHandler) {
        if (this.linkedOrConsumed)
            throw new IllegalStateException();

        int listLength = this.closeHandlers.size();
        this.closeHandlers.insert(listLength, closeHandler);
        return this;
    }

    public void close() {
        int listLength = this.closeHandlers.size();
        for (int i = 0; i < listLength; i++) {
            Runnable currentHandler = this.closeHandlers.get(i);
            currentHandler.run();
        }
        this.closeHandlers = Engine.makeSymbolicList();
        this.linkedOrConsumed = true;
    }
}
