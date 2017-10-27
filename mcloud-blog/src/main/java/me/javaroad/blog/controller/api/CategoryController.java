package me.javaroad.blog.controller.api;

import static me.javaroad.blog.controller.ApiConstants.API_PREFIX;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import me.javaroad.blog.dto.response.ArticlePageResponse;
import me.javaroad.blog.service.CategoryService;
import me.javaroad.blog.dto.request.ArticleSearchRequest;
import me.javaroad.blog.dto.response.CategoryResponse;
import me.javaroad.blog.entity.Article;
import me.javaroad.blog.entity.Category;
import me.javaroad.blog.mapper.BlogMapper;
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
@RequestMapping(API_PREFIX + "/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final ArticleService articleService;
    private final BlogMapper mapper;

    @Autowired
    public CategoryController(CategoryService categoryService, BlogMapper mapper, ArticleService articleService) {
        this.categoryService = categoryService;
        this.mapper = mapper;
        this.articleService = articleService;
    }

    @ApiOperation(value = "获取所有分类", httpMethod = "GET")
    @GetMapping
    public List<CategoryResponse> getCategories() {
        List<Category> categories = categoryService.getAll();
        return categories.stream().map(mapper::categoryEntityToDto).collect(Collectors.toList());
    }

    @ApiOperation(value = "获取分类下面的所有文章", httpMethod = "GET")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "size", paramType = "query", dataType = "int")
    })

    @GetMapping("{categoryId}/articles")
    public Page<ArticlePageResponse> getCategoryArticles(@PathVariable String username,
        @PathVariable Long categoryId, @PageableDefault Pageable pageable) {

        Page<Article> articles = articleService.getArticlePage(
            ArticleSearchRequest.builder().username(username).categoryId(categoryId).build(),
            pageable);
        return articles.map(mapper::articleEntityToPageDto);
    }

}
