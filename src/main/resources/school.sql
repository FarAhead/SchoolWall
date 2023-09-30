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

 Date: 30/09/2023 22:28:06
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
  `alikecount` int UNSIGNED NOT NULL,
  `reported` int UNSIGNED NOT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES (1, 70, 921107820244, '今天拿了好多纪念品', '2023-09-21 13:33:11', 11, 0);
INSERT INTO `answer` VALUES (3, 70, 921107820244, '今天还看了晚会', '2023-09-21 13:33:11', 11, 0);
INSERT INTO `answer` VALUES (4, 72, 921107820244, '我刚抢到了一台，芜湖', '2023-09-21 13:33:11', 11, 0);
INSERT INTO `answer` VALUES (5, 72, 921107820244, '是真的非常流畅，麒麟9000S,真的是yyds', '2023-09-21 13:33:11', 11, 0);
INSERT INTO `answer` VALUES (6, 72, 921107820242, '尊嘟假嘟', '2023-09-30 09:23:05', 0, 0);
INSERT INTO `answer` VALUES (7, 73, 921107820244, '可惜我没抢到，呜呜呜！', '2023-09-30 09:31:01', 0, 0);
INSERT INTO `answer` VALUES (10, 77, 921107820242, '星苑1楼的香锅非常的nice！！！  不过每天要拍好长的队伍，呜呜呜呜', '2023-09-30 14:16:05', 0, 0);
INSERT INTO `answer` VALUES (11, 73, 921107810234, '我让我整个寝室的同学帮我抢，我的天，开始即结束了，真的栓Q', '2023-09-30 14:24:55', 0, 0);
INSERT INTO `answer` VALUES (12, 76, 921107810234, '玄武湖，夫子庙，鸡鸣寺哈哈，不过我选择躺在寝室，嘿嘿！！！', '2023-09-30 14:25:28', 0, 0);
INSERT INTO `answer` VALUES (13, 77, 921107820326, '我觉得名苑二楼的麻辣拌，以及星苑的鱼粉', '2023-09-30 14:27:48', 0, 0);
INSERT INTO `answer` VALUES (14, 76, 921107820326, '我回家啦，嘿嘿！！！', '2023-09-30 14:28:04', 0, 0);
INSERT INTO `answer` VALUES (15, 72, 921107820326, '加油华为！加油CHINA', '2023-09-30 14:28:22', 0, 0);
INSERT INTO `answer` VALUES (16, 1, 921107820326, '我参加马拉松啦，还拿到奖牌了', '2023-09-30 14:28:43', 0, 0);
INSERT INTO `answer` VALUES (17, 1, 921107811111, '学校七十周年能不能给分配个对象啊 嘤嘤嘤', '2023-09-30 14:30:24', 0, 0);
INSERT INTO `answer` VALUES (18, 73, 921107811111, '没事，抢不到，陪我去喝瑞幸吧', '2023-09-30 14:30:54', 0, 0);
INSERT INTO `answer` VALUES (19, 76, 921107811111, '当然是窝在寝室里看恋综，呜呜呜我的杨汝晴', '2023-09-30 14:31:45', 0, 0);
INSERT INTO `answer` VALUES (20, 77, 921107820244, '名苑一楼泡泡锅', '2023-09-30 22:15:49', 0, 0);

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`  (
  `cid` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `price` decimal(10, 2) UNSIGNED NOT NULL,
  `uid` bigint UNSIGNED NOT NULL,
  `cname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品描述',
  `ctime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `sold` int NOT NULL COMMENT '是否被购买',
  `cavatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ctype` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES (44, 20.00, 921107811111, '高等数学（上册）', '已经学完了，书99新，没有多余标记', '2023-09-30 22:19:52', 1, 'http://localhost:8088/src/main/resources/commodity/math.jpg', '1');
INSERT INTO `commodity` VALUES (45, 15.00, 921107811111, '衣架', '衣架多买了一些，想要出掉', '2023-09-30 17:11:24', 0, 'http://localhost:8088/src/main/resources/commodity/yijia.jpg', '1');
INSERT INTO `commodity` VALUES (46, 50.00, 921107820244, '水杯（400ml）', '抽奖送的一个运动水杯，便宜出', '2023-09-30 22:18:37', 1, 'http://localhost:8088/src/main/resources/commodity/bottle.jpg', '1');
INSERT INTO `commodity` VALUES (53, 399.00, 921107820244, 'z自行车', '二手闲置', '2023-09-30 22:19:17', 0, 'http://localhost:8088/src/main/resources/commodity/bike.jpg', '1');

-- ----------------------------
-- Table structure for lik
-- ----------------------------
DROP TABLE IF EXISTS `lik`;
CREATE TABLE `lik`  (
  `qid` int UNSIGNED NOT NULL,
  `uid` bigint UNSIGNED NOT NULL,
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '序号',
  `typ` int UNSIGNED NOT NULL COMMENT '关系的类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lik
-- ----------------------------
INSERT INTO `lik` VALUES (70, 921107820244, 12, 2);
INSERT INTO `lik` VALUES (70, 921107820242, 23, 1);
INSERT INTO `lik` VALUES (76, 921107820244, 28, 1);
INSERT INTO `lik` VALUES (72, 921107811111, 43, 1);
INSERT INTO `lik` VALUES (77, 921107811111, 49, 2);
INSERT INTO `lik` VALUES (73, 921107820244, 50, 1);
INSERT INTO `lik` VALUES (78, 921107820244, 51, 2);
INSERT INTO `lik` VALUES (77, 921107820244, 52, 2);
INSERT INTO `lik` VALUES (79, 921107820244, 53, 2);
INSERT INTO `lik` VALUES (78, 921107820244, 54, 2);

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
  `checked` int(10) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`nid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (12, 1001, '校团委基层工作大会', '校团委基层工作大会将于下周二在学术交流中心隆重开展！！！', '2023-09-30 14:39:40', 0, 0000000001);
INSERT INTO `notice` VALUES (13, 1002, '青协招新啦！', '青年志愿者协会各部门招新宣讲将于下周一开始，有意愿的同学请将申请表交到团委楼302', '2023-09-30 17:22:07', 0, 0000000001);
INSERT INTO `notice` VALUES (14, 1002, '杭州亚运会', '2023年4月25日起，为期三天的杭州亚运会代表团团长大会在杭州举行，亚洲45个国家和地区的奥委会代表参会 。 6月15日，杭州亚运会倒计时100天，亚运会火种在杭州良渚古城遗址公园大莫角山成功采集到 ；同日，杭州亚运会奖牌在“湖山”发布。6月29日，杭州亚运会第二次世界媒体大会成果发布在杭州国际博览中心召开。7月，杭州亚运会运动员报名圆满结束，亚奥理事会45个国家（地区）奥委会均已报名，运动员人数达到12500多名，报名规模创历届之最。', '2023-09-30 21:51:50', 0, 0000000001);
INSERT INTO `notice` VALUES (15, 1002, '演示', '演示专用', '2023-09-30 22:22:08', 0, 0000000001);

-- ----------------------------
-- Table structure for ord
-- ----------------------------
DROP TABLE IF EXISTS `ord`;
CREATE TABLE `ord`  (
  `oid` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `obid` bigint UNSIGNED NULL DEFAULT NULL,
  `osid` bigint UNSIGNED NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `cname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cavatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ofinishdate` datetime NULL DEFAULT NULL,
  `cid` int NOT NULL,
  `ocreatedate` datetime NOT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ord
-- ----------------------------
INSERT INTO `ord` VALUES (13, 921107820244, 921107811111, 20.00, '高等数学（上册）', '已经学完了，书99新，没有多余标记', '', '2023-09-30 22:19:52', 44, '2023-09-30 11:25:19');
INSERT INTO `ord` VALUES (14, 0, 921107811111, 15.00, '衣架', '衣架多买了一些，想要出掉', '', NULL, 45, '2023-09-30 11:25:30');
INSERT INTO `ord` VALUES (15, 921107820244, 921107820244, 50.00, '水杯（400ml）', '抽奖送的一个运动水杯，便宜出', '', '2023-09-30 22:18:37', 46, '2023-09-30 11:25:32');
INSERT INTO `ord` VALUES (22, 0, 921107820244, 399.00, 'z自行车', '二手闲置', '', '2023-09-30 22:19:18', 53, '2023-09-30 22:19:18');

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
  `zavatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `utype` int UNSIGNED NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('校团委', 1001, '罗翔', '15121732451', '000000', 'fumengyin@njust.edu.cn', 'http://localhost:8088/src/main/resources/organization/tuan.jpg', 1);
INSERT INTO `organization` VALUES ('校青协', 1002, '王一涵', '15786544214', '000000', 'wangyihan@njust.edu.cn', 'http://localhost:8088/src/main/resources/organization/青协.jpg', 1);
INSERT INTO `organization` VALUES ('西部计划', 1003, '徐辉', '12445784124', '000000', 'xuhui@njust.edu.cn', 'http://localhost:8088/src/main/resources/organization/b.png', 1);
INSERT INTO `organization` VALUES ('先锋频道', 1004, '黄辉', '14898547621', '000000', 'huanghui@njust.edu.cn', 'http://localhost:8088/src/main/resources/organization/b.png', 1);
INSERT INTO `organization` VALUES ('校科协', 1005, '刘翔', '15478246985', '000000', 'zhangxuefeng@njust.edu.cn', 'http://localhost:8088/src/main/resources/organization/b.png', 1);
INSERT INTO `organization` VALUES ('校红会', 1006, '王帆', '15478246985', '000000', 'zhangxuefeng@njust.edu.cn', 'http://localhost:8088/src/main/resources/organization/b.png', 1);
INSERT INTO `organization` VALUES ('中国联通', 1010, '张雪峰', '15478246985', '000000', 'zhangxuefeng@njust.edu.cn', 'http://localhost:8088/src/main/resources/organization/b.png', 1);

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
  `qcollectcount` int UNSIGNED NOT NULL,
  `qreported` int UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`qid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (72, 921107820242, '欢迎大家支持华为', '华为MATE60今日上新啦！！！欢迎南理工的同学加入华为大家庭，一起遥遥领先~', '2023-09-19 13:33:11', 189, 1, 4, 1, 0, 0);
INSERT INTO `question` VALUES (73, 921107820244, '林俊杰JJ20', '今晚开始抢票啦！！！', '2023-09-21 13:33:11', 238, 1, 3, 1, 2, 0);
INSERT INTO `question` VALUES (78, 921107811111, '南理麦当劳开了吗', '听说星苑二楼的麦当劳这几天开业，尊嘟假嘟', '2023-09-30 20:48:10', 61, 3, 0, 1, 1, 0);
INSERT INTO `question` VALUES (79, 921107820244, '杭州亚运会开幕咯', '2023年4月25日起，为期三天的杭州亚运会代表团团长大会在杭州举行，亚洲45个国家和地区的奥委会代表参会 。 6月15日，杭州亚运会倒计时100天，亚运会火种在杭州良渚古城遗址公园大莫角山成功采集到', '2023-09-30 21:50:57', 35, 0, 0, 1, 1, 0);

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
  `uavatar` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 921107822223 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (921107810234, '叶黎', 'male', '888888', '3547896412@qq.com', 2, 'http://localhost:8088/src/main/resources/head/tuzi.jpg');
INSERT INTO `user` VALUES (921107811111, '施朝兴', 'male', '1008611', 'shichaoxing@qq.com', 2, 'http://localhost:8088/src/main/resources/head/scx.jpg');
INSERT INTO `user` VALUES (921107820242, '余承东', 'male', '888888', 'yuchengdong@qq.com', 2, 'http://localhost:8088/src/main/resources/head/yuchengdong.jpg');
INSERT INTO `user` VALUES (921107820244, '郑宇唅', 'male', '000000', '3143334009@qq.com', 2, 'http://localhost:8088/src/main/resources/head/cxj.jpg');
INSERT INTO `user` VALUES (921107820326, '陈旭疆', 'male', '000000', '12385796344@qq.com', 2, 'http://localhost:8088/src/main/resources/head/cxj.jpg');
INSERT INTO `user` VALUES (921107822222, '小郑', 'male', '000000', 'zzzz.njuse.edu.cn', 2, NULL);

SET FOREIGN_KEY_CHECKS = 1;
