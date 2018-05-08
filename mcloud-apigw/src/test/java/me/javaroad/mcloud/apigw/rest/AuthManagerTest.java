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
public class AuthManagerTest extends BaseSpringTest {

    @Autowired
    private AuthManager authManager;

    @Test
    public void login() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("mcloud-user");
        loginRequest.setPassword("1234567");
        //todo
        AuthDto authDto = authManager.login(loginRequest);
        assertThat(authDto).isNotNull();
    }

}