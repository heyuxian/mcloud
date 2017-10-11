-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_oauth
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

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `db_oauth` /*!40100 DEFAULT CHARACTER SET utf8 */;
use db_oauth;
--
-- Table structure for table `client_approval`
--

DROP TABLE IF EXISTS `client_approval`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_approval` (
  `client_id` bigint(20) NOT NULL,
  `approval_id` bigint(20) NOT NULL,
  PRIMARY KEY (`client_id`,`approval_id`),
  KEY `FK6d9wf63mapnddid2pwyogxadu` (`approval_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_approval`
--

LOCK TABLES `client_approval` WRITE;
/*!40000 ALTER TABLE `client_approval` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_approval` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_authority`
--

DROP TABLE IF EXISTS `client_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_authority` (
  `client_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  PRIMARY KEY (`client_id`,`authority_id`),
  KEY `FKawkrs586vlrjc6bvfd1d43dws` (`authority_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_authority`
--

LOCK TABLES `client_authority` WRITE;
/*!40000 ALTER TABLE `client_authority` DISABLE KEYS */;
INSERT INTO `client_authority` VALUES (1,1);
/*!40000 ALTER TABLE `client_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_resource`
--

DROP TABLE IF EXISTS `client_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_resource` (
  `client_id` bigint(20) NOT NULL,
  `resource_id` bigint(20) NOT NULL,
  PRIMARY KEY (`client_id`,`resource_id`),
  KEY `FKshvh31pn9vjgyln9goppbe8up` (`resource_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_resource`
--

LOCK TABLES `client_resource` WRITE;
/*!40000 ALTER TABLE `client_resource` DISABLE KEYS */;
INSERT INTO `client_resource` VALUES (1,1);
/*!40000 ALTER TABLE `client_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_scope`
--

DROP TABLE IF EXISTS `client_scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_scope` (
  `client_id` bigint(20) NOT NULL,
  `scope_id` bigint(20) NOT NULL,
  PRIMARY KEY (`client_id`,`scope_id`),
  KEY `FKj6mxw6pvppit3ehruqk0fbwpe` (`scope_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_scope`
--

LOCK TABLES `client_scope` WRITE;
/*!40000 ALTER TABLE `client_scope` DISABLE KEYS */;
INSERT INTO `client_scope` VALUES (1,1);
/*!40000 ALTER TABLE `client_scope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_approval`
--

DROP TABLE IF EXISTS `oauth_approval`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_approval` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `expires_at` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tojwelh71b4fdjjrqvoljqfqv` (`name`),
  KEY `FKf0vchujwiv8ax7hpjgec7g6mc` (`client_id`),
  KEY `FK3bjrqua90d1ej3heecowgoa2c` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_approval`
--

LOCK TABLES `oauth_approval` WRITE;
/*!40000 ALTER TABLE `oauth_approval` DISABLE KEYS */;
INSERT INTO `oauth_approval` VALUES (1,'2017-09-04 22:44:37','2017-09-04 22:44:37',NULL,'string','APPROVED',NULL,NULL,NULL);
/*!40000 ALTER TABLE `oauth_approval` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_approval_scope`
--

DROP TABLE IF EXISTS `oauth_approval_scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_approval_scope` (
  `oauth_approval_id` bigint(20) NOT NULL,
  `scope_id` bigint(20) NOT NULL,
  `approval_id` bigint(20) NOT NULL,
  PRIMARY KEY (`oauth_approval_id`,`scope_id`),
  KEY `FKd9d351ii75r7vtbg2m1dcwnsg` (`scope_id`),
  KEY `FK65aeg11208kapv2x2t9qr5d4y` (`approval_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_approval_scope`
--

LOCK TABLES `oauth_approval_scope` WRITE;
/*!40000 ALTER TABLE `oauth_approval_scope` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_approval_scope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_authority`
--

DROP TABLE IF EXISTS `oauth_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_authority`
--

LOCK TABLES `oauth_authority` WRITE;
/*!40000 ALTER TABLE `oauth_authority` DISABLE KEYS */;
INSERT INTO `oauth_authority` VALUES (1,'2017-09-02 21:36:58','2017-09-02 21:36:58','ROLE_USER',NULL);
/*!40000 ALTER TABLE `oauth_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_client`
--

DROP TABLE IF EXISTS `oauth_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `additional_information` text,
  `client_id` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `grant_types` varchar(255) DEFAULT NULL,
  `redirect_uri` varchar(255) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6tiq1b1cchcusg2t6oe5mv8qw` (`client_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_client`
--

LOCK TABLES `oauth_client` WRITE;
/*!40000 ALTER TABLE `oauth_client` DISABLE KEYS */;
INSERT INTO `oauth_client` VALUES (1,'2017-09-09 19:44:48','2017-09-09 19:44:48',1000000,'{}','mcloud-blog','$2a$08$zW51jdV8.3xcbyBEQQWtaOZsewbPmTqSUIzrkfCSB3PEYA9hmQ.3y','CODE,CLIENT_CREDENTIALS,REFRESH_TOKEN,IMPLICIT,PASSWORD','https://www.getpostman.com/oauth2/callback',1000000,NULL);
/*!40000 ALTER TABLE `oauth_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_resources`
--

DROP TABLE IF EXISTS `oauth_resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ce9njkq29gsvi07cnu71gbbn1` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_resources`
--

LOCK TABLES `oauth_resources` WRITE;
/*!40000 ALTER TABLE `oauth_resources` DISABLE KEYS */;
INSERT INTO `oauth_resources` VALUES (1,'2017-09-02 21:36:46','2017-09-02 21:36:46','userinfo',NULL);
/*!40000 ALTER TABLE `oauth_resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_scope`
--

DROP TABLE IF EXISTS `oauth_scope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_scope` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7hoilwb3g67jnwsab08oe4hyn` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_scope`
--

LOCK TABLES `oauth_scope` WRITE;
/*!40000 ALTER TABLE `oauth_scope` DISABLE KEYS */;
INSERT INTO `oauth_scope` VALUES (1,'2017-09-02 21:35:52','2017-09-02 21:35:52','read',NULL);
/*!40000 ALTER TABLE `oauth_scope` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_user`
--

DROP TABLE IF EXISTS `oauth_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `modified_date` datetime DEFAULT NULL,
  `password` varchar(1024) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7prjgk5n8h0qbu5yggg933swc` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_user`
--

LOCK TABLES `oauth_user` WRITE;
/*!40000 ALTER TABLE `oauth_user` DISABLE KEYS */;
INSERT INTO `oauth_user` VALUES (1,'2017-10-10 23:09:23','$2a$08$SuFiBd.szqVhlq3nkTO6dOGf9E9G/SieJFoTln7Z/Y5YgB8f9tP1i','user','2017-10-10 23:09:23');
/*!40000 ALTER TABLE `oauth_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_authority`
--

DROP TABLE IF EXISTS `user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`authority_id`),
  KEY `FKibm0ptairmvui7tm2icpdpwmq` (`authority_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_authority`
--

LOCK TABLES `user_authority` WRITE;
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
INSERT INTO `user_authority` VALUES (1,1);
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-11 20:35:47
