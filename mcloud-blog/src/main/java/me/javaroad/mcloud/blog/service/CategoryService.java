package me.javaroad.mcloud.blog.service;

import java.util.List;
import java.util.Objects;
import me.javaroad.mcloud.blog.dto.request.CategoryRequest;
import me.javaroad.mcloud.blog.dto.response.CategoryResponse;
import me.javaroad.mcloud.blog.mapper.CategoryMapper;
import me.javaroad.mcloud.blog.repository.CategoryRepository;
import me.javaroad.mcloud.blog.entity.Category;
import me.javaroad.common.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author heyx
 */
@Service
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.mapEntityToResponse(categories);
    }

    public CategoryResponse getResponse(Long categoryId) {
        return categoryMapper.mapEntityToResponse(getEntity(categoryId));
    }

    @Transactional
    public CategoryResponse create(CategoryRequest categoryRequest) {
        Category category = categoryMapper.mapRequestToEntity(categoryRequest);
        category = categoryRepository.save(category);
        return categoryMapper.mapEntityToResponse(category);
    }

    @Transactional
    public CategoryResponse modify(Long categoryId, CategoryRequest categoryRequest) {
        Category category = getNotNullEntity(categoryId);
        categoryMapper.updateEntityFromRequest(categoryRequest, category);
        category = categoryRepository.save(category);
        return categoryMapper.mapEntityToResponse(category);
    }

    @Transactional
    public void delete(Long categoryId) {
        Category category = getNotNullEntity(categoryId);
        categoryRepository.delete(category);
    }

    private Category getEntity(Long categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    private Category getNotNullEntity(Long categoryId) {
        Category category = getEntity(categoryId);
        if (Objects.isNull(category)) {
            throw new DataNotFoundException("category[id=%s] not found", categoryId);
        }
        return category;
    }

}
