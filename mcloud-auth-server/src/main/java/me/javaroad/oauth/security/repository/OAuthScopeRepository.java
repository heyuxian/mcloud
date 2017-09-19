package me.javaroad.oauth.security.repository;

import java.util.Set;
import me.javaroad.oauth.security.entity.OAuthScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface OAuthScopeRepository extends JpaRepository<OAuthScope, Long> {

    Set<OAuthScope> findByIdIn(Set<Long> scopeIds);
}
