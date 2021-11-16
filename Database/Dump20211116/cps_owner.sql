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
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `licence_number` varchar(30) DEFAULT NULL,
  `licence_url` varchar(2000) DEFAULT NULL,
  `aadhar_number` varchar(15) DEFAULT NULL,
  `aadhar_url` varchar(2000) DEFAULT NULL,
  `user_id` int NOT NULL,
  `owner_preference_id` int DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `owner_user_fk_idx` (`user_id`),
  KEY `owner_preference_fk_idx` (`owner_preference_id`),
  CONSTRAINT `owner_preference_fk` FOREIGN KEY (`owner_preference_id`) REFERENCES `owner_preference` (`id`),
  CONSTRAINT `owner_user_fk` FOREIGN KEY (`user_id`) REFERENCES `cps_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (3,'Virat Kohali','Flat no. 45, Defense colony, New street Delhi, India. 457855','9874563210','DL457844','licence.com','478562154854','aadhar.com',3,3,'Pending'),(6,'Sanjoy Das','4, Central Park, Bandipur Road, Bansdroni, Kolkata - 700070','012345678','ABCD1234','licence.com','4785621590','aadhar.com',2,1,'Pending'),(8,'hakuna','Assam','7418529630','DL11111','licence.com','4785621593','aadhar.com',3,3,'Approved'),(9,'Arshatullah Mohammed','India','7777777777','DL9999999','licence.com','4785621594','aadhar.com',3,3,'Approved'),(10,'Sibghatullah Mohammed','India','9999999999','DL8888888','licence.com','4785621595','aadhar.com',2,2,'Approved'),(12,'Radha K','new street mumbai india 445522','0123456781','DL6666667','licence.com','478562159700','aadhar.com',47,28,'Approved'),(13,'Venkata Ramana Gunuputi','India','5555555555','DL5555555','licence.com','4785621598','aadhar.com',3,3,'Approved'),(14,'Ashu Pandey','India','4444444444','DL5555556','licence.com','4785621599','aadhar.com',3,3,'Approved'),(15,'Sai Nikhil Amaravadi','India','4444444445','DL5555557','licence.com','4785621600','aadhar.com',3,3,'Approved'),(16,'Supriya Kumari','India','4444444446','DL5555558','licence.com','4785621601','aadhar.com',3,3,'Rejected'),(17,'Sonia Seelam','India','4444444447','DL5555559','licence.com','4785621602','aadhar.com',3,3,'Approved'),(18,'Chaitanya Bommisetty','India','4444444448','DL5555560','licence.com','4785621603','aadhar.com',3,3,'Approved'),(19,'Bugude Preethi','India','4444444449','DL5555561','licence.com','4785621604','aadhar.com',3,3,'Approved'),(20,'Abhishek Sigh','India','4444444443','DL5555562','licence.com','4785621605','aadhar.com',3,3,'Rejected'),(21,'Pallavi','India','4444444442','DL5555563','licence.com','4785621606','aadhar.com',3,3,'Approved'),(22,'Rushikesh Tokmurke','India','4444444441','DL5555564','licence.com','4785621607','aadhar.com',3,3,'Approved'),(23,'Preetham Reddy Kadapana','India','4444444440','DL5555565','licence.com','4785621608','aadhar.com',3,3,'Approved'),(45,'ASHU PANDEYYY','j 497 darpan colonyYYYY','1234567890','MP 072015112345','','123456789012','',51,71,'Approved'),(46,'Lewis Ham','1-5-590,balaji colony, Tirupathi','7799443311','DL-123457','','123456789322','',52,72,'Approved'),(47,'Chandrasekaran','78 Gandhi Street','1234567890','234234234234','','123456789012','',54,73,'Pending');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
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

-- Dump completed on 2021-11-16 10:38:16
