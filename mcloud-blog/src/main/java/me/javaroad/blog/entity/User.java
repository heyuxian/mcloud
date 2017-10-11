package me.javaroad.blog.entity;

import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
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
@Table(name = "blog_user")
public class User extends TemporalEntity {
    private String username;
    private String password;
    private String nickname;
    private String avatar;
    @ManyToMany
    @JoinTable(name = "sys_user_authority")
    private Set<Authority> authorities = new TreeSet<>();

}
