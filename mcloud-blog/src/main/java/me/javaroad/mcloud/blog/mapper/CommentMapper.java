package me.javaroad.mcloud.blog.mapper;

import me.javaroad.mcloud.blog.dto.request.CommentRequest;
import me.javaroad.mcloud.blog.dto.response.CommentResponse;
import me.javaroad.mcloud.blog.entity.Comment;
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
