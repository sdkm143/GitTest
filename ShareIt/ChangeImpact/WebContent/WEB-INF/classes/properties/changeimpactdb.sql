/*
SQLyog Community v11.51 (32 bit)
MySQL - 5.7.1-m11 : Database - changeimpactdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`changeimpactdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `changeimpactdb`;

/*Table structure for table `tc_details` */

DROP TABLE IF EXISTS `tc_details`;

CREATE TABLE `tc_details` (
  `testcase_id` varchar(255) NOT NULL,
  `TC_Name` varchar(600) DEFAULT '',
  `TC_Desc` varchar(1500) DEFAULT NULL,
  `script_name` mediumtext,
  `project` varchar(50) NOT NULL DEFAULT '',
  `createdby` varchar(50) DEFAULT NULL,
  `modified` bit(1) DEFAULT b'0',
  `autotech` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`project`,`testcase_id`),
  KEY `tcindex` (`TC_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tc_details` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
