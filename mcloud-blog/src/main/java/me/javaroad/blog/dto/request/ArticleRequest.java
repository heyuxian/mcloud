package me.javaroad.blog.dto.request;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.validation.constraints.Size;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author heyx
 */
@Getter
@Setter
public class ArticleRequest {
    private Long id;
    @NotBlank
    @Size(max = 100)
    private String title;
    @NotBlank
    private String content;
    @Size(max = 250)
    private String summary;
    @NotBlank
    @Size(max = 100)
    private String seoTitle;
    @NotBlank
    @Size(max = 100)
    private String seoKeywords;
    @NotBlank
    @Size(max = 250)
    private String seoDescription;
    private Integer sort;
    @NotEmpty
    @Default
    private Set<Long> categoryIds = new LinkedHashSet<>();
    @NotEmpty
    @Default
    private Set<Long> labelIds = new HashSet<>();
}
