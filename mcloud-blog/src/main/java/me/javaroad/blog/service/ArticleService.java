package me.javaroad.blog.service;

import me.javaroad.blog.dto.ArticleSearchRequest;
import me.javaroad.blog.entity.Article;
import me.javaroad.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author heyx
 */
@Service
@Transactional(readOnly = true)
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Page<Article> getArticlePage(ArticleSearchRequest searchRequest, Pageable pageable) {
        return articleRepository.findBySearchRequest(searchRequest, pageable);
    }

    public Article get(Long articleId) {
        return articleRepository.findOne(articleId);
    }
}
