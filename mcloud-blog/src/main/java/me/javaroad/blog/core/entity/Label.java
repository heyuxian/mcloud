package me.javaroad.blog.core.entity;

import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
@Table(name = "blog_label")
public class Label extends TemporalEntity {

    private String name;
    @ManyToMany(mappedBy = "labels")
    private Set<Article> articles = new TreeSet<>();
    //是否是全局标签,global=false代表是用户自定义标签
    private Boolean global;
}
