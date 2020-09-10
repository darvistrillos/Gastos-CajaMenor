/*
SQLyog Ultimate v11.21 (64 bit)
MySQL - 10.1.31-MariaDB : Database - tesoreria
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `gastos` */

DROP TABLE IF EXISTS `gastos`;

CREATE TABLE `gastos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL DEFAULT '0000-00-00',
  `identificacion` varchar(16) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `obs` varchar(250) COLLATE utf8_spanish_ci NOT NULL,
  `file` mediumblob NOT NULL,
  `valor` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
