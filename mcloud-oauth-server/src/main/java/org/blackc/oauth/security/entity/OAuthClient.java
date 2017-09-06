package org.blackc.oauth.security.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.blackc.data.entity.TemporalEntity;
import org.blackc.data.entity.convert.StringSetConvert;
import org.blackc.oauth.security.entity.convert.GrantTypeStringConvert;

/**
 * @author heyx
 */
@NamedEntityGraph(
    name = OAuthClient.FETCH_ALL_GRAPH,
    attributeNodes = {
        @NamedAttributeNode("resources"),
        @NamedAttributeNode("scope"),
        @NamedAttributeNode("authorities"),
        @NamedAttributeNode("autoApprove")
    }
)
@Getter
@Setter
@Entity
@Table(name = "oauth_client")
public class OAuthClient extends TemporalEntity {

    public static final String FETCH_ALL_GRAPH = "fetch_all";
    @Column(unique = true)
    private String clientId;
    @ManyToMany
    @JoinTable(name = "client_resource",
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private Set<OAuthResource> resources;
    private String clientSecret;
    @ManyToMany
    @JoinTable(name = "client_scope",
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "scope_id")
    )
    private Set<OAuthScope> scope;
    @Convert(converter = GrantTypeStringConvert.class)
    private Set<GrantType> grantTypes;
    @Convert(converter = StringSetConvert.class)
    private Set<String> redirectUri;
    @ManyToMany
    @JoinTable(name = "client_authority",
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<OAuthAuthority> authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    @Column(columnDefinition = "text")
    private String additionalInformation;
    @ManyToMany
    @JoinTable(name = "client_approval",
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "approval_id")
    )
    private Set<OAuthApproval> autoApprove;

}
