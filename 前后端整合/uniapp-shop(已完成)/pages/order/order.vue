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
					isActive: true
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
	}
}
</script>

<style>

</style>
