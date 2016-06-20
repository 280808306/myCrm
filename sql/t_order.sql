/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-06-14 11:13:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) DEFAULT NULL,
  `signTime` datetime DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) NOT NULL,
  `seller_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '001', '2016-06-14 10:35:06', 'rgsfgf', '1', '1');
INSERT INTO `t_order` VALUES ('2', '002', '2016-06-09 10:35:26', 'hvhgfjhgf', '2', '1');
INSERT INTO `t_order` VALUES ('3', '003', '2016-06-14 10:35:47', '广东省股份', '2', '2');
INSERT INTO `t_order` VALUES ('4', '005', '2016-06-14 10:49:07', 'fgsdfgdslj', '2', null);
