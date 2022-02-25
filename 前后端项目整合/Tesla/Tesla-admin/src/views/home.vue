<template>
	<div class="dashboard-container">
		<div class="dashboard-editor-container">
			<div class="github-corner"></div>

			<el-row class="dashboard-el-row"></el-row>

			<el-row gutter="32">
				<el-col xs="24" sm="24" lg="8"></el-col>
				<el-col xs="24" sm="24" lg="8"></el-col>
				<el-col xs="24" sm="24" lg="8"></el-col>
			</el-row>
			
			<!-- 导航菜单 -->
			<el-menu
			      default-active="2"
			      class="el-menu-admin"
			      @open="handleOpen"
			      @close="handleClose"
			      background-color="#545c64"
			      text-color="#fff"
			      active-text-color="#ffd04b"
				  style="list-style: none;">
			      <el-submenu index="1">
			        <template slot="title">
			          <i class="el-icon-location"></i>
			          <span>导航一</span>
			        </template>
			        <el-menu-item-group>
			          <el-menu-item index="1-1">选项1</el-menu-item>
			          <el-menu-item index="1-2">选项2</el-menu-item>
			        </el-menu-item-group>
			        <el-menu-item-group title="分组2">
			          <el-menu-item index="1-3">选项3</el-menu-item>
			        </el-menu-item-group>
			        <el-submenu index="1-4">
			          <template slot="title">选项4</template>
			          <el-menu-item index="1-4-1">选项1</el-menu-item>
			        </el-submenu>
			      </el-submenu>
			      <el-menu-item index="2">
			        <i class="el-icon-menu"></i>
			        <span slot="title">导航二</span>
			      </el-menu-item>
			      <el-menu-item index="3" disabled>
			        <i class="el-icon-document"></i>
			        <span slot="title">导航三</span>
			      </el-menu-item>
			      <el-menu-item index="4">
			        <i class="el-icon-setting"></i>
			        <span slot="title">导航四</span>
			      </el-menu-item>
			</el-menu>	
		</div>	
	</div>
</template>

<script>
	export default {
		name: 'Home',
		data() {
			return {
				adminMenus: [
					{
						iconCls: '',
						nameZh: '导航一',
						children: [
							{
								icon: '',
								nameZh: '选项1.1'
							},
							{
								icon: '',
								nameZh: '选项1.2'
							},
							{
								icon: '',
								nameZh: '选项1.3'
							}
						]
					},
					{
						iconCls: '',
						nameZh: '导航二'
					}
				]

			}
		}
	}
</script>


<style scoped lang="scss">
	.dashboard-editor-container {
		padding: 32px;
		background-color: rgb(240, 242, 245);
		position: relative;
	}

	.dashboard-el-row {
		background: #fff;
		padding: 16px 16px 0;
		margin-bottom: 32px;
	}

	.github-corner {
		position: absolute;
		top: 0;
		border: 0;
		right: 0;

	}

.el-menu-admin {
	width: 200px;
	min-height: 400px;
}
</style>
