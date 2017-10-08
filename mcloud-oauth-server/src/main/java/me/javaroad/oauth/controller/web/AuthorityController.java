package me.javaroad.oauth.controller.web;

import javax.validation.Valid;
import me.javaroad.oauth.controller.web.request.AuthorityRequest;
import me.javaroad.oauth.controller.web.response.AuthorityResponse;
import me.javaroad.oauth.entity.Authority;
import me.javaroad.oauth.mapper.AuthorityMapper;
import me.javaroad.oauth.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author heyx
 */
@Controller
@RequestMapping("authority")
public class AuthorityController {

    private final AuthorityService authorityService;
    private final AuthorityMapper authorityMapper;

    @Autowired
    public AuthorityController(AuthorityService authorityService, AuthorityMapper authorityMapper) {
        this.authorityService = authorityService;
        this.authorityMapper = authorityMapper;
    }

    @GetMapping("create")
    public String create() {
        return "create";
    }

    @PostMapping("create")
    @ResponseBody
    public AuthorityResponse createAuthority(@Valid AuthorityRequest authorityRequest) {
        Authority authority = authorityService.createAuthority(authorityRequest);
        return authorityMapper.mapEntityToResponse(authority);
    }

    @GetMapping("edit")
    public String edit() {
        return "edit";
    }

    @GetMapping("list")
    public String list() {
        return "list";
    }
}
