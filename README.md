# MCloud - 微服务基础设施
[![Build Status](https://www.travis-ci.org/heyuxian/mcloud.svg?branch=master)](https://www.travis-ci.org/heyuxian/mcloud)
[![Coverage Status](https://coveralls.io/repos/github/heyuxian/mcloud/badge.svg?branch=master)](https://coveralls.io/github/heyuxian/mcloud?branch=master)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## 项目简介

MCloud 基于Spring Cloud进行开发，提供了项目中常用的基础设施：

- **mcloud-registry** 服务注册与发现中心。
- [keycloak](http://www.keycloak.org/) 用户认证和管理
- **mcloud-apigw** 基于Spring cloud zuul 实现的api网关 。
- **mcloud-config** 统一配置中心。
- **mcloud-logs** 基于`logstash`  `Kibana` 以及 `ElasticSearch` 实现的日志服务。
- **mcloud-demo** Demo Project
- **mcloud-console** 基于 ant-design-pro 搭建的系统控制台

其他模块：
- [Code Generator](https://github.com/heyuxian/code-generator) 用于 Intellij-IDEA 的代码生成器插件。


## Dependencies

- Spring Boot 2.0.0.RELEASE
- Spring Cloud Finchley.M7
- Gradle 4.6
- ......


## 环境依赖

- **JDK** 1.8 以上
- **IDE** 请安装对应IDE的**lombok**插件
- **数据库** Mysql 5.5 及以上


## Quick Start

**修改 hosts**
```
127.0.0.1	mcloud-registry.example.com
127.0.0.1	mcloud-demo.example.com
127.0.0.1	mcloud-config.example.com
127.0.0.1	mcloud-apigw.example.com
```

**安装 keycloak**

下载 [keycloak](https://www.keycloak.org/archive/downloads-3.4.3.html) 并解压到本地文件夹，在 keycloak bin 目录下运行以下命令启动 keycloak:

 **Windows**
```
standalone.bat -Djboss.http.port=8443
```
**Linux/MacOs**
```
./standalone.sh -Djboss.http.port=8443
```

启动后登陆到 keycloak 并导入 `data` 目录下的 `mcloud-realm.json` 和 `mcloud-users-0.json`，默认用户为：

- 管理员：mcloud-admin/123456
- 普通用户：mcloud-user/123456

**克隆项目到本地**

```
git clone https://github.com/heyuxian/mcloud.git
```

**构建并运行**

**Windows**

```shell
cd mcloud
#执行构建
gradlew.bat build
# 分别在三个不同的终端运行以下命令
gradlew.bat bootRun -b ./mcloud-registry/mcloud-registry.gradle
gradlew.bat bootRun -b ./mcloud-apigw/mcloud-apigw.gradle
gradlew.bat bootRun -b ./mcloud-demo/mcloud-demo.gradle
```

**Linux/MacOs**

```sh
cd mcloud
#执行构建
./gradlew build
# 分别在三个不同的终端运行以下命令
./gradlew bootRun -b ./mcloud-registry/mcloud-registry.gradle
./gradlew bootRun -b ./mcloud-apigw/mcloud-apigw.gradle
./gradlew bootRun -b ./mcloud-demo/mcloud-demo.gradle
```

各个服务运行之后，首先通过 api gateway 进行登陆：

```shell
curl --request POST \
  --url http://mcloud-apigw.example.com/auth/login \
  --header 'cache-control: no-cache' \
  --header 'content-type: application/json' \
  --data '{"username": "mcloud-user","password": "123456"}'
```

如果一切正常，将获取 AccessToken：

```shell
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100  1500    0  1452  100    48  11616    384 --:--:-- --:--:-- --:--:-- 11616{"access_token":"${access_token}","expires_in":36000,"refresh_expires_in":1800,"token_type":"bearer","id_token":null,"not-before-policy":0,"session_state":"8c808f01-86fd-45fd-bb69-d3edf7218be8"}
```

此时，使用上面获取的 AccessToken ，即可访问受保护的 api ：`http://mcloud-apigw.example.com/demo/info`

```shell
curl --request GET \
  --url http://mcloud-apigw.example.com/demo/info \
  --header 'authorization: Bearer ${access_token}' \
  --header 'cache-control: no-cache' \
  --header 'content-type: application/json' \
  --data '{\n	"grant_type":"password"\n}'
```

API 也可通过 Swagger 进行调用，地址为: `http://mcloud-apigw.example.com/swagger-ui.html`

![image](https://user-images.githubusercontent.com/30259465/39365862-f2d5f954-4a64-11e8-8acd-7eff6dd7847b.png)

最后，还可以直接通过 `mcloud-console` 项目进入系统。运行并登陆 `mcloud-console` 后，将看到以下的画面：

![image](https://user-images.githubusercontent.com/30259465/39928109-01808502-5567-11e8-9379-e42b031a7fc0.png)

![image](https://user-images.githubusercontent.com/30259465/39928133-1826e9d6-5567-11e8-8917-81bf55e534db.png)



## 问题及建议

若是对于本项目有任何问题或建议,请提 [Issue](https://github.com/heyuxian/mcloud/issues/new) 。
