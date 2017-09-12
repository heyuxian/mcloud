package me.javaroad.blog.core.repository;

import java.util.List;
import me.javaroad.blog.core.entity.Category;

/**
 * @author heyx
 */
public interface CategoryRepositoryCustom {

    List<Category> findByUser(String username);
}
