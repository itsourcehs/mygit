<template>
  <el-container style="height: 100%">
    <el-aside width="200px">
      <img src="@/assets/img/admin_icon.jpg" style="height: 44px;width: auto">
      <el-menu
        router
        default-active="1-1"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        background-color="#495060"
        text-color="#fff"
        style="border-right: none"
        active-text-color="#ffd04b">

        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-s-order"></i>
            <span>瓷砖管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="1-1">选项1</el-menu-item>
            <el-menu-item index="1-2">选项2</el-menu-item>
            <el-menu-item index="1-3">选项3</el-menu-item>
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-user"></i>
            <span>用户管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="2-1">选项1</el-menu-item>
            <el-menu-item index="2-2">选项2</el-menu-item>
            <el-menu-item index="2-3">选项3</el-menu-item>
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="3">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>角色管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="3-1">选项1</el-menu-item>
            <el-menu-item index="3-2">选项2</el-menu-item>
            <el-menu-item index="3-3">选项3</el-menu-item>
          </el-menu-item-group>
        </el-submenu>

      </el-menu>
    </el-aside>

    <el-container style="width: 89%;margin-left: 200px">
      <el-header>
      <!--面包屑-->
        <div class="header-main">
          <el-row style="margin: 18px 0px 0px 18px">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{path: '/admin'}">管理中心</el-breadcrumb-item>
              <el-breadcrumb-item>内容管理</el-breadcrumb-item>
              <el-breadcrumb-item>图书管理</el-breadcrumb-item>
            </el-breadcrumb>
          </el-row>

          <div class="user-avatar">
            <span>hs</span>
            <el-avatar shape="circle" :size="large" :fit="fit" src="@/assets/img/eva1.jpg"></el-avatar>
          </div>
        </div>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
	export default {
		name: 'Home',
		data() {
			return {

			}
		}
	}
</script>


<style scoped lang="scss">
.el-aside {
  background-color: #495060;
  color: #333;
  text-align: center;
  line-height: 100px;
}
/*占满全屏*/
.el-container{
  position: absolute;
  width: 100%;
  top: 0;
  left: 0;
  bottom: 0;
  padding: 0;
}
.el-header {
  background-color: #ffffff;
  color: #333;
  padding: 0;
}
.el-main {
  background-color: #f0f0f0;
}

.header-main {
  display: flex;
  flex-direction: row;
  justify-content: space-between;

  .user-avatar {
    margin-top: 10px;
  }
}
</style>
