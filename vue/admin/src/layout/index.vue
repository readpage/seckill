<template>
  <div class="page-layout" :class="{ collapse: menuCollapse, }">
    <!-- 遮盖层 -->
    <div id="overlay" class="page-layout__mask" @click="COLLAPSE_MENU(true)"></div>
    <div class="page-layout__left">
      <!-- 侧边栏 -->
      <slider />
    </div>
    <div class="page-layout__right">
      <!-- 顶栏 -->
      <div class="page-layout__topbar">
        <topbar />
      </div>

      <!-- 页面视图 -->
      <div class="page-layout__container">
          <el-scrollbar style="height: 100vh; padding: 30px;">
            <router-view></router-view>
            <div class="box"></div>
          </el-scrollbar>
      </div>
    </div>
  </div>
</template>
<script>
import { mapGetters, mapMutations } from "vuex";
import slider from "./slider.vue";
import topbar from "./topbar.vue";
export default {
  components: {
    slider,
    topbar,
  },

  computed: {
    ...mapGetters("msg", ["menuCollapse"]),
  },

  methods: {
    ...mapMutations("msg", ["COLLAPSE_MENU"]),
  },
};
</script>
<style lang="scss" scoped>
.page-layout {
  display: flex;
  background-color: #f7f7f7;
  height: 100%;
  width: 100%;
  overflow: hidden;

  &__left {
    overflow: hidden;
    height: 100%;
    width: 250px;
    transition: left 0.2s;
  }

  &__right {
    display: flex;
    flex-direction: column;
    height: 100%;
    width: calc(100% - 255px);
  }
  &__topbar {
    margin-bottom: 10px;
  }
  &__container {
    width: 100%;
    box-sizing: border-box;
    flex: 1;
    overflow: hidden;
    margin-bottom: 10px;
    .box::after {
      content: "";
      padding: 20px;
    }
  }
  &__mask {
		position: fixed;
		left: 0;
		top: 0;
		background-color: rgba(0, 0, 0, 0.5);
		height: 100%;
		width: 100%;
		z-index: 999;
	}

  @media (max-width: 768px) {
    .page-layout__left {
      position: absolute;
      left: 0;
      z-index: 9999;
      transition: transform 0.3s cubic-bezier(0.7, 0.3, 0.1, 1),
				box-shadow 0.3s cubic-bezier(0.7, 0.3, 0.1, 1);
    }
    .page-layout__right {
      width: 100%;
    }
    &.collapse {
      .page-layout__left {
				transform: translateX(-100%);
			}

			.page-layout__mask {
        display: none;
      }
    }
  }

  @media (min-width: 768px) {
    .page-layout__left,
    .page-layout__right {
      transition: width 0.2s;
    }

    .page-layout__mask {
      display: none;
    }

    &.collapse {
      .page-layout__left {
        width: 64px;
      }

      .page-layout__right {
        width: calc(100% - 64px);
      }
    }
  }
}
</style>
