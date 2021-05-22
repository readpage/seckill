/*
 Navicat MySQL Data Transfer

 Source Server         : navigate
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : seckill

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 22/05/2021 23:47:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `stock` int(0) NULL DEFAULT NULL COMMENT '商品库存',
  `store` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品店铺',
  `evaluate` int(0) NULL DEFAULT NULL COMMENT '商品评价',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品类型',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `verison` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (23, '分期免息/现货速发nubia/努比亚红魔6 Pro 5G电竞游戏手机官方旗舰店骁龙888透明s', '686947088.jpg', 4399.00, 1467, '\n壹品良机旗舰店\n', 461, '手机', '2021-04-28 19:16:57', '2021-05-16 15:52:25', 3);
INSERT INTO `goods` VALUES (24, '【新品享12期免息】ZTE中兴Axon 30 Pro 5G旗舰手机6400万双主摄骁龙888轻薄7.86mm智能5G手机', '2765414748.jpg', 2998.00, 1276, '\nZTE中兴官方旗舰店\n', 0, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (25, '【20日10点限时开售】MIX FOLD小米折叠屏手机5g骁龙888哈曼卡顿立体声四扬声器2K+折叠屏', '2616970884.jpg', 9999.00, 503, '\n苏宁易购官方旗舰店\n', 0, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (26, '【限时直降1050 至高享1000元换新补贴】Samsung/三星GalaxyS20+ SM-G9860 国行骁龙官方旗舰5G手机', '2616970884.jpg', 6999.00, 1726, '\n苏宁易购官方旗舰店\n', 446, '手机', '2021-04-28 19:16:57', '2021-05-09 13:07:04', 3);
INSERT INTO `goods` VALUES (27, '3期免息【送手环】HONOR/荣耀30青春版 5G手机柔滑全速屏超清智能游戏学生5g手机拍照自拍三际数码官方旗舰店', '268451883.jpg', 2399.00, 1999, '\n三际数码官方旗舰店\n', 7011, '手机', '2021-04-28 19:16:57', '2021-05-16 15:51:48', 3);
INSERT INTO `goods` VALUES (28, 'Apple/苹果手机iPhone 12 Pro Max 手机 国行全国联保', '8-0-lubanu.jpg', 9299.00, 1532, '\n天猫超市\n', 146, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (29, '【抢200天猫券低至2779起】Xiaomi/小米10 5G手机1亿像素8K电影相机游戏智能手机官方旗舰店小米手机10s', '3063905773.jpg', 3099.00, 548, '\n创汇通达数码旗舰店\n', 671, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (30, 'vivo iQOO Neo5新5G手机iqooneo5爱酷iqoonoe5 vivoiqoonoe5 iqqo vivoneo5官方旗舰iooq店iq00neo5 ipooneo5', '1864868535.jpg', 2999.00, 733, '\nvivo航鹰专卖店\n', 468, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (31, '【新品上市】OPPO Reno5 K opporeno5k手机5g新款手机上市opporeno5pro曲面屏限量版 oppo手机官方旗舰店官网', '2386434092.jpg', 2699.00, 1222, '\nOPPO普天精诚专卖店\n', 510, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (32, '【可省150元】OPPO K7x oppok7x手机5g新款oppok7x限量版全网通oppo官网旗舰店官0ppok7 oppo手机官方正品', '268451883.jpg', 1399.00, 511, '\n三际数码官方旗舰店\n', 3518, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (33, '顺丰包邮 Huawei/华为Nova 8 5g手机麒麟新品66W快充nova8直降9', '94-0-lubanu.jpg', 4149.00, 1930, '\n天猫超市\n', 193, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (34, '【整点赠耳机 晒单返20】vivo iQOO U1x畅销大电池学生老人智能手机官方旗舰店官网正品vivoiqooU1x vivou1x', '883737303.png', 999.00, 1494, '\nvivo官方旗舰店\n', 2504, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (35, '当天发货【下单立减50元】红米Redmi Note9 Pro手机官网手机官方旗舰店Xiaomi/小米红米note9pro系列5G新品', '2211163110445.jpg', 1599.00, 1277, '\n平天数码专营店\n', 19, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (36, '分期免息/现货速发nubia/努比亚红魔6 Pro 5G电竞游戏手机官方旗舰店骁龙888透明s', '686947088.jpg', 4399.00, 1246, '\n壹品良机旗舰店\n', 46, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (37, '直降200+现货速发+送原装配件】nubia/努比亚红魔6游戏手机165hz骁龙888腾讯红魔6pro电竞5S代官方旗舰红魔5G', '2200586761792.jpg', 5367.00, 970, '\n信通志远数码专营店\n', 381, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (38, '【24期免息 可减500元】Huawei/华为P40 5G手机P40Pro官方旗舰店麒麟芯片徕卡摄影智能手机P40 Pro+新品直降', '2615238525.jpg', 6968.00, 1701, '\n华为莫问专卖店\n', 210, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (39, '【立省300元】蜜茶手机Apple/苹果 iPhoneXR 全网通 全新国行 iPhonexr手机 iphonexr 苹果xr iphone xr', '2124156138.jpg', 4299.00, 1654, '\n搜酷数码专营店\n', 967, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (40, 'vivo iQOO neo5 5g手机 iqooneo5 iqoonoe5 vivoneo5 ipooneo5 iq00neo5 爱酷neo5 neo7 pro vivo官方旗舰店', '263726286.jpg', 2699.00, 1170, '\n能良数码官方旗舰店\n', 79, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (41, '【立减1100元】OPPO Ace2 oppoace2新款5g手机 oppo手机官方旗舰店 游戏手机 oppoace限量版 全网通', '297810316.jpg', 3499.00, 1353, '\n骏灿数码专营店\n', 109, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (42, '【当天发 24期分期】Huawei/华为P40 Pro 5G手机 官方旗舰店P40 Pro+麒麟芯片 摄像官网正品直降P50', '2615238525.jpg', 5188.00, 560, '\n华为莫问专卖店\n', 454, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (43, '【低至2679起/领300优惠】 一加OnePlus 8T 5G手机 正品官方旗舰店1加8t官网一加8pro赛博朋克直降新款1+8t', '1710936647.jpg', 3289.00, 839, '\n佰分购旗舰店\n', 22, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (44, '【咨询领券立减】OPPO K7x oppok7x手机5g全网通新品能良中国移动官旗oppo手机官方旗舰店oppo官网旗舰店官5g', '1776456424.jpg', 1499.00, 1504, '\n中国移动官方旗舰店\n', 79, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (45, '到手4469起 12期分期顺丰现货速发苹果iPhone 11 全网通4G手机官方旗舰原装正品苹果11/12Pro 2020新版简装', '1115488308.jpg', 4499.00, 1739, '\n君问数码官方旗舰店\n', 452, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (46, '当天速发 Huawei/华为 畅享8 Plus 全面屏正品手机 全网通4G手机 全网通4G手机', '682299517.jpg', 759.00, 1081, '\n旭翼数码专营店\n', 83, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (47, '【新品上市】HUAWEI/华为nova 8 Pro麒麟曲面屏华为手机5g手机智能手机华为官方旗舰店nova8pro', '2838892713.jpg', 3999.00, 1144, '\n华为官方旗舰店\n', 9489, '手机', '2021-04-28 19:16:57', NULL, 1);
INSERT INTO `goods` VALUES (58, 'da', NULL, 123.00, NULL, 'ada', 123, NULL, '2021-05-16 16:07:06', '2021-05-16 16:28:30', 2);
INSERT INTO `goods` VALUES (59, 'a', NULL, 123.00, 123, NULL, NULL, NULL, '2021-05-22 22:35:00', NULL, 1);
INSERT INTO `goods` VALUES (60, 'b', NULL, 234.00, 233, NULL, NULL, NULL, '2021-05-22 22:35:14', NULL, 1);

-- ----------------------------
-- Table structure for goods_seckill
-- ----------------------------
DROP TABLE IF EXISTS `goods_seckill`;
CREATE TABLE `goods_seckill`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '秒杀商品id',
  `gid` int(0) NULL DEFAULT NULL COMMENT '商品gid',
  `seckill_price` double NULL DEFAULT 0 COMMENT '秒杀价',
  `stock_count` int(0) NULL DEFAULT NULL COMMENT '库存数量',
  `start_date` datetime(0) NULL DEFAULT NULL COMMENT '秒杀开始时间',
  `end_date` datetime(0) NULL DEFAULT NULL COMMENT '秒杀结束时间',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `gid`(`gid`) USING BTREE,
  CONSTRAINT `goods_seckill_ibfk_1` FOREIGN KEY (`gid`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_seckill
-- ----------------------------
INSERT INTO `goods_seckill` VALUES (70, 59, 0, NULL, NULL, NULL, '2021-05-22 22:35:27', NULL, 1);
INSERT INTO `goods_seckill` VALUES (71, 60, 0, NULL, NULL, NULL, '2021-05-22 22:35:30', NULL, 1);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `pattern` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url地址',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `pattern`(`pattern`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '/**', '2021-04-28 19:25:24', NULL, 1);
INSERT INTO `menu` VALUES (2, '/admin/**', '2021-04-28 19:25:24', NULL, 1);
INSERT INTO `menu` VALUES (3, '/user/**', '2021-04-28 19:25:24', NULL, 1);

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `mid` int(0) NULL DEFAULT NULL COMMENT '菜单ID',
  `rid` int(0) NULL DEFAULT NULL COMMENT '角色ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  CONSTRAINT `menu_role_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `menu_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES (1, 1, 1, '2021-04-28 19:28:00', NULL, 1);
INSERT INTO `menu_role` VALUES (2, 2, 1, '2021-04-28 19:28:00', NULL, 1);
INSERT INTO `menu_role` VALUES (3, 3, 1, '2021-04-28 19:28:00', NULL, 1);
INSERT INTO `menu_role` VALUES (4, 2, 2, '2021-04-28 19:28:00', NULL, 1);
INSERT INTO `menu_role` VALUES (5, 3, 2, '2021-04-28 19:28:00', NULL, 1);
INSERT INTO `menu_role` VALUES (6, 3, 3, '2021-04-28 19:28:00', NULL, 1);
INSERT INTO `menu_role` VALUES (14, 1, 4, '2021-05-16 18:42:01', NULL, 1);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `number` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `uid` bigint(0) NULL DEFAULT NULL COMMENT '用户ID',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int(0) NULL DEFAULT 0 COMMENT '订单状态',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (43, '16529dee70034ba29e365d0397c83102', 2, '2021-05-22 15:10:18', 0, NULL, 1);
INSERT INTO `orders` VALUES (44, '0b2b820669754efa9b7d20e294a4ed04', 3, '2021-05-22 15:10:42', 0, NULL, 1);
INSERT INTO `orders` VALUES (45, '2eef7779370141099241ae2fccb36295', 2, '2021-05-22 15:11:13', 0, NULL, 1);
INSERT INTO `orders` VALUES (46, '741260618ab3493d8cb813badcc90740', 1, '2021-05-22 17:22:18', 0, NULL, 1);

-- ----------------------------
-- Table structure for orders_goods
-- ----------------------------
DROP TABLE IF EXISTS `orders_goods`;
CREATE TABLE `orders_goods`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `oid` bigint(0) NULL DEFAULT NULL COMMENT '订单id',
  `gid` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `count` int(0) NULL DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `oid`(`oid`) USING BTREE,
  INDEX `gid`(`gid`) USING BTREE,
  CONSTRAINT `orders_goods_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `orders` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orders_goods_ibfk_2` FOREIGN KEY (`gid`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders_goods
-- ----------------------------
INSERT INTO `orders_goods` VALUES (43, 43, 29, 1);
INSERT INTO `orders_goods` VALUES (44, 43, 30, 3);
INSERT INTO `orders_goods` VALUES (45, 44, 31, 1);
INSERT INTO `orders_goods` VALUES (46, 44, 32, 1);
INSERT INTO `orders_goods` VALUES (47, 45, 40, 1);
INSERT INTO `orders_goods` VALUES (48, 45, 34, 1);
INSERT INTO `orders_goods` VALUES (49, 45, 23, 1);
INSERT INTO `orders_goods` VALUES (50, 46, 38, 4);

-- ----------------------------
-- Table structure for orders_seckill
-- ----------------------------
DROP TABLE IF EXISTS `orders_seckill`;
CREATE TABLE `orders_seckill`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `gsId` int(0) NULL DEFAULT NULL COMMENT '抢购id',
  `oid` bigint(0) NULL DEFAULT NULL COMMENT '订单id',
  `count` int(0) NULL DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `gsId`(`gsId`) USING BTREE,
  INDEX `oid`(`oid`) USING BTREE,
  CONSTRAINT `orders_seckill_ibfk_1` FOREIGN KEY (`gsId`) REFERENCES `goods_seckill` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orders_seckill_ibfk_2` FOREIGN KEY (`oid`) REFERENCES `orders` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders_seckill
-- ----------------------------
INSERT INTO `orders_seckill` VALUES (6, 70, NULL, NULL);
INSERT INTO `orders_seckill` VALUES (7, 71, NULL, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'dba', '2021-04-28 19:32:40', NULL, 1);
INSERT INTO `role` VALUES (2, 'admin', '2021-04-28 19:32:40', NULL, 1);
INSERT INTO `role` VALUES (3, 'user', '2021-04-28 19:32:40', NULL, 1);
INSERT INTO `role` VALUES (4, ' tourist', '2021-04-29 18:54:53', NULL, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'root', '$2a$10$9U4qvQ.PVwY8teJZcmx3teErLgF9lc2o9IMUhA5dJYbpF..Grqph.', NULL, NULL, '2021-04-28 19:34:34', '2021-05-16 15:47:46', 4);
INSERT INTO `user` VALUES (2, 'admin', '$2a$10$xLbctedxEk/D3cv11LzFjOMRaBLk25SrWIidTETr1aa.Ho.0RZTba', NULL, NULL, '2021-04-28 19:34:34', '2021-05-04 16:08:32', 2);
INSERT INTO `user` VALUES (3, 'user', '$2a$10$gG2uw7LB0OTyyDNrg9fnquJCe9QYtuOZ/Yj973sr6dGusLMjfSKJe', NULL, NULL, '2021-04-28 19:34:34', '2021-05-04 16:40:52', 2);
INSERT INTO `user` VALUES (62, 'ff', '$2a$10$fGsC.gTi318XXvxWR1xsseTe6.cqY7KLg2teuF3Bo1ks5qQHhySNy', NULL, NULL, '2021-05-14 18:07:51', '2021-05-16 13:47:30', 1);
INSERT INTO `user` VALUES (66, 'ac', '$2a$10$3bckg4c.7qujliEExdn9sO26SoWL0wWwedOb3BSfR4YjDh3xXBekK', NULL, NULL, '2021-05-16 15:05:08', '2021-05-16 15:34:50', 4);
INSERT INTO `user` VALUES (74, '李明', '$2a$10$yx98JM9dUSgy0xiAL5rsEuRKOe2RCC8L3wq.Pc7aKK0eW6sSn0Ehq', '12345', NULL, '2021-05-17 09:26:23', '2021-05-17 09:26:23', 1);
INSERT INTO `user` VALUES (75, 'fff', '$2a$10$v/xlrup91X2/nR10f.0uiOqF2MBDE5avgzgM0pmQITYk4vq0zBlm.', NULL, NULL, '2021-05-18 13:29:26', '2021-05-18 13:29:26', 1);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uid` bigint(0) NOT NULL COMMENT '用户ID',
  `rid` int(0) NULL DEFAULT 3 COMMENT '角色ID',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1, NULL, '2021-04-28 19:36:33', 1);
INSERT INTO `user_role` VALUES (2, 1, 2, NULL, '2021-04-28 19:36:33', 1);
INSERT INTO `user_role` VALUES (3, 1, 3, NULL, '2021-04-28 19:36:33', 1);
INSERT INTO `user_role` VALUES (4, 2, 2, NULL, '2021-04-28 19:36:33', 1);
INSERT INTO `user_role` VALUES (5, 2, 3, NULL, '2021-04-28 19:36:33', 1);
INSERT INTO `user_role` VALUES (6, 3, 3, NULL, '2021-04-28 19:36:33', 1);
INSERT INTO `user_role` VALUES (18, 62, 3, NULL, '2021-05-14 18:07:50', 1);
INSERT INTO `user_role` VALUES (19, 66, 3, NULL, '2021-05-16 15:05:08', 1);
INSERT INTO `user_role` VALUES (24, 74, 3, NULL, '2021-05-17 09:26:23', 1);
INSERT INTO `user_role` VALUES (25, 75, 3, NULL, '2021-05-18 13:29:26', 1);

SET FOREIGN_KEY_CHECKS = 1;
