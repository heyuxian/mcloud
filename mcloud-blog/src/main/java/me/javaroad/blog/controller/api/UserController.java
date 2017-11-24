package me.javaroad.blog.controller.api;

import static me.javaroad.blog.controller.ApiConstants.API_PREFIX;

import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import me.javaroad.blog.dto.request.ArticleRequest;
import me.javaroad.blog.dto.response.ArticleResponse;
import me.javaroad.blog.dto.response.UserResponse;
import me.javaroad.blog.service.ArticleService;
import me.javaroad.web.bind.annotation.CurrentUser;
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
@RequestMapping(API_PREFIX + "/users")
public class UserController {

    private final ArticleService articleService;

    @Autowired
    public UserController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @ApiOperation(value = "获取当前登录用户信息", httpMethod = "GET")
    @GetMapping("me")
    public UserResponse me(@CurrentUser String username) {
        return null;
    }

    @ApiOperation(value = "新建Article", httpMethod = "POST")
    @PostMapping("me/articles")
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleResponse createArticle(@RequestBody @Valid ArticleRequest articleRequest) {
        return articleService.create(articleRequest);
    }

    @ApiOperation(value = "删除Article", httpMethod = "DELETE")
    @DeleteMapping("me/articles/{articleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable Long articleId) {
        articleService.delete(articleId);
    }
}
