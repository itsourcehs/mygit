
// #ifndef VUE3
import Vue from 'vue'
import App from './App'
import {myRequest} from 'common/api.js'
Vue.prototype.$myRequest = myRequest
import {$http} from '@escook/request-miniprogram'
uni.$http = $http
$http.baseUrl = "www.uinav.com"
Vue.filter('formatDate',(date)=>{
	const nDate = new Date(date)
	const year = nDate.getFullYear()
	const month = nDate.getMonth().toString().padStart(2,0)
	const day = nDate.getDay().toString().padStart(2,0)
	return year+'-'+month+'-'+day
})

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