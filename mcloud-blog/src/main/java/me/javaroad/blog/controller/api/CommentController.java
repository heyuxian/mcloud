package me.javaroad.blog.controller.api;

import me.javaroad.blog.controller.ApiConstants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping(ApiConstants.API_VERSION + "/users/{username}/articles/{articleId}/comments")
public class CommentController {

}
