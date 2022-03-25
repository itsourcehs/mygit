<template>
	<div class="login">
		
		<!-- 登录表单 -->
		<el-form v-model="loginForm" class="login-form" ref="loginForm">
			<h3 class="title">Admin后台管理系统</h3>
			
			<el-form-item prop="username">
				<el-input v-model="loginForm.username" type="text" auto-complete="off" placeholder="账号">
					<!-- <svg-icon></svg-icon> -->
				</el-input>
			</el-form-item>
			
			<el-form-item prop="password">
				<el-input v-model="loginForm.password" type="password" auto-complete="off" placeholder="密码">
					<!-- <svg-icon></svg-icon> -->
				</el-input>
			</el-form-item>
			
			<el-form-item prop="code">
				<el-input v-model="loginForm.code" auto-complete="off" placeholder="验证码">
					<!-- <svg-icon></svg-icon> -->
				</el-input>
				<div class="login-code">
					<img :src="codeUrl" @click="getCode" />
				</div>
			</el-form-item>
			
			<!-- <el-checkbox v-model="loginForm.rememberMe" style="margin: 0 0 25px;">记住我</el-checkbox> -->
			
			<el-form-item style="width: 100%;">
				<el-button class="login-button" @click.native.prevent="handleLogin" :loading="loading" size="medium" type="primary" style="width: 23%;">
					<span v-if="!loading">登 录</span>
					<span v-else>登录中...</span>
				</el-button>
			</el-form-item>
			
		</el-form>
	</div>
</template>

<script>
export default {
	name: 'Login',
	data () {
		return {
			codeUrl: '',
			loginForm: {
				username: 'admin',
				password: '1234',
				rememberMe: false,
				code: '1234'
			},
			loading: false
		}
	},
	methods: {
		// 获取验证码
		getCode () {},
		
		// 处理登录
		handleLogin () {
			const _this = this
			// 获取登录表单的账号，密码，验证码信息
			const username = _this.loginForm.username
			const password = _this.loginForm.password
			const code = _this.loginForm.code
			
			console.log('用户名:'+ username, '密码:'+password, '验证码:'+code);
			
			// 1.如果用户名，密码，验证码验证通过
			if (username !== 'admin' || password !== '1234' || code !== '1234') return this.$message.error('用户验证失败!')
			_this.loading = true
			setTimeout(function() {_this.$router.push('/index')}, 2000);
			// 2.登录成功后路由跳转到首页
			
		}
	}
}
</script>

<style lang="scss">
.login {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100%;
	background-size: cover;
}
.login-form {
	border-radius: 6px;
	width: 385px;
	padding: 25px 25px 5px;
	box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
}

.login-button {
	padding: 10px;
	border-radius: 30px;
}

</style>
