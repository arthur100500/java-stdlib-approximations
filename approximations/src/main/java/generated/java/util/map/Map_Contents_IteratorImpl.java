package generated.java.util.map;

import generated.java.util.AbstractIteratorImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;
import stub.java.util.map.Map_Contents_Iterator;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

@Approximate(Map_Contents_Iterator.class)
public class Map_Contents_IteratorImpl<K, V, Content> extends AbstractIteratorImpl<Content> {

    public Map_ContentsImpl<K, V, Content> contents;

    public LibSLRuntime.Map<K, Map.Entry<K, V>> unseen;

    public K currentKey;

    public Map_Contents_IteratorImpl(
        Map_ContentsImpl<K, V, Content> contents,
        LibSLRuntime.Map<K, Map.Entry<K, V>> unseen,
        int expectedModCount
    ) {
        super(expectedModCount);
        this.contents = contents;
        this.unseen = unseen;
        this.currentKey = null;
    }

    private Map_ContentsImpl<K, V, Content> _getContents() {
        Map_ContentsImpl<K, V, Content> result = this.contents;
        Engine.assume(result != null);
        return result;
    }

    private AbstractMapImpl<K, V> _getMap() {
        AbstractMapImpl<K, V> result = _getContents().map;
        Engine.assume(result != null);
        return result;
    }

    protected int _parentModCount() {
        return _getMap().modCount;
    }

    private boolean _isEmpty() {
        return this.unseen.size() == 0;
    }

    public void forEachRemaining(Consumer<? super Content> userAction) {
        if (userAction == null)
            throw new NullPointerException();

        int size = this.unseen.size();
        Engine.assume(size >= 0);
        Map_ContentsImpl<K, V, Content> contents = _getContents();
        while (size > 0) {
            _checkForModification();
            K curKey = this.unseen.anyKey();
            userAction.accept(contents._contentByKey(this.unseen, curKey));
            this.unseen.remove(curKey);
            size--;
        }
    }

    public boolean hasNext() {
        return !_isEmpty();
    }

    public Content next() {
        _checkForModification();
        if (_isEmpty())
            throw new NoSuchElementException();

        K curKey = this.unseen.anyKey();
        Map_ContentsImpl<K, V, Content> contents = _getContents();
        Content result = contents._contentByKey(this.unseen, curKey);
        this.unseen.remove(curKey);
        this.currentKey = curKey;
        return result;
    }

    public void remove() {
        K key = this.currentKey;
        if (key == null)
            throw new IllegalStateException();

        _checkForModification();
        AbstractMapImpl<K, V> map = _getMap();
        map._getStorage().remove(key);
        map.modCount++;
        this.unseen.remove(key);
        this.expectedModCount = map.modCount;
        this.currentKey = null;
    }
}
