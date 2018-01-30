package me.javaroad.mcloud.uia.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.javaroad.common.util.JsonUtils;
import me.javaroad.mcloud.uia.entity.State;
import org.springframework.util.Base64Utils;

/**
 * @author heyx
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StateUtils {

    public static State decode(String src) {
        try {
            String stateStr = new String(Base64Utils.decodeFromString(src), "utf8");
            return JsonUtils.parse(stateStr, State.class);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("invalid state string, state: " + src);
        } catch (IOException e) {
            return null;
        }
    }

    public static String encode(State state) {
        try {
            String stateJson = JsonUtils.toJson(state);
            return Base64Utils.encodeToUrlSafeString(stateJson.getBytes("utf8"));
        } catch (JsonProcessingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
