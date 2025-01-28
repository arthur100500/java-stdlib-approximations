package generated.com.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

import java.io.IOException;
import java.io.Serial;
import java.lang.reflect.Type;
import java.util.*;

@Approximate(BeanDeserializer.class)
public class BeanDeserializerImpl extends BeanDeserializer {

    @Serial
    private static final long serialVersionUID = 1L;
    
    protected BeanDeserializerImpl(BeanDeserializerBase src) {
        super(src);
    }
    
    
    private boolean _isJsonPrimitive(Class<?> clazz) {
        // Here are types like Integer string etc.
        // Currently only int and string
        List<Class<?>> primitives = Arrays.asList(String.class, Integer.class, Boolean.class);
        return primitives.contains(clazz) || clazz.isPrimitive();
    }

    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException
    {
        Object empty = _valueInstantiator.createUsingDefault(ctxt);
        Class<?> clazz = empty.getClass();
        if (_isJsonPrimitive(clazz))
            return Engine.makeSymbolic(clazz);
        return deserializeFromObject(p, ctxt);
    }
    
    public Object deserializeFromObject(JsonParser p, DeserializationContext ctxt) throws IOException {
        final Object bean = _valueInstantiator.createUsingDefault(ctxt);
        final Class<?> clazz = bean.getClass();
        for (SettableBeanProperty property : _beanProperties) {
            if (_isJsonPrimitive(clazz))
                property.set(bean, Engine.makeSymbolic(clazz));
            else
                property.deserializeAndSet(p, ctxt, bean);
        }
        return bean;
    }
}
