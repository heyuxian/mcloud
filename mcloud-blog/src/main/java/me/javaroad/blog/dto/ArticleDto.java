package me.javaroad.blog.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author heyx
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDto {
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
    private Set<CategoryDto> categories = new LinkedHashSet<>();
    @NotEmpty
    @Default
    private Set<LabelDto> labels = new HashSet<>();
    @NotNull
    private ChannelDto channel;

    private Date createDate;
    private Date modifiedDate;
}
