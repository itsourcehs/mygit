import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
	mode: 'history',
	routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('@/views/home'),
      // 使用嵌套路由进行渲染 统一header和导航菜单，不同内容main
      children: [
        {
          path: '/1-1',
          name: 'test',
          component: () => import('@/views/test')
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
