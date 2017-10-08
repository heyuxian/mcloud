package me.javaroad.uaa.net;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author heyx
 */
@Getter
@Setter
public class TokenResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refresh_token;
    @JsonProperty("expires_in")
    private Long expiresIn;
    private String scope;

    private String error;
    @JsonProperty("error_description")
    private String errorDescription;
}
