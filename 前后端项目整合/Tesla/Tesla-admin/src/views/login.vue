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
			
			<el-checkbox v-model="loginForm.rememberMe" style="margin: 0 0 25px;">记住我</el-checkbox>
			
			<el-form-item style="width: 100%;">
				<el-button @click.native.prevent="handleLogin" :loading="loading" size="medium" type="primary" style="width: 13%;">
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
				code: ''
			},
			loading: false
		}
	},
	methods: {
		// 获取验证码
		getCode () {},
		
		// 处理登录
		handleLogin () {}
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
	background: #ffffff;
}

</style>
