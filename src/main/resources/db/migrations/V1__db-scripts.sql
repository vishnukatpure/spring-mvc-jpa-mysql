--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  `id` bigint(20) NOT NULL,
  `username_username` varchar(255) DEFAULT NULL,
  `createBy` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updatedBy` bigint(20) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `username_id` bigint(20) DEFAULT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  KEY `FK_7tkx4s5whi2ac5bybxpghhf5i` (`username_username`),
  CONSTRAINT `FK_7tkx4s5whi2ac5bybxpghhf5i` FOREIGN KEY (`username_username`) REFERENCES `users` (`username`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `authorities` WRITE;
INSERT INTO `authorities` VALUES ('admin','ROLE_USER',0,NULL,NULL,NULL,NULL,NULL,NULL);
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `createBy` bigint(20) DEFAULT NULL,
  `updatedBy` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES ('admin','$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL);
UNLOCK TABLES;


--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `people` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `createBy` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updatedBy` bigint(20) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (1,30,'Vishnu','Katpure',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;
