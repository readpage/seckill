<template>
<div class="content-footer">
  <div class="top">
    <el-space :size=20>
      <el-link :underline="false">企业服务</el-link>
      <el-link :underline="false">关于我们</el-link>
      <el-link :underline="false">联系我们</el-link>
      <el-link :underline="false">帮助中心</el-link>
      <el-link :underline="false">代码托管</el-link>
      <el-link :underline="false">友情链接</el-link>
    </el-space>
  </div>
  <div class="bottom">
    <p>Copyright&nbsp;&copy;&nbsp;2021 f1dao.com &nbsp;京ICP备 666号-1 &nbsp;京公网备666666号 &nbsp;营业执照</p>
    <p>&nbsp;{{ currentTime }} &nbsp; 小破站已经运行了{{ duration }}</p>
  </div>
</div>
</template>

<script>
export default {
  data() {
    return {
      currentTime: "",
      duration: "",
      downTime: "",
    }
  },
  methods: {
    handlerDuration() {
      const diffTime = dayjs.duration(dayjs() - dayjs("2021-05-27 18:00:00"));
      const day = diffTime.days(); //天
      const hours = diffTime.hours(); //小时
      const minutes = diffTime.minutes(); //分钟
      const seconds = diffTime.seconds(); //秒
      this.duration = `${day}天${hours}小时${minutes}分${seconds}秒`
    },
  }, 
  created() {
    setInterval(() => {
      this.currentTime = dayjs().format("YYYY-MM-DD HH:mm:ss")
      this.handlerDuration()
    }, 1000);
    console.log(dayjs("2021-05-29 18:00:32").fromNow())
  },
}
</script>
<style lang="scss">
.content-footer {
  height: 300px;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  flex-direction: column;
  .el-link {
    color: #000000 !important;
  }
  .bottom {
    font-size: 15px;
    font-family: Arial, Helvetica, sans-serif;
    p { 
      margin: 8px;
    }
  }
}
</style>
