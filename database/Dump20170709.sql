-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: mmp
-- ------------------------------------------------------
-- Server version	5.7.18

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

--
-- Table structure for table `tb_device`
--

DROP TABLE IF EXISTS `tb_device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_device` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `system` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_device`
--

LOCK TABLES `tb_device` WRITE;
/*!40000 ALTER TABLE `tb_device` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_organization`
--

DROP TABLE IF EXISTS `tb_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_organization` (
  `id` varchar(255) NOT NULL,
  `available` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `priority` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_organization`
--

LOCK TABLES `tb_organization` WRITE;
/*!40000 ALTER TABLE `tb_organization` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_permission`
--

DROP TABLE IF EXISTS `tb_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_permission` (
  `id` varchar(255) NOT NULL,
  `available` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `priority` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_permission`
--

LOCK TABLES `tb_permission` WRITE;
/*!40000 ALTER TABLE `tb_permission` DISABLE KEYS */;
INSERT INTO `tb_permission` VALUES ('fh32f7y72y37ry32r27','','用户添加','1','0/1','user:add',1,'button','user/add'),('hdhewfh2378fg438fg2','','用户删除','1',NULL,NULL,0,NULL,NULL),('rh438rh348h283r723yr2','','用户管理','0','0/','user:view',0,'menu','user/list');
/*!40000 ALTER TABLE `tb_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role`
--

DROP TABLE IF EXISTS `tb_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_role` (
  `id` varchar(255) NOT NULL,
  `available` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role`
--

LOCK TABLES `tb_role` WRITE;
/*!40000 ALTER TABLE `tb_role` DISABLE KEYS */;
INSERT INTO `tb_role` VALUES ('ddewhfiwh2e823','','VIP会员',NULL,'vip'),('H23D236DT16EG12EG12','','管理员',NULL,'admin');
/*!40000 ALTER TABLE `tb_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role_permission`
--

DROP TABLE IF EXISTS `tb_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_role_permission` (
  `rid` varchar(255) NOT NULL,
  `pid` varchar(255) NOT NULL,
  KEY `FK3jufuj591o1efc9pbvcv477rd` (`pid`),
  KEY `FKrnp5jy17kewgeejdaniwu7dnf` (`rid`),
  CONSTRAINT `FK3jufuj591o1efc9pbvcv477rd` FOREIGN KEY (`pid`) REFERENCES `tb_permission` (`id`),
  CONSTRAINT `FKrnp5jy17kewgeejdaniwu7dnf` FOREIGN KEY (`rid`) REFERENCES `tb_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role_permission`
--

LOCK TABLES `tb_role_permission` WRITE;
/*!40000 ALTER TABLE `tb_role_permission` DISABLE KEYS */;
INSERT INTO `tb_role_permission` VALUES ('H23D236DT16EG12EG12','rh438rh348h283r723yr2'),('H23D236DT16EG12EG12','fh32f7y72y37ry32r27');
/*!40000 ALTER TABLE `tb_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `id` varchar(255) NOT NULL,
  `locked` int(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES ('2c9067945d25720d015d25739e1c0001',0,'a0f8adfc2091a4f5ad0bbb39144658ae','ee6cf963affe12c69c5a24d113013314','test2222',NULL,NULL),('2c9067945d25720d015d2573d0dd0002',0,'d43bf30f9c419a6711d289aa9a31e5ad','c6284bee5ab917138fa8d8371388e78c','test3333',NULL,NULL),('2c9067945d25720d015d2573fd4f0003',0,'f127199bf97d6a6cbb3cff676e1aee96','d338eeeaa0bb6c4e5fa911a6f2c6c9a8','test4444',NULL,NULL),('2c9067945d25720d015d257428b90004',0,'f616c4696e95ad57f2d64bd73b824b18','173a2c7cd4357e8cb45be48463fea2de','test55555',NULL,NULL),('2c9067945d25b043015d25b75a220000',0,'232e514314c01b1b761b3c1e93624b23','f6cf939244ba413d4262ccb3b255b869','test6666',NULL,NULL),('2c9067945d25d1c3015d25d24d4f0000',0,'d1243c7c5fe42075d06ca4055e9635d2','5557f1190494af86bf87d43513e74749','date1111','2017-07-09 13:28:45','2017-07-09 13:29:44'),('DHF347R23RY',0,'d3c59d25033dbf980d29554025c23a75','8d78869f470951332959580424d4bf4f','admin','2017-07-09 13:28:45','2017-07-09 13:28:45');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_role`
--

DROP TABLE IF EXISTS `tb_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_role` (
  `rid` varchar(255) NOT NULL,
  `uid` varchar(255) NOT NULL,
  KEY `FKp113c9l86ie6f8ou2ye6pvnxi` (`uid`),
  KEY `FKm80juwiueguiukgrqrvfcu5hf` (`rid`),
  CONSTRAINT `FKm80juwiueguiukgrqrvfcu5hf` FOREIGN KEY (`rid`) REFERENCES `tb_role` (`id`),
  CONSTRAINT `FKp113c9l86ie6f8ou2ye6pvnxi` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_role`
--

LOCK TABLES `tb_user_role` WRITE;
/*!40000 ALTER TABLE `tb_user_role` DISABLE KEYS */;
INSERT INTO `tb_user_role` VALUES ('H23D236DT16EG12EG12','DHF347R23RY'),('ddewhfiwh2e823','DHF347R23RY');
/*!40000 ALTER TABLE `tb_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-09 13:37:14
