package me.javaroad.mcloud.blog.repository;

import java.util.List;
import me.javaroad.mcloud.blog.entity.Category;

/**
 * @author heyx
 */
public interface CategoryRepositoryCustom {

    List<Category> findByUser(String username);
}
