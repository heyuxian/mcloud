package me.javaroad.blog.core.repository;

import me.javaroad.blog.core.entity.ViewLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface ViewLogRepository extends JpaRepository<ViewLog, Long> {

}
