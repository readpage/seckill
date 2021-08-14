#  seckill

***项目在扩建中不稳定,请下载发行版***

## 此项目源码采用前后端分离方式，spring boot开发后端，使用spring security进行权限控制，vue3、element plus、axios为前端，基于json进行，接口完全采用Restful的风格.

商城抢购系统分为前后台两个页面、用户端工作的主要流程从登陆开始，首先进入登录页面进行登录，输入用户名密码之后进行登录。用户进入网页后可以进行商品浏览、商品选择、进行购买商品,以及该系统主打特色-抢购活动页面，还可以进入个人中心修改资料、密码，退出登录和订单管理等。

商城管理后台系统的主要流程从登录开始，首先进入登录页面进行登录也可以注册后台登录，进入系统后可进行，商品信息管理、商品库存管理，商品店铺管理，商品的修改，注册用户信息管理，订单信息管理，订单信息修改，价格管理、还可以退出登录等

## 操作指南

​	环境:idea+node+maven+jdk8

1. msqyl创建数据库seckill,sql文件下导人seckill.sql文件.

2. 运行项目store-provider

3. vue文件下右键打开终端,切换到到admin目录下

4. 启动后台

   ```
   // 下载vue相应框架组件(注意在admin目录下运行命令)
   npm install
   // 启动vue项目
   npm run dev
   
   ```

6. 启动前台

   ```npm
   //右键新建终端端口 vue文件下切换目录到shop
   // 下载vue相应框架组件(注意在admin目录下运行命令)
   npm install
   // 启动项目
   npm run dev
   
   ```

   


 

 

 

1.3商城登录

根据输入的用户、密码与数据库中的用户对应的密码进行匹配，成功即登录成功否则失败。商城管理后台端登录界面如图2-1所示、注册界面如图2-2所示。

​             

 

 

![img](https://gitee.com/f1dao/images/raw/master/wps17.jpg) 

2-1 商城登录页面

 

 

![img](https://gitee.com/f1dao/images/raw/master/wps18.jpg) 

2-2 商城注册页面

 

为了便于管理商城，给用户带来更好的使用感受，本系统分为用户与管理者，两者登录方式不同，登录注册页面相同

 

 

 

## **2****．用户端功能**

 

## 2.1.1商品选购

#### 对于商城购物来说，商品的选购模块进行选择是必不可少的。商品选购模块界面如图3-1所示。

 

![img](https://gitee.com/f1dao/images/raw/master/wps19.jpg)图3-1 商品选购模块界面

#### 2.1.2商品的搜索

用户输入商品的名字，首页展示结果。影片的搜索模块界面如图3-2所示。

​          ![img](https://gitee.com/f1dao/images/raw/master/wps20.jpg)

图3-2 商品的搜索模块界面

 

#### 2.1.3商品加购

用户浏览商品，对想要购买的商品进行选择了解并购买、加购模块界面如图3-3所示。

![img](https://gitee.com/f1dao/images/raw/master/wps21.jpg)

图3-3商品加购模块界面

#### 2.1.4“抢购”功能

用户对于商城主办的抢购活动可以按照规矩时间进行抢购，然后点击抢购页面对心仪产品进行抢购

“抢购”页面如图3-4所示。

![img](https://gitee.com/f1dao/images/raw/master/wps22.jpg)

 

 

 

图3-4“抢购”页面

#### 2.1.5 购买商品

购买商品模块是本系统的基本功能也是核心功能，分为选择要购买的商品、数量、生成订单。购买商品等界面如图3-5所示。

![img](https://gitee.com/f1dao/images/raw/master/wps23.jpg)

 

![img](https://gitee.com/f1dao/images/raw/master/wps24.jpg)

图3-5 购买商品等界面

 

 

#### 2.1.6 编辑资料（我的）

用户可以通过个人中心里的编辑资料来更改头像、昵称。编辑资料如图3-10所示。

![img](https://gitee.com/f1dao/images/raw/master/wps25.jpg) 

 

 

 

![img](https://gitee.com/f1dao/images/raw/master/wps26.jpg) 

图3-10编辑资料

## 2.1.7订单管理

 

在购物车选项中，可以进行订单管理。订单管理如图3-11所示。

![img](https://gitee.com/f1dao/images/raw/master/wps27.jpg)

图3-11 订单管理

 

 

 

## **3.2商品管理端功能**

## 3.2.1系统首页

管理端首页运用扇形统计图形象的展示了网站商品售卖的具体信息，如3-1所示

 

![img](https://gitee.com/f1dao/images/raw/master/wps28.jpg) 

​             3-1 系统首页图

 

## 3.2.2商品管理 

在商品管理中对商品的信息进行添加，修改，删除管理

![img](https://gitee.com/f1dao/images/raw/master/wps29.jpg) 

图3-2 添加商品详情模块界面

 

 

此外这里还有一个特色功能，抢购功能，后台管理人员可以设置抢购活动的具体信息，如图3-2-1

![img](https://gitee.com/f1dao/images/raw/master/wps30.jpg) 

​           图3-2-1 后台抢购管理页面

 

 

 

## 3.2.3订单管理

对用户提交的订单信息进行核对，检测，操作与管理

![img](https://gitee.com/f1dao/images/raw/master/wps31.jpg) 

图3-3 订单管理详情模块界面

 

## 3.2.4 用户管理

以表格的形式展示在该商城进行注册登录的用户个人信息，并对其进行修改删除等按钮操作。用户管理详情模块界面如图3-15所示。

![img](https://gitee.com/f1dao/images/raw/master/wps32.jpg) 

图3-4 用户管理详情模块界面

# 赞赏
***
请作者喝杯咖啡吧！(微信号：hellobook1)

<img width="250" src="https://gitee.com/f1dao/images/raw/master/1626671153432.png" alt="">
 

 

 

 