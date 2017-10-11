package me.javaroad.oauth.controller.api;

import static me.javaroad.oauth.controller.OAuthConstants.API_PREFIX;

import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import me.javaroad.oauth.controller.api.request.ScopeRequest;
import me.javaroad.oauth.controller.api.response.ScopeResponse;
import me.javaroad.oauth.entity.Scope;
import me.javaroad.oauth.mapper.ScopeMapper;
import me.javaroad.oauth.service.ScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author heyx
 */
@Controller
@RequestMapping(API_PREFIX+"/scopes")
public class ScopeController {

    private final ScopeService scopeService;
    private final ScopeMapper scopeMapper;

    @Autowired
    public ScopeController(ScopeService scopeService, ScopeMapper scopeMapper) {
        this.scopeService = scopeService;
        this.scopeMapper = scopeMapper;
    }

    @ApiOperation(value = "Create Scope", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScopeResponse createScope(@RequestBody @Valid ScopeRequest scopeRequest) {
        Scope scope = scopeService.createScope(scopeRequest);
        return scopeMapper.mapEntityToResponse(scope);
    }

}
