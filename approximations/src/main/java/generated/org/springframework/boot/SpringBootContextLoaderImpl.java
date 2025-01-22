package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootContextLoader;

@Approximate(SpringBootContextLoader.class)
public class SpringBootContextLoaderImpl {

    protected SpringApplication getSpringApplication() {
        SpringApplication springApplication = new SpringApplication(new Class<?>[0]);
        springApplication.setRegisterShutdownHook(false);
        return springApplication;
    }

}
