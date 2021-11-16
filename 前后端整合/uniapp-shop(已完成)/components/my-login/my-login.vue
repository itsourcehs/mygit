<template>
	<view class="login-container">
		<uni-icons type="contact-filled" size="100" color="#AFAFAF"></uni-icons>
		<!-- 可以从 @getuserinfo 事件处理函数的形参中，获取到用户的基本信息 -->
		<!-- <button
		type="primary"
		class="btn-login"
		open-type="getUserInfo"
		@getuserinfo="getUserInfo">一键登录(弃用)</button> -->
		<button
		type="primary"
		class="btn-login"
		@tap="getUserProfile">一键登录</button>
		<view class="tips-text">登录后尽享更多权益</view>
	</view>
</template>

<script>
	// 1. 按需导入 mapMutations 辅助函数
	import { mapMutations, mapState } from 'vuex'
	export default {
		name:"my-login",
		data() {
			return {
				
			};
		},
		computed: {
			// 调用mapState辅助方法,将 m_user 模块中的数据映射到当前组件使用
			...mapState('m_user', ['redirectInfo']),
		},
		methods: {
			/*
			 * 获取微信用户的基本信息(已弃用)
			 * 微信登录授权调整:https://developers.weixin.qq.com/community/develop/doc/000cacfa20ce88df04cb468bc52801?highLine=login
			 */
			getUserInfo (e) {
				// console.log(e);
				// 判断是否获取用户信息成功
				if (e.detail.errMsg === 'getUserInfo:fail auth deny') return uni.$showMsg('您取消了登录授权！')
				
				// console.log(e.detail.userInfo);
				
				// 将用户的基本信息存储到 vuex 中
				this.updateUserInfo(e.detail.userInfo)
				
				// 获取登录成功后的 Token 字符串
				this.getToken(e.detail)
				
			},
			
			// 获取微信用户的基本信息
			getUserProfile (e) {
				// 1.调用wx.getUserProfile获取用户信息
				wx.getUserProfile({
					desc: '用于测试登录获取基本信息!',
					success: (res) => {
						// console.log(res);
						// 2.将用户的基本信息存储到 vuex 中
						// console.log(res.userInfo);
						this.updateUserInfo(res.userInfo)
						
						// 3.获取登录成功后的 Token 字符串
						this.getToken(res)
					}
				})
			},
			
			
			// 把 m_user 模块中的 updateUserInfo 映射到当前组件中使用
			...mapMutations('m_user', ['updateUserInfo', 'updateToken', 'updateRedirectInfo']),
			
			async getToken (info) {
				console.log(info);
				// 调用微信登录接口
				// const [err, res] = await uni.login().catch(err => err)
				const [err, res] = await uni.login({
					onlyAuthorize: true
				}).catch(err => err)
				console.log(res);
				
				// 判断是否 uni.login() 调用失败
				if (err || res.errMsg !== 'login:ok') return uni.$showError('登录失败1！')
				
				// 准备参数
				const query = {
					code: res.code,
					encryptedData: info.encryptedData,
					iv: info.iv,
					rawData: info.rawData,
					signature: info.signature
				}
				
				// 换取token
				console.log(query);
				const { data: loginResult } = await uni.$http.post('/api/public/v1/users/wxlogin', query)
				console.log(loginResult);
				
				// if (loginResult.meta.status !== 200) return uni.$showMsg('登录失败2！')
				
				uni.$showMsg('登录成功')
				
				// this.updateToken(loginResult.message.token)
				this.updateToken("eyJhb6cioi31UzI1NiJ9") // 假token
				
				/*
				 * 判断 vuex 中 redirectInfo 是否为 null
				 * 如果不为 null,则登录成功后重新导航到对应的页面 
				 */
				this.navigateBack()
			},
			
			// 返回登录前的页面
			navigateBack () {
				// 1.如果redirectInfo 不为 null 且导航方式为 switchTab
				if (this.redirectInfo && this.redirectInfo.openType === 'switchTab') {
					// 2.调用uni.switchTab()
					uni.switchTab({
						url: this.redirectInfo.from,
						// 导航成功后,把 vuex 中的 redirectInfo 对象重置为 null
						complete: () => {
							this.updateRedirectInfo(null)
						}
					})
				}
			},
		
		}
	}
</script>

<style lang="scss">
.login-container {
	height: 750rpx;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	background-color: #f8f8f8;
	position: relative;
	overflow: hidden;
	
	// 登录盒子底部半椭圆造型
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
	
	// 登录按钮
	.btn-login {
		width: 90%;
		border-radius: 100px;
		margin: 15px 0;
		background-color: #c00000;
	}
	
	// 提示文本的样式
	.tips-text {font-size: 12px;color: gray;}
}
</style>
