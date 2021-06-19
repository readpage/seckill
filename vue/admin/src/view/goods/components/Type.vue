<template>
  <el-select v-model="value" size="mini" placeholder="请选择商品类型" clearable>
    <el-option
      v-for="item in options"
      :key="item"
      :value="item"></el-option>
  </el-select>
</template>
<script>
export default {
  props: ["value"],
  data() {
    return {
     options: [],
     val: ""
    }
  },
  methods: {
    goodsType() {
      const t = this;
      t.axios.get("/api/goods/type")
        .then(res => {
          t.options=res.data
        })
    }
  },
  created() {
    this.goodsType();
  },
  watch: {
    value: function(val) {
      this.$emit("typeEvent", val)
    }
  },
}
</script>