package me.javaroad.oauth.mapper;

import me.javaroad.oauth.controller.web.request.ScopeRequest;
import me.javaroad.oauth.controller.web.response.ScopeResponse;
import me.javaroad.oauth.entity.Scope;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface ScopeMapper {
    ScopeMapper INSTANCE = Mappers.getMapper(ScopeMapper.class);

    Scope mapRequestToEntity(ScopeRequest scopeRequest);

    ScopeResponse mapEntityToResponse(Scope scope);
}
