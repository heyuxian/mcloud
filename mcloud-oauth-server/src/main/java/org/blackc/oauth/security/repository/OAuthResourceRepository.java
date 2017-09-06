package org.blackc.oauth.security.repository;

import java.util.Set;
import org.blackc.oauth.security.entity.OAuthResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface OAuthResourceRepository extends JpaRepository<OAuthResource, Long> {

    Set<OAuthResource> findByIdIn(Set<Long> resourceIds);
}
