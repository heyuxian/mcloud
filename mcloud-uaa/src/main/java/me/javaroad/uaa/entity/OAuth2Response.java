package me.javaroad.uaa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author heyx
 */
@Getter
@Setter
public class OAuth2Response {
    @JsonProperty("access_token")
    private String accessToken;
}
