package me.javaroad.oauth.controller.api.response;

import java.time.LocalDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import me.javaroad.oauth.entity.Approval.ApprovalStatus;

/**
 * @author heyx
 */
@Getter
@Setter
public class ApprovalResponse {
    private String name;
    private Long clientId;
    private Set<Long> scopeIds;
    private ApprovalStatus status;
    private LocalDateTime expiresAt;
}
