package me.javaroad.uaa.controller;

import java.util.Objects;
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
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String login(String redirectUrl, String oauthProvider) {
        OAuthServerInfo serverInfo = provider.getProvider().get(oauthProvider);
        if(Objects.isNull(serverInfo)){
            throw new InvalidParameterException("invalid oauthProvider");
        }
        String authorizationUri = serverInfo.getAuthorizationUri(redirectUrl);
        return "redirect:" + authorizationUri;
    }

    @GetMapping("callback")
    @ResponseBody
    public OAuth2Response callback(String code, String state) {
        OAuth2Response token =
            token("http://localhost:8043/mcloud/oauth/token?grant_type=authorization_code&client_id=mcloud-blog"
                + "&code=" + code);
        return token;
    }

    private OAuth2Response token(String url) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic bWNsb3VkLWJsb2c6MTIzNDU2");
        ResponseEntity<OAuth2Response> responseEntity = restTemplate
            .postForEntity(url, new HttpEntity<>(httpHeaders), OAuth2Response.class);
        return responseEntity.getBody();
    }
}
