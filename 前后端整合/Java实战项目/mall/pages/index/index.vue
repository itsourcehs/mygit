<template>
	<view class="container">
		
		<!-- 首页轮播图区域 -->
		<swiper
		class="banner"
		indicator-dots="true"
		autoplay="true"
		interval="3000"
		duration="1000">
			<swiper-item
			v-for="(item, index) in banner"
			:key="index">
				<navigator v-if="item.link" :url="item.link">
					<image :src="item.image_url" background-size="cover"></image>
				</navigator>
				<image v-else :src="item.image_url" background-size="cover"></image>
			</swiper-item>
		</swiper>
		
		
	</view>
</template>

<script>
	const api = require('@/common/api.js');
	const util = require("@/common/util.js")
	export default {
		data() {
			return {
				banner: [],
				channel: []
			}
		},
		onLoad() {
			this.getIndexData()
		},
		methods: {
			// 获取首页数据
			getIndexData () {
				debugger
				let that = this
				
				//首页banner数据
				util.request(api.IndexUrlBanner)
				.then(function(res) {
					console.log(res);
					if (res.errno === 0) {
						that.banner = res.data.banner
					}
				})
				
				// 
				
			}
		},
		// 下拉刷新数据
		onPullDownRefresh() {
			this.getIndexData()
		},
		
		onShareAppMessage: function() {
			return {
				title: '开源商城',
				path: '/pages/index/index'
			}
		}
	}
</script>

<style lang="scss">
.banner {
	width: 750rpx;height: 417rpx;
	image {width: 100%;height: 417rpx;}
}

</style>
