package generated.java.util.list;

import java.util.Collection;
import java.util.List;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;

@SuppressWarnings("unused")
@Approximate(java.util.List.class)
public interface ListImpl<E> extends Collection<E> {

    static <E> List<E> copyOf(Collection<? extends E> coll) {
        return new ArrayListImpl<>(coll);
    }

    static <E> List<E> of() {
        return new ArrayListImpl<>();
    }

    static <E> List<E> of(E element) {
        SymbolicList<E> data = Engine.makeSymbolicList();
        data.insert(0, element);
        return new ArrayListImpl<>(data, 0);
    }

    static <E> List<E> of(E element1, E element2) {
        SymbolicList<E> data = Engine.makeSymbolicList();
        data.insert(0, element1);
        data.insert(1, element2);
        return new ArrayListImpl<>(data, 0);
    }

    static <E> List<E> of(E e1, E e2, E e3) {
        SymbolicList<E> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        return new ArrayListImpl<>(data, 0);
    }

    static <E> List<E> of(E e1, E e2, E e3, E e4) {
        SymbolicList<E> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        return new ArrayListImpl<>(data, 0);
    }

    static <E> List<E> of(E e1, E e2, E e3, E e4, E e5) {
        SymbolicList<E> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        data.insert(4, e5);
        return new ArrayListImpl<>(data, 0);
    }

    static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6) {
        SymbolicList<E> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        data.insert(4, e5);
        data.insert(5, e6);
        return new ArrayListImpl<>(data, 0);
    }

    static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
        SymbolicList<E> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        data.insert(4, e5);
        data.insert(5, e6);
        data.insert(6, e7);
        return new ArrayListImpl<>(data, 0);
    }

    static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        SymbolicList<E> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        data.insert(4, e5);
        data.insert(5, e6);
        data.insert(6, e7);
        data.insert(7, e8);
        return new ArrayListImpl<>(data, 0);
    }

    static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        SymbolicList<E> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        data.insert(4, e5);
        data.insert(5, e6);
        data.insert(6, e7);
        data.insert(7, e8);
        data.insert(8, e9);
        return new ArrayListImpl<>(data, 0);
    }

    static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        SymbolicList<E> data = Engine.makeSymbolicList();
        data.insert(0, e1);
        data.insert(1, e2);
        data.insert(2, e3);
        data.insert(3, e4);
        data.insert(4, e5);
        data.insert(5, e6);
        data.insert(6, e7);
        data.insert(7, e8);
        data.insert(8, e9);
        data.insert(9, e10);
        return new ArrayListImpl<>(data, 0);
    }

    @SuppressWarnings("ConstantValue")
    static <E> List<E> of(E[] elements) {
        SymbolicList<E> data = Engine.makeSymbolicList();
        int size = elements.length;
        Engine.assume(size >= 0);
        for (int i = 0; i < size; i++) {
            data.insert(i, elements[i]);
        }
        return new ArrayListImpl<>(data, 0);
    }
}
