<template>
<el-button type="warning" size="mini" icon="el-icon-s-goods" :disabled="updateDisabled" @click="handleUpdate">抢购</el-button>
<el-dialog title="抢购策略" v-model="visible" center width="600px">
  <el-form :model="shopForm"
    label-width="80px">
    <el-form-item label="抢购时间:">
      <el-date-picker
        v-model="shopForm.time"
        type="datetimerange"
        :shortcuts="shortcuts"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期">
      </el-date-picker>
    </el-form-item>
    <el-form-item label="状态:">
      <el-switch v-model="shopForm.status"
        active-color="#13ce66"
        inactive-color="#ff4949"
        active-text="运行"
        inactive-text="停止"
        :active-value="1"
        :inactive-value="0">
      </el-switch>
    </el-form-item>
    <el-form-item>
      <el-space :size="40">
        <el-button size="small" type="primary" @click="shopSubmit">确定</el-button>
        <el-button size="small" @click="visible=false">取消</el-button>
      </el-space>
    </el-form-item>
  </el-form>
</el-dialog>
</template>

<script>
import { ElLoading } from "element-plus";

export default {
  inject: ["reload"],
  props: ["updateDisabled", "multipleSelection"],
  data() {
    return {
      shortcuts: [{
        text: '最近一周',
        value: (() => {
          const end = new Date();
          const start = new Date();
          start.setTime(start.getTime() - 3600 * 1000 * 24 * 7 / 2);
          end.setTime(end.getTime() + 3600 * 1000 * 24 * 7 / 2);
          return [start, end]
        })()
      }, {
        text: '最近一个月',
        value: (() => {
          const end = new Date();
          const start = new Date();
          start.setTime(start.getTime() - 3600 * 1000 * 24 * 30 / 2);
          end.setTime(end.getTime() + 3600 * 1000 * 24 * 30 / 2);
          return [start, end]
        })()
      }, {
        text: '最近三个月',
        value: (() => {
          const end = new Date();
          const start = new Date();
          start.setTime(start.getTime() - 3600 * 1000 * 24 * 90 / 2);
          end.setTime(end.getTime() + 3600 * 1000 * 24 * 90 / 2);
          return [start, end]
        })()
      }],
      visible: false,
      shopForm: {
        time: "",
        status: 1,
        gid: "",
      },
      LOptions: {
        text: "拼命加载中...",
        spinner: "el-icon-loading"
      }
    }
  },
  methods: {
    handleUpdate() {
      let data = JSON.parse(JSON.stringify(this.multipleSelection.goodsSeckill))
      let shop = {}
      shop.time = [data.startDate, data.endDate]
      shop.status = data.status
      shop.gid = data.gid
      this.shopForm = shop
      this.visible = true
    },
    shopSubmit() {  
      const t = this;
      let loading = ElLoading.service(this.LOptions)
      let data =JSON.parse(JSON.stringify(this.shopForm))
      let param = data
      param.startDate = dayjs(data.time[0]).format("YYYY-MM-DD HH:mm:ss")
      param.endDate = dayjs(data.time[1]).format("YYYY-MM-DD HH:mm:ss")
      delete param.time
      t.axios.post("/api/goods/add-seckill", param)
        .then(res => {
          t.visible = false
          loading.close()
          t.$message.success(res.data.message)
          t.reload()
        }).catch(err => {
          loading.close()
          t.$message.error("出错了!")
        })
    }
  },
  watch: {
    shopForm: val => {
      console.log(val)
    }
  },
}
</script>
