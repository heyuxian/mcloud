package me.javaroad.oauth.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "oauth_scope")
public class OAuthScope extends TemporalEntity {
    @Column(unique = true)
    private String name;
}
