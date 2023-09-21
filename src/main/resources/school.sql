/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : db01

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 21/09/2023 20:59:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `aid` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `qid` int UNSIGNED NOT NULL,
  `uid` bigint UNSIGNED NOT NULL,
  `acontent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `atime` datetime NOT NULL,
  `alikecount` int(255) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of answer
-- ----------------------------

-- ----------------------------
-- Table structure for lik
-- ----------------------------
DROP TABLE IF EXISTS `lik`;
CREATE TABLE `lik`  (
  `qid` int UNSIGNED NOT NULL,
  `uid` bigint UNSIGNED NOT NULL,
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lik
-- ----------------------------
INSERT INTO `lik` VALUES (1, 921107820244, 1);
INSERT INTO `lik` VALUES (72, 921107820244, 2);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `nid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `ntitle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ncontent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ntime` datetime NOT NULL,
  `nbrowsecount` int UNSIGNED NOT NULL,
  PRIMARY KEY (`nid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, 1002, '瑞幸咖啡买一送一啦', '具体内容如下', '2023-09-01 13:21:12', 12);
INSERT INTO `notice` VALUES (6, 1002, '华为MATE60遥遥领先', '遥遥领先！！！', '2023-09-18 12:23:11', 1009);
INSERT INTO `notice` VALUES (7, 1002, '华为MATE60遥遥领先', '遥遥领先！！！', '2023-09-18 12:23:11', 888);
INSERT INTO `notice` VALUES (8, 1002, '中秋放假须知', '遥遥领先！！！', '2023-09-18 12:23:11', 8888);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `oid` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `obid` int UNSIGNED NULL DEFAULT NULL,
  `osid` int UNSIGNED NOT NULL,
  `oprice` decimal(10, 2) NOT NULL,
  `oname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `odescription` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `oimageurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ocreatedate` datetime NOT NULL,
  `ofinishdate` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
  `zname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '组织名称',
  `uid` int(4) UNSIGNED ZEROFILL NOT NULL COMMENT '组织代码',
  `zstudent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zphone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `upwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zmail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('校党委办公室', 1001, '付梦印', '15121732451', '666666', 'fumengyin@njust.edu.cn');
INSERT INTO `organization` VALUES ('校青协', 1002, '王一涵', '15786544214', '123456', 'wangyihan@njust.edu.cn');
INSERT INTO `organization` VALUES ('西部计划', 1003, '徐辉', '12445784124', '123456', 'xuhui@njust.edu.cn');
INSERT INTO `organization` VALUES ('先锋频道', 1004, '黄辉', '14898547621', '123456', 'huanghui@njust.edu.cn');
INSERT INTO `organization` VALUES ('校科协', 1005, '张雪峰', '15478246985', '000000', 'zhangxuefeng@njust.edu.cn');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `qid` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `uid` bigint UNSIGNED NOT NULL,
  `qtitle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `qcontent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `qtime` datetime NOT NULL,
  `qbrowsecount` int UNSIGNED NOT NULL,
  `qlikecount` int UNSIGNED NOT NULL,
  `qanswercount` int UNSIGNED NOT NULL,
  `qlabel` int UNSIGNED NOT NULL,
  PRIMARY KEY (`qid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 74 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (70, 921107820244, '南理工建校七十周年', '今天学校举办了好多活动，我好开心', '2023-09-19 13:23:11', 135, 23, 16, 1);
INSERT INTO `question` VALUES (72, 921107820244, '瑞幸咖啡买一送一', '酱香拿铁今日上新啦！！！', '2023-09-19 13:33:11', 5, 93, 18, 1);
INSERT INTO `question` VALUES (73, 921107820244, '林俊杰JJ20', '今晚开始抢票啦！！！', '2023-09-21 13:33:11', 234, 66, 18, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `usex` enum('male','female') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `upwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `umail` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `utype` int NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 921107820327 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (921107810232, '叶黎', 'male', '888888', '3547896412@qq.com', 2);
INSERT INTO `user` VALUES (921107820242, '余承东', 'male', '061600', 'yuchengdong@qq.com', 2);
INSERT INTO `user` VALUES (921107820244, '郑宇唅', 'male', '888888', '3143334009@qq.com', 2);
INSERT INTO `user` VALUES (921107820326, '陈旭疆', 'male', '123456', '12385796344@qq.com', 2);

SET FOREIGN_KEY_CHECKS = 1;
