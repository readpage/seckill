import { createRouter, createWebHistory } from "vue-router";
import Nprogress from "nprogress";
import "nprogress/nprogress.css";
import axios from "axios";

const routes = [
  {
    path: "/",
    name: "index",
    component: () =>
      import(/* webpackChunkName: "about" */ "../layout/index.vue"),
    children: [
      {
        path: "/",
        redirect: {
          name: "home",
        },
      },
      {
        path: "/home",
        name: "home",
        component: () =>
          import(/* webpackChunkName: "about" */ "../view/home.vue"),
        meta: { title: "主页" },
      },
      {
        path: "/system/user",
        component: () =>
          import(/* webpackChunkName: "about" */ "../view/system/user.vue"),
        meta: { title: "用户管理" },
      },
      {
        path: "/system/role",
        component: () =>
          import(/* webpackChunkName: "about" */ "../view/system/role.vue"),
        meta: { title: "角色管理" },
      },
      {
        path: "/system/menu",
        component: () =>
          import(/* webpackChunkName: "about" */ "../view/system/menu.vue"),
        meta: { title: "菜单管理" },
      },
      {
        path: "/goods",
        component: () =>
          import(/* webpackChunkName: "about" */ "../view/goods/goods.vue"),
        meta: { title: "商品管理" },
      },
      {
        path: "/orders",
        component: () =>
          import(/* webpackChunkName: "about" */ "../view/orders/orders.vue"),
        meta: { title: "订单管理" },
      },
    ],
  },
  {
    path: "/sign",
    name: "sign",
    component: () => import(/* webpackChunkName: "about" */ "../view/sign.vue"),
    meta: { title: "登录/注册" },
  },
  {
    path: "/:pathMatch(.*)*",
    name: "404",
    component: () => import(/* webpackChunkName: "about" */ "../view/404.vue"),
    meta: { title: "丢失了" },
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});
router.beforeEach((to, from, next) => {
  let overlay = document.getElementById("overlay");
  if (overlay && document.body.clientWidth < 768) {
    overlay.click();
  }
  Nprogress.start();
  if (to.path == "/sign") {
    next();
  } else {
    axios.get("/api/info/user").then((res) => {
      if (res.data.code == 200) {
        next();
      } else {
        localStorage.removeItem("user")
        next({
          path: "/sign",
          query: { redirect: to.fullPath },
        });
      }
    });
  }
});
router.afterEach((to) => {
  load();
  Nprogress.done();
  document.title = to.meta.title;
});
function load() {
  setTimeout(() => {
    let loading = document.getElementById("loading");
    if (loading != null) {
      document.body.removeChild(loading);
    }
  }, 666);
}
export default router;
