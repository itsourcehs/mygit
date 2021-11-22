<template>
	<view>
		<view class="feedback_main">
			<view style="font-size: 24rpx;">问题种类</view>
			<view class="feedback_types">
				<view class="feedback_types_item"></view>
				<view style="padding: 6px 13px;width: 30%;"></view>
			</view>
			
			<!-- 反馈内容区域 -->
			<view class="feedback_text">
				<textarea name="" id="" cols="30" rows="10" placeholder="请描述你的问题..." placeholder-class="place"></textarea>
				<view class="feedback_uploadImage">
					<image></image>
					<view style="position: relative;">
						<image></image>
						<icon
						type="clear" size="20" color="red"
						v-if="imageList.length > 0"></icon>
					</view>
				</view>
			</view>
			
			<!-- 提交按钮 区域 -->
			<view class="btns">
				<button
				class="btn"
				:class="[inpStatus?'add':'']">
					<view style="margin-left: 23px;">
						<image src="../../static/trues.png"></image>
						<text>提交</text>
					</view>
				</button>
			</view>	
		</view>
		
		<!-- 上传图片组件区域 -->
		<my-upload></my-upload>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				// 默认不添加样式
				inpStatus: false,
				imageList: [],
				// 默认图片
				src: ''
			}
		},
		methods: {
			handleChooseImg () {
				return '选择图片'
			}
		}
	}
</script>

<style>
textarea {width: 100%;height: 100px;padding: 10px;}
icon {
	width: 30rpx;height: 30rpx;
	position: absolute;
	right: -5px;
	top: -5px;
}
.feedback_main {padding: 20rpx;}
.feedback_uploadImage {display: flex;}
.feedback_types {
	display: flex;
	justify-content: space-around;
	align-content: flex-start;
	flex-wrap: wrap;
	width: 100%;
	padding: 19px 0;
	font-size: 12px;
}
.feedback_types_item {
	padding: 6px 13px;
	background: #fff;
	text-align: center;
	width: 30%;margin-top: 20rpx;
}
.feedback_text {background: #fff;width: 100%;}
.btns {position: relative;}
.btns image {
	width: 40rpx;height: 40rpx;
	position: absolute;left: 22px;top: 11px;
}
.btn {
	color: #fff;
	width: 30% !important;
	position: absolute;
	right: 0;top: 10px;
}
.add {
	background: var(--themeColor);
}
</style>
