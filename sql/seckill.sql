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

 Date: 08/07/2021 21:29:06
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
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品类型',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 149 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (86, 'FlexPai2新一代5G双模折叠屏手机', '2022a0a4297058a8.jpg', 9998.00, 1628, '柔宇（ROYOLE）折叠屏手机京东自营旗舰店', '手机', '2021-05-26 11:08:50', '2021-05-28 14:58:53', 1);
INSERT INTO `goods` VALUES (87, '9A5000mAh大电量大屏幕大字体大音量', '5b33ac76b2aaea9b.jpg', 699.00, 1217, '小米京东自营旗舰店', '手机', '2021-05-26 11:08:51', '2021-05-29 18:25:29', 1);
INSERT INTO `goods` VALUES (88, 'Note94G', 'c0cf7c9643743b71.jpg', 1099.00, 597, '小米京东自营旗舰店', '手机', '2021-05-26 11:08:51', NULL, 1);
INSERT INTO `goods` VALUES (89, 'Note9Pro', 'ed74bdb6decc03a0.jpg', 1799.00, 719, '小米京东自营旗舰店', '手机', '2021-05-26 11:08:51', NULL, 1);
INSERT INTO `goods` VALUES (90, '超级快充5000mAh大电池6.6英寸全面屏', '56b4eabc00aa04c8.jpg', 1301.00, 1298, '荣耀京东自营旗舰店', '手机', '2021-05-26 11:08:52', NULL, 1);
INSERT INTO `goods` VALUES (91, 'iPhone12(A2404)', '63796cc95e30a40e.jpg', 6799.00, 925, 'Apple产品京东自营旗舰店', '手机', '2021-05-26 11:11:06', NULL, 1);
INSERT INTO `goods` VALUES (92, '真我Q3骁龙750G120Hz可变帧电竞屏', '133030cccc51681c.jpg', 1249.00, 617, 'realme真我京东自营旗舰店', '手机', '2021-05-26 11:11:06', NULL, 1);
INSERT INTO `goods` VALUES (93, 'K99老人手机全网通4G移动联通电信老年机', '8e0db42162d354ac.jpg', 199.00, 1429, '纽曼京东自营官方旗舰店', '手机', '2021-05-26 11:11:07', NULL, 1);
INSERT INTO `goods` VALUES (94, 'Note95G', 'b0fe4cfb07693742.jpg', 1268.00, 1336, '小米京东自营旗舰店', '手机', '2021-05-26 11:11:08', NULL, 1);
INSERT INTO `goods` VALUES (95, 'Reno55G6400万水光人像四摄', '330d61c61b9381a2.jpg', 2999.00, 1415, 'OPPO京东自营官方旗舰店', '手机', '2021-05-26 11:11:08', NULL, 1);
INSERT INTO `goods` VALUES (97, 'E142021居家办公本', '634851842fa3ab8c.jpg', 5299.00, 509, 'ThinkPad京东自营旗舰店', '笔记本电脑', '2021-05-26 11:17:59', NULL, 1);
INSERT INTO `goods` VALUES (98, '到手价4099；含199元套装；联想小新AIR14笔记本电脑', '7356351f6d7cc7dc.jpg', 4199.00, 1097, '联想华北授权专卖店', '笔记本电脑', '2021-05-26 11:17:59', NULL, 1);
INSERT INTO `goods` VALUES (99, '2021超轻薄笔记本电脑高色域学生办公设计师游戏本八核锐龙R7-5700U', '0fa0d41877da5ff4.jpg', 5499.00, 1475, '联想华东授权专卖店', '笔记本电脑', '2021-05-26 11:17:59', NULL, 1);
INSERT INTO `goods` VALUES (100, '15.6英寸游戏笔记本电脑(R7-4800H16G512G', '3700fb613c795f15.jpg', 6199.00, 1743, '联想京东自营旗舰店', '笔记本电脑', '2021-05-26 11:18:00', NULL, 1);
INSERT INTO `goods` VALUES (101, '高性能轻薄本英特尔酷睿i513.3英寸全面屏学生笔记本电脑(i5-1135G7', '2e9c82bceb5e899f.jpg', 5999.00, 1932, '联想京东自营旗舰店', '笔记本电脑', '2021-05-26 11:18:00', NULL, 1);
INSERT INTO `goods` VALUES (102, '立减300；联想IdeaPad14s增强版超轻薄笔记本电脑', '13b3c38d82f4a783.jpg', 3699.00, 1771, '联想华北授权专卖店', '笔记本电脑', '2021-05-26 11:18:53', NULL, 1);
INSERT INTO `goods` VALUES (103, 'MagicBookX', '521c806110f6ae6f.jpg', 3899.00, 1158, '荣耀京东自营旗舰店', '笔记本电脑', '2021-05-26 11:18:54', NULL, 1);
INSERT INTO `goods` VALUES (104, '16英寸全面屏笔记本电脑(标压R7-5800H16G', 'b336193f722ba9d1.jpg', 6499.00, 1869, '联想京东自营旗舰店', '笔记本电脑', '2021-05-26 11:18:54', NULL, 1);
INSERT INTO `goods` VALUES (105, '15.6英寸高性能轻薄商务笔记本电脑(11代英特尔酷睿i5-1135G716G', '8ee97cd2969dce34.jpg', 4399.00, 1412, '戴尔京东自营官方旗舰店', '笔记本电脑', '2021-05-26 11:18:54', NULL, 1);
INSERT INTO `goods` VALUES (106, '高性能轻薄本14英寸全面屏笔记本电脑(8核R7-5800H', '24ea633243870934.jpg', 5699.00, 1454, '联想京东自营旗舰店', '笔记本电脑', '2021-05-26 11:18:54', NULL, 1);
INSERT INTO `goods` VALUES (107, '办公室下午茶休闲零食家庭装349g独立小包分享装囤货必备（新老包装随机发货）', '0a15d5b71eafadea.jpg', 19.90, 981, '亿滋京东自营官方旗舰店', '食品', '2021-05-26 12:06:32', NULL, 1);
INSERT INTO `goods` VALUES (108, '糯米老婆饼1000g整箱礼盒装澳门风味特色小吃', '619bf8f7b80eccb4.jpg', 21.70, 1735, '葡记京东自营旗舰店', '食品', '2021-05-26 12:06:35', NULL, 1);
INSERT INTO `goods` VALUES (109, '饼干蛋糕点心糕点零食酵母面包代餐早餐饼干口袋软面包礼盒1000g/盒', 'df5c73b38818c6a8.jpg', 32.90, 1056, '三只松鼠京东自营旗舰店', '食品', '2021-05-26 12:06:35', NULL, 1);
INSERT INTO `goods` VALUES (110, '铜锣烧蛋糕1000g整箱礼盒装', 'b9f6679f38fab942.jpg', 29.90, 857, '葡记京东自营旗舰店', '食品', '2021-05-26 12:06:35', NULL, 1);
INSERT INTO `goods` VALUES (111, '750g/30袋端午坚果礼盒零食大礼包儿童孕妇节日混合干果腰果夏威夷果核桃仁开心果巴旦木', '665db6224c197af9.jpg', 149.00, 1659, '三只松鼠京东自营旗舰店', '食品', '2021-05-26 12:06:36', NULL, 1);
INSERT INTO `goods` VALUES (112, '京东超市	\n三只松鼠乳酸菌小伴侣面包 营养早餐代餐口袋手撕面包网红零食饼干生日蛋糕糕点520g/箱', '606887af934f806e.jpg', 28.90, 1266, '三只松鼠京东自营旗舰店', '食品', '2021-05-26 12:06:36', NULL, 1);
INSERT INTO `goods` VALUES (113, '手撕干巴牛肉四川牛肉干', 'd15aab0bf393b70d.jpg', 108.00, 985, '椒享官方旗舰店', '食品', '2021-05-26 12:06:36', NULL, 1);
INSERT INTO `goods` VALUES (114, '昆明冠生园梅花牌中华老字号鲜花饼440g礼盒装糕点零食小吃玫瑰花饼', '708865ec89b0336c.jpg', 29.80, 1108, '梅花牌京东自营旗舰店', '食品', '2021-05-26 12:06:37', NULL, 1);
INSERT INTO `goods` VALUES (115, '京东超市	\n【满199减120】每日坚果礼盒600g/30袋 干果炒货核桃孕妇零食大礼包', '1b070a40afecc699.jpg', 199.90, 1186, '享食者食品旗舰店', '食品', '2021-05-26 12:06:37', NULL, 1);
INSERT INTO `goods` VALUES (116, '京东超市	\n达利园饼干 好吃点香脆核桃饼800g薄饼脆片礼盒早餐食品曲奇饼干蛋糕零食办公室点心(新老包装随机发货)', '469e069a422d66c5.jpg', 29.90, 1091, '达利园京东自营旗舰店', '食品', '2021-05-26 12:06:38', NULL, 1);
INSERT INTO `goods` VALUES (117, '3074白色XL', 'c9711fa3e3b0f9c5.jpg', 58.00, 1808, '奥帝洛姿服饰专营店', '服装', '2021-05-26 12:08:40', NULL, 1);
INSERT INTO `goods` VALUES (118, '四格白+KY蓝+SP灰+海Z黑L建议120-135斤', '4992d74848f80fa5.jpg', 99.00, 680, '诚谊服饰专营店', '服装', '2021-05-26 12:08:41', NULL, 1);
INSERT INTO `goods` VALUES (119, '水绿色(柯基男孩)L【推荐120-130斤左右】', '8b7d7209305599f5.jpg', 49.90, 1490, '南极人布克专卖店', '服装', '2021-05-26 12:08:42', NULL, 1);
INSERT INTO `goods` VALUES (120, '深灰色XL', '63e0981481fca821.jpg', 139.00, 1305, '卡帝乐鳄鱼（CARTELO）男装京东自营专卖店', '服装', '2021-05-26 12:08:43', NULL, 1);
INSERT INTO `goods` VALUES (121, '运动套装男健身服速干冰丝休闲短袖夏季宽松薄款训练篮球装备T恤跑步衣服晨跑短裤科幻宽松两件套【冰丝套装】', 'e61c5436f3471347.jpg', 59.00, 684, '艾伦伯顿官方旗舰店', '服装', '2021-05-26 12:08:44', NULL, 1);
INSERT INTO `goods` VALUES (122, '白色XL', 'e842b9698a26c8b1.jpg', 99.00, 1918, '稻草人男装服饰京东自营专区', '服装', '2021-05-26 12:08:44', NULL, 1);
INSERT INTO `goods` VALUES (123, '3件套】卫衣套装男春装男季运动套装2021新款潮休闲男装外套男衣服男服饰801灰色(三件套)', 'c16ac26c03712eaa.jpg', 128.00, 1740, '潮龙涧男装专营店', '服装', '2021-05-26 12:08:44', NULL, 1);
INSERT INTO `goods` VALUES (124, '夹克男士外套休闲潮流修身立领夹克衫渐变上衣服男装2072', 'e33d77714aa8f2eb.jpg', 158.00, 1543, 'AEMAPE苹果男装京东自营专区', '服装', '2021-05-26 12:08:44', NULL, 1);
INSERT INTO `goods` VALUES (125, '【纯棉4件】宾宇兄弟t恤男短袖2021年新款韩版修身大码t恤时尚休闲男装上衣服青年半截袖打底衫体恤潮 纯棉套餐7：三杠黑+des卡其+黄杠铁灰+帽子雾...', '382d938ae5835e2b.jpg', 99.00, 1050, '奥尼服饰专营店', '服装', '2021-05-26 12:08:46', NULL, 1);
INSERT INTO `goods` VALUES (126, '长乱条黑+叶子黑', '5d403c4bccb1e51f.jpg', 25.00, 1440, '耀佳男装专营店', '服装', '2021-05-26 12:08:46', NULL, 1);
INSERT INTO `goods` VALUES (127, '3.4米多人位升级版', '37ebba12e1ddfbbf.jpg', 5728.00, 1382, '班捷家居旗舰店', '家具', '2021-05-26 12:09:14', NULL, 1);
INSERT INTO `goods` VALUES (128, '沙发实木沙发现代新中式布艺沙发组合小户型客厅整装家具', 'ab9c88ab2d2b8ce5.jpg', 1499.00, 559, '卡貝森家具旗舰店', '家具', '2021-05-26 12:09:14', NULL, 1);
INSERT INTO `goods` VALUES (129, '三人位布板颜色样品寄送联系客服旗舰版海绵座包【颜...', '2aef1e0ee823f999.jpg', 1499.00, 1566, '宣梵家具旗舰店', '家具', '2021-05-26 12:09:15', NULL, 1);
INSERT INTO `goods` VALUES (130, '衣柜推拉门简易木质两门小衣柜衣橱简约现代移门衣柜浅胡桃色', '9621d6ff10911bef.jpg', 258.00, 1604, '新尚.美家家具旗舰店', '家具', '2021-05-26 12:09:15', NULL, 1);
INSERT INTO `goods` VALUES (131, '实木床双人床北欧主卧大床1.81.51.2米经济型现代简约单人床加厚出租房简易床裸床胡桃色', '733744d4acc30ddd.jpg', 391.00, 1149, '庆恩旗舰店', '家具', '2021-05-26 12:09:15', NULL, 1);
INSERT INTO `goods` VALUES (132, '床真皮床卧室双人床现代简约', '5798168fa0ff004d.jpg', 2880.00, 1711, '百冠环球迅毅专卖店', '家具', '2021-05-26 12:09:15', NULL, 1);
INSERT INTO `goods` VALUES (133, '衣柜现代简约卧室家具木质带转角边柜组合大衣橱四门五门白色衣柜', '2c47f712bf576185.jpg', 980.00, 748, '奥尚斯莱家居旗舰店', '家具', '2021-05-26 12:09:15', NULL, 1);
INSERT INTO `goods` VALUES (134, '茶几实木质感茶几', '537a064d04a10785.jpg', 99.00, 1738, '雅美乐京东自营旗舰店', '家具', '2021-05-26 12:09:16', NULL, 1);
INSERT INTO `goods` VALUES (135, '沙发现代简约皮布沙发北欧客厅可拆洗整装布艺沙发组合102085C', 'f27f18716aec7613.jpg', 3588.00, 1268, '全友家居京东自营旗舰店', '家具', '2021-05-26 12:09:16', NULL, 1);
INSERT INTO `goods` VALUES (136, '三人位【颜色样品寄送联系客服】旗舰海绵座包【颜色备注...', 'b9bac2411640d95c.jpg', 1499.00, 1810, '亲友家居旗舰店', '家具', '2021-05-26 12:09:16', NULL, 1);
INSERT INTO `goods` VALUES (137, '惠普', NULL, 5000.00, 2000, '惠普旗舰店', '笔记本电脑', '2021-05-28 14:14:13', '2021-05-28 14:14:13', 1);
INSERT INTO `goods` VALUES (138, 'vivo', NULL, 2000.00, 499, 'vivo旗舰店', '手机', '2021-05-28 14:17:32', '2021-05-28 14:17:32', 1);
INSERT INTO `goods` VALUES (139, 'oppo', NULL, 2512.00, 200, 'oppo旗舰店', '手机', '2021-05-28 14:46:58', '2021-05-28 15:02:09', 1);
INSERT INTO `goods` VALUES (146, 'c', NULL, 12314.00, 23141, '132412', '笔记本电脑', '2021-07-05 18:39:32', NULL, 1);
INSERT INTO `goods` VALUES (147, 'f', NULL, 1314.00, 31241, '2134', '手机', '2021-07-05 18:41:50', NULL, 1);

-- ----------------------------
-- Table structure for goods_seckill
-- ----------------------------
DROP TABLE IF EXISTS `goods_seckill`;
CREATE TABLE `goods_seckill`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '秒杀商品id',
  `gid` int(0) NULL DEFAULT NULL COMMENT '商品gid',
  `start_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀开始时间',
  `end_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀结束时间',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  `status` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `gid`(`gid`) USING BTREE,
  CONSTRAINT `goods_seckill_ibfk_1` FOREIGN KEY (`gid`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 183 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_seckill
-- ----------------------------
INSERT INTO `goods_seckill` VALUES (122, 86, '2021-07-01 00:00:00', '2021-07-15 00:00:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (123, 87, '2021-05-28 00:00:00', '2021-08-25 18:11:57', 1, 1);
INSERT INTO `goods_seckill` VALUES (124, 88, '2021-07-05 00:00:00', '2021-07-07 00:00:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (125, 89, '2021-07-05 00:00:00', '2021-07-07 00:00:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (126, 90, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 0);
INSERT INTO `goods_seckill` VALUES (127, 91, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (128, 92, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (129, 93, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (130, 94, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (131, 95, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (132, 97, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (133, 98, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (134, 99, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (135, 100, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (136, 101, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (137, 102, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (138, 103, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (139, 104, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (140, 105, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (141, 106, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (142, 107, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (143, 108, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (144, 109, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (145, 110, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (146, 111, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (147, 112, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (148, 113, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (149, 114, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (150, 115, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (151, 116, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (152, 117, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (153, 118, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (154, 119, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (155, 120, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (156, 121, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (157, 122, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (158, 123, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (159, 124, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (160, 125, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (161, 126, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (162, 127, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (163, 128, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (164, 129, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (165, 130, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (166, 131, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (167, 132, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (168, 133, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (169, 134, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (170, 135, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (171, 136, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (172, 137, '2021-05-26 12:19:46', '2021-05-26 12:19:46', 1, 0);
INSERT INTO `goods_seckill` VALUES (173, 138, '2021-05-30 00:00:00', '2021-06-30 00:00:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (174, 139, '2021-05-28 14:46:57', '2021-05-28 14:46:57', 1, 0);
INSERT INTO `goods_seckill` VALUES (180, NULL, '2021-07-05 18:39:32', '2021-07-05 18:39:32', 1, 0);
INSERT INTO `goods_seckill` VALUES (181, NULL, '2021-07-05 18:41:50', '2021-07-05 18:41:50', 1, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '/goods/add-seckill/**', '2021-04-28 19:25:24', NULL, 1);
INSERT INTO `menu` VALUES (2, '/goods/delete/**', '2021-04-28 19:25:24', NULL, 1);
INSERT INTO `menu` VALUES (3, '/goods/deleteBatchId/**', '2021-04-28 19:25:24', NULL, 1);
INSERT INTO `menu` VALUES (4, '/goods/like/**', '2021-06-20 15:26:30', NULL, 1);
INSERT INTO `menu` VALUES (5, '/goods/type/**', '2021-07-05 18:21:04', NULL, 1);
INSERT INTO `menu` VALUES (6, '/goods/page/**', '2021-07-05 18:01:46', NULL, 1);
INSERT INTO `menu` VALUES (7, '/goods/save/**', '2021-07-05 18:02:17', NULL, 1);
INSERT INTO `menu` VALUES (8, '/goods/selectAll/**', '2021-07-05 18:02:32', NULL, 1);
INSERT INTO `menu` VALUES (9, '/goods/update/**', '2021-07-05 18:02:43', NULL, 1);
INSERT INTO `menu` VALUES (10, '/user/delete/**', '2021-07-05 18:02:58', NULL, 1);
INSERT INTO `menu` VALUES (11, '/user/deleteBatchId/**', '2021-07-05 18:03:13', NULL, 1);
INSERT INTO `menu` VALUES (12, '/user/page/**', '2021-07-05 18:03:32', NULL, 1);
INSERT INTO `menu` VALUES (13, '/user/register/**', '2021-07-05 18:03:46', NULL, 1);
INSERT INTO `menu` VALUES (14, '/user/selectsUsername/**', '2021-07-05 18:04:00', NULL, 1);
INSERT INTO `menu` VALUES (15, '/user/update/**', '2021-07-05 18:04:18', NULL, 1);
INSERT INTO `menu` VALUES (16, '/orders/add/**', '2021-07-05 18:04:33', NULL, 1);
INSERT INTO `menu` VALUES (17, '/orders/add/seckill/**', '2021-07-05 18:04:43', NULL, 1);
INSERT INTO `menu` VALUES (18, '/orders/deleteBatchId/**', '2021-07-05 18:04:59', NULL, 1);
INSERT INTO `menu` VALUES (19, '/orders/likeName/**', '2021-07-05 18:05:08', NULL, 1);
INSERT INTO `menu` VALUES (20, '/orders/likeNumber', '2021-07-05 18:05:19', NULL, 1);
INSERT INTO `menu` VALUES (21, '/orders/page/**', '2021-07-05 18:05:25', NULL, 1);
INSERT INTO `menu` VALUES (22, '/orders/selectAll/**', '2021-07-05 18:05:33', NULL, 1);
INSERT INTO `menu` VALUES (23, '/goods/pageSeckill/**', '2021-07-05 18:21:44', NULL, 1);
INSERT INTO `menu` VALUES (24, '/user/selectUserCount', '2021-07-06 09:13:25', NULL, 1);
INSERT INTO `menu` VALUES (25, '/info/data', '2021-07-06 17:02:34', NULL, 1);
INSERT INTO `menu` VALUES (26, '/user/save', '2021-07-07 08:31:03', NULL, 1);
INSERT INTO `menu` VALUES (27, '/info/user', '2021-07-07 09:03:05', NULL, 1);
INSERT INTO `menu` VALUES (28, '/info/updateUser', '2021-07-07 10:51:56', NULL, 1);
INSERT INTO `menu` VALUES (29, '/orders/personPage/**', '2021-07-07 15:58:27', NULL, 1);
INSERT INTO `menu` VALUES (30, '/orders/delete/*', '2021-07-08 21:26:35', NULL, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES (1, 1, 2, '2021-04-28 19:28:00', NULL, 1);
INSERT INTO `menu_role` VALUES (2, 2, 2, '2021-04-28 19:28:00', NULL, 1);
INSERT INTO `menu_role` VALUES (3, 3, 2, '2021-04-28 19:28:00', NULL, 1);
INSERT INTO `menu_role` VALUES (4, 4, 2, '2021-04-28 19:28:00', NULL, 1);
INSERT INTO `menu_role` VALUES (5, 6, 2, '2021-04-28 19:28:00', NULL, 1);
INSERT INTO `menu_role` VALUES (6, 7, 2, '2021-04-28 19:28:00', NULL, 1);
INSERT INTO `menu_role` VALUES (14, 8, 2, '2021-05-16 18:42:01', NULL, 1);
INSERT INTO `menu_role` VALUES (15, 9, 2, '2021-07-05 18:07:28', NULL, 1);
INSERT INTO `menu_role` VALUES (16, 10, 2, '2021-07-05 18:07:30', NULL, 1);
INSERT INTO `menu_role` VALUES (17, 11, 2, '2021-07-05 18:07:31', NULL, 1);
INSERT INTO `menu_role` VALUES (18, 12, 2, '2021-07-05 18:07:34', NULL, 1);
INSERT INTO `menu_role` VALUES (19, 13, 2, '2021-07-05 18:07:35', NULL, 1);
INSERT INTO `menu_role` VALUES (20, 14, 2, '2021-07-05 18:07:36', NULL, 1);
INSERT INTO `menu_role` VALUES (21, 15, 2, '2021-07-05 18:07:37', NULL, 1);
INSERT INTO `menu_role` VALUES (22, 16, 2, '2021-07-05 18:07:39', NULL, 1);
INSERT INTO `menu_role` VALUES (23, 17, 2, '2021-07-05 18:07:41', NULL, 1);
INSERT INTO `menu_role` VALUES (24, 18, 2, '2021-07-05 18:07:43', NULL, 1);
INSERT INTO `menu_role` VALUES (25, 19, 2, '2021-07-05 18:07:46', NULL, 1);
INSERT INTO `menu_role` VALUES (26, 20, 2, '2021-07-05 18:07:48', NULL, 1);
INSERT INTO `menu_role` VALUES (27, 21, 2, '2021-07-05 18:07:56', NULL, 1);
INSERT INTO `menu_role` VALUES (28, 22, 2, '2021-07-05 18:08:04', NULL, 1);
INSERT INTO `menu_role` VALUES (29, 5, 2, '2021-07-05 18:23:03', NULL, 1);
INSERT INTO `menu_role` VALUES (30, 23, 2, '2021-07-05 18:23:09', NULL, 1);
INSERT INTO `menu_role` VALUES (31, 6, 4, '2021-07-05 20:03:44', NULL, 1);
INSERT INTO `menu_role` VALUES (32, 24, 2, '2021-07-06 09:14:21', NULL, 1);
INSERT INTO `menu_role` VALUES (33, 25, 2, '2021-07-06 17:02:45', NULL, 1);
INSERT INTO `menu_role` VALUES (34, 23, 3, '2021-07-06 18:31:50', NULL, 1);
INSERT INTO `menu_role` VALUES (35, 16, 3, '2021-07-06 18:33:53', NULL, 1);
INSERT INTO `menu_role` VALUES (36, 17, 3, '2021-07-06 18:33:58', NULL, 1);
INSERT INTO `menu_role` VALUES (37, 26, 2, '2021-07-07 08:32:23', NULL, 1);
INSERT INTO `menu_role` VALUES (38, 27, 3, '2021-07-07 09:03:15', NULL, 1);
INSERT INTO `menu_role` VALUES (39, 28, 3, '2021-07-07 10:52:11', NULL, 1);
INSERT INTO `menu_role` VALUES (40, 29, 3, '2021-07-07 15:58:52', NULL, 1);
INSERT INTO `menu_role` VALUES (41, 23, 4, '2021-07-07 22:54:11', NULL, 1);
INSERT INTO `menu_role` VALUES (42, 13, 4, '2021-07-08 16:21:51', NULL, 1);
INSERT INTO `menu_role` VALUES (43, 30, 2, '2021-07-08 21:26:58', NULL, 1);

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
  `discounts` float NULL DEFAULT NULL COMMENT '折扣',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 219 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (186, 'bfcb9e2a1f3940f3890c4745f0591b56', 2, '2021-05-30 14:25:59', 0, NULL, 1, 1);
INSERT INTO `orders` VALUES (187, 'abe2655c50ac4715bc384d7135f8f48d', 1, '2021-05-30 14:43:28', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (188, 'cc4c24dc9cdd4adf8ccbd99bf48d339e', 1, '2021-05-30 14:50:42', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (189, 'e62aa62f64ec408c8a00ef8688daee5d', 2, '2021-05-30 14:51:35', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (190, '3179e7da3557495383ebe33fab5de51d', 2, '2021-05-30 14:51:41', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (191, '32dd458ddbd544f3a96dc23f1c0d76b0', 1, '2021-05-30 14:53:32', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (192, 'c6831bfd0e27493dbf0bdc80ac6e25f1', 1, '2021-05-30 15:25:40', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (193, '02c08e681f0a46e684ca89d512669b25', 1, '2021-05-30 15:25:45', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (194, '43131290bb574d35981d057de26a81d0', 1, '2021-05-30 15:25:47', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (195, '56b9f2ecb1c04260a26e1e826d3431de', 1, '2021-05-30 15:25:49', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (196, '52bf064265284dc7bc2f3c5984a4465d', 1, '2021-05-30 15:25:50', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (197, 'aa08e2a565234591af0ab81c94d7ba83', 1, '2021-05-30 16:32:28', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (198, 'c7f49dc76a7045b4a4e0325aaaf4f247', 1, '2021-05-30 16:35:08', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (199, '5090d78e07c0498a8c29abf7fd776caa', 1, '2021-05-30 16:36:14', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (200, '5e4f1d7411974ddf857a500b4352bb27', 1, '2021-05-30 16:38:25', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (201, 'b1bf47036efc43d8bb2982df2887825f', 1, '2021-05-30 16:49:09', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (202, '6b4e1c689ebd42bead0ea5f214e329c9', 1, '2021-05-30 16:49:14', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (203, 'ae17acf3ac7d4ffcafd47f90679a2e15', 1, '2021-05-30 16:49:19', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (204, '1d93e037d8c4415ca6212d4d842349aa', 1, '2021-05-30 16:49:28', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (205, '1e9d53a821044555a4efe97c9ce53022', 1, '2021-05-30 16:49:33', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (206, 'de780fd033f74d4582e72413f3266a16', 1, '2021-05-30 17:25:02', 0, NULL, 1, 1);
INSERT INTO `orders` VALUES (207, 'de492c121f824fdb86258603714bf1ec', 1, '2021-05-30 17:25:11', 0, NULL, 1, 1);
INSERT INTO `orders` VALUES (208, '71c9e846f66543aba1125e255d06b3d0', 1, '2021-05-30 17:26:25', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (209, '32af00ff3da94ed8a9388299a8576814', 1, '2021-05-30 17:45:26', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (210, '85e9d0eb1ec440f5aeed65af62e60367', 1, '2021-05-30 17:46:34', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (211, '828373c2954746b694a630f2bcd398f7', 1, '2021-05-30 17:46:42', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (212, 'd1931e8b28f241ea941b585247e1f4ed', 1, '2021-05-30 17:46:47', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (213, '96162fb86f6b4bd88d9c90856bb89877', 1, '2021-05-30 17:46:52', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (214, '650d9e982d344708941d7a6cb06ef68a', 1, '2021-07-05 16:12:48', 0, NULL, 1, 1);
INSERT INTO `orders` VALUES (215, '2c2b39511fb24cf2a738dacc0570b6a7', 3, '2021-07-06 18:34:02', 0, NULL, 1, 0.1);
INSERT INTO `orders` VALUES (216, 'e6f8dc8b90d94394ab0aee511699c8f4', 3, '2021-07-06 18:34:24', 0, NULL, 1, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 190 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders_goods
-- ----------------------------
INSERT INTO `orders_goods` VALUES (155, 186, 86, 1);
INSERT INTO `orders_goods` VALUES (156, 187, 89, 1);
INSERT INTO `orders_goods` VALUES (157, 188, 90, 1);
INSERT INTO `orders_goods` VALUES (158, 189, 87, 1);
INSERT INTO `orders_goods` VALUES (159, 190, 88, 1);
INSERT INTO `orders_goods` VALUES (160, 191, 134, 1);
INSERT INTO `orders_goods` VALUES (161, 192, 135, 1);
INSERT INTO `orders_goods` VALUES (162, 193, 136, 1);
INSERT INTO `orders_goods` VALUES (163, 194, 138, 1);
INSERT INTO `orders_goods` VALUES (164, 195, 133, 1);
INSERT INTO `orders_goods` VALUES (165, 196, 128, 1);
INSERT INTO `orders_goods` VALUES (166, 197, 94, 1);
INSERT INTO `orders_goods` VALUES (167, 198, 91, 1);
INSERT INTO `orders_goods` VALUES (168, 199, 92, 1);
INSERT INTO `orders_goods` VALUES (169, 200, 99, 1);
INSERT INTO `orders_goods` VALUES (170, 201, 104, 1);
INSERT INTO `orders_goods` VALUES (171, 202, 103, 1);
INSERT INTO `orders_goods` VALUES (172, 203, 105, 1);
INSERT INTO `orders_goods` VALUES (173, 204, 106, 1);
INSERT INTO `orders_goods` VALUES (174, 205, 107, 1);
INSERT INTO `orders_goods` VALUES (175, 206, 88, 1);
INSERT INTO `orders_goods` VALUES (176, 207, 88, 1);
INSERT INTO `orders_goods` VALUES (177, 208, 95, 1);
INSERT INTO `orders_goods` VALUES (178, 209, 115, 1);
INSERT INTO `orders_goods` VALUES (179, 210, 100, 1);
INSERT INTO `orders_goods` VALUES (180, 211, 110, 1);
INSERT INTO `orders_goods` VALUES (181, 212, 108, 1);
INSERT INTO `orders_goods` VALUES (182, 213, 112, 1);
INSERT INTO `orders_goods` VALUES (183, 214, 88, 2);
INSERT INTO `orders_goods` VALUES (184, 215, 87, 1);
INSERT INTO `orders_goods` VALUES (185, 216, 86, 6);
INSERT INTO `orders_goods` VALUES (186, 216, 91, 4);

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'root', '2021-04-28 19:32:40', NULL, 1);
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
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'root', '$2a$10$8B0rfYVBx5ZVX5D15KHVEe0jh0orzYZ4LNOL4mNRWwyIxxkG4C9KC', '139****6302', '/api/avatar/avatar.gif', '2021-04-28 19:34:34', '2021-07-07 08:22:45', 9);
INSERT INTO `user` VALUES (2, 'admin', '$2a$10$xLbctedxEk/D3cv11LzFjOMRaBLk25SrWIidTETr1aa.Ho.0RZTba', '14884326322', '/api/avatar/avatar.gif', '2021-04-28 19:34:34', '2021-06-26 17:59:23', 2);
INSERT INTO `user` VALUES (3, 'user', '$2a$10$nAxzL2juE.1jFhloOWsamOr.NY.ozK5jk4.VRFPigwsGYMch8P6G2', '15995322344', '/api/avatar/avatar.gif', '2021-04-28 19:34:34', '2021-07-07 21:14:33', 2);
INSERT INTO `user` VALUES (95, 'f', '$2a$10$ZxtJkvFghR4ju404bmh5P.uGYBg53Sc16NPci.PExWRazpmXbNpIq', '15885326303', NULL, '2021-07-08 16:40:06', '2021-07-08 16:40:06', 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 2, NULL, '2021-04-28 19:36:33', 1);
INSERT INTO `user_role` VALUES (4, 2, 2, NULL, '2021-04-28 19:36:33', 1);
INSERT INTO `user_role` VALUES (29, 3, 3, NULL, '2021-07-05 19:31:02', 1);
INSERT INTO `user_role` VALUES (30, 2, 3, NULL, '2021-07-07 09:04:41', 1);
INSERT INTO `user_role` VALUES (31, 1, 3, NULL, '2021-07-07 09:04:46', 1);
INSERT INTO `user_role` VALUES (38, 95, 3, NULL, '2021-07-08 16:40:06', 1);

SET FOREIGN_KEY_CHECKS = 1;
