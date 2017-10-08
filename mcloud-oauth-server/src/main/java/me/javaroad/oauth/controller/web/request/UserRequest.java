package me.javaroad.oauth.controller.web.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author heyx
 */
@Getter
@Setter
public class UserRequest {
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
