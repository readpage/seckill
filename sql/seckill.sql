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

 Date: 29/05/2021 21:51:32
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
) ENGINE = InnoDB AUTO_INCREMENT = 143 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (86, 'FlexPai2新一代5G双模折叠屏手机', '2022a0a4297058a8.jpg', 9998.00, 1635, '柔宇（ROYOLE）折叠屏手机京东自营旗舰店', '手机', '2021-05-26 11:08:50', '2021-05-28 14:58:53', 1);
INSERT INTO `goods` VALUES (87, '9A5000mAh大电量大屏幕大字体大音量', '5b33ac76b2aaea9b.jpg', 699.00, 1222, '小米京东自营旗舰店', '手机', '2021-05-26 11:08:51', '2021-05-29 18:25:29', 1);
INSERT INTO `goods` VALUES (88, 'Note94G', 'c0cf7c9643743b71.jpg', 1099.00, 602, '小米京东自营旗舰店', '手机', '2021-05-26 11:08:51', NULL, 1);
INSERT INTO `goods` VALUES (89, 'Note9Pro', 'ed74bdb6decc03a0.jpg', 1799.00, 721, '小米京东自营旗舰店', '手机', '2021-05-26 11:08:51', NULL, 1);
INSERT INTO `goods` VALUES (90, '超级快充5000mAh大电池6.6英寸全面屏', '56b4eabc00aa04c8.jpg', 1299.00, 1301, '荣耀京东自营旗舰店', '手机', '2021-05-26 11:08:52', NULL, 1);
INSERT INTO `goods` VALUES (91, 'iPhone12(A2404)', '63796cc95e30a40e.jpg', 6799.00, 930, 'Apple产品京东自营旗舰店', '手机', '2021-05-26 11:11:06', NULL, 1);
INSERT INTO `goods` VALUES (92, '真我Q3骁龙750G120Hz可变帧电竞屏', '133030cccc51681c.jpg', 1249.00, 618, 'realme真我京东自营旗舰店', '手机', '2021-05-26 11:11:06', NULL, 1);
INSERT INTO `goods` VALUES (93, 'K99老人手机全网通4G移动联通电信老年机', '8e0db42162d354ac.jpg', 199.00, 1429, '纽曼京东自营官方旗舰店', '手机', '2021-05-26 11:11:07', NULL, 1);
INSERT INTO `goods` VALUES (94, 'Note95G', 'b0fe4cfb07693742.jpg', 1268.00, 1337, '小米京东自营旗舰店', '手机', '2021-05-26 11:11:08', NULL, 1);
INSERT INTO `goods` VALUES (95, 'Reno55G6400万水光人像四摄', '330d61c61b9381a2.jpg', 2999.00, 1416, 'OPPO京东自营官方旗舰店', '手机', '2021-05-26 11:11:08', NULL, 1);
INSERT INTO `goods` VALUES (97, 'E142021居家办公本', '634851842fa3ab8c.jpg', 5299.00, 509, 'ThinkPad京东自营旗舰店', '笔记本电脑', '2021-05-26 11:17:59', NULL, 1);
INSERT INTO `goods` VALUES (98, '到手价4099；含199元套装；联想小新AIR14笔记本电脑', '7356351f6d7cc7dc.jpg', 4199.00, 1097, '联想华北授权专卖店', '笔记本电脑', '2021-05-26 11:17:59', NULL, 1);
INSERT INTO `goods` VALUES (99, '2021超轻薄笔记本电脑高色域学生办公设计师游戏本八核锐龙R7-5700U', '0fa0d41877da5ff4.jpg', 5499.00, 1476, '联想华东授权专卖店', '笔记本电脑', '2021-05-26 11:17:59', NULL, 1);
INSERT INTO `goods` VALUES (100, '15.6英寸游戏笔记本电脑(R7-4800H16G512G', '3700fb613c795f15.jpg', 6199.00, 1744, '联想京东自营旗舰店', '笔记本电脑', '2021-05-26 11:18:00', NULL, 1);
INSERT INTO `goods` VALUES (101, '高性能轻薄本英特尔酷睿i513.3英寸全面屏学生笔记本电脑(i5-1135G7', '2e9c82bceb5e899f.jpg', 5999.00, 1932, '联想京东自营旗舰店', '笔记本电脑', '2021-05-26 11:18:00', NULL, 1);
INSERT INTO `goods` VALUES (102, '立减300；联想IdeaPad14s增强版超轻薄笔记本电脑', '13b3c38d82f4a783.jpg', 3699.00, 1771, '联想华北授权专卖店', '笔记本电脑', '2021-05-26 11:18:53', NULL, 1);
INSERT INTO `goods` VALUES (103, 'MagicBookX', '521c806110f6ae6f.jpg', 3899.00, 1159, '荣耀京东自营旗舰店', '笔记本电脑', '2021-05-26 11:18:54', NULL, 1);
INSERT INTO `goods` VALUES (104, '16英寸全面屏笔记本电脑(标压R7-5800H16G', 'b336193f722ba9d1.jpg', 6499.00, 1870, '联想京东自营旗舰店', '笔记本电脑', '2021-05-26 11:18:54', NULL, 1);
INSERT INTO `goods` VALUES (105, '15.6英寸高性能轻薄商务笔记本电脑(11代英特尔酷睿i5-1135G716G', '8ee97cd2969dce34.jpg', 4399.00, 1413, '戴尔京东自营官方旗舰店', '笔记本电脑', '2021-05-26 11:18:54', NULL, 1);
INSERT INTO `goods` VALUES (106, '高性能轻薄本14英寸全面屏笔记本电脑(8核R7-5800H', '24ea633243870934.jpg', 5699.00, 1455, '联想京东自营旗舰店', '笔记本电脑', '2021-05-26 11:18:54', NULL, 1);
INSERT INTO `goods` VALUES (107, '办公室下午茶休闲零食家庭装349g独立小包分享装囤货必备（新老包装随机发货）', '0a15d5b71eafadea.jpg', 19.90, 982, '亿滋京东自营官方旗舰店', '食品', '2021-05-26 12:06:32', NULL, 1);
INSERT INTO `goods` VALUES (108, '糯米老婆饼1000g整箱礼盒装澳门风味特色小吃', '619bf8f7b80eccb4.jpg', 21.70, 1736, '葡记京东自营旗舰店', '食品', '2021-05-26 12:06:35', NULL, 1);
INSERT INTO `goods` VALUES (109, '饼干蛋糕点心糕点零食酵母面包代餐早餐饼干口袋软面包礼盒1000g/盒', 'df5c73b38818c6a8.jpg', 32.90, 1056, '三只松鼠京东自营旗舰店', '食品', '2021-05-26 12:06:35', NULL, 1);
INSERT INTO `goods` VALUES (110, '铜锣烧蛋糕1000g整箱礼盒装', 'b9f6679f38fab942.jpg', 29.90, 858, '葡记京东自营旗舰店', '食品', '2021-05-26 12:06:35', NULL, 1);
INSERT INTO `goods` VALUES (111, '750g/30袋端午坚果礼盒零食大礼包儿童孕妇节日混合干果腰果夏威夷果核桃仁开心果巴旦木', '665db6224c197af9.jpg', 149.00, 1659, '三只松鼠京东自营旗舰店', '食品', '2021-05-26 12:06:36', NULL, 1);
INSERT INTO `goods` VALUES (112, '京东超市	\n三只松鼠乳酸菌小伴侣面包 营养早餐代餐口袋手撕面包网红零食饼干生日蛋糕糕点520g/箱', '606887af934f806e.jpg', 28.90, 1267, '三只松鼠京东自营旗舰店', '食品', '2021-05-26 12:06:36', NULL, 1);
INSERT INTO `goods` VALUES (113, '手撕干巴牛肉四川牛肉干', 'd15aab0bf393b70d.jpg', 108.00, 985, '椒享官方旗舰店', '食品', '2021-05-26 12:06:36', NULL, 1);
INSERT INTO `goods` VALUES (114, '昆明冠生园梅花牌中华老字号鲜花饼440g礼盒装糕点零食小吃玫瑰花饼', '708865ec89b0336c.jpg', 29.80, 1108, '梅花牌京东自营旗舰店', '食品', '2021-05-26 12:06:37', NULL, 1);
INSERT INTO `goods` VALUES (115, '京东超市	\n【满199减120】每日坚果礼盒600g/30袋 干果炒货核桃孕妇零食大礼包', '1b070a40afecc699.jpg', 199.90, 1187, '享食者食品旗舰店', '食品', '2021-05-26 12:06:37', NULL, 1);
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
INSERT INTO `goods` VALUES (128, '沙发实木沙发现代新中式布艺沙发组合小户型客厅整装家具', 'ab9c88ab2d2b8ce5.jpg', 1499.00, 560, '卡貝森家具旗舰店', '家具', '2021-05-26 12:09:14', NULL, 1);
INSERT INTO `goods` VALUES (129, '三人位布板颜色样品寄送联系客服旗舰版海绵座包【颜...', '2aef1e0ee823f999.jpg', 1499.00, 1566, '宣梵家具旗舰店', '家具', '2021-05-26 12:09:15', NULL, 1);
INSERT INTO `goods` VALUES (130, '衣柜推拉门简易木质两门小衣柜衣橱简约现代移门衣柜浅胡桃色', '9621d6ff10911bef.jpg', 258.00, 1604, '新尚.美家家具旗舰店', '家具', '2021-05-26 12:09:15', NULL, 1);
INSERT INTO `goods` VALUES (131, '实木床双人床北欧主卧大床1.81.51.2米经济型现代简约单人床加厚出租房简易床裸床胡桃色', '733744d4acc30ddd.jpg', 391.00, 1149, '庆恩旗舰店', '家具', '2021-05-26 12:09:15', NULL, 1);
INSERT INTO `goods` VALUES (132, '床真皮床卧室双人床现代简约', '5798168fa0ff004d.jpg', 2880.00, 1711, '百冠环球迅毅专卖店', '家具', '2021-05-26 12:09:15', NULL, 1);
INSERT INTO `goods` VALUES (133, '衣柜现代简约卧室家具木质带转角边柜组合大衣橱四门五门白色衣柜', '2c47f712bf576185.jpg', 980.00, 749, '奥尚斯莱家居旗舰店', '家具', '2021-05-26 12:09:15', NULL, 1);
INSERT INTO `goods` VALUES (134, '茶几实木质感茶几', '537a064d04a10785.jpg', 99.00, 1739, '雅美乐京东自营旗舰店', '家具', '2021-05-26 12:09:16', NULL, 1);
INSERT INTO `goods` VALUES (135, '沙发现代简约皮布沙发北欧客厅可拆洗整装布艺沙发组合102085C', 'f27f18716aec7613.jpg', 3588.00, 1269, '全友家居京东自营旗舰店', '家具', '2021-05-26 12:09:16', NULL, 1);
INSERT INTO `goods` VALUES (136, '三人位【颜色样品寄送联系客服】旗舰海绵座包【颜色备注...', 'b9bac2411640d95c.jpg', 1499.00, 1811, '亲友家居旗舰店', '家具', '2021-05-26 12:09:16', NULL, 1);
INSERT INTO `goods` VALUES (137, '惠普', NULL, 5000.00, 2000, '惠普旗舰店', '笔记本电脑', '2021-05-28 14:14:13', '2021-05-28 14:14:13', 1);
INSERT INTO `goods` VALUES (138, 'vivo', NULL, 2000.00, 500, 'vivo旗舰店', '手机', '2021-05-28 14:17:32', '2021-05-28 14:17:32', 1);
INSERT INTO `goods` VALUES (139, 'oppo', NULL, 2512.00, 200, 'oppo旗舰店', '手机', '2021-05-28 14:46:58', '2021-05-28 15:02:09', 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 178 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_seckill
-- ----------------------------
INSERT INTO `goods_seckill` VALUES (122, 86, '2021-05-28 00:00:00', '2021-06-23 17:00:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (123, 87, '2021-05-28 00:00:00', '2021-08-25 18:11:57', 1, 1);
INSERT INTO `goods_seckill` VALUES (124, 88, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (125, 89, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
INSERT INTO `goods_seckill` VALUES (126, 90, '2021-05-26 12:19:46', '2021-06-01 12:20:00', 1, 1);
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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `discounts` float NULL DEFAULT NULL COMMENT '折扣',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 186 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (184, '2d9602d056774120b2878a55eb638c03', 1, '2021-05-27 10:47:54', 0, NULL, 1, 1);
INSERT INTO `orders` VALUES (185, '5edb3754387f46d5a297a96e75a78eee', 1, '2021-05-28 15:27:58', 0, NULL, 1, 0.8);

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
) ENGINE = InnoDB AUTO_INCREMENT = 155 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders_goods
-- ----------------------------
INSERT INTO `orders_goods` VALUES (146, 184, 87, 1);
INSERT INTO `orders_goods` VALUES (147, 184, 86, 2);
INSERT INTO `orders_goods` VALUES (148, 185, 109, 3);
INSERT INTO `orders_goods` VALUES (149, 185, 97, 2);
INSERT INTO `orders_goods` VALUES (150, 185, 98, 3);
INSERT INTO `orders_goods` VALUES (151, 185, 93, 1);
INSERT INTO `orders_goods` VALUES (152, 185, 86, 1);
INSERT INTO `orders_goods` VALUES (153, 185, 87, 1);
INSERT INTO `orders_goods` VALUES (154, 185, 88, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'root', '$2a$10$hPb72GAGW4NMWIHui7VMiu9z8/2CaAVaQN1js6CIhZKElgdRSJR2G', '13995726302', '/api/avatar/avatar.gif', '2021-04-28 19:34:34', '2021-05-28 17:44:08', 8);
INSERT INTO `user` VALUES (2, 'admin', '$2a$10$xLbctedxEk/D3cv11LzFjOMRaBLk25SrWIidTETr1aa.Ho.0RZTba', '14884326322', '/api/avatar/avatar.gif', '2021-04-28 19:34:34', '2021-05-28 17:44:08', 2);
INSERT INTO `user` VALUES (3, 'user', '$2a$10$gG2uw7LB0OTyyDNrg9fnquJCe9QYtuOZ/Yj973sr6dGusLMjfSKJe', '15995322344', '/api/avatar/avatar.gif', '2021-04-28 19:34:34', '2021-05-28 17:44:08', 2);
INSERT INTO `user` VALUES (62, 'ff', '$2a$10$fGsC.gTi318XXvxWR1xsseTe6.cqY7KLg2teuF3Bo1ks5qQHhySNy', NULL, '/api/avatar/avatar.gif', '2021-05-14 18:07:51', '2021-05-28 17:44:08', 1);
INSERT INTO `user` VALUES (66, 'ac', '$2a$10$3bckg4c.7qujliEExdn9sO26SoWL0wWwedOb3BSfR4YjDh3xXBekK', NULL, '/api/avatar/avatar.gif', '2021-05-16 15:05:08', '2021-05-28 17:44:08', 4);
INSERT INTO `user` VALUES (74, '李明', '$2a$10$yx98JM9dUSgy0xiAL5rsEuRKOe2RCC8L3wq.Pc7aKK0eW6sSn0Ehq', '12345', '/api/avatar/avatar.gif', '2021-05-17 09:26:23', '2021-05-28 17:44:08', 1);
INSERT INTO `user` VALUES (75, 'fff', '$2a$10$v/xlrup91X2/nR10f.0uiOqF2MBDE5avgzgM0pmQITYk4vq0zBlm.', NULL, '/api/avatar/avatar.gif', '2021-05-18 13:29:26', '2021-05-28 17:44:08', 1);
INSERT INTO `user` VALUES (77, '李名', '$2a$10$aourTj3.SV1sdk0Ew80qIutiQQtp9LCIJDrvFqs2ZI.NkPdzGNEpG', '15995322344', '/api/avatar/avatar.gif', '2021-05-27 17:24:03', '2021-05-28 17:44:08', 1);
INSERT INTO `user` VALUES (78, '赵强', '$2a$10$BF1rjgjpFhD2q.AtyBc9ae.G7Tn07wxhR2G5ZfvWGx9pyIgIXuks2', '14884326322', '/api/avatar/avatar.gif', '2021-05-27 18:21:34', '2021-05-28 17:44:08', 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `user_role` VALUES (27, 77, 3, NULL, '2021-05-27 17:24:02', 1);
INSERT INTO `user_role` VALUES (28, 78, 3, NULL, '2021-05-27 18:21:34', 1);

SET FOREIGN_KEY_CHECKS = 1;
