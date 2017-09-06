package org.blackc.blog.core.mapper;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.blackc.blog.core.mapper.data.MockData.makeArticleDto;

import org.blackc.blog.core.dto.ArticleDto;
import org.blackc.blog.core.entity.Article;
import org.junit.Test;

/**
 * @author heyx
 */
public class BlogMapperTest {

    @Test
    public void dtoToEntity() throws Exception {
        ArticleDto articleDto = makeArticleDto();
        Article article = BlogMapper.INSTANCE.articleDtoToEntity(articleDto);
        assertThat(article.getTitle()).isEqualTo(articleDto.getTitle());
    }

}