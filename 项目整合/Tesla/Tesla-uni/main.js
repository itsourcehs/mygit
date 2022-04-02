// #ifndef VUE3
import Vue from 'vue'
import App from './App'

// 全局注册,之后可在其他组件中通过 this.$axios发送数据
var axios = require('axios')
Vue.prototype.$axios = axios

// 引入mock服务并使用
import mock from "mock/index.js"
Vue.use(mock)


Vue.config.productionTip = false

App.mpType = 'app'

const app = new Vue({
    ...App
})
app.$mount()
// #endif

// #ifdef VUE3
import { createSSRApp } from 'vue'
import App from './App.vue'
export function createApp() {
  const app = createSSRApp(App)
  return {
    app
  }
}
// #endif