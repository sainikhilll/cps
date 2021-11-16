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
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip` (
  `id` int NOT NULL AUTO_INCREMENT,
  `origin` varchar(45) NOT NULL,
  `destination` varchar(45) NOT NULL,
  `departure_time` time NOT NULL,
  `price` double NOT NULL,
  `date` date NOT NULL,
  `owner_id` int NOT NULL,
  `number_of_passengers` int NOT NULL,
  `number_of_seats_available` int NOT NULL,
  `car_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `owner_fk_idx` (`owner_id`),
  CONSTRAINT `owner_fk` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` VALUES (1,'hyd','goa','07:40:00',3000,'2021-11-10',3,4,-127,'SUV'),(3,'visakhapatnam','goa','08:30:00',5000,'2021-12-09',3,4,4,''),(4,'goa','visakhapatnam','19:00:00',1000,'2021-11-09',3,4,2,''),(5,'hyd','goa','07:20:00',2000,'2021-11-10',8,3,3,''),(6,'hyd','goa','12:00:00',9000,'2021-11-10',6,4,3,''),(7,'Hyderabad','Kurnool','15:20:00',290,'2021-11-07',3,3,3,'Santro'),(8,'Adoni','Kurnool','02:20:00',90,'2021-11-08',3,3,3,'Baleno'),(9,'Hyderabad','Kurnool','02:20:00',2000,'2021-11-07',8,2,1,'Baleno'),(10,'Hyderabad','Kurnool','19:00:00',10000,'2021-11-07',10,4,-1,'Santro'),(11,'Hyderabad','Kurnool','08:30:00',3000,'2021-11-07',6,1,3,'Maruti'),(12,'Kurnool','Mumbai','14:00:00',1000,'2021-12-25',3,3,3,'Glanza'),(13,'Bangalore','Chennai','16:00:00',1500,'2021-11-30',3,2,2,'SUV'),(14,'Bangalore','Chennai','16:00:00',1500,'2021-11-30',6,2,1,'SUV'),(15,'Kadapa','Chennai','02:20:00',1500,'2021-12-12',3,2,2,''),(16,'Bangalore','Mumbai','16:00:00',200,'2021-12-05',3,1,1,''),(17,'Coimbatore','Kurnool','17:30:00',2500,'2021-12-10',3,2,2,''),(19,'Guntur','Kurnool','12:10:00',1200,'2021-12-25',12,3,3,'Compact SUV'),(20,'Hyderabad','Guntur','12:30:00',1000,'2021-12-01',12,2,2,''),(21,'Hyderabad','Bomdila','12:30:00',400,'2021-12-17',12,1,1,''),(22,'Kuppam','Chandannagar','12:25:00',1000,'2021-12-17',12,3,3,''),(23,'Hubli','Balanagar','12:45:00',1000,'2021-12-18',12,1,1,'Compact SUV'),(24,'Gwalior','New Delhi','09:52:00',1200,'2021-12-17',45,4,4,''),(25,'Bangalore','Chennai','21:41:00',500,'2021-12-02',46,2,0,''),(26,'Hyderabad','Chennai','10:30:00',400,'2021-12-04',12,3,2,'Hatchback');
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
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

-- Dump completed on 2021-11-16 10:38:13
