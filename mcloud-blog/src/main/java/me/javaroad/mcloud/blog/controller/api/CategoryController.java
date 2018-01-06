package me.javaroad.mcloud.blog.controller.api;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import me.javaroad.mcloud.blog.dto.request.CategoryRequest;
import me.javaroad.mcloud.blog.dto.response.CategoryResponse;
import me.javaroad.mcloud.blog.service.CategoryService;
import me.javaroad.mcloud.blog.controller.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping(ApiConstants.API_PREFIX + "/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "Get all categories", httpMethod = "GET")
    @GetMapping
    public List<CategoryResponse> getCategories() {
        return categoryService.getAll();
    }

    @ApiOperation(value = "Get category by ID", httpMethod = "GET")
    @GetMapping("{categoryId}")
    public CategoryResponse getCategory(@PathVariable Long categoryId) {
        return categoryService.getResponse(categoryId);
    }

    @ApiOperation(value = "Create category", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        return categoryService.create(categoryRequest);
    }

    @ApiOperation(value = "Modify category", httpMethod = "PUT")
    @PutMapping("{categoryId}")
    public CategoryResponse modifyCategory(@PathVariable Long categoryId,
        @RequestBody @Valid CategoryRequest categoryRequest) {
        return categoryService.modify(categoryId, categoryRequest);
    }

    @ApiOperation(value = "Delete category", httpMethod = "DELETE")
    @DeleteMapping("{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.delete(categoryId);
    }

}
