# Java 开源博客 black-c

[![Build Status](https://www.travis-ci.org/heyuxian/black-c.svg?branch=master)](https://www.travis-ci.org/heyuxian/black-c)
[![Coverage Status](https://coveralls.io/repos/github/heyuxian/black-c/badge.svg)](https://coveralls.io/github/heyuxian/black-c)

**简介**

**black-c**是一款开源的博客系统，以前后端分离的方式，使用Java提供Rest风格的API供NodeJs调用，并结合Spring cloud，以微服务的形式实现整个系统。项目将分为三个阶段实现：

1. 以Java实现系统博客相关的Rest API，并以swagger文档的形式提供API定义
2. 以NodeJs+vue方式调用系统Rest API实现前端UI展现
3. 拆分后台服务，结合Spring cloud实现简单的微服务架构


目前项目处于第一阶段，希望大家多提意见和建议，可以在下方评论（仅限码云）或直接提交Issue。也欢迎大家和我一起完善这个项目。

------

**技术选型**

- **开发语言** Java8
- **基础框架** Spring,Spring MVC
- **ORM相关框架** Spring data JPA,Hibernate,QueryDsl
- **安全相关框架** Spring Security,Spring session
- **缓存框架** Redis
- **测试框架** Spring test,mockito,Rest-Assured
- **代码托管** github: [black-c](https://github.com/heyuxian/black-c "black-c") , 码云: [black-c ](http://git.oschina.net/black-c )
- **微服务相关** Spring cloud
- **其他** lombok,MapStruct
- **API 定义** [API Spec](https://github.com/heyuxian/black-c/wiki/Rest-API)

------

### Usage

1. 检出项目

```shell
git clone https://github.com/heyuxian/black-c.git
```

2. 创建数据库(mysql)

```
mysql -uroot -p密码
CREATE DATABASE IF NOT EXISTS blackc;
```

3.修改数据源配置 `application-dev.yml`

```yaml
server:
  port: 80
logging:
  #修改为你自己的日志保存路径
  path: D:\logs\black-c
  level: error
spring:
  datasource:
    url: jdbc:mysql://localhost/blackc
    username: root
    password: 密码
    driver-class-name: com.mysql.jdbc.Driver
```

4. 运行

```
mvn clean install
mvn spring-boot:run -Drun.profiles=dev
```

当服务启动之后，访问 http://localhost/swagger-ui.html 即可看到系统已经实现的API
