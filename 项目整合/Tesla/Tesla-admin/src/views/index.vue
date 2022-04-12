<template>
  <div class="index">
	  <div class="index-header">
		<div class="index-header-left">
			<el-avatar shape="circle" :size="avatarSize" :fit="avatarFit" :src="avatarUrl"></el-avatar>
			<div class="text">
				<span style="font-size: 18px;">您好，管理员，祝您开心每一天!</span>
				<span style="font-size: 13px;font-weight: 100;">我们用代码编写梦想，用梦想改变世界。</span>
			</div>
		</div>
		<div class="index-header-right">
			<div class="right-span">
				<span>项目数</span>
				<span>56</span>
			</div>
			<div class="right-span">
				<span>团队内排名</span>
				<span>8/24</span>
			</div>
			<div class="right-span">
				<span>项目访问</span>
				<span>2,223</span>
			</div>
		</div>
		</div>
	  
	  <div class="index-main">
		  <div class="main-left">
		    <span>简介</span>
		    <el-divider></el-divider>
		    <span style="font-size: 13px;font-weight: 100;">SpringBlade 2.0是一个基于Spring Boot 2 & Spring Cloud Finchley &Mybatis 等核心技术，用于快速构建中大型系统的基础框架,</span>
			<el-divider></el-divider>
			<span style="font-size: 13px;font-weight: 100;">SpringBlade 企业版系列已通过长时间生产环境的考验，现将其拆分出基础模块进行开源，当前版本为∶2.0.0-RC1.</span>
			<el-divider></el-divider>
			<span style="font-size: 13px;font-weight: 100;">SpringBlade技术交流群号:477853168。欢迎大家加入。</span>
		  </div>
		  <div class="main-right">
			  <div class="main-right-1" style="background-color: #ffffff;text-align: left;padding: 10px;margin-bottom: 20px;">
				<span>快速开始/便捷导航</span>
				<el-divider></el-divider>
				<span></span>
			  </div>
			  <div class="main-right-1" style="background-color: #ffffff;text-align: left;padding: 10px;">
					<span>团队</span>
					<el-divider></el-divider>
					<span></span>
			  </div>
		  </div>
	  </div>
  </div>
</template>

<script>
	export default {
		name: 'index',
		components: {

		},
		data() {
			return {
				avatarSize: 60,
				avatarFit: 'fit',
				avatarUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
			}
		}
	}
</script>


<style scoped lang="scss">
.index-header {
	display: flex;
	flex-direction: row;
	margin: 40px 0;
	padding-top: 20px;
	padding-left: 20px;
	height: 75px;
	background-color: #ffffff;
}
.index-header-left {
	text-align: left;
	display: flex;
	flex-direction: row;
	margin-right: 18px;
	span {
		display:block;
		margin-bottom: 15px;
	}
	.text {
		margin-left: 20px;
	}
}
.index-header-right {
	width: 240px;
	position: absolute;
	right: 0;
	margin-right: 40px;
	display: flex;
	flex-direction: row;
	span {
		display: flex;
		flex-direction: row;
	}
}
.right-span {
	margin-left: 15px;
	border-right: 1px solid #f3f3f3;
}
.index-main {
	position: relative;
}

.main-right {
	width: 30%;
	position: absolute;
	right: 0;
	top: 0;
}
.main-left {
	width: 65%;
	background-color: #ffffff;
	text-align: left;
	padding: 10px;
}
</style>
