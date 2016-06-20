/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-06-14 09:42:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_potentialcustomer
-- ----------------------------
DROP TABLE IF EXISTS `t_potentialcustomer`;
CREATE TABLE `t_potentialcustomer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `successRate` float(10,0) NOT NULL,
  `remark` varchar(255) NOT NULL,
  `linkMan` varchar(255) DEFAULT NULL,
  `linkManTel` varchar(255) DEFAULT NULL,
  `inputTime` datetime NOT NULL,
  `inputUser_id` bigint(20) NOT NULL,
  `customerSource_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_potentialcustomer
-- ----------------------------
INSERT INTO `t_potentialcustomer` VALUES ('1', 'tom', '70', 'sdf', null, null, '2016-06-11 19:05:10', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('2', 'tom', '70', 'sdf', null, null, '2016-06-11 19:05:55', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('3', 'tom0', '70', 'sdf0', null, null, '2016-06-11 20:12:52', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('4', 'tom1', '70', 'sdf1', null, null, '2016-06-11 20:12:52', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('5', 'tom2', '70', 'sdf2', null, null, '2016-06-11 20:12:52', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('8', 'tom5', '70', 'sdf5', null, null, '2016-06-11 20:12:52', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('9', 'tom6', '70', 'sdf6', null, null, '2016-06-11 20:12:52', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('10', 'tom7', '70', 'sdf7', null, null, '2016-06-11 20:12:52', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('11', 'tom8', '70', 'sdf8', null, null, '2016-06-11 20:12:52', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('12', 'tom9', '70', 'sdf9', null, null, '2016-06-11 20:12:52', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('13', 'tom10', '70', 'sdf10', null, null, '2016-06-11 20:12:52', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('14', 'tom11', '70', 'sdf11', null, null, '2016-06-11 20:12:52', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('15', 'tom12', '70', 'sdf12', null, null, '2016-06-11 20:12:52', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('16', 'tom13', '70', 'sdf13', null, null, '2016-06-11 20:12:52', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('17', 'tom14', '70', 'sdf14', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('18', 'tom15', '70', 'sdf15', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('19', 'tom16', '70', 'sdf16', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('20', 'tom17', '70', 'sdf17', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('21', 'tom18', '70', 'sdf18', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('22', 'tom19', '70', 'sdf19', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('23', 'tom20', '70', 'sdf20', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('24', 'tom21', '70', 'sdf21', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('25', 'tom22', '70', 'sdf22', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('26', 'tom23', '70', 'sdf23', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('27', 'tom24', '70', 'sdf24', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('28', 'tom25', '70', 'sdf25', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('29', 'tom26', '70', 'sdf26', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('30', 'tom27', '70', 'sdf27', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('31', 'tom28', '70', 'sdf28', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('32', 'tom29', '70', 'sdf29', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('33', 'tom30', '70', 'sdf30', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('34', 'tom31', '70', 'sdf31', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('35', 'tom32', '70', 'sdf32', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('36', 'tom33', '70', 'sdf33', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('37', 'tom34', '70', 'sdf34', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('38', 'tom35', '70', 'sdf35', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('39', 'tom36', '70', 'sdf36', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('40', 'tom37', '70', 'sdf37', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('41', 'tom38', '70', 'sdf38', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('42', 'tom39', '70', 'sdf39', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('43', 'tom40', '70', 'sdf40', null, null, '2016-06-11 20:12:53', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('44', 'tom41', '70', 'sdf41', null, null, '2016-06-11 20:12:54', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('45', 'tom42', '70', 'sdf42', null, null, '2016-06-11 20:12:54', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('46', 'tom43', '70', 'sdf43', null, null, '2016-06-11 20:12:54', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('47', 'tom44', '70', 'sdf44', null, null, '2016-06-11 20:12:54', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('48', 'tom45', '70', 'sdf45', null, null, '2016-06-11 20:12:54', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('49', 'tom46', '70', 'sdf46', null, null, '2016-06-11 20:12:54', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('50', 'tom47', '70', 'sdf47', null, null, '2016-06-11 20:12:54', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('51', 'tom48', '70', 'sdf48', null, null, '2016-06-11 20:12:54', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('52', 'tom49', '70', 'sdf49', null, null, '2016-06-11 20:12:54', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('53', 'lym', '40', 'fgsg', 'luyunming', '12345678901', '2016-06-11 20:49:13', '1', null);
INSERT INTO `t_potentialcustomer` VALUES ('104', 'rr', '34', 'rrr', 'rrr', '11243243421', '2016-06-13 15:28:16', '1', null);
