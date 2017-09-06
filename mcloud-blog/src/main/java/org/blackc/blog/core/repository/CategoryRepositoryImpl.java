package org.blackc.blog.core.repository;

import java.util.List;
import org.blackc.blog.core.entity.Category;
import org.blackc.blog.core.entity.QCategory;
import org.blackc.blog.user.entity.QUser;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

/**
 * @author heyx
 */
public class CategoryRepositoryImpl extends QueryDslRepositorySupport implements CategoryRepositoryCustom {

    private QCategory category = QCategory.category;
    private QUser user = QUser.user;

    public CategoryRepositoryImpl() {
        super(Category.class);
    }

    @Override
    public List<Category> findByUser(String username) {
        return from(category)
            .innerJoin(category.user, user)
            .where(user.username.eq(username))
            .fetch();
    }
}
