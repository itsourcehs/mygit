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
					<view class="item-box" @tap="goToDetail" :data-id="activity.id">
						<image class="cover" :src="activity.activityCover"></image>
						<view class="meta">
							<view class="title">{{activity.activityTitle}}</view>
							<view class="subtitle">{{activity.activitySubtitle}}</view>
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
				<view class="title">{{item.activityTitle}}</view>
				<view class="icon-bar">车主专属</view>
				<view class="date-area">
					<view class="date">{{item.startTime}} - {{item.endTime}}</view>
					<view class="status-tag signing-up" v-if="item.activityStatus === 'signing-up'">报名中</view>
					<view class="status-tag signing-end" v-if="item.activityStatus === 'signing-end'">报名结束</view>
					<view class="status-tag signed" v-if="item.activityStatus === 'signed'">已报名</view>
				</view>
				<view class="address">{{item.activityAddress}}</view>
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
				recommendActivities: [],
				current: 0,
				activities: []
			}
		},
		methods: {
			// 获取活动列表
			async getActivityList () {
				await this.$api({url: '/api/activity/all'}).then(res => {
					this.recommendActivities = res.data.data
					this.activities = res.data.data
				})
			},
			
			
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
		},
		onLoad() {
			this.getActivityList()
		}
	}
</script>

<style>
@import url("activity.css");
</style>
