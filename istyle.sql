/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50549
 Source Host           : localhost:3306
 Source Schema         : istyle

 Target Server Type    : MySQL
 Target Server Version : 50549
 File Encoding         : 65001

 Date: 16/03/2020 09:05:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `tb_evaluation`;
CREATE TABLE `tb_evaluation`  (
  `evalId` bigint(20) NOT NULL AUTO_INCREMENT,
  `evalPhoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `evalName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `evalWord` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`evalId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_evaluation
-- ----------------------------
INSERT INTO `tb_evaluation` VALUES (1, 'img/salaonpho1.jpg', '太棒了！', '这家理发店剪得真好看，好评！！下次还来');
INSERT INTO `tb_evaluation` VALUES (2, 'img/salonpho3.jpg', '好评！！', '这家的1号好帅啊,wysl');

-- ----------------------------
-- Table structure for tb_styhouse
-- ----------------------------
DROP TABLE IF EXISTS `tb_styhouse`;
CREATE TABLE `tb_styhouse`  (
  `styHouseId` bigint(20) NOT NULL AUTO_INCREMENT,
  `styHouseName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `styHouseWord` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `styHousePhoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `styHousePosition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `styHouseAccount` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'zhang hao',
  `styHousePassword` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'mi ma',
  `headName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'fuzeren xingming',
  `headId` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'fuzeren shenfenzheng',
  `headPhone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'fuzeren shouji',
  `styHouseStatus` int(11) NOT NULL COMMENT '0为正常，1为注销',
  `styHouseAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `styHousePackage` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '优惠套餐',
  `styHousePhone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业电话',
  `styHouseWorkTime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业时间',
  PRIMARY KEY (`styHouseId`) USING BTREE,
  INDEX `styHouseId`(`styHouseId`) USING BTREE,
  INDEX `styHouseId_2`(`styHouseId`) USING BTREE,
  INDEX `styHouseId_3`(`styHouseId`) USING BTREE,
  INDEX `styHouseId_4`(`styHouseId`) USING BTREE,
  INDEX `styHouseId_5`(`styHouseId`) USING BTREE,
  INDEX `styHouseId_6`(`styHouseId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_styhouse
-- ----------------------------
INSERT INTO `tb_styhouse` VALUES (1, '马庄洗剪吹e', 'styHouse01', 'img/fadian01.jpg', '上海市辖区黄浦区', '111111', '111111', '敏梓', '44148888888888888', '110', 0, '马庄146号', '洗剪吹 | 质感烫', '120', '7：00 - 19：00');
INSERT INTO `tb_styhouse` VALUES (2, '青苹果', 'styHouse02', 'img/salonpho3.jpg', '上海市辖区黄浦区', '222222', '222222', '文伟', '4414000000000000', '111', 0, '河南岸街道', '单剪 | 洗剪吹 | 染烫', '110', '7：00 - 19：00');
INSERT INTO `tb_styhouse` VALUES (3, 'styhouse01', NULL, NULL, 'styhouse01', 'styhouse01', 'styhouse01', 'styhouse01', 'styhouse01', 'styhouse01', 0, NULL, NULL, NULL, NULL);
INSERT INTO `tb_styhouse` VALUES (4, '花之发型屋', 'styHose03', 'img/9.jpg', '上海市辖区黄浦区', '15217847448', '111111', '接口', '441402199808281061', '15217847448', 0, '华茂', '劲爽控油护油 | 经典草本防脱', '111', '7：00 - 19：00');
INSERT INTO `tb_styhouse` VALUES (5, '#{styHouseName}', NULL, NULL, '#{styHousePosition}', '#{styHouseAt}', '#{stsword}', '#{headName}', '#{headId}', '#{heone}', 0, NULL, NULL, NULL, NULL);
INSERT INTO `tb_styhouse` VALUES (6, '恢复的', NULL, NULL, '广东广州市天河区', '15217847449', '111111', '杰哥', '441402199808281061', '15217847449', 0, '新天地', '技术风格裁剪 | 单人染烫', '112', '7：00 - 19：00');
INSERT INTO `tb_styhouse` VALUES (7, 'SALON 潮牌造型', 'styHouse07', 'img/salonpho2.jpg', '上海市辖区黄浦区', '15217821901', '111111', '111', '441421199809065555', '15217774444', 0, '新天地', '技术风格裁剪 | 单人染烫', '112', '7：00 - 19：00');

-- ----------------------------
-- Table structure for tb_styhouse_package
-- ----------------------------
DROP TABLE IF EXISTS `tb_styhouse_package`;
CREATE TABLE `tb_styhouse_package`  (
  `packageId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '该表id',
  `styHouseId` bigint(20) NOT NULL COMMENT '造型屋id',
  `packagePhoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐图片',
  `packageName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐名称',
  `packagePrice` double(9, 0) NULL DEFAULT NULL COMMENT '套餐价格',
  `packageDescription` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '套餐描述',
  `status` int(1) NOT NULL DEFAULT 1 COMMENT '状态，status=1，正常；status=0，无效。',
  PRIMARY KEY (`packageId`, `styHouseId`) USING BTREE,
  INDEX `styHouseId-packageId`(`styHouseId`) USING BTREE,
  CONSTRAINT `styHouseId-packageId` FOREIGN KEY (`styHouseId`) REFERENCES `tb_styhouse` (`styHouseId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_styhouse_package
-- ----------------------------
INSERT INTO `tb_styhouse_package` VALUES (1, 1, 'img/package01.jpg', '洗剪吹', 39, '单套洗剪吹，学生有优惠', 0);
INSERT INTO `tb_styhouse_package` VALUES (2, 1, 'img/package01.jpg', '质感烫', 258, '用最好的技术烫出最美的发型', 0);
INSERT INTO `tb_styhouse_package` VALUES (3, 1, 'img/package01.jpg2', '洗剪吹2额test', 39, '单套洗剪吹，学生有优2惠', 0);
INSERT INTO `tb_styhouse_package` VALUES (4, 1, NULL, '222', 33, '333', 1);
INSERT INTO `tb_styhouse_package` VALUES (5, 1, NULL, '单剪', 15, '国庆特价', 1);
INSERT INTO `tb_styhouse_package` VALUES (6, 1, NULL, '单剪', 15, '国庆特价', 0);

-- ----------------------------
-- Table structure for tb_styhouse_stylist
-- ----------------------------
DROP TABLE IF EXISTS `tb_styhouse_stylist`;
CREATE TABLE `tb_styhouse_stylist`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stylistId` bigint(20) NOT NULL,
  `styHouseId` bigint(20) NOT NULL,
  `stylistPhoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '造型师在造型屋展示的图片',
  `stylistName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '造型师在造型屋展示的名字',
  `stylistIntroduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '造型师在造型屋展示的简介',
  `maxNumber` int(11) NULL DEFAULT NULL COMMENT '造型师在造型屋最大可预约人数',
  `reservationTime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '造型师在造型屋可预约时间',
  `status` int(1) NOT NULL DEFAULT 1 COMMENT '状态，1为正常，0为无效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id-stylistId`(`stylistId`) USING BTREE,
  CONSTRAINT `id-stylistId` FOREIGN KEY (`stylistId`) REFERENCES `tb_stylist` (`stylistid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_styhouse_stylist
-- ----------------------------
INSERT INTO `tb_styhouse_stylist` VALUES (1, 1, 1, '1', 'kan\'kan', NULL, 5, 'test', 0);
INSERT INTO `tb_styhouse_stylist` VALUES (2, 2, 1, '2', '', NULL, NULL, NULL, 0);
INSERT INTO `tb_styhouse_stylist` VALUES (3, 3, 1, '3', '', NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for tb_stylist
-- ----------------------------
DROP TABLE IF EXISTS `tb_stylist`;
CREATE TABLE `tb_stylist`  (
  `stylistId` bigint(20) NOT NULL AUTO_INCREMENT,
  `stylistName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stylistPhoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stylistWord` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `realName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stylistPassword` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stylistSex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stylistAge` int(3) NULL DEFAULT NULL,
  `stylistPhone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stylistStatus` int(11) NOT NULL COMMENT '0为正常，1为注销',
  `stylistAdvisory` bigint(20) NOT NULL COMMENT '咨询数',
  `stylistIntroduction` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '个人简介',
  PRIMARY KEY (`stylistId`) USING BTREE,
  INDEX `stylistId`(`stylistId`) USING BTREE,
  INDEX `stylistId_2`(`stylistId`) USING BTREE,
  INDEX `stylistId_3`(`stylistId`) USING BTREE,
  INDEX `stylistId_4`(`stylistId`) USING BTREE,
  INDEX `stylistId_5`(`stylistId`) USING BTREE,
  INDEX `stylistId_6`(`stylistId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_stylist
-- ----------------------------
INSERT INTO `tb_stylist` VALUES (1, 'Tony', 'img/user1.jpg', '今天也要美美的~', '流行', '111111', '男', 24, '111111', 0, 0, 'Tony是著名造型师，10月28日出生北京，是目前国内第一位来往国际间的著名形象设计师；中国第一位签约海外公司的形象设计师；中国第一位举办了时装设计展的造型师；中国历届模特大赛评委、总形象设计师。');
INSERT INTO `tb_stylist` VALUES (2, 'Lisa', 'img/user2.jpg', 'stylist02', '', '', NULL, NULL, '', 0, 0, NULL);
INSERT INTO `tb_stylist` VALUES (3, '方婷', 'img/4.jpg', NULL, 'hhh', '111111', '女', 18, '15217821901', 0, 0, NULL);
INSERT INTO `tb_stylist` VALUES (4, '李二', NULL, NULL, '李二', '123456', '男', 18, '13211111111', 0, 0, NULL);

-- ----------------------------
-- Table structure for tb_stylist_advisory
-- ----------------------------
DROP TABLE IF EXISTS `tb_stylist_advisory`;
CREATE TABLE `tb_stylist_advisory`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `stylistId` bigint(20) NOT NULL COMMENT '造型师id',
  `userId` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_submission
-- ----------------------------
DROP TABLE IF EXISTS `tb_submission`;
CREATE TABLE `tb_submission`  (
  `subId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NULL DEFAULT NULL,
  `subPhoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subTime` datetime NULL DEFAULT NULL,
  `subPageView` int(255) NULL DEFAULT NULL,
  `subComment` int(255) NULL DEFAULT NULL,
  `subCollection` int(255) NULL DEFAULT NULL,
  `subContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subStatus` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`subId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_submission
-- ----------------------------
INSERT INTO `tb_submission` VALUES (1, 1, '', '问题', '2019-10-29 12:42:57', NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userPassword` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userPhone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userSex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userAge` int(11) NULL DEFAULT NULL,
  `userWord` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `userPhoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usersState` int(11) NOT NULL COMMENT '0正常，1注销',
  PRIMARY KEY (`userId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `userId_2`(`userId`) USING BTREE,
  INDEX `userId_3`(`userId`) USING BTREE,
  INDEX `userId_4`(`userId`) USING BTREE,
  INDEX `userId_5`(`userId`) USING BTREE,
  INDEX `userId_6`(`userId`) USING BTREE,
  INDEX `userId_7`(`userId`) USING BTREE,
  INDEX `userId_8`(`userId`) USING BTREE,
  INDEX `userId_9`(`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, '张敏梓', '111111', '111111', '男', 11, '我是最胖的~', 'img/headphoto.png', 0);
INSERT INTO `tb_user` VALUES (2, '黄文伟', '222222', '222222', '男', 20, '立志成为造型师的男人', 'img/headphoto.png', 0);
INSERT INTO `tb_user` VALUES (3, '林俊健', '333333', '333333', '男', 20, '青苹果造型屋3号技师', 'img/headphoto.png', 0);
INSERT INTO `tb_user` VALUES (4, '志超', '444444', '444444', '男', 20, NULL, 'img/headphoto.png', 0);
INSERT INTO `tb_user` VALUES (5, '王治平', '555555', '555555', '男', 20, '马庄洗剪吹造型屋总监', 'img/headphoto.png', 0);
INSERT INTO `tb_user` VALUES (6, '987654', '987654', '987654', '4', 4, NULL, 'img/headphoto.png', 0);
INSERT INTO `tb_user` VALUES (7, '1', '1', '1', '1', 1, NULL, 'img/headphoto.png', 0);
INSERT INTO `tb_user` VALUES (8, '110110', '110110', '110110', '1', 1, NULL, 'img/headphoto.png', 0);
INSERT INTO `tb_user` VALUES (9, '112112', '112112', '112112', '1', 1, NULL, 'img/headphoto.png', 0);
INSERT INTO `tb_user` VALUES (11, '张敏梓', '111111', '15217821901', '女', 18, NULL, 'img/headphoto.png', 0);
INSERT INTO `tb_user` VALUES (12, '李二', '123456', '13222222222', '女', 18, NULL, 'img/headphoto.png', 0);

-- ----------------------------
-- Table structure for tb_user_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_evaluation`;
CREATE TABLE `tb_user_evaluation`  (
  `userId` bigint(20) NOT NULL,
  `evalId` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`, `evalId`) USING BTREE,
  INDEX `evalId-user`(`evalId`) USING BTREE,
  CONSTRAINT `evalId-user` FOREIGN KEY (`evalId`) REFERENCES `tb_evaluation` (`evalId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userId-eval` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user_evaluation
-- ----------------------------
INSERT INTO `tb_user_evaluation` VALUES (1, 1);
INSERT INTO `tb_user_evaluation` VALUES (1, 2);

-- ----------------------------
-- Table structure for tb_user_styhouse
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_styhouse`;
CREATE TABLE `tb_user_styhouse`  (
  `userId` bigint(20) NOT NULL,
  `styHouseId` bigint(20) NOT NULL,
  `status` int(11) NOT NULL COMMENT '0关注，1未关注',
  PRIMARY KEY (`userId`, `styHouseId`) USING BTREE,
  INDEX `styHouseId-user`(`styHouseId`) USING BTREE,
  CONSTRAINT `styHouseId-user` FOREIGN KEY (`styHouseId`) REFERENCES `tb_styhouse` (`styHouseId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userId-styHouse` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user_styhouse
-- ----------------------------
INSERT INTO `tb_user_styhouse` VALUES (1, 1, 0);
INSERT INTO `tb_user_styhouse` VALUES (1, 2, 0);

-- ----------------------------
-- Table structure for tb_user_stylist
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_stylist`;
CREATE TABLE `tb_user_stylist`  (
  `userId` bigint(20) NOT NULL,
  `stylistId` bigint(20) NOT NULL,
  `status` int(11) NOT NULL COMMENT '0关注，1未关注',
  PRIMARY KEY (`userId`, `stylistId`) USING BTREE,
  INDEX `stylistId-user`(`stylistId`) USING BTREE,
  CONSTRAINT `stylistId-user` FOREIGN KEY (`stylistId`) REFERENCES `tb_stylist` (`stylistId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userId-stylist` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user_stylist
-- ----------------------------
INSERT INTO `tb_user_stylist` VALUES (1, 1, 0);
INSERT INTO `tb_user_stylist` VALUES (1, 2, 0);
INSERT INTO `tb_user_stylist` VALUES (1, 3, 0);
INSERT INTO `tb_user_stylist` VALUES (2, 1, 0);
INSERT INTO `tb_user_stylist` VALUES (2, 2, 0);

-- ----------------------------
-- Table structure for tb_user_stylist_advisory
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_stylist_advisory`;
CREATE TABLE `tb_user_stylist_advisory`  (
  `advisoryId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` bigint(20) NOT NULL COMMENT '用户id',
  `stylistId` bigint(20) NOT NULL COMMENT '造型师id',
  `advisoryPhoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片位置',
  `advisoryHeight` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身高',
  `advisoryWeight` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '体重',
  `advisoryStyle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '穿衣风格',
  `advisoryDescription` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `putTime` datetime NULL DEFAULT NULL COMMENT '发表时间',
  `isReply` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否回复',
  `replyMessage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复内容',
  `replyTime` datetime NULL DEFAULT NULL COMMENT '回复时间',
  `replyPhoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复照片',
  `styHouseURL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '造型屋链接',
  PRIMARY KEY (`advisoryId`, `userId`, `stylistId`) USING BTREE,
  INDEX `advisory-user`(`userId`) USING BTREE,
  INDEX `advisory-stylist`(`stylistId`) USING BTREE,
  CONSTRAINT `advisory-stylist` FOREIGN KEY (`stylistId`) REFERENCES `tb_stylist` (`stylistId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `advisory-user` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user_stylist_advisory
-- ----------------------------
INSERT INTO `tb_user_stylist_advisory` VALUES (1, 1, 1, 'img/user1.jpg', '160', '66', '简约', '微胖', '2019-09-30 00:02:24', '1', '你好', '2019-10-16 15:54:45', 'img/user1.jpg', NULL);
INSERT INTO `tb_user_stylist_advisory` VALUES (2, 1, 1, 'img/user1.jpg', '160', '50', '潮流', '廋', '2019-09-30 00:09:08', '1', '漂亮', '2019-11-20 16:16:53', 'img/user1.jpg', NULL);
INSERT INTO `tb_user_stylist_advisory` VALUES (3, 1, 1, 'img/user1.jpg', '160', '66', '简约', '微胖', '2019-09-30 00:21:46', '0', NULL, NULL, NULL, NULL);
INSERT INTO `tb_user_stylist_advisory` VALUES (4, 1, 1, 'img/user1.jpg', '11', '11', '1', '1', '2019-10-03 14:24:01', '1', '热特一天可以', '2019-10-03 22:18:19', 'img/reply/44537d35-8ca0-42bc-8e66-0b320774050c.jpeg', 'http://');

-- ----------------------------
-- Table structure for tb_user_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_user`;
CREATE TABLE `tb_user_user`  (
  `userId` bigint(20) NOT NULL,
  `userId2` bigint(20) NOT NULL,
  `usersState` int(1) NOT NULL COMMENT '0正常，1注销',
  PRIMARY KEY (`userId`, `userId2`) USING BTREE,
  INDEX `userId2-user`(`userId2`) USING BTREE,
  CONSTRAINT `userId-user` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userId2-user` FOREIGN KEY (`userId2`) REFERENCES `tb_user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user_user
-- ----------------------------
INSERT INTO `tb_user_user` VALUES (1, 2, 0);
INSERT INTO `tb_user_user` VALUES (1, 3, 0);
INSERT INTO `tb_user_user` VALUES (1, 4, 1);
INSERT INTO `tb_user_user` VALUES (1, 5, 1);
INSERT INTO `tb_user_user` VALUES (2, 1, 0);
INSERT INTO `tb_user_user` VALUES (2, 4, 1);
INSERT INTO `tb_user_user` VALUES (3, 1, 0);
INSERT INTO `tb_user_user` VALUES (4, 1, 1);
INSERT INTO `tb_user_user` VALUES (5, 1, 0);

-- ----------------------------
-- Table structure for user_consult
-- ----------------------------
DROP TABLE IF EXISTS `user_consult`;
CREATE TABLE `user_consult`  (
  `consult_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '咨询id',
  `userId` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `height` double NULL DEFAULT NULL COMMENT '用户身高',
  `weight` double NULL DEFAULT NULL COMMENT '用户体重',
  `userphoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户照片',
  `dressing_style` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户穿衣风格',
  `problem_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题描述',
  `stylistId` bigint(20) NULL DEFAULT NULL COMMENT '造型师ID',
  `time` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `is_return` int(255) NULL DEFAULT NULL COMMENT '是否回复',
  `return_context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复内容',
  `return_time` datetime NULL DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`consult_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
