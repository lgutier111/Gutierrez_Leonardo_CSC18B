CREATE DATABASE  IF NOT EXISTS `SimonGameDBase`;

USE `SimonGameDBase`;

DROP TABLE IF EXISTS `enity_user`;

CREATE TABLE `entity_user`(`user_id` INTEGER NOT NULL PRIMARY KEY,`first_name` VARCHAR(25) NOT NULL,`last_name` VARCHAR(25) NOT NULL,`email` VARCHAR(60),`birth_date` DATE,`status` TINYINT);



DROP TABLE IF EXISTS `enity_history`;

CREATE TABLE `entity_history`(`game_id` INTEGER NOT NULL PRIMARY KEY,`game_date` TIMESTAMP(0) NOT NULL,`game_level` TINYINT NOT NULL,`game_score` TINYINT NOT NULL,`game_user` INTEGER NOT NULL);



DROP TABLE IF EXISTS `xfer_user_history`;

CREATE TABLE `xref_user_history`(`user_history_xref` INTEGER NOT NULL PRIMARY KEY,`user_id` INTEGER NOT NULL,`game_id` INTEGER NOT NULL);



DROP TABLE IF EXISTS `enum_status`;

CREATE TABLE `enum_status`(`enum_status_id` TINYINT NOT NULL PRIMARY KEY,`status_name` VARCHAR(12));



INSERT INTO `entity_user` VALUES(0,'Leo','Gutierrez','photog_friend@email.com','1978-02-19',2);

INSERT INTO `entity_user` VALUES(1,'Dorothy','Chan','dc@email.com','1978-06-14',3);

INSERT INTO `entity_user` VALUES(2,'Andres','Gutierrez','aGutierrez@email.com','1998-09-18',3);

INSERT INTO `entity_user` VALUES(3,'Mickey','Mouse','mickey@disnland.com','1954-06-10',1);

INSERT INTO `entity_user` VALUES(4,'Donald','Duck','donald@disneyland.com','1955-09-20',2);

INSERT INTO `entity_user` VALUES(5,'Mary','Poppins','MaryP@disneyworld.com','1944-02-20',2);

INSERT INTO `entity_history` VALUES(0,'2014-05-01 12:00:00.000000000',1,7,0);

INSERT INTO `entity_history` VALUES(1,'2014-05-01 12:01:00.000000000',1,8,0);

INSERT INTO `entity_history` VALUES(2,'2014-05-01 12:02:00.000000000',1,8,0);

INSERT INTO `entity_history` VALUES(3,'2014-05-01 12:03:00.000000000',2,12,0);

INSERT INTO `entity_history` VALUES(4,'2014-05-01 12:04:00.000000000',2,13,0);

INSERT INTO `entity_history` VALUES(5,'2014-05-01 12:05:00.000000000',2,13,0);

INSERT INTO `entity_history` VALUES(6,'2014-05-01 12:06:00.000000000',2,12,0);

INSERT INTO `entity_history` VALUES(7,'2014-06-10 16:30:00.000000000',1,7,2);

INSERT INTO `entity_history` VALUES(8,'2014-06-10 16:31:00.000000000',1,7,2);
INSERT INTO `entity_history` VALUES(9,'2014-06-10 16:32:00.000000000',1,8,2);

INSERT INTO `entity_history` VALUES(10,'2014-06-10 16:33:00.000000000',1,8,2);

INSERT INTO `entity_history` VALUES(11,'2014-06-10 16:35:00.000000000',2,10,2);

INSERT INTO `entity_history` VALUES(12,'2014-06-10 16:36:00.000000000',2,11,2);

INSERT INTO `entity_history` VALUES(13,'2014-06-10 16:37:00.000000000',2,10,2);

INSERT INTO `entity_history` VALUES(14,'2014-06-10 16:39:00.000000000',2,12,2);

INSERT INTO `entity_history` VALUES(15,'2014-06-10 16:41:00.000000000',2,12,2);

INSERT INTO `entity_history` VALUES(16,'2014-09-19 09:32:00.000000000',2,11,5);

INSERT INTO `entity_history` VALUES(17,'2014-09-19 09:34:00.000000000',2,11,5);

INSERT INTO `entity_history` VALUES(18,'2014-09-19 09:36:00.000000000',2,12,5);

INSERT INTO `entity_history` VALUES(19,'2014-09-19 09:38:00.000000000',2,14,5);

INSERT INTO `entity_history` VALUES(20,'2014-09-19 09:40:00.000000000',2,12,5);

INSERT INTO `entity_history` VALUES(21,'2014-09-19 09:42:00.000000000',2,13,5);
INSERT INTO `entity_history` VALUES(22,'2014-09-19 09:44:00.000000000',2,12,5);

INSERT INTO `entity_history` VALUES(23,'2015-02-21 09:00:00.000000000',1,7,3);

INSERT INTO `entity_history` VALUES(24,'2015-02-21 09:01:00.000000000',1,7,3);

INSERT INTO `entity_history` VALUES(25,'2015-02-21 09:02:00.000000000',1,8,3);

INSERT INTO `entity_history` VALUES(26,'2015-02-21 09:03:00.000000000',1,8,3);

INSERT INTO `entity_history` VALUES(27,'2015-02-21 09:04:00.000000000',2,11,3);

INSERT INTO `entity_history` VALUES(28,'2015-02-21 09:05:00.000000000',2,11,3);

INSERT INTO `entity_history` VALUES(29,'2015-02-21 09:06:00.000000000',2,12,3);

INSERT INTO `entity_history` VALUES(30,'2015-02-21 09:07:00.000000000',2,12,3);

INSERT INTO `entity_history` VALUES(31,'2015-02-21 09:08:00.000000000',2,11,3);

INSERT INTO `entity_history` VALUES(32,'2015-02-21 09:10:00.000000000',2,12,3);

INSERT INTO `entity_history` VALUES(33,'2015-02-21 09:11:00.000000000',2,12,3);

INSERT INTO `entity_history` VALUES(34,'2015-02-21 09:13:00.000000000',2,14,3);

INSERT INTO `entity_history` VALUES(35,'2015-02-21 09:15:00.000000000',2,14,3);

INSERT INTO `entity_history` VALUES(36,'2015-02-21 09:17:00.000000000',2,12,3);

INSERT INTO `entity_history` VALUES(37,'2015-02-21 09:19:00.000000000',2,13,3);

INSERT INTO `entity_history` VALUES(38,'2015-02-21 09:21:00.000000000',2,13,3);

INSERT INTO `entity_history` VALUES(39,'2015-05-01 20:34:00.000000000',2,12,1);

INSERT INTO `entity_history` VALUES(40,'2015-05-01 20:36:00.000000000',2,12,1);

INSERT INTO `entity_history` VALUES(41,'2015-05-01 20:38:00.000000000',2,13,1);

INSERT INTO `entity_history` VALUES(42,'2015-05-01 20:40:00.000000000',2,14,1);

INSERT INTO `entity_history` VALUES(43,'2015-05-01 20:41:00.000000000',2,12,1);

INSERT INTO `entity_history` VALUES(44,'2015-05-01 08:43:00.000000000',3,11,1);

INSERT INTO `entity_history` VALUES(45,'2015-05-01 20:45:00.000000000',3,14,1);

INSERT INTO `entity_history` VALUES(46,'2015-05-01 20:47:00.000000000',3,13,1);

INSERT INTO `xref_user_history` VALUES(0,0,1);

INSERT INTO `xref_user_history` VALUES(1,0,2);

INSERT INTO `xref_user_history` VALUES(2,0,3);

INSERT INTO `xref_user_history` VALUES(3,0,4);

INSERT INTO `xref_user_history` VALUES(4,0,5);

INSERT INTO `xref_user_history` VALUES(5,0,6);

INSERT INTO `xref_user_history` VALUES(6,2,7);

INSERT INTO `xref_user_history` VALUES(7,2,8);

INSERT INTO `xref_user_history` VALUES(8,2,9);

INSERT INTO `xref_user_history` VALUES(9,2,10);

INSERT INTO `xref_user_history` VALUES(10,2,11);

INSERT INTO `xref_user_history` VALUES(11,2,12);

INSERT INTO `xref_user_history` VALUES(12,2,13);

INSERT INTO `xref_user_history` VALUES(13,2,14);

INSERT INTO `xref_user_history` VALUES(14,2,15);

INSERT INTO `xref_user_history` VALUES(15,5,16);

INSERT INTO `xref_user_history` VALUES(17,5,17);

INSERT INTO `xref_user_history` VALUES(18,5,18);

INSERT INTO `xref_user_history` VALUES(19,5,19);

INSERT INTO `xref_user_history` VALUES(20,5,20);

INSERT INTO `xref_user_history` VALUES(21,5,21);

INSERT INTO `xref_user_history` VALUES(22,5,22);

INSERT INTO `xref_user_history` VALUES(23,3,23);

INSERT INTO `xref_user_history` VALUES(24,3,24);

INSERT INTO `xref_user_history` VALUES(25,3,25);

INSERT INTO `xref_user_history` VALUES(26,3,26);

INSERT INTO `xref_user_history` VALUES(27,3,27);

INSERT INTO `xref_user_history` VALUES(28,3,28);

INSERT INTO `xref_user_history` VALUES(29,3,29);

INSERT INTO `xref_user_history` VALUES(30,3,30);

INSERT INTO `xref_user_history` VALUES(31,3,31);

INSERT INTO `xref_user_history` VALUES(32,3,32);

INSERT INTO `xref_user_history` VALUES(33,3,33);

INSERT INTO `xref_user_history` VALUES(34,3,34);

INSERT INTO `xref_user_history` VALUES(35,3,35);

INSERT INTO `xref_user_history` VALUES(36,3,36);

INSERT INTO `xref_user_history` VALUES(37,3,37);

INSERT INTO `xref_user_history` VALUES(38,3,38);

INSERT INTO `xref_user_history` VALUES(39,1,39);

INSERT INTO `xref_user_history` VALUES(40,1,40);

INSERT INTO `xref_user_history` VALUES(41,1,41);

INSERT INTO `xref_user_history` VALUES(42,1,42);

INSERT INTO `xref_user_history` VALUES(43,1,43);

INSERT INTO `xref_user_history` VALUES(44,1,44);

INSERT INTO `xref_user_history` VALUES(45,1,45);

INSERT INTO `xref_user_history` VALUES(46,1,46);

INSERT INTO `enum_status` VALUES(1,'Beginner');

INSERT INTO `enum_status` VALUES(2,'Casual');

INSERT INTO `enum_status` VALUES(3,'Intermediate');

INSERT INTO `enum_status` VALUES(4,'Advanced');

INSERT INTO `enum_status` VALUES(5,'Expert');