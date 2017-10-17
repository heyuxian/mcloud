package me.javaroad.blog.mapper;

import me.javaroad.blog.controller.api.response.UserResponse;
import me.javaroad.blog.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserResponse mapEntityToResponse(User user);
}
