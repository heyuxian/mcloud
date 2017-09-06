package org.blackc.blog.core.repository;

import org.blackc.blog.core.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryCustom {

}
