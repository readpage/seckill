<template>
  <div ref="charts" class="charts"></div>
</template>

<script setup>
import { onMounted, ref } from "vue"
import * as echarts from "echarts"

const charts = ref()
const option = {
  tooltip: {},
  series: {
    name: "访问来源",
    type: "pie",
    radius: "55%",
    data: [
      { value: 235, name: "视频广告" },
      { value: 274, name: "联盟广告" },
      { value: 310, name: "邮件营销" },
      { value: 335, name: "直接访问" },
      { value: 400, name: "搜索引擎" },
    ],
    roseType: "angle",
    itemStyle: {
      normal: {
        shadowBlur: 200,
        shadowCOlor: "rgba(0, 0, 0, 0.5)",
      }
    }
  }
}

onMounted(() => {
  const myChart = echarts.init(charts.value)
  myChart.setOption(option)
})
</script>

<style lang="scss">
  .charts {
    width: 400px;
    height: 300px;
  }
</style>