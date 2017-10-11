package me.javaroad.blog.mapper;

import me.javaroad.blog.dto.ArticlePageDto;
import me.javaroad.blog.entity.Channel;
import me.javaroad.blog.dto.ArticleDto;
import me.javaroad.blog.dto.CategoryDto;
import me.javaroad.blog.dto.ChannelDto;
import me.javaroad.blog.dto.LabelDto;
import me.javaroad.blog.entity.Article;
import me.javaroad.blog.entity.Category;
import me.javaroad.blog.entity.Label;
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
