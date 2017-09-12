package me.javaroad.blog.core.repository;

import me.javaroad.blog.core.dto.ArticleSearchRequest;
import me.javaroad.blog.core.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author heyx
 */
public interface ArticleRepositoryCustom {

    Page<Article> findBySearchRequest(ArticleSearchRequest searchRequest, Pageable pageable);

    Article findByUserAndId(String username, Long articleId);
}
