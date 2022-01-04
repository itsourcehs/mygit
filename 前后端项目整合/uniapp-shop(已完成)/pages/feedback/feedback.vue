<template>
	<view>
		<view class="feedback_main">
			<view style="font-size: 24rpx;padding: 20rpx 0;">问题种类</view>
			<view class="feedback_types">
				<text>功能建议</text>
				<text>购买遇到问题</text>
				<text>性能问题</text>
				<text>其他</text>
			</view>
			
			<!-- 反馈内容区域 -->
			<view class="feedback_text">
				<textarea
				:value="textContent"
				@input="handleInput" cols="30" rows="10"
				placeholder="请描述你的问题..."
				placeholder-class="place"></textarea>
				<view class="feedback_bool">
					<view
					class="tool_add"
					@tap="handleAddImgs"
					v-if="imageList.length == 0">+</view>
					<view
					class="tool_item"
					v-for="(item,index) in imageList"
					:key="index"
					>
						<my-upload :imgSrc="item"></my-upload>
						<icon
						:data-index="index"
						type="clear" color="red" size="23"
						@tap="handleRemoveImgs"></icon>
					</view>
				</view>
			</view>
			
			<!-- 提交按钮 区域 -->
			<view class="feedback_submit">
				<button @tap="handleSubmit" size="mini">
					<icon type="success_no_circle" size="23" color="white"></icon>
					提交
				</button>
			</view>
			
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				textContent: '',
				// 默认不添加样式
				inpStatus: true,
				imageList: [],
				// 默认图片
				src: '../../static/upload.png',
				// 外网的图片路径数组
				uploadImages: [],
				
			}
		},
		methods: {
			// 提交
			handleSubmit () {
				const that = this
				// 1.判断文本域输入内容是否合法
				if (!that.textContent.trim()) uni.$showMsg('输入内容不合法!!!')
				// 2.显示正在上传中
				uni.showLoading({
					title:'提交中,请稍候......'
				})
				
				// 3.判断是否选择了图片,如果没有选择图片就仅提交文本
				if (that.imageList.length != 0) {
					// 3.1 需要循环上传每一张
					that.imageList.forEach((temfile,i) => {
						uni.uploadFile({
							filePath: temfile,
							name: 'file',
							url: 'https://imgchr.com/i/MjaXxU',
							success: res => {
								console.log(res);
							}
						})
					})
				} else {}
				// 4.隐藏加载中并返回至上一个页面
				setTimeout(back => {
					uni.hideLoading();
					uni.navigateBack({
						delta: 1
					})
				},5000)
			},
			
			// 处理文本域输入内容 接收并赋值给 textContent
			handleInput (e) {
				this.textContent = e.detail.value
			},
			
			// 移除已选择的图片
			handleRemoveImgs (e) {
				// 1.获取图片元素对应的索引 e.currentTarget.dataset.index
				const index = e.currentTarget.dataset.index
				const imageList = this.imageList
				// 2.调用函数 array.splice(index,num) 进行移除
				imageList.splice(index, 1)
				this.imageList = imageList
			},
			
			// 选择图片
			handleAddImgs () {
				var vm = this
				// 1.调用 uni.chooseImage 进行选择图片
				uni.chooseImage({
					count: 3,
					sizeType: ['original', 'compressed'],
					sourceType: ['album', 'camera'],
					success: res => {
						// 2.使用扩展运算符将 success 的回调函数返回数据赋值给 imageList
						vm.imageList = [...res.tempFilePaths]
					}
				})
			},
			
			// 处理改变问题类型
			handleTypeBtn (e) {
				console.log('e的值是:', e.currentTarget.dataset.id.id); // 拿到对应id
				const title = e.currentTarget.dataset.id.title
				uni.$showMsg('您选择的是:' + title)
			},
		}
	}
</script>

<style>
page {background: #edeeec;}
textarea {width: 100%;height: 100px;padding: 10px;}

.feedback_main {padding: 20rpx;color: #666;}
.feedback_uploadImage {display: flex;}
.feedback_types {display: flex;flex-wrap: wrap;}
.feedback_types text {
	padding: 10rpx 20rpx;
	margin: 10rpx 10rpx;
	background-color: #fff;
	display: flex;justify-content: center;align-items: center;
}
.feedback_types_item {
	padding: 6px 13px;
	background: #fff;
	text-align: center;
	width: 30%;margin-top: 20rpx;
}
.feedback_text {background: #fff;width: 100%;}
.feedback_text image {width: 120rpx;height: 120rpx;}

.feedback_bool {display: flex;flex-wrap: wrap;}
.tool_add {
	width: 100rpx;
	height: 100rpx;
	margin: 20rpx;
	border-radius: 10rpx;
	background-color: #d8d8d8;
	font-size: 60rpx;
	font-weight: bold;
	text-align: center;line-height: 100rpx;
}
.tool_item {margin: 20rpx;position: relative;}
.tool_item icon {
	position: absolute;
	right: -15rpx;
	top: -15rpx;
}
/* 提交按钮样式 */
.feedback_submit {
	margin-top: 20rpx;
	display: flex;
	justify-content: flex-end;
}
.feedback_submit button {
	background-color: #c00000;
	color: #fff;
	margin: 0;
	width: 30%;
}
</style>
