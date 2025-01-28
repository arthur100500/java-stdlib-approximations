package generated.org.springframework.http;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import stub.java.util.map.RequestMap;

@Approximate(HttpHeaders.class)
public class HttpHeadersImpl {
    private final RequestMap fakeHeaders = new RequestMap("HEADER");
    
    public void set(String headerName, @Nullable String headerValue) {
        fakeHeaders.set(headerName, headerValue);
    }

    @Nullable
    public MediaType getContentType() {
        // TODO: Make symbolic with pre-defined values that will be accepted by respective message converter
        String value = "application/json";
        return MediaType.parseMediaType(value);
    }
}
