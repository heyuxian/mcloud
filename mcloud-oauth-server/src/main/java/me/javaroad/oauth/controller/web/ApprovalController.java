package me.javaroad.oauth.controller.web;

import javax.validation.Valid;
import me.javaroad.oauth.controller.web.request.ApprovalRequest;
import me.javaroad.oauth.controller.web.response.ApprovalResponse;
import me.javaroad.oauth.entity.Approval;
import me.javaroad.oauth.mapper.ApprovalMapper;
import me.javaroad.oauth.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author heyx
 */
@Controller
@RequestMapping("approval")
public class ApprovalController {

    private final ApprovalService approvalService;
    private final ApprovalMapper approvalMapper;

    @Autowired
    public ApprovalController(ApprovalService approvalService, ApprovalMapper approvalMapper) {
        this.approvalService = approvalService;
        this.approvalMapper = approvalMapper;
    }

    @GetMapping("create")
    public String create() {
        return "create";
    }

    @PostMapping("create")
    @ResponseBody
    public ApprovalResponse createApproval(@Valid ApprovalRequest approvalRequest) {
        Approval approval = approvalService.createApproval(approvalRequest);
        return approvalMapper.mapEntityToResponse(approval);
    }

    @GetMapping("edit")
    public String edit() {
        return "edit";
    }

    @GetMapping("list")
    public String list() {
        return "list";
    }
}
