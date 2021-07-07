<template>
  <div ref="charts" class="charts"></div>
</template>

<script setup>
import { onMounted, inject, ref, watch } from "vue"
import * as echarts from "echarts"

const info = inject("info")

const charts = ref()
const option = {
  tooltip: {},
  series: {
    name: "访问来源",
    type: "pie",
    radius: "55%",
    data: [],
    itemStyle: {
      shadowBlur: 200,
      shadowColor: "rgba(0, 0, 0, 0.5)",
    }
  }
}

onMounted(() => {
  const myChart = echarts.init(charts.value)
  watch(info, (salesType) => {
    option.series.data = info.value.salesType
    myChart.setOption(option)
  })
})
</script>

<style lang="scss">
  .charts {
    width: 400px;
    height: 300px;
  }
</style>