<template>
<el-space :size="10">
  <el-autocomplete v-model="search" size="mini" prefix-icon="el-icon-search" :fetch-suggestions="querySearchAsync" placeholder="请输入订单编号id" clearable highlight-first-item>
  </el-autocomplete>
  <el-button size="mini" type="info" @click="querySearch">搜索</el-button>
</el-space>
</template>

<script>
export default {
  props: ["name"],
  data() {
    return {
      search: "",
      results: [],
    }
  },
  methods: {
    querySearchAsync(query, callback) {
      const t = this;
      var results = t.results;
      t.axios.get("/api/orders/likeNumber?number=" + query+ "&name=" +t.name)
        .then(res => {
          results = res.data.map(item => {
            return {
              value: item
            }
          })
          callback(results)
        })
    },

    querySearch() {
      this.$emit("numberEvent", this.search)
    }
  },
  watch: {
    search: function (val) {
      if (!val) {
        this.querySearch()
      }
    }
  },
}
</script>
