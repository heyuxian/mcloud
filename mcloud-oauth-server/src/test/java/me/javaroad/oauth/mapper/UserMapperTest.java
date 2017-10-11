package me.javaroad.oauth.mapper;

import static org.assertj.core.api.Java6Assertions.assertThat;

import me.javaroad.oauth.controller.api.response.UserResponse;
import me.javaroad.oauth.entity.User;
import org.junit.Test;

/**
 * @author heyx
 */
public class UserMapperTest {

    private UserMapper userMapper = UserMapper.INSTANCE;

    @Test
    public void mapEntityToResponse() throws Exception {
        User user = new User();
        user.setUsername("user");
        user.setId(1L);
        UserResponse userResponse = userMapper.mapEntityToResponse(user);
        assertThat(userResponse.getId()).isEqualTo(user.getId());
    }

}