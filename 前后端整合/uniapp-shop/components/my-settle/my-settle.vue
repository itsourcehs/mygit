<template>
	<view class="my-settle-container">
		<!-- 全选区域 -->
		<label class="radio">
			<radio color="#C00000" :checked="true"><text>全选</text></radio>
		</label>
		
		<!-- 合计区域 -->
		<view class="amount-box">
			合计:<text class="amount">￥1234.00</text>
		</view>
		
		<!-- 结算按钮 -->
		<view class="btn-settle">结算(0)</view>
	</view>
</template>

<script>
	export default {
		name:"my-settle",
		data() {
			return {
				
			};
		}
	}
</script>

<style lang="scss">
.my-settle-container {
	position: fixed;
	bottom: 0;
	left: 0;
	width: 100%;
	height: 50rpx;
	background-color: white;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding-left: 5rpx;
	font-size: 14rpx;
	
	.radio {display: flex;align-items: center;}
	.amount {color: #c00000;}
	.btn-settle {
		height: 50rpx;
		min-width: 100rpx;
		background-color: #c00000;
		color: white;
		line-height: 50rpx;
		text-align: center;
		padding: 0 10rpx;
	}
}
</style>
