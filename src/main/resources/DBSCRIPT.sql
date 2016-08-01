CREATE DATABASE  IF NOT EXISTS `worker` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `worker`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: worker
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_admin`
--

LOCK TABLES `w_admin` WRITE;
/*!40000 ALTER TABLE `w_admin` DISABLE KEYS */;
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
  `W_CE_SCHEDULE_ID` int(11) NOT NULL,
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
  `CREATE_TIME` datetime NOT NULL,
  `MODIFI_TIME` datetime NOT NULL,
  `MODIFI_AUTHOR` varchar(45) NOT NULL,
  `DATALEVEL` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
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
  `W_M_REGISTER_TIME` datetime NOT NULL,
  `W_M_LAST_LOGIN_TIME` datetime NOT NULL,
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
-- Table structure for table `w_order`
--

DROP TABLE IF EXISTS `w_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_order` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `W_O_MEMBERS_ID` int(11) NOT NULL,
  `W_O_SUPPLIER_ID` int(11) NOT NULL,
  `W_O_ORDER_NO` varchar(10) NOT NULL,
  `W_O_PAY_TYPE` int(11) NOT NULL,
  `W_O_FEE` decimal(10,2) NOT NULL,
  `W_O_IS_END` int(11) NOT NULL,
  `W_O_IS_CONFIM` int(11) NOT NULL,
  `W_O_IS_PAY` int(11) NOT NULL,
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
  `W_O_SCHEDULE_ID` int(11) NOT NULL,
  `W_O_CONTACT` varchar(8) NOT NULL,
  `W_O_CITY` varchar(16) NOT NULL,
  `W_O_DISTRICT` varchar(16) NOT NULL,
  `W_O_TELEPHONE` varchar(20) NOT NULL,
  `W_O_ADDRESS` varchar(128) NOT NULL,
  `W_O_SUPPLIER_NAME` varchar(32) NOT NULL,
  `W_O_BEGIN_TIME` datetime NOT NULL,
  `W_O_END_TIME` datetime NOT NULL,
  `W_O_HOUR` int(11) NOT NULL,
  `W_O_STAFF_COUNT` int(11) NOT NULL,
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
  `W_S_SERVICE_TYPE` int(11) NOT NULL,
  `W_S_TITLE` varchar(64) DEFAULT NULL,
  `W_S_SCORE` int(11) NOT NULL,
  `W_S_WORK_COUNT` int(11) NOT NULL,
  `W_S_DESC` varchar(300) DEFAULT NULL,
  `W_S_COMPLAINT_COUNT` int(11) NOT NULL,
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
  `W_S_NAME` varchar(32) NOT NULL,
  `W_S_CITY` varchar(16) NOT NULL,
  `W_S_DISTRICT` varchar(16) NOT NULL,
  `W_S_ADDRESS` varchar(128) NOT NULL,
  `W_S_TELEPHONE` varchar(20) NOT NULL,
  `W_S_WEBSITE` varchar(128) DEFAULT NULL,
  `W_S_CONTACT` varchar(8) NOT NULL,
  `W_S_SECTOR` int(11) NOT NULL,
  `W_S_GRADE` int(11) NOT NULL,
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
-- Dumping data for table `w_supplier`
--

LOCK TABLES `w_supplier` WRITE;
/*!40000 ALTER TABLE `w_supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `w_supplier` ENABLE KEYS */;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-01 18:57:09
