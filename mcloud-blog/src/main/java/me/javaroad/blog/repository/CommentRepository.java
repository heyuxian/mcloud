package me.javaroad.blog.repository;

import me.javaroad.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
