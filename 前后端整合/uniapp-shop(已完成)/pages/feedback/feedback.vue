<template>
	<view>
		<view class="feedback_main">
			<view style="font-size: 24rpx;">问题种类</view>
			<view class="feedback_types">
				<view
				class="feedback_types_item"
				v-for="(item, index) in types"
				:key="index"
				@tap="handleTypeBtn"
				:data-id="item">{{item.title}}</view>
				<view style="padding: 6px 13px;width: 30%;"></view>
			</view>
			
			<!-- 反馈内容区域 -->
			<view class="feedback_text">
				<textarea :value="textContent" @input="handleInput" name="" id="" cols="30" rows="10" placeholder="请描述你的问题..." placeholder-class="place"></textarea>
				<view class="feedback_uploadImage">
					<image @tap="handleChooseImg" src="../../static/upload.png"></image>
					<view
					style="position: relative;"
					v-for="(item, index) in uploadImages"
					:key="index">
						<image style="margin-left: 10px;" :src="item"></image>
						<icon
						type="clear" size="20" color="red"
						v-if="imageList.length > 0"
						:data-index="index"
						@tap="handleClose"></icon>
					</view>
				</view>
			</view>
			
			<!-- 提交按钮 区域 -->
			<view class="btns" @tap="handleSubmit">
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
		<!-- <my-upload :imageList="imageList"></my-upload> -->
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
				// 反馈问题类型
				types: [
					{
						id: 1,
						title: '功能建议'
					},
					{
						id: 2,
						title: '购买遇到问题'
					},
					{
						id: 3,
						title: '性能问题'
					},
					{
						id: 4,
						title: '其他'
					},
				]
			}
		},
		methods: {
			// 处理删除已上传的图片
			handleClose (e) {
				
			},
			
			// 选择图片
			handleChooseImg () {
				var _this = this
				
				const len = this.length
				if (len > 2) {
					uni.$showMsg('最多上传三张照片...')
					return;
				}
				
				uni.chooseImage({
					count: 3,
					sizeType: ['original', 'compressed'],
					sourceType: ['album', 'camera'],
					success (res) {
						uni.$showMsg('照片上传成功...')
						// tempFilePaths 作为 img 标签的src属性显示图片
						// console.log(res.tempFilePaths);
						// _this.imageList = res.tempFilePaths
						_this.imageList.push(JSON.stringify(res.tempFilePaths))
						
						
						// this.handleToServer()
					}
				})
			},
			
			// 上传图片到服务器(待完善)
			handleToServer () {
				
				uni.showLoading({
					title: '正在上传中....',
				})
				const imageList = _this.imageList
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
.feedback_text image {width: 120rpx;height: 120rpx;}
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
