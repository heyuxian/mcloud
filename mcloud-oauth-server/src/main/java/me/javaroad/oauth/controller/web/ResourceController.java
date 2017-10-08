package me.javaroad.oauth.controller.web;

import javax.validation.Valid;
import me.javaroad.oauth.controller.web.request.ResourceRequest;
import me.javaroad.oauth.controller.web.response.ResourceResponse;
import me.javaroad.oauth.entity.Resource;
import me.javaroad.oauth.mapper.ResourceMapper;
import me.javaroad.oauth.service.ResourceService;
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
@RequestMapping("resource")
public class ResourceController {

    private final ResourceService resourceService;
    private final ResourceMapper resourceMapper;

    @Autowired
    public ResourceController(ResourceService resourceService, ResourceMapper resourceMapper) {
        this.resourceService = resourceService;
        this.resourceMapper = resourceMapper;
    }

    @GetMapping("create")
    public String create() {
        return "create";
    }

    @PostMapping("create")
    @ResponseBody
    public ResourceResponse createResource(@Valid ResourceRequest resourceRequest) {
        Resource resource = resourceService.createResource(resourceRequest);
        return resourceMapper.mapEntityToResponse(resource);
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
