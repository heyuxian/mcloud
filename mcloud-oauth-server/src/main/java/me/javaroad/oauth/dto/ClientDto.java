package me.javaroad.oauth.dto;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import me.javaroad.oauth.entity.GrantType;

/**
 * @author heyx
 */
@Getter
@Setter
public class ClientDto {
    private Long id;
    private String clientId;
    private Set<ResourceDto> resources;
    private String clientSecret;
    private Set<ScopeDto> scope;
    private Set<GrantType> grantTypes;
    private Set<String> registeredRedirectUris;
    private Set<AuthorityDto> authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String additionalInformation;
    private Set<ApprovalDto> autoApprove;
}
