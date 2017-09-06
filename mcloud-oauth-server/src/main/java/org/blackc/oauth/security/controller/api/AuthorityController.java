package org.blackc.oauth.security.controller.api;

import static org.blackc.oauth.security.controller.OAuthConstants.API_PREFIX;

import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.blackc.oauth.security.dto.AuthorityDto;
import org.blackc.oauth.security.entity.OAuthAuthority;
import org.blackc.oauth.security.mapper.OAuthMapper;
import org.blackc.oauth.security.service.OAuthAuthorityService;
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
@RequestMapping(API_PREFIX + "/authoritys")
public class AuthorityController {

    private final OAuthAuthorityService authorityService;
    private final OAuthMapper mapper;

    @Autowired
    public AuthorityController(OAuthAuthorityService authorityService, OAuthMapper mapper) {
        this.authorityService = authorityService;
        this.mapper = mapper;
    }

    @ApiOperation(value = "创建authority", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorityDto createAuthority(@RequestBody @Valid AuthorityDto authorityDto) {
        OAuthAuthority authority = authorityService.createAuthority(authorityDto);
        return mapper.mapAuthorityEntityToDto(authority);
    }

    @ApiOperation(value = "修改authority", httpMethod = "PUT")
    @PutMapping("{authorityId}")
    public AuthorityDto modifyAuthority(@PathVariable Long authorityId, @RequestBody @Valid AuthorityDto authorityDto) {
        authorityDto.setId(authorityId);
        OAuthAuthority authority = authorityService.modifyAuthority(authorityDto);
        return mapper.mapAuthorityEntityToDto(authority);
    }

    @ApiOperation(value = "获取authority", httpMethod = "GET")
    @GetMapping("{authorityId}")
    public AuthorityDto modifyAuthority(@PathVariable Long authorityId) {
        OAuthAuthority authority = authorityService.getAuthority(authorityId);
        return mapper.mapAuthorityEntityToDto(authority);
    }

    @ApiOperation(value = "删除authority", httpMethod = "DELETE")
    @DeleteMapping("{authorityId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthority(@PathVariable Long authorityId) {
        authorityService.deleteAuthority(authorityId);
    }
}
