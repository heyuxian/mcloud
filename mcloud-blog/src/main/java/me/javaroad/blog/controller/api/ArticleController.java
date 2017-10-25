package me.javaroad.blog.controller.api;

import static me.javaroad.blog.controller.ApiConstants.API_VERSION;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.security.Principal;
import javax.validation.Valid;
import me.javaroad.blog.dto.request.ArticleSearchRequest;
import me.javaroad.blog.dto.request.CommentRequest;
import me.javaroad.blog.dto.response.ArticlePageResponse;
import me.javaroad.blog.dto.response.ArticleResponse;
import me.javaroad.blog.dto.response.CommentResponse;
import me.javaroad.blog.dto.response.UserResponse;
import me.javaroad.blog.entity.Article;
import me.javaroad.blog.entity.Comment;
import me.javaroad.blog.mapper.ArticleMapper;
import me.javaroad.blog.mapper.CommentMapper;
import me.javaroad.blog.service.ArticleService;
import me.javaroad.blog.service.CommentService;
import me.javaroad.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    private final CommentService commentService;
    private final UserService userService;

    @Autowired
    public ArticleController(ArticleService articleService, ArticleMapper articleMapper,
        CommentMapper commentMapper, CommentService commentService, UserService userService) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
        this.commentMapper = commentMapper;
        this.commentService = commentService;
        this.userService = userService;
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
        Page<Comment> commentPage = commentService.getCommentPage(articleId, pageable);
        return commentPage.map(commentMapper::mapEntityToResponse);
    }

    @ApiOperation(value = "发表评论", httpMethod = "POST")
    @PostMapping("{articleId}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public void createArticleComment(@PathVariable Long articleId,
        @Valid @RequestBody CommentRequest commentRequest, Principal principal) {

        UserResponse userResponse = userService.get(principal.getName());
        commentService.create(articleId, userResponse.getId(), commentRequest);
    }

}
