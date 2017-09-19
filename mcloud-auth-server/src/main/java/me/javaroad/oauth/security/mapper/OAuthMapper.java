package me.javaroad.oauth.security.mapper;

import me.javaroad.oauth.security.dto.ApprovalDto;
import me.javaroad.oauth.security.dto.ResourceDto;
import me.javaroad.oauth.security.dto.ScopeDto;
import me.javaroad.oauth.security.entity.OAuthAuthority;
import me.javaroad.oauth.security.entity.OAuthScope;
import me.javaroad.oauth.security.controller.api.request.OAuthApprovalRequest;
import me.javaroad.oauth.security.controller.api.request.OAuthClientRequest;
import me.javaroad.oauth.security.dto.AuthorityDto;
import me.javaroad.oauth.security.dto.ClientDto;
import me.javaroad.oauth.security.entity.OAuthApproval;
import me.javaroad.oauth.security.entity.OAuthClient;
import me.javaroad.oauth.security.entity.OAuthResource;
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
