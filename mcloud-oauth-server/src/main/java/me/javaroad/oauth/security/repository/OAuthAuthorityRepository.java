package me.javaroad.oauth.security.repository;

import java.util.Set;
import me.javaroad.oauth.security.entity.OAuthAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface OAuthAuthorityRepository extends JpaRepository<OAuthAuthority, Long> {

    Set<OAuthAuthority> findByIdIn(Set<Long> authorityIds);
}
