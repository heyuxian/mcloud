package org.blackc.blog.core.repository;

import java.util.List;
import org.blackc.blog.core.entity.Category;

/**
 * @author heyx
 */
public interface CategoryRepositoryCustom {

    List<Category> findByUser(String username);
}
