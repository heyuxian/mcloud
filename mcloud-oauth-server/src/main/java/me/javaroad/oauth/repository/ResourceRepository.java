package me.javaroad.oauth.repository;

import java.util.Set;
import me.javaroad.oauth.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    Set<Resource> findByIdIn(Set<Long> resourceIds);
}
