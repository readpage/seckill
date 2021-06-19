<template>
  <router-view />
</template>
<script>
import Nprogress from 'nprogress';
import "nprogress/nprogress.css";
import { mapActions } from 'vuex';
export default {
  methods: {
    ...mapActions(["addStorage"])
  },
  created() {
    if (localStorage.getItem("user")) {
      this.addStorage()
    }
  },
}
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
.carousel-box .el-image__placeholder {
  background: no-repeat center url("/static/max-loading.gif") !important;
}
.el-image__placeholder {
  height: 215px !important;
  background: no-repeat top/cover url("/static/min-loading.gif") !important;
}
.el-image__error {
  height: 215px !important;
}

.backdrop {
  background: rgba(255, 255, 255, 0.6);
  box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.1);
  backdrop-filter: blur(3px);
}

.ellipsis {
  overflow: hidden;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
}

</style>
