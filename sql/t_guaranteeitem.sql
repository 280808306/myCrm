/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-06-17 19:39:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_guaranteeitem
-- ----------------------------
DROP TABLE IF EXISTS `t_guaranteeitem`;
CREATE TABLE `t_guaranteeitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `guaranteeTime` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `isSolve` int(1) DEFAULT NULL,
  `guarantee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_guaranteeitem
-- ----------------------------
INSERT INTO `t_guaranteeitem` VALUES ('1', '2016-06-15 00:00:00', '342432', '1', '1');
INSERT INTO `t_guaranteeitem` VALUES ('2', null, 'ghdgf', '0', '1');
INSERT INTO `t_guaranteeitem` VALUES ('4', '2016-06-06 00:00:00', 'gfdsgfd', '1', '2');
