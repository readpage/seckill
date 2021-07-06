<template>
  <div class="app-slider">
    <div class="app-slider__logo">
      <lottie-player class="lottie-player" src="/static/programmer.json"  background="transparent"  speed="2.2"  style="width: 145px; height: 55px;" loop autoplay></lottie-player>
    </div>
    <div class="app-slider__menu">
      <el-menu
        class="aside-menu"
        :default-active="$route.path"
        background-color="#304156"
        text-color="#bfcbd9"
        active-text-color="#409eff"
        router
        style="height: 100%"
        :collapse="menuCollapse"
      >
        <template v-for="item in items">
          <template v-if="item.subs">
            <el-submenu :index="item.index" :key="item.index">
              <template #title>
                <i :class="item.icon"></i>
                <span>{{ item.title }}</span>
              </template>
              <el-menu-item
                v-for="subItem in item.subs"
                :index="subItem.index"
                :key="subItem.index"
              >
                <i :class="subItem.icon"></i>
                <template #title>
                  {{ subItem.title }}
                </template>
              </el-menu-item>
            </el-submenu>
          </template>
          <template v-else>
            <el-menu-item :index="item.index" :key="item.index">
              <i :class="item.icon"></i>
              <template #title>
                <span>
                  {{ item.title }}
                </span>
              </template>
            </el-menu-item>
          </template>
        </template>
      </el-menu>
    </div>
  </div>
</template>
<script>
import { mapGetters, mapMutations } from "vuex";
export default {
  data() {
    return {
      items: [
        {
          icon: "el-icon-s-home",
          index: "/home",
          title: "系统首页",
        },
        {
          icon: "el-icon-setting",
          index: "/system",
          title: "系统管理",
          subs: [
            {
              index: "/system/user",
              title: "用户管理",
              icon: "el-icon-user-solid",
            },

          ],
        },
        {
          title: "订单管理",
          index: "/orders",
          icon: "el-icon-s-order",
        },
        {
          title: "商品管理",
          index: "/goods",
          icon: "el-icon-s-goods",
        },
      ],
    };
  },
  computed: {
    ...mapGetters("msg", ["menuCollapse"]),
  },
  methods: {
    ...mapMutations("msg", ["UpdateCollapse"]),
    aside() {
      
      
      window.onresize = () => {
        let screenWidth = document.body.clientWidth;
        if (screenWidth <= 768) {
          this.UpdateCollapse(true);
        } 
      };
    },
  },
  mounted() {
    if (document.body.clientWidth > 768) {
      this.UpdateCollapse(false)
    }
    this.aside();
  },
};
</script>
<style lang="scss" scoped>
.app-slider {
  height: 100%;
  background-color: #304156;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
  &__logo {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 80px;
    cursor: pointer;
  }

  img {
    height: 30px;
    width: 30px;
  }

  &__menu {
    height: calc(100% - 80px);
  }
}
.el-menu {
  border: 0;
}
</style>
