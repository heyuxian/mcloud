package me.javaroad.blog.config;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author heyx
 */
@Component
public class PageArgumentResolver implements HandlerMethodArgumentResolver {
    @Value("${blog.default.page:1}")
    private Integer defaultPage;
    @Value("${blog.default.size:10}")
    private Integer defaultSize;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Pageable.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String pageParam = webRequest.getNativeRequest(HttpServletRequest.class).getParameter("page");
        String sizeParam = webRequest.getNativeRequest(HttpServletRequest.class).getParameter("size");
        try {
            Integer page = Integer.valueOf(pageParam);
            Integer size = Integer.valueOf(sizeParam);
            return new PageRequest(page - 1, size);
        } catch (Exception e) {
            return new PageRequest(defaultPage - 1, defaultSize);
        }
    }
}
