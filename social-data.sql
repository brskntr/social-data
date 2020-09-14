# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.25)
# Database: social
# Generation Time: 2020-09-14 20:02:12 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table player
# ------------------------------------------------------------

DROP TABLE IF EXISTS `player`;

CREATE TABLE `player` (
  `id` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `birth_date` datetime(6) DEFAULT NULL,
  `license_start_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;

INSERT INTO `player` (`id`, `first_name`, `last_name`, `birth_date`, `license_start_date`)
VALUES
	('08fae8be-bf5f-4118-bf0b-4e4c579b0a4f','Ugur','Ekinci','1990-05-03 03:00:00.000000','2012-05-17 03:00:00.000000'),
	('42f352fe-6b38-474e-8d7f-084a982f7448','Ozkan','Calıkusu','1990-05-03 03:00:00.000000','2012-05-17 03:00:00.000000'),
	('97f17d99-cda5-403d-a239-478c82764449','Ali','Kumral','1990-05-03 03:00:00.000000','2012-05-17 03:00:00.000000'),
	('d1faa06c-bc5b-4e88-aee0-7ee51dcf98e2','Baris','Kantar','1990-05-03 03:00:00.000000','2012-05-17 03:00:00.000000');

/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table player_attribute
# ------------------------------------------------------------

DROP TABLE IF EXISTS `player_attribute`;

CREATE TABLE `player_attribute` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `player_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7u4yg23yy3ajomqivubpgdngw` (`player_id`),
  CONSTRAINT `FK7u4yg23yy3ajomqivubpgdngw` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `player_attribute` WRITE;
/*!40000 ALTER TABLE `player_attribute` DISABLE KEYS */;

INSERT INTO `player_attribute` (`id`, `name`, `value`, `player_id`)
VALUES
	('06efb6fd-a2f9-4791-8315-1db60a553eaa','height','185cm','97f17d99-cda5-403d-a239-478c82764449'),
	('27d491be-12b8-4af3-af3d-e1092de683c3','width','75kg','97f17d99-cda5-403d-a239-478c82764449'),
	('645c9d3e-87dd-4c70-9bfc-9404179b276f','position','GK','97f17d99-cda5-403d-a239-478c82764449');

/*!40000 ALTER TABLE `player_attribute` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table player_team
# ------------------------------------------------------------

DROP TABLE IF EXISTS `player_team`;

CREATE TABLE `player_team` (
  `id` varchar(100) DEFAULT NULL,
  `player_id` varchar(100) DEFAULT NULL,
  `team_id` varchar(100) DEFAULT NULL,
  `season_id` varchar(100) DEFAULT NULL,
  KEY `FKi5rpfhkcbhcotndp7k623f4y0` (`player_id`),
  KEY `FK9axcbkwl4aiy4b9stqe31q2k` (`team_id`),
  CONSTRAINT `FK9axcbkwl4aiy4b9stqe31q2k` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`),
  CONSTRAINT `FKi5rpfhkcbhcotndp7k623f4y0` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `player_team` WRITE;
/*!40000 ALTER TABLE `player_team` DISABLE KEYS */;

INSERT INTO `player_team` (`id`, `player_id`, `team_id`, `season_id`)
VALUES
	('42f352fe-5338-474e-8d7f-084a982f7448','42f352fe-6b38-474e-8d7f-084a982f7448','37e06bd4-788e-4bc9-b72b-3804f7245ffd','5823d211-6d01-46f9-b2d4-f75529bae37e'),
	('56674cc2-1b32-41d8-8086-3646b5c05a69','42f352fe-6b38-474e-8d7f-084a982f7448','a3bf48fc-a461-485e-ab69-4b9bfcdf4ece','35674cc2-ecf1-41d8-8086-3646b5c05a69'),
	('e1fa236c-bc5b-4e88-aee0-7ee51dcf98e2','d1faa06c-bc5b-4e88-aee0-7ee51dcf98e2','a3bf48fc-a461-485e-ab69-4b9bfcdf4ece','35674cc2-ecf1-41d8-8086-3646b5c05a69');

/*!40000 ALTER TABLE `player_team` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table team
# ------------------------------------------------------------

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `currency_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe5cxa0unldc93c5xvmut8sai4` (`currency_id`),
  CONSTRAINT `FKe5cxa0unldc93c5xvmut8sai4` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;

INSERT INTO `team` (`id`, `name`, `currency_id`)
VALUES
	('1084cdf3-8ca0-4b58-b24b-7d1470444432','Bordeaux','17b43e86-486d-43a3-86b8-c92e1a64df83'),
	('1abcd939-4a7e-4ac5-8434-434b7556ac2b','Everton','3dd0cddb-bff6-4cad-8f3a-44215f398bae'),
	('37e06bd4-788e-4bc9-b72b-3804f7245ffd','Internazionale','17b43e86-486d-43a3-86b8-c92e1a64df83'),
	('a3bf48fc-a461-485e-ab69-4b9bfcdf4ece','Villarreal','17b43e86-486d-43a3-86b8-c92e1a64df83');

/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
