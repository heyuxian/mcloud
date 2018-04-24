package me.javaroad.mcloud.apigw.rest;

import static org.assertj.core.api.Assertions.assertThat;

import me.javaroad.mcloud.apigw.BaseSpringTest;
import me.javaroad.mcloud.apigw.dto.AuthDto;
import me.javaroad.mcloud.apigw.web.request.LoginRequest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author heyx
 */
public class AuthApiTest extends BaseSpringTest {

    @Autowired
    private AuthApi authApi;

    @Test
    public void login() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("mcloud-user");
        loginRequest.setPassword("123456");
        //todo
        //AuthDto authDto = authApi.login(loginRequest);
        //assertThat(authDto).isNotNull();
    }

}