package me.javaroad.blog.core.mapper;

import static org.assertj.core.api.Java6Assertions.assertThat;

import me.javaroad.blog.core.mapper.data.MockData;
import me.javaroad.blog.core.dto.ArticleDto;
import me.javaroad.blog.core.entity.Article;
import org.junit.Test;

/**
 * @author heyx
 */
public class BlogMapperTest {

    @Test
    public void dtoToEntity() throws Exception {
        ArticleDto articleDto = MockData.makeArticleDto();
        Article article = BlogMapper.INSTANCE.articleDtoToEntity(articleDto);
        assertThat(article.getTitle()).isEqualTo(articleDto.getTitle());
    }

}