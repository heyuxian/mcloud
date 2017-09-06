package org.blackc.oauth.security.service;

import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.blackc.common.exception.InvalidParameterException;
import org.blackc.oauth.security.controller.api.request.OAuthClientRequest;
import org.blackc.oauth.security.dto.ClientDto;
import org.blackc.oauth.security.entity.OAuthApproval;
import org.blackc.oauth.security.entity.OAuthAuthority;
import org.blackc.oauth.security.entity.OAuthClient;
import org.blackc.oauth.security.entity.OAuthResource;
import org.blackc.oauth.security.entity.OAuthScope;
import org.blackc.oauth.security.mapper.OAuthMapper;
import org.blackc.oauth.security.repository.OAuthClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @author heyx
 */
@Service
@Transactional(readOnly = true)
public class OAuthClientService {

    private final OAuthClientRepository clientRepository;
    private final OAuthMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final OAuthResourceService resourceService;
    private final OAuthApprovalService approvalService;
    private final OAuthAuthorityService authorityService;
    private final OAuthScopeService scopeService;

    @Autowired
    public OAuthClientService(OAuthClientRepository clientRepository, OAuthMapper mapper,
        PasswordEncoder passwordEncoder, OAuthResourceService resourceService, OAuthApprovalService approvalService,
        OAuthAuthorityService authorityService, OAuthScopeService scopeService) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.resourceService = resourceService;
        this.approvalService = approvalService;
        this.authorityService = authorityService;
        this.scopeService = scopeService;
    }

    public OAuthClient getClient(Long clientId) {
        return clientRepository.findOne(clientId);
    }

    @Transactional
    public OAuthClient createClient(OAuthClientRequest clientRequest) {
        OAuthClient client = mapper.mapClientRequestToEntity(clientRequest);
        client.setClientSecret(passwordEncoder.encode(clientRequest.getClientSecret()));
        setResourceToClient(client, clientRequest.getResourceIds());
        setAutoApproveToClient(client, clientRequest.getAutoApproveIds());
        setAuthorityToClient(client, clientRequest.getAuthorityIds());
        setScopeToClient(client, clientRequest.getScopeIds());
        return clientRepository.save(client);
    }

    private void setScopeToClient(OAuthClient client, Set<Long> scopeIds) {
        Set<OAuthScope> scopes = scopeService.getScopeByIds(scopeIds);
        if (CollectionUtils.isEmpty(scopes)) {
            throw new InvalidParameterException("invalid scopeIds");
        }
        client.setScope(scopes);
    }

    private void setAuthorityToClient(OAuthClient client, Set<Long> authorityIds) {
        Set<OAuthAuthority> authorities = authorityService.getAuthorityByIds(authorityIds);
        if (CollectionUtils.isEmpty(authorities)) {
            throw new InvalidParameterException("invalid authorityIds");
        }
        client.setAuthorities(authorities);
    }

    private void setAutoApproveToClient(OAuthClient client, Set<Long> autoApproveIds) {
        if (CollectionUtils.isEmpty(autoApproveIds)) {
            return;
        }
        Set<OAuthApproval> approvals = approvalService.getApprovalByIds(autoApproveIds);
        if (CollectionUtils.isEmpty(approvals)) {
            throw new InvalidParameterException("invalid autoApproveIds");
        }
        client.setAutoApprove(approvals);
    }

    private void setResourceToClient(OAuthClient client, Set<Long> clientIds) {
        Set<OAuthResource> resources = resourceService.getResourceByIds(clientIds);
        if (CollectionUtils.isEmpty(resources)) {
            throw new InvalidParameterException("invalid resourceIds");
        }
        client.setResources(resources);
    }

    @Transactional
    public OAuthClient modifyClient(ClientDto clientDto) {
        OAuthClient client = mapper.mapClientDtoToEntity(clientDto);
        if (StringUtils.isNotBlank(clientDto.getClientSecret())) {
            client.setClientSecret(passwordEncoder.encode(clientDto.getClientSecret()));
        }
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Long clientId) {
        clientRepository.delete(clientId);
    }

    public OAuthClient getClientByClientId(String clientId) {
        return clientRepository.findByClientId(clientId);
    }
}
