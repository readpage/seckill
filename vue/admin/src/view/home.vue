<template>
  <ul class="top">
    <li>
      <el-card style="background: rgb(249, 89, 89);">
        <span>总销售额:{{info.sales}}</span>
      </el-card>
    </li>
    <li>
      <el-card style="background: rgb(133, 149, 244);">
        <span>用户数量:{{info.userCount}}</span>
      </el-card>
    </li>
    <li>
      <el-card style="background: rgb(254, 187, 80);">
        <span>商品数量:{{info.goodsCount}}</span><br>
        <span>库存数量:{{info.goodsStockCount}}</span>
      </el-card>
    </li>
    <li>
      <el-card style="background: #8e44ad">
        <span>订单数量:{{info.ordersCount}}</span>
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
import { onMounted, reactive, provide, ref, toRefs, watchEffect} from "vue";
import anime from "animejs";
import Angle from "../components/echart/Angle.vue";
import Bar from "../components/echart/Bar.vue";
import Line from "../components/echart/Line.vue";
import axios from "axios"

const state = reactive({
  info: {
    userCount: 0,
    goodsCount: 0,
    goodsStockCount: 0,
    ordersCount: 0,
    sales: 0,
    salesType: [],
  }
})
const {info} = toRefs(state)
provide("info", info)
axios.get("/api/info/data").then((res) => {
  state.info = res.data 
});
</script>

<style lang="scss">
ul.top {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 20px;
  li:nth-child(5),
  li:nth-child(7) {
    grid-column: 1 / 3;
  }
  li:nth-child(6) {
    grid-column: 3 / 5;
  }
  li {
    list-style: none;
    span {
      color: #fff;
      font-size: 14px;
    }
    .el-card {
      height: 150px;
    }
  }
}
</style>
