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
-- Table structure for table `trip_bookings`
--

DROP TABLE IF EXISTS `trip_bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip_bookings` (
  `id` int NOT NULL AUTO_INCREMENT,
  `trip_id` int NOT NULL,
  `passenger_id` int NOT NULL,
  `seats_booked` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `trip_fk_idx` (`trip_id`),
  KEY `passenger_fk_idx` (`passenger_id`),
  CONSTRAINT `passenger_fk` FOREIGN KEY (`passenger_id`) REFERENCES `passenger` (`id`),
  CONSTRAINT `trip_fk` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_bookings`
--

LOCK TABLES `trip_bookings` WRITE;
/*!40000 ALTER TABLE `trip_bookings` DISABLE KEYS */;
INSERT INTO `trip_bookings` VALUES (1,1,1,2),(2,1,1,2),(3,1,1,2),(4,3,1,1),(5,3,1,1),(6,3,1,4),(7,1,1,3),(8,1,1,0),(9,1,1,2),(10,1,1,1),(11,1,1,1),(12,1,1,1),(13,1,1,1),(14,1,1,2),(15,1,1,3),(16,1,1,2),(17,1,1,1),(18,1,1,0),(19,1,1,0),(20,1,1,0),(21,1,1,0),(22,1,1,0),(23,1,1,1),(24,1,1,3),(25,1,1,1),(26,1,1,1),(27,1,1,2),(28,1,1,23),(29,1,1,2),(30,1,1,2),(31,1,1,2),(32,1,1,2),(33,1,1,3),(34,1,1,100),(35,10,1,2),(36,10,1,0),(37,10,1,0),(38,10,1,1),(39,10,1,1),(40,10,1,1),(41,10,1,1),(42,10,1,5),(43,10,1,5),(44,10,1,1),(46,10,21,2),(47,10,22,1),(48,10,22,1),(49,10,22,1),(50,25,22,1),(51,25,22,1),(52,26,21,1);
/*!40000 ALTER TABLE `trip_bookings` ENABLE KEYS */;
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

-- Dump completed on 2021-11-16 10:38:19
