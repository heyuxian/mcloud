package me.javaroad.oauth.security.controller.api;

import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import me.javaroad.oauth.security.controller.OAuthConstants;
import me.javaroad.oauth.security.service.OAuthResourceService;
import me.javaroad.oauth.security.dto.ResourceDto;
import me.javaroad.oauth.security.entity.OAuthResource;
import me.javaroad.oauth.security.mapper.OAuthMapper;
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
@RequestMapping(OAuthConstants.API_PREFIX + "/resources")
public class ResourceController {

    private final OAuthResourceService resourceService;
    private final OAuthMapper mapper;

    @Autowired
    public ResourceController(OAuthResourceService resourceService, OAuthMapper mapper) {
        this.resourceService = resourceService;
        this.mapper = mapper;
    }

    @ApiOperation(value = "创建resource", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResourceDto createResource(@RequestBody @Valid ResourceDto resourceDto) {
        OAuthResource resource = resourceService.createResource(resourceDto);
        return mapper.mapResourceEntityToDto(resource);
    }

    @ApiOperation(value = "修改resource", httpMethod = "PUT")
    @PutMapping("{resourceId}")
    public ResourceDto modifyResource(@PathVariable Long resourceId, @RequestBody @Valid ResourceDto resourceDto) {
        resourceDto.setId(resourceId);
        OAuthResource resource = resourceService.modifyResource(resourceDto);
        return mapper.mapResourceEntityToDto(resource);
    }

    @ApiOperation(value = "获取resource", httpMethod = "GET")
    @GetMapping("{resourceId}")
    public ResourceDto modifyResource(@PathVariable Long resourceId) {
        OAuthResource resource = resourceService.getResource(resourceId);
        return mapper.mapResourceEntityToDto(resource);
    }

    @ApiOperation(value = "删除resource", httpMethod = "DELETE")
    @DeleteMapping("{resourceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteResource(@PathVariable Long resourceId) {
        resourceService.deleteResource(resourceId);
    }
}
