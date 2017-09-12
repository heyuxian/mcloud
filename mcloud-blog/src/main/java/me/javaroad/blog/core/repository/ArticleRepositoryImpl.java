package me.javaroad.blog.core.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.JPQLQuery;
import java.util.Objects;
import me.javaroad.blog.core.entity.QLabel;
import org.apache.commons.lang3.StringUtils;
import me.javaroad.blog.core.dto.ArticleSearchRequest;
import me.javaroad.blog.core.entity.Article;
import me.javaroad.blog.core.entity.QArticle;
import me.javaroad.blog.core.entity.QCategory;
import me.javaroad.blog.core.entity.QChannel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

/**
 * @author heyx
 */
public class ArticleRepositoryImpl extends QueryDslRepositorySupport implements ArticleRepositoryCustom {

    private QArticle article = QArticle.article;
    private QCategory category = QCategory.category;
    private QLabel label = QLabel.label;
    private QChannel channel = QChannel.channel;

    public ArticleRepositoryImpl() {
        super(Article.class);
    }


    @Override
    public Page<Article> findBySearchRequest(ArticleSearchRequest searchRequest, Pageable pageable) {
        JPQLQuery<Article> query = from(article)
            .leftJoin(article.categories, category).fetchJoin()
            .leftJoin(article.labels, label).fetchJoin();

        bindSearchParam(query, searchRequest);

        QueryResults<Article> articleQueryResults = getQuerydsl()
            .applyPagination(pageable, query).fetchResults();

        return new PageImpl<>(articleQueryResults.getResults(),
            pageable, articleQueryResults.getTotal());
    }

    @Override
    public Article findByUserAndId(String username, Long articleId) {
        return from(article)
            .leftJoin(article.categories, category).fetchJoin()
            .leftJoin(article.labels, label).fetchJoin()
            .where(article.id.eq(articleId), article.author.username.eq(username))
            .fetchOne();
    }

    private void bindSearchParam(JPQLQuery<Article> query, ArticleSearchRequest searchRequest) {
        if (StringUtils.isNotBlank(searchRequest.getUsername())) {
            query.where(article.author.username.eq(searchRequest.getUsername()));
        }
        if (Objects.nonNull(searchRequest.getCategoryId())) {
            query.where(category.id.eq(searchRequest.getCategoryId()));
        }
        if (Objects.nonNull(searchRequest.getLabelId())) {
            query.where(label.id.eq(searchRequest.getLabelId()));
        }
    }
}
