package generated.com.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.FieldProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import generated.org.springframework.boot.SpringApplicationImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

import java.io.IOException;
import java.io.Serial;
import java.lang.annotation.Annotation;

@Approximate(FieldProperty.class)
public abstract class FieldPropertyImpl extends SettableBeanProperty {
    @Serial
    private static final long serialVersionUID = 1L;

    protected FieldPropertyImpl(BeanPropertyDefinition propDef, JavaType type, TypeDeserializer typeDeser, Annotations contextAnnotations) {
        super(propDef, type, typeDeser, contextAnnotations);
    }

    @Override
    public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException
    {
        if (BeanDeserializerImpl._concreteDeserialization()) {
            deserializeAndSetReal(p, ctxt, instance);
            return;
        }

        boolean isNull = Engine.makeSymbolicBoolean();
        Object value;

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
            ((FieldProperty)(Object)(this)).set(instance, value);
        } catch (Exception e) {
            _throwAsIOE(p, e, value);
        }
    }

    public void deserializeAndSetReal(JsonParser p,
                                  DeserializationContext ctxt, Object instance) throws IOException
    {
        boolean _skipNulls;

        try {
            _skipNulls = FieldProperty.class.getDeclaredField("_skipNulls").getBoolean(this);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        Object value;
        if (p.hasToken(JsonToken.VALUE_NULL)) {
            if (_skipNulls) {
                return;
            }
            value = _nullProvider.getNullValue(ctxt);
        } else if (_valueTypeDeserializer == null) {
            value = _valueDeserializer.deserialize(p, ctxt);
            // 04-May-2018, tatu: [databind#2023] Coercion from String (mostly) can give null
            if (value == null) {
                if (_skipNulls) {
                    return;
                }
                value = _nullProvider.getNullValue(ctxt);
            }
        } else {
            value = _valueDeserializer.deserializeWithType(p, ctxt, _valueTypeDeserializer);
        }
        try {
            ((FieldProperty)(Object)(this)).set(instance, value);
        } catch (Exception e) {
            _throwAsIOE(p, e, value);
        }
    }
}
