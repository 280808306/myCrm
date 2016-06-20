/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-06-14 09:19:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_systemmenu
-- ----------------------------
DROP TABLE IF EXISTS `t_systemmenu`;
CREATE TABLE `t_systemmenu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(40) NOT NULL,
  `name` varchar(20) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `icon` varchar(40) DEFAULT NULL,
  `url` varchar(80) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;

INSERT INTO `t_systemmenu` VALUES ('1', 'sn-1', '业务模块', null, null, null, null);
INSERT INTO `t_systemmenu` VALUES ('2', 'sn-2', '客户管理', '1', '', '/customer/customer', '');
INSERT INTO `t_systemmenu` VALUES ('3', 'sn-3', '客户跟进管理', '1', '', '/customerTraceHistory/customerTraceHistory', '');
INSERT INTO `t_systemmenu` VALUES ('4', 'sn-4', '客户移交历史', '1', null, null, null);
INSERT INTO `t_systemmenu` VALUES ('5', 'sn-5', '客户资源池（回收站）', '1', null, null, null);
INSERT INTO `t_systemmenu` VALUES ('6', 'sn-6', '系统模块', null, null, null, null);
INSERT INTO `t_systemmenu` VALUES ('7', 'sn-7', '用户管理', '6', '', '/employee/index', '');
INSERT INTO `t_systemmenu` VALUES ('8', 'sn-8', '部门管理', '6', null, '/department', null);
INSERT INTO `t_systemmenu` VALUES ('9', 'sn-9', '权限功能', '6', null, null, null);
INSERT INTO `t_systemmenu` VALUES ('10', 'sn-10', '资源管理', '9', '', '/resource', '');
INSERT INTO `t_systemmenu` VALUES ('11', 'sn-11', '权限管理', '9', '', '/permission', '');
INSERT INTO `t_systemmenu` VALUES ('12', 'sn-12', '角色管理', '9', null, null, null);
INSERT INTO `t_systemmenu` VALUES ('13', 'sn-13', '系统菜单管理', '6', 'icon-system-menu', '/systemMenu', '');
INSERT INTO `t_systemmenu` VALUES ('14', 'sn-14', '数据字典管理', '6', null, '/systemDictionary', null);
INSERT INTO `t_systemmenu` VALUES ('17', 'sn-15', '系统日志管理', '6', null, null, null);
INSERT INTO `t_systemmenu` VALUES ('124', 'sn-11111', '营销管理', null, '', '', '营销管理');
INSERT INTO `t_systemmenu` VALUES ('125', '', '潜在客户管理', '124', '', '/potentialCustomer/index', '潜在客户管理');
INSERT INTO `t_systemmenu` VALUES ('126', 'sn-111', '潜在客户开发计划', '124', '', '/customerDevPlan/index', 'xxxx');
