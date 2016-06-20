/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2016-06-14 09:52:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_employee`
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dept_id` bigint(255) DEFAULT NULL,
  `inputTime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('2', '1111111', '蛋霸王', '123', '123', null, null, null, null, null);
INSERT INTO `t_employee` VALUES ('3', '1111111', '王霸胆', '123', '123', null, null, null, null, null);
INSERT INTO `t_employee` VALUES ('4', 'ssssssss', null, null, 'ssssssssssssssss', 'ssssssssssss', null, '2016-06-13 21:51:25', null, null);
INSERT INTO `t_employee` VALUES ('5', 'ssssssss', null, null, 'aaaaaaa', 'aaaaaaa', null, '2016-06-13 21:51:35', null, null);
INSERT INTO `t_employee` VALUES ('6', '1231582', '1585123', '166222', '1111', '2222', null, '2016-06-14 09:13:07', null, null);
INSERT INTO `t_employee` VALUES ('7', '王尼玛', '王尼玛', '123', '1', '1758422507@qq.com', null, '2016-06-14 09:16:11', null, null);
