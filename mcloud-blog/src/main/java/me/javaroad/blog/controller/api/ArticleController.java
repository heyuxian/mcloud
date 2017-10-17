package me.javaroad.blog.controller.api;

import static me.javaroad.blog.controller.ApiConstants.API_VERSION;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.javaroad.blog.controller.api.request.ArticleSearchRequest;
import me.javaroad.blog.controller.api.response.ArticlePageResponse;
import me.javaroad.blog.controller.api.response.ArticleResponse;
import me.javaroad.blog.controller.api.response.CommentResponse;
import me.javaroad.blog.entity.Article;
import me.javaroad.blog.mapper.ArticleMapper;
import me.javaroad.blog.mapper.CommentMapper;
import me.javaroad.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping(API_VERSION + "/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleMapper articleMapper;
    private final CommentMapper commentMapper;

    @Autowired
    public ArticleController(ArticleService articleService, ArticleMapper articleMapper,
        CommentMapper commentMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
        this.commentMapper = commentMapper;
    }

    @ApiOperation(value = "根据ID获取Article", httpMethod = "GET")
    @GetMapping("{articleId}")
    public ArticleResponse getArticle(@PathVariable Long articleId) {
        Article article = articleService.get(articleId);
        return articleMapper.mapEntityToResponse(article);
    }

    @ApiOperation(value = "分页获取文章", httpMethod = "GET")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "size", paramType = "query", dataType = "int")
    })
    @GetMapping
    public Page<ArticlePageResponse> getArticles(@PageableDefault Pageable pageable) {
        Page<Article> articlePage = articleService.getArticlePage(
            ArticleSearchRequest.builder().build(),
            pageable);
        return articlePage.map(articleMapper::mapEntityToPageResponse);
    }

    @ApiOperation(value = "分页获取文章评论", httpMethod = "GET")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "size", paramType = "query", dataType = "int")
    })
    @GetMapping("{articleId}/comments")
    public Page<CommentResponse> getArticleComments(@PathVariable Long articleId, @PageableDefault Pageable pageable) {
        return null;
    }

}
