/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50729
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-02-01 17:14:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `keyword` varchar(64) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '新增知识', 'KNOWLEDGE_ADD', null);
INSERT INTO `permission` VALUES ('2', '删除知识', 'KNOWLEDGE_DELETE', null);
INSERT INTO `permission` VALUES ('3', '编辑知识', 'KNOWLEDGE_EDIT', null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `keyword` varchar(64) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '系统管理员', 'ROLE_ADMIN', null);
INSERT INTO `role` VALUES ('2', '教师', 'ROLE_TEACHER', null);
INSERT INTO `role` VALUES ('3', '学生', 'ROLE_STUDENT', ' ');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1');
INSERT INTO `role_permission` VALUES ('1', '2');
INSERT INTO `role_permission` VALUES ('1', '3');
INSERT INTO `role_permission` VALUES ('1', '4');
INSERT INTO `role_permission` VALUES ('1', '5');
INSERT INTO `role_permission` VALUES ('1', '6');
INSERT INTO `role_permission` VALUES ('1', '7');
INSERT INTO `role_permission` VALUES ('1', '8');
INSERT INTO `role_permission` VALUES ('1', '9');
INSERT INTO `role_permission` VALUES ('1', '10');
INSERT INTO `role_permission` VALUES ('1', '11');
INSERT INTO `role_permission` VALUES ('1', '12');
INSERT INTO `role_permission` VALUES ('2', '1');
INSERT INTO `role_permission` VALUES ('2', '3');
INSERT INTO `role_permission` VALUES ('2', '4');
INSERT INTO `role_permission` VALUES ('2', '5');
INSERT INTO `role_permission` VALUES ('2', '7');
INSERT INTO `role_permission` VALUES ('2', '8');
INSERT INTO `role_permission` VALUES ('2', '9');
INSERT INTO `role_permission` VALUES ('2', '11');
INSERT INTO `role_permission` VALUES ('2', '12');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `station` varchar(1) DEFAULT NULL COMMENT '状态',
  `telephone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'root', '$2a$10$cEswspHBE7FLS7WoXhjRpO0fpLwLUb5/0d6pkErwmMEFUvl8.ux2O', '0', '1990-12-12', '0', '0', '1294329489');
INSERT INTO `user` VALUES ('2', 'zhangsan', '$2a$10$cEswspHBE7FLS7WoXhjRpO0fpLwLUb5/0d6pkErwmMEFUvl8.ux2O', '0', '2020-12-12', '2', '3', '3');
INSERT INTO `user` VALUES ('4', 'lisi', '$2a$10$cEswspHBE7FLS7WoXhjRpO0fpLwLUb5/0d6pkErwmMEFUvl8.ux2O', '0', '1991-12-12', '0', '0', '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
INSERT INTO `user_role` VALUES ('4', '3');
