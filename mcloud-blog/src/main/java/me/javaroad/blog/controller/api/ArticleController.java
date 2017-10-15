package me.javaroad.blog.controller.api;

import static me.javaroad.blog.controller.ApiConstants.API_VERSION;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.javaroad.blog.dto.ArticlePageDto;
import me.javaroad.blog.mapper.BlogMapper;
import me.javaroad.blog.service.ArticleService;
import me.javaroad.blog.dto.ArticleDto;
import me.javaroad.blog.dto.ArticleSearchRequest;
import me.javaroad.blog.entity.Article;
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

    private final BlogMapper mapper;
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService, BlogMapper mapper) {
        this.articleService = articleService;
        this.mapper = mapper;
    }

    @ApiOperation(value = "根据ID获取Article", httpMethod = "GET")
    @GetMapping("{articleId}")
    public ArticleDto getArticle(@PathVariable Long articleId) {
        Article article = articleService.get(articleId);
        return mapper.articleEntityToDto(article);
    }

    @ApiOperation(value = "分页获取文章", httpMethod = "GET")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "size", paramType = "query", dataType = "int")
    })
    @GetMapping
    public Page<ArticlePageDto> getArticles(@PageableDefault Pageable pageable) {
        Page<Article> articlePage = articleService.getArticlePage(
            ArticleSearchRequest.builder().build(),
            pageable);
        return articlePage.map(mapper::articleEntityToPageDto);
    }

}
