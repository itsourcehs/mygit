import Vue from 'vue'
import App from './App'
import router from './router'

Vue.config.productionTip = false

import Element from 'element-ui';
Vue.use(Element)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
