<template>
	<el-menu
	  router
	  default-active="config"
	  class="el-menu-vertical-demo"
	  @open="handleOpen"
	  @close="handleClose"
	  background-color="#495060"
	  text-color="#fff"
	  active-text-color="#ffd04b">

    <el-menu-item index="">
      <i class="el-icon-menu"></i>
      <span slot="title">首页</span>
    </el-menu-item>

	  <el-submenu index="carManage">
	    <template slot="title">
	      <i class="el-icon-s-order"></i>
	      <span>车辆管理</span>
	    </template>
	    <el-menu-item-group>
	      <el-menu-item index="/config">
          <i class="el-icon-s-tools"></i>Tesla配置
        </el-menu-item>
	      <el-menu-item index="/parts">
          <i class="el-icon-orange"></i>Tesla零件
        </el-menu-item>
	      <el-menu-item index="">选项3</el-menu-item>
	    </el-menu-item-group>
	  </el-submenu>

	  <el-submenu index="/user">
	    <template slot="title">
	      <i class="el-icon-user"></i>
	      <span>用户管理</span>
	    </template>
	    <el-menu-item-group>
	      <el-menu-item index="/user/add">新增用户</el-menu-item>
	      <el-menu-item index="2-2">选项2</el-menu-item>
	      <el-menu-item index="2-3">选项3</el-menu-item>
	    </el-menu-item-group>
	  </el-submenu>

	</el-menu>

</template>

<script>
export default {
  name: "AdminMenu",
  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>
.el-menu {
  border-right: none;
}
.el-menu-item {
  padding-right: 5px;
}
</style>
