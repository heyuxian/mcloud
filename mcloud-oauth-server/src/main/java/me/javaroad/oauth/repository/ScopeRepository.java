package me.javaroad.oauth.repository;

import java.util.Set;
import me.javaroad.oauth.entity.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface ScopeRepository extends JpaRepository<Scope, Long> {

    Set<Scope> findByIdIn(Set<Long> scopeIds);
}
