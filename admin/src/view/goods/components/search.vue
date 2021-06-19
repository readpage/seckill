<template>
  <el-space :size="10">
    <el-autocomplete
      v-model="search"
      size="mini"
      prefix-icon="el-icon-search"
      :fetch-suggestions="querySearchAsync"
      placeholder="请输入内容"
      clearable
      highlight-first-item>
    </el-autocomplete>
    <el-button size="mini" type="info" @click="querySearch">搜索</el-button>
  </el-space>
</template>

<script>
export default {
  props: ["type"],
  data() {
    return {
      search: "",
      results: [],
    }
  },
  methods: {
    querySearchAsync(query, callback) {
      var results = this.results;
      const t = this;
      if (query) {
        t.axios.get("/api/goods/like?name=" + query+ "&type=" +t.type)
          .then(res => {
            t.results = res.data.map(item => {
              return { value: item.name }
            })
            callback(t.results)
          }).catch(err => {
            t.$message.error("出错了😂")
          })
      } else {
        this.querySearch();
        t.axios.get("/api/goods/page/1/4?type=" +t.type)
          .then(res => {
            results = res.data.list;
            results.forEach(el => {
              el.value = el.name;
            });
            callback(results)
          }).catch(err => {
            t.$message.error("出错了😂")
          })
      }
    },
    querySearch() {
      this.$emit("searchEvent", this.search)
    },
  },
  watch: {
    search: function(val) {
      if (!val) {
        this.querySearch()
      }
    }
  }
}
</script>
