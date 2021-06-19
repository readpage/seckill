<template>
  <router-view v-if="showRouter" />
</template>
<script>
import Nprogress from 'nprogress';
import "nprogress/nprogress.css";
import { mapActions } from 'vuex'
export default {
  provide() {
    return {
      reload: this.reload
    }
  },
  data() {
    return {
      showRouter: true
    }
  },
  methods: {
    reload() {
      Nprogress.start()
      this.showRouter = false
      // Vue 实现响应式并不是数据发生变化之后 DOM 立即变化，而是按一定的策略进行 DOM 的更新。
      // $nextTick 是在下次 DOM 更新循环结束之后执行延迟回调，在修改数据之后使用 $nextTick，则可以在回调中获取更新后的 DOM
      this.$nextTick(function() {
        this.showRouter = true
        Nprogress.done()
      })
    },
    ...mapActions(["addStorage"])
  },
  created() {
    // if (sessionStorage.getItem("store") ) {
    //   this.$store.replaceState(Object.assign({},this.$store.state,JSON.parse(sessionStorage.getItem("store"))))
    // }
    // window.addEventListener("beforeunload",()=>{
    //   sessionStorage.setItem("store",JSON.stringify(this.$store.state))
    // })
    if (localStorage.getItem("user")) {
      this.addStorage()
    }
  },
};
</script>
<style lang="scss">
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
:focus {
  outline: none;
}
#nprogress .bar {
  background: blueviolet !important; //自定义颜色
}
#loading {
  position: fixed;
  display: flex;
  justify-content: center;
  align-items: center;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 2000;
  background-color: #ffffff;
}
#loading .lottie-player {
  position: relative;
  top: -10%;
}
html,
body,
#app,
.el-scrollbar__view {
  height: 100%;
}
</style>
