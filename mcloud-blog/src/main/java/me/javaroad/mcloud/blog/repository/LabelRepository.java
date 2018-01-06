package me.javaroad.mcloud.blog.repository;

import me.javaroad.mcloud.blog.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {

}
