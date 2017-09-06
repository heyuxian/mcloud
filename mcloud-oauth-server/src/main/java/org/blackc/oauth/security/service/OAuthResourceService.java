package org.blackc.oauth.security.service;

import java.util.Set;
import org.blackc.oauth.security.dto.ResourceDto;
import org.blackc.oauth.security.entity.OAuthResource;
import org.blackc.oauth.security.mapper.OAuthMapper;
import org.blackc.oauth.security.repository.OAuthResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author heyx
 */
@Service
@Transactional(readOnly = true)
public class OAuthResourceService {

    private final OAuthResourceRepository resourceRepository;
    private final OAuthMapper mapper;

    @Autowired
    public OAuthResourceService(OAuthResourceRepository resourceRepository, OAuthMapper mapper) {
        this.resourceRepository = resourceRepository;
        this.mapper = mapper;
    }

    public OAuthResource getResource(Long resourceId) {
        return resourceRepository.findOne(resourceId);
    }

    @Transactional
    public OAuthResource createResource(ResourceDto resourceDto) {
        OAuthResource resource = mapper.mapResourceDtoToEntity(resourceDto);
        return resourceRepository.save(resource);
    }

    @Transactional
    public OAuthResource modifyResource(ResourceDto resourceDto) {
        OAuthResource resource = mapper.mapResourceDtoToEntity(resourceDto);
        return resourceRepository.save(resource);
    }

    @Transactional
    public void deleteResource(Long resourceId) {
        resourceRepository.delete(resourceId);
    }

    public Set<OAuthResource> getResourceByIds(Set<Long> resourceIds) {
        return resourceRepository.findByIdIn(resourceIds);
    }
}
