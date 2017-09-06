package org.blackc.oauth.security.controller.api;

import static org.blackc.oauth.security.controller.OAuthConstants.API_PREFIX;

import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.blackc.oauth.security.controller.api.request.OAuthApprovalRequest;
import org.blackc.oauth.security.dto.ApprovalDto;
import org.blackc.oauth.security.entity.OAuthApproval;
import org.blackc.oauth.security.mapper.OAuthMapper;
import org.blackc.oauth.security.service.OAuthApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    private final OAuthApprovalService approvalService;
    private final OAuthMapper mapper;

    @Autowired
    public ApprovalController(OAuthApprovalService approvalService, OAuthMapper mapper) {
        this.approvalService = approvalService;
        this.mapper = mapper;
    }

    @ApiOperation(value = "创建approval", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApprovalDto createApproval(@RequestBody @Valid OAuthApprovalRequest approvalRequest) {
        OAuthApproval approval = approvalService.createApproval(approvalRequest);
        return mapper.mapApprovalEntityToDto(approval);
    }

    @ApiOperation(value = "修改approval", httpMethod = "PUT")
    @PutMapping("{approvalId}")
    public ApprovalDto modifyApproval(@PathVariable Long approvalId, @RequestBody @Valid ApprovalDto approvalDto) {
        approvalDto.setId(approvalId);
        OAuthApproval approval = approvalService.modifyApproval(approvalDto);
        return mapper.mapApprovalEntityToDto(approval);
    }

    @ApiOperation(value = "获取approval", httpMethod = "GET")
    @GetMapping("{approvalId}")
    public ApprovalDto modifyApproval(@PathVariable Long approvalId) {
        OAuthApproval approval = approvalService.getApproval(approvalId);
        return mapper.mapApprovalEntityToDto(approval);
    }

    @ApiOperation(value = "删除approval", httpMethod = "DELETE")
    @DeleteMapping("{approvalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteApproval(@PathVariable Long approvalId) {
        approvalService.deleteApproval(approvalId);
    }
}
