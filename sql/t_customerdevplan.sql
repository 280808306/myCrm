/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-06-14 09:30:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_customerdevplan
-- ----------------------------
DROP TABLE IF EXISTS `t_customerdevplan`;
CREATE TABLE `t_customerdevplan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `planTime` datetime DEFAULT NULL,
  `planSubject` varchar(255) NOT NULL,
  `planDetails` varchar(255) NOT NULL,
  `planType_id` bigint(20) DEFAULT NULL,
  `potentialCustomer_id` bigint(20) DEFAULT NULL,
  `inputUser_id` bigint(20) NOT NULL,
  `inputTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customerdevplan
-- ----------------------------
INSERT INTO `t_customerdevplan` VALUES ('1', null, 'aaaaa', 'bbbb', '1', null, '1', '2016-06-13 19:10:51');
INSERT INTO `t_customerdevplan` VALUES ('2', null, 'bbbbb', 'dfdsafdf', '1', null, '1', '2016-06-13 20:21:11');
INSERT INTO `t_customerdevplan` VALUES ('4', null, 'cccccc', 'edfsdgdasg', '1', null, '1', '2016-06-13 20:21:23');
