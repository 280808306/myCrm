/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-06-17 19:39:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_guarantee
-- ----------------------------
DROP TABLE IF EXISTS `t_guarantee`;
CREATE TABLE `t_guarantee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_guarantee
-- ----------------------------
INSERT INTO `t_guarantee` VALUES ('1', 'sd', '1', '2016-06-17 00:00:00');
INSERT INTO `t_guarantee` VALUES ('2', 'ssd', '1', '2016-06-30 00:00:00');
