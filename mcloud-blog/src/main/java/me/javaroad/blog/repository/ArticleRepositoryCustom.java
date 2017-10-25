package me.javaroad.blog.repository;

import me.javaroad.blog.dto.request.ArticleSearchRequest;
import me.javaroad.blog.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author heyx
 */
public interface ArticleRepositoryCustom {

    Page<Article> findBySearchRequest(ArticleSearchRequest searchRequest, Pageable pageable);

    Article findByUserAndId(String username, Long articleId);
}
