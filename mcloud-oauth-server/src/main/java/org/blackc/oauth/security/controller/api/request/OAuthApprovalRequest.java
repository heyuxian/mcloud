package org.blackc.oauth.security.controller.api.request;

import java.time.LocalDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.blackc.oauth.security.entity.OAuthApproval.ApprovalStatus;

/**
 * @author heyx
 */
@Getter
@Setter
public class OAuthApprovalRequest {
    private Long id;
    private String name;
    private Long clientId;
    private Set<Long> scopeIds;
    private ApprovalStatus status;
    private LocalDateTime expiresAt;
}
