package jatek.utl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.bson.Document;
import org.bson.json.Converter;
import org.bson.json.JsonWriterSettings;
import org.bson.json.StrictJsonWriter;
import java.io.IOException;

/**
 * JSon és BSon oda-vissza alakítások, a szükséges varázslatokkal.
 *
 * @author Jenei Attila
 */
public class JsonUtil {

    private static final ObjectMapper objectMapper;
    private static final ObjectMapper compactMapper;
    private static final ObjectMapper bsonDeserializerMapper;
    private static final JsonWriterSettings jsonWriterSettings;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        
        SimpleModule module = new SimpleModule();
        module.addSerializer(java.util.Date.class, new HunDateSerializer());
        module.addDeserializer(java.util.Date.class, new HunDateDeserializer());
        objectMapper.registerModule(module);
        
        //
        compactMapper = new ObjectMapper();
        compactMapper.configure(SerializationFeature.INDENT_OUTPUT, false);
        compactMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        compactMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        
        //
        bsonDeserializerMapper = new ObjectMapper();
        bsonDeserializerMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        module = new SimpleModule();
        module.addDeserializer(java.util.Date.class, new HunDateDeserializer());
        bsonDeserializerMapper.registerModule(module);

        jsonWriterSettings = JsonWriterSettings.builder().int64Converter(new Converter<Long>() {
            @Override
            public void convert(Long value, StrictJsonWriter writer) {
                writer.writeNumber(String.valueOf(value));
            }
        }).build();
    }
    
    private JsonUtil() {
        
    }

    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException jpe) {
            throw new RuntimeException("json-ra alakitas elszállt", jpe);
        }
    }

    public static String toCompactJson(Object obj) {
        try {
            return compactMapper.writeValueAsString(obj);
        } catch (JsonProcessingException jpe) {
            throw new RuntimeException("json-ra alakítás elszállt", jpe);
        }
    }

    public static <T> T fromJson(String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (IOException e) {
            throw new RuntimeException("json readValue elszállt", e);
        }
    }

    public static <T> T fromBson(Document document, Class<T> valueType) {
        String json = document.toJson(jsonWriterSettings);
        try {
            return bsonDeserializerMapper.readValue(json, valueType);
        } catch (IOException e) {
            throw new RuntimeException("json readValue elszállt", e);
        }
    }
}
