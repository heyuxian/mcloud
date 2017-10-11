package me.javaroad.oauth.mapper;

import me.javaroad.oauth.controller.api.response.ClientResponse;
import me.javaroad.oauth.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientResponse mapEntityToResponse(Client client);
}
