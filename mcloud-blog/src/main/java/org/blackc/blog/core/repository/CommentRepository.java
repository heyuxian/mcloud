package org.blackc.blog.core.repository;

import org.blackc.blog.core.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
