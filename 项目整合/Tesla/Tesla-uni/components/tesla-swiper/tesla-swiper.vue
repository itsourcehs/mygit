<template>
	<view>
		<view class="swiper-area">
			
			<swiper @change="handleChange">
				<swiper-item v-for="(item, index) in swiperList" :key="index">
					<view class="swiper-item">
						<image :src="item.imgUrl" mode="aspectFill"></image>
					</view>
				</swiper-item>
			</swiper>
			
			<view class="swiper-content"
			v-for="(car,index1) in swiperList"
			:key="index1"
			v-if="current === index1">
				
				<view class="title">
					{{car.title}}
				</view>
				
				<view class="meta">
					<view class="items" v-for="(conf,index2) in car.config" :key="index2">
						<view class="item-title">{{conf.title}}</view>
						<view class="item-subtitle">{{conf.subtitle}}</view>
					</view>
				</view>
				
				<!-- 预约试驾 -->
				<view class="action">
					
					<view class="book-btn">
						<button @tap="handleBook">预约试驾</button>
						<view class="book-btn-back"></view>
					</view>
					
					<view class="view-configuration" @tap="handleViewConfig">查看配置</view>
				</view>
			</view>
			
			<view class="swiper-dots">
				<view
				class="dot"
				:class="[current !== index3 || 'active']"
				v-for="(cart,index3) in swiperList"
				:key="index3">
					
				</view>
			</view>
		</view>
	</view>
</template>
<script>
export default {
	name:"tesla-swiper",
	data() {
		return {
			// 模拟轮播图数据
			swiperList: [
				{
					imgUrl: '../../static/images/swiper/car.png',
					title: 'Model s',
					config: [
						{title: '637',subtitle:'公里续航'},
						{title: '2.1s',subtitle:'百公里加速'},
						{title: '322Km/h',subtitle:'最高车速'}
					]
				},
				{
					imgUrl: '../../static/images/swiper/car.png',
					title: 'Model x',
					config: [
						{title: '537',subtitle:'公里续航'},
						{title: '3.1s',subtitle:'百公里加速'},
						{title: '122Km/h',subtitle:'最高车速'}
					]
				},
				{
					imgUrl: '../../static/images/swiper/car.png',
					title: 'Model y',
					config: [
						{title: '437',subtitle:'公里续航'},
						{title: '1.1s',subtitle:'百公里加速'},
						{title: '222Km/h',subtitle:'最高车速'}
					]
				}
			],
			current: 0
		};
	},
	methods: {
		getIndexSwiperList () {
			const db = uniCloud.database();
			
		},
		
		// swiper 元素改变时
		handleChange (e) {
			// console.log(e.detail.current);
			this.current = e.detail.current
		},
		
		handleBook () {
			// 触发父组件 bookClick 事件
			this.$emit('bookClick')
		},
		
		// 查看配置
		handleViewConfig (e) {
			uni.navigateTo({
				url: '../../pages/product/product'
			})
		}
	}
}
</script>

<style>
@import url("tesla-swiper.css");
</style>
