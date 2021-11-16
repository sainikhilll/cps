-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: project-3.c06fys7aqkow.ap-south-1.rds.amazonaws.com    Database: cps
-- ------------------------------------------------------
-- Server version	8.0.23

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `owner_preference`
--

DROP TABLE IF EXISTS `owner_preference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owner_preference` (
  `id` int NOT NULL AUTO_INCREMENT,
  `music` char(1) NOT NULL,
  `smoking` char(1) NOT NULL,
  `pets_allowed` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner_preference`
--

LOCK TABLES `owner_preference` WRITE;
/*!40000 ALTER TABLE `owner_preference` DISABLE KEYS */;
INSERT INTO `owner_preference` VALUES (1,'Y','N','Y'),(2,'Y','Y','Y'),(3,'N','Y','Y'),(4,'Y','Y','N'),(5,'Y','N','Y'),(6,'Y','N','Y'),(7,'Y','N','Y'),(8,'Y','N','N'),(9,'Y','Y','Y'),(10,'Y','Y','Y'),(11,'N','Y','N'),(12,'Y','N','N'),(13,'Y','N','N'),(14,'Y','N','N'),(15,'Y','N','N'),(16,'Y','N','N'),(17,'Y','N','Y'),(18,'Y','Y','Y'),(19,'N','Y','N'),(20,'N','Y','Y'),(21,'Y','Y','Y'),(22,'Y','Y','N'),(23,'Y','N','N'),(24,'Y','N','Y'),(25,'N','N','Y'),(26,'Y','N','Y'),(27,'N','N','N'),(28,'Y','Y','Y'),(29,'N','N','Y'),(67,'N','Y','N'),(68,'Y','Y','N'),(69,'Y','N','N'),(70,'Y','N','Y'),(71,'Y','N','Y'),(72,'Y','Y','Y'),(73,'N','N','N');
/*!40000 ALTER TABLE `owner_preference` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-16 10:38:15
