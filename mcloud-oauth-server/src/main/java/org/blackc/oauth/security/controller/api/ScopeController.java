package org.blackc.oauth.security.controller.api;

import static org.blackc.oauth.security.controller.OAuthConstants.API_PREFIX;

import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.blackc.oauth.security.dto.ScopeDto;
import org.blackc.oauth.security.entity.OAuthScope;
import org.blackc.oauth.security.mapper.OAuthMapper;
import org.blackc.oauth.security.service.OAuthScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping(API_PREFIX + "/scopes")
public class ScopeController {

    private final OAuthScopeService scopeService;
    private final OAuthMapper mapper;

    @Autowired
    public ScopeController(OAuthScopeService scopeService, OAuthMapper mapper) {
        this.scopeService = scopeService;
        this.mapper = mapper;
    }

    @ApiOperation(value = "创建scope", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScopeDto createScope(@RequestBody @Valid ScopeDto scopeDto) {
        OAuthScope scope = scopeService.createScope(scopeDto);
        return mapper.mapScopeEntityToDto(scope);
    }

    @ApiOperation(value = "修改scope", httpMethod = "PUT")
    @PutMapping("{scopeId}")
    public ScopeDto modifyScope(@PathVariable Long scopeId, @RequestBody @Valid ScopeDto scopeDto) {
        scopeDto.setId(scopeId);
        OAuthScope scope = scopeService.modifyScope(scopeDto);
        return mapper.mapScopeEntityToDto(scope);
    }

    @ApiOperation(value = "获取scope", httpMethod = "GET")
    @GetMapping("{scopeId}")
    public ScopeDto modifyScope(@PathVariable Long scopeId) {
        OAuthScope scope = scopeService.getScope(scopeId);
        return mapper.mapScopeEntityToDto(scope);
    }

    @ApiOperation(value = "删除scope", httpMethod = "DELETE")
    @DeleteMapping("{scopeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteScope(@PathVariable Long scopeId) {
        scopeService.deleteScope(scopeId);
    }
}
