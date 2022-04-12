import Vue from 'vue'
import App from './App'
import router from './router'

Vue.config.productionTip = false

// 导入 element-ui
import Element from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(Element)

// 导入axios
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8081/api'
// 全局注册,之后可在其他组件中通过 this.$axios发送数据
Vue.prototype.$axios = axios



/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
