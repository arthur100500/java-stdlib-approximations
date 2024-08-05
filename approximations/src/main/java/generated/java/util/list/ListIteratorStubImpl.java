package generated.java.util.list;

import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import generated.java.util.AbstractIteratorImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import stub.java.util.list.ListIteratorStub;

@Approximate(ListIteratorStub.class)
public class ListIteratorStubImpl<E> extends AbstractIteratorImpl<E> implements ListIterator<E> {

    public AbstractListImpl<E> list;

    public int cursor;

    public int lastRet;

    public ListIteratorStubImpl(AbstractListImpl<E> list, int index, int expectedModCount) {
        super(expectedModCount);
        Engine.assume(list != null);
        this.list = list;
        Engine.assume(index >= 0);
        this.cursor = index;
        this.lastRet = -1;
    }

    public ListIteratorStubImpl(AbstractListImpl<E> list, int index) {
        this(list, index, list.modCount);
    }

    public ListIteratorStubImpl(AbstractListImpl<E> list) {
        this(list, 0);
    }

    protected AbstractListImpl<E> _getList() {
        AbstractListImpl<E> result = this.list;
        Engine.assume(result != null);
        return result;
    }

    protected int _parentModCount() {
        return _getList().modCount;
    }

    protected int _getSize(SymbolicList<E> storage) {
        return storage.size();
    }

    public boolean hasPrevious() {
        return this.cursor > 0;
    }

    public int nextIndex() {
        return this.cursor;
    }

    public int previousIndex() {
        return this.cursor - 1;
    }

    protected boolean _hasNext(int size) {
        return this.cursor < size;
    }

    public boolean hasNext() {
        return _hasNext(_getList()._getStorage().size());
    }

    public E next() {
        _checkForModification();
        if (!hasNext())
            throw new NoSuchElementException();

        int i = this.cursor;
        this.cursor = i + 1;
        this.lastRet = i;
        return _getList()._getStorage().get(i);
    }

    public E previous() {
        _checkForModification();
        if (!hasPrevious())
            throw new NoSuchElementException();

        this.cursor--;
        this.lastRet = this.cursor;
        return _getList()._getStorage().get(this.cursor);
    }

    public void remove() {
        if (this.lastRet < 0)
            throw new IllegalStateException();

        _checkForModification();
        AbstractListImpl<E> list = _getList();
        SymbolicList<E> storage = list._getStorage();
        list.modCount++;
        storage.remove(this.lastRet);
        this.cursor = this.lastRet;
        this.lastRet = -1;
        this.expectedModCount = list.modCount;
    }

    public void set(E e) {
        if (this.lastRet < 0)
            throw new IllegalStateException();

        _checkForModification();
        SymbolicList<E> storage = _getList()._getStorage();
        storage.set(this.lastRet, e);
    }

    public void add(E e) {
        _checkForModification();
        AbstractListImpl<E> list = _getList();
        SymbolicList<E> storage = list._getStorage();
        list.modCount++;
        storage.insert(this.cursor, e);
        this.cursor++;
        this.lastRet = -1;
        this.expectedModCount = list.modCount;
    }

    public void forEachRemaining(Consumer<? super E> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        _checkForModification();
        SymbolicList<E> storage = _getList()._getStorage();
        int size = _getSize(storage);
        while (this.cursor < size) {
            E item = storage.get(this.cursor);
            userAction.accept(item);
            this.lastRet = this.cursor;
            this.cursor++;
            _checkForModification();
        }
    }
}
