/*
 Navicat Premium Data Transfer

 Source Server         : hs_Demo
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : tesla_db

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 12/04/2022 14:39:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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

SET FOREIGN_KEY_CHECKS = 1;
