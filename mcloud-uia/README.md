# MCloud - 用户认证中心
## 简介

mcloud-uia 实现用户统一登录，通过简单的配置即可实现第三方登录。

## 快速使用

> **注：** 用户认证中心依赖[OAuth2 Server](https://github.com/heyuxian/mcloud/tree/master/mcloud-oauth-server),在启动认证中心之前需启动 [OAuth2](https://github.com/heyuxian/mcloud/tree/master/mcloud-oauth-server)认证服务

**启动OAuth Server:**

```
cd mcloud-oauth-server
mvn clean install
mvn spring-boot:run
```

**启动认证中心:**

```
cd mcloud-uia
mvn clean install
mvn spring-boot:run
```
访问地址: http://localhost:8443/uia/swagger-ui.html

**预置用户**

- 用户名：user
- 密码：123456

通过swagger调用登录接口即可获取 access_token 供其他服务使用.

![uaa](https://user-images.githubusercontent.com/30259465/31441502-eed820b0-aec5-11e7-933c-2aa9f3d80e74.png)

![access_token](https://user-images.githubusercontent.com/30259465/31441536-0843a6b4-aec6-11e7-9af2-e89bc32f7fad.png)