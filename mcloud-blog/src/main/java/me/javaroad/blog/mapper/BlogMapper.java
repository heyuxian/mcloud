package me.javaroad.blog.mapper;

import me.javaroad.blog.controller.api.request.ArticleRequest;
import me.javaroad.blog.controller.api.response.ArticleResponse;
import me.javaroad.blog.controller.api.response.ArticlePageResponse;
import me.javaroad.blog.controller.api.response.CategoryResponse;
import me.javaroad.blog.controller.api.response.LabelResponse;
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

    Article articleDtoToEntity(ArticleResponse articleResponse);

    ArticleResponse articleEntityToDto(Article article);

    Article articleRequestToEntity(ArticleRequest articleRequest);

    Category categoryDtoToEntity(CategoryResponse categoryResponse);

    CategoryResponse categoryEntityToDto(Category category);

    Label labelDtoToEntity(LabelResponse labelResponse);

    LabelResponse labelEntityToDto(Label label);

    ArticlePageResponse articleEntityToPageDto(Article article);
}
