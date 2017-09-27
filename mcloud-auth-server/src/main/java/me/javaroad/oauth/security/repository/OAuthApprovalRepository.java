package me.javaroad.oauth.security.repository;

import java.util.Set;
import me.javaroad.oauth.security.entity.OAuthApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface OAuthApprovalRepository extends JpaRepository<OAuthApproval, Long> {

    Set<OAuthApproval> findByIdIn(Set<Long> autoApproveIds);
}
