package generated.jakarta.servlet.http;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.mock.web.MockHttpServletRequest;
import stub.java.util.map.RequestMap;
import stub.java.util.map.RequestMultiValueMap;

import java.util.*;

@Approximate(MockHttpServletRequest.class)
public class MockHttpServletRequestImpl {
    public Map<String, String[]> getParameterMap() { return new RequestMultiValueMap("PARAM"); }
    public Map<String, String[]> _getHeaderMap() { return new RequestMultiValueMap("HEADER"); }
    public Map<String, String[]> _matrixMap() { return new RequestMultiValueMap("MATRIX"); }
    public Map<String, String[]> _pathMap() { return new RequestMultiValueMap("PATH"); }

    // TODO: In real request all maps are multivalue, here it's taking [0] from map
    public String getParameter(String name) { return new RequestMap("PARAM").get(name); }
    public String getHeader(String name) { return new RequestMap("HEADER").get(name); }
}
