package me.javaroad.oauth.service;

import java.util.List;
import java.util.Set;
import me.javaroad.oauth.controller.api.request.ApprovalRequest;
import me.javaroad.oauth.dto.ApprovalDto;
import me.javaroad.oauth.entity.Approval;
import me.javaroad.oauth.mapper.OAuthMapper;
import me.javaroad.oauth.repository.ApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author heyx
 */
@Service
public class ApprovalService {

    private final ApprovalRepository approvalRepository;
    private final OAuthMapper mapper;

    @Autowired
    public ApprovalService(ApprovalRepository approvalRepository, OAuthMapper mapper) {
        this.approvalRepository = approvalRepository;
        this.mapper = mapper;
    }

    public Approval createApproval(ApprovalRequest approvalRequest) {
        Approval approval = mapper.mapApprovalDtoToEntity(approvalRequest);
        return approvalRepository.save(approval);
    }

    public Approval modifyApproval(ApprovalDto approvalDto) {
        Approval approval = mapper.mapApprovalDtoToEntity(approvalDto);
        return approvalRepository.save(approval);
    }

    public Approval getApproval(Long approvalId) {
        return approvalRepository.findOne(approvalId);
    }

    public void deleteApproval(Long approvalId) {
        approvalRepository.delete(approvalId);
    }

    public Set<Approval> getApprovalByIds(Set<Long> autoApproveIds) {
        return approvalRepository.findByIdIn(autoApproveIds);
    }

    public List<Approval> getAll() {
        return approvalRepository.findAll();
    }
}
