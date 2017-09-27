package me.javaroad.oauth.security.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import me.javaroad.data.entity.TemporalEntity;

/**
 * @author heyx
 */
@Getter
@Setter
@Entity
@Table(name = "oauth_authority")
public class OAuthAuthority extends TemporalEntity {
    private String name;
    @ManyToMany(mappedBy = "authorities")
    private Set<OAuthUser> users;
}
