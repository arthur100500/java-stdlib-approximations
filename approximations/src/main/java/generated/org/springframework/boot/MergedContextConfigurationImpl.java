package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.lang.Nullable;
import org.springframework.test.context.ContextCustomizer;
import org.springframework.test.context.MergedContextConfiguration;

import java.util.Collections;
import java.util.Set;

@Approximate(MergedContextConfiguration.class)
public class MergedContextConfigurationImpl {

    private static final Set<ContextCustomizer> EMPTY_CONTEXT_CUSTOMIZERS = Collections.emptySet();

    private static Set<ContextCustomizer> processContextCustomizers(
            @Nullable Set<ContextCustomizer> contextCustomizers
    ) {
        if (contextCustomizers == null)
            return EMPTY_CONTEXT_CUSTOMIZERS;

        contextCustomizers.removeIf(it -> it.getClass().getName().contains("TypeExcludeFiltersContextCustomizer"));

        return contextCustomizers;
    }
}
