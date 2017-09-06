package org.blackc.blog.core.entity;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author heyx
 */
@Getter
@Setter
@Embeddable
public class ArticleStatistic {
    private Long readCount;
    private Long commentCount;
}
