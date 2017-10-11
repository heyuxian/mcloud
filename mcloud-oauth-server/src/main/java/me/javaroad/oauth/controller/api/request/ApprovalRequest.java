package me.javaroad.oauth.controller.api.request;

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
public class ApprovalRequest {
    private Long id;
    private String name;
    private Long clientId;
    private Set<Long> scopeIds;
    private ApprovalStatus status;
    private LocalDateTime expiresAt;
}
