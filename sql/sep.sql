/*
Navicat MySQL Data Transfer

Source Server         : 10.7.90.210
Source Server Version : 50505
Source Host           : 10.7.90.210:3306
Source Database       : sep

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2015-05-30 14:07:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `Dic`
-- ----------------------------
DROP TABLE IF EXISTS `Dic`;
CREATE TABLE `Dic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `obj` varchar(128) DEFAULT NULL,
  `attr` varchar(128) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Dic
-- ----------------------------
INSERT INTO `Dic` VALUES ('1', null, 'Gd', 'gdlx', '功能新增', '1');
INSERT INTO `Dic` VALUES ('2', null, 'Gd', 'gdlx', '软件故障', '2');
INSERT INTO `Dic` VALUES ('3', null, 'Gd', 'gdlx', '硬件故障', '3');
INSERT INTO `Dic` VALUES ('4', null, 'Gd', 'gdlx', '日常巡检', '4');
INSERT INTO `Dic` VALUES ('5', null, 'Gd', 'zt', '新建', '1');
INSERT INTO `Dic` VALUES ('6', null, 'Gd', 'zt', '已派单', '2');
INSERT INTO `Dic` VALUES ('7', null, 'Gd', 'zt', '施工中', '3');
INSERT INTO `Dic` VALUES ('8', null, 'Gd', 'zt', '完工', '4');
INSERT INTO `Dic` VALUES ('9', null, 'Gd', 'zt', '已评价', '5');
INSERT INTO `Dic` VALUES ('10', null, 'Gd', 'state', '已删除', '0');
INSERT INTO `Dic` VALUES ('11', null, 'Gd', 'state', '正常', '1');
INSERT INTO `Dic` VALUES ('12', null, 'Gd', 'jj', '普通', '1');
INSERT INTO `Dic` VALUES ('13', null, 'Gd', 'jj', '紧急', '2');
INSERT INTO `Dic` VALUES ('15', null, 'Gd', 'pj', '好评', '1');
INSERT INTO `Dic` VALUES ('16', null, 'Gd', 'pj', '中评', '2');
INSERT INTO `Dic` VALUES ('17', null, 'Gd', 'pj', '差评', '3');
INSERT INTO `Dic` VALUES ('18', null, 'Gd', 'jf', '计分', '1');
INSERT INTO `Dic` VALUES ('19', null, 'Gd', 'jf', '不计分', '2');
INSERT INTO `Dic` VALUES ('20', null, 'User', 'whdj', '普通', '1');
INSERT INTO `Dic` VALUES ('21', null, 'User', 'whdj', '高级', '2');

-- ----------------------------
-- Table structure for `FileInfo`
-- ----------------------------
DROP TABLE IF EXISTS `FileInfo`;
CREATE TABLE `FileInfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `fileName` varchar(512) DEFAULT NULL COMMENT '文件名称',
  `fileUrl` varchar(512) DEFAULT NULL COMMENT '文件路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of FileInfo
-- ----------------------------
INSERT INTO `FileInfo` VALUES ('69', null, 'wifi.txt', 'C:\\cache\\upload_gd\\69\\wifi.txt');
INSERT INTO `FileInfo` VALUES ('70', null, 'title.png', 'C:\\cache\\upload_gd\\70\\title.png');
INSERT INTO `FileInfo` VALUES ('71', null, 'wifi.txt', 'C:\\cache\\upload_gd\\71\\wifi.txt');
INSERT INTO `FileInfo` VALUES ('72', null, 'ComputerZ_CN.exe', 'C:\\cache\\upload_gd\\72\\ComputerZ_CN.exe');
INSERT INTO `FileInfo` VALUES ('73', null, 'title.png', 'C:\\cache\\upload_gd\\73\\title.png');
INSERT INTO `FileInfo` VALUES ('74', null, 'title.png', 'C:\\cache\\upload_gd\\74\\title.png');
INSERT INTO `FileInfo` VALUES ('75', null, '公司网站内容更新方法.doc', 'C:\\cache\\upload_gd\\75\\公司网站内容更新方法.doc');
INSERT INTO `FileInfo` VALUES ('76', null, 'aaaaa.doc', 'C:\\cache\\upload_gd\\76\\aaaaa.doc');

-- ----------------------------
-- Table structure for `PermInstance`
-- ----------------------------
DROP TABLE IF EXISTS `PermInstance`;
CREATE TABLE `PermInstance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permissionId` bigint(20) DEFAULT NULL,
  `roleId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of PermInstance
-- ----------------------------
INSERT INTO `PermInstance` VALUES ('1', '1', '1');
INSERT INTO `PermInstance` VALUES ('2', '2', '1');
INSERT INTO `PermInstance` VALUES ('3', '3', '1');
INSERT INTO `PermInstance` VALUES ('4', '4', '1');
INSERT INTO `PermInstance` VALUES ('5', '5', '2');
INSERT INTO `PermInstance` VALUES ('6', '6', '2');
INSERT INTO `PermInstance` VALUES ('7', '7', '3');
INSERT INTO `PermInstance` VALUES ('8', '8', '3');
INSERT INTO `PermInstance` VALUES ('9', '9', '3');
INSERT INTO `PermInstance` VALUES ('10', '10', '3');
INSERT INTO `PermInstance` VALUES ('11', '11', '3');
INSERT INTO `PermInstance` VALUES ('12', '12', '3');
INSERT INTO `PermInstance` VALUES ('13', '13', '4');
INSERT INTO `PermInstance` VALUES ('14', '14', '4');
INSERT INTO `PermInstance` VALUES ('15', '1', '99');
INSERT INTO `PermInstance` VALUES ('16', '2', '99');
INSERT INTO `PermInstance` VALUES ('17', '3', '99');
INSERT INTO `PermInstance` VALUES ('18', '4', '99');
INSERT INTO `PermInstance` VALUES ('19', '5', '99');
INSERT INTO `PermInstance` VALUES ('20', '6', '99');
INSERT INTO `PermInstance` VALUES ('21', '7', '99');
INSERT INTO `PermInstance` VALUES ('22', '8', '99');
INSERT INTO `PermInstance` VALUES ('23', '9', '99');
INSERT INTO `PermInstance` VALUES ('24', '10', '99');
INSERT INTO `PermInstance` VALUES ('25', '11', '99');
INSERT INTO `PermInstance` VALUES ('26', '12', '99');
INSERT INTO `PermInstance` VALUES ('27', '13', '99');
INSERT INTO `PermInstance` VALUES ('28', '14', '99');
INSERT INTO `PermInstance` VALUES ('29', '15', '1');
INSERT INTO `PermInstance` VALUES ('30', '15', '2');
INSERT INTO `PermInstance` VALUES ('31', '15', '3');
INSERT INTO `PermInstance` VALUES ('32', '15', '4');
INSERT INTO `PermInstance` VALUES ('33', '15', '99');
INSERT INTO `PermInstance` VALUES ('34', '16', '3');
INSERT INTO `PermInstance` VALUES ('35', '16', '99');

-- ----------------------------
-- Table structure for `Permission`
-- ----------------------------
DROP TABLE IF EXISTS `Permission`;
CREATE TABLE `Permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Permission
-- ----------------------------
INSERT INTO `Permission` VALUES ('1', '客户维护申请页面');
INSERT INTO `Permission` VALUES ('2', '未完工单');
INSERT INTO `Permission` VALUES ('3', '已完评价');
INSERT INTO `Permission` VALUES ('4', '投诉建议');
INSERT INTO `Permission` VALUES ('5', '待接工单');
INSERT INTO `Permission` VALUES ('6', '已完工单');
INSERT INTO `Permission` VALUES ('7', '主动派单');
INSERT INTO `Permission` VALUES ('8', '客户管理');
INSERT INTO `Permission` VALUES ('9', '被动派单');
INSERT INTO `Permission` VALUES ('10', '人员管理');
INSERT INTO `Permission` VALUES ('11', '工单列表');
INSERT INTO `Permission` VALUES ('12', '工作量统计(施工)');
INSERT INTO `Permission` VALUES ('13', '已完成工单列表');
INSERT INTO `Permission` VALUES ('14', '查看投诉建议');
INSERT INTO `Permission` VALUES ('15', '修改密码');
INSERT INTO `Permission` VALUES ('16', '工作量统计(客户)');

-- ----------------------------
-- Table structure for `Role`
-- ----------------------------
DROP TABLE IF EXISTS `Role`;
CREATE TABLE `Role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(128) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Role
-- ----------------------------
INSERT INTO `Role` VALUES ('1', '客户');
INSERT INTO `Role` VALUES ('2', '施工人员');
INSERT INTO `Role` VALUES ('3', '售后经理');
INSERT INTO `Role` VALUES ('4', '回访人员');
INSERT INTO `Role` VALUES ('99', '超级管理员');

-- ----------------------------
-- Table structure for `Tenant`
-- ----------------------------
DROP TABLE IF EXISTS `Tenant`;
CREATE TABLE `Tenant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` int(11) DEFAULT NULL COMMENT '当前状态',
  `name` varchar(128) DEFAULT NULL COMMENT '租户名称',
  `country` varchar(128) DEFAULT NULL COMMENT '租户国家',
  `province` varchar(128) DEFAULT NULL COMMENT '租户省份',
  `city` varchar(128) DEFAULT NULL COMMENT '租户城市',
  `contactor` varchar(128) DEFAULT NULL COMMENT '联系人',
  `address` varchar(128) DEFAULT NULL COMMENT '租户地址',
  `telephone` varchar(128) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(128) DEFAULT NULL COMMENT '电子邮箱',
  `co` varchar(128) DEFAULT NULL COMMENT '用户登陆标签',
  `createTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='租户表\r\n';

-- ----------------------------
-- Records of Tenant
-- ----------------------------
INSERT INTO `Tenant` VALUES ('1', '1', '浙江师范大学', '中国', '浙江', '金华', '陈涛', '浙师大路1号', '15268639007', '1393899065@qq.com', 'zjnu', '2015-01-19 23:09:24');
INSERT INTO `Tenant` VALUES ('2', '1', 'hgy', 'hgy', 'hgy', 'hgy', 'hgy', 'hgy', 'hgy', 'hgy', 'hgy', '2015-01-19 23:09:29');
INSERT INTO `Tenant` VALUES ('3', '1', 'wl', 'wl', 'wl', 'wl', 'wl', 'wl', 'wl', 'wl', 'wl', '2015-01-16 15:43:42');

-- ----------------------------
-- Table structure for `User`
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `saasId` bigint(20) DEFAULT NULL COMMENT '公司标示',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `createTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `userName` varchar(64) DEFAULT NULL COMMENT '登陆名称',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `realName` varchar(128) DEFAULT NULL COMMENT '客户名称',
  `roleId` bigint(20) DEFAULT NULL COMMENT '外键角色Id',
  `phone` varchar(128) DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of User
-- ----------------------------
INSERT INTO `User` VALUES ('1', null, '1', null, '1', '1', '浙江力得', '1', '11');
INSERT INTO `User` VALUES ('2', null, '1', null, '2', '2', '浙江力得', '2', '11');
INSERT INTO `User` VALUES ('3', null, '1', null, '3', '3', '浙江力得', '3', '11');
INSERT INTO `User` VALUES ('4', null, '1', null, '4', '4', '浙江力得', '4', '1111');
INSERT INTO `User` VALUES ('5', null, '1', null, '99', '99', '浙江力得', '99', '1111111');
INSERT INTO `User` VALUES ('6', null, '1', null, '6', '6', '浙江力得', '2', '1222');
INSERT INTO `User` VALUES ('7', null, '1', null, '7', '7', '中心医院', '1', '1211212');
INSERT INTO `User` VALUES ('8', null, '1', null, '8', '8', '人民医院', '1', '1252');
INSERT INTO `User` VALUES ('9', null, '0', null, 'aa', 'aa', 'aa', '1', 'aa');
INSERT INTO `User` VALUES ('10', null, '1', null, 'bb', 'bb', '浙江力得', '3', 'bb');
INSERT INTO `User` VALUES ('11', null, '1', null, 'uu', '', 'uu', '1', 'uu');
INSERT INTO `User` VALUES ('12', null, '0', null, '', '', '', '1', '');
INSERT INTO `User` VALUES ('13', null, '0', null, '', '', '', '1', '');
INSERT INTO `User` VALUES ('14', null, '0', null, 'a', '', 'q', '1', 'a');
INSERT INTO `User` VALUES ('15', null, '1', null, '', '', '浙江力得', '3', '');
INSERT INTO `User` VALUES ('16', null, '1', null, 'aaaa', '', '浙江力得', '2', '');
INSERT INTO `User` VALUES ('17', null, '1', null, 'cc', 'cc', '浙江力得', null, '');
INSERT INTO `User` VALUES ('18', null, '1', null, 'cc', 'cc', '浙江力得', '2', 'a');
INSERT INTO `User` VALUES ('19', null, '1', null, 'yui', '0000', 'yuio', '1', 'yuio');
INSERT INTO `User` VALUES ('20', null, '1', null, 'qw2', '0000', '浙江力得', '2', 'qw2');
INSERT INTO `User` VALUES ('21', null, '1', null, 'wew', '0000', '浙江力得', '2', 'wew');
