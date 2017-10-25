package me.javaroad.blog.service;

import java.util.Objects;
import me.javaroad.blog.dto.request.ArticleRequest;
import me.javaroad.blog.dto.request.ArticleSearchRequest;
import me.javaroad.blog.entity.Article;
import me.javaroad.blog.mapper.BlogMapper;
import me.javaroad.blog.repository.ArticleRepository;
import me.javaroad.common.exception.DataNotFoundException;
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

    @Transactional
    public void delete(Long articleId) {
        Article article = articleRepository.findOne(articleId);
        if(Objects.isNull(article)) {
            throw new DataNotFoundException("article[id=%s] not found", articleId);
        }
        articleRepository.delete(article);
    }

    Article getArticle(Long articleId) {
        return articleRepository.findOne(articleId);
    }
}
