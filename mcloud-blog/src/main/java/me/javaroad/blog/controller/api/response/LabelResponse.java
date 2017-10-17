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
public class LabelResponse {
    private Long id;
    private String name;
}
