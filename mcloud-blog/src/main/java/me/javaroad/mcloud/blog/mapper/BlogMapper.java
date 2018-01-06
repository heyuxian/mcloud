package me.javaroad.mcloud.blog.mapper;

import me.javaroad.mcloud.blog.dto.request.ArticleRequest;
import me.javaroad.mcloud.blog.dto.response.ArticleResponse;
import me.javaroad.mcloud.blog.dto.response.ArticlePageResponse;
import me.javaroad.mcloud.blog.dto.response.CategoryResponse;
import me.javaroad.mcloud.blog.dto.response.LabelResponse;
import me.javaroad.mcloud.blog.entity.Article;
import me.javaroad.mcloud.blog.entity.Category;
import me.javaroad.mcloud.blog.entity.Label;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface BlogMapper {

    BlogMapper INSTANCE = Mappers.getMapper(BlogMapper.class);

    Article articleDtoToEntity(ArticleResponse articleResponse);

    ArticleResponse articleEntityToDto(Article article);

    Article articleRequestToEntity(ArticleRequest articleRequest);

    Category categoryDtoToEntity(CategoryResponse categoryResponse);

    CategoryResponse categoryEntityToDto(Category category);

    Label labelDtoToEntity(LabelResponse labelResponse);

    LabelResponse labelEntityToDto(Label label);

    ArticlePageResponse articleEntityToPageDto(Article article);
}
