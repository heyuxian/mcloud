package org.blackc.blog.core.repository;

import org.blackc.blog.core.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleRepositoryCustom {

}
