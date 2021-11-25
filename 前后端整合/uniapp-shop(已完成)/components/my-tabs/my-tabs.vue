<template>
	<view class="tbs">
		 <!-- {{item.isActive?'active':''}} -->
		<view class="tabs_title">
			<view
			class="title_item"
			:class="[item.isActive?'active':'']"
			v-for="(item, index) in tabs"
			:key="item.value"
			@tap="handleTap"
			:data-index="index +1">{{item.value}}</view>
		</view>
		
		
		<!-- 内容区域 -->
		<view class="tabs_content">
			<!-- 插槽 -->
			<slot></slot>
		</view>
	</view>
</template>

<script>
	export default {
		name:"my-tabs",
		// 子组件用 props 接受父组件传递过来的值
		props: {
			tabs: {
				type:Array,
				value: ''
			}
		},
		data() {
			return {
				
			};
		},
		methods: {
			handleTap (e) {
				// console.log('e',e);
				// 1.获取点击元素中绑定的索引
				const index = e.currentTarget.dataset.index
				// console.log(index);
				
				// 2.触发父组件中的自定义事件 triggerEvent
				this.$emit('tabsItemChange', index)
			}
		}
	}
</script>

<style lang="scss">
.tabs_title {
	display: flex;
	justify-content: space-around;
	align-items: center;
	font-size: 30rpx;
	background: #fff;
}
.title_item {
	display: flex;flex: 1;
	justify-content: center;
	align-items: center;
	padding: 20rpx;
}
.active {
	// color: var(--themeColor);
	color: #c08875;
	border-bottom: 3px solid #c08875;
}
</style>
