package org.blackc.blog.core.mapper;

import org.blackc.blog.core.dto.ArticleDto;
import org.blackc.blog.core.dto.ArticlePageDto;
import org.blackc.blog.core.dto.CategoryDto;
import org.blackc.blog.core.dto.ChannelDto;
import org.blackc.blog.core.dto.LabelDto;
import org.blackc.blog.core.entity.Article;
import org.blackc.blog.core.entity.Category;
import org.blackc.blog.core.entity.Channel;
import org.blackc.blog.core.entity.Label;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface BlogMapper {

    BlogMapper INSTANCE = Mappers.getMapper(BlogMapper.class);

    Article articleDtoToEntity(ArticleDto articleDto);

    ArticleDto articleEntityToDto(Article article);

    Category categoryDtoToEntity(CategoryDto categoryDto);

    CategoryDto categoryEntityToDto(Category category);

    Label labelDtoToEntity(LabelDto labelDto);

    LabelDto labelEntityToDto(Label label);

    Channel channelDtoToEntity(ChannelDto channelDto);

    ChannelDto channelEntityToDto(Channel channel);

    ArticlePageDto articleEntityToPageDto(Article article);
}
