package org.blackc.blog.core.dto;

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
public class CategoryDto implements Comparable<CategoryDto> {
    private Long id;
    private String name;

    @Override
    public int compareTo(CategoryDto o) {
        return 0;
    }
}
