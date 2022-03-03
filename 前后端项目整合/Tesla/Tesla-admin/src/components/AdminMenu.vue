<template>
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

</template>

<script>
export default {
  name: "AdminMenu"
}
</script>

<style scoped>

</style>
