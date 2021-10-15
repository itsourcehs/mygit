import Vue from 'vue'
import Router from 'vue-router'
import Layout from '../views/layout/Layout'

Vue.use(Router)

export const constantRouterMap = [
	{path: '/login', component: () => import('@/views/login/index'), hidden: true},
	// {
	//     path: '',
	//     component: Layout,
	//     redirect: '/home',
	//     children: [{
	//       path: 'home',
	//       name: 'home',
	//       component: () => import('@/views/home/home'),
	//       meta: {title: '首页', icon: 'home'}
	//     }]
	// }
]

export default new Router({
  mode: "history", // 不加无法路由跳转
  routes: constantRouterMap
})
