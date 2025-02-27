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
    public Map<String, String[]> getParameterMap() { return new RequestMultiValueMap("PARAM"); }
    public Map<String, String[]> _getHeaderMap() { return new RequestMultiValueMap("HEADER"); }
    public Map<String, String[]> _matrixMap() { return new RequestMultiValueMap("MATRIX"); }
    public Map<String, String[]> _pathMap() { return new RequestMultiValueMap("PATH"); }
}
