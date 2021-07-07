<template>
  <div ref="charts" class="charts"></div>
</template>

<script setup lang="ts">
import * as echarts from "echarts";
import { onMounted, ref } from "vue";

const charts = ref();
const option = {
  title: {
    text: "柱状图",
  },
  tooltip: {},
  legend: {
    data: ["销量"],
  },
  xAxis: {
    data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"],
  },
  yAxis: {},
  series: [
    {
      name: "销量",
      type: "bar",
      data: [5, 20, 36, 10, 10, 20],
    },
  ],
};

onMounted(() => {
  const myChart = echarts.init(charts.value);
  myChart.setOption(option);
});
</script>

<style lang="scss">
.charts {
  width: 400px;
  height: 300px;
  margin: auto;
}
</style>
