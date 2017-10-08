package me.javaroad.oauth.entity;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "oauth_approval")
public class Approval extends TemporalEntity {
    @Column(unique = true)
    private String name;
    @ManyToOne
    private User user;
    @ManyToOne
    private Client client;
    @ManyToMany
    private Set<Scope> scope;
    @Enumerated(EnumType.STRING)
    private ApprovalStatus status;
    private LocalDateTime expiresAt;

    public enum ApprovalStatus {
        APPROVED,
        DENIED;
    }
}
