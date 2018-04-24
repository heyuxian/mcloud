package me.javaroad.mcloud.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author heyx
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T parse(String content, Class<T> clazz) throws IOException {
        return MAPPER.readValue(content, clazz);
    }

    public static <T> String toJson(T t) throws JsonProcessingException {
        return MAPPER.writeValueAsString(t);
    }
}
