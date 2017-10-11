package me.javaroad.blog.mapper;

import me.javaroad.blog.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User user(User user);
}
