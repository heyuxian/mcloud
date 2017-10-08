package me.javaroad.oauth.controller.web;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author heyx
 */
public class OAuth2Controller {

    @Autowired
    private ClientDetailsService clientDetailsService;


    @GetMapping("/confirm_access")
    public ModelAndView authorize(Map<String, Object> model, Principal principal) throws Exception {
        AuthorizationRequest clientAuth = (AuthorizationRequest) model.remove("authorizationRequest");
        ClientDetails client = clientDetailsService.loadClientByClientId(clientAuth.getClientId());
        model.put("auth_request", clientAuth);
        model.put("Client", client);
        Map<String, String> scopes = new LinkedHashMap<>();
        for (String scope : clientAuth.getScope()) {
            scopes.put(OAuth2Utils.SCOPE_PREFIX + scope, "false");
        }
        /*for (Approval approval : approvalStore.getApprovals(principal.getName(), client.getClientId())) {
            if (clientAuth.getScope().contains(approval.getScope())) {
                scopes.put(OAuth2Utils.SCOPE_PREFIX + approval.getScope(),
                    approval.getStatus() == ApprovalStatus.APPROVED ? "true" : "false");
            }
        }*/
        model.put("scopes", scopes);
        return new ModelAndView("oauth/confirm_access", model);
    }

    @RequestMapping("/error")
    public String handleError(Map<String, Object> model) throws Exception {
        model.put("message", "There was a problem with the OAuth2 protocol");
        return "oauth/oauth_error";
    }

}
