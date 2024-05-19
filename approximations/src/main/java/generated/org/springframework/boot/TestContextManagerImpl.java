package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestContextBootstrapper;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.TestExecutionListener;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Approximate(TestContextManager.class)
public class TestContextManagerImpl {

    private final TestContext testContext;

    private final List<TestExecutionListener> testExecutionListeners = new ArrayList<>(8);

    private static TestContext copyTestContext(TestContext testContext) {
        Constructor<? extends TestContext> constructor =
                ClassUtils.getConstructorIfAvailable(testContext.getClass(), testContext.getClass());

        if (constructor != null) {
            try {
                ReflectionUtils.makeAccessible(constructor);
                return constructor.newInstance(testContext);
            }
            catch (Exception ignored) {
            }
        }

        // Fallback to original instance
        return testContext;
    }

    public TestContextManagerImpl(TestContextBootstrapper testContextBootstrapper) {
        this.testContext = testContextBootstrapper.buildTestContext();
        registerTestExecutionListeners(testContextBootstrapper.getTestExecutionListeners());
    }

    public final TestContext getTestContext() {
        return this.testContext;
    }

    public void registerTestExecutionListeners(List<TestExecutionListener> testExecutionListeners) {
        registerTestExecutionListeners(testExecutionListeners.toArray(new TestExecutionListener[0]));
    }

    public void registerTestExecutionListeners(TestExecutionListener... testExecutionListeners) {
        Collections.addAll(this.testExecutionListeners, testExecutionListeners);
    }

}
