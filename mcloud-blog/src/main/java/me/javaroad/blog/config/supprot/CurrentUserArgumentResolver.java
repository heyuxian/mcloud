package me.javaroad.blog.config.supprot;

import java.util.Objects;
import me.javaroad.blog.config.CurrentUser;
import me.javaroad.blog.dto.response.UserResponse;
import me.javaroad.blog.service.UserService;
import me.javaroad.common.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author heyx
 */
@Component
public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final UserService userService;

    @Autowired
    public CurrentUserArgumentResolver(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String username = (String) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        // TODO getResponse User Info from OAuth2 Server
        UserResponse userResponse = userService.getResponse(username);
        if(Objects.isNull(userResponse)) {
            throw new UnauthorizedException("unauthorized");
        }
        return userResponse;
    }
}
