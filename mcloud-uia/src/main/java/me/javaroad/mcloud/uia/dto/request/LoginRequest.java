package me.javaroad.mcloud.uia.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author heyx
 */
@Getter
@Setter
public class LoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
