package me.javaroad.oauth.security.service;

import java.util.Set;
import me.javaroad.oauth.security.dto.ApprovalDto;
import me.javaroad.oauth.security.controller.api.request.OAuthApprovalRequest;
import me.javaroad.oauth.security.entity.OAuthApproval;
import me.javaroad.oauth.security.mapper.OAuthMapper;
import me.javaroad.oauth.security.repository.OAuthApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author heyx
 */
@Service
public class OAuthApprovalService {

    private final OAuthApprovalRepository approvalRepository;
    private final OAuthMapper mapper;

    @Autowired
    public OAuthApprovalService(OAuthApprovalRepository approvalRepository, OAuthMapper mapper) {
        this.approvalRepository = approvalRepository;
        this.mapper = mapper;
    }

    public OAuthApproval createApproval(OAuthApprovalRequest approvalRequest) {
        OAuthApproval approval = mapper.mapApprovalDtoToEntity(approvalRequest);
        return approvalRepository.save(approval);
    }

    public OAuthApproval modifyApproval(ApprovalDto approvalDto) {
        OAuthApproval approval = mapper.mapApprovalDtoToEntity(approvalDto);
        return approvalRepository.save(approval);
    }

    public OAuthApproval getApproval(Long approvalId) {
        return approvalRepository.findOne(approvalId);
    }

    public void deleteApproval(Long approvalId) {
        approvalRepository.delete(approvalId);
    }

    public Set<OAuthApproval> getApprovalByIds(Set<Long> autoApproveIds) {
        return approvalRepository.findByIdIn(autoApproveIds);
    }
}
