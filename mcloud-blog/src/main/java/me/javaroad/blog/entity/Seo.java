package me.javaroad.blog.entity;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author heyx
 */
@Getter
@Setter
@Embeddable
public class Seo {
    private String seoTitle;
    private String seoKeywords;
    private String seoDescription;
}
