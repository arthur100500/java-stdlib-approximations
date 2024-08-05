package stub.java.util.map;

import generated.java.util.map.Map_ContentsSetImpl;
import runtime.LibSLRuntime;
import stub.java.util.AbstractIterator;

import java.util.Map;
import java.util.function.Consumer;

public class Map_Contents_Iterator<K, V, Content> extends AbstractIterator<Content> {

    @SuppressWarnings("unused")
    public Map_Contents_Iterator(
        Map_ContentsSetImpl<K, V, Content> parent,
        LibSLRuntime.Map<K, Map.Entry<K, V>> unseen,
        int expectedModCount
    ) {
        super(expectedModCount);
        throw new LinkageError();
    }

    protected int _parentModCount() {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer<? super Content> userAction) {
        throw new LinkageError();
    }

    public boolean hasNext() {
        throw new LinkageError();
    }

    public Content next() {
        throw new LinkageError();
    }

    public void remove() {
        throw new LinkageError();
    }
}
