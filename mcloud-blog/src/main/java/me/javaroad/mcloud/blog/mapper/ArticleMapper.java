package me.javaroad.mcloud.blog.mapper;

import me.javaroad.mcloud.blog.dto.request.ArticleRequest;
import me.javaroad.mcloud.blog.dto.response.ArticlePageResponse;
import me.javaroad.mcloud.blog.dto.response.ArticleResponse;
import me.javaroad.mcloud.blog.entity.Article;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring", uses = {
    CategoryMapper.class,
    CommentMapper.class,
    LabelMapper.class
})
public interface ArticleMapper {

    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    Article mapRequestToEntity(ArticleRequest articleRequest);

    ArticleResponse mapEntityToResponse(Article article);

    ArticlePageResponse mapEntityToPageResponse(Article article);
}
