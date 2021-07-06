<template>
  <ul class="top">
    <li class="ab">
      <el-card>
        <span>总销售额 ￥15920</span>
      </el-card>
    </li>
    <li>
      <el-card>
        <span>用户数量 8846</span>
      </el-card>
    </li>
    <li>
      <el-card>
        <span>3</span>
      </el-card>
    </li>
    <li>
      <el-card>
        <span>4</span>
      </el-card>
    </li>
    <li>
      <Angle />
    </li>
    <li>
      <Bar />
    </li>
    <li>
      <Line />
    </li>
  </ul>

</template>

<script setup>
import { onMounted, reactive, ref } from "vue";
import anime from "animejs";
import Angle from "../components/echart/Angle.vue"
import Bar from "../components/echart/Bar.vue"
import Line from "../components/echart/Line.vue"

onMounted(() => {
  anime({
    targets: ".top span",
    innerHTML: (el) => {
      return [0, el.innerHTML];
    },
    duration: 2000,
    round: 1,
    //越来越快
    easing: "easeInExpo",
  });
});
</script>

<style lang="scss">
ul.top {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 20px;
  li:nth-child(5), li:nth-child(7) {
    grid-column: 1 / 3
  }
  li:nth-child(6) {
    grid-column: 3 / 5
  }
  li {
    list-style: none;
    .el-card {
      height: 150px;
    }
  }
}

</style>
