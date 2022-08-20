/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.28-log : Database - edu_ad
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`edu_ad` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `edu_ad`;

/*Table structure for table `promotion_ad` */

DROP TABLE IF EXISTS `promotion_ad`;

CREATE TABLE `promotion_ad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '广告名',
  `spaceId` int(11) DEFAULT NULL COMMENT '广告位id',
  `keyword` varchar(255) DEFAULT NULL COMMENT '精确搜索关键词',
  `htmlContent` text COMMENT '静态广告的内容',
  `text` varchar(255) DEFAULT NULL COMMENT '文字一',
  `link` varchar(255) DEFAULT NULL COMMENT '链接一',
  `startTime` datetime DEFAULT NULL COMMENT '开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '结束时间',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `status` int(2) NOT NULL DEFAULT '0',
  `priority` int(4) DEFAULT '0' COMMENT '优先级',
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `promotion_ad_SEG` (`spaceId`,`startTime`,`endTime`,`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1089 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `promotion_ad` */

insert  into `promotion_ad`(`id`,`name`,`spaceId`,`keyword`,`htmlContent`,`text`,`link`,`startTime`,`endTime`,`createTime`,`updateTime`,`status`,`priority`,`img`) values 
(1074,'java0基础训练营',3,NULL,NULL,'sdfsadf','https://edu.lagou.com/','2020-06-23 17:03:27','2020-07-29 17:03:45','2020-07-14 14:28:34','2020-07-22 12:41:27',1,0,'https://edu-lagou.oss-cn-beijing.aliyuncs.com/images/2020/07/17/15949658736951644.jpeg'),
(1075,'精选课程',2,NULL,NULL,NULL,'http://edufront.lagou.com/#/content?courseId=1','2020-06-29 17:03:25','2020-07-29 17:03:45','2020-07-14 14:28:34','2020-07-17 13:13:51',1,0,'https://edu-lagou.oss-cn-beijing.aliyuncs.com/images/2020/07/17/15949580209796992.png'),
(1076,'java训练营2',3,NULL,NULL,NULL,'http://edufront.lagou.com/#/content?courseId=1','2020-06-29 17:03:25','2020-07-29 17:03:45','2020-07-14 14:28:34','2020-07-17 13:14:11',1,0,'https://edu-lagou.oss-cn-beijing.aliyuncs.com/images/2020/07/17/15949583460826312.jpeg'),
(1077,'轮播广告2',3,NULL,NULL,NULL,'http://edufront.lagou.com/#/content?courseId=1','2020-06-29 17:03:25','2020-07-29 17:03:45','2020-07-14 14:28:34','2020-07-17 13:07:52',0,0,'https://edu-lagou.oss-cn-beijing.aliyuncs.com/images/2020/07/17/15949624525374063.png'),
(1078,'广告3333',162,NULL,NULL,'这是文本内容111','http://www.163.com111','2020-01-01 00:00:00','2020-09-30 00:00:00','2020-07-14 14:28:34','2020-07-17 11:22:31',0,2,'https://edu-lagou.oss-cn-beijing.aliyuncs.com/images/2020/07/17/15949561472241579.jpg'),
(1079,'广告',162,NULL,NULL,'这是文本内容111','http://www.163.com111','2020-07-01 00:00:00','2020-08-01 00:00:00','2020-07-14 14:30:48','2020-07-14 14:30:48',0,2,'http://www.baidu.com111'),
(1080,'广告名称111',169,NULL,NULL,'text','link1','2030-01-10 01:01:01','2030-01-02 12:12:12','2020-07-14 16:38:03','2020-07-14 17:36:34',0,0,'img1'),
(1081,'广告名称111',169,NULL,NULL,'text','link1','2030-01-10 01:01:01','2030-01-02 12:12:12','2020-07-14 17:36:50','2020-07-14 17:36:50',0,0,'img1'),
(1082,'111',NULL,NULL,NULL,NULL,NULL,'2020-07-14 16:00:00','2020-07-15 16:00:00','2020-07-15 11:57:23','2020-07-15 11:57:23',0,0,NULL),
(1083,'222',NULL,NULL,NULL,NULL,NULL,'2020-07-14 16:00:00','2020-07-16 16:00:00','2020-07-15 11:58:00','2020-07-15 11:58:00',0,0,NULL),
(1084,'123123',NULL,NULL,NULL,NULL,NULL,'2020-07-15 16:00:00','2020-07-16 16:00:00','2020-07-16 15:52:30','2020-07-16 15:52:30',1,0,NULL),
(1085,'storm',NULL,NULL,NULL,NULL,NULL,'2020-07-15 15:06:02','2020-07-30 16:00:00','2020-07-16 21:48:26','2020-07-16 21:48:26',0,0,NULL),
(1086,'stormtest',3,NULL,NULL,NULL,NULL,'2020-07-16 16:00:00','2020-07-17 16:00:00','2020-07-16 22:16:48','2020-07-16 22:16:48',0,0,NULL),
(1087,'撒短发',3,NULL,NULL,NULL,'sdfasdfasdfssss','2020-07-14 16:00:00','2020-07-16 16:00:00','2020-07-16 22:22:47','2020-07-16 22:22:47',0,0,NULL),
(1088,'冰淇淋套餐',NULL,NULL,NULL,NULL,'sdfdasdf','2020-01-01 00:00:00','2020-02-01 01:00:00','2020-07-17 10:07:39','2020-07-17 11:10:51',0,0,NULL);

/*Table structure for table `promotion_space` */

DROP TABLE IF EXISTS `promotion_space`;

CREATE TABLE `promotion_space` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `spaceKey` varchar(255) DEFAULT NULL COMMENT '广告位key',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `isDel` int(2) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `promotion_space_key_isDel` (`spaceKey`,`isDel`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `promotion_space` */

insert  into `promotion_space`(`id`,`name`,`spaceKey`,`createTime`,`updateTime`,`isDel`) values 
(1,'首页顶部推荐位','666','2020-07-14 13:03:31','2020-07-17 13:13:21',0),
(2,'首页侧边广告位','888','2020-07-14 13:03:31','2020-07-17 11:53:02',0),
(3,'首页顶部轮播','999','2020-07-14 13:03:31','2020-07-17 13:13:03',0),
(160,'sadfa','123','2020-07-14 13:03:31','2020-07-17 11:21:22',0),
(161,'ffff','456','2020-07-14 13:03:31','2020-07-17 11:21:26',0),
(162,'广告名称','789','2020-07-14 13:03:31','2020-07-14 13:03:11',0),
(163,'广告名称','78911111','2020-07-14 13:03:31','2020-07-14 13:03:11',0),
(164,'广告名称','78911111','2020-07-14 13:03:31','2020-07-14 13:03:11',0),
(165,'广告名称','78911111','2020-07-14 13:03:31','2020-07-14 13:03:11',0),
(166,'广告名称','78911111','2020-07-14 13:03:31','2020-07-14 13:03:11',0),
(167,'广告名称','78911111','2020-07-14 13:03:31','2020-07-14 13:03:11',0),
(168,'广告名称111','33333','2020-07-14 13:03:31','2020-07-14 13:03:49',0),
(169,'名称','abcd','2020-07-14 16:30:38','2020-07-14 16:31:31',0),
(170,'冰淇淋套餐',NULL,'2020-07-14 17:39:19','2020-07-14 17:40:24',0),
(171,'12111111',NULL,'2020-07-15 12:18:47','2020-07-15 12:19:06',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
