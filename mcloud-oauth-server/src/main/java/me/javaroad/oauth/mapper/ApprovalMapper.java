package me.javaroad.oauth.mapper;

import me.javaroad.oauth.controller.api.response.ApprovalResponse;
import me.javaroad.oauth.entity.Approval;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface ApprovalMapper {
    ApprovalMapper INSTANCE = Mappers.getMapper(ApprovalMapper.class);

    ApprovalResponse mapEntityToResponse(Approval approval);
}
