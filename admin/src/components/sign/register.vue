<template>
<el-card class="card-form">
  <template #header>
    <div class="header">
      <span class="line"></span>
      <span>注册</span>
      <span class="line"></span>
    </div>
  </template>
  <el-form :model="ruleForm" label-width="90px" ref="ruleFormRef" :rules="rules">
    <el-form-item label="用户名:" prop="username">
      <el-input size="small" v-model="ruleForm.username" prefix-icon="el-icon-user-solid" placeholder="请输入用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码:" prop="password">
      <el-input show-password v-model="ruleForm.password" size="small" prefix-icon="el-icon-lock" placeholder="请输入密码"></el-input>
    </el-form-item>
    <el-form-item label="确认密码:" prop="checkPass">
      <el-input show-password prefix-icon="el-icon-lock" size="small" v-model="ruleForm.checkPass" placeholder="请再输入一遍密码"></el-input>
    </el-form-item>
    <el-form-item label="手机号码" prop="phone" placeholder="请输入手机号码" clearable>
      <el-input v-model.number="ruleForm.phone" prefix-icon="el-icon-mobile-phone" size="small"></el-input>
    </el-form-item>
    <el-form-item>
      <el-space :size="20">
        <el-button size="mini" type="primary" @click="register">注册</el-button>
        <el-button size="mini" @click="reset">重置</el-button>
      </el-space>
    </el-form-item>
  </el-form>
</el-card>
</template>

<script>
export default {
  data() {
    const validatePass = (rule, value, callback) => {
      if (!value) {
        callback("请在次输入密码😂")
      } else if (value != this.ruleForm.password) {
        callback("两次输入密码不一致😂")
      } else {
        callback()
      }
    }
    const checkPhone = (rule, value, callback) => {
      const phoneReg = /^1[3456789]\d{9}$/
      if (!value) {
        return callback("电话号码不能为空😂")
      }
      // isNaN()的缺点就在于 null、空格以及空串会被按照0来处理
      if (!Number.isInteger(value)) {
        callback("请输入数字值😂")
      } else {
        if (phoneReg.test(value)) {
          callback()
        } else {
          callback("电话号码格式不正确😂")
        }
      }
    }
    const checkUsername = (rule, value, callback) => {
      if (!value) {
        return callback("请输入用户名😂")
      }
      this.axios.get("/api/user/selectIsUsername?username=" + value)
        .then(res => {
          console.log("ad")
          if (res.data==true) {
            console.log("hel")
            callback("用户名已经存在😂")
          } else {
            callback()
          }
        }).catch(err => {
          callback("404");
        })
    }
    return {
      ruleForm: {
        username: "",
        password: "",
        checkPass: "",
        phone: "",
        isUsername: false,
      },
      rules: {
        username: {
          required: true,
          validator: checkUsername,
          trigger: "blur"
        },
        password: {
          required: true,
          message: "请输入密码:😂",
        },
        checkPass: {
          required: true,
          validator: validatePass,
          trigger: "blur"
        },
        phone: {
          required: true,
          validator: checkPhone,
          trigger: "blur"
        },
      },
    };
  },
  methods: {
    reset() {
      this.$refs.ruleFormRef.resetFields();
    },
    register() {
      this.$refs.ruleFormRef.validate((valid) => {
        if (valid) {
          const t = this;
          let param = JSON.parse(JSON.stringify(t.ruleForm))
          delete param.checkPass
          t.axios.post("/api/user/register", param)
            .then((result) => {
              t.$notify.info({
                title: "消息",
                message: result.data.message
              })
              location.reload();
            }).catch((err) => {
              t.$message.error("出错了😭");
            });
        }
      })
    },
  },
};
</script>
