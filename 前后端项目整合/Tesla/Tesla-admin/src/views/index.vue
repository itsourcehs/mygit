<template>
  <div class="index">
	  <div class="index-header">
		<div class="index-header-left">
			<el-avatar shape="circle" :size="avatarSize" :fit="avatarFit" :src="avatarUrl"></el-avatar>
			<div class="text">
				<span style="font-size: 18px;">您好，管理员，祝您开心每一天!</span>
				<span style="
		font-size: 13px;
		font-weight: 100;">我们用代码编写梦想，用梦想改变世界。</span>
			</div>	
		</div>
		<div class="index-header-right">
			<span>
				<span>项目数</span>
				<span>56</span>
			</span>
			<span>
				<span>团队内排名</span>
				<span>8/24</span>
			</span>
			<span>
				<span>项目访问</span>
				<span>2,223</span>
			</span>
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
	margin: 30px 0;
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
	width: 210px;
	position: absolute;
	right: 0;
	margin-right: 20px;
	span {
		display: flex;
		flex-direction: row;
	}
}
</style>
