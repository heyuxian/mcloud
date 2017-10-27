-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_blog
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/ `db_blog` /*!40100 DEFAULT CHARACTER SET utf8 */;
use db_blog;
--
-- Table structure for table `blog_article`
--

DROP TABLE IF EXISTS `blog_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` tinyblob,
  `modified_date` tinyblob,
  `content` varchar(255) DEFAULT NULL,
  `seo_description` varchar(255) DEFAULT NULL,
  `seo_keywords` varchar(255) DEFAULT NULL,
  `seo_title` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `comment_count` bigint(20) DEFAULT NULL,
  `read_count` bigint(20) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `channel_id` bigint(20) DEFAULT NULL,
  `created_date` tinyblob,
  PRIMARY KEY (`id`),
  KEY `FKg1ccd1bvdbby2gj023t9hysl2` (`author_id`),
  KEY `FK5bg5s8io2egy9080xdxp6bmxt` (`channel_id`),
  CONSTRAINT `FK5bg5s8io2egy9080xdxp6bmxt` FOREIGN KEY (`channel_id`) REFERENCES `blog_chanel` (`id`),
  CONSTRAINT `FKg1ccd1bvdbby2gj023t9hysl2` FOREIGN KEY (`author_id`) REFERENCES `blog_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_article`
--

LOCK TABLES `blog_article` WRITE;
/*!40000 ALTER TABLE `blog_article` DISABLE KEYS */;
INSERT INTO `blog_article` VALUES (1,NULL,NULL,'xxxx','xx','xx','xxx',1,NULL,NULL,NULL,'aaaa',1,NULL,NULL),(2,NULL,NULL,'ddd','ddd',NULL,NULL,2,NULL,NULL,NULL,'zzzzz',1,NULL,NULL),(3,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL),(4,NULL,NULL,NULL,'3',NULL,NULL,NULL,NULL,NULL,NULL,'rr',1,NULL,NULL),(5,NULL,NULL,NULL,'2',NULL,NULL,NULL,NULL,NULL,NULL,'1',1,NULL,NULL),(6,NULL,NULL,NULL,'4',NULL,NULL,NULL,NULL,NULL,NULL,'1233',1,NULL,NULL),(7,NULL,NULL,NULL,'3',NULL,NULL,NULL,NULL,NULL,NULL,'11',1,NULL,NULL),(8,NULL,NULL,NULL,'4',NULL,NULL,NULL,NULL,NULL,NULL,'4',1,NULL,NULL);
/*!40000 ALTER TABLE `blog_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_article_category`
--

DROP TABLE IF EXISTS `blog_article_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_article_category` (
  `article_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`article_id`,`category_id`),
  KEY `FKi6dnhj4arapba1fw3l2dl6g3c` (`category_id`),
  CONSTRAINT `FK59q2fb68lnn9dokreevy28ndy` FOREIGN KEY (`article_id`) REFERENCES `blog_article` (`id`),
  CONSTRAINT `FKi6dnhj4arapba1fw3l2dl6g3c` FOREIGN KEY (`category_id`) REFERENCES `blog_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_article_category`
--

LOCK TABLES `blog_article_category` WRITE;
/*!40000 ALTER TABLE `blog_article_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_article_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_article_label`
--

DROP TABLE IF EXISTS `blog_article_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_article_label` (
  `article_id` bigint(20) NOT NULL,
  `label_id` bigint(20) NOT NULL,
  PRIMARY KEY (`article_id`,`label_id`),
  KEY `FKp5s4gxk5wa9esvfqcia82t369` (`label_id`),
  CONSTRAINT `FK9r85o7v8n5p0xd15uy4ia97k2` FOREIGN KEY (`article_id`) REFERENCES `blog_article` (`id`),
  CONSTRAINT `FKp5s4gxk5wa9esvfqcia82t369` FOREIGN KEY (`label_id`) REFERENCES `blog_label` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_article_label`
--

LOCK TABLES `blog_article_label` WRITE;
/*!40000 ALTER TABLE `blog_article_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_article_label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_authority`
--

DROP TABLE IF EXISTS `blog_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` tinyblob,
  `modified_date` tinyblob,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_date` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_authority`
--

LOCK TABLES `blog_authority` WRITE;
/*!40000 ALTER TABLE `blog_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_category`
--

DROP TABLE IF EXISTS `blog_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` tinyblob,
  `modified_date` tinyblob,
  `name` varchar(255) DEFAULT NULL,
  `sort` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `created_date` tinyblob,
  PRIMARY KEY (`id`),
  KEY `FK9x4mnhyimr0mmwps6gs51qxj2` (`user_id`),
  CONSTRAINT `FK9x4mnhyimr0mmwps6gs51qxj2` FOREIGN KEY (`user_id`) REFERENCES `blog_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_category`
--

LOCK TABLES `blog_category` WRITE;
/*!40000 ALTER TABLE `blog_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_chanel`
--

DROP TABLE IF EXISTS `blog_chanel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_chanel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` tinyblob,
  `modified_date` tinyblob,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_date` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_chanel`
--

LOCK TABLES `blog_chanel` WRITE;
/*!40000 ALTER TABLE `blog_chanel` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_chanel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_comment`
--

DROP TABLE IF EXISTS `blog_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` tinyblob,
  `modified_date` tinyblob,
  `content` varchar(255) DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `created_date` tinyblob,
  PRIMARY KEY (`id`),
  KEY `FK19mmltn2ksm0u3tolmb975aq1` (`article_id`),
  KEY `FK5prsmyfi3bv5cv3p62d87ouwu` (`author_id`),
  CONSTRAINT `FK19mmltn2ksm0u3tolmb975aq1` FOREIGN KEY (`article_id`) REFERENCES `blog_article` (`id`),
  CONSTRAINT `FK5prsmyfi3bv5cv3p62d87ouwu` FOREIGN KEY (`author_id`) REFERENCES `blog_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_comment`
--

LOCK TABLES `blog_comment` WRITE;
/*!40000 ALTER TABLE `blog_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_label`
--

DROP TABLE IF EXISTS `blog_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_label` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` tinyblob,
  `modified_date` tinyblob,
  `global` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_date` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_label`
--

LOCK TABLES `blog_label` WRITE;
/*!40000 ALTER TABLE `blog_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_user`
--

DROP TABLE IF EXISTS `blog_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` tinyblob,
  `modified_date` tinyblob,
  `avatar` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `created_date` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_user`
--

LOCK TABLES `blog_user` WRITE;
/*!40000 ALTER TABLE `blog_user` DISABLE KEYS */;
INSERT INTO `blog_user` VALUES (1,NULL,NULL,NULL,NULL,NULL,'heyx',NULL);
/*!40000 ALTER TABLE `blog_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_view_log`
--

DROP TABLE IF EXISTS `blog_view_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_view_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `view_date` datetime DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4e52u1n0c4qqnn7n4jr3liroo` (`article_id`),
  CONSTRAINT `FK4e52u1n0c4qqnn7n4jr3liroo` FOREIGN KEY (`article_id`) REFERENCES `blog_article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_view_log`
--

LOCK TABLES `blog_view_log` WRITE;
/*!40000 ALTER TABLE `blog_view_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_view_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_authority`
--

DROP TABLE IF EXISTS `sys_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_authority`
--

LOCK TABLES `sys_authority` WRITE;
/*!40000 ALTER TABLE `sys_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_authority`
--

DROP TABLE IF EXISTS `sys_user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_authority` (
  `users_id` bigint(20) NOT NULL,
  `authorities_id` bigint(20) NOT NULL,
  PRIMARY KEY (`users_id`,`authorities_id`),
  KEY `FK97xdd09jaw5dsg2q49hvdo9pm` (`authorities_id`),
  CONSTRAINT `FK97xdd09jaw5dsg2q49hvdo9pm` FOREIGN KEY (`authorities_id`) REFERENCES `blog_authority` (`id`),
  CONSTRAINT `FKt0eo8m25aa8s9tl5e6nw9lwl` FOREIGN KEY (`users_id`) REFERENCES `blog_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_authority`
--

LOCK TABLES `sys_user_authority` WRITE;
/*!40000 ALTER TABLE `sys_user_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user_authority` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-11 20:36:24
