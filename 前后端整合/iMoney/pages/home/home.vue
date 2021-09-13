<template>
	<view class="home-container">
		
		<!-- 首页标题区域 -->
		<view class="home-title">
			<view class="home-title-left">Imoney</view>
			<view class="home-title-right">
				<text>￥0.0</text>
				<view class="">
					<text>立即提现</text>
					<image></image>
				</view>
			</view>
		</view>
		
		<!-- 轮播图区域 -->
		<swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000" :circular="true">
			<swiper-item>
				<!-- 改造view为navigator -->
				<navigator class="swiper-item">
					<image></image>
				</navigator>
			</swiper-item>
		</swiper>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			};
		}
	}
</script>

<style lang="scss">
.home-container {
	width: 100%;
	
}
.home-title {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	justify-content: space-between;
	align-items: stretch;
	height: 100rpx;
	padding: 0 10rpx;
	border-bottom: 1px solid #d3d3d3;

	.home-title-left {
		margin-right: 54%;
	}
	
	.home-title-right {
		display: flex;
	}
}


</style>
