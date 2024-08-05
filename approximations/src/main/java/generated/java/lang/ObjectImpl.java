package generated.java.lang;

import java.lang.String;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

@SuppressWarnings("unused")
@Approximate(java.lang.Object.class)
public class ObjectImpl {

    static {
        Engine.assume(true);
    }

    // Do not delete this constructor!
    public ObjectImpl(Void dummy) {}

    public boolean equals(ObjectImpl obj) {
        return this == obj;
    }

    public int hashCode() {
        return Engine.makeSymbolicInt();
    }

    public String toString() {
        return "java.lang.Object@735b5592";
    }
}
