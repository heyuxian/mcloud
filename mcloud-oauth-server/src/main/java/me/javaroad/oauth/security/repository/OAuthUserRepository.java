package me.javaroad.oauth.security.repository;

import me.javaroad.oauth.security.entity.OAuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface OAuthUserRepository extends JpaRepository<OAuthUser, Long> {

}
