package me.javaroad.blog.controller.api;

import static me.javaroad.blog.controller.ApiConstants.API_VERSION;

import io.swagger.annotations.ApiOperation;
import java.security.Principal;
import javax.validation.Valid;
import me.javaroad.blog.controller.api.request.ArticleRequest;
import me.javaroad.blog.dto.ArticleDto;
import me.javaroad.blog.entity.Article;
import me.javaroad.blog.mapper.BlogMapper;
import me.javaroad.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping(API_VERSION + "/users")
public class UserController {

    private final ArticleService articleService;
    private final BlogMapper blogMapper;

    @Autowired
    public UserController(ArticleService articleService, BlogMapper blogMapper) {
        this.articleService = articleService;
        this.blogMapper = blogMapper;
    }

    @GetMapping("me")
    public Principal me(Principal principal) {
        return principal;
    }

    @ApiOperation(value = "新建Article", httpMethod = "POST")
    @PostMapping("me/articles")
    public ArticleDto createArticle(@RequestBody @Valid ArticleRequest articleRequest) {
        Article article = articleService.create(articleRequest);
        return blogMapper.articleEntityToDto(article);
    }
}
