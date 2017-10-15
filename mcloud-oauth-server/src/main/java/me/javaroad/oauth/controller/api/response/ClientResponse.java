package me.javaroad.oauth.controller.api.response;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import me.javaroad.oauth.entity.GrantType;

/**
 * @author heyx
 */
@Getter
@Setter
public class ClientResponse {
    private Long id;
    private String clientId;
    private Set<ResourceResponse> resources;
    private Set<ScopeResponse> scope;
    private Set<GrantType> grantTypes;
    private Set<String> redirectUri;
    private Set<AuthorityResponse> authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String additionalInformation;
    private Set<ApprovalResponse> autoApprove;
}
