export default {
  namespaced: true,
  state: {
    collapse: true,
  },
  getters: {
		// 左侧菜单是否收起
		menuCollapse: state => state.collapse
	},
  mutations: {
    UpdateCollapse(state, newCollapse) {
      state.collapse = newCollapse;
    },
    COLLAPSE_MENU(state, val) {
      state.collapse = val;
    },
  },
  actions: {
  },
  modules: {},
}