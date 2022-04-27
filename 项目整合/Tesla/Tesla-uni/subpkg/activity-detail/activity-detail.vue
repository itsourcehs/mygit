<template>
	<view class="page">
		<image class="cover" mode="aspectFill" :src="activityObject.activityCover"></image>
		
		<view class="main">
			<view class="title">{{activityObject.activityTitle}}</view>
			<view class="icon-bar">车主专属</view>
			<view class="date-area">
				<view class="date">{{activityObject.startTime}} - {{activityObject.endTime}}</view>
				<view class="status-tag signing-up" v-if="activityObject.activityStatus === 'signing-up'">报名中</view>
				<view class="status-tag signing-end" v-if="activityObject.activityStatus === 'signing-end'">报名结束</view>
				<view class="status-tag signed" v-if="activityObject.activityStatus === 'signed'">已报名</view>
			</view>
			<view class="address">{{activityObject.activityAddress}}</view>
			<view class="description-label">活动详情</view>
			<rich-text class="description-content" :nodes="activityObject.activitySubtitle"></rich-text>
			<view class="apply-timerange">报名时间: {{activityObject.startTime}} - {{activityObject.endTime}}</view>
			<view class="activity-apply-btn" v-if="activityCurrentUserApplication" @tap="apply" :data-id="activityObject.id">立即报名</view>
			<view class="activity-apply-btn disable" v-if="!activityCurrentUserApplication">已报名</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				activityCurrentUserApplication: true, // 是否已报名
				activity: {},
				activityObject: {}
			};
		},
		onLoad(e) {
			// 页面加载时调用
			this.loadData(e.id)
		},
		methods: {
			// 立即报名
			apply (e) {
				const id = e.currentTarget.dataset.id
				uni.navigateTo({
					url: `/subpkg/activity-apply/activity-apply?id=${id}`
				})
			},
			
			async loadData (val) {
				// 根据上一页面传递的id获取数据
				await this.$api({url: '/api/activity/'+ val}).then(res => {
					this.activityObject = res.data.data
				})
			}
			
		}
	}
</script>

<style lang="scss">
@import url("activity-detail.css");
</style>
