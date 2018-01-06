package me.javaroad.mcloud.blog.mapper;

import me.javaroad.mcloud.blog.dto.response.UserResponse;
import me.javaroad.mcloud.blog.entity.User;
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
