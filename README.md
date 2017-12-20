# MCloud - 微服务基础设施
[![Build Status](https://www.travis-ci.org/heyuxian/mcloud.svg?branch=master)](https://www.travis-ci.org/heyuxian/mcloud)
[![Coverage Status](https://coveralls.io/repos/github/heyuxian/mcloud/badge.svg?branch=master)](https://coveralls.io/github/heyuxian/mcloud?branch=master)[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## 项目简介

MCloud 基于Spring Cloud进行开发，提供了项目中常用的基础设施：

- **mcloud-eureka** 服务注册与发现中心。
- [**mcloud-oauth-server**](https://github.com/heyuxian/mcloud-oauth2-server) 基于Spring OAuth2实现的OAuth2认证服务端，其它服务需要依赖此服务进行认证。
- **mcloud-uia** API 统一登录中心。
- **mcloud-apigw** 基于Spring cloud zuul 实现的api网关 。
- **mcloud-config** 统一配置中心。
- **mcloud-monitoring** 基于 Spring boot admin 实现系统监控。
- **mcloud-file-storage** 文件存储中心。
- **mcloud-search** 基于 `ElasticSearch` 全文检索服务
- **mcloud-logs** 基于`logstash`  `Kafka` 以及 `ElasticSearch` 实现的日志服务。
- **mcloud-blog** Demo Project

其他模块：

- [mcloud-parent](https://github.com/heyuxian/mcloud-parent) maven 公用依赖。
- [mcloud-common](https://github.com/heyuxian/mcloud-common) 项目公用工具类。
- [mcloud-data](https://github.com/heyuxian/mcloud-data) 数据存储相关。
- [mcloud-web](https://github.com/heyuxian/mcloud-web) web相关依赖及公共类。
- [Code Generator](https://github.com/heyuxian/code-generator) 用于 Intellij-IDEA 的代码生成器插件。

UI界面:

- 基于 [AdminBSBMaterialDesign](https://github.com/gurayyarar/AdminBSBMaterialDesign) ，使用 `thymeleaf` 实现的后台管理界面。
- [mcloud-blog-ui](https://github.com/heyuxian/mcloud-blog-ui) 基于[CoPilot](https://github.com/misterGF/CoPilot) ，使用 `node` + `vue`实现的博客前端。 

## 环境依赖

- **JDK** 1.8 以上
- **IDE** 请安装对应IDE的**lombok**插件
- **数据库** Mysql 5.5 及以上
- **缓存** Redis
- **消息中间件** Kafka, RabbitMQ （暂未实现）
- **全文检索** ElasticSearch （暂未实现）
- **其他** Zookeeper （暂未实现）


## 系统结构

![1](https://user-images.githubusercontent.com/30259465/34211439-0d4f035c-e5d4-11e7-8c46-ba5c7ffd65d0.png)



## 问题及建议

若是对于本项目有任何问题或建议,请提 [Issue](https://github.com/heyuxian/mcloud/issues/new) 。
