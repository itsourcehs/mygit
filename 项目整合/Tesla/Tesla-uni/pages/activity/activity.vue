<template>
	<view class="page">
		<view class="header">
			<view class="location-box">
				<image class="icon" src="../../static/images/icon/location_search.png"></image>
				<view class="location">北京</view>
				<view class="switch-location">切换</view>
			</view>
		</view>
		
		<view class="swiper" v-if="recommendActivities.length">
			
			<swiper autoplay="true" @change="onSwiperChange">
				<swiper-item v-for="(activity,index1) in recommendActivities" :key="index1">
					<view class="item-box" @tap="goToDetail" :data-id="activity._id">
						<image class="cover" :src="activity.cover"></image>
						<view class="meta">
							<view class="title">{{activity.title}}</view>
							<view class="subtitle">{{activity.subtitle}}</view>
						</view>
					</view>
				</swiper-item>
			</swiper>
			
			<view class="dots">
				<view
				v-for="(item,index) in recommendActivities"
				class="dot"
				:class="[current !== index || 'active']"
				:key="index">
					
				</view>
			</view>
		</view>
		
		<view class="list">
			<view class="list-title">最新活动</view>
			<view class="activity-item" v-for="(item,index) in activities" :key="index">
				<view class="title">{{item.title}}</view>
				<view class="icon-bar">车主专属</view>
				<view class="date-area">
					<view class="date">{{item.start_time}} - {{item.end_time}}</view>
					<view class="status-tag signing-up" v-if="item.status === 'signing-up'">报名中</view>
					<view class="status-tag signing-end" v-if="item.status === 'signing-end'">报名结束</view>
					<view class="status-tag signed" v-if="item.status === 'signed'">已报名</view>
				</view>
				<view class="address">{{item.address}}</view>
			</view>
			
			<van-loading custom-class="loading-text" size="24px" vertical v-if="false">加载中....</van-loading>
			<view class="no-more" v-if="false">没有更多了</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				recommendActivities: [
					{
						_id: '50264178a123d51515',
						cover: require("@/static/images/icon/car.png"),
						title: 'T-LIFE北京|开启智能「特」别车主生活',
						subtitle: '欢迎您参加我们每周车主活动，给您带来不一样的特斯拉之旅'
					},
					{
						_id: '485d2738am56213124',
						cover: require("@/static/images/icon/car1.png"),
						title: 'T-LIFE北京|开启智能「特」别车主生活',
						subtitle: '欢迎您参加我们每周车主活动，给您带来不一样的特斯拉之旅'
					}
				],
				current: 0,
				activities: [
					{
						title: 'T-PASSPORT北京|新车主护照领取',
						start_time: '11月1日 10:00',
						end_time: '11月30日 18:00',
						status: 'signing-end' ,// signing-up:报名中  signing-end:报名结束 signed:已报名
						address: '北京 · 北京蟹岛特斯拉中心'
					},
					{
						title: 'S3XY TREAUSRE北京| 打卡京城「特」级充电站打卡赢取惊喜好礼',
						start_time: '11月1日 10:00',
						end_time: '11月30日 18:00',
						status: 'signing-up' ,
						address: '北京 · 北京特斯拉超充'
					}
				]
			}
		},
		methods: {
			// 活动详情页
			goToDetail (e) {
				const id = e.currentTarget.dataset.id
				uni.navigateTo({
					url: `/subpkg/activity-detail/activity-detail?id=${id}`
				})
			},
			
			// 切换轮播图
			onSwiperChange (e) {
				this.current = e.detail.current
			}
		}
	}
</script>

<style>
@import url("activity.css");
</style>
