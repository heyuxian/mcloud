package me.javaroad.uaa.controller;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import me.javaroad.common.exception.InvalidParameterException;
import me.javaroad.uaa.config.OAuthProvider;
import me.javaroad.uaa.config.OAuthServerInfo;
import me.javaroad.uaa.entity.OAuth2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * @author heyx
 */
@Controller
@RequestMapping("oauth")
public class LoginController {

    private final RestTemplate restTemplate;
    private final OAuthProvider provider;

    @Autowired
    public LoginController(RestTemplateBuilder builder, OAuthProvider provider) {
        this.restTemplate = builder.build();
        this.provider = provider;
    }

    @GetMapping("login")
    public String login(String redirectUrl, @RequestParam(defaultValue = "mcloud") String oauthProvider, HttpServletRequest request) {
        System.out.println(request.getParameter("redirectUrl"));
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
        String accessTokenUrl = serverInfo.buildAccessTokenUrl(code);
        OAuth2Response token = token(accessTokenUrl);

        return "redirect:" + state + "#/login/success?token=" + token.getAccessToken();
    }

    private OAuth2Response token(String url) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic bWNsb3VkLWJsb2c6MTIzNDU2");
        ResponseEntity<OAuth2Response> responseEntity = restTemplate
            .postForEntity(url, new HttpEntity<>(httpHeaders), OAuth2Response.class);
        return responseEntity.getBody();
    }
}
