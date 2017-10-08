package me.javaroad.oauth.controller.web;

import java.util.List;
import javax.validation.Valid;
import me.javaroad.oauth.controller.web.request.SearchUserRequest;
import me.javaroad.oauth.controller.web.request.UserRequest;
import me.javaroad.oauth.controller.web.response.DataTableResponse;
import me.javaroad.oauth.controller.web.response.UserResponse;
import me.javaroad.oauth.entity.User;
import me.javaroad.oauth.mapper.UserMapper;
import me.javaroad.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author heyx
 */
@Controller
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "user/edit";
    }

    @GetMapping("view/{userId}")
    public String view(@PathVariable Long userId, Model model) {
        User user = userService.get(userId);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @DeleteMapping("{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }

    @PostMapping("createOrUpdate")
    public String createOrUpdate(@Valid UserRequest userRequest, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors().get(0).getDefaultMessage());
            return "error/validationFail";
        }
        User user = userService.createOrUpdate(userRequest);
        model.addAttribute("user", userMapper.mapEntityToResponse(user));
        return "user/edit";
    }

    @GetMapping("list")
    public String list() {
        return "user/list";
    }

    @GetMapping
    @ResponseBody
    public DataTableResponse ajaxList(SearchUserRequest searchUserRequest,
        @PageableDefault Pageable pageable, @RequestParam(required = false) Long draw) {
        Page<User> users = userService.getAll(searchUserRequest, pageable);
        List<UserResponse> userResponseList = userMapper.mapEntityToResponse(users.getContent());
        return new DataTableResponse<>(userResponseList, users.getTotalElements(), draw);
    }
}
