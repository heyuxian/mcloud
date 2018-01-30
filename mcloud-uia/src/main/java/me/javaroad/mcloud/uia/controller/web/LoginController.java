package me.javaroad.mcloud.uia.controller.web;

import me.javaroad.mcloud.uia.config.OAuth2Property;
import me.javaroad.mcloud.uia.entity.State;
import me.javaroad.mcloud.uia.util.StateUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author heyx
 */
@Controller
public class LoginController {

    @Autowired
    private OAuth2Property oauth2Property;

    @GetMapping("oauth2/login")
    public String login(String redirectUri) {
        State state = State.builder()
            .redirectUri(redirectUri)
            .nonce(RandomStringUtils.randomAlphabetic(16))
            .build();

        String stateStr = StateUtils.encode(state);
        String authUrl = oauth2Property.buildAuthUrl(stateStr);
        return "redirect:" + authUrl;
    }

    @GetMapping("oauth2/callback")
    public String callback(String code, String state) {
        State decode = StateUtils.decode(state);
        Assert.notNull(decode, "invalid state");
        return "redirect:" + decode.getRedirectUri() + "?code=" + code;
    }

}
