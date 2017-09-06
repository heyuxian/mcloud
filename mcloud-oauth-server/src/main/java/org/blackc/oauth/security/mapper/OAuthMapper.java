package org.blackc.oauth.security.mapper;

import org.blackc.oauth.security.controller.api.request.OAuthApprovalRequest;
import org.blackc.oauth.security.controller.api.request.OAuthClientRequest;
import org.blackc.oauth.security.dto.ApprovalDto;
import org.blackc.oauth.security.dto.AuthorityDto;
import org.blackc.oauth.security.dto.ClientDto;
import org.blackc.oauth.security.dto.ResourceDto;
import org.blackc.oauth.security.dto.ScopeDto;
import org.blackc.oauth.security.entity.OAuthApproval;
import org.blackc.oauth.security.entity.OAuthAuthority;
import org.blackc.oauth.security.entity.OAuthClient;
import org.blackc.oauth.security.entity.OAuthResource;
import org.blackc.oauth.security.entity.OAuthScope;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface OAuthMapper {

    OAuthMapper INSTANCE = Mappers.getMapper(OAuthMapper.class);

    ClientDto mapClientEntityToDto(OAuthClient client);

    OAuthClient mapClientDtoToEntity(ClientDto clientDto);

    @Mappings({
        @Mapping(target = "id", ignore = true)
    })
    OAuthClient mapClientRequestToEntity(OAuthClientRequest clientRequest);

    ResourceDto mapResourceEntityToDto(OAuthResource resource);

    OAuthResource mapResourceDtoToEntity(ResourceDto resourceDto);

    AuthorityDto mapAuthorityEntityToDto(OAuthAuthority authority);

    OAuthAuthority mapAuthorityDtoToEntity(AuthorityDto authorityDto);

    ApprovalDto mapApprovalEntityToDto(OAuthApproval approval);

    OAuthApproval mapApprovalDtoToEntity(ApprovalDto approvalDto);

    OAuthApproval mapApprovalDtoToEntity(OAuthApprovalRequest approvalRequest);

    ScopeDto mapScopeEntityToDto(OAuthScope scope);

    OAuthScope mapScopeDtoToEntity(ScopeDto scopeDto);
}
