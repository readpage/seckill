import ElementPlus from "element-plus";
import "element-plus/lib/theme-chalk/index.css";
import locale from "element-plus/lib/locale/lang/zh-cn";

import dayjs from 'dayjs'
import "dayjs/locale/zh-cn"

import Vue3Autocounter from 'vue3-autocounter';

export default {
  install: app => {
    app.use(ElementPlus, { locale })
    app.config.globalProperties.day = dayjs;
    app.component("cl-count", Vue3Autocounter)
  }
}
