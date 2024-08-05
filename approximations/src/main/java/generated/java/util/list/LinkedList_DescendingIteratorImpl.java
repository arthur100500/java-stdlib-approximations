package generated.java.util.list;

import java.lang.NullPointerException;
import java.util.function.Consumer;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.SymbolicList;
import stub.java.util.list.LinkedList_DescendingIterator;

@Approximate(LinkedList_DescendingIterator.class)
public final class LinkedList_DescendingIteratorImpl<E> extends ListIteratorStubImpl<E> {

    public LinkedList_DescendingIteratorImpl(LinkedListImpl<E> list) {
        super(list, list._getStorage().size());
    }

    @SuppressWarnings("unused")
    private boolean _isEmpty() {
        return !super.hasPrevious();
    }

    public boolean hasNext() {
        return super.hasPrevious();
    }

    public E next() {
        return super.previous();
    }

    public void remove() {
        super.remove();
    }

    public void forEachRemaining(Consumer<? super E> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        _checkForModification();
        int i = this.cursor;
        SymbolicList<E> storage = _getList()._getStorage();
        while (i >= 0) {
            E item = storage.get(i);
            userAction.accept(item);
            i--;
            _checkForModification();
        }
        this.cursor = i;
        this.lastRet = i + 1;
    }
}
