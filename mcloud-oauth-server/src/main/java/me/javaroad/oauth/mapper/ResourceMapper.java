package me.javaroad.oauth.mapper;

import me.javaroad.oauth.controller.web.request.ResourceRequest;
import me.javaroad.oauth.controller.web.response.ResourceResponse;
import me.javaroad.oauth.entity.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface ResourceMapper {
    ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);

    Resource mapRequestToEntity(ResourceRequest resourceRequest);

    ResourceResponse mapEntityToResponse(Resource resource);
}
