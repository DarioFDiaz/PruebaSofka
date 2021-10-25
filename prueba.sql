CREATE DATABASE  IF NOT EXISTS `prueba` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `prueba`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: prueba
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.21-MariaDB

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
-- Table structure for table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pregunta` (
  `idpregunta` int(11) NOT NULL AUTO_INCREMENT,
  `pregunta` varchar(200) NOT NULL,
  `nivel` int(1) NOT NULL,
  PRIMARY KEY (`idpregunta`),
  UNIQUE KEY `pregunta_UNIQUE` (`pregunta`),
  UNIQUE KEY `idpregunta_UNIQUE` (`idpregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta`
--

LOCK TABLES `pregunta` WRITE;
/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` VALUES (1,'¿Pregunta 1 de nivel 1',1),(2,'¿Pregunta 2 de nivel 1',1),(3,'¿Pregunta 3 de nivel 1',1),(4,'¿Pregunta 4 de nivel 1',1),(5,'¿Pregunta 5 de nivel 1',1),(6,'¿Pregunta 1 de nivel 2',2),(7,'¿Pregunta 2 de nivel 2',2),(8,'¿Pregunta 3 de nivel 2',2),(9,'¿Pregunta 4 de nivel 2',2),(10,'¿Pregunta 5 de nivel 2',2),(11,'¿Pregunta 1 de nivel 3',3),(12,'¿Pregunta 2 de nivel 3',3),(13,'¿Pregunta 3 de nivel 3',3),(14,'¿Pregunta 4 de nivel 3',3),(15,'¿Pregunta 5 de nivel 3',3),(16,'¿Pregunta 1 de nivel 4',4),(17,'¿Pregunta 2 de nivel 4',4),(18,'¿Pregunta 3 de nivel 4',4),(19,'¿Pregunta 4 de nivel 4',4),(20,'¿Pregunta 5 de nivel 4',4),(21,'¿Pregunta 1 de nivel 5',5),(22,'¿Pregunta 2 de nivel 5',5),(23,'¿Pregunta 3 de nivel 5',5),(24,'¿Pregunta 4 de nivel 5',5),(25,'¿Pregunta 5 de nivel 5',5);
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `idrecord` int(11) NOT NULL AUTO_INCREMENT,
  `jugador` varchar(45) NOT NULL,
  `puntaje` int(11) NOT NULL,
  PRIMARY KEY (`idrecord`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (1,'das',455),(2,'dasfa',100000);
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuesta` (
  `idrespuesta` int(11) NOT NULL AUTO_INCREMENT,
  `respuesta` varchar(200) NOT NULL,
  `validacion` varchar(1) NOT NULL,
  `pregunta_id` int(11) NOT NULL,
  PRIMARY KEY (`idrespuesta`),
  UNIQUE KEY `idrespuesta_UNIQUE` (`idrespuesta`),
  KEY `Pregunta-Respuesta` (`pregunta_id`),
  CONSTRAINT `Pregunta-Respuesta` FOREIGN KEY (`pregunta_id`) REFERENCES `pregunta` (`idpregunta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta`
--

LOCK TABLES `respuesta` WRITE;
/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
INSERT INTO `respuesta` VALUES (1,'Respuesta A (CORRECTA)','V',1),(2,'Respuesta B','F',1),(3,'Respuesta C','F',1),(4,'Respuesta D','F',1),(5,'Respuesta A (CORRECTA)','V',2),(6,'Respuesta B','F',2),(7,'Respuesta C','F',2),(8,'Respuesta D','F',2),(9,'Respuesta A (CORRECTA)','V',3),(10,'Respuesta B','F',3),(11,'Respuesta C','F',3),(12,'Respuesta D','F',3),(13,'Respuesta A (CORRECTA)','V',4),(14,'Respuesta B','F',4),(15,'Respuesta C','F',4),(16,'Respuesta D','F',4),(17,'Respuesta A (CORRECTA)','V',5),(18,'Respuesta B','F',5),(19,'Respuesta C','F',5),(20,'Respuesta D','F',5),(101,'Respuesta A (CORRECTA)','V',6),(102,'Respuesta B','F',6),(103,'Respuesta C','F',6),(104,'Respuesta D','F',6),(105,'Respuesta A (CORRECTA)','V',7),(106,'Respuesta B','F',7),(107,'Respuesta C','F',7),(108,'Respuesta D','F',7),(109,'Respuesta A (CORRECTA)','V',8),(110,'Respuesta B','F',8),(111,'Respuesta C','F',8),(112,'Respuesta D','F',8),(113,'Respuesta A (CORRECTA)','V',9),(114,'Respuesta B','F',9),(115,'Respuesta C','F',9),(116,'Respuesta D','F',9),(117,'Respuesta A (CORRECTA)','V',10),(118,'Respuesta B','F',10),(119,'Respuesta C','F',10),(120,'Respuesta D','F',10),(121,'Respuesta A (CORRECTA)','V',11),(122,'Respuesta B','F',11),(123,'Respuesta C','F',11),(124,'Respuesta D','F',11),(125,'Respuesta A (CORRECTA)','V',12),(126,'Respuesta B','F',12),(127,'Respuesta C','F',12),(128,'Respuesta D','F',12),(129,'Respuesta A (CORRECTA)','V',13),(130,'Respuesta B','F',13),(131,'Respuesta C','F',13),(132,'Respuesta D','F',13),(133,'Respuesta A (CORRECTA)','V',14),(134,'Respuesta B','F',14),(135,'Respuesta C','F',14),(136,'Respuesta D','F',14),(137,'Respuesta A (CORRECTA)','V',15),(138,'Respuesta B','F',15),(139,'Respuesta C','F',15),(140,'Respuesta D','F',15),(141,'Respuesta A (CORRECTA)','V',16),(142,'Respuesta B','F',16),(143,'Respuesta C','F',16),(144,'Respuesta D','F',16),(145,'Respuesta A (CORRECTA)','V',17),(146,'Respuesta B','F',17),(147,'Respuesta C','F',17),(148,'Respuesta D','F',17),(149,'Respuesta A (CORRECTA)','V',18),(150,'Respuesta B','F',18),(151,'Respuesta C','F',18),(152,'Respuesta D','F',18),(153,'Respuesta A (CORRECTA)','V',19),(154,'Respuesta B','F',19),(155,'Respuesta C','F',19),(156,'Respuesta D','F',19),(157,'Respuesta A (CORRECTA)','V',20),(158,'Respuesta B','F',20),(159,'Respuesta C','F',20),(160,'Respuesta D','F',20),(161,'Respuesta A (CORRECTA)','V',21),(162,'Respuesta B','F',21),(163,'Respuesta C','F',21),(164,'Respuesta D','F',21),(165,'Respuesta A (CORRECTA)','V',22),(166,'Respuesta B','F',22),(167,'Respuesta C','F',22),(168,'Respuesta D','F',22),(169,'Respuesta A (CORRECTA)','V',23),(170,'Respuesta B','F',23),(171,'Respuesta C','F',23),(172,'Respuesta D','F',23),(173,'Respuesta A (CORRECTA)','V',24),(174,'Respuesta B','F',24),(175,'Respuesta C','F',24),(176,'Respuesta D','F',24),(177,'Respuesta A (CORRECTA)','V',25),(178,'Respuesta B','F',25),(179,'Respuesta C','F',25),(180,'Respuesta D','F',25);
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-25  1:29:56
