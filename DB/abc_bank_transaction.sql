-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: abc_bank
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `tID` int NOT NULL AUTO_INCREMENT,
  `accNumber` int NOT NULL,
  `amount` float NOT NULL,
  `date_Time` datetime NOT NULL,
  `type` varchar(45) NOT NULL,
  `destinationAccID` int DEFAULT NULL,
  PRIMARY KEY (`tID`),
  KEY `FKrqvshdxv10oxta3act72t3p9h` (`accNumber`),
  CONSTRAINT `FKrqvshdxv10oxta3act72t3p9h` FOREIGN KEY (`accNumber`) REFERENCES `account` (`accNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,1,112,'1999-03-22 10:06:07','d',0),(2,1,112,'1999-03-22 10:06:07','w',0),(3,1,112,'1999-03-22 10:06:07','w',0),(4,1,112,'1999-03-22 10:06:07','d',0),(5,1,102,'1999-03-22 10:06:07','w',0),(6,3,1000,'2022-05-03 17:36:07','d',0),(7,3,100,'2022-05-03 17:36:07','w',0),(8,3,100,'2022-05-03 17:36:07','t',1),(9,3,1,'2022-05-03 17:36:07','d',0),(10,1,1,'2022-05-03 17:36:07','d',1),(11,3,120,'2022-05-03 17:36:07','t',1),(12,3,200,'2022-05-03 17:36:07','t',1),(13,3,505484,'2022-05-03 17:36:07','t',1),(14,1,30,'2022-05-03 17:36:07','t',3),(15,1,30,'2022-05-03 17:36:07','t',3),(16,1,764,'2022-05-03 17:36:07','t',3),(17,3,234,'2022-05-03 17:36:07','t',1),(18,3,1,'2022-05-03 17:36:07','d',0),(19,3,1,'2022-05-03 17:36:07','d',0),(20,1,25,'2022-05-03 17:36:07','w',0),(21,3,444,'2022-05-03 17:36:07','w',0),(22,6,50,'2022-05-03 17:36:07','t',1),(23,6,52,'2022-05-03 17:36:07','d',0),(24,6,48,'2022-05-03 17:36:07','w',0),(25,1,112,'1999-03-22 16:06:07','w',0),(26,1,112,'1999-03-22 16:06:07','w',0),(27,1,112,'1999-03-22 16:06:07','w',0),(28,1,50662,'1999-03-22 16:06:07','w',0),(29,1,455960,'1999-03-22 16:06:07','w',0);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-17 12:04:25
