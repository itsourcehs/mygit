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
					<view class="tool_add" @tap="handleAddImgs">+</view>
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
				inpStatus: false,
				imageList: [],
				// 默认图片
				src: '../../static/upload.png',
				// 选择的图片张数
				length: '1',
				// 外网的图片路径数组
				uploadImages: [],
				
			}
		},
		methods: {
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
			
			handleChooseImg () {
				const len = _this.length
				if (len > 2) {
					uni.$showMsg('最多上传三张照片...')
					return;
				}
			},
			
			// 上传图片到服务器(待完善)
			handleToServer () {
				
				uni.showLoading({
					title: '正在上传中....',
				})
				
				console.log(imageList);
				imageList.forEach((file, i) => {
					uni.uploadFile({
						// 上传的图片路径
						filePath: file,
						name: 'images', // 上传的文件名称,后台用来获取文件 file (自定义名称)
						url: 'https://api.uomg.com/api/image.baidu',
						success: (res) => {
							// console.log('上传到服务器成功...', res);
							console.log(res);
							
							
						},
						fail: (err) => {}
					})
				})
			},
			
			// 提交
			handleSubmit () {
				console.log('正常点击提交按钮...');
			},
			
			// 处理改变问题类型
			handleTypeBtn (e) {
				console.log('e的值是:', e.currentTarget.dataset.id.id); // 拿到对应id
				const title = e.currentTarget.dataset.id.title
				uni.$showMsg('您选择的是:' + title)
			},
			
			// 文本域处理函数
			handleInput (e) {
				console.log('文本框里的内容是:',e);
				const inp = e.detail.value
				this.textContent = inp
				
				if (inp) this.inpStatus = true
				
			}
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
