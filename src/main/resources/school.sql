/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : school

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 14/09/2023 22:24:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uID` int(0) NOT NULL AUTO_INCREMENT,
  `uSex` enum('male','female') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uPwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uMail` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uType` int(0) NOT NULL,
  PRIMARY KEY (`uID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (333, 'female', '333', '333', 1);
INSERT INTO `user` VALUES (444, 'male', '3344', '2244', 2);
INSERT INTO `user` VALUES (445, 'male', '3344', '2244', 2);
INSERT INTO `user` VALUES (446, 'male', '3344', '2244', 2);
INSERT INTO `user` VALUES (448, 'male', '3344', '2244', 2);

SET FOREIGN_KEY_CHECKS = 1;
