package generated.com.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.FieldProperty;
import com.fasterxml.jackson.databind.deser.impl.MethodProperty;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import generated.org.springframework.boot.SpringApplicationImpl;
import org.jacodb.approximation.annotation.Approximate;

import java.io.IOException;
import java.io.Serial;

@Approximate(MethodProperty.class)
public abstract class MethodPropertyImpl extends SettableBeanProperty {
    @Serial
    private static final long serialVersionUID = 1L;

    protected MethodPropertyImpl(BeanPropertyDefinition propDef, JavaType type, TypeDeserializer typeDeser, Annotations contextAnnotations) {
        super(propDef, type, typeDeser, contextAnnotations);
    }

    @Override
    public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException
    {
        // TODO: Make it working with non-symbolic deserialization
        // TODO: Make symbolic
        boolean isNull = false;
        Object value;

        SpringApplicationImpl._println(String.format("[Deserializing (deserializeAndSet) (MethodPropertyImpl)] Setting %s", this));

        if (isNull) {
            value = _nullProvider.getNullValue(ctxt);
        } else if (_valueTypeDeserializer == null) {
            value = _valueDeserializer.deserialize(p, ctxt);
            // 04-May-2018, tatu: [databind#2023] Coercion from String (mostly) can give null
            if (value == null) {
                value = _nullProvider.getNullValue(ctxt);
            }
        } else {
            value = _valueDeserializer.deserializeWithType(p, ctxt, _valueTypeDeserializer);
        }
        try {
            ((MethodProperty)(Object)(this)).set(instance, value);
        } catch (Exception e) {
            _throwAsIOE(p, e, value);
        }
    }
}
