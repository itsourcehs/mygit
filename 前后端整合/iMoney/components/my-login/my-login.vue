<template>
	<view class="login">
		<text>登录领取海量任务开始赚钱</text>
		<u-button type="error" size="middle">登录</u-button>
	</view>
</template>

<script>
import uButton from 'uview-ui/components/u-button/u-button.vue'	
export default {
	components: {uButton},
	name:"my-login",
	data() {
		return {
			
		};
	}
}
</script>

<style lang="scss">
.login {
	height: 80rpx;
	width: 100%;
	display: flex;
	background-color: #ffe2d9;
	padding:10px;
	position: fixed;
	bottom: 90rpx;
}
</style>
