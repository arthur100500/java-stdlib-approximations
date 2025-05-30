package generated.com.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jacodb.approximation.annotation.Approximate;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@Approximate(ObjectMapper.class)
public class ObjectMapperImpl extends ObjectMapper{

    @Serial
    private static final long serialVersionUID = 1L;

    protected Object _readMapAndClose(JsonParser p0, JavaType valueType) throws IOException {
        DeserializationConfig cfg = this.getDeserializationConfig();
        DeserializationContext ctxt = this.createDeserializationContext(p0, cfg);
        JsonDeserializer<Object> deserializer = this._findRootDeserializer(ctxt, valueType);
        List<Object> result = BeanDeserializerImpl.generateSymbolic(valueType, deserializer, p0, ctxt, 0);
        BeanDeserializerImpl.writeToState(result.get(0));
        return result.get(1);
    }
}
