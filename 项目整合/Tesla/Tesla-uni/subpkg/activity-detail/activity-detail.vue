<template>
	<view class="page">
		<image class="cover" mode="aspectFill" :src="activity.cover"></image>
		
		<view class="main">
			<view class="title">{{activity.title}}</view>
			<view class="icon-bar">车主专属</view>
			<view class="date-area">
				<view class="date">{{activity.start_time}} - {{activity.end_time}}</view>
				<view class="status-tag signing-up" v-if="item.status === 'signing-up'">报名中</view>
				<view class="status-tag signing-end" v-if="item.status === 'signing-end'">报名结束</view>
				<view class="status-tag signed" v-if="item.status === 'signed'">已报名</view>
			</view>
			<view class="address">{{activity.address}}</view>
			<view class="description-label">活动详情</view>
			<rich-text class="description-content" :nodes="activity.description"></rich-text>
			<view class="apply-timerange">报名时间: {{activity.start_time}} - {{activity.end_time}}</view>
			<view class="activity-apply-btn" v-if="!activityCurrentUserApplication">立即报名</view>
			<view class="activity-apply-btn disable" v-if="activityCurrentUserApplication">已报名</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				activityCurrentUserApplication: true, // 是否已报名
				activity: {},
				activityObject1: {
					cover: require("@/static/images/icon/car.png"),
					title: 'T-LIFE北京|开启智能「特」别车主生活',
					start_time: '11月1日 10:00',
					end_time: '11月30日 18:00',
					status: 'signing-end' ,// signing-up:报名中  signing-end:报名结束 signed:已报名
					address: '北京 · 北京蟹岛特斯拉中心',
					description: '如果能擁有彩虹 Tesla 電動車三天的時間，您是否有長久埋藏在心中的行動可以立即啟程？我們在找尋放膽作夢、有遠見的提案，把心中瘋狂的想法化作對未來改變的願景。「與驕傲同行–放膽作夢」（Drive with Pride 2021）不限題材，但是絕對要勇敢上路，把夢想做大。'
				},
				activityObject2: {
					cover: require("@/static/images/icon/car1.png"),
					title: 'S3XY TREAUSRE北京| 打卡京城「特」级充电站打卡赢取惊喜好礼',
					start_time: '11月1日 10:00',
					end_time: '11月30日 18:00',
					status: 'signing-up' ,
					address: '北京 · 北京蟹岛特斯拉中心',
					description: 'Tesla Taiwan 希望透過長期舉辦「Drive with Pride 與驕傲同行」活動，一步步匯聚「改變」的力量。希望藉由駕駛彩虹 Tesla 電動車，讓您心中埋藏的計畫能再次萌發新芽，能往前更推進一步；讓那些尚未付諸行動的念頭、或許有些瘋狂的想法、年輕時塵封的計畫，得以有機會被實踐、驕傲地讓大家看見。'
				}
			};
		},
		onLoad(e) {
			// 页面加载时调用
			this.loadData(e.id)
		},
		methods: {
			loadData (val) {
				// 根据上一页面传递的id获取数据
				if (val === '50264178a123d51515') {
					this.activity = this.activityObject1
				}
				if (val === '485d2738am56213124') {
					this.activity = this.activityObject2
				}
			}
		}
	}
</script>

<style lang="scss">
@import url("activity-detail.css");
</style>
