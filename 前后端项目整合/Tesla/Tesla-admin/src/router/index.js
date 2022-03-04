import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
	mode: 'history',
	routes: [
    {
      path: '/',
      name: 'AdminIndex',
      meta: {title: '首页'}, // 配置meta属性，实现动态面包屑导航
      component: () => import('@/views/AdminIndex'),
    },

    {
      path: '/carManage',
      name: 'carManagement',
      meta: {title: '车辆管理'},
      component: () => import('@/views/CommonViews'),
      // 使用嵌套路由进行渲染 统一header和导航菜单，不同内容main
      children: [
        {
          path: '/config',
          name: 'carconfig',
          meta: {title: 'Tesla配置'},
          component: () => import('@/views/CarConfig'),
        },
        {
          path: '/parts',
          name: 'carparts',
          meta: {title: 'Tesla零件'},
          component: () => import('@/views/CarParts'),
        },
        {
          path: '/user/add',
          name: 'UserAdd',
          meta: {title: '添加用户'},
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
