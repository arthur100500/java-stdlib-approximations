package stub.java.util.map;

import generated.java.util.map.Map_ContentsImpl;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;

import java.util.Spliterators;
import java.util.function.Consumer;

public class Map_Contents_Spliterator<K, V, Content> extends Spliterators.AbstractSpliterator<Content> {

    @SuppressWarnings("unused")
    Map_Contents_Spliterator(
        Map_ContentsImpl<K, V, Content> contents,
        SymbolicList<K> seenKeys,
        SymbolicList<K> unseenKeys,
        int index,
        int fence,
        int expectedModCount
    ) {
        super(fence - index, expectedModCount);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    public Map_Contents_Spliterator(Map_ContentsImpl<K, V, Content> contents) {
        this(contents, Engine.makeSymbolicList(), null, 0, -1, 0);
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    protected Spliterators.AbstractSpliterator<Content> _create(int index, int fence) {
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    Map_Contents_Spliterator<K, V, Content> _createSpliterator(
        SymbolicList<K> seenKeys,
        SymbolicList<K> unseenKeys,
        int index,
        int fence,
        int expectedModCount
    ) {
        throw new LinkageError();
    }

    protected int _parentModCount() {
        throw new LinkageError();
    }

    protected int _storageSize() {
        throw new LinkageError();
    }

    @SuppressWarnings("unused")
    protected int _defaultCharacteristics() {
        throw new LinkageError();
    }

    public int characteristics() {
        throw new LinkageError();
    }

    public long estimateSize() {
        throw new LinkageError();
    }

    public void forEachRemaining(Consumer<? super Content> userAction) {
        throw new LinkageError();
    }

    public long getExactSizeIfKnown() {
        throw new LinkageError();
    }

    public boolean tryAdvance(Consumer<? super Content> userAction) {
        throw new LinkageError();
    }

    public Map_Contents_Spliterator<K, V, Content> trySplit() {
        throw new LinkageError();
    }
}
