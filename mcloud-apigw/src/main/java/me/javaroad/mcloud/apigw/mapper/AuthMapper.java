package me.javaroad.mcloud.apigw.mapper;

import me.javaroad.mcloud.apigw.dto.AuthDto;
import me.javaroad.mcloud.apigw.web.response.AuthResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    @Mapping(target = "roles", ignore = true)
    AuthResponse toResponse(AuthDto authDto);
}
