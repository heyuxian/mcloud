package me.javaroad.mcloud.apigw.mapper;

import me.javaroad.mcloud.apigw.dto.AuthDto;
import me.javaroad.mcloud.apigw.web.response.AuthResponse;
import org.mapstruct.Mapper;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface AuthMapper {

    AuthResponse toResponse(AuthDto authDto);
}
