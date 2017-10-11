package me.javaroad.oauth.service;

import java.util.Objects;
import me.javaroad.common.exception.DataConflictException;
import me.javaroad.common.exception.DataNotFoundException;
import me.javaroad.oauth.controller.api.request.SearchUserRequest;
import me.javaroad.oauth.controller.api.request.UserRequest;
import me.javaroad.oauth.entity.User;
import me.javaroad.oauth.mapper.UserMapper;
import me.javaroad.oauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
        UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User createOrUpdate(UserRequest userRequest) {
        if(Objects.isNull(userRequest.getId())) {
            return create(userRequest);
        }
        return update(userRequest);
    }

    private User update(UserRequest userRequest) {
        User user = get(userRequest.getId());
        if (Objects.isNull(user)) {
            throw new DataNotFoundException("User[userId=%s] not found", userRequest.getId());
        }
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        return userRepository.save(user);
    }

    private User create(UserRequest userRequest) {
        User user = get(userRequest.getUsername());
        if (Objects.nonNull(user)) {
            throw new DataConflictException("User[username=%s] already exists", userRequest.getUsername());
        }
        user = userMapper.mapRequestToEntity(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        return userRepository.save(user);
    }

    public Page<User> getAll(SearchUserRequest searchUserRequest, Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User get(Long id) {
        return userRepository.findOne(id);
    }

    public User get(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public void delete(Long userId) {
        userRepository.delete(userId);
    }

}
