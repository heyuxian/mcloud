package me.javaroad.oauth.service;

import java.util.Set;
import me.javaroad.oauth.controller.web.request.ResourceRequest;
import me.javaroad.oauth.entity.Resource;
import me.javaroad.oauth.mapper.ResourceMapper;
import me.javaroad.oauth.repository.ResourceRepository;
import me.javaroad.oauth.dto.ResourceDto;
import me.javaroad.oauth.mapper.OAuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author heyx
 */
@Service
@Transactional(readOnly = true)
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper mapper;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository, ResourceMapper mapper) {
        this.resourceRepository = resourceRepository;
        this.mapper = mapper;
    }

    public Resource getResource(Long resourceId) {
        return resourceRepository.findOne(resourceId);
    }

    @Transactional
    public Resource createResource(ResourceRequest resourceRequest) {
        Resource resource = mapper.mapRequestToEntity(resourceRequest);
        return resourceRepository.save(resource);
    }

    @Transactional
    public Resource modifyResource(ResourceRequest resourceRequest) {
        Resource resource = mapper.mapRequestToEntity(resourceRequest);
        return resourceRepository.save(resource);
    }

    @Transactional
    public void deleteResource(Long resourceId) {
        resourceRepository.delete(resourceId);
    }

    public Set<Resource> getResourceByIds(Set<Long> resourceIds) {
        return resourceRepository.findByIdIn(resourceIds);
    }
}
