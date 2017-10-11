# MCloud - OAuth2 认证中心

## 简介

mcloud-oauth-server 基于Spring OAuth2实现的OAuth认证服务端。

## 快速使用

**执行脚本**

运行项目根目录 `sql` 文件夹下的数据库脚本 `db_oauth.sql`

**修改数据库用户及密码**

修改 `application.yml` 中的数据库用户及密码

**启动OAuth2认证服务**

```
cd mcloud-oauth-server
mvn clean install
mvn spring-boot:run
```

**访问地址**

```
http://localhost:8043/uaa/swagger-ui.html
```

![uaa](https://user-images.githubusercontent.com/30259465/31441550-16f2053e-aec6-11e7-9568-93cd35dbc1dd.png)

> 注：访问OAuth2 认证服务的swagger文档需要通过认证，在弹出的登陆页面输入默认的用户名密码即可进入swagger文档.