/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-06-14 19:28:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_contract
-- ----------------------------
DROP TABLE IF EXISTS `t_contract`;
CREATE TABLE `t_contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) DEFAULT NULL,
  `signTime` datetime DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `sum` decimal(10,0) DEFAULT NULL,
  `customer_id` bigint(20) NOT NULL,
  `seller_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_contract
-- ----------------------------
INSERT INTO `t_contract` VALUES ('1', 'sdas', '2016-06-14 19:10:42', '和四个覆盖', '3423', '1', '1');
INSERT INTO `t_contract` VALUES ('2', '005', '2016-06-14 19:26:45', 'fgsdfgdslj', '50000000', '1', '3');
INSERT INTO `t_contract` VALUES ('3', 'gafdgag', '2016-06-14 19:19:16', '34254324', '34234', '2', '3');
