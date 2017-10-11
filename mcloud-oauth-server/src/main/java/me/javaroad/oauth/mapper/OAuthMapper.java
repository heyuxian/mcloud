package me.javaroad.oauth.mapper;

import me.javaroad.oauth.controller.api.request.ClientRequest;
import me.javaroad.oauth.dto.ApprovalDto;
import me.javaroad.oauth.dto.ResourceDto;
import me.javaroad.oauth.dto.ScopeDto;
import me.javaroad.oauth.entity.Approval;
import me.javaroad.oauth.entity.Authority;
import me.javaroad.oauth.entity.Client;
import me.javaroad.oauth.entity.Scope;
import me.javaroad.oauth.controller.api.request.ApprovalRequest;
import me.javaroad.oauth.dto.AuthorityDto;
import me.javaroad.oauth.dto.ClientDto;
import me.javaroad.oauth.entity.Resource;
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

    ClientDto mapClientEntityToDto(Client client);

    Client mapClientDtoToEntity(ClientDto clientDto);

    @Mappings({
        @Mapping(target = "id", ignore = true)
    })
    Client mapClientRequestToEntity(ClientRequest clientRequest);

    ResourceDto mapResourceEntityToDto(Resource resource);

    Resource mapResourceDtoToEntity(ResourceDto resourceDto);

    AuthorityDto mapAuthorityEntityToDto(Authority authority);

    Authority mapAuthorityDtoToEntity(AuthorityDto authorityDto);

    ApprovalDto mapApprovalEntityToDto(Approval approval);

    Approval mapApprovalDtoToEntity(ApprovalDto approvalDto);

    Approval mapApprovalDtoToEntity(ApprovalRequest approvalRequest);

    ScopeDto mapScopeEntityToDto(Scope scope);

    Scope mapScopeDtoToEntity(ScopeDto scopeDto);
}
