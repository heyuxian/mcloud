package me.javaroad.oauth.service;

import java.util.Set;
import me.javaroad.oauth.controller.api.request.ScopeRequest;
import me.javaroad.oauth.entity.Scope;
import me.javaroad.oauth.mapper.ScopeMapper;
import me.javaroad.oauth.repository.ScopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author heyx
 */
@Service
@Transactional(readOnly = true)
public class ScopeService {

    private final ScopeRepository scopeRepository;
    private final ScopeMapper mapper;

    @Autowired
    public ScopeService(ScopeRepository scopeRepository, ScopeMapper mapper) {
        this.scopeRepository = scopeRepository;
        this.mapper = mapper;
    }

    public Scope getScope(Long scopeId) {
        return scopeRepository.findOne(scopeId);
    }

    @Transactional
    public Scope createScope(ScopeRequest scopeRequest) {
        Scope scope = mapper.mapRequestToEntity(scopeRequest);
        return scopeRepository.save(scope);
    }

    @Transactional
    public Scope modifyScope(ScopeRequest scopeRequest) {
        Scope scope = mapper.mapRequestToEntity(scopeRequest);
        return scopeRepository.save(scope);
    }

    @Transactional
    public void deleteScope(Long scopeId) {
        scopeRepository.delete(scopeId);
    }

    public Set<Scope> getScopeByIds(Set<Long> scopeIds) {
        return scopeRepository.findByIdIn(scopeIds);
    }
}
