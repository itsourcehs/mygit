import Vue from 'vue'
import Router from 'vue-router'
import main from "@/components/main"

Vue.use(Router)

export default new Router({
	mode: 'history',
	routes: [
    {
		path: '/',
		component: main,
		redirect: '/login',
		children: [
			{
			  path: '/index',
			  name: 'index',
			  meta: {title: '首页'}, // 配置meta属性，实现动态面包屑导航
			  component: () => import('@/views/index'),
			},
		]
	},
	
    // 车辆管理
    {
      path: '/car',
      name: '',
      meta: {title: '车辆管理'},
      component: main,
      // 使用嵌套路由进行渲染 统一header和导航菜单，不同内容main
      children: [
        {
          path: '/config',
          name: 'carconfig',
          meta: {title: 'Tesla'},
          component: () => import('@/views/CarConfig'),
        },
        {
          path: '/parts',
          name: 'carparts',
          meta: {title: 'Tesla零件'},
          component: () => import('@/views/CarParts'),
        },

      ]

    },
    // 用户管理
    {
      path: '/user',
      name: 'User',
      meta: {title: '用户管理'},
      component: main,
      children: [
        {
          path: '/user/add',
          name: 'UserAdd',
          meta: {title: '新增用户'},
          component: () => import('@/views/UserCenter'),
        }
      ]
    },

    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/login')
    },
  ]
})
