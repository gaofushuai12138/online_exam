/*
Navicat MySQL Data Transfer

Source Server         : company
Source Server Version : 50553
Source Host           : 192.168.42.1:3306
Source Database       : bs

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2020-01-02 13:19:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT '' COMMENT '文章内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1.有效  2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='发布号作者表';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('5', '莎士比亚', '2017-10-25 09:08:45', '2017-10-30 17:59:41', '1');
INSERT INTO `article` VALUES ('6', '亚里士多德', '2017-10-26 10:49:28', '2017-11-18 09:54:15', '1');
INSERT INTO `article` VALUES ('10', '亚历山大', '2017-10-26 14:57:45', '2017-11-08 13:28:52', '1');
INSERT INTO `article` VALUES ('11', '李白', '2017-10-26 15:23:42', '2017-10-26 15:23:42', '1');
INSERT INTO `article` VALUES ('19', '文章test2', '2017-11-18 13:37:07', '2017-11-18 13:37:11', '1');
INSERT INTO `article` VALUES ('20', '4334', '2019-12-31 12:14:53', '2019-12-31 12:14:57', '1');
INSERT INTO `article` VALUES ('21', 'hydsb', '2020-01-01 10:42:27', '2020-01-01 10:42:43', '1');

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '自定id,主要供前端展示权限列表分类排序使用.',
  `menu_code` varchar(255) DEFAULT '' COMMENT '归属菜单,前端判断并展示菜单使用,',
  `menu_name` varchar(255) DEFAULT '' COMMENT '菜单的中文释义',
  `permission_code` varchar(255) DEFAULT '' COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
  `permission_name` varchar(255) DEFAULT '' COMMENT '本权限的中文释义',
  `required_permission` tinyint(1) DEFAULT '2' COMMENT '是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('101', 'article', '文章管理', 'article:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('102', 'article', '文章管理', 'article:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('103', 'article', '文章管理', 'article:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('601', 'user', '用户', 'user:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('602', 'user', '用户', 'user:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('603', 'user', '用户', 'user:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('701', 'role', '角色权限', 'role:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('702', 'role', '角色权限', 'role:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('703', 'role', '角色权限', 'role:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('704', 'role', '角色权限', 'role:delete', '删除', '2');
INSERT INTO `sys_permission` VALUES ('705', 'role', '角色权限', 'role:test', '测试', '2');
INSERT INTO `sys_permission` VALUES ('801', 'log', '日志管理', 'log:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('802', 'log', '日志管理', 'log:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('803', 'log', '日志管理', 'log:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('804', 'log', '日志管理', 'log:delete', '删除', '2');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '2017-11-22 16:24:34', '2017-11-22 16:24:52', '1');
INSERT INTO `sys_role` VALUES ('2', '作家', '2017-11-22 16:24:34', '2017-11-22 16:24:52', '1');
INSERT INTO `sys_role` VALUES ('3', '程序员', '2017-11-22 16:28:47', '2019-12-31 11:10:07', '2');
INSERT INTO `sys_role` VALUES ('5', '超管', '2020-01-01 10:56:54', '2020-01-01 13:13:42', '2');
INSERT INTO `sys_role` VALUES ('6', '程序员', '2020-01-01 13:10:02', '2020-01-01 13:13:44', '2');
INSERT INTO `sys_role` VALUES ('7', '程序员', '2020-01-01 13:12:42', '2020-01-01 13:13:55', '1');
INSERT INTO `sys_role` VALUES ('8', '老师', '2020-01-01 14:10:01', '2020-01-01 14:10:36', '1');

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效 1有效     2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '2', '101', '2017-11-22 16:26:21', '2017-11-22 16:26:32', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '2', '102', '2017-11-22 16:26:21', '2017-11-22 16:26:32', '1');
INSERT INTO `sys_role_permission` VALUES ('5', '2', '602', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('6', '2', '601', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('7', '2', '603', '2017-11-22 16:28:28', '2020-01-01 13:13:10', '2');
INSERT INTO `sys_role_permission` VALUES ('8', '2', '703', '2017-11-22 16:28:28', '2019-12-31 11:22:15', '2');
INSERT INTO `sys_role_permission` VALUES ('9', '2', '701', '2017-11-22 16:28:28', '2019-12-31 11:22:15', '2');
INSERT INTO `sys_role_permission` VALUES ('10', '2', '702', '2017-11-22 16:28:28', '2019-12-31 11:22:15', '2');
INSERT INTO `sys_role_permission` VALUES ('11', '2', '704', '2017-11-22 16:28:31', '2019-12-31 11:22:15', '2');
INSERT INTO `sys_role_permission` VALUES ('12', '2', '103', '2017-11-22 16:28:31', '2017-11-22 16:28:31', '1');
INSERT INTO `sys_role_permission` VALUES ('13', '3', '601', '2017-11-22 16:28:47', '2019-12-31 11:10:08', '2');
INSERT INTO `sys_role_permission` VALUES ('14', '3', '701', '2017-11-22 16:28:47', '2019-12-31 11:10:08', '2');
INSERT INTO `sys_role_permission` VALUES ('15', '3', '702', '2017-11-22 16:35:01', '2019-12-31 11:10:08', '2');
INSERT INTO `sys_role_permission` VALUES ('16', '3', '704', '2017-11-22 16:35:01', '2019-12-31 11:10:08', '2');
INSERT INTO `sys_role_permission` VALUES ('17', '3', '102', '2017-11-22 16:35:01', '2019-12-31 11:10:08', '2');
INSERT INTO `sys_role_permission` VALUES ('18', '3', '101', '2017-11-22 16:35:01', '2019-12-31 11:10:08', '2');
INSERT INTO `sys_role_permission` VALUES ('19', '3', '603', '2017-11-22 16:35:01', '2019-12-31 11:10:08', '2');
INSERT INTO `sys_role_permission` VALUES ('20', '5', '101', '2020-01-01 10:56:54', '2020-01-01 13:13:42', '2');
INSERT INTO `sys_role_permission` VALUES ('21', '5', '102', '2020-01-01 10:56:54', '2020-01-01 13:13:42', '2');
INSERT INTO `sys_role_permission` VALUES ('22', '5', '103', '2020-01-01 10:56:54', '2020-01-01 13:13:42', '2');
INSERT INTO `sys_role_permission` VALUES ('23', '5', '601', '2020-01-01 10:56:54', '2020-01-01 13:13:42', '2');
INSERT INTO `sys_role_permission` VALUES ('24', '5', '602', '2020-01-01 10:56:54', '2020-01-01 13:13:42', '2');
INSERT INTO `sys_role_permission` VALUES ('25', '5', '603', '2020-01-01 10:56:54', '2020-01-01 13:13:42', '2');
INSERT INTO `sys_role_permission` VALUES ('26', '5', '701', '2020-01-01 10:56:54', '2020-01-01 13:11:02', '2');
INSERT INTO `sys_role_permission` VALUES ('27', '5', '702', '2020-01-01 10:56:54', '2020-01-01 13:11:02', '2');
INSERT INTO `sys_role_permission` VALUES ('28', '5', '703', '2020-01-01 10:56:54', '2020-01-01 13:11:02', '2');
INSERT INTO `sys_role_permission` VALUES ('29', '5', '704', '2020-01-01 10:56:54', '2020-01-01 13:11:02', '2');
INSERT INTO `sys_role_permission` VALUES ('30', '5', '705', '2020-01-01 10:56:54', '2020-01-01 13:11:02', '2');
INSERT INTO `sys_role_permission` VALUES ('31', '6', '101', '2020-01-01 13:10:02', '2020-01-01 13:13:44', '2');
INSERT INTO `sys_role_permission` VALUES ('32', '6', '102', '2020-01-01 13:10:02', '2020-01-01 13:10:52', '2');
INSERT INTO `sys_role_permission` VALUES ('33', '6', '103', '2020-01-01 13:10:02', '2020-01-01 13:13:29', '2');
INSERT INTO `sys_role_permission` VALUES ('34', '7', '101', '2020-01-01 13:12:42', '2020-01-01 13:13:55', '1');
INSERT INTO `sys_role_permission` VALUES ('35', '7', '102', '2020-01-01 13:12:42', '2020-01-01 13:13:55', '1');
INSERT INTO `sys_role_permission` VALUES ('36', '7', '103', '2020-01-01 13:12:42', '2020-01-01 13:13:55', '1');
INSERT INTO `sys_role_permission` VALUES ('37', '7', '601', '2020-01-01 13:12:42', '2020-01-01 18:51:36', '2');
INSERT INTO `sys_role_permission` VALUES ('38', '7', '602', '2020-01-01 13:12:42', '2020-01-01 18:51:36', '2');
INSERT INTO `sys_role_permission` VALUES ('39', '7', '603', '2020-01-01 13:12:42', '2020-01-01 13:26:57', '2');
INSERT INTO `sys_role_permission` VALUES ('40', '2', '603', '2020-01-01 14:08:52', '2020-01-01 14:08:52', '1');
INSERT INTO `sys_role_permission` VALUES ('41', '2', '701', '2020-01-01 14:08:56', '2020-01-01 14:08:56', '1');
INSERT INTO `sys_role_permission` VALUES ('42', '2', '702', '2020-01-01 14:08:56', '2020-01-01 14:08:56', '1');
INSERT INTO `sys_role_permission` VALUES ('43', '2', '703', '2020-01-01 14:08:56', '2020-01-01 14:08:56', '1');
INSERT INTO `sys_role_permission` VALUES ('44', '2', '704', '2020-01-01 14:08:56', '2020-01-01 14:08:56', '1');
INSERT INTO `sys_role_permission` VALUES ('45', '2', '705', '2020-01-01 14:08:56', '2020-01-01 14:08:56', '1');
INSERT INTO `sys_role_permission` VALUES ('46', '8', '101', '2020-01-01 14:10:01', '2020-01-01 14:10:36', '1');
INSERT INTO `sys_role_permission` VALUES ('47', '8', '102', '2020-01-01 14:10:01', '2020-01-01 14:10:36', '1');
INSERT INTO `sys_role_permission` VALUES ('48', '8', '103', '2020-01-01 14:10:01', '2020-01-01 14:10:36', '1');
INSERT INTO `sys_role_permission` VALUES ('49', '2', '801', '2020-01-01 14:14:52', '2020-01-01 14:14:52', '1');
INSERT INTO `sys_role_permission` VALUES ('50', '2', '802', '2020-01-01 14:14:52', '2020-01-01 14:14:52', '1');
INSERT INTO `sys_role_permission` VALUES ('51', '2', '803', '2020-01-01 14:14:52', '2020-01-01 14:14:52', '1');
INSERT INTO `sys_role_permission` VALUES ('52', '2', '804', '2020-01-01 14:14:52', '2020-01-01 14:14:52', '1');
INSERT INTO `sys_role_permission` VALUES ('53', '7', '701', '2020-01-01 14:15:35', '2020-01-01 14:15:35', '1');
INSERT INTO `sys_role_permission` VALUES ('54', '7', '702', '2020-01-01 14:15:35', '2020-01-01 14:15:35', '1');
INSERT INTO `sys_role_permission` VALUES ('55', '7', '703', '2020-01-01 14:15:35', '2020-01-01 14:15:35', '1');
INSERT INTO `sys_role_permission` VALUES ('56', '7', '704', '2020-01-01 14:15:35', '2020-01-01 14:15:35', '1');
INSERT INTO `sys_role_permission` VALUES ('57', '7', '705', '2020-01-01 14:15:35', '2020-01-01 14:15:35', '1');
INSERT INTO `sys_role_permission` VALUES ('58', '8', '801', '2020-01-01 14:15:40', '2020-01-01 14:15:40', '1');
INSERT INTO `sys_role_permission` VALUES ('59', '8', '802', '2020-01-01 14:15:40', '2020-01-01 14:15:40', '1');
INSERT INTO `sys_role_permission` VALUES ('60', '8', '803', '2020-01-01 14:15:40', '2020-01-01 14:15:40', '1');
INSERT INTO `sys_role_permission` VALUES ('61', '8', '804', '2020-01-01 14:15:40', '2020-01-01 18:40:50', '2');
INSERT INTO `sys_role_permission` VALUES ('62', '8', '701', '2020-01-01 18:40:40', '2020-01-01 18:40:40', '1');
INSERT INTO `sys_role_permission` VALUES ('63', '8', '702', '2020-01-01 18:40:40', '2020-01-01 18:40:40', '1');
INSERT INTO `sys_role_permission` VALUES ('64', '8', '703', '2020-01-01 18:40:40', '2020-01-01 18:40:40', '1');
INSERT INTO `sys_role_permission` VALUES ('65', '8', '704', '2020-01-01 18:40:40', '2020-01-01 18:40:50', '2');
INSERT INTO `sys_role_permission` VALUES ('66', '8', '705', '2020-01-01 18:40:40', '2020-01-01 18:40:40', '1');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `role_id` int(11) DEFAULT '0' COMMENT '角色ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10012 DEFAULT CHARSET=utf8 COMMENT='运营后台用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('10003', 'admin', '123456', '超级用户23', '1', '2017-10-30 11:52:38', '2020-01-01 13:11:47', '1');
INSERT INTO `sys_user` VALUES ('10004', 'user', '123456', '莎士比亚', '1', '2017-10-30 16:13:02', '2020-01-01 19:29:27', '1');
INSERT INTO `sys_user` VALUES ('10005', 'aaa', '123', 'abba', '1', '2017-11-15 14:02:56', '2019-12-31 11:21:19', '1');
INSERT INTO `sys_user` VALUES ('10007', 'test', '123456', '就看看列表', '3', '2017-11-22 16:29:41', '2019-12-31 10:24:49', '2');
INSERT INTO `sys_user` VALUES ('10008', '32', '32', '324', '1', '2019-12-31 12:05:25', '2019-12-31 12:05:47', '1');
INSERT INTO `sys_user` VALUES ('10009', 'gaofushuai', '123456', '高副帅', '7', '2020-01-01 11:03:40', '2020-01-01 14:15:55', '1');
INSERT INTO `sys_user` VALUES ('10010', 'zy', '123456', 'zzzyyyy250', '1', '2020-01-01 13:13:58', '2020-01-01 13:22:27', '1');
INSERT INTO `sys_user` VALUES ('10011', 'wt', '123456', 'wmm', '8', '2020-01-01 14:10:38', '2020-01-01 14:10:56', '1');
