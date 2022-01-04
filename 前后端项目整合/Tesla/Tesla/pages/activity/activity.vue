<template>
	<view class="page">
		<view class="header">
			<view class="location-box">
				<image class="icon"></image>
				<view class="location"></view>
				<view class="switch-location">切换</view>
			</view>
		</view>
		
		<view class="swiper">
			<swiper>
				<swiper-item>
					<view class="item-box">
						<image class="cover"></image>
						<view class="meta">
							<view class="title"></view>
							<view class="subtitle"></view>
						</view>
					</view>
				</swiper-item>
			</swiper>
			
			<view class="dots">
				<view
				class="dot"
				:class="[current !== index || 'active']"
				v-for="(item,index) in recommendActivities"
				:key="index">
					
				</view>
			</view>
		</view>
		
		<view class="list">
			<view class="list-title">最新活动</view>
			<view class="activity-item">
				<view class="title">标题</view>
				<view class="icon-bar">车主专属</view>
				<view class="date-area">
					<view class="date">2021.12.03 - 2022.12.02</view>
					<view class="status-tag signing-up">报名中</view>
					<view class="status-tag signing-end">报名结束</view>
				</view>
				<view class="address"></view>
			</view>
			<van-loading custom-class="loading-text" size="24px" vertical>加载中....</van-loading>
			<view class="no-more">没有更多了</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				recommendActivities: [],
				current: 0
			}
		},
		methods: {
			
		}
	}
</script>

<style>
@import url("activity.css");
</style>
