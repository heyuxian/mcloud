package me.javaroad.blog.entity;

import javax.persistence.Entity;
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
@Table(name = "blog_user")
public class User extends TemporalEntity {
    private String username;
    private String nickname;
    private String avatar;
}
