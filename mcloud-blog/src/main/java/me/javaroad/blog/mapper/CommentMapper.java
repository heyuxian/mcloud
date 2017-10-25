package me.javaroad.blog.mapper;

import me.javaroad.blog.dto.request.CommentRequest;
import me.javaroad.blog.dto.response.CommentResponse;
import me.javaroad.blog.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment mapRequestToEntity(CommentRequest commentRequest);

    CommentResponse mapEntityToResponse(Comment comment);

}
