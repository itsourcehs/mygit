<template>
	<view class="signin-container">
		<view class="signin-head">
			<image src="../../static/img/chat.png" style="width: 100%;height:90px ;"></image>
		</view>
		
		<!-- 签到列表 -->
		<view class="signin-list">
			<view class="signin-list-head">
				<text>已连续签到<span>1</span>天</text>
				<view>
					<text>签到提醒</text>
					<u-switch></u-switch>
				</view>
			</view>
			<text style="margin-bottom: 30px;">剩余一元提现卡0张/剩余任务奖金双倍卡0张</text>
			<view class="today-list">
				<view class="today-list-item">
					<icon type="success" size="16"></icon>
					<text>1天</text>
				</view>
				<view class="today-list-item">
					<icon type="success" size="16"></icon>
					<text>1天</text>
				</view>
				<view class="today-list-item">
					<icon type="success" size="16"></icon>
					<text>1天</text>
				</view>
				<view class="today-list-item">
					<icon type="success" size="16"></icon>
					<text>1天</text>
				</view>
				<view class="today-list-item">
					<icon type="success" size="16"></icon>
					<text>1天</text>
				</view>
				<view class="today-list-item">
					<icon type="success" size="16"></icon>
					<text>1天</text>
				</view>
				<view class="today-list-item">
					<icon type="success" size="16"></icon>
					<text>1天</text>
				</view>
				<view class="today-list-item">
					<icon type="success" size="16"></icon>
					<text>1天</text>
				</view>
				<view class="today-list-item">
					<icon type="success" size="16"></icon>
					<text>1天</text>
				</view>
				<view class="today-list-item">
					<icon type="success" size="16"></icon>
					<text>1天</text>
				</view>
				<view class="today-list-item">
					<icon type="success" size="16"></icon>
					<text>1天</text>
				</view>
				<view class="today-list-item">
					<icon type="success" size="16"></icon>
					<text>1天</text>
				</view>
			</view>
		</view>
		
		<!-- 友链区域 -->
		<view class="you-lian">
			<image></image>
			<image></image>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			};
		}
	}
</script>

<style lang="scss">
.signin-container {width: 100%;height: 100%;}
.signin-list {height: 500rpx;background-color: #ffffff;
	padding:10px;
	position: relative;
	top: -30px;
	margin: 5rpx 25rpx 0;
	border-radius: 3%;
	border: 1px solid #C0C4CC;
	
	.signin-list-head {
		display: flex;justify-content: space-between;align-content: center;
		margin-bottom: 40rpx;
	}
}

.today-list {
	display: flex;flex-wrap: wrap;padding-top: 20rpx;margin-top: 20rpx;
	
	.today-list-item {align-items: center;
		width: 50px;margin: 0 0 10px 10px;
		display: flex;flex-direction: column;
	}
}
</style>
