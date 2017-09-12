package me.javaroad.blog.core.entity;

import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name = "blog_chanel")
public class Channel extends TemporalEntity {
    private String name;
    private String description;
    @OneToMany(mappedBy = "channel")
    private Set<Article> articles = new TreeSet<>();
}
