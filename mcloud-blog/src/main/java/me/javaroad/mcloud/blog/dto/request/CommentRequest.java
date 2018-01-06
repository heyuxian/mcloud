package me.javaroad.mcloud.blog.dto.request;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author heyx
 */
@Getter
@Setter
public class CommentRequest {
    @NotBlank
    @Size(max = 500)
    private String content;
}
