package org.blackc.oauth.security.repository;

import java.util.Set;
import org.blackc.oauth.security.entity.OAuthApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface OAuthApprovalRepository extends JpaRepository<OAuthApproval, Long> {

    Set<OAuthApproval> findByIdIn(Set<Long> autoApproveIds);
}
