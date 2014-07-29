/*
MySQL Data Transfer
Source Host: localhost
Source Database: bt
Target Host: localhost
Target Database: bt
Date: 2014/4/27 23:42:49
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for bid2uid
-- ----------------------------
DROP TABLE IF EXISTS `bid2uid`;
CREATE TABLE `bid2uid` (
  `bid` varchar(100) character set gbk collate gbk_bin NOT NULL,
  `uid` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for biduid2scan
-- ----------------------------
DROP TABLE IF EXISTS `biduid2scan`;
CREATE TABLE `biduid2scan` (
  `uid` varchar(100) character set gbk collate gbk_bin NOT NULL,
  `bid` varchar(100) NOT NULL,
  `scanDate` timestamp NOT NULL default '0000-00-00 00:00:00',
  `x` double NOT NULL,
  `y` double NOT NULL,
  `username` varchar(100) NOT NULL,
  `isMatch` int(11) NOT NULL,
  `operationType` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for locusinfo
-- ----------------------------
DROP TABLE IF EXISTS `locusinfo`;
CREATE TABLE `locusinfo` (
  `username` varchar(100) character set gbk collate gbk_bin NOT NULL,
  `ID` bigint(20) NOT NULL,
  `x` double NOT NULL,
  `y` double NOT NULL,
  `serial` bigint(20) NOT NULL,
  `datePhone` timestamp NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `dateServer` timestamp NULL default '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `epc` varchar(100) character set gbk collate gbk_bin NOT NULL,
  `userName` varchar(100) NOT NULL,
  `expireDays` int(11) NOT NULL,
  `productTime` date NOT NULL,
  `category` varchar(10) character set gbk collate gbk_bin NOT NULL,
  `productName` varchar(100) character set gbk collate gbk_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for uid2epc
-- ----------------------------
DROP TABLE IF EXISTS `uid2epc`;
CREATE TABLE `uid2epc` (
  `uid` varchar(100) character set gbk collate gbk_bin NOT NULL,
  `epc` varchar(100) NOT NULL,
  `recall` int(11) NOT NULL,
  `isExpire` int(11) NOT NULL,
  `producedate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userdata
-- ----------------------------
DROP TABLE IF EXISTS `userdata`;
CREATE TABLE `userdata` (
  `userName` varchar(100) character set gbk collate gbk_bin NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `type` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `x` double NOT NULL,
  `y` double NOT NULL,
  `radius` int(11) NOT NULL,
  `address` varchar(100) NOT NULL,
  `establishDate` date NOT NULL,
  `postcode` varchar(20) NOT NULL,
  `contactPerson` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for username2bid
-- ----------------------------
DROP TABLE IF EXISTS `username2bid`;
CREATE TABLE `username2bid` (
  `username` varchar(100) character set gbk collate gbk_bin NOT NULL,
  `ID` bigint(20) NOT NULL,
  `bid` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `bid2uid` VALUES ('11', '11');
INSERT INTO `bid2uid` VALUES ('434C0355000104E0', '2F8F1B5F000104E0');
INSERT INTO `bid2uid` VALUES ('434C0355000104E0', '89A51B5F000104E0');
INSERT INTO `biduid2scan` VALUES ('89A51B5F000104E0', '434C0355000104E0', '2014-04-27 23:40:29', '10', '11', 'ab', '1', '1');
INSERT INTO `locusinfo` VALUES ('h', '1', '39.999102', '116.331273', '2', '2014-04-27 22:53:15', '2014-04-27 22:46:29');
INSERT INTO `locusinfo` VALUES ('h', '1', '39.899102', '116.331273', '1', '2014-04-27 22:53:17', '2014-04-27 22:46:32');
INSERT INTO `locusinfo` VALUES ('h', '1', '39.899102', '116.431273', '1', '2014-04-27 22:53:19', '2014-04-27 22:46:34');
INSERT INTO `locusinfo` VALUES ('h', '1', '39.999102', '116.431273', '1', '2014-04-27 22:53:21', '2014-04-27 22:46:37');
INSERT INTO `locusinfo` VALUES ('hahaha', '3', '39.9991016771533', '116.331301', '1', '2014-04-27 21:56:29', '2014-04-27 21:32:53');
INSERT INTO `locusinfo` VALUES ('hahaha', '3', '39.9993103652268', '116.331301', '3', '2014-04-27 21:57:18', '2014-04-27 21:33:03');
INSERT INTO `locusinfo` VALUES ('d', '1', '39.999102', '116.931273', '2', '2014-04-27 23:02:42', '2014-04-27 22:46:29');
INSERT INTO `locusinfo` VALUES ('d', '1', '39.899102', '116.831273', '1', '2014-04-27 23:02:50', '2014-04-27 22:46:32');
INSERT INTO `locusinfo` VALUES ('d', '1', '39.899102', '116.931273', '1', '2014-04-27 23:02:52', '2014-04-27 22:46:34');
INSERT INTO `locusinfo` VALUES ('d', '1', '39.999102', '116.931273', '1', '2014-04-27 23:02:56', '2014-04-27 22:46:37');
INSERT INTO `locusinfo` VALUES ('f', '1', '39.999102', '116.531273', '2', '2014-04-27 22:56:20', '2014-04-27 22:46:29');
INSERT INTO `locusinfo` VALUES ('d', '1', '39.999102', '116.831273', '1', '2014-04-27 23:03:00', '2014-04-27 22:46:41');
INSERT INTO `locusinfo` VALUES ('h', '1', '39.999102', '116.431273', '1', '2014-04-27 22:56:39', '2014-04-27 22:46:41');
INSERT INTO `locusinfo` VALUES ('f', '1', '39.899102', '116.431273', '1', '2014-04-27 22:56:48', '2014-04-27 22:46:32');
INSERT INTO `locusinfo` VALUES ('f', '1', '39.899102', '116.531273', '1', '2014-04-27 22:57:12', '2014-04-27 22:46:34');
INSERT INTO `locusinfo` VALUES ('f', '1', '39.999102', '116.531273', '1', '2014-04-27 22:57:16', '2014-04-27 22:46:37');
INSERT INTO `locusinfo` VALUES ('f', '1', '39.999102', '116.431273', '1', '2014-04-27 22:57:23', '2014-04-27 22:46:41');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '1', '2014-04-27 23:09:46', '2014-04-27 23:09:49');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '2', '2014-04-27 23:09:48', '2014-04-27 23:09:51');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '3', '2014-04-27 23:09:51', '2014-04-27 23:09:54');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '4', '2014-04-27 23:09:54', '2014-04-27 23:09:57');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '5', '2014-04-27 23:09:56', '2014-04-27 23:09:59');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '6', '2014-04-27 23:09:59', '2014-04-27 23:10:02');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '7', '2014-04-27 23:10:01', '2014-04-27 23:10:04');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '8', '2014-04-27 23:10:03', '2014-04-27 23:10:38');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '9', '2014-04-27 23:10:37', '2014-04-27 23:10:41');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '10', '2014-04-27 23:10:40', '2014-04-27 23:10:43');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '11', '2014-04-27 23:10:42', '2014-04-27 23:10:45');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '12', '2014-04-27 23:10:44', '2014-04-27 23:10:47');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '13', '2014-04-27 23:10:46', '2014-04-27 23:10:49');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '14', '2014-04-27 23:10:48', '2014-04-27 23:10:51');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '15', '2014-04-27 23:10:50', '2014-04-27 23:10:53');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '16', '2014-04-27 23:10:52', '2014-04-27 23:10:55');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '17', '2014-04-27 23:10:54', '2014-04-27 23:10:57');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '18', '2014-04-27 23:10:56', '2014-04-27 23:10:59');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '19', '2014-04-27 23:10:59', '2014-04-27 23:11:01');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '20', '2014-04-27 23:11:00', '2014-04-27 23:11:04');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '21', '2014-04-27 23:11:03', '2014-04-27 23:11:05');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '22', '2014-04-27 23:11:04', '2014-04-27 23:11:07');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '23', '2014-04-27 23:11:06', '2014-04-27 23:11:10');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '24', '2014-04-27 23:11:09', '2014-04-27 23:11:12');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '25', '2014-04-27 23:11:11', '2014-04-27 23:11:14');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '26', '2014-04-27 23:11:13', '2014-04-27 23:11:16');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '27', '2014-04-27 23:11:15', '2014-04-27 23:11:18');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '28', '2014-04-27 23:11:17', '2014-04-27 23:11:21');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '29', '2014-04-27 23:11:20', '2014-04-27 23:11:23');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '30', '2014-04-27 23:11:22', '2014-04-27 23:11:25');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '31', '2014-04-27 23:11:24', '2014-04-27 23:11:27');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '32', '2014-04-27 23:11:26', '2014-04-27 23:11:29');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '33', '2014-04-27 23:11:28', '2014-04-27 23:11:34');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '34', '2014-04-27 23:11:33', '2014-04-27 23:11:36');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '35', '2014-04-27 23:11:35', '2014-04-27 23:11:38');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '36', '2014-04-27 23:11:37', '2014-04-27 23:11:40');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '37', '2014-04-27 23:11:39', '2014-04-27 23:11:42');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '38', '2014-04-27 23:11:41', '2014-04-27 23:11:44');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '39', '2014-04-27 23:11:43', '2014-04-27 23:11:46');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '40', '2014-04-27 23:11:45', '2014-04-27 23:11:47');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '41', '2014-04-27 23:11:46', '2014-04-27 23:11:50');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '42', '2014-04-27 23:11:49', '2014-04-27 23:11:51');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '43', '2014-04-27 23:11:50', '2014-04-27 23:11:53');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '44', '2014-04-27 23:11:52', '2014-04-27 23:11:55');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '45', '2014-04-27 23:11:54', '2014-04-27 23:11:58');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '46', '2014-04-27 23:11:57', '2014-04-27 23:12:00');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '47', '2014-04-27 23:11:59', '2014-04-27 23:12:02');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '48', '2014-04-27 23:12:01', '2014-04-27 23:12:04');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.9995323909943', '116.330970488076', '49', '2014-04-27 23:12:03', '2014-04-27 23:12:06');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.9995323909943', '116.330970488076', '50', '2014-04-27 23:12:05', '2014-04-27 23:12:07');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.9995341418394', '116.331097257565', '51', '2014-04-27 23:12:07', '2014-04-27 23:12:10');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.9995341418394', '116.331097257565', '52', '2014-04-27 23:12:09', '2014-04-27 23:12:12');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.9995883522178', '116.33119505036', '53', '2014-04-27 23:12:11', '2014-04-27 23:12:14');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.9995883522178', '116.33119505036', '54', '2014-04-27 23:12:13', '2014-04-27 23:12:16');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.9996576001401', '116.331376097841', '55', '2014-04-27 23:12:15', '2014-04-27 23:12:18');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.9996576001401', '116.331376097841', '56', '2014-04-27 23:12:17', '2014-04-27 23:12:20');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999504782835', '116.331590890462', '57', '2014-04-27 23:12:34', '2014-04-27 23:12:37');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999504782835', '116.331590890462', '58', '2014-04-27 23:12:36', '2014-04-27 23:12:39');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.9994804302662', '116.331458153341', '59', '2014-04-27 23:13:02', '2014-04-27 23:13:05');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.9994804302662', '116.331458153341', '60', '2014-04-27 23:13:04', '2014-04-27 23:13:07');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '61', '2014-04-27 23:13:36', '2014-04-27 23:13:39');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '62', '2014-04-27 23:13:38', '2014-04-27 23:13:41');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '63', '2014-04-27 23:13:49', '2014-04-27 23:13:52');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '64', '2014-04-27 23:13:51', '2014-04-27 23:13:54');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '65', '2014-04-27 23:13:53', '2014-04-27 23:13:56');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '66', '2014-04-27 23:13:55', '2014-04-27 23:13:58');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '67', '2014-04-27 23:13:57', '2014-04-27 23:14:00');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '68', '2014-04-27 23:13:59', '2014-04-27 23:14:02');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '69', '2014-04-27 23:14:01', '2014-04-27 23:14:04');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '70', '2014-04-27 23:14:03', '2014-04-27 23:14:06');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '71', '2014-04-27 23:14:05', '2014-04-27 23:14:08');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '72', '2014-04-27 23:14:07', '2014-04-27 23:14:10');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '73', '2014-04-27 23:14:09', '2014-04-27 23:14:12');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '74', '2014-04-27 23:14:11', '2014-04-27 23:14:14');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '75', '2014-04-27 23:14:13', '2014-04-27 23:14:16');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '76', '2014-04-27 23:14:15', '2014-04-27 23:14:18');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '77', '2014-04-27 23:14:17', '2014-04-27 23:14:20');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.99924', '116.33089', '78', '2014-04-27 23:14:19', '2014-04-27 23:14:22');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '1', '2014-04-27 23:14:43', '2014-04-27 23:14:45');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '2', '2014-04-27 23:14:44', '2014-04-27 23:14:45');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '3', '2014-04-27 23:14:49', '2014-04-27 23:14:50');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '4', '2014-04-27 23:14:49', '2014-04-27 23:14:52');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '5', '2014-04-27 23:14:54', '2014-04-27 23:14:55');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '6', '2014-04-27 23:14:54', '2014-04-27 23:14:55');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '7', '2014-04-27 23:14:54', '2014-04-27 23:14:55');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '8', '2014-04-27 23:14:59', '2014-04-27 23:15:00');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '9', '2014-04-27 23:14:59', '2014-04-27 23:15:00');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '10', '2014-04-27 23:14:59', '2014-04-27 23:15:00');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '11', '2014-04-27 23:15:04', '2014-04-27 23:15:05');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '12', '2014-04-27 23:15:04', '2014-04-27 23:15:05');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '13', '2014-04-27 23:15:04', '2014-04-27 23:15:06');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '14', '2014-04-27 23:15:09', '2014-04-27 23:15:10');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '15', '2014-04-27 23:15:09', '2014-04-27 23:15:10');
INSERT INTO `locusinfo` VALUES ('hehehe', '1', '39.999266', '116.331315', '16', '2014-04-27 23:15:09', '2014-04-27 23:15:10');
INSERT INTO `product` VALUES ('11', 'ac', '50', '1954-11-21', '1', 'as');
INSERT INTO `uid2epc` VALUES ('11', '11', '1', '1', '1954-11-12');
INSERT INTO `userdata` VALUES ('ab', 'ab', 'ab', '5', 'ab', '50', '50', '50', 'ab', '1954-11-21', 'ab', 'ab', 'ab');
INSERT INTO `userdata` VALUES ('ac', 'bb', '44', '1', 'rh', '20', '12', '23', '2', '1954-11-21', '24', '5', 'gr');
INSERT INTO `username2bid` VALUES ('1aa', '0', '22');
INSERT INTO `username2bid` VALUES ('aa', '0', '22');
INSERT INTO `username2bid` VALUES ('1aa', '1', '22');
INSERT INTO `username2bid` VALUES ('hahaha', '0', '11');
INSERT INTO `username2bid` VALUES ('hahaha', '0', '22');
INSERT INTO `username2bid` VALUES ('hahaha', '0', '33');
INSERT INTO `username2bid` VALUES ('hahaha', '0', '44');
INSERT INTO `username2bid` VALUES ('hahaha', '3', '11');
INSERT INTO `username2bid` VALUES ('hh', '3', '11');
INSERT INTO `username2bid` VALUES ('hahaha', '1', '33');
INSERT INTO `username2bid` VALUES ('hahaha', '1', '44');
INSERT INTO `username2bid` VALUES ('hahaha', '2', '22');
INSERT INTO `username2bid` VALUES ('hahaha', '2', '22');
INSERT INTO `username2bid` VALUES ('hahaha', '2', '33');
INSERT INTO `username2bid` VALUES ('hahaha', '2', '44');
INSERT INTO `username2bid` VALUES ('h', '1', 'aa');
INSERT INTO `username2bid` VALUES ('f', '1', 'aa');
INSERT INTO `username2bid` VALUES ('d', '1', 'aa');
INSERT INTO `username2bid` VALUES ('hehehe', '0', 'bb');
INSERT INTO `username2bid` VALUES ('hehehe', '1', 'bb');
