# MCloud - blog
## 简介

以简单的博客系统作为 mcloud 的示例项目。

## 快速使用

**创建数据库**

```
CREATE DATABASE IF NOT EXISTS `db_blog` DEFAULT CHARACTER SET utf8;
```

**执行初始化脚本**

修改 flyway plugin 用户及密码：

mcloud-blog/pom.xml

```xml
<plugin>
  <groupId>org.flywaydb</groupId>
  <artifactId>flyway-maven-plugin</artifactId>
  <version>4.2.0</version>
  <configuration>
    <user>root</user>
    <password>root</password>
    <driver>com.mysql.jdbc.Driver</driver>
    <url>jdbc:mysql://localhost:3306/db_blog</url>
  </configuration>
</plugin>
```

在 mcloud-blog 根目录运行 maven 命令：

```
mvn flyway:clean flyway:migrate
```

**修改数据库用户及密码**

修改 `application-dev.yml` 中的数据库用户及密码

**启动认证服务**

refer: [统一认证服务](../mcloud-uia/README.md)

**启动服务**

```
cd mcloud-blog
mvn clean install
mvn spring-boot:run -Drun.profiles=dev
```

**访问地址**

```
http://localhost:8081/swagger-ui.html
```