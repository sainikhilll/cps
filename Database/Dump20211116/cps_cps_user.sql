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
-- Table structure for table `cps_user`
--

DROP TABLE IF EXISTS `cps_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cps_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cps_user`
--

LOCK TABLES `cps_user` WRITE;
/*!40000 ALTER TABLE `cps_user` DISABLE KEYS */;
INSERT INTO `cps_user` VALUES (1,'admin@rev.com','123db','admin'),(2,'sdas@gmail.com','123db','owner'),(3,'hakuna@yahoo.com','123','passenger'),(7,'divya@gmail.com','123','passenger'),(8,'rohit@gmail.com','123','passenger'),(9,'supriya@gmail.com','123','passenger'),(10,'venkata@gmail.com','123','passenger'),(15,'gvr907@gmail.com','123','owner'),(17,'preethi@gmail.com','123','passenger'),(20,'sana@gmail.com','123','passenger'),(23,'sana@gmail.com','123','passenger'),(24,'tia@gmail.com','123','passenger'),(32,'gvr907@gmail.com','123','owner'),(37,'amita@gmail.com','123','passenger'),(38,'rinki@gmail.com','123','passenger'),(39,'arushi@gmail.com','123','passenger'),(40,'jimin@gmail.com','123','passenger'),(42,'sahith@gmail.com','Sahith@45','passenger'),(43,'admin2@rev.com','111','admin'),(47,'radha@gmail.com','1233455','owner'),(48,'chaitu@gmail.com','1234db','passenger'),(49,'nickky@gmail.com','3256637','passenger'),(50,'md@gmail.com','admin','passenger'),(51,'ashupandey358@gmail.com','@Shu12345','owner'),(52,'lewis@gmail.com','Lewis123@','owner'),(53,'max@gmail.com','abcdef','passenger'),(54,'chandra@gmail.com','Password123$','owner');
/*!40000 ALTER TABLE `cps_user` ENABLE KEYS */;
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

-- Dump completed on 2021-11-16 10:38:14
