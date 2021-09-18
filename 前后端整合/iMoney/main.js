// #ifndef VUE3
import Vue from 'vue'
import App from './App'
import {Tab, Tabs} from 'vant'
// 引入uView
import uView from 'uview-ui'
Vue.use(uView)

Vue.use(Tab)
Vue.use(Tabs)

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