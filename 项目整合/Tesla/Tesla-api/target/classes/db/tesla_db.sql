/*
 Navicat Premium Data Transfer

 Source Server         : shop
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : tesla_db

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 27/04/2022 09:24:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tesla_activity
-- ----------------------------
DROP TABLE IF EXISTS `tesla_activity`;
CREATE TABLE `tesla_activity`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activity_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activity_subtitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activity_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activity_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tesla_activity
-- ----------------------------
INSERT INTO `tesla_activity` VALUES ('485d2738am56213124', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgqomkoWqBYQwEghy7e6GE75N6g4SkNKR68Q&usqp=CAU', 'S3XY TREAUSRE北京| 打卡京城「特」级充电站打卡赢取惊喜好礼', '欢迎您参加我们每周车主活动，给您带来不一样的特斯拉之旅', '11月1日 10:00', '11月30日 18:00', 'signing-up', '北京 · 北京特斯拉超充');
INSERT INTO `tesla_activity` VALUES ('50264178a123d51515', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlG5BqDhXTR4bRZc3qZK8o_o4io_muoX0rYA&usqp=CAU', 'T-LIFE北京|开启智能「特」别车主生活', '欢迎您参加我们每周车主活动，给您带来不一样的特斯拉之旅', '11月1日 10:00', '11月30日 18:00', 'signing-end', '北京 · 北京蟹岛特斯拉中心');

-- ----------------------------
-- Table structure for tesla_car
-- ----------------------------
DROP TABLE IF EXISTS `tesla_car`;
CREATE TABLE `tesla_car`  (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `car_imgurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `car_endurance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `car_accelerate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `car_maxspeed` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`car_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tesla_car
-- ----------------------------
INSERT INTO `tesla_car` VALUES (1, 'Model s', 'https://img.pcauto.com.cn/images/upload/upc/tx/auto5/2101/28/c18/251684897_1611842075144_1024.jpg', '637', '2.1s', '322Km/h');
INSERT INTO `tesla_car` VALUES (2, 'Model x', 'https://img.pcauto.com.cn/images/upload/upc/tx/auto5/2101/29/c20/251777147_1611903863686_1024.jpg', '537', '3.1s', '122Km/h');
INSERT INTO `tesla_car` VALUES (3, 'Model y', 'https://img.pcauto.com.cn/images/upload/upc/tx/auto5/1903/15/c9/137551085_1552635462985_1024.jpg', '437', '1.1s', '222Km/h');
INSERT INTO `tesla_car` VALUES (4, 'Model v', 'https://img.pcauto.com.cn/images/upload/upc/tx/auto5/1711/20/c25/67259504_1511160424168_1024.jpg', '356', '1.9s', '218Km/h');
INSERT INTO `tesla_car` VALUES (5, 'Model v', 'https://img.pcauto.com.cn/images/upload/upc/tx/auto5/1711/20/c25/67259504_1511160424168_1024.jpg', '356', '1.9s', '218Km/h');
INSERT INTO `tesla_car` VALUES (6, 'Model w', 'https://img.pcauto.com.cn/images/upload/upc/tx/auto5/1711/20/c25/67259504_1511160424168_1024.jpg', '356', '1.9s', '218Km/h');
INSERT INTO `tesla_car` VALUES (7, 'Model z', 'https://img.pcauto.com.cn/images/upload/upc/tx/auto5/1711/20/c25/67259504_1511160424168_1024.jpg', '356', '1.9s', '218Km/h');
INSERT INTO `tesla_car` VALUES (8, 'Model d', 'https://img.pcauto.com.cn/images/upload/upc/tx/auto5/1711/20/c25/67259504_1511160424168_1024.jpg', '356', '1.9s', '218Km/h');
INSERT INTO `tesla_car` VALUES (14, '123213', '133123', '12312', '31231', '313121');

SET FOREIGN_KEY_CHECKS = 1;
