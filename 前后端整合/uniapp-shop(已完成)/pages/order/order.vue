<template>
	<view>
		<my-tabs
		:tabs="tabs"
		@tabsItemChange="handleTabsItemChange"></my-tabs>
	</view>
</template>

<script>
export default {
	data() {
		return {
			tabs: [
				{
					id:1,
					value: '待付款',
					isActive: false
				},
				{
					id:2,
					value: '待收货',
					isActive: false
				},
				{
					id:3,
					value: '退款/退货',
					isActive: false
				},
				{
					id:4,
					value: '全部订单',
					isActive: false
				},
			]
		}
	},
	methods: {
		// 父组件自定义事件
		handleTabsItemChange (index) {
			console.log(index); // 传递过来的索引 0 1 2
			this.tabs.forEach((v, i) => i === index?v.isActive = true: v.isActive = false)
		}
	},
	// 监听页面加载,参数 options 为上个页面传递的数据
	onShow: (options) => {
		debugger
		// console.log('页面加载',options);
		const type = options.type
		// 
		const that = this
		const tabs = that.tabs
		tabs.forEach(v => {
			if (v.id === type) {
				v.isActive = true
			}
		})
	}
}
</script>

<style>

</style>
