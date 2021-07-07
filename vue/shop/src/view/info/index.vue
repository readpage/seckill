<template>
  <el-card>
    <el-form :model="form" label-width="80px">
      <el-form-item label="名称:">
        <el-input size="small" v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="密码:">
        <el-input show-password size="small" v-model="form.password"></el-input>
      </el-form-item>
      <el-form-item label="手机号码:">
        <el-input size="small" v-model="form.phone"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button size="small" type="primary" @click="update">保存修改</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script setup>
import { reactive, toRefs, watchEffect } from "vue"
import { useRouter } from "vue-router";
import axios from "axios"
import { ElMessage } from "element-plus"

const state = reactive({
  form: {
    username: "",
    password: "",
    phone: ""
  }
})
const router = useRouter()
const { form } = toRefs(state)
axios.get("/api/info/user")
.then(res => {
  if (res.data.code!=200) {
    throw res.data
  }
  form.value = res.data.data
}).catch( err => {
  ElMessage.error(err.message)
})

function update() {
  axios.put("/api/info/updateUser", form.value)
    .then(res => {
      if (res.data.code!=200) {
        throw res.data
      }
      watchEffect (() => {
        console.log(form.value.username);
        axios.get("/api/logout")
          .then(res => {
            localStorage.removeItem("user")
            router.replace("/sign")
          })
      })
      ElMessage.success(res.data.message)
    }).catch( err => {
      ElMessage.error(err.message)
    })
}
</script>

<style lang="scss" scoped>
  .el-card {
    margin: 20px;
  }
  .el-input {
    width: 400px;
  }

@media (min-width: 768px) and (max-width: 1200px) {
  .el-card {
    width: calc(100vw - 100px)
  }
}
@media (max-width: 768px) {
  .el-card {
    width: calc(100vw - 90px)
  }
  .el-input {
    width: 300px;
  }
}
</style>