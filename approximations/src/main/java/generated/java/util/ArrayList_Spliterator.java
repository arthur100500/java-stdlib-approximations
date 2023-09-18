// Generated by the LibSL translator.  DO NOT EDIT!
// source: ?
//
package generated.java.util;

import generated.runtime.LibSLGlobals;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;

import java.util.ConcurrentModificationException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * ArrayList_SpliteratorAutomaton for ArrayList_Spliterator ~> java.util.ArrayList_Spliterator
 */
@Approximate(stub.java.util.ArrayList_Spliterator.class)
public final class ArrayList_Spliterator implements LibSLRuntime.Automaton, Spliterator {
    static {
    }

    private byte __$lsl_state = __$lsl_States.Allocated;

    public ArrayList parent;

    public int index = 0;

    public int fence = -1;

    public int expectedModCount = 0;

    @LibSLRuntime.AutomatonConstructor
    public ArrayList_Spliterator(Void __$lsl_token, final byte p0, final ArrayList p1, final int p2,
            final int p3, final int p4) {
        this.__$lsl_state = p0;
        this.parent = p1;
        this.index = p2;
        this.fence = p3;
        this.expectedModCount = p4;
    }

    @LibSLRuntime.AutomatonConstructor
    public ArrayList_Spliterator(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Allocated, null, 0, -1, 0);
    }

    /**
     * [CONSTRUCTOR] ArrayList_SpliteratorAutomaton::ArrayList_Spliterator(ArrayList_Spliterator, ArrayList, int, int, int) -> ArrayList_Spliterator
     */
    private ArrayList_Spliterator(ArrayList _this, int origin, int fence, int expectedModCount) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            LibSLRuntime.not_implemented(/* inaccessible constructor */);
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [SUBROUTINE] ArrayList_SpliteratorAutomaton::_getFence() -> int
     */
    private int _getFence() {
        int result = 0;
        /* body */ {
            if (fence < 0) {
                Engine.assume(parent != null);
                expectedModCount = ((ArrayList) parent).modCount;
                fence = ((ArrayList) parent).length;
            }
            result = fence;
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayList_SpliteratorAutomaton::characteristics(ArrayList_Spliterator) -> int
     */
    public int characteristics() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = LibSLGlobals.SPLITERATOR_ORDERED | LibSLGlobals.SPLITERATOR_SIZED | LibSLGlobals.SPLITERATOR_SUBSIZED;
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayList_SpliteratorAutomaton::estimateSize(ArrayList_Spliterator) -> long
     */
    public long estimateSize() {
        long result = 0L;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _getFence() - index;
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayList_SpliteratorAutomaton::forEachRemaining(ArrayList_Spliterator, Consumer) -> void
     */
    public void forEachRemaining(Consumer _action) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (_action == null) {
                throw new NullPointerException();
            }
            Engine.assume(parent != null);
            final SymbolicList<Object> a = ((ArrayList) parent).storage;
            if (a == null) {
                throw new ConcurrentModificationException();
            }
            int hi = fence;
            int mc = expectedModCount;
            if (hi < 0) {
                hi = ((ArrayList) parent).length;
                mc = ((ArrayList) parent).modCount;
            }
            int i = index;
            index = hi;
            if ((i < 0) || (hi > ((ArrayList) parent).length)) {
                throw new ConcurrentModificationException();
            }
            for (i = i; i < hi; i += 1) {
                final Object item = a.get(i);
                _action.accept(item);
            }
            ;
            if (mc != ((ArrayList) parent).modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * [FUNCTION] ArrayList_SpliteratorAutomaton::getExactSizeIfKnown(ArrayList_Spliterator) -> long
     */
    public long getExactSizeIfKnown() {
        long result = 0L;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _getFence() - index;
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayList_SpliteratorAutomaton::tryAdvance(ArrayList_Spliterator, Consumer) -> boolean
     */
    public boolean tryAdvance(Consumer _action) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (_action == null) {
                throw new NullPointerException();
            }
            final int hi = _getFence();
            final int i = index;
            if (i < hi) {
                Engine.assume(parent != null);
                index = i + 1;
                final SymbolicList<Object> parentStorage = ((ArrayList) parent).storage;
                final Object item = parentStorage.get(i);
                _action.accept(item);
                if (((ArrayList) parent).modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayList_SpliteratorAutomaton::trySplit(ArrayList_Spliterator) -> ArrayList_Spliterator
     */
    public ArrayList_Spliterator trySplit() {
        ArrayList_Spliterator result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final int hi = _getFence();
            final int lo = index;
            final int mid = (lo + hi) >>> 1;
            if (lo >= mid) {
                result = null;
            } else {
                result = new ArrayList_Spliterator((Void) null, __$lsl_States.Initialized, parent, lo, mid, expectedModCount);
            }
            index = mid;
        }
        return result;
    }

    public static final class __$lsl_States {
        public static final byte Allocated = (byte) 0;

        public static final byte Initialized = (byte) 1;
    }

    @Approximate(ArrayList_Spliterator.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
