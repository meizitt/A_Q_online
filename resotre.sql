-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: q_a
-- ------------------------------------------------------
-- Server version	5.6.48-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comm_q`
--

DROP TABLE IF EXISTS `comm_q`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comm_q` (
  `q_id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `answer` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`q_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comm_q`
--

LOCK TABLES `comm_q` WRITE;
/*!40000 ALTER TABLE `comm_q` DISABLE KEYS */;
/*!40000 ALTER TABLE `comm_q` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab_q`
--

DROP TABLE IF EXISTS `lab_q`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab_q` (
  `q_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) DEFAULT NULL,
  `stu_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tch_id` int(11) DEFAULT NULL,
  `tch_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sub_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `answer_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `q_text` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `answer_text` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`q_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_q`
--

LOCK TABLES `lab_q` WRITE;
/*!40000 ALTER TABLE `lab_q` DISABLE KEYS */;
/*!40000 ALTER TABLE `lab_q` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stu`
--

DROP TABLE IF EXISTS `stu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stu` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `sex` char(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `class_num` int(11) DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`stu_id`,`stu_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stu`
--

LOCK TABLES `stu` WRITE;
/*!40000 ALTER TABLE `stu` DISABLE KEYS */;
INSERT INTO `stu` VALUES (1,'xxx',NULL,NULL,NULL);
/*!40000 ALTER TABLE `stu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tch`
--

DROP TABLE IF EXISTS `tch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tch` (
  `tch_id` int(11) NOT NULL AUTO_INCREMENT,
  `tch_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `sex` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bir` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `major` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `part_time_teach` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `app_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phonenum` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`tch_id`,`tch_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tch`
--

LOCK TABLES `tch` WRITE;
/*!40000 ALTER TABLE `tch` DISABLE KEYS */;
/*!40000 ALTER TABLE `tch` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-12 22:59:22
