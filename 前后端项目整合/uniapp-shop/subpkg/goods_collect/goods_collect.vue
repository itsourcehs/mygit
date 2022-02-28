<template>
	<view>
		<view class="collect-content">
			
			<view class="collect-title">
				<text class="title_tip active">全部</text>
				<text class="title_tip">正在热卖</text>
				<text class="title_tip">即将上线</text>
			</view>
			
			<view class="collect_main">
				<!-- 第一件商品 -->
				<view class="collect_main_navi">
					<view class="goods_image">
						<image src="../../static/uni.png"></image>
					</view>
					<view class="goods_info">
						<view class="info_name">测试1</view>
						<view class="info_price">￥0.01</view>
					</view>
				</view>
				<!-- 第二件商品 -->
				<view class="collect_main_navi">
					<view class="goods_image">
						<image src="../../static/uni.png"></image>
					</view>
					<view class="goods_info">
						<view class="info_name">测试1</view>
						<view class="info_price">￥0.01</view>
					</view>
				</view>
				<!-- 第三件商品 -->
				<view class="collect_main_navi">
					<view class="goods_image">
						<image src="../../static/uni.png"></image>
					</view>
					<view class="goods_info">
						<view class="info_name">测试1</view>
						<view class="info_price">￥0.01</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
	
		}
	}
</script>

<style lang="scss">
.collect-content {background: #ccc;}
.collect-title {padding: 30rpx;}
.title_tip {
	padding: 10rpx 20rpx;
	margin-left: 10rpx;
	border: 1px solid #888;
	background-color: #fff;
	
	.active {
		color: var(--themeColor);
		border: 1px solid currentColor;
	}
}
.collect_main_navi {
	display: flex;
	padding: 10rpx 0;
	border-bottom: 2px solid #ccc;
	
	.goods_image {
		flex: 2;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	.goods_image image {width: 100%;height: 100%;}
	
	.goods_info {
		flex: 5;display: flex;
		flex-direction: column;
		justify-content: space-between;
		
		.info_name {
			display: -webkit-box;
			overflow: hidden;
			-webkit-box-orient:vertical;
			-webkit-line-clamp:2;
			font-size: 28rpx;	
		}
		
		.info_price {
			color: var(--themeColor);
			font-size: 32rpx;
		}
	}
}


</style>
