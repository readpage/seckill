<template>
  <div class="charts" ref="charts"></div>
</template>

<script setup lang="ts">
import * as echarts from "echarts"
import { onMounted, ref } from "vue"

const charts = ref()
const option = {
  xAxis: {
    type: "category",
    data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
  },
  yAxis: {
    type: "value"
  },
  series: [{
    data: [150, 230, 224, 218, 135, 147, 260],
    type: "line"
  }]
}

onMounted(() => {
  const myCharts = echarts.init(charts.value)
  myCharts.setOption(option)
})

</script>

<style lang="scss">
  .charts {
    width: 400px;
    height: 300px;
    margin: auto;
  }
</style>