<template>
	<view class="home-container">
		
		<home-head></home-head>
		
		<view class="container">
			<!-- 轮播图区域 -->
			<swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000" :circular="true">
				<swiper-item v-for="(item, i) in imgList" :key="item.id">
					<!-- 改造view为navigator -->
					<navigator class="swiper-item">
						<image :src="item.url"></image>
					</navigator>
				</swiper-item>
			</swiper>
			
			<!-- 新人活动区域 -->
			<view class="new-task" v-if="true">
				<image src="../../static/img/new.png"></image>
			</view>
			
			<!-- 标签页区域 -->
			<tab class="tab" index="0" :animation="true" tabPadding="28" @changeIndex="changeIndex">
				<tab-pane label="常规任务">
					<task-list></task-list>
				</tab-pane>
				<tab-pane label="更多"><task-list></task-list></tab-pane>
				<tab-pane label="快赚"><task-list></task-list></tab-pane>
				<tab-pane label="简单任务"><task-list></task-list></tab-pane>
				<tab-pane label="高额任务"><task-list></task-list></tab-pane>
			</tab>
		</view>
		
		<!-- 登录组件区域 -->
		<my-login v-if="token"></my-login>
	</view>
</template>

<script>
import tab from '@/components/lipan-tabs/lipan-tabs.vue';
import tabPane from '@/components/lipan-tabs/lipan-tab-pane.vue';
export default {
	methods: {
		changeIndex (e) {
			console.log(e);
		}
	},
	data() {
		return {
			token: true,
			active: 2,
			// 轮播图
			imgList: [{
				url: 'https://img9.51tietu.net/pic/2019-091200/vgkpidei2tjvgkpidei2tj.jpg',
				id: 1
			},{
				url: 'https://img9.51tietu.net/pic/2019-091200/euzekmi5m23euzekmi5m23.jpg',
				id: 2
			},{
				url: 'https://img9.51tietu.net/pic/2019-091200/143tt0ta4sr143tt0ta4sr.jpg',
				id: 3
			},{
				url: 'https://img9.51tietu.net/pic/2019-091200/ff1vqwm3q33ff1vqwm3q33.jpg',
				id: 4
			},]
		}
	},
	components: {
		tab,
		tabPane
	}
}	
</script>

<style lang="scss">
.home-container {width: 100%;height: 100%;padding-bottom: 40rpx;}

// 轮播图区域样式
swiper {
	height: 200rpx;
	.swiper-item,
	image {
		width: 98%;
		height: 100%;
		margin: 7rpx;
	}
}
.new-task {
	height: 210rpx;
	margin: 10rpx 0;
	padding-left: 12rpx;
	
	image {width: 98%;height: 100%;}
}
</style>
