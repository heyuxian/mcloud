package me.javaroad.blog.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import me.javaroad.data.entity.TemporalEntity;

/**
 * @author heyx
 */
@Getter
@Setter
@Entity
@Table(name = "blog_comment")
public class Comment extends TemporalEntity {
    private String content;
    @ManyToOne
    private User author;
    @ManyToOne
    private Article article;
}
