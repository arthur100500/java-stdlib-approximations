package generated.runtime;

import java.lang.Object;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

@Approximate(runtime.LibSLGlobals.class)
public final class LibSLGlobals {

    public static final boolean CONSOLE_IS_TTY;

    public static final int MAX_CODE_POINT;

    public static final int MIN_CODE_POINT;

    public static final int MIN_HIGH_SURROGATE;

    public static final int MIN_LOW_SURROGATE;

    public static final int MIN_SUPPLEMENTARY_CODE_POINT;

    public static final int RANDOM_STREAM_SIZE_MAX;

    public static final Object SOMETHING;

    public static final int SPLITERATOR_CONCURRENT;

    public static final int SPLITERATOR_DISTINCT;

    public static final int SPLITERATOR_IMMUTABLE;

    public static final int SPLITERATOR_NONNULL;

    public static final int SPLITERATOR_ORDERED;

    public static final int SPLITERATOR_SIZED;

    public static final int SPLITERATOR_SORTED;

    public static final int SPLITERATOR_SUBSIZED;

    public static final boolean SYSTEM_IS_MAC;

    public static final boolean SYSTEM_IS_WINDOWS;

    public static final int VM_JAVA_LANG_SYSTEM_INITED;

    public static final int VM_MODULE_SYSTEM_INITED;

    public static final int VM_SYSTEM_BOOTED;

    public static final int VM_SYSTEM_LOADER_INITIALIZING;

    public static final int VM_SYSTEM_SHUTDOWN;

    static {
        CONSOLE_IS_TTY = Engine.makeSymbolicBoolean();
        MAX_CODE_POINT = 1114111;
        MIN_CODE_POINT = 0;
        MIN_HIGH_SURROGATE = 55296;
        MIN_LOW_SURROGATE = 56320;
        MIN_SUPPLEMENTARY_CODE_POINT = 65536;
        RANDOM_STREAM_SIZE_MAX = 100;
        SOMETHING = new java.lang.Object();
        SPLITERATOR_CONCURRENT = 4096;
        SPLITERATOR_DISTINCT = 1;
        SPLITERATOR_IMMUTABLE = 1024;
        SPLITERATOR_NONNULL = 256;
        SPLITERATOR_ORDERED = 16;
        SPLITERATOR_SIZED = 64;
        SPLITERATOR_SORTED = 4;
        SPLITERATOR_SUBSIZED = 16384;
        SYSTEM_IS_MAC = Engine.makeSymbolicBoolean();
        //noinspection ConstantValue
        SYSTEM_IS_WINDOWS = !LibSLGlobals.SYSTEM_IS_MAC && Engine.makeSymbolicBoolean();
        VM_JAVA_LANG_SYSTEM_INITED = 1;
        VM_MODULE_SYSTEM_INITED = 2;
        VM_SYSTEM_BOOTED = 4;
        VM_SYSTEM_LOADER_INITIALIZING = 3;
        VM_SYSTEM_SHUTDOWN = 5;
    }
}
