package me.javaroad.blog.controller.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author heyx
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse implements Comparable<CategoryResponse> {
    private Long id;
    private String name;

    @Override
    public int compareTo(CategoryResponse o) {
        return 0;
    }
}
