-- MySQL dump 10.13  Distrib 5.1.33, for Win32 (ia32)
--
-- Host: localhost    Database: restaurant
-- ------------------------------------------------------
-- Server version	5.1.33-community

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
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp` (
  `EID` varchar(3) NOT NULL DEFAULT '',
  `Name` varchar(25) DEFAULT NULL,
  `Surname` varchar(25) DEFAULT NULL,
  `Age` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`EID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES ('1','Rahul','Das','20'),('2','John','Cena','25'),('3','Seth','Rollins','24'),('4','Roman','Reigns','27'),('5','Brock','Lesner','30'),('7','Dwayne','Johnson','28');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `Email` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('Admin','pass123','dasrahul0103@gmail.com'),('Customer','pass456','rrkk404@gmail.com'),('Chef','pass789','rahul.das@viit.ac.in');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `category` varchar(25) DEFAULT NULL,
  `Item_Name` varchar(25) NOT NULL DEFAULT '',
  `Price` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Item_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES ('Roti','Butter Roti','60'),('Biryani','Chicken Biryani','110'),('Biryani','Egg Biryani','90'),('Roll','Egg Roll','80'),('Biryani','Hyderadi Biryani','140'),('Biryani','Veg Biryani','90'),('Chinese','Veg Noodles','55'),('Roll','Veg Roll','60');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ord_stat`
--

DROP TABLE IF EXISTS `ord_stat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ord_stat` (
  `order_id` varchar(4) NOT NULL DEFAULT '',
  `Item_Name` varchar(25) NOT NULL DEFAULT '',
  `Price` varchar(6) DEFAULT NULL,
  `Quantity` varchar(3) DEFAULT NULL,
  `Status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`Item_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ord_stat`
--

LOCK TABLES `ord_stat` WRITE;
/*!40000 ALTER TABLE `ord_stat` DISABLE KEYS */;
INSERT INTO `ord_stat` VALUES ('10','Butter Roti','60','3','Delivered'),('10','Veg Roll','60','1','Pending'),('11','Egg Roll','80','1','Pending'),('12','Chicken Biryani','110','3','Pending'),('15','Egg Roll','80','1','Delivered'),('15','Veg Roll','60','1','Delivered'),('16','Veg Roll','60','4','Delivered'),('17','Hyderadi Biryani','150','1','Pending'),('18','Veg Biryani','80','1','Pending'),('19','Veg Biryani','80','4','Delivered'),('20','Chicken Biryani','110','4','Delivered'),('21','Egg Roll','80','1','Pending'),('21','Hyderadi Biryani','150','1','Pending'),('22','Chicken Biryani','110','1','Pending'),('22','Veg Biryani','90','4','Pending'),('22','Veg Roll','60','1','Delivered'),('4','Chicken Roll','100','1','Pending'),('7','Chicken Roll','100','1','Delivered'),('8','Chicken Roll','100','1','Pending'),('9','Chicken Roll','100','1','Pending');
/*!40000 ALTER TABLE `ord_stat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-26  4:08:39
