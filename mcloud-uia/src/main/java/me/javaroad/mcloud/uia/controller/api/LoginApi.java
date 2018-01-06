package me.javaroad.mcloud.uia.controller.api;

import io.swagger.annotations.ApiOperation;
import java.util.Objects;
import javax.validation.Valid;
import me.javaroad.common.exception.InvalidParameterException;
import me.javaroad.mcloud.uia.config.OAuthProvider;
import me.javaroad.mcloud.uia.entity.TokenInfo;
import me.javaroad.mcloud.uia.controller.api.request.LoginRequest;
import me.javaroad.mcloud.uia.controller.api.request.RegisterRequest;
import me.javaroad.mcloud.uia.entity.OAuthServerInfo;
import me.javaroad.mcloud.uia.rest.OAuthApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
public class LoginApi {

    private final OAuthApi oauthapi;
    private final OAuthProvider provider;

    @Autowired
    public LoginApi(OAuthApi oauthapi, OAuthProvider provider) {
        this.oauthapi = oauthapi;
        this.provider = provider;
    }

    @ApiOperation(value = "Login", httpMethod = "POST")
    @PostMapping("login")
    public TokenInfo login(@RequestBody @Valid LoginRequest loginRequest) {
        OAuthServerInfo serverInfo = provider.getProvider().get("mcloud");
        if (Objects.isNull(serverInfo)) {
            throw new InvalidParameterException("invalid oauthProvider");
        }
        return oauthapi.token(serverInfo, loginRequest);
    }

    @PostMapping("register")
    public void register(@RequestBody @Valid RegisterRequest loginRequest) {
        OAuthServerInfo serverInfo = provider.getProvider().get("mcloud");
        if (Objects.isNull(serverInfo)) {
            throw new InvalidParameterException("invalid oauthProvider");
        }
    }
}
