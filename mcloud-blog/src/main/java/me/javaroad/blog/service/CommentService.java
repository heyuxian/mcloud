package me.javaroad.blog.service;

import me.javaroad.blog.dto.request.CommentRequest;
import me.javaroad.blog.dto.response.CommentResponse;
import me.javaroad.blog.entity.Article;
import me.javaroad.blog.entity.Comment;
import me.javaroad.blog.entity.User;
import me.javaroad.blog.mapper.CommentMapper;
import me.javaroad.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author heyx
 */
@Service
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final UserService userService;
    private final ArticleService articleService;

    @Autowired
    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper, UserService userService,
        ArticleService articleService) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.userService = userService;
        this.articleService = articleService;
    }

    public Page<CommentResponse> getCommentPage(Long articleId, Pageable pageable) {
        Page<Comment> commentPage = commentRepository.findByArticleId(articleId, pageable);
        return commentPage.map(commentMapper::mapEntityToResponse);
    }

    @Transactional
    public CommentResponse create(Long articleId, String username, CommentRequest commentRequest) {
        Comment comment = commentMapper.mapRequestToEntity(commentRequest);
        User user = userService.getEntity(username);
        Article article = articleService.getNotNullEntity(articleId);
        comment.setAuthor(user);
        comment.setArticle(article);
        comment = commentRepository.save(comment);
        return commentMapper.mapEntityToResponse(comment);
    }
}
