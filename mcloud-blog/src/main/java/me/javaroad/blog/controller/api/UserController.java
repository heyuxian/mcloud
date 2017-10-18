package me.javaroad.blog.controller.api;

import static me.javaroad.blog.controller.ApiConstants.API_VERSION;

import io.swagger.annotations.ApiOperation;
import java.security.Principal;
import javax.validation.Valid;
import me.javaroad.blog.controller.api.request.ArticleRequest;
import me.javaroad.blog.controller.api.response.ArticleResponse;
import me.javaroad.blog.controller.api.response.UserResponse;
import me.javaroad.blog.entity.Article;
import me.javaroad.blog.mapper.ArticleMapper;
import me.javaroad.blog.mapper.CategoryMapper;
import me.javaroad.blog.mapper.CommentMapper;
import me.javaroad.blog.mapper.LabelMapper;
import me.javaroad.blog.mapper.UserMapper;
import me.javaroad.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping(API_VERSION + "/users")
public class UserController {

    private final ArticleService articleService;
    private final UserMapper userMapper;
    private final ArticleMapper articleMapper;
    private final CommentMapper commentMapper;
    private final LabelMapper labelMapper;
    private final CategoryMapper categoryMapper;

    @Autowired
    public UserController(ArticleService articleService, UserMapper userMapper,
        ArticleMapper articleMapper, CommentMapper commentMapper, LabelMapper labelMapper,
        CategoryMapper categoryMapper) {
        this.articleService = articleService;
        this.userMapper = userMapper;
        this.articleMapper = articleMapper;
        this.commentMapper = commentMapper;
        this.labelMapper = labelMapper;
        this.categoryMapper = categoryMapper;
    }

    @ApiOperation(value = "获取当前登录用户信息", httpMethod = "POST")
    @GetMapping("me")
    public UserResponse me(Principal principal) {
        return new UserResponse();
    }

    @ApiOperation(value = "新建Article", httpMethod = "POST")
    @PostMapping("me/articles")
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleResponse createArticle(@RequestBody @Valid ArticleRequest articleRequest) {
        Article article = articleService.create(articleRequest);
        return articleMapper.mapEntityToResponse(article);
    }

    @ApiOperation(value = "新建Article", httpMethod = "DELETE")
    @DeleteMapping("me/articles/{articleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable Long articleId) {
        articleService.delete(articleId);
    }
}
