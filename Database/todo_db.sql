CREATE DATABASE  IF NOT EXISTS `todoapp_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `todoapp_db`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: todoapp_db
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `backlog`
--

DROP TABLE IF EXISTS `backlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `backlog` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ptsequence` int DEFAULT NULL,
  `project_identifier` varchar(255) DEFAULT NULL,
  `project_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKke1y6s94kp9snojm2w2bd5e2v` (`project_id`),
  CONSTRAINT `FKke1y6s94kp9snojm2w2bd5e2v` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backlog`
--

LOCK TABLES `backlog` WRITE;
/*!40000 ALTER TABLE `backlog` DISABLE KEYS */;
INSERT INTO `backlog` VALUES (2,9,'IPOS',2),(3,3,'VPMS',3),(4,1,'ELL8',4),(5,0,'GPI8',5),(6,1,'IG0B',6);
/*!40000 ALTER TABLE `backlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_task`
--

DROP TABLE IF EXISTS `project_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_task` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `acceptance_criteria` varchar(255) DEFAULT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `due_date` datetime(6) DEFAULT NULL,
  `priority` int DEFAULT NULL,
  `project_identifier` varchar(255) DEFAULT NULL,
  `project_sequence` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `backlog_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lk2ru5up8ilfm5wkq7wp6rtce` (`project_sequence`),
  KEY `FKnhbtfc4k2v2fsl0s3rm7uc7w3` (`backlog_id`),
  CONSTRAINT `FKnhbtfc4k2v2fsl0s3rm7uc7w3` FOREIGN KEY (`backlog_id`) REFERENCES `backlog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_task`
--

LOCK TABLES `project_task` WRITE;
/*!40000 ALTER TABLE `project_task` DISABLE KEYS */;
INSERT INTO `project_task` VALUES (4,'Java','2022-12-28 18:01:38.699000','2022-12-30 07:00:00.000000',1,'ELL8','ELL8-1','DONE','Spring Framework','2022-12-29 16:47:57.044000',4),(7,'Is there any known issue in this area for SMART R13.0 version?','2022-12-29 14:54:11.987000','2022-12-29 07:00:00.000000',1,'VPMS','VPMS-1','TO_DO','Diary Testing Tool','2022-12-29 17:04:28.227000',3),(8,'Automatic PH Reinstate','2022-12-29 17:05:19.050000','2022-12-30 07:00:00.000000',2,'VPMS','VPMS-2','IN_PROGRESS','New Feature ',NULL,3),(9,'Batch job to perform Automatic','2022-12-29 17:05:48.308000','2022-11-30 07:00:00.000000',3,'VPMS','VPMS-3','DONE','Anniversary Processing',NULL,3),(13,'Javascript for Beginners','2022-12-29 17:37:35.609000','2022-12-29 07:00:00.000000',1,'IPOS','IPOS-4','TO_DO','Development',NULL,2),(14,'Create Elegant, Powerful Web and Mobile Applications Using AJAX.','2022-12-29 17:38:16.284000','2022-11-30 07:00:00.000000',2,'IPOS','IPOS-5','IN_PROGRESS','AJAX Development',NULL,2),(15,'Become a Certified HTML, CSS, JavaScript','2022-12-29 17:38:44.562000','2022-12-08 07:00:00.000000',3,'IPOS','IPOS-6','DONE','Web Developer',NULL,2),(16,'Course for Busy Developers','2022-12-29 17:39:16.922000','2022-12-17 07:00:00.000000',2,'IPOS','IPOS-7','IN_PROGRESS','Angular Crash',NULL,2),(17,'Typescript React from Scratch','2022-12-29 17:39:55.818000','2022-11-27 07:00:00.000000',3,'IPOS','IPOS-8','DONE','Typescript | Type script',NULL,2),(18,'Full Stack Java Developer','2022-12-29 17:40:33.758000','2022-12-15 07:00:00.000000',1,'IPOS','IPOS-9','TO_DO','Go Java Full Stack with Spring Boot and Angular',NULL,2),(19,'Make your own animated 2D games','2022-12-29 17:41:48.304000','2022-12-02 07:00:00.000000',2,'IG0B','IG0B-1','IN_PROGRESS','Game Development with JavaScript',NULL,6);
/*!40000 ALTER TABLE `project_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `project_identifier` varchar(5) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_d2odc28mq6cesjqfpe1mq7srs` (`project_identifier`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (2,'2022-12-28 15:52:02.317000','Product Development (Active)','2022-01-29 07:12:00.000000','IPOS','Integral POS','2022-01-04 07:12:00.000000',NULL),(3,'2022-12-28 15:52:39.545000','IBMi Helpdesk Support','2022-01-30 07:12:00.000000','VPMS','Integral VPMS','2022-01-01 07:12:00.000000',NULL),(4,'2022-12-28 15:53:42.971000','Product Development (Active)','2022-01-30 07:12:00.000000','ELL8','Etiqa Life (Lion)','2022-01-01 07:12:00.000000',NULL),(5,'2022-12-29 17:02:35.501000','IBMi Helpdesk Support',NULL,'GPI8','GenPolisy',NULL,NULL),(6,'2022-12-29 17:03:19.463000','Project Delivery (Active)',NULL,'IG0B','Integral iSeries Support',NULL,NULL);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-29 17:43:31
