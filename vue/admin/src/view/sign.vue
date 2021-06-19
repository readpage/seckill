<template>
  <div class="container" :class="{ 'sign-up-mode': signModel }">
    <div class="forms-container">
      <div class="signin-signup">
        <div class="sign-in-form sign-grid">
          <login />
        </div>
        <div class="sign-up-form sign-grid">
          <register />
        </div>
      </div>
    </div>
    <div class="panels-container">
      <div class="panel left-panel">
        <div class="content">
          <h3>新来的?</h3>
          <p>我的心，我的心将会奉献给你。</p>
          <el-button type="primary" @click="signSwitch" plain round
            >注&nbsp;册</el-button
          >
        </div>
        <img src="../assets/img/log.svg" class="image" alt="" />
      </div>
      <div class="panel right-panel">
        <div class="content">
          <h3>我们中的一个?</h3>
          <p>我为你祈祷，愿你永远幸福。我们的工作和生活。</p>
          <el-button type="primary" round plain @click="signSwitch"
            >登&nbsp;录</el-button
          >
        </div>
        <img src="../assets/img/register.svg" class="image" alt="" />
      </div>
    </div>
  </div>
</template>
<script>
import login from "../components/sign/login.vue";
import register from "../components/sign/register.vue";
export default {
  components: {
    login,
    register,
  },
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      signModel: false,
    };
  },
  methods: {
    signSwitch() {
      this.signModel = !this.signModel;
    },
  },
};
</script>
<style lang="scss" scoped>
@import "../assets/css/sign.css";
.header {
  text-align: center;
  color: #888888;
}
.line {
  border-top: 1px solid #cccccc;
  width: 100px;
  display: inline-block;
  vertical-align: middle;
}
.signin-signup .card-form {
  width: 80%;
  min-width: 350px;
  height: 400px;
  margin: 20px;
}
.card-form .el-input {
  max-width: 300px;
  min-width: 200px;
}
</style>
