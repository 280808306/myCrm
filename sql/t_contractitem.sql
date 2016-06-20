/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-06-17 19:39:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_contractitem
-- ----------------------------
DROP TABLE IF EXISTS `t_contractitem`;
CREATE TABLE `t_contractitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `payTime` datetime DEFAULT NULL,
  `money` decimal(12,2) NOT NULL,
  `scale` decimal(7,5) DEFAULT NULL,
  `isPayment` int(11) DEFAULT '0',
  `contract_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_contractitem
-- ----------------------------
INSERT INTO `t_contractitem` VALUES ('1', null, '2000.00', '0.25000', '0', '1');
INSERT INTO `t_contractitem` VALUES ('2', null, '2000.00', '0.25000', '0', '1');
INSERT INTO `t_contractitem` VALUES ('3', null, '2000.00', '0.25000', '0', '1');
INSERT INTO `t_contractitem` VALUES ('4', null, '2000.00', '0.25000', '0', '1');
INSERT INTO `t_contractitem` VALUES ('18', null, '2000.00', null, '1', '7');
INSERT INTO `t_contractitem` VALUES ('19', null, '3000.00', null, '1', '7');
INSERT INTO `t_contractitem` VALUES ('20', null, '3333.00', null, '1', '7');
INSERT INTO `t_contractitem` VALUES ('21', null, '32432.00', null, '0', '7');
INSERT INTO `t_contractitem` VALUES ('22', '2016-06-14 00:00:00', '333.00', null, '1', '9');
INSERT INTO `t_contractitem` VALUES ('23', null, '4353.00', null, '0', '9');
INSERT INTO `t_contractitem` VALUES ('24', null, '4344.00', null, '0', '9');
INSERT INTO `t_contractitem` VALUES ('25', null, '342.00', null, '1', '8');
INSERT INTO `t_contractitem` VALUES ('26', null, '3433.00', null, '0', '8');
INSERT INTO `t_contractitem` VALUES ('27', null, '453.00', null, '0', '8');
