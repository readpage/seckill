import { createStore } from "vuex";
import app from './modules/base/app.js'

export default createStore({
  state: {
    user: {
      username: "未登录"
    },
  },
  mutations: {
    updateUser(state, newVal) {
      state.user = newVal;
      localStorage.setItem("user", JSON.stringify(newVal))
    },
     // 添加localStorage数据
     addStorage(state, data) {
      state.user=data
    },
    UOLoad(state, val) {
      state.operateLoad = val;
    }
  },
  actions: {
    // 添加localStorage数据
    addStorage({commit}) {
      const data = JSON.parse(localStorage.getItem('user'))
      commit("addStorage", data)
    }
  },
  modules: {
    msg: app,
    anothe: {
      namespaced: true,
    }
  }
});
