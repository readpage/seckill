import { createRouter, createWebHistory } from 'vue-router'
import Nprogress from 'nprogress';
import "nprogress/nprogress.css";
import axios from "axios"

const routes = [
  {
    path: "/",
    name: "index",
    component: () => import(/* webpackChunkName: "about" */ "../layout/index.vue"),
    children: [
      {
        path: "/",
        redirect: {
          name: "home"
        }
      },
      {
        path: "/home",
        name: "home",
        component: () => import(/* webpackChunkName: "about" */ "../view/home.vue"),
        meta: { title: "主页" }
      },
      {
        path: "/cart",
        component: () => import("../view/cart/cart.vue"),
        meta: { title: "购物车"}
      },
      {
        path: "/shop",
        name: "抢购",
        component: () => import(/* webpackChunkName: "about" */ "../view/shop/shop.vue"),
        meta: { title: "抢购" }
      },
      {
        path: "/info",
        name: "info",
        component: () => import("../view/info/index.vue"),
        meta: { title: "个人中心"}
      },
      {
        path: "/orders",
        name: "orders",
        component: () => import("../view/orders/index.vue"),
        meta: { title: "我的订单"}
      }
    ]
  },
  {
    path: "/sign",
    name: "sign",
    component: () => import(/* webpackChunkName: "about" */  "../view/sign.vue"),
    meta: { title: "登录/注册" }
  },
  {
    path: "/:pathMatch(.*)*",
    name: "404",
    component: () => import(/* webpackChunkName: "about" */ "../view/404.vue"),
    meta: { title: "丢失了"}
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});
router.beforeEach((to, from, next) => {
  Nprogress.start();
  axios.get("/api/info/user").then((res) => {
    if (res.data.code == 200) {
      next();
    } else {
      localStorage.removeItem("user")
      if (to.path == "/cart" || to.path == "/info" || to.path == "/orders") {
        next({
          path: "/sign",
          query: { redirect: to.fullPath}
        })
      } 
      next()
    }
  });
})
router.afterEach(to => {
  load()
  Nprogress.done();
  document.title = to.meta.title;
  
})
function load() {
  setTimeout(() => {
    let loading=document.getElementById("loading")
    if (loading != null) {
      document.body.removeChild(loading);
    }
  }, 666);
}
export default router;