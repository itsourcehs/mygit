// #ifndef VUE3
import Vue from 'vue'
import App from './App'
// 1. 导入 store 的实例对象
import store from './store/store.js'
import {myRequest} from 'common/api.js'
Vue.prototype.$myRequest = myRequest
import {$http} from '@escook/request-miniprogram'
uni.$http = $http
$http.baseUrl = "https://www.uinav.com"
// $http.baseUrl = "https://api-hmugo-web.itheima.net"

$http.beforeRequest = function (options) {
	// console.log(options);
	uni.showLoading({
		title: '数据加载中....'
	})
	
	/*
	 * 只有在登录后调用支付相关的接口,所以必须为有权限的接口添加身份认证的请求头字段
	 * 1.判断是否是有权限的接口
	 * 2.为请求头添加身份认证字段
	 */
	// 1.判断是否是有权限的接口
	if (options.url.indexOf('/my/') !== -1) {
		// 2.为请求头添加身份认证 token 字段，可以从 vuex 中拿到
		options.header = {
			Authorization: store.state.m_user.token,
		}
	}
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

// 格式化日期
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
    ...App,
	store
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