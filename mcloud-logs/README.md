# mcloud-logs

mcloud-logs 使用 logstash + kafka + elasticsearch 实现整个系统服务日志监控与查询。

## 服务配置

**添加 maven 依赖：**

```xml
<dependency>
   <groupId>org.apache.kafka</groupId>
   <artifactId>kafka-clients</artifactId>
   <version>1.0.0</version>
</dependency>
```

**添加 log4j2 配置：**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
  <Appenders>
    <Console name="Console" target="SYSTEM_OUT">
      <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
    </Console>
    <Kafka name="Kafka" topic="mcloud-log">
      <PatternLayout pattern="%date %message"/>
      <Property name="bootstrap.servers">localhost:9092</Property>
    </Kafka>
  </Appenders>
  <Loggers>
    <Root level="debug">
      <AppenderRef ref="Console"/>
      <AppenderRef ref="Kafka"/>
    </Root>
    <Logger name="org.apache.kafka" level="INFO" />
  </Loggers>
</Configuration>
```

## 系统配置

### Zookeeper-3.4.10  [官网](http://zookeeper.apache.org/doc/current/zookeeperStarted.html#sc_InstallingSingleMode)

**添加配置**

在 `conf` 目录下创建配置文件 `zoo.cfg ` , 并在其中添加以下内容：

```properties
tickTime=2000
dataDir=/var/lib/zookeeper
clientPort=2181
```

**启动 ZooKeeper**

**windows**:

```
bin/zkServer.bat start
```

### Kafka_2.11-1.0.0 [官网](http://kafka.apache.org/quickstart)

**修改日志存储位置**

config/server.properties

```
log.dirs=D:/kafka-logs
```

**启动 Kafka**

**windows**:

```
bin/windows/kafka-server-start.bat config/server.properties
```

**注：**

如果在启动的时候出现以下错误：

```
错误: 找不到或无法加载主类
```

需要手动修改 `bin/windows/kafka-run-class.bat` ，找到以下的代码：

```
set COMMAND=%JAVA% %KAFKA_HEAP_OPTS% %KAFKA_JVM_PERFORMANCE_OPTS% %KAFKA_JMX_OPTS% %KAFKA_LOG4J_OPTS% -cp %CLASSPATH% %KAFKA_OPTS% %*
```

将其中的 `%CLASSPATH%` 添上双引号 => `"%CLASSPATH%"` 。

## Elasticsearch-6.1.1 [官网](https://www.elastic.co/downloads/elasticsearch)

**安装 x-pack**

```
bin/elasticsearch-plugin install x-pack
```

新增用户：

```
bin/users useradd mcloud-user
```

修改角色：

```
 bin/users roles -a logstash_admin mcloud-log-user
```

**注：**

系统内置角色：

```
Known roles: [kibana_dashboard_only_user, watcher_admin, logstash_system, kibana_user, machine_learning_user, remote_monitoring_agent, machine_learning_admin, watcher_user, monitoring_user, reporting_user, kibana_system, logstash_admin, transport_client, superuser, ingest_admin]
```

**启动服务**

```
bin/elasticsearch.bat
```

## Kibana-6.1.1 [官网](https://www.elastic.co/downloads/kibana)

**安装 x-pack**

```
bin/kibana-plugin.bat install x-pack
```

**启动服务**

```
bin/kibana.bat
```

## Logstash-6.1.1 [官网](https://www.elastic.co/downloads/logstash)

**创建配置文件** [文档](https://www.elastic.co/guide/en/logstash/current/input-plugins.html)

config/logstash.conf

```
input { 	
	logstash-input-kafka {
		topics => ["mcloud-log"]
	} 
}
output {
  elasticsearch { 
  	hosts => ["localhost:9200"] 
  	user => "mcloud-user"
  	password => 123456
  }
}
```

## 最终效果

相关服务启动完成后， 登陆 kibana 管理界面，可以看到以下的效果：

![qq 20171223170727](https://user-images.githubusercontent.com/30259465/34318488-ce483ba6-e803-11e7-8b38-78f57fcc5329.jpg)