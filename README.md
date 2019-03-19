# MCloud - 微服务基础设施
[![Build Status](https://www.travis-ci.org/heyuxian/mcloud.svg?branch=master)](https://www.travis-ci.org/heyuxian/mcloud)
[![Coverage Status](https://coveralls.io/repos/github/heyuxian/mcloud/badge.svg?branch=master)](https://coveralls.io/github/heyuxian/mcloud?branch=master)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## 项目简介

MCloud 基于 Spring Cloud 进行开发，提供了项目中常用的基础设施：

- **mcloud-registry** 服务注册与发现中心。
- [keycloak](http://www.keycloak.org/) 用户认证和管理
- **mcloud-apigw** 基于Spring cloud gateway 实现的 API 网关 。
- **mcloud-config** 基于 GitHub 的统一配置中心。
- **mcloud-logs** 基于`logstash`  `Kibana` 以及 `ElasticSearch` 实现的日志服务。
- **mcloud-demo** Demo Project
- **mcloud-console** 基于 ant-design-pro 搭建的系统控制台

其他模块：
- [Code Generator](https://github.com/heyuxian/code-generator) 用于 Intellij-IDEA 的代码生成器插件。


## Dependencies

- Spring Boot 2.1.3.RELEASE
- Spring Cloud Greenwich.RELEASE
- Maven
- ......

## 环境依赖

- **JDK** 1.8 以上
- **IDE** 请安装对应IDE的 **lombok** 插件


## Quick Start

**克隆项目到本地**

```
git clone https://github.com/heyuxian/mcloud.git
```

**构建及运行**

因为项目使用统一配置，所以需要先启动 `mcloud-config` 模块，然后依次启动 `mcloud-registry` 、`mcloud-apigw`，`mcloud-demo`。

启动配置中心：

```shell
cd mcloud-config
./mvnw clean install spring-boot:run
```

启动注册中心：
```shell
cd mcloud-registry
#分别在三个终端运行以下命令，用于启动多个注册节点
mvn clean install spring-boot:run -Dspring.profiles.active=peer1
mvn clean install spring-boot:run -Dspring.profiles.active=peer2
mvn clean install spring-boot:run -Dspring.profiles.active=peer3
```

启动 API 网关：

```shell
cd mcloud-apigw
mvn clean install spring-boot:run
```

启动实例项目：

```shell
cd mcloud-demo
mvn clean install
#分别在两个终端运行以下命令，用于启动两个节点
mvn spring-boot:run -Dspring.profiles.active=peer1
mvn spring-boot:run -Dspring.profiles.active=peer2
```

所有节点都启动完成后，就可以通过 API 网关访问我们的示例项目了：

```
curl http://localhost:8443/demo/hello
```

## 问题及建议

若是对于本项目有任何问题或建议,请提 [Issue](https://github.com/heyuxian/mcloud/issues/new) 。
