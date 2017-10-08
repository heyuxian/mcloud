package me.javaroad.uaa.controller.web;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import me.javaroad.common.exception.InvalidParameterException;
import me.javaroad.uaa.config.OAuthProvider;
import me.javaroad.uaa.entity.OAuthServerInfo;
import me.javaroad.uaa.entity.TokenInfo;
import me.javaroad.uaa.net.OAuthApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author heyx
 */
@Controller
@RequestMapping("oauth")
public class LoginController {

    private final OAuthProvider provider;
    private final OAuthApi oAuthApi;

    @Autowired
    public LoginController(OAuthProvider provider, OAuthApi oAuthApi) {
        this.provider = provider;
        this.oAuthApi = oAuthApi;
    }

    @GetMapping("login")
    public String login(String redirectUrl, @RequestParam(defaultValue = "mcloud") String oauthProvider, HttpServletRequest request) {
        OAuthServerInfo serverInfo = provider.getProvider().get(oauthProvider);
        if (Objects.isNull(serverInfo)) {
            throw new InvalidParameterException("invalid oauthProvider");
        }
        String authorizationUri = serverInfo.buildAuthorizationUrl(redirectUrl);
        return "redirect:" + authorizationUri;
    }

    @GetMapping("callback")
    public String callback(String code, String state, @RequestParam(defaultValue = "mcloud") String oauthProvider) {
        OAuthServerInfo serverInfo = provider.getProvider().get(oauthProvider);
        if (Objects.isNull(serverInfo)) {
            throw new InvalidParameterException("invalid oauthProvider");
        }
        TokenInfo token = oAuthApi.token(serverInfo, code);

        return "redirect:" + state + "#/login/success?token=" + token.getAccessToken();
    }

}
