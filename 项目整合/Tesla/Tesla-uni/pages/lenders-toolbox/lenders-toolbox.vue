<template>
	<view class="lenders-toolbox-page">
		
		<view class="head-line">金融服务</view>
		
		<view class="section product-selection-area">
			<view class="title">请选择你感兴趣的车型</view>
			<view class="form-item"><tesla-picker></tesla-picker></view>
			<view class="form-item"><tesla-picker></tesla-picker></view>
			<view class="form-item"><tesla-picker></tesla-picker></view>
		</view>
		
		<view class="section" style="margin-bottom: 106rpx;">
			<view class="title">选择金融方案</view>
			<view class="form-item"><tesla-selection></tesla-selection></view>
			<view class="tips">通过特斯拉指定的通过特斯拉指定的通过特斯拉指定的通过特斯拉指定的</view>
			<view class="form-item"><tesla-picker></tesla-picker></view>
			<view class="form-item"><tesla-picker></tesla-picker></view>
			<view class="form-item"><tesla-input></tesla-input></view>
			<view class="form-item"><tesla-input label="年化率(%)" disabled tips="折合年化率7.30%"></tesla-input></view>
		</view>
		
		<view class="section">
			<view class="title">查看适用金融机构</view>
			<view class="form-item"><tesla-picker></tesla-picker></view>
			<view class="form-item"><tesla-picker></tesla-picker></view>
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
@import url("lenders-toolbox.css");
</style>
