package org.blackc.blog.core.controller.api;

import static org.blackc.blog.core.controller.ApiConstants.API_VERSION;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.blackc.blog.core.dto.ArticleDto;
import org.blackc.blog.core.dto.ArticlePageDto;
import org.blackc.blog.core.dto.ArticleSearchRequest;
import org.blackc.blog.core.entity.Article;
import org.blackc.blog.core.mapper.BlogMapper;
import org.blackc.blog.core.service.ArticleService;
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
@RequestMapping(API_VERSION + "/users/{username}/articles")
public class ArticleController {

    private final BlogMapper mapper;
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService, BlogMapper mapper) {
        this.articleService = articleService;
        this.mapper = mapper;
    }

    @ApiOperation(value = "根据ID获取Article", httpMethod = "GET")
    @GetMapping("{articleId}")
    public ArticleDto getArticle(@PathVariable String username, @PathVariable Long articleId) {
        Article article = articleService.getArticle(username, articleId);
        return mapper.articleEntityToDto(article);
    }

    @ApiOperation(value = "根据用户分页获取文章", httpMethod = "GET")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "size", paramType = "query", dataType = "int")
    })
    @GetMapping
    public Page<ArticlePageDto> getArticles(@PathVariable String username, @PageableDefault Pageable pageable) {
        Page<Article> articlePage = articleService.getArticlePage(
            ArticleSearchRequest.builder().username(username).build(),
            pageable);
        return articlePage.map(mapper::articleEntityToPageDto);
    }

}
