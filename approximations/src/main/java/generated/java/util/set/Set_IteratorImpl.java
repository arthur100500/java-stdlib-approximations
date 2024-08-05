package generated.java.util.set;

import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import generated.java.util.AbstractIteratorImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;
import stub.java.util.set.Set_Iterator;

@Approximate(Set_Iterator.class)
public final class Set_IteratorImpl<E> extends AbstractIteratorImpl<E> {

    public AbstractSetImpl<E> set;

    public LibSLRuntime.Map<E, Object> unseen;

    public E currentKey;

    public Set_IteratorImpl(
        int expectedModCount,
        LibSLRuntime.Map<E, Object> unseen,
        AbstractSetImpl<E> set,
        E currentKey
    ) {
        super(expectedModCount);
        this.unseen = unseen;
        this.set = set;
        this.currentKey = currentKey;
    }

    private AbstractSetImpl<E> _getSet() {
        AbstractSetImpl<E> result = this.set;
        Engine.assume(result != null);
        return result;
    }

    protected int _parentModCount() {
        return _getSet().modCount;
    }

    private boolean _isEmpty() {
        return this.unseen.size() == 0;
    }

    public void forEachRemaining(Consumer<? super E> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        int size = this.unseen.size();
        Engine.assume(size >= 0);
        while (size > 0) {
            _checkForModification();
            E curKey = this.unseen.anyKey();
            userAction.accept(curKey);
            this.unseen.remove(curKey);
            size--;
        }
    }

    public boolean hasNext() {
        return !_isEmpty();
    }

    public E next() {
        _checkForModification();
        if (_isEmpty())
            throw new NoSuchElementException();

        E curKey = this.unseen.anyKey();
        this.unseen.remove(curKey);
        this.currentKey = curKey;
        return curKey;
    }

    public void remove() {
        E key = this.currentKey;
        if (key == null)
            throw new IllegalStateException();

        _checkForModification();
        AbstractSetImpl<E> set = _getSet();
        set._getStorage().remove(key);
        set.modCount++;
        this.unseen.remove(key);
        this.expectedModCount = set.modCount;
        this.currentKey = null;
    }
}
