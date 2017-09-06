package org.blackc.blog.user.entity;

import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.blackc.data.entity.TemporalEntity;

/**
 * @author heyx
 */
@Getter
@Setter
@Entity
@Table(name = "blog_authority")
public class Authority extends TemporalEntity {
    private String name;
    private String description;
    @ManyToMany(mappedBy = "authorities")
    private Set<User> users = new TreeSet<>();
}
