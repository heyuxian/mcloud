package org.blackc.oauth.security.dto;

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
public class ApprovalDto {
    private Long id;
    private String name;
    private ClientDto client;
    private Set<ScopeDto> scope;
    private ApprovalStatus status;
    private LocalDateTime expiresAt;
}
