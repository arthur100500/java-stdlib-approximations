package generated.org.springframework.boot;

import jakarta.servlet.Filter;
import org.jacodb.approximation.annotation.Approximate;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@Approximate(org.springframework.boot.SpringApplication.class)
public class SpringApplicationImpl {

    private List<ApplicationListener<?>> listeners;

    private ApplicationContextFactory applicationContextFactory = ApplicationContextFactory.DEFAULT;

    private boolean registerShutdownHook = true;

    private Map<String, Map<String, List<Object>>> allControllerPaths() {
        return new HashMap<>();
    }

    protected void afterRefresh(ConfigurableApplicationContext context, ApplicationArguments args) {
        startAnalysis();
        Object[] beans = context.getBeansOfType(Filter.class).values().toArray();
        Filter[] filters = Arrays.copyOf(beans, beans.length, Filter[].class);
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup((WebApplicationContext) context);
        for (Filter filter : filters) {
            builder.addFilter(filter);
        }
        MockMvc mockMvc = builder.build();
        Map<String, Map<String, List<Object>>> allPaths = allControllerPaths();
        try {
            for (String controllerName : allPaths.keySet()) {
                Map<String, List<Object>> paths = allPaths.get(controllerName);
                for (String path : paths.keySet()) {
                    List<Object> properties = paths.get(path);
                    String kind = (String) properties.get(0);
                    Integer paramCount = (Integer) properties.get(1);
                    Object[] pathArgs = new Object[paramCount];
                    if (kind.equals("get"))
                        mockMvc.perform(get(path, pathArgs));
                    if (kind.equals("post"))
                        mockMvc.perform(post(path, pathArgs));
                    if (kind.equals("put"))
                        mockMvc.perform(put(path, pathArgs));
                    if (kind.equals("delete"))
                        mockMvc.perform(delete(path, pathArgs));
                    if (kind.equals("patch"))
                        mockMvc.perform(patch(path, pathArgs));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void startAnalysis() { }

    public void setListeners(Collection<? extends ApplicationListener<?>> listeners) {
        registerShutdownHook = false;
        listeners.removeIf(it -> it instanceof LoggingApplicationListener);
        this.listeners = new ArrayList<>(listeners);
    }
}
