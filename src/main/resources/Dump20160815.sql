CREATE DATABASE  IF NOT EXISTS `worker` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `worker`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: worker
-- ------------------------------------------------------
-- Server version	5.5.40

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
-- Table structure for table `w_admin`
--

DROP TABLE IF EXISTS `w_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_admin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_A_SUPPLIER_ID` int(11) NOT NULL,
  `W_A_USERNAME` varchar(30) NOT NULL,
  `W_A_PASSWORD` varchar(64) NOT NULL,
  `W_A_REAL_NAME` varchar(8) NOT NULL,
  `W_A_TELEPHONE` varchar(20) NOT NULL,
  `W_A_ROLE_ID` int(11) NOT NULL,
  `W_A_LAST_LOG_TIME` datetime DEFAULT NULL,
  `W_A_LOGIN_IP` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_admin`
--

LOCK TABLES `w_admin` WRITE;
/*!40000 ALTER TABLE `w_admin` DISABLE KEYS */;
INSERT INTO `w_admin` VALUES (1,1,'admin','B28C8D15FE545A341430487244227801','reagan','13983272841',9,'2016-08-15 04:39:27','2016-08-08 00:00:00','2016-08-08 00:00:00','system','2016-08-08 00:00:00','system',1,1);
/*!40000 ALTER TABLE `w_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_certificore`
--

DROP TABLE IF EXISTS `w_certificore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_certificore` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_CE_STAFF_ID` int(11) NOT NULL,
  `W_CE_NAME` varchar(64) NOT NULL,
  `W_CE_ATTAC_ID` int(11) NOT NULL,
  `W_CE_VALID_TIME` datetime NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_certificore`
--

LOCK TABLES `w_certificore` WRITE;
/*!40000 ALTER TABLE `w_certificore` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_certificore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_comment`
--

DROP TABLE IF EXISTS `w_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_comment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_MEMBERS_ID` int(11) NOT NULL,
  `W_STAFF_ID` int(11) NOT NULL,
  `W_C_TITLE` varchar(100) NOT NULL,
  `W_C_CONTENT` varchar(300) NOT NULL,
  `W_C_NICKNAME` varchar(30) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_comment`
--

LOCK TABLES `w_comment` WRITE;
/*!40000 ALTER TABLE `w_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_contact`
--

DROP TABLE IF EXISTS `w_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_contact` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_C_MEMBERS_ID` int(11) NOT NULL,
  `W_C_CONTACT` varchar(8) NOT NULL,
  `W_C_CITY` varchar(16) NOT NULL,
  `W_C_DISTRICT` varchar(16) NOT NULL,
  `W_C_TELEPHONE` varchar(20) NOT NULL,
  `W_C_ADDRESS` varchar(128) NOT NULL,
  `W_C_DEFAULT` int(11) NOT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_contact`
--

LOCK TABLES `w_contact` WRITE;
/*!40000 ALTER TABLE `w_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_coupon`
--

DROP TABLE IF EXISTS `w_coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_coupon` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_C_COUPON_NO` varchar(10) DEFAULT NULL,
  `W_C_TITLE` varchar(120) NOT NULL,
  `W_C_TYPE` int(11) NOT NULL,
  `W_C_DESC` varchar(45) NOT NULL,
  `W_C_ATTAC_ID` int(11) NOT NULL,
  `W_C_MONEY` decimal(10,2) NOT NULL,
  `W_C_DISCOUNT` float NOT NULL,
  `W_C_BEGIN_TIME` datetime NOT NULL,
  `W_C_END_TIME` datetime NOT NULL,
  `W_C_PUBLISHI_COUNT` int(11) NOT NULL,
  `W_IS_END` int(11) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_coupon`
--

LOCK TABLES `w_coupon` WRITE;
/*!40000 ALTER TABLE `w_coupon` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_member_coupon`
--

DROP TABLE IF EXISTS `w_member_coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_member_coupon` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_MC_MEMBER_ID` int(11) NOT NULL,
  `W_MC_COUPON_ID` int(11) NOT NULL,
  `W_MC_COUPON_TITLE` varchar(120) DEFAULT NULL,
  `W_MC_COUPON_TYPE` int(11) DEFAULT NULL,
  `W_MC_USE_DATE` datetime NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_member_coupon`
--

LOCK TABLES `w_member_coupon` WRITE;
/*!40000 ALTER TABLE `w_member_coupon` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_member_coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_member_detail`
--

DROP TABLE IF EXISTS `w_member_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_member_detail` (
  `ID` int(11) NOT NULL,
  `W_MD_COUPON_COUNT` int(11) NOT NULL,
  `W_MD_USE_COUNT` int(11) NOT NULL,
  `W_MD_SCORE` int(11) NOT NULL,
  `W_MD_GARDE` int(11) NOT NULL,
  `W_MD_BIRTHDAY` date DEFAULT NULL,
  `W_MD_OCCUPATION` varchar(30) DEFAULT NULL,
  `CREATE_AUTHOR` varchar(45) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_member_detail`
--

LOCK TABLES `w_member_detail` WRITE;
/*!40000 ALTER TABLE `w_member_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_member_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_member_login_log`
--

DROP TABLE IF EXISTS `w_member_login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_member_login_log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_ML_MEMBER_ID` int(11) NOT NULL,
  `W_ML_MOBILE` varchar(20) NOT NULL,
  `W_ML_LOGIN_DATE` datetime NOT NULL,
  `W_ML_LOGIN_IP` varchar(64) DEFAULT NULL,
  `W_ML_LOGIN_SRC` int(11) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_member_login_log`
--

LOCK TABLES `w_member_login_log` WRITE;
/*!40000 ALTER TABLE `w_member_login_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_member_login_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_members`
--

DROP TABLE IF EXISTS `w_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_members` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_M_MOBILE` varchar(20) NOT NULL,
  `W_M_FACE` int(11) NOT NULL,
  `W_M_PASSWORD` varchar(64) NOT NULL,
  `W_M_NICKNAME` varchar(30) DEFAULT NULL,
  `W_M_LOGIN_IP` varchar(64) NOT NULL,
  `W_M_REG_TIME` datetime NOT NULL,
  `W_M_REG_DEVICE` varchar(10) DEFAULT NULL,
  `W_M_REG_IP` varchar(64) NOT NULL,
  `CREATE_AUTHOR` varchar(45) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_members`
--

LOCK TABLES `w_members` WRITE;
/*!40000 ALTER TABLE `w_members` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_menu`
--

DROP TABLE IF EXISTS `w_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_menu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_M_ITEM` varchar(30) NOT NULL,
  `W_M_URL` varchar(120) NOT NULL,
  `W_M_ROLE_ID` int(11) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_menu`
--

LOCK TABLES `w_menu` WRITE;
/*!40000 ALTER TABLE `w_menu` DISABLE KEYS */;
INSERT INTO `w_menu` VALUES (1,'渠道管理','/supplier/list/all/1.html',9,'2016-08-08 00:00:00','system','2016-08-08 00:00:00','system',1,1),(2,'管理员管理','/admin/list/all/1.html',8,'2016-08-08 00:00:00','system','2016-08-08 00:00:00','system',1,1),(3,'保洁服务','/task/list/all/1.html',1,'2016-08-08 00:00:00','system','2016-08-08 00:00:00','system',1,1),(4,'人员管理','/admin/list/all/1.html',1,'2016-08-08 00:00:00','system','2016-08-08 00:00:00','system',1,1),(5,'订单确认','/admin/list/all/1.html',1,'2016-08-08 00:00:00','system','2016-08-08 00:00:00','system',1,1),(6,'交易流水','/admin/list/all/1.html',1,'2016-08-08 00:00:00','system','2016-08-08 00:00:00','system',1,1),(7,'会员管理','/admin/list/all/1.html',8,'2016-08-08 00:00:00','system','2016-08-08 00:00:00','system',1,1);
/*!40000 ALTER TABLE `w_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_order`
--

DROP TABLE IF EXISTS `w_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_order` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_O_MEMBERS_ID` int(11) NOT NULL,
  `W_O_SUPPLIER_ID` int(11) NOT NULL,
  `W_O_SERVICE_NAME` varchar(300) DEFAULT NULL,
  `W_O_ORDER_NO` varchar(10) NOT NULL,
  `W_O_PAY_TYPE` int(11) NOT NULL,
  `W_O_FEE` decimal(10,2) NOT NULL,
  `W_O_IS_END` int(11) NOT NULL,
  `W_O_IS_CONFIM` int(11) NOT NULL,
  `W_O_IS_PAY` int(11) NOT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_order`
--

LOCK TABLES `w_order` WRITE;
/*!40000 ALTER TABLE `w_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_order_detail`
--

DROP TABLE IF EXISTS `w_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_order_detail` (
  `ID` int(11) NOT NULL,
  `W_O_STIFF_ID` int(11) NOT NULL,
  `W_O_TASK_ID` int(11) DEFAULT NULL,
  `W_O_SUPPLIER_NAME` varchar(32) NOT NULL,
  `W_O_CONTACT` varchar(8) NOT NULL,
  `W_O_CITY` varchar(16) NOT NULL,
  `W_O_DISTRICT` varchar(16) NOT NULL,
  `W_O_TELEPHONE` varchar(20) NOT NULL,
  `W_O_STAFF_TELEPHONE` varchar(20) NOT NULL,
  `W_O_STAFF_CONTACT` varchar(8) DEFAULT NULL,
  `W_O_ADDRESS` varchar(128) NOT NULL,
  `W_O_SUBSCRIBE` datetime NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `STATUS` int(11) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_order_detail`
--

LOCK TABLES `w_order_detail` WRITE;
/*!40000 ALTER TABLE `w_order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_order_staff`
--

DROP TABLE IF EXISTS `w_order_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_order_staff` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_ORDER_DETAIL_ID` int(11) NOT NULL,
  `W_STAFF_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_order_staff`
--

LOCK TABLES `w_order_staff` WRITE;
/*!40000 ALTER TABLE `w_order_staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_order_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_order_task`
--

DROP TABLE IF EXISTS `w_order_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_order_task` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_O_ORDER_ID` int(11) NOT NULL,
  `W_O_TASK_NAME` varchar(30) NOT NULL,
  `W_O_TASK_PRICE` decimal(10,2) NOT NULL,
  `W_O_TASK_PRICE_COUNT` decimal(10,2) NOT NULL,
  `W_O_TASK_ITEM` varchar(30) NOT NULL,
  `W_O_TASK_STAFF_COUNT` int(11) NOT NULL,
  `W_O_TASK_HOURS` int(11) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_order_task`
--

LOCK TABLES `w_order_task` WRITE;
/*!40000 ALTER TABLE `w_order_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_order_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_payrecord`
--

DROP TABLE IF EXISTS `w_payrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_payrecord` (
  `ID` int(11) NOT NULL,
  `W_PR_TRADE_NO` varchar(10) NOT NULL,
  `W_PR_ORDER_NO` varchar(10) NOT NULL,
  `W_PR_COUPON_NO` varchar(10) DEFAULT NULL,
  `W_PR_FEE` decimal(10,2) NOT NULL,
  `W_PR_IS_COUPON` int(11) NOT NULL,
  `W_PR_PAY_CHANNEL` varchar(20) NOT NULL,
  `W_PR_TIMESTAMP` int(11) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_payrecord`
--

LOCK TABLES `w_payrecord` WRITE;
/*!40000 ALTER TABLE `w_payrecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_payrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_ratin`
--

DROP TABLE IF EXISTS `w_ratin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_ratin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_R_SCHEDULE_ID` int(11) NOT NULL,
  `W_R_SCORE` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_ratin`
--

LOCK TABLES `w_ratin` WRITE;
/*!40000 ALTER TABLE `w_ratin` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_ratin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_schedule`
--

DROP TABLE IF EXISTS `w_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_schedule` (
  `ID` int(11) NOT NULL,
  `W_S_STAFF_ID` int(11) NOT NULL,
  `W_S_DATE` datetime NOT NULL,
  `W_S_BEIGN_TIME` datetime NOT NULL,
  `W_S_END_TIME` datetime NOT NULL,
  `W_S_HOUR` int(11) NOT NULL,
  `W_S_DESC` varchar(200) NOT NULL,
  `W_S_SERVICE_TYPE` int(11) NOT NULL,
  `W_S_IS_COMPLETE` int(11) NOT NULL,
  `W_S_IS_TIMEOUT` int(11) NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_schedule`
--

LOCK TABLES `w_schedule` WRITE;
/*!40000 ALTER TABLE `w_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_sms_code`
--

DROP TABLE IF EXISTS `w_sms_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_sms_code` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_SM_TEMP_KEY` varchar(32) NOT NULL,
  `W_SM_MOBILE` varchar(20) NOT NULL,
  `W_SM_CODE` varchar(6) NOT NULL,
  `W_SM_VALID_TIME` datetime DEFAULT NULL,
  `CREATE_AUTHOR` varchar(45) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_sms_code`
--

LOCK TABLES `w_sms_code` WRITE;
/*!40000 ALTER TABLE `w_sms_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_sms_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_sms_template`
--

DROP TABLE IF EXISTS `w_sms_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_sms_template` (
  `W_SM_KEY` varchar(32) NOT NULL,
  `W_SM_CONTENT` varchar(120) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`W_SM_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_sms_template`
--

LOCK TABLES `w_sms_template` WRITE;
/*!40000 ALTER TABLE `w_sms_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_sms_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_staff`
--

DROP TABLE IF EXISTS `w_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_staff` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_S_SUPPLIER_ID` int(11) NOT NULL,
  `W_S_ATTAC_ID` int(11) NOT NULL,
  `W_STAFF_NAME` varchar(8) NOT NULL,
  `W_STAFF_GENDER` int(11) NOT NULL,
  `W_S_IDCARD` varchar(20) NOT NULL,
  `W_S_AGE` int(11) NOT NULL,
  `W_S_WOKER_YEAR` int(11) NOT NULL,
  `W_S_GRADE` int(11) NOT NULL,
  `W_S_TYPE` int(11) NOT NULL,
  `W_S_SCORE` int(11) NOT NULL,
  `W_S_ADDRESS` varchar(100) NOT NULL,
  `W_S_TELEPHONE` varchar(20) NOT NULL,
  `W_S_PLACE` varchar(8) NOT NULL,
  `W_S_ITEMS` varchar(300) NOT NULL,
  `W_S_TERGET` varchar(200) NOT NULL,
  `W_S_WORK_COUNT` int(11) NOT NULL,
  `W_S_DESC` varchar(300) DEFAULT NULL,
  `W_S_COMPLAINT_COUNT` int(11) NOT NULL,
  `W_S_PRICE_FIRST` decimal(10,2) DEFAULT NULL,
  `W_S_PRICE_SECOND` decimal(10,2) DEFAULT NULL,
  `W_S_PRICE_THRID` decimal(10,2) DEFAULT NULL,
  `W_S_REST_DAY` int(11) NOT NULL,
  `W_S_NATION` varchar(10) NOT NULL,
  `W_S_IS_MARRI` int(11) NOT NULL,
  `W_S_ATTRIBUTE` varchar(2) NOT NULL,
  `W_S_EDU` varchar(4) NOT NULL,
  `W_S_TRAIN_ORG` varchar(30) NOT NULL,
  `W_S_TRAIN_DATE` datetime NOT NULL,
  `w_S_TRAIN_ITEMS` varchar(300) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_staff`
--

LOCK TABLES `w_staff` WRITE;
/*!40000 ALTER TABLE `w_staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_supplier`
--

DROP TABLE IF EXISTS `w_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_supplier` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_S_ATTAC_ID` int(11) DEFAULT NULL,
  `W_S_NAME` varchar(32) NOT NULL,
  `W_S_CITY` varchar(16) NOT NULL,
  `W_S_DISTRICT` varchar(16) NOT NULL,
  `W_S_ADDRESS` varchar(128) NOT NULL,
  `W_S_TELEPHONE` varchar(20) NOT NULL,
  `W_S_WEBSITE` varchar(128) DEFAULT NULL,
  `W_S_CONTACT` varchar(8) NOT NULL,
  `W_S_SECTOR` int(11) NOT NULL,
  `W_S_LICENSE` int(11) DEFAULT NULL,
  `W_S_GRADE` int(11) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_supplier`
--

LOCK TABLES `w_supplier` WRITE;
/*!40000 ALTER TABLE `w_supplier` DISABLE KEYS */;
INSERT INTO `w_supplier` VALUES (1,NULL,'超级公司','重庆','南岸区','南坪街道','13983272841','xsh1314.cn','管理员',99999,NULL,99,'2016-08-08 00:00:00','system','2016-08-08 00:00:00','system',1,1),(2,NULL,'重庆市好保姆公司','重庆','南岸区','响水路49号附1号','02382899231','','张邦昌',0,NULL,1,'2016-08-10 14:45:51','admin','2016-08-10 14:45:51','admin',1,1),(3,NULL,'大田家政','重庆','南岸区','南坪西路99号','02382899555','','德川家康',0,NULL,1,'2016-08-10 14:47:47','admin','2016-08-10 16:00:28','admin',1,1),(4,NULL,'重庆周到家政','重庆','南岸区','渝中区邹容路220号','637889523','','李建成',0,NULL,1,'2016-08-10 14:50:49','admin','2016-08-10 16:00:26','admin',1,1),(5,NULL,'山城国高级保姆公司','重庆','南岸区','渝中区邹容路220号','637889523','','山城大纳言',0,NULL,1,'2016-08-10 14:53:41','admin','2016-08-10 17:13:24','admin',1,1),(6,NULL,'山城国高级保姆公司','重庆','南岸区','响水路49号附1号','02382899555','','山城大纳言',0,NULL,1,'2016-08-10 15:05:34','admin','2016-08-10 17:12:36','admin',1,1),(7,NULL,'111111111','重庆','南岸区','1111111111','1111111111','','111111',0,NULL,1,'2016-08-10 17:23:59','admin','2016-08-10 17:23:59','admin',1,1),(8,NULL,'222222','重庆','南岸区','222222222','22222222','','222222',0,NULL,1,'2016-08-10 17:24:27','admin','2016-08-10 17:24:27','admin',1,1),(9,NULL,'33333333','重庆','南岸区','33333333333','33333333','','333333',0,NULL,1,'2016-08-10 17:24:52','admin','2016-08-10 17:24:52','admin',1,1),(10,NULL,'44444444','重庆','南岸区','444444444','4444444444','','444444',0,NULL,1,'2016-08-10 17:26:11','admin','2016-08-10 17:26:11','admin',1,1),(11,NULL,'55555555','3','3','55555555','555555555','','55555555',0,NULL,1,'2016-08-10 17:26:34','admin','2016-08-10 17:26:34','admin',1,1);
/*!40000 ALTER TABLE `w_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_supplier_worker`
--

DROP TABLE IF EXISTS `w_supplier_worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_supplier_worker` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `w_supplier_id` int(11) NOT NULL,
  `w_worker_id` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_supplier_worker`
--

LOCK TABLES `w_supplier_worker` WRITE;
/*!40000 ALTER TABLE `w_supplier_worker` DISABLE KEYS */;
INSERT INTO `w_supplier_worker` VALUES (30,6,11),(29,5,11),(28,4,11),(27,3,11),(26,2,11),(25,1,11);
/*!40000 ALTER TABLE `w_supplier_worker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_transaction`
--

DROP TABLE IF EXISTS `w_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_transaction` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_TR_ORDER_ID` int(11) NOT NULL,
  `W_TR_MEMBERS_ID` int(11) NOT NULL,
  `W_TR_SUPPLIER_ID` int(11) NOT NULL,
  `W_TR_TRADE_NO` varchar(10) NOT NULL,
  `W_TR_ORDER_NO` varchar(10) NOT NULL,
  `W_TR_TYPE` int(11) DEFAULT NULL,
  `W_TR_MONEY` decimal(10,2) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_transaction`
--

LOCK TABLES `w_transaction` WRITE;
/*!40000 ALTER TABLE `w_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_worker_item`
--

DROP TABLE IF EXISTS `w_worker_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_worker_item` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_WI_ITEM` varchar(30) NOT NULL,
  `W_WI_TASK_ID` int(11) DEFAULT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_worker_item`
--

LOCK TABLES `w_worker_item` WRITE;
/*!40000 ALTER TABLE `w_worker_item` DISABLE KEYS */;
INSERT INTO `w_worker_item` VALUES (16,'80',7,'2016-08-15 03:52:26','admin','2016-08-15 03:52:26','admin',1,1),(17,'90',7,'2016-08-15 03:52:26','admin','2016-08-15 03:52:26','admin',1,1),(18,'100',7,'2016-08-15 03:52:26','admin','2016-08-15 03:52:26','admin',1,1),(19,'120',7,'2016-08-15 03:52:27','admin','2016-08-15 03:52:27','admin',1,1),(20,'80',8,'2016-08-15 04:00:12','admin','2016-08-15 04:00:12','admin',1,1),(21,'a1',9,'2016-08-15 04:21:48','admin','2016-08-15 04:21:48','admin',1,1),(22,'a1',10,'2016-08-15 04:34:50','admin','2016-08-15 04:34:50','admin',1,1),(23,'a1',11,'2016-08-15 04:40:18','admin','2016-08-15 04:40:18','admin',1,1);
/*!40000 ALTER TABLE `w_worker_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_worker_staff`
--

DROP TABLE IF EXISTS `w_worker_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_worker_staff` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_WS_TASK_ID` int(11) DEFAULT NULL,
  `W_WS_STAFF_COUNT` int(11) DEFAULT NULL,
  `W_WS_HOURS` int(11) DEFAULT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_worker_staff`
--

LOCK TABLES `w_worker_staff` WRITE;
/*!40000 ALTER TABLE `w_worker_staff` DISABLE KEYS */;
INSERT INTO `w_worker_staff` VALUES (14,7,1,3,'2016-08-15 03:52:27','admin','2016-08-15 03:52:27','admin',1,1),(15,7,2,2,'2016-08-15 03:52:27','admin','2016-08-15 03:52:27','admin',1,1),(16,7,4,3,'2016-08-15 03:52:27','admin','2016-08-15 03:52:27','admin',1,1),(17,8,1,1,'2016-08-15 04:00:12','admin','2016-08-15 04:00:12','admin',1,1),(18,9,1,1,'2016-08-15 04:21:48','admin','2016-08-15 04:21:48','admin',1,1),(19,10,1,1,'2016-08-15 04:34:50','admin','2016-08-15 04:34:50','admin',1,1),(20,11,1,2,'2016-08-15 04:40:19','admin','2016-08-15 04:40:19','admin',1,1);
/*!40000 ALTER TABLE `w_worker_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_worker_task`
--

DROP TABLE IF EXISTS `w_worker_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_worker_task` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_W_SUPPLIER` int(11) DEFAULT NULL,
  `W_W_NAME` varchar(30) NOT NULL,
  `W_W_PRICE` decimal(10,2) NOT NULL,
  `W_W_PRICE_UNIT` int(11) DEFAULT NULL,
  `W_W_TYPE` int(11) DEFAULT NULL,
  `W_W_DESC` varchar(200) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `CREATE_AUTHOR` varchar(30) NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_worker_task`
--

LOCK TABLES `w_worker_task` WRITE;
/*!40000 ALTER TABLE `w_worker_task` DISABLE KEYS */;
INSERT INTO `w_worker_task` VALUES (7,1,'保洁任务',38.00,NULL,NULL,'保洁任务保洁任务保洁任务','2016-08-15 03:52:26','admin','2016-08-15 03:52:33','admin',1,1),(8,1,'保洁任务2',38.00,NULL,NULL,'保洁任务2保洁任务2保洁任务2保洁任务2','2016-08-15 04:00:11','admin','2016-08-15 04:22:21','admin',1,1),(9,NULL,'保洁任务3',38.00,NULL,NULL,'保洁任务3保洁任务3保洁任务3保洁任务3','2016-08-15 04:21:48','admin','2016-08-15 04:22:24','admin',1,1),(10,NULL,'保洁任务3',38.00,NULL,NULL,'保洁任务3保洁任务3保洁任务3','2016-08-15 04:34:50','admin','2016-08-15 04:35:18','admin',1,1),(11,NULL,'保洁任务',38.00,NULL,NULL,'保洁任务保洁任务保洁任务保洁任务保洁任务','2016-08-15 04:40:18','admin','2016-08-15 04:40:27','admin',1,1);
/*!40000 ALTER TABLE `w_worker_task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-15 10:01:41
