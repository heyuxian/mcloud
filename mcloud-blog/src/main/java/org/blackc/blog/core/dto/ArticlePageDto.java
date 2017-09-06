package org.blackc.blog.core.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
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
public class ArticlePageDto {
    private Long id;
    private String title;
    private String summary;
    private Integer sort;

    @Default
    private Set<CategoryDto> categories = new LinkedHashSet<>();
    @Default
    private Set<LabelDto> labels = new HashSet<>();
    private ChannelDto channel;

    private Date createDate;
    private Date modifiedDate;
}
