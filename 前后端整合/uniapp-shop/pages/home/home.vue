<template>
	<view>
		<!-- 轮播图区域 -->
		<swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000" :circular="true">
			<swiper-item v-for="(item, i) in swiperList" :key="i">
				<!-- 改造view为navigator -->
				<navigator class="swiper-item" :url="'/subpkg/goods_detail/goods_detail?goods_id=' + item.goods_id">
					<image :src="item.image_src"></image>
				</navigator>
			</swiper-item>
		</swiper>
		<!-- 分类导航区域 -->
		<view class="nav-list">
			<view class="nav-item" v-for="(item, i) in navList" :key="i" @click="navClickHandler(item)">
			     <image :src="item.image_src" class="nav-img"></image>
			</view>
		</view>
		<!-- 楼层区域 -->
		<view class="floor-list">
			<view class="floor-item" v-for="(item, i) in floorList" :key="i">
				<image :src="item.floor_title.image_src" class="floor-title"></image>
				<!-- 楼层图片区域 -->
				<view class="floor-img-box"></view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				swiperList: [],
				// 分类导航的数据列表
				navList: [],
				// 楼层的数据列表
				floorList: []
			};
		},
		onLoad () {
			this.getSwiperList()
			this.getNavList()
			this.getFloorList()
		},
		methods: {
			async getSwiperList () {
				const {data: res} = await uni.$http.get('/api/public/v1/home/swiperdata')
				// 如果请求失败,直接调用封装后的消息提示方法返回
				if (res.meta.status !== 200) return uni.$showMsg()
				// 如果请求成功
				this.swiperList = res.message
			},
			async getNavList () {
				const {data: res} = await uni.$http.get('/api/public/v1/home/catitems')
				if (res.meta.status !== 200) return uni.$showMsg()
				// 如果请求成功
				this.navList = res.message
			},
			async getFloorList () {
				const {data: res} = await uni.$http.get('/api/public/v1/home/floordata')
				if (res.meta.status !== 200) return uni.$showMsg()
				// 如果请求成功
				this.floorList = res.message
			},
			navClickHandler (item) {
				// 元素被点击后跳转到分类
				if (item.name === '分类') {
					// 切换到分类Tab
					uni.switchTab({
						url: '/pages/cate/cate'
					})
				}
			}
		}
	}
</script>

<style lang="scss">
swiper {
	height: 330rpx;
	.swiper-item,
	 image {
	   width: 100%;
	   height: 100%;
	 }
}

// 分类导航样式
.nav-list {
	display: flex;
	// 弹性盒子横轴对齐
	justify-content: space-around;
	margin: 15rpx 0;
	.nav-img {
		width: 128rpx;
		height: 140rpx;
	}
}

.floor-title {height: 60rpx;width: 100%;display: flex;}

</style>
