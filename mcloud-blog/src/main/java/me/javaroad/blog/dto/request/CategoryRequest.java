package me.javaroad.blog.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author heyx
 */
@Getter
@Setter
public class CategoryRequest {
    private String name;
    private Integer sort;
}
