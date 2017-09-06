package org.blackc.blog.core.repository;

import org.blackc.blog.core.dto.ArticleSearchRequest;
import org.blackc.blog.core.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author heyx
 */
public interface ArticleRepositoryCustom {

    Page<Article> findBySearchRequest(ArticleSearchRequest searchRequest, Pageable pageable);

    Article findByUserAndId(String username, Long articleId);
}
