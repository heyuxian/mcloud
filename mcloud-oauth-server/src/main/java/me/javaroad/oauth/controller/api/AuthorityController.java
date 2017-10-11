package me.javaroad.oauth.controller.api;

import static me.javaroad.oauth.controller.OAuthConstants.API_PREFIX;

import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import me.javaroad.oauth.controller.api.request.AuthorityRequest;
import me.javaroad.oauth.controller.api.response.AuthorityResponse;
import me.javaroad.oauth.entity.Authority;
import me.javaroad.oauth.mapper.AuthorityMapper;
import me.javaroad.oauth.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping(API_PREFIX + "/authorities")
public class AuthorityController {

    private final AuthorityService authorityService;
    private final AuthorityMapper authorityMapper;

    @Autowired
    public AuthorityController(AuthorityService authorityService, AuthorityMapper authorityMapper) {
        this.authorityService = authorityService;
        this.authorityMapper = authorityMapper;
    }

    @ApiOperation(value = "Create Authority", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorityResponse createAuthority(@RequestBody @Valid AuthorityRequest authorityRequest) {
        Authority authority = authorityService.createAuthority(authorityRequest);
        return authorityMapper.mapEntityToResponse(authority);
    }
}
