package stub.java.util.map;

import generated.java.util.map.Map_ContentsSetImpl;
import org.usvm.api.SymbolicList;

import java.util.function.Consumer;

@SuppressWarnings("unused")
public class Map_ContentsSet_Spliterator<K, V, Content> extends Map_Contents_Spliterator<K, V, Content> {

    private Map_ContentsSet_Spliterator(
        Map_ContentsSetImpl<K, V, Content> set,
        SymbolicList<K> seenKeys,
        SymbolicList<K> unseenKeys,
        int index,
        int fence,
        int expectedModCount
    ) {
        super(set, seenKeys, unseenKeys, index, fence, expectedModCount);
        throw new LinkageError();
    }

    public Map_ContentsSet_Spliterator(Map_ContentsSetImpl<K, V, Content> set) {
        super(set);
        throw new LinkageError();
    }

    Map_ContentsSet_Spliterator<K, V, Content> _createSpliterator(
        SymbolicList<K> seenKeys,
        SymbolicList<K> unseenKeys,
        int index,
        int fence,
        int expectedModCount
    ) {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    protected int _defaultCharacteristics() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public int characteristics() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public long estimateSize() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public void forEachRemaining(Consumer<? super Content> userAction) {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public long getExactSizeIfKnown() {
        throw new LinkageError();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public boolean tryAdvance(Consumer<? super Content> userAction) {
        throw new LinkageError();
    }

    public Map_ContentsSet_Spliterator<K, V, Content> trySplit() {
        throw new LinkageError();
    }
}
