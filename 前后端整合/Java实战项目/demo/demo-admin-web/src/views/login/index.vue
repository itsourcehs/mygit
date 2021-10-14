<template>
	<div>
		<!-- 登录表单区域 -->
		<el-card class="login-form-layout">
			<el-form 
			autoComplete="on"
			:model="loginForm"
			:rules="loginRules"
			ref="loginForm"
			label-position="left">
				<!-- 表单icon  待开发-->
				<!-- 表单标题 -->
				<h2 class="login-title color-main">***</h2>
				
				<!-- 用户名 -->
				<el-form-item prop="username">
					<el-input name="username"
					type="text"
					v-model="loginForm.username"
					auto-complete="on"
					placeholder="请输入用户名">
						<!-- 输入框icon  待开发-->
					</el-input>
				</el-form-item>
				<!-- 密码 -->
				<el-form-item prop="password">
					<el-input name="password"
					type="password"
					v-model="loginForm.password"
					auto-complete="on"
					placeholder="请输入密码"
					@keyup.enter.native="handleLogin">
						<!-- 输入框icon  待开发-->
					</el-input>
				</el-form-item>
				<!-- 登录 -->
				<el-form-item>
					<el-button
					style="width: 45%;"type="primary"
					@click.native.prevent="handleLogin"
					:loading="loading">登录</el-button>
					<el-button
					style="width: 45%;"type="primary"
					@click.native.prevent="handleTry">获取体验账号</el-button>
				</el-form-item>
			</el-form>
		</el-card>
		
		<!-- 体验号二维码 -->
		<el-dialog
		title="公众号二维码"
		:visible.sync="dialogVisible"
		:show-close="false"
		:center="true" width="30%">
			<div style="text-align: center">
				<span class="font-title-large"><span class="color-main font-extra-large">关注公众号</span>回复<span class="color-main font-extra-large">体验</span>获取体验账号</span>
				<br>
				<img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg" width="160" height="160" style="margin-top: 10px">
			</div>
			  <span slot="footer" class="dialog-footer">
			<el-button type="primary" @click="dialogConfirm">确定</el-button>
			  </span>
		</el-dialog>
	</div>
</template>

<script>
export default{
	name: 'login',
	data () {
		return {
			loginForm: {
				username: '',
				password: ''
			},
			loginRules: {},
			loading: false,
			dialogVisible: false
		}
	},
	methods: {
		// 获取体验账号方法
		handleTry () {this.dialogVisible =true},
		
		// 关闭体验账号对话框
		dialogConfirm () {this.dialogVisible =false},
		
		// 登录
		handleLogin () {
			this.loading = true
			var _this = this
			// 向后端发送异步请求
			this.axios.post('/admin/login', {
				username: this.loginForm.username,
				password: this.loginForm.password
			})
			.then(res => {
				if (res.data.code === 200) {
					this.$router.push({path: '/'})
				}
			}).catch(this.loading = false)
		},
		
		
	}
}
	
</script>

<style scoped>
.login-form-layout {
	position: absolute;
	left: 0;
	right: 0;
	width: 360px;
	margin: 140px auto;
	border-top: 10px solid #409EFF;
}
</style>
