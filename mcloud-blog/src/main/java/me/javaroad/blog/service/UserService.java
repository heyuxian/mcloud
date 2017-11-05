package me.javaroad.blog.service;

import java.util.Objects;
import me.javaroad.blog.dto.response.UserResponse;
import me.javaroad.blog.entity.User;
import me.javaroad.blog.mapper.UserMapper;
import me.javaroad.blog.repository.UserRepository;
import me.javaroad.common.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author heyx
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse getResponse(String username) {
        User user = getEntity(username);
        return userMapper.mapEntityToResponse(user);
    }

    User getEntity(Long userId) {
        return userRepository.findOne(userId);
    }

    User getNotNullEntity(Long userId) {
        User user = getEntity(userId);
        if (Objects.isNull(user)) {
            throw new DataNotFoundException("user[id=%s] not found", user);
        }
        return user;
    }

    User getEntity(String username) {
        return userRepository.findByUsername(username);
    }
}
