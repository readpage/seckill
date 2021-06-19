<template>
<el-select v-model="value" filterable remote clearable placeholder="请输入商品名称关键词" :remote-method="remoteMethod" size="mini" :loading="loading">
  <el-option v-for="(item) in options" :key="item" :value="item">
  </el-option>
</el-select>
</template>

<script>
export default {
  data() {
    return {
      options: [],
      value: "",
      loading: false,
    }
  },
  methods: {
    remoteMethod(query) {
      const t = this
      t.loading = true;
      t.axios.get("/api/orders/likeName?name=" + query)
        .then(res => {
          t.options = res.data;
          t.loading = false;
        })
    },
  },
  created() {
    this.remoteMethod("");
  },
  watch: {
    value: function (val) {
      if (!val) {
        this.remoteMethod("");
      }
      this.$emit("nameEvent", val)
    }
  }
}
</script>

<style>

</style>
