package me.javaroad.blog.repository;

import me.javaroad.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleRepositoryCustom {

}
