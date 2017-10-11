package me.javaroad.blog.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import me.javaroad.data.entity.BaseEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author heyx
 */
@Getter
@Setter
@Entity
@Table(name = "blog_view_log")
@EntityListeners(AuditingEntityListener.class)
public class ViewLog extends BaseEntity {
    @ManyToOne
    private Article article;
    private String ip;
    @CreatedDate
    @Column(name = "view_date")
    private Date viewDate;
}
