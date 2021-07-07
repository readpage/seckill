<template>
  <div class="topbar">
    <div class="topbar__logo">
      <lottie-player class="lottie-player" src="/static/shopping-list.json"  background="transparent"  speed="2.2"  style="width: 200px; height: 60px;" loop autoplay></lottie-player>
    </div>
    <div class="topbar__menu">
      <el-menu 
      mode="horizontal"
      :default-active="$route.path"
      router
      text-color="#000000"
      active-text-color="#409eff">
      <template v-for="item in items">
        <template v-if="item.subs">
          <el-submenu :index="item.index" :key="item.index">
            <template #title>
              <i :class="item.icon"></i>
              <span>{{ item.title }}</span>
            </template>
            <el-menu-item v-for="subItem in item.subs"
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
              <span>{{ item.title }}</span>
            </template>
          </el-menu-item>
        </template>
      </template>
    </el-menu>
    </div>
    <search @search-event="querySearch"/>
    <div class="topbar__user">
      <el-badge :value="totalCount">
        <el-button type="danger" circle size="mini"  icon="el-icon-shopping-cart-full" @click="this.$router.push('/cart')"></el-button>
      </el-badge>
      <el-dropdown trigger="click" class="user">
        <span class="el-dropdown-link">
          <span class="name">{{ user.username }}</span>
          <el-avatar src="https://i.gtimg.cn/club/item/face/img/2/16022_100.gif"></el-avatar>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="sign">登录/注册</el-dropdown-item>
            <el-dropdown-item @click="exit">退出</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>
<script>
import {mapActions, mapGetters, mapMutations, mapState} from "vuex"
import search from '../components/search.vue'
export default {
  components: {
    search
  },
  data() {
    return {
      items: [
        {
          icon: "el-icon-s-home",
          index: "/home",
          title: "首页",
        },
        {
          title: "抢购",
          index: "/shop",
          icon: "el-icon-s-goods",
        }
      ],
    }
  },
  methods: {
    querySearch(val) {
      this.updateUrlName(val)
    },
    sign() {
      this.$router.push("/sign")
    },
    
    exit() {
      const t = this
      t.axios.get("/api/logout")
				.then(res => {
					localStorage.removeItem("user")
					this.$router.replace("/sign")
				})
    },
    ...mapActions(["updateUrlName"])
  },
  computed: {
    ...mapGetters(["totalCount"]),
    ...mapState(["user"]),
  },
}
</script>
<style lang="scss">
.topbar {
  display: flex;
  justify-content: space-between;
  color: #fff;
  height: 60px;
  
  &__logo {
    width: 200px;
    
  }
  &__menu {
    flex: 1;
  }

  &__user {
    display: flex;
    align-items: center;
    justify-content: space-evenly;
    width: 300px;
    .user {
      cursor: pointer;
    }
    .name {
      white-space: nowrap;
      margin-right: 15px;
    }
    .el-dropdown-link {
      display: flex;
      align-items: center;
    }
  }
}
.el-menu i {
  color: #000000;
}
.el-menu span {
  font-weight: bold;
}
</style>