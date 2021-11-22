<template>
	<view style="display: flex;">
		<image @tap="handleChooseImg" :src="src"></image>
		<view
		style="position: relative;"
		v-for="(item,index) in imageList"
		:key="index">
			<image style="margin-left: 10px;"
			:src="item"></image>
			<image style="width: 30rpx;height: 30rpx;position: absolute;right: -5px;top: -5px;"
			src="../../static/close_fill.png"
			v-if="imageList.length > 0"
			:data-index="index"
			@tap="handleClose"></image>
		</view>
		
		
	</view>
</template>

<script>
	export default {
		name:"my-upload",
		data() {
			return {
				
			};
		}
	}
</script>

<style>

</style>
