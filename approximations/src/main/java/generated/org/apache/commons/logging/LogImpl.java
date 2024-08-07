package generated.org.apache.commons.logging;

import org.jacodb.approximation.annotation.Approximate;

@SuppressWarnings("unused")
@Approximate(org.apache.commons.logging.Log.class)
public interface LogImpl {

    default boolean isFatalEnabled() {
        return false;
    }

    default boolean isErrorEnabled() {
        return false;
    }

    default boolean isWarnEnabled() {
        return false;
    }

    default boolean isInfoEnabled() {
        return false;
    }

    default boolean isDebugEnabled() {
        return false;
    }

    default boolean isTraceEnabled() {
        return false;
    }

    default void fatal(Object message) { }

    default void fatal(Object message, Throwable t) { }

    default void error(Object message) { }

    default void error(Object message, Throwable t) { }

    default void warn(Object message) { }

    default void warn(Object message, Throwable t) { }

    default void info(Object message) { }

    default void info(Object message, Throwable t) { }

    default void debug(Object message) { }

    default void debug(Object message, Throwable t) { }

    default void trace(Object message) { }

    default void trace(Object message, Throwable t) { }
}
