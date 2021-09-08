<template>
	<view>
		<!-- 搜索组件区域 -->
		<view class="search-box">
		  <my-search @click="gotoSearch"></my-search>
		</view>
		
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
				<view class="floor-img-box">
					<!-- 左侧大图区域 -->
					<navigator class="left-img-box"
					:url="item.product_list[0].url">
						<image
						:src="item.product_list[0].image_src"
						:style="{width: item.product_list[0].image_width + 'rpx'}"
						mode="widthFix"></image>
					</navigator>
					<!-- 右侧四张小图区域 -->
					<view class="right-img-box">
						<navigator class="right-img-item"
						v-for="(item2, i2) in item.product_list"
						:key="i2"
						v-if="i2 !== 0"
						:url="item2.url">
							<image
							:src="item2.image_src"
							:style="{width: item2.image_width + 'rpx'}"
							mode="widthFix"></image>
						</navigator>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	// 接口地址 https://www.escook.cn/docs-uni-shop/mds/5.search.html#_5-1-1-%E8%87%AA%E5%AE%9A%E4%B9%89-my-search-%E7%BB%84%E4%BB%B6
	// https://www.bilibili.com/video/BV1PU4y1n743?p=42
	// 导入自己封装的 mixin 模块
	import badgeMix from '@/mixins/tabbar-badge.js'
	export default {
		// 将 badgeMix 混入到当前的页面中进行使用
		mixins: [badgeMix],
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
				
				// 通过forEach循环返回数据,拼接自定义跳转url
				res.message.forEach(floor => {
					floor.product_list.forEach(prod => {
						prod.url = '/subpkg/goods_list/goods_list?' + prod.navigator_url.split('?')[1]
					})
				})
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
			},
			gotoSearch () {
				uni.navigateTo({
					url: '/subpkg/search/search'
				});
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
	// 弹性盒子中元素横轴对齐
	justify-content: space-around;
	margin: 15rpx 0;
	.nav-img {
		width: 128rpx;
		height: 140rpx;
	}
}

.floor-title {height: 60rpx;width: 100%;display: flex;}

.floor-img-box {display: flex;padding-left: 10rpx;}
.right-img-box {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-around;
}
.search-box {
	// 设置 "吸顶"定位效果: 顶部距离0 提高层级防止被轮播图覆盖z-index
	position: sticky;
	top: 0;
	z-index: 999;
}
</style>
