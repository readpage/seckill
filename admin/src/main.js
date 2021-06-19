import { createApp } from 'vue'
import App from './App.vue'
import plugins from "./plugins"
import router from './router';
import store from "./store";
import axios from "axios";
import VueAxios from "vue-axios";

createApp(App)
  .use(store)
  .use(plugins)
  .use(VueAxios, axios)
  .use(router)
  .mount('#app')
