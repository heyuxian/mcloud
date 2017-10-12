# MCloud - 微服务开发实践
[![Build Status](https://www.travis-ci.org/heyuxian/mcloud.svg?branch=master)](https://www.travis-ci.org/heyuxian/mcloud)

## 项目简介

MCloud 是基于Spring Cloud实现的简单微服务系统。提供了微服务开发中常用的模块：

- mcloud-eureka 服务注册与发现中心
- mcloud-oauth-server 基于Spring OAuth2实现的OAuth认证服务端
- mcloud-uia 实现用户统一登录，通过简单的配置即可实现第三方登录
- mcloud-apigw 基于Spring cloud zuul 实现的api网关 
- mcloud-config 统一配置中心 (暂未实现)

其他模块：

- mcloud-parent maven 公用依赖
- mcloud-common 项目公用工具类
- mcloud-data 数据库操作相关
- mcloud-blog 简单微服务架构的博客系统

UI界面:

- mcloud-ui 基于[CoreUI](https://github.com/mrholek/CoreUI-Vue) 实现的后台管理及前端展现页面 [地址](https://github.com/heyuxian/mcloud-ui)

## 环境依赖

- JDK 1.8 以上

- 如果使用Idea 进行开发，请安装 lombok插件

- 数据库：因为使用的是hibernate进行开发，理论上是支持多种数据库，但目前只提供了mysql脚本，如有需要，可以对`application.yml` 做如下修改，使hibernate自动生成对应表结构

  ```
  spring:
    jpa:
      hibernate:
        # update 改为 create,生成表之后需改回 update
        ddl-auto: create
  ```

## 快速使用

**下载项目**

```
git clone https://github.com/heyuxian/mcloud.git
cd 项目目录/mcloud
```

**执行脚本**

首先在数据库中执行以下两个脚本:

```
mcloud/sql/db_oauth.sql
mcloud/sql/db_blog.sql
```

修改对应配置文件中的数据库用户名及密码:

- mcloud-blog: application-dev.yml
- mcloud-oauth-server: application.yml

**启动OAuth Server:**   [详细配置](mcloud-oauth-server/README.md)

```
cd mcloud-oauth-server
mvn clean install
mvn spring-boot:run
```

访问地址: http://localhost:8043/uaa/swagger-ui.html

**启动认证中心:** [详细配置](mcloud-uia/README.md)

```
cd mcloud-uia
mvn clean install
mvn spring-boot:run
```
访问地址: http://localhost:8443/uia/swagger-ui.html 

**启动博客服务:** [详细配置](mcloud-blog/README.md)

```
cd mcloud-blog
mvn clean install
mvn spring-boot:run
```
访问地址: http://localhost:8081/swagger-ui.html 

**注：** 

- 服务注册与发现(mcloud-eureka) 以及api网关(mcloud-apigw)和统一配置中心(mcloud-config) 三个模块暂未完善，但是不用启动以上三个服务系统也是可以运行的。这一块会在最近进行完善。
- 整个系统是以前后端分离的方式进行开发的，所以后端服务暂时只能通过 swagger 文档的形式进行访问，至于前端页面，是在 CoreUI 上进行了二次开发，但是目前实现的功能较少，如需参考，请查看 [源码](https://github.com/heyuxian/mcloud-ui)

## 问题及建议

若是对于本项目有任何问题或建议,可以在github上提Issue,如果是码云，可以直接发表评论,提Issue或是直接给我发私信.同时,如果你愿意参与开发,欢迎提PR.

## License

```
Copyright 2017

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
