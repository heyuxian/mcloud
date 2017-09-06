package org.blackc.oauth.security.repository;

import org.blackc.oauth.security.entity.OAuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface OAuthUserRepository extends JpaRepository<OAuthUser, Long> {

}
