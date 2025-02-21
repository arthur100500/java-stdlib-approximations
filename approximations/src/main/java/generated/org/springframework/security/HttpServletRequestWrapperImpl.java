package generated.org.springframework.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.jacodb.approximation.annotation.Approximate;
import stub.java.util.map.RequestMap;

@Approximate(HttpServletRequestWrapper.class)
public class HttpServletRequestWrapperImpl {
    // TODO: Other methods

    public String getHeader(String name) {
        return new RequestMap("HEADER").get(name);
    }
}
