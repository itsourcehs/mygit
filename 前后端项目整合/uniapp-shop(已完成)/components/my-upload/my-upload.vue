<template>
	<view class="content">
		<image :src="imgSrc"></image>
		<!-- <icon type="clear" color="red" size="23"></icon> -->
	</view>
</template>

<script>
	export default {
		name:"my-upload",
		props: {
			// 图片路径
			imgSrc: {
				type:String,
				value:''
			}
		},
		data() {
			return {
				
			};
		},
		methods: {
		}
	}
</script>

<style>
image {width: 100%;height: 100%;}
.content {
	position: relative;
	width: 100rpx;
	height: 100rpx;
	border-radius: 10rpx;
}
</style>
