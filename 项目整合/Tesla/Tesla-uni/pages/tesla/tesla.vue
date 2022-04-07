<template>
	<view class="page">
		<tesla-swiper @bookClick="handleBookClick" style="width: 100%;"></tesla-swiper>
		
		<!-- 月刊杂志 -->
		<view class="magazine-area">
			<view class="title">T zone</view>
			<image class="magazine-cover" src="@/static/images/swiper/car.png" @tap="handleClickMagazine" data-id="1234"></image>
			<view class="magazine-title">杂志摘要....</view>
		</view>
		
		<!-- 贷款计算器 -->
		<view class="icon-banner" @tap="goToLendersToolbox">
			<image class="banner-bg credit-card" src="@/static/images/icon/credit-card.jpg" mode="widthFix"></image>
			<view class="content">
				<view class="info">
					<view class="title">贷款计算器</view>
					<view class="subtitle">定制我的金融方案</view>
				</view>
			</view>
		</view>
		
		<!-- 新手视频 -->
		<view class="icon-banner" @tap="goToVideo">
			<image class="banner-bg credit-card" src="@/static/images/icon/video.png" mode="widthFix"></image>
			<view class="content">
				<view class="info">
					<view class="title">新手视频</view>
					<view class="subtitle">观看视频</view>
				</view>
			</view>
		</view>
		
		<!-- 新能源政策 -->
		<view class="icon-box-area">
			<view class="icon-box tradin" @tap="gotoCleanEnergy">
				<image class="icon" src="@/static/images/icon/energy.png" mode="aspectFit"></image>
				<!-- <view class="title">新能源政策</view> -->
				<view class="title">新能源政策</view>
			</view>
			<view class="icon-box tradin">
				<image class="icon" src="@/static/images/icon/exchange.png" mode="aspectFit"></image>
				<!-- <view class="title">车辆置换</view> -->
				<view class="title">车辆置换</view>
			</view>
		</view>
		
		<!-- 弹出层 -->
		<uni-popup ref="popup" type="bottom">
			<view class="popup-menu">
				<view class="head">
					<view class="title">选择车型</view>
					<image class="close-icon" src="@/static/images/icon/close.png" @tap="handleClosePopupMenu"></image>
				</view>
				<view class="content">
					<view class="item-box" v-for="(item,index) in products" :key="index" @tap="clickProduct" :data-id="item.id">
						<view class="title">{{item.name}}</view>
						<image :src="item.carPic"></image>
					</view>
				</view>
			</view>
		</uni-popup>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				popupMenu: false,
				products: [
					{
						"id": "fa241ce1a6178",
						"carPic": require("@/static/images/swiper/car.png"),
						"name": "Model s"
					},
					{
						"id": "d78wawy7aawd9",
						"carPic": require("@/static/images/swiper/car.png"),
						"name": "Model x"
					},
					{
						"id": "575jdaw9311",
						"carPic": require("@/static/images/swiper/car.png"),
						"name": "Model y"
					}
				]
			}
		},
		methods: {
			gotoCleanEnergy () {
				uni.navigateTo({
					url: '../article/detail/detail?id=28371ada13'
				})
			},
			// 工具箱
			goToLendersToolbox () {
				uni.navigateTo({
					url: '../lenders-toolbox/lenders-toolbox'
				})
			},
			
			clickProduct (e) {
				const id = e.currentTarget.dataset.id
				uni.navigateTo({
					url: '../test-drive/test-drive?id=' + id
				})
				// 关闭弹层
				this.handleClosePopupMenu()
			},
			
			// 预约试驾
			handleBookClick () {
				// 通过组件定义的ref调用uni-popup方法
				this.$refs.popup.open()
				// 模拟发送请求
				this.$http({url:'/car/list'})
			},
			// 杂志封面
			handleClickMagazine () {
				let id = e.currentTarget.dataset.id
				uni.navigateTo({
					url: '../magazine/magazine?id=' +id
				})
				
			},
			
			// 新手视频
			goToVideo () {},
			// 关闭弹出层 && 页面发生改变时也应关闭
			handleClosePopupMenu () {
				// 通过组件定义的ref调用uni-popup close方法
				this.$refs.popup.close()
			}
		}
	}
</script>

<style>
@import url("tesla.css");
</style>
