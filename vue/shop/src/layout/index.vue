<template>
<el-container>
  <el-header>
    <Header />
  </el-header>
  <el-scrollbar>
    <div class="layer">
      <router-view></router-view>
    </div>
    <div class="footer">
      <Footer />
    </div>
  </el-scrollbar>
  <el-backtop target=".el-scrollbar__wrap"></el-backtop>
</el-container>
</template>

<script>
import Footer from "./footer.vue";
import Header from "./header.vue";
export default {
  components: {
    Footer,
    Header,
  },
};
</script>

<style lang="scss">
.el-container {
  display: flex;
  height: 100vh;

  .layer {
    min-height: calc(100vh - 500px);
    width: calc(100% - 330px);
    margin: 0 auto;
    min-height: 480px;
  }

  .el-header {
    text-align: center;
    padding: 0;
    overflow: hidden;
    background-color: #FFFFFF;
    box-shadow: 0 2px 12px 0 rgb(0 0 0 / 10%);
  }

  .footer {
    margin-top: 40px;
    height: 300px;
    background: no-repeat 0 33%/cover url("/static/bg.jpg");
  }
}
@media (min-width: 768px ) and (max-width: 1200px) {
  .el-container {
    .el-footer {
      background-position: 0 30%;
    }
  }
}
@media (max-width: 1200px) {
  .el-container .layer {
    width: 100%;
  }
  .home-box {
    .card-box {
      margin: 20px 5% !important;
    }
  }
}

</style>
