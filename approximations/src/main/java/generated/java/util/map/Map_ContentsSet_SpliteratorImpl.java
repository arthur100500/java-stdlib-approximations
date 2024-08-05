package generated.java.util.map;

import generated.runtime.LibSLGlobals;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.SymbolicList;
import stub.java.util.map.Map_ContentsSet_Spliterator;

import java.util.function.Consumer;

@Approximate(Map_ContentsSet_Spliterator.class)
public class Map_ContentsSet_SpliteratorImpl<K, V, Content> extends Map_Contents_SpliteratorImpl<K, V, Content> {

    Map_ContentsSet_SpliteratorImpl(
        Map_ContentsSetImpl<K, V, Content> set,
        SymbolicList<K> seenKeys,
        SymbolicList<K> unseenKeys,
        int index,
        int fence,
        int expectedModCount
    ) {
        super(set, seenKeys, unseenKeys, index, fence, expectedModCount);
    }

    public Map_ContentsSet_SpliteratorImpl(Map_ContentsSetImpl<K, V, Content> set) {
        super(set);
    }

    Map_ContentsSet_SpliteratorImpl<K, V, Content> _createSpliterator(
        SymbolicList<K> seenKeys,
        SymbolicList<K> unseenKeys,
        int index,
        int fence,
        int expectedModCount
    ) {
        Map_ContentsSetImpl<K, V, Content> typedContents = (Map_ContentsSetImpl<K, V, Content>) this.contents;
        return new Map_ContentsSet_SpliteratorImpl<>(typedContents, seenKeys, unseenKeys, index, fence, expectedModCount);
    }

    protected int _defaultCharacteristics() {
        return LibSLGlobals.SPLITERATOR_DISTINCT;
    }

    public int characteristics() {
        return super.characteristics();
    }

    public long estimateSize() {
        return super.estimateSize();
    }

    public void forEachRemaining(Consumer<? super Content> userAction) {
        super.forEachRemaining(userAction);
    }

    public long getExactSizeIfKnown() {
        return super.getExactSizeIfKnown();
    }

    public boolean tryAdvance(Consumer<? super Content> userAction) {
        return super.tryAdvance(userAction);
    }

    public Map_ContentsSet_SpliteratorImpl<K, V, Content> trySplit() {
        return (Map_ContentsSet_SpliteratorImpl<K, V, Content>) super.trySplit();
    }
}
