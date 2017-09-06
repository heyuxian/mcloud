package org.blackc.oauth.security.service;

import java.util.Set;
import org.blackc.oauth.security.dto.AuthorityDto;
import org.blackc.oauth.security.entity.OAuthAuthority;
import org.blackc.oauth.security.mapper.OAuthMapper;
import org.blackc.oauth.security.repository.OAuthAuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author heyx
 */
@Service
@Transactional(readOnly = true)
public class OAuthAuthorityService {

    private final OAuthAuthorityRepository authorityRepository;
    private final OAuthMapper mapper;

    @Autowired
    public OAuthAuthorityService(OAuthAuthorityRepository authorityRepository, OAuthMapper mapper) {
        this.authorityRepository = authorityRepository;
        this.mapper = mapper;
    }

    public OAuthAuthority getAuthority(Long authorityId) {
        return authorityRepository.findOne(authorityId);
    }

    @Transactional
    public OAuthAuthority createAuthority(AuthorityDto authorityDto) {
        OAuthAuthority authority = mapper.mapAuthorityDtoToEntity(authorityDto);
        return authorityRepository.save(authority);
    }

    @Transactional
    public OAuthAuthority modifyAuthority(AuthorityDto authorityDto) {
        OAuthAuthority authority = mapper.mapAuthorityDtoToEntity(authorityDto);
        return authorityRepository.save(authority);
    }

    @Transactional
    public void deleteAuthority(Long authorityId) {
        authorityRepository.delete(authorityId);
    }

    public Set<OAuthAuthority> getAuthorityByIds(Set<Long> authorityIds) {
        return authorityRepository.findByIdIn(authorityIds);
    }
}
