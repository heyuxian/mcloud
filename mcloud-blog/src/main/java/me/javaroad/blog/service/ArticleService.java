package me.javaroad.blog.service;

import java.util.Objects;
import me.javaroad.blog.dto.request.ArticleRequest;
import me.javaroad.blog.dto.request.ArticleSearchRequest;
import me.javaroad.blog.dto.response.ArticlePageResponse;
import me.javaroad.blog.dto.response.ArticleResponse;
import me.javaroad.blog.entity.Article;
import me.javaroad.blog.mapper.ArticleMapper;
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
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    public Page<ArticlePageResponse> getArticlePage(ArticleSearchRequest searchRequest, Pageable pageable) {
        Page<Article> articlePage = articleRepository.findBySearchRequest(searchRequest, pageable);
        return articlePage.map(articleMapper::mapEntityToPageResponse);
    }

    public ArticleResponse getResponse(Long articleId) {
        Article article = getNotNullEntity(articleId);
        return articleMapper.mapEntityToResponse(article);
    }

    Article getEntity(Long articleId) {
        return articleRepository.findOne(articleId);
    }

    Article getNotNullEntity(Long articleId) {
        Article article = getEntity(articleId);
        if(Objects.isNull(article)) {
            throw new DataNotFoundException("article[id=%s] not found", articleId);
        }
        return article;
    }

    @Transactional
    public ArticleResponse create(ArticleRequest articleRequest) {
        Article article = articleMapper.mapRequestToEntity(articleRequest);
        article = articleRepository.save(article);
        return articleMapper.mapEntityToResponse(article);
    }

    @Transactional
    public void delete(Long articleId) {
        Article article = articleRepository.findOne(articleId);
        if(Objects.isNull(article)) {
            throw new DataNotFoundException("article[id=%s] not found", articleId);
        }
        articleRepository.delete(article);
    }

}
