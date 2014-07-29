/*
MySQL Data Transfer
Source Host: localhost
Source Database: bt
Target Host: localhost
Target Database: bt
Date: 2014/4/24 14:28:23
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
  `scanDate` date NOT NULL,
  `x` double NOT NULL,
  `y` double NOT NULL,
  `username` varchar(100) NOT NULL,
  `match` smallint(6) NOT NULL,
  `type` smallint(6) NOT NULL
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
  `order` bigint(20) NOT NULL
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
  `recall` int(6) NOT NULL,
  `isExpire` int(6) NOT NULL,
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
