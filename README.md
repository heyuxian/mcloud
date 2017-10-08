# MCloud - 微服务开发实践
[![Build Status](https://www.travis-ci.org/heyuxian/mcloud.svg?branch=master)](https://www.travis-ci.org/heyuxian/mcloud)

## 项目简介

MCloud 是基于Spring Cloud实现的简单微服务系统。提供了微服务开发中常用的模块：

- mcloud-eureka 服务注册与发现中心
- mcloud-oauth-server 基于Spring OAuth2实现的OAuth认证服务端
- mcloud-uia 实现用户统一登录，通过简单的配置即可实现第三方登录
- mcloud-apigw 基于Spring cloud zuul 实现的api网关
- mcloud-config 统一配置中心

其他模块：

- mcloud-parent maven 公用依赖
- mcloud-common 项目公用工具类
- mcloud-data 数据库操作相关
- mcloud-blog 简单微服务架构的博客系统

## 快速使用

```
git clone https://github.com/heyuxian/mcloud.git
cd 项目目录/mcloud
```

**启动OAuth Server:**

```
cd mcloud-oauth-server
mvn clean install
mvn spring-boot:run
```

访问地址: http://localhost:8043/uaa

**启动认证中心:**

```
cd mcloud-uia
mvn clean install
mvn spring-boot:run
```
访问地址: http://localhost:8443/uia

**启动博客服务:**

```
cd mcloud-blog
mvn clean install
mvn spring-boot:run
```
访问地址: http://localhost:8081/swagger-ui.html

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