<template>
	<view class="login-container">
		<uni-icons type="contact-filled" size="100" color="#AFAFAF"></uni-icons>
		<!-- 可以从 @getuserinfo 事件处理函数的形参中，获取到用户的基本信息 -->
		<button
		type="primary"
		class="btn-login"
		open-type="getUserInfo"
		@getuserinfo="getUserInfo">一键登录</button>
		<view class="tips-text">登录后尽享更多权益</view>
	</view>
</template>

<script>
	// 1. 按需导入 mapMutations 辅助函数
	import { mapMutations } from 'vuex'
	export default {
		name:"my-login",
		data() {
			return {
				
			};
		},
		methods: {
			// 获取微信用户的基本信息
			getUserInfo (e) {
				// console.log(e);
				// 判断是否获取用户信息成功
				if (e.detail.errMsg === 'getUserInfo:fail auth deny') return uni.$showMsg('您取消了登录授权！')
				
				// console.log(e.detail.userInfo);
				
				// 将用户的基本信息存储到 vuex 中
				this.updateUserInfo(e.detail.userInfo)
				
				// 获取登录成功后的 Token 字符串
				// this.getToken(e.detail)
				this.handleUserInfo(e.detail)
			},
			
			// 把 m_user 模块中的 updateUserInfo 映射到当前组件中使用
			...mapMutations('m_user', ['updateUserInfo', 'updateToken']),
			
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
				
				if (loginResult.meta.status !== 200) return uni.$showMsg('登录失败2！')
				
				uni.$showMsg('登录成功')
				
				this.updateToken(loginResult.message.token)
			},
		
			handleUserInfo(e){
				console.log(e);
			    new Promise((resolve, reject) => {
			        wx.login({
			          success: (res) => {
			            let code = res.code; //返回一个code
			            const loadingParams = {
			              encryptedData: e.encryptedData,
			              rawData: e.rawData,
			              iv: e.iv,
			              signature: e.signature,
			              code
			            }; // 创建一个对象 执行resolve
			            resolve(loadingParams); // 把创建的对象当作参数
			          },
			          fail(err) {
			            reject(err);
			          }
			        })
			      }).then(res => {  // res 就是resolve 中的参数
			        console.log(res);
			        wx.request({
			          url: 'https://www.uinav.com/api/public/v1/users/wxlogin', // 相当于登录的接口
			          data: res,
			          method: 'post',
			          success(res) { 
			            // res中一般会包含一个token
			            // wx.navigateBack({ // 返回上一个页面
			            //   delta: 1
			            // });
						console.log(res);
			          },
			          fail(err) {
			            console.log(err);
					}
				})
			  })
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
