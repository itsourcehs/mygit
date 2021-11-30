<template>
	<view class="page">
		<view class="swiper">
			<swiper @change="handleChange">
				<swiper-item v-for="(item, index) in swiperList" :key="index">
					<image :src="item.imgUrl" mode="aspectFill"></image>
				</swiper-item>
			</swiper>
			
			<view class="swiper-float-content">
				<view
				class="title"
				v-for="(item3,index3) in swiperList"
				:key="index3"
				v-if="currentSwiperIndex === index3"
				>
					{{item3.title}}
				</view>
				
				<view
				class="descriptions-area"
				v-for="(item4,index4) in swiperList"
				:key="index4"
				v-if="currentSwiperIndex === index4">
					<view
					class="description"
					v-for="(item5,index5) in item4.config"
					:key="index5">
						<view class="description-title">
							{{item5.title}}
						</view>
						
						<view class="description-subtitle">
							{{item5.subtitle}}
						</view>
					</view>
				</view>
				
				<view class="action-btn">
					预约试驾
				</view>
				
				<view class="view-config">
					查看参数
				</view>
				
				<view class="swiper-dots">
					<view
					class="dot"
					:class="[currentSwiperIndex !== index2 || 'active']"
					v-for="(item2,index2) in swiperList"
					:key="index2"></view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				// 模拟轮播图数据
				swiperList: [
					{
						imgUrl: '../../static/images/swiper/car.png',
						title: 'Model s',
						config: [
							{title: '637',subtitle:'公里续航'},
							{title: '2.1秒',subtitle:'百公里加速'},
							{title: '322公里/小时',subtitle:'最高车速'}
						]
					},
					{
						imgUrl: '../../static/images/swiper/car.png',
						title: 'Model x',
						config: [
							{title: '537',subtitle:'公里续航'},
							{title: '3.1秒',subtitle:'百公里加速'},
							{title: '122公里/小时',subtitle:'最高车速'}
						]
					},
					{
						imgUrl: '../../static/images/swiper/car.png',
						title: 'Model y',
						config: [
							{title: '437',subtitle:'公里续航'},
							{title: '1.1秒',subtitle:'百公里加速'},
							{title: '222公里/小时',subtitle:'最高车速'}
						]
					}
				],
				currentSwiperIndex: 0
			}
		},
		methods: {
			// swiper 元素改变时
			handleChange (e) {
				console.log(e.detail.current);
				this.currentSwiperIndex = e.detail.current
			}
		}
	}
</script>

<style>
@import url("tesla.css");
</style>
