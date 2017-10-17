package me.javaroad.blog.service;

import me.javaroad.blog.controller.api.request.ArticleRequest;
import me.javaroad.blog.controller.api.request.ArticleSearchRequest;
import me.javaroad.blog.entity.Article;
import me.javaroad.blog.mapper.BlogMapper;
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
    private final BlogMapper blogMapper;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, BlogMapper blogMapper) {
        this.articleRepository = articleRepository;
        this.blogMapper = blogMapper;
    }

    public Page<Article> getArticlePage(ArticleSearchRequest searchRequest, Pageable pageable) {
        return articleRepository.findBySearchRequest(searchRequest, pageable);
    }

    public Article get(Long articleId) {
        return articleRepository.findOne(articleId);
    }

    @Transactional
    public Article create(ArticleRequest articleRequest) {
        Article article = blogMapper.articleRequestToEntity(articleRequest);
        return articleRepository.save(article);
    }
}
