import ElementPlus from "element-plus";
import "element-plus/lib/theme-chalk/index.css";
import locale from "element-plus/lib/locale/lang/zh-cn";

import dayjs from 'dayjs'
import "dayjs/locale/zh-cn"
import duration from "dayjs/plugin/duration"
dayjs.extend(duration)
import relativeTime from "dayjs/plugin/relativeTime"
dayjs.extend(relativeTime)
import countTo from 'vue3-count-to';

export default {
  install: app => {
    app.use(ElementPlus, { locale })
    app.config.globalProperties.day = dayjs;
    app.use(countTo)
  }
}
