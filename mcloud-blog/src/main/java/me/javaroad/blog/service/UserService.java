package me.javaroad.blog.service;

import me.javaroad.blog.dto.response.UserResponse;
import me.javaroad.blog.entity.User;
import me.javaroad.blog.mapper.UserMapper;
import me.javaroad.blog.repository.UserRepository;
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

    public UserResponse get(String username) {
        User user = userRepository.findByUsername(username);
        return userMapper.mapEntityToResponse(user);
    }

    User getUser(Long userId) {
        return userRepository.findOne(userId);
    }
}
