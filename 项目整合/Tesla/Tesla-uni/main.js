// #ifndef VUE3
import Vue from 'vue'
import App from './App'
// 引入vant部分组件

// import { Col, Row } from 'vant';
// import { Field } from 'vant';
// // 使用vant
// Vue.use(Col);
// Vue.use(Row);
// Vue.use(Field);


// 1.全局注册,之后可在其他组件中通过发送数据请求
import api from 'common/api.js'
// 2.挂载到Vue原型上
Vue.prototype.$api = api


// 1.引入mock服务
import mock from "mock/index.js"
// 2.使用
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