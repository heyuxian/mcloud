package me.javaroad.blog.core.service;

import java.util.List;
import me.javaroad.blog.core.repository.CategoryRepository;
import me.javaroad.blog.core.entity.Category;
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

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(String username) {
        return categoryRepository.findByUser(username);
    }
}
