package me.javaroad.oauth.entity;

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
import me.javaroad.data.entity.TemporalEntity;
import me.javaroad.data.entity.convert.StringSetConvert;
import me.javaroad.oauth.entity.convert.GrantTypeStringConvert;

/**
 * @author heyx
 */
@NamedEntityGraph(
    name = Client.FETCH_ALL_GRAPH,
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
public class Client extends TemporalEntity {

    public static final String FETCH_ALL_GRAPH = "fetch_all";
    @Column(unique = true)
    private String clientId;
    @ManyToMany
    @JoinTable(name = "client_resource",
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private Set<Resource> resources;
    private String clientSecret;
    @ManyToMany
    @JoinTable(name = "client_scope",
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "scope_id")
    )
    private Set<Scope> scope;
    @Convert(converter = GrantTypeStringConvert.class)
    private Set<GrantType> grantTypes;
    @Convert(converter = StringSetConvert.class)
    private Set<String> redirectUri;
    @ManyToMany
    @JoinTable(name = "client_authority",
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    @Column(columnDefinition = "text")
    private String additionalInformation;
    @ManyToMany
    @JoinTable(name = "client_approval",
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "approval_id")
    )
    private Set<Approval> autoApprove;

}
