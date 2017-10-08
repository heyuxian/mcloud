package me.javaroad.oauth.mapper;

import java.util.List;
import me.javaroad.oauth.controller.web.request.UserRequest;
import me.javaroad.oauth.controller.web.response.UserResponse;
import me.javaroad.oauth.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapRequestToEntity(UserRequest userRequest);

    UserResponse mapEntityToResponse(User user);

    List<UserResponse> mapEntityToResponse(List<User> users);
}
