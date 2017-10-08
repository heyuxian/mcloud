package me.javaroad.oauth.repository;

import java.util.Set;
import me.javaroad.oauth.entity.Approval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface ApprovalRepository extends JpaRepository<Approval, Long> {

    Set<Approval> findByIdIn(Set<Long> autoApproveIds);
}
