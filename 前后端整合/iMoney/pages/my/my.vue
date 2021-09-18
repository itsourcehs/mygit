<template>
	<view>
		<view class="my-back">
			<image src="../../static/img/chat.png" style="width: 100%;height:90px ;"></image>
		</view>
		
		<view class="login-head">
			<view class="login-head-top">
				<view class="login-head-top-left">
					<image src="../../static/img/chat.png" class="avatar"></image>
				</view>
				<view class="login-head-top-right">
					<text>未登录</text>
					<view class="login-head-top-right-bottom">
						<u-button type="error" size="mini" style="margin-right: 50rpx;">签到 ></u-button>
						<u-button type="error" size="mini">走路 ></u-button>
					</view>
				</view>
			</view>
			<view class="login-head-bottom">
				<view class="login-head-bottom-item">
					<text>***</text>
					<text>账户余额(元)</text>
				</view>
				<view class="login-head-bottom-item">
					<text>***</text>
					<text>累计收入(元)</text>
				</view>
				<u-button type="error" size="mini">立即提现</u-button>
			</view>
		</view>
	
		<!-- 收支列表区域 -->
		<view class="list">
			<view class="list-item">
				<image src="../../static/img/chat.png" class="avatar"></image>
				<text>收支明细</text>
			</view>
			<view class="list-item">
				<image src="../../static/img/chat.png" class="avatar"></image>
				<text>审核列表</text>
			</view>
			<view class="list-item">
				<image src="../../static/img/chat.png" class="avatar"></image>
				<text>金币明细</text>
			</view>
			<view class="list-item">
				<image src="../../static/img/chat.png" class="avatar"></image>
				<text>收徒管理</text>
			</view>
			<view class="list-item">
				<image src="../../static/img/chat.png" class="avatar"></image>
				<text>帮助与反馈</text>
			</view>
			<view class="list-item">
				<image src="../../static/img/chat.png" class="avatar"></image>
				<text>关于我们</text>
			</view>
		</view>
		
		<view style="height: 180rpx;">
			<image src="../../static/img/money.png" style="width: 100%;height: 100%;"></image>
		</view>
		<my-login></my-login>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style lang="scss">
.my-back {
	height: 200rpx;
	position: relative;
	overflow: hidden;
	
	&::after {
		content: ' ';
		display: block;
		position: absolute;
		width: 100%;
		height: 40px;
		left: 0;
		bottom: 0;
		background-color: white;
		border-radius: 100%;
		transform: translateY(50%);
	}
}
.login-head {
	height: 350rpx;
	background-color: #ffffff;
	padding: 0 10px;
	position: relative;
	top: -100px;
	margin: 25rpx 25rpx 0;
	display: flex;
	flex-direction: column;
	justify-content: space-around;
	border-radius: 3%;
	border: 1px solid #C0C4CC;
	box-shadow: darkgrey 0px 0px 30px 5px;
}
.login-head-top {
	border-bottom: 1px solid #C8C9CC;padding-bottom: 20rpx;
	width: 90%;height: 130rpx;display: flex;justify-content:space-between;align-items: center;}
.login-head-bottom {
	width: 90%;height: 130rpx;
	display: flex;
	padding:10rpx;
	align-items: center;
	margin-top: -50rpx;
}
.avatar {
	display: block;
	width: 55px;
	height: 55px;
	border-radius: 45px;
	border: 2px solid white;
	box-shadow: 0 1px 5px black;
}
.login-head-top-right {
	height: 98%;width: 80%;
	padding-left: 15rpx;
	display: flex;flex-direction: column;justify-content: space-between;
}

.login-head-bottom-item {
		display: flex;
		flex-direction: column;
		margin-right: 48rpx;
		justify-content: center;
		align-items: center;
}

.list {
	height: 450rpx;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-around;
	align-items: auto;
	align-content: start;
	margin-top: -180rpx;
	
	.list-item {
	  flex: 0 0 auto;
	  margin: 18px;
	}
}
</style>
