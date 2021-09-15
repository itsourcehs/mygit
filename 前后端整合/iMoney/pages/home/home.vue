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
			<swiper-item v-for="(item, i) in imgList" :key="item.id">
				<!-- 改造view为navigator -->
				<navigator class="swiper-item">
					<image :src="item.url"></image>
				</navigator>
			</swiper-item>
		</swiper>
		
		<!-- 新人活动区域 -->
		<view class="new-task">
			<image src="../../static/img/new.png"></image>
		</view>
		
		<!-- 标签页区域 -->
		<tab index="0" :animation="true" tabPadding="28" @changeIndex="changeIndex">
			<tab-pane label="常规任务">
				<view class="cgTask">
					<view class="cgTask-left">
						<image src="../../static/img/chat.png"></image>
					</view>
					<view class="cgTask-right">
						<view class="cgTask-right-text">
							<text>爱聊</text>
							<text>安装包 | 下载</text>
						</view>
						<view class="cgTask-right-money"><text>+0.51元</text></view>
					</view>
				</view>
			</tab-pane>
			<tab-pane label="更多">内容2</tab-pane>
			<tab-pane label="快赚">内容3</tab-pane>
			<tab-pane label="简单任务">内容4</tab-pane>
			<tab-pane label="高额任务">内容5</tab-pane>
		</tab>
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
	padding: 10rpx;
	border-bottom: 1px solid #d3d3d3;

	.home-title-left {
		margin-right: 54%;
	}
	
	.home-title-right {
		display: flex;
	}
}

// 轮播图区域样式
swiper {
	height: 330rpx;
	.swiper-item,
	image {
		width: 98%;
		height: 100%;
		border-radius: 7%;
		margin: 7rpx;
	}
}
.new-task {
	height: 280rpx;
	margin: 10rpx 0;
	padding-left: 15rpx;
	image {
		width: 98%;
		height: 100%;
		border-radius: 7%;
	}
}

.cgTask {
	display: flex;
	align-items: center;
	margin: 15rpx;
	height: 80px;
	justify-content: center;
}
.cgTask-left {
	margin: 20rpx;
	width: 10%;
	height: 50%;
	
	image {
		height: 100%;
		width: 100%;
	}
}
.cgTask-right {
	display: flex;
	align-items: center;
	margin: 20rpx 20rpx 20rpx 0;
	width: 80%;

	.cgTask-right-text {
		display: flex;
		flex-direction: column;
		width: 77%;
		text {
			margin-bottom: 28rpx;
		}
	}
	.cgTask-right-money {
		text {
			color: #ff5500;
		}
	}
}
</style>
