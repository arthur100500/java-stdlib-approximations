package generated.jakarta.servlet.http;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.apache.catalina.util.ParameterMap;
import org.apache.tomcat.util.bcel.Const;
import org.jacodb.approximation.annotation.Approximate;
import stub.java.util.map.RequestMap;
import stub.java.util.map.RequestMultiValueMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

@Approximate(jakarta.servlet.http.HttpServletRequest.class)
public class HttpServletRequestImpl {
    private final Map<String, String[]> parameterMap = new RequestMultiValueMap("PARAM");
    public Map<String, String[]> getParameterMap() { return parameterMap; }
}
