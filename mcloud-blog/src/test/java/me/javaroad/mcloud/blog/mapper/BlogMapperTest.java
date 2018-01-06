package me.javaroad.mcloud.blog.mapper;

import static org.assertj.core.api.Java6Assertions.assertThat;

import me.javaroad.mcloud.blog.dto.response.ArticleResponse;
import me.javaroad.mcloud.blog.mapper.data.MockData;
import me.javaroad.mcloud.blog.entity.Article;
import org.junit.Test;

/**
 * @author heyx
 */
public class BlogMapperTest {

    @Test
    public void dtoToEntity() throws Exception {
        ArticleResponse articleResponse = MockData.makeArticleDto();
        Article article = BlogMapper.INSTANCE.articleDtoToEntity(articleResponse);
        assertThat(article.getTitle()).isEqualTo(articleResponse.getTitle());
    }

}