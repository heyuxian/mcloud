package me.javaroad.oauth.repository;

import java.util.Set;
import me.javaroad.oauth.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Set<Authority> findByIdIn(Set<Long> authorityIds);
}
