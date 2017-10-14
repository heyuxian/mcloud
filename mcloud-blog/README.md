# MCloud - 博客主服务
## 简介

mcloud-blog 使用Spring cloud实现微服务架构的博客系统

## 快速使用

**执行脚本**

运行项目根目录 `sql` 文件夹下的数据库脚本 `db_blog.sql`

**修改数据库用户及密码**

修改 `application-dev.yml` 中的数据库用户及密码

**启动认证服务**

refer: [统一认证服务](../mcloud-uia/README.md)

**启动博客服务**

```
cd mcloud-blog
mvn clean install
mvn spring-boot:run -Drun.profiles=dev
```

**访问地址**

```
http://localhost:8081/swagger-ui.html
```