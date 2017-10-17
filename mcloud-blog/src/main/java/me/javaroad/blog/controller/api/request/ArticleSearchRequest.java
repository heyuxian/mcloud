package me.javaroad.blog.controller.api.request;

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
public class ArticleSearchRequest {

    private String username;
    private Long categoryId;
    private Long labelId;

}
