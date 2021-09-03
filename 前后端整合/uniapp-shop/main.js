
// #ifndef VUE3
import Vue from 'vue'
import App from './App'
import {myRequest} from 'common/api.js'
Vue.prototype.$myRequest = myRequest
import {$http} from '@escook/request-miniprogram'
uni.$http = $http
$http.baseUrl = "https://www.uinav.com"
$http.beforeRequest = function (options) {
	uni.showLoading({
		title: '数据加载中....'
	})
}
$http.afterRequest = function () {
	uni.hideLoading()
}

// 封装的展示消息提示的方法
uni.$showMsg = function (title= '数据加载失败！', duration= 1500) {
	uni.showToast({
		title,
		duration,
		icon: 'none'
	})
}

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