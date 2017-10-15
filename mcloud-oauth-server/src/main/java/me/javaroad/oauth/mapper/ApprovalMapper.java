package me.javaroad.oauth.mapper;

import java.util.List;
import java.util.Set;
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

    List<ApprovalResponse> mapEntityToResponse(List<Approval> approvals);

    Set<ApprovalResponse> mapEntityToResponse(Set<Approval> approvals);
}
