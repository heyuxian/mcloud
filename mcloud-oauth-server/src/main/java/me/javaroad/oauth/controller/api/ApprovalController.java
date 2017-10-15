package me.javaroad.oauth.controller.api;

import static me.javaroad.oauth.controller.OAuthConstants.API_PREFIX;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import me.javaroad.oauth.controller.api.request.ApprovalRequest;
import me.javaroad.oauth.controller.api.response.ApprovalResponse;
import me.javaroad.oauth.entity.Approval;
import me.javaroad.oauth.mapper.ApprovalMapper;
import me.javaroad.oauth.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping(API_PREFIX + "/approvals")
public class ApprovalController {

    private final ApprovalService approvalService;
    private final ApprovalMapper approvalMapper;

    @Autowired
    public ApprovalController(ApprovalService approvalService, ApprovalMapper approvalMapper) {
        this.approvalService = approvalService;
        this.approvalMapper = approvalMapper;
    }

    @ApiOperation(value = "Create Approval", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApprovalResponse createApproval(@RequestBody @Valid ApprovalRequest approvalRequest) {
        Approval approval = approvalService.createApproval(approvalRequest);
        return approvalMapper.mapEntityToResponse(approval);
    }

    @ApiOperation(value = "Get All Approval", httpMethod = "GET")
    @GetMapping
    public List<ApprovalResponse> getAllApproval() {
        List<Approval> approvals = approvalService.getAll();
        return approvalMapper.mapEntityToResponse(approvals);
    }


}
