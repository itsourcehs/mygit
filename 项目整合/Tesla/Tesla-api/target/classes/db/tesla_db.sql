/*
 Navicat Premium Data Transfer

 Source Server         : mysql_root_root
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : tesla_db

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 02/04/2022 16:57:02
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
  `car_config` json NULL,
  PRIMARY KEY (`car_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tesla_car
-- ----------------------------
INSERT INTO `tesla_car` VALUES (1, 'Model s', 'https://img-blog.csdnimg.cn/20201014180756922.png?x-oss-process=image/resize,m_fixed,h_64,w_64', '[{\"title\": \"637\", \"subtitle\": \"公里续航\"}, {\"title\": \"637\", \"subtitle\": \"公里续航\"}, {\"title\": \"637\", \"subtitle\": \"公里续航\"}]');
INSERT INTO `tesla_car` VALUES (2, 'Model x', 'https://img-blog.csdnimg.cn/20201014180756922.png?x-oss-process=image/resize,m_fixed,h_64,w_64', '[{\"title\": \"637\", \"subtitle\": \"公里续航\"}, {\"title\": \"637\", \"subtitle\": \"公里续航\"}, {\"title\": \"637\", \"subtitle\": \"公里续航\"}]');
INSERT INTO `tesla_car` VALUES (3, 'Model y', 'https://img-blog.csdnimg.cn/20201014180756922.png?x-oss-process=image/resize,m_fixed,h_64,w_64', '[{\"title\": \"637\", \"subtitle\": \"公里续航\"}, {\"title\": \"637\", \"subtitle\": \"公里续航\"}, {\"title\": \"637\", \"subtitle\": \"公里续航\"}]');

SET FOREIGN_KEY_CHECKS = 1;
