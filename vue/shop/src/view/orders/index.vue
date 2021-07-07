<template>
  <el-card>
      <el-table :data="tableData"
        stripe
        :header-cell-style="{ background: '#f5f7fa', color: '#606266'}"
        height="500"
        v-loading="loading"
        element-loading-text="拼命加载中"
        element-loadding-spinner="el-icon-loading"
        max-height="520">
        <el-table-column type="expand" label="详情">
          <template #default="props">
            <el-descriptions title="订单信息">
              <el-descriptions-item label="订单号">{{props.row.number}}</el-descriptions-item>
              <el-descriptions-item label="收货人">{{props.row.username}}</el-descriptions-item>
              <el-descriptions-item label="手机号码">{{props.row.phone }}</el-descriptions-item>
              <el-descriptions-item label="商品名称">{{ props.row.name }}</el-descriptions-item>
              <el-descriptions-item label="商品数量">{{ props.row.count }}</el-descriptions-item>
              <el-descriptions-item label="商品金额">{{ props.row.money }}</el-descriptions-item>
              <el-descriptions-item label="支付状态"><el-tag :type="props.row.status=='已支付'?'success':'danger'">{{ props.row.status}}</el-tag></el-descriptions-item>
            </el-descriptions>
          </template>
        </el-table-column>
        <el-table-column label="订单号" prop="number" width="200"></el-table-column>
        <el-table-column label="收货人" prop="username" width="120" align="center"></el-table-column>
        <el-table-column label="手机号码" prop="phone" width="120"></el-table-column>
        <el-table-column label="单价" prop="price" align="center" width="150">
          <template #default="scope">
            <template  v-if="scope.row.discounts=='原价'">
              <span>{{scope.row.current}}￥</span>
            </template>
            <template v-else>
              <el-space :size="10" direction="vertical">
                <span style="text-decoration:line-through;" >{{scope.row.price }} 原价</span>
                <span style="color: red">{{scope.row.current }} 现价</span>
              </el-space>
          </template>
          </template>
        </el-table-column>
        <el-table-column label="折扣" width="80">
          <template #default="scope">
            <el-tag type="primary">{{ scope.row.discounts  }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="状态" width="80">
          <template #default="scope">
           <el-tag :type="scope.row.status=='已支付'?'success':'danger'">{{ scope.row.status}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="购买时间" prop="createDate" width="180"></el-table-column>
      </el-table>
      <el-pagination layout="total, sizes, prev, pager, next, jumper"
        small
        :total="total"
        :page-sizes="[5, 10, 20, 40]"
        :page-size="pageSize"
        background
        @current-change="handleCurrentChange"
        @size-change="handleSizeChange"
      ></el-pagination>
  </el-card>
</template>

<script>
export default {
  data() {
    return {
      tableData: [],
      pageSize: 5,
      pageNum: 1,
      total: 0,
      loading: true,
      paramName: "",
      paramNumber: "",
      deleteDisable: true,
      multipleSelection: [],
      sales: 0,
      LOptions: {
        text: "拼命加载中...",
        spinner: "el-icon-loading"
      }
    }
  },
  methods: {
    page() {
      const t = this;
      t.loading = true;
      t.axios.get("/api/orders/personPage/" +t.pageNum+ "/" +t.pageSize)
        .then(res => {
          res.data.list.forEach(item => {
            item.status= item.status==1?"已支付":"未支付"
            let discounts=item.discounts
            let current=discounts*item.price
            let money =current*item.count
            item.money = money.toFixed(2)
            item.current=current.toFixed(2)
            if (discounts==1) {
              item.discounts = "原价"
            } else {
              item.discounts = discounts*10 + "折"
            }
            let reg=/^(\d{3})\d{4}(\d{4})$/;
            item.phone=item.phone.replace(reg, "$1****$2")
          });
          t.tableData=res.data.list;
          t.total = res.data.total;
          t.loading = false;
        })
    },
    handleSizeChange(val) {
      this.pageSize=val;
      this.page();
    },
    handleCurrentChange(val) {
      this.pageNum=val;
      this.page();
    },
  },
  created() {
    this.page()
  },
}
</script>

<style lang="scss">
  .el-card {
    margin-top: 20px;
  }
</style>