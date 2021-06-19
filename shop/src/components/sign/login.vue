<template>
<el-card class="card-form">
  <template #header>
    <div class="header">
      <span class="line"></span>
      <span>登录</span>
      <span class="line"></span>
    </div>
  </template>
  <el-form :model="user" label-width="80px" ref="userRef" :rules="rules">
    <el-form-item label="用户名:" prop="username">
      <el-input size="small" v-model="user.username" prefix-icon="el-icon-user-solid" placeholder="请输入用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码:" prop="password" placeholder="请输入密码">
      <el-input show-password v-model="user.password" size="small" prefix-icon="el-icon-lock"></el-input>
    </el-form-item>
    <el-form-item>
      <el-space :size="20">
        <el-button size="mini" type="primary" @click="login">登录</el-button>
        <el-button size="mini" @click="reset">重置</el-button>
      </el-space>
    </el-form-item>
  </el-form>
</el-card>
</template>

<script>
import { ElLoading } from 'element-plus';
import {
  mapActions,
  mapMutations,
  mapState
} from 'vuex';
export default {
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      options: {
        text: "拼命加载中...",
        spinner: "el-icon-loading"
      },
      rules: {
        username: {
          required: true,
          message: "请输入用户名😂"
        },
        password: {
          required: true,
          message: "请输入密码:😂"
        },
      },
    };
  },
  methods: {
    reset() {
      this.$refs.userRef.resetFields();
    },
    login() {
      this.$refs.userRef.validate((valid) => {
        if (valid) {
          const t = this;
          let loading = ElLoading.service(this.options)
          const param = new FormData();
          param.append("username", this.user.username);
          param.append("password", this.user.password);
          t.axios
            .post("/api/login", param)
            .then((result) => {
              if (result.data.code == 200) {
                t.$notify.success({
                  title: "消息",
                  message: result.data.message,
                });
                t.updateUser(result.data.data)
                if (t.$route.query.redirect) {
                  let redirect = t.$route.query.redirect;
                  t.$router.replace(redirect);
                } else {
                  t.$router.replace("/");
                }
              } else {
                t.$notify.error({
                  title: "错误!",
                  message: result.data.message,
                });
              }
              setTimeout(() => {
                loading.close();
              }, 1000);
            }).catch((err) => {
              loading.close();
              t.$message.error("请求失败!");
            });
        }
      });
    },
    ...mapMutations(["updateUser"]),
  },
};
</script>
