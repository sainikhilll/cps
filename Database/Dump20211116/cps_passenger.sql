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
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `date_of_birth` date NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `passenger_user_fk_idx` (`user_id`),
  CONSTRAINT `passenger_user_fk` FOREIGN KEY (`user_id`) REFERENCES `cps_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,'hyd','980','1999-12-26',1),(2,'priya','777777777','1996-02-01',1),(3,'neha','7775467293','1998-04-06',2),(4,'neha','7775467293','1998-04-06',2),(5,'riya','736483274','1970-01-01',3),(6,'riya','736483274','1970-01-01',3),(7,'riya','736483274','1970-01-01',3),(8,'riya','736483274','1970-01-01',3),(9,'divya','6737693673','1970-01-02',7),(10,'rohit','636676739','1970-01-01',8),(11,'supriya','371687839','2021-11-10',9),(12,'venkata','3676879839','2021-11-23',10),(13,'preethi','3627468279','2021-11-08',17),(14,'sana','7856234782','2021-11-09',20),(15,'sana','4575467293','1999-04-06',23),(16,'tia','4575467293','1999-04-06',24),(17,'rinki','4575467254','1999-04-06',38),(18,'jimin','6557068455','2021-11-07',40),(19,'nickky','7467637367','2021-11-05',49),(20,'md sibghat','4569823170','2000-03-28',50),(21,'sahith','8978978911','2021-02-21',42),(22,'Max Versatppen','1234432112','2020-02-13',53);
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
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

-- Dump completed on 2021-11-16 10:38:18
