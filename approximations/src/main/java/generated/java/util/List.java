// Generated by the LibSL translator.  DO NOT EDIT!
// source: ?
//
package generated.java.util;

import java.util.Collection;
import java.util.Iterator;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;

/**
 * ListAutomaton for LSLList ~> java.util.List
 */
@Approximate(java.util.List.class)
public interface List extends LibSLRuntime.Automaton, java.util.List {
    Class __$_lsl_INIT_INTERFACE_ListAutomaton_5013495c = Void.class;

    /**
     * [FUNCTION] ListAutomaton::copyOf(Collection) -> List
     */
    static java.util.List copyOf(Collection coll) {
        java.util.List result = null;
        /* body */ {
            final SymbolicList<Object> data = Engine.makeSymbolicList();
            int size = 0;
            final Iterator iter = coll.iterator();
            while (iter.hasNext()) {
                final Object item = iter.next();
                data.insert(size, item);
                size += 1;
            }
            ;
            result = new ArrayList((Void) null, 
            /* state = */ ArrayList.__$lsl_States.Initialized, 
            /* storage = */ data, 
            /* length = */ size, 
            /* modCount = */ 0);
        }
        return result;
    }

    /**
     * [FUNCTION] ListAutomaton::of() -> List
     */
    static java.util.List of() {
        java.util.List result = null;
        /* body */ {
            result = new ArrayList((Void) null, 
            /* state = */ ArrayList.__$lsl_States.Initialized, 
            /* storage = */ Engine.makeSymbolicList(), 
            /* length = */ 0, 
            /* modCount = */ 0);
        }
        return result;
    }

    /**
     * [FUNCTION] ListAutomaton::of(Object) -> List
     */
    static java.util.List of(Object e1) {
        java.util.List result = null;
        /* body */ {
            final SymbolicList<Object> data = Engine.makeSymbolicList();
            data.insert(0, e1);
            result = new ArrayList((Void) null, 
            /* state = */ ArrayList.__$lsl_States.Initialized, 
            /* storage = */ data, 
            /* length = */ 1, 
            /* modCount = */ 0);
        }
        return result;
    }

    /**
     * [FUNCTION] ListAutomaton::of(Object, Object) -> List
     */
    static java.util.List of(Object e1, Object e2) {
        java.util.List result = null;
        /* body */ {
            final SymbolicList<Object> data = Engine.makeSymbolicList();
            data.insert(0, e1);
            data.insert(1, e2);
            result = new ArrayList((Void) null, 
            /* state = */ ArrayList.__$lsl_States.Initialized, 
            /* storage = */ data, 
            /* length = */ 2, 
            /* modCount = */ 0);
        }
        return result;
    }

    /**
     * [FUNCTION] ListAutomaton::of(Object, Object, Object) -> List
     */
    static java.util.List of(Object e1, Object e2, Object e3) {
        java.util.List result = null;
        /* body */ {
            final SymbolicList<Object> data = Engine.makeSymbolicList();
            data.insert(0, e1);
            data.insert(1, e2);
            data.insert(2, e3);
            result = new ArrayList((Void) null, 
            /* state = */ ArrayList.__$lsl_States.Initialized, 
            /* storage = */ data, 
            /* length = */ 3, 
            /* modCount = */ 0);
        }
        return result;
    }

    /**
     * [FUNCTION] ListAutomaton::of(Object, Object, Object, Object) -> List
     */
    static java.util.List of(Object e1, Object e2, Object e3, Object e4) {
        java.util.List result = null;
        /* body */ {
            final SymbolicList<Object> data = Engine.makeSymbolicList();
            data.insert(0, e1);
            data.insert(1, e2);
            data.insert(2, e3);
            data.insert(3, e4);
            result = new ArrayList((Void) null, 
            /* state = */ ArrayList.__$lsl_States.Initialized, 
            /* storage = */ data, 
            /* length = */ 4, 
            /* modCount = */ 0);
        }
        return result;
    }

    /**
     * [FUNCTION] ListAutomaton::of(Object, Object, Object, Object, Object) -> List
     */
    static java.util.List of(Object e1, Object e2, Object e3, Object e4, Object e5) {
        java.util.List result = null;
        /* body */ {
            final SymbolicList<Object> data = Engine.makeSymbolicList();
            data.insert(0, e1);
            data.insert(1, e2);
            data.insert(2, e3);
            data.insert(3, e4);
            data.insert(4, e5);
            result = new ArrayList((Void) null, 
            /* state = */ ArrayList.__$lsl_States.Initialized, 
            /* storage = */ data, 
            /* length = */ 5, 
            /* modCount = */ 0);
        }
        return result;
    }

    /**
     * [FUNCTION] ListAutomaton::of(Object, Object, Object, Object, Object, Object) -> List
     */
    static java.util.List of(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6) {
        java.util.List result = null;
        /* body */ {
            final SymbolicList<Object> data = Engine.makeSymbolicList();
            data.insert(0, e1);
            data.insert(1, e2);
            data.insert(2, e3);
            data.insert(3, e4);
            data.insert(4, e5);
            data.insert(5, e6);
            result = new ArrayList((Void) null, 
            /* state = */ ArrayList.__$lsl_States.Initialized, 
            /* storage = */ data, 
            /* length = */ 6, 
            /* modCount = */ 0);
        }
        return result;
    }

    /**
     * [FUNCTION] ListAutomaton::of(Object, Object, Object, Object, Object, Object, Object) -> List
     */
    static java.util.List of(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6,
            Object e7) {
        java.util.List result = null;
        /* body */ {
            final SymbolicList<Object> data = Engine.makeSymbolicList();
            data.insert(0, e1);
            data.insert(1, e2);
            data.insert(2, e3);
            data.insert(3, e4);
            data.insert(4, e5);
            data.insert(5, e6);
            data.insert(6, e7);
            result = new ArrayList((Void) null, 
            /* state = */ ArrayList.__$lsl_States.Initialized, 
            /* storage = */ data, 
            /* length = */ 7, 
            /* modCount = */ 0);
        }
        return result;
    }

    /**
     * [FUNCTION] ListAutomaton::of(Object, Object, Object, Object, Object, Object, Object, Object) -> List
     */
    static java.util.List of(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6,
            Object e7, Object e8) {
        java.util.List result = null;
        /* body */ {
            final SymbolicList<Object> data = Engine.makeSymbolicList();
            data.insert(0, e1);
            data.insert(1, e2);
            data.insert(2, e3);
            data.insert(3, e4);
            data.insert(4, e5);
            data.insert(5, e6);
            data.insert(6, e7);
            data.insert(7, e8);
            result = new ArrayList((Void) null, 
            /* state = */ ArrayList.__$lsl_States.Initialized, 
            /* storage = */ data, 
            /* length = */ 8, 
            /* modCount = */ 0);
        }
        return result;
    }

    /**
     * [FUNCTION] ListAutomaton::of(Object, Object, Object, Object, Object, Object, Object, Object, Object) -> List
     */
    static java.util.List of(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6,
            Object e7, Object e8, Object e9) {
        java.util.List result = null;
        /* body */ {
            final SymbolicList<Object> data = Engine.makeSymbolicList();
            data.insert(0, e1);
            data.insert(1, e2);
            data.insert(2, e3);
            data.insert(3, e4);
            data.insert(4, e5);
            data.insert(5, e6);
            data.insert(6, e7);
            data.insert(7, e8);
            data.insert(8, e9);
            result = new ArrayList((Void) null, 
            /* state = */ ArrayList.__$lsl_States.Initialized, 
            /* storage = */ data, 
            /* length = */ 9, 
            /* modCount = */ 0);
        }
        return result;
    }

    /**
     * [FUNCTION] ListAutomaton::of(Object, Object, Object, Object, Object, Object, Object, Object, Object, Object) -> List
     */
    static java.util.List of(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6,
            Object e7, Object e8, Object e9, Object e10) {
        java.util.List result = null;
        /* body */ {
            final SymbolicList<Object> data = Engine.makeSymbolicList();
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
            result = new ArrayList((Void) null, 
            /* state = */ ArrayList.__$lsl_States.Initialized, 
            /* storage = */ data, 
            /* length = */ 10, 
            /* modCount = */ 0);
        }
        return result;
    }

    /**
     * [FUNCTION] ListAutomaton::of(array<Object>) -> List
     */
    static java.util.List of(Object[] elements) {
        java.util.List result = null;
        /* body */ {
            final SymbolicList<Object> data = Engine.makeSymbolicList();
            final int size = elements.length;
            Engine.assume(size >= 0);
            if (size != 0) {
                int i = 0;
                for (i = 0; i < size; i += 1) {
                    data.insert(i, elements[i]);
                }
                ;
            }
            result = new ArrayList((Void) null, 
            /* state = */ ArrayList.__$lsl_States.Initialized, 
            /* storage = */ data, 
            /* length = */ size, 
            /* modCount = */ 0);
        }
        return result;
    }

    final class __$lsl_States {
        public static final byte Initialized = (byte) 0;
    }

    @Approximate(List.class)
    final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}