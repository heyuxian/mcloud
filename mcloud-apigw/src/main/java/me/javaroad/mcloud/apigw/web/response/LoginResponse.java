package me.javaroad.mcloud.apigw.web.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author heyx
 */
@Getter
@Setter
public class LoginResponse {
    private String accessToken;
    private List<String> roles;
}
