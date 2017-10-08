package me.javaroad.oauth.entity;

import lombok.Getter;

/**
 * @author heyx
 */
public enum GrantType {
    CODE("authorization_code"),
    //用户名密码模式
    PASSWORD("password"),
    //客户端模式
    CLIENT_CREDENTIALS("client_credentials"),
    //简化模式
    IMPLICIT("implicit"),
    REFRESH_TOKEN("refresh_token");

    @Getter
    private String code;

    GrantType(String code) {
        this.code = code;
    }
}
