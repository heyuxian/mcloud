package me.javaroad.blog.repository;

import me.javaroad.blog.entity.ViewLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface ViewLogRepository extends JpaRepository<ViewLog, Long> {

}
