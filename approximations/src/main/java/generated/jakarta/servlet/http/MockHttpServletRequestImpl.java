package generated.jakarta.servlet.http;

import generated.org.springframework.boot.pinnedValues.PinnedValueSource;
import org.jacodb.approximation.annotation.Approximate;
import org.springframework.mock.web.MockHttpServletRequest;
import stub.java.util.map.RequestMap;
import stub.java.util.map.RequestMultiValueMap;

import java.util.*;

import static generated.org.springframework.boot.pinnedValues.PinnedValueStorage.getPinnedValue;

@Approximate(MockHttpServletRequest.class)
public class MockHttpServletRequestImpl {
    public Map<String, String[]> getParameterMap() { return new RequestMultiValueMap(PinnedValueSource.REQUEST_PARAM); }
    public Map<String, String[]> _getHeaderMap() { return new RequestMultiValueMap(PinnedValueSource.REQUEST_HEADER); }
    public Map<String, String[]> _matrixMap() { return new RequestMultiValueMap(PinnedValueSource.REQUEST_MATRIX); }
    public Map<String, String[]> _pathMap() { return new RequestMultiValueMap(PinnedValueSource.REQUEST_PATH); }

    // TODO: In real request all maps are multivalue, here it's taking [0] from map
    public String getParameter(String name) { return new RequestMap(PinnedValueSource.REQUEST_PARAM).get(name); }
    public String getHeader(String name) { return new RequestMap(PinnedValueSource.REQUEST_HEADER).get(name); }
}
