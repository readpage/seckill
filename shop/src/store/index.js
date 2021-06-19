import { createStore } from "vuex";
import axios from "axios";
import { ElMessage} from "element-plus"

export default createStore({
  state: {
    user: {
      username: "未登录"
    },
    cart: [],
    goods: {pageSize: 10},
    loading: true,
    urlName: "",
  },
  getters: {
    //获取购物车列表
    getCart: state => {
      return state.cart.map(({id, count}) => {
        let product = state.goods.find(n => n.id == id);
        if (product) {
          // ...三点的用法
          //对数组和对象而言，就是将运算符后面的变量里东西每一项拆下来
          return { ...product, count}
        }
      })
    },
    // 获取总数量
    totalCount: (state) => {
      let total = 0;
      state.cart.map(n => {
        total += n.count;
      })
      return total;
    },
    //计算总价格
    totalPrice: (state, getters) => {
      let totalPrice=0;
      getters.getCart.map(n => {
        totalPrice += n.count*n.price
      })
      return totalPrice
    },
  },
  mutations: {
    updateUser(state, newVal) {
      state.user = newVal;
      localStorage.setItem("user", JSON.stringify(newVal))
    },
    updateGoods(state, newVal) {
      state.goods = newVal;
      state.loading = false;
      state.goods.loading2 = false;
    },
    //加入购物车
    addCart(state, {id}) {
      let record = state.cart.find(n => n.id == id);
      if (!record) {
        state.cart.unshift({id, count:1})
      } else {
        record.count++
      }
    },
    //修改商品数量
    updateCart(state, {id, count}) {
      let record = state.cart.find(n => n.id == id);
      record.count = count
    },
    //删除单个物品
    deleteShop(state, product) {
      state.cart.forEach((item, i) => {
        if (item.id == product.id) {
          state.cart.splice(i, 1)
          ElMessage.success(`${product.name}删除成功!`)
        }
      })
    },
    //清空购物车
    clearCart(state) {
      state.cart=[]
    },
    // 添加localStorage数据
    addStorage(state, data) {
      state.user=data
    }
  },
  actions: {
    updateGoods({ commit, state } ) {
      axios
        .get("/api/goods/page/1/" +state.goods.pageSize +"?name=" +state.urlName)
        .then((result) => {
          let goods = [];
          goods = result.data.list;
          goods.total = result.data.total
          goods.pageSize = state.goods.pageSize;
          goods.loading2 = false
          goods.forEach((element) => {
            element.img = "/api/img/" + element.img;
          });
          commit("updateGoods", goods)
        }).catch(err => {
          ElMessage.error("出错了!")
        }) 
    },
    updateUrlName({ dispatch, state }, val) {
      state.urlName = val
      dispatch("updateGoods")
    },
    incrementCount({dispatch, commit, state}, val) {
      state.goods.pageSize += val;
      dispatch("updateGoods")
    },
    //加入购物车
    addToCart({commit}, product) {
      commit("addCart", {
        id: product.id
      })
    },
    //修改商品数量
    updateToCart({commit}, product) {
      commit("updateCart", {
        id: product.id,
        count: product.count
      })
    },
    // 清空购物车
    clearToCart({commit}) {
      commit("clearCart")
    },
    //删除单个物品
    deleteToShop({commit}, product) {
      commit("deleteShop", product)
    },
    // 添加localStorage数据
    addStorage({commit}) {
      const data = JSON.parse(localStorage.getItem('user'))
      commit("addStorage", data)
    }
  },
});
