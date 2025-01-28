package generated.com.fasterxml.jackson;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

import java.io.IOException;
import java.io.Serial;

@Approximate(NumberDeserializers.class)
public class NumberDeserializersImpl {
//
//    protected abstract static class PrimitiveOrWrapperDeserializer<T>
//            extends StdScalarDeserializer<T> {
//        private static final long serialVersionUID = 1L;
//
//        // @since 2.12
//        protected final LogicalType _logicalType;
//
//        protected final T _nullValue;
//
//        // @since 2.9
//        protected final T _emptyValue;
//
//        protected final boolean _primitive;
//
//        // @since 2.12
//        protected PrimitiveOrWrapperDeserializer(Class<T> vc, LogicalType logicalType,
//                                                 T nvl, T empty) {
//            super(vc);
//            _logicalType = logicalType;
//            _nullValue = nvl;
//            _emptyValue = empty;
//            _primitive = vc.isPrimitive();
//        }
//
//        @Deprecated // since 2.12
//        protected PrimitiveOrWrapperDeserializer(Class<T> vc, T nvl, T empty) {
//            this(vc, LogicalType.OtherScalar, nvl, empty);
//        }
//
//        @Override
//        public AccessPattern getNullAccessPattern() {
//            // 02-Feb-2017, tatu: For primitives we must dynamically check (and possibly throw
//            //     exception); for wrappers not.
//            if (_primitive) {
//                return AccessPattern.DYNAMIC;
//            }
//            if (_nullValue == null) {
//                return AccessPattern.ALWAYS_NULL;
//            }
//            return AccessPattern.CONSTANT;
//        }
//
//        @Override
//        public final T getNullValue(DeserializationContext ctxt) throws JsonMappingException {
//            // 01-Mar-2017, tatu: Alas, not all paths lead to `_coerceNull()`, as `SettableBeanProperty`
//            //    short-circuits `null` handling. Hence need this check as well.
//            if (_primitive && ctxt.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
//                ctxt.reportInputMismatch(this,
//                        "Cannot map `null` into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)",
//                        ClassUtil.classNameOf(handledType()));
//            }
//            return _nullValue;
//        }
//
//        @Override
//        public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
//            return _emptyValue;
//        }
//
//        @Override // since 2.12
//        public final LogicalType logicalType() {
//            return _logicalType;
//        }
//    }
//
//    // TODO: Other Deserializers...
//    
//    @JacksonStdImpl
//    @Approximate(NumberDeserializers.IntegerDeserializer.class)
//    public final static class BooleanDeserializerImpl extends NumberDeserializersImpl.PrimitiveOrWrapperDeserializer<Boolean> {
//        @Serial
//        private static final long serialVersionUID = 1L;
//
//        private BooleanDeserializerImpl(Class<Boolean> vc, LogicalType logicalType, Boolean nvl, Boolean empty) {
//            super(vc, logicalType, nvl, empty);
//        }
//
//        @Override
//        public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
//            return Engine.makeSymbolicBoolean();
//        }
//    }
//
//    @JacksonStdImpl
//    @Approximate(NumberDeserializers.IntegerDeserializer.class)
//    public final static class IntegerDeserializerImpl extends NumberDeserializersImpl.PrimitiveOrWrapperDeserializer<Integer> {
//        @Serial
//        private static final long serialVersionUID = 1L;
//
//        private IntegerDeserializerImpl(Class<Integer> vc, LogicalType logicalType, Integer nvl, Integer empty) {
//            super(vc, logicalType, nvl, empty);
//        }
//        
//        @Override
//        public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
//            return Engine.makeSymbolicInt();
//        }
//    }
}
