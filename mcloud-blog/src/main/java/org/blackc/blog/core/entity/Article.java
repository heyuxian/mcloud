package org.blackc.blog.core.entity;

import java.util.List;
import java.util.Set;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.blackc.blog.user.entity.User;
import org.blackc.data.entity.TemporalEntity;

/**
 * @author heyx
 */
@Getter
@Setter
@Entity
@Table(name = "blog_article")
public class Article extends TemporalEntity {
    private String title;
    private String content;
    private String summary;
    private Integer sort;
    @Embedded
    private Seo seo;
    @Embedded
    private ArticleStatistic statistic;
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;
    @ManyToMany
    @JoinTable(
        name = "blog_article_category",
        joinColumns = {@JoinColumn(name = "article_id")},
        inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> categories;
    @ManyToOne(fetch = FetchType.LAZY)
    private Channel channel;
    @OneToMany(mappedBy = "article")
    private List<Comment> comments;
    @ManyToMany
    @JoinTable(
        name = "blog_article_label",
        joinColumns = {@JoinColumn(name = "article_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "label_id", referencedColumnName = "id")})
    private Set<Label> labels;
}
