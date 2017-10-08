package me.javaroad.oauth.controller.web.request;

import java.util.Set;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import me.javaroad.oauth.entity.GrantType;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author heyx
 */
@Getter
@Setter
public class ClientRequest {
    @NotBlank
    private String clientId;
    @NotBlank
    private String clientSecret;
    private String additionalInformation;
    @NotNull
    private Integer accessTokenValidity;
    @NotNull
    private Integer refreshTokenValidity;
    @NotEmpty
    private Set<String> redirectUri;
    @NotEmpty
    private Set<GrantType> grantTypes;
    @NotEmpty
    private Set<Long> resourceIds;
    @NotEmpty
    private Set<Long> scopeIds;
    @NotEmpty
    private Set<Long> authorityIds;
    private Set<Long> autoApproveIds;
}
