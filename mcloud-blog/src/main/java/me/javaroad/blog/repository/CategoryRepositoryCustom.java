package me.javaroad.blog.repository;

import java.util.List;
import me.javaroad.blog.entity.Category;

/**
 * @author heyx
 */
public interface CategoryRepositoryCustom {

    List<Category> findByUser(String username);
}
