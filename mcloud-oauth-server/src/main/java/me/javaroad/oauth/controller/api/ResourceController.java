package me.javaroad.oauth.controller.api;

import static me.javaroad.oauth.controller.OAuthConstants.API_PREFIX;

import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import me.javaroad.oauth.controller.api.request.ResourceRequest;
import me.javaroad.oauth.controller.api.response.ResourceResponse;
import me.javaroad.oauth.entity.Resource;
import me.javaroad.oauth.mapper.ResourceMapper;
import me.javaroad.oauth.service.ResourceService;
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
@RequestMapping(API_PREFIX + "/resources")
public class ResourceController {

    private final ResourceService resourceService;
    private final ResourceMapper resourceMapper;

    @Autowired
    public ResourceController(ResourceService resourceService, ResourceMapper resourceMapper) {
        this.resourceService = resourceService;
        this.resourceMapper = resourceMapper;
    }

    @ApiOperation(value = "Create Resource", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResourceResponse createResource(@RequestBody @Valid ResourceRequest resourceRequest) {
        Resource resource = resourceService.createResource(resourceRequest);
        return resourceMapper.mapEntityToResponse(resource);
    }

}
