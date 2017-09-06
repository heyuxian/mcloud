package org.blackc.blog.core.repository;

import org.blackc.blog.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author heyx
 */
public class ArticleRepositoryTest extends BaseSpringTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void findAll() {
        articleRepository.findAll();
    }
}