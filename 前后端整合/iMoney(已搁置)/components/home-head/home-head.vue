<template>
	<!-- 首页标题区域 -->
	<view class="head">
		<view class="home-title">
			<view class="home-title-left"><text>Imoney</text></view>
			<view class="home-title-right">
				<text>￥0.0</text>
				<text>立即提现 ></text>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		name:"home-head",
		data() {
			return {
				
			};
		}
	}
</script>

<style lang="scss">
.head {padding-bottom: 30px;}
.home-title {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	justify-content: space-between;
	// align-items: stretch;
	height: 50rpx;
	padding-bottom: 5px;
	border-bottom: 1px solid #efefef;
	position: fixed;
	z-index: 1;
	background-color: #ffffff;
	
	
	.home-title-left {margin-right: 380rpx;text {color: #e9686b;}}

}
.home-title-right {display: flex;}
.home-title-right text:nth-child(1) {
	color: #e9686b;
	font-size: 18px;
}
</style>
