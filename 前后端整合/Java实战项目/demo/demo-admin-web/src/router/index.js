import Vue from 'vue'
import Router from 'vue-router'
import Layout from '../views/layout/Layout'

Vue.use(Router)

export const constantRouterMap = [
	{path: '/login', component: () => import('@/views/login/index'), hidden: true},
	{
	    path: '',
		// component: () => import('@/views/home/home')
	    component: Layout,
	    redirect: '/home',
	    children: [{
	      path: 'home',
	      name: 'home',
	      component: () => import('@/views/home/home'),
	      meta: {title: '首页', icon: 'home'}
	    }]
	}
]

// 异步路由映射
export const asyncRouterMap = [
	{
		path: '/pms',
		component: Layout,
		redirect: '/pms/product',
		name: 'pms',
		meta: {title: '商品', icon: 'product'},
		children: [
			{
				path: 'product',
				name: 'product',
				component: () => import('@/views/pms/product/index'),
				meta: {title: '商品列表', icon: 'product-list'}
			},
			{
					path: 'addProduct',
					name: 'addProduct',
					component: () => import('@/views/pms/product/add'),
					meta: {title: '添加商品', icon: 'product-add'}
			},
			{
					path: 'updateProduct',
					name: 'updateProduct',
					component: () => import('@/views/pms/product/update'),
					meta: {title: '修改商品', icon: 'product-add'},
					hidden: true
			},
			{
					path: 'productCate',
					name: 'productCate',
					component: () => import('@/views/pms/productCate/index'),
					meta: {title: '商品分类', icon: 'product-cate'}
			},
			{
					path: 'addProductCate',
					name: 'addProductCate',
					component: () => import('@/views/pms/productCate/add'),
					meta: {title: '添加商品分类'},
					hidden: true
			},
			{
					path: 'updateProductCate',
					name: 'updateProductCate',
					component: () => import('@/views/pms/productCate/update'),
					meta: {title: '修改商品分类'},
					hidden: true
			},
			{
					path: 'productAttr',
					name: 'productAttr',
					component: () => import('@/views/pms/productAttr/index'),
					meta: {title: '商品类型', icon: 'product-attr'}
			},
			{
					path: 'productAttrList',
					name: 'productAttrList',
					component: () => import('@/views/pms/productAttr/productAttrList'),
					meta: {title: '商品属性列表'},
					hidden: true
			},
			{
					path: 'addProductAttr',
					name: 'addProductAttr',
					component: () => import('@/views/pms/productAttr/addProductAttr'),
					meta: {title: '添加商品属性'},
					hidden: true
			},
			{
					path: 'updateProductAttr',
					name: 'updateProductAttr',
					component: () => import('@/views/pms/productAttr/updateProductAttr'),
					meta: {title: '修改商品属性'},
					hidden: true
			},
			{
					path: 'brand',
					name: 'brand',
					component: () => import('@/views/pms/brand/index'),
					meta: {title: '品牌管理', icon: 'product-brand'}
			},
			{
					path: 'addBrand',
					name: 'addBrand',
					component: () => import('@/views/pms/brand/add'),
					meta: {title: '添加品牌'},
					hidden: true
			},
			{
					path: 'updateBrand',
					name: 'updateBrand',
					component: () => import('@/views/pms/brand/update'),
					meta: {title: '编辑品牌'},
					hidden: true
			}
		]
	},
	// 订单
	
]

export default new Router({
  mode: "history", // 不加无法路由跳转
  routes: constantRouterMap
})
