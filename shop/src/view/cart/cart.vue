<template>
<el-card class="box">
  <el-empty v-if="!cartData.length" description="没有数据🤣"></el-empty>
  <div v-else>
    <div style="margin-bottom: 20px">
      <el-space :size="10">
        <el-popconfirm title="你确定要清空购物车吗" @confirm="clearCart">
          <template #reference>
            <el-button type="danger" size="mini" icon="el-icon-delete">清空</el-button>
          </template>
        </el-popconfirm>
      </el-space>
    </div>
    <el-table :data="cartData" stripe :header-cell-style="{ background: '#f5f7fa', color: '#606266' }" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column label="名称" prop="name"></el-table-column>
      <el-table-column label="图片">
        <template #default="scope" width="200">
          <el-image :src="scope.row.img"></el-image>
        </template>
      </el-table-column>
      <el-table-column label="数量">
        <template #default="scope">
          <el-input-number :min="1" @change="handleChangeCount(scope.row)" v-model="scope.row.count" size="small"></el-input-number>
        </template>
      </el-table-column>
      <el-table-column label="单价">
        <template #default="scope">
          <i class="el-icon-wallet"></i>
          <span style="margin-left: 10px">{{ scope.row.price }}</span>
        </template>
      </el-table-column>
      <el-table-column label="金额">
        <template #default="scope">
          <span style="margin-left: 10px">{{ itemPrice(scope.row) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="店铺" prop="store"></el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-popconfirm icon="el-icon-info" title="确定删除吗?" @confirm="deleteShop(scope.row)">
            <template #reference>
              <el-button type="danger" size="mini">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div class="totalPrice">
      <el-space>
        <el-tag>总价:￥{{totalPrice}}</el-tag>
        <el-button type="danger" size="mini" @click="buy">购买</el-button>
      </el-space>
    </div>
  </div>
</el-card>
</template>

<script>
import {
  mapActions,
  mapGetters,
  mapState
} from "vuex"
export default {
  methods: {
    handleSelectionChange(val) {

    },
    itemPrice(product) {
      return product.price * product.count
    },
    handleChangeCount(product) {
      this.updateCart(product)
    },
    ...mapActions({
      addCart: "addToCart",
      updateCart: "updateToCart",
      clearCart: "clearToCart",
      deleteShop: "deleteToShop"
    }),
    buy() {
      const product=JSON.parse(JSON.stringify(this.cart))
      product.forEach(item => {
        item.gid=item.id
        delete item.id
      })
      console.log(product)
      
      const t = this
      this.axios.post("/api/orders/add/" +this.user.id, product)
        .then((res) => {
          if (res.data.code==200) {
            this.$message.success(res.data.message)
          } else {
            this.$message.error(res.data.message)
          }
          this.clearCart();
        }).catch((err) => {
          t.$message.error("出错了!")
        })
      
    }
  },
  computed: {
    ...mapState(["cart", "user",]),
    ...mapGetters({
      cartData: "getCart",
    }),
    ...mapGetters(["totalPrice"])
  },
};
</script>

<style lang="scss" scoped>
.totalPrice {
  display: flex;
  flex-direction: row-reverse;
  margin: 20px;
}

.box {
  position: relative;
  margin-top: 10vh;
}
</style>>
