package me.javaroad.oauth.controller.web;

import javax.validation.Valid;
import me.javaroad.oauth.controller.web.request.ScopeRequest;
import me.javaroad.oauth.controller.web.response.ScopeResponse;
import me.javaroad.oauth.entity.Scope;
import me.javaroad.oauth.mapper.ScopeMapper;
import me.javaroad.oauth.service.ScopeService;
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
@RequestMapping("scopes")
public class ScopeController {

    private final ScopeService scopeService;
    private final ScopeMapper scopeMapper;

    @Autowired
    public ScopeController(ScopeService scopeService, ScopeMapper scopeMapper) {
        this.scopeService = scopeService;
        this.scopeMapper = scopeMapper;
    }

    @GetMapping("create")
    public String create() {
        return "create";
    }

    @PostMapping
    @ResponseBody
    public ScopeResponse createScope(@Valid ScopeRequest scopeRequest) {
        Scope scope = scopeService.createScope(scopeRequest);
        return scopeMapper.mapEntityToResponse(scope);
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
