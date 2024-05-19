package generated.org.springframework.boot;

import org.springframework.test.context.TestContextManager;

public class StartSpring {

    public static void startSpring() {
        TestContextManager b = new TestContextManager(TestClass.class);
        b.getTestContext().getApplicationContext();
    }
}
