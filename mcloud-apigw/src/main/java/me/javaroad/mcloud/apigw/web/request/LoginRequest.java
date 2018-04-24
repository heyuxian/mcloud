package me.javaroad.mcloud.apigw.web.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * @author heyx
 */
@Getter
@Setter
public class LoginRequest {
    @NotBlank
    @Size(min = 6)
    private String username;
    @NotBlank
    @Size(min = 6)
    private String password;
}
