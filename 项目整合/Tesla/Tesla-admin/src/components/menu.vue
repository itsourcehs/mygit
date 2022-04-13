<template>
	<el-menu
	  router
	  :default-active="this.$route.path"
	  class="el-menu-vertical-demo"
	  @open="handleOpen"
	  @close="handleClose"
	  background-color="#495060"
	  text-color="#fff"
	  unique-opened
	  active-text-color="#ffd04b">

    <el-menu-item index="/index"><i class="el-icon-menu"></i>
      <span slot="title">首页</span>
    </el-menu-item>

	  <el-submenu :index="item.path" v-for="(item,index) in menus" :key="index">
	    <template slot="title"><i class="el-icon-s-order"></i>
	      <span>{{item.name}}</span>
	    </template>
	    
		<el-menu-item-group>
		  <el-menu-item :index="item2.childPath" v-for="(item2,index2) in item.child" :key="index2">
          <i class="el-icon-s-tools"></i>{{item2.title}}
        </el-menu-item>
	    </el-menu-item-group>
		
	  </el-submenu>

	</el-menu>

</template>

<script>
export default {
  name: "menu",
	data () {
		return {
			menus: [
				{
					name: '车辆管理',
					path: '/car',
					child: [
						{
							title: 'Tesla配置',
							childPath: '/config'
						},
						{
							title: 'Tesla零件',
							childPath: '/parts'
						}
					]
				},
				{
					name: '用户管理',
					path: '/user',
					child: [
						{
							title: '新增用户',
							childPath: '/user/add'
						},
					]
				}
			]
		}
	},
  methods: {
    handleOpen (key, keyPath) {
      // console.log(key, keyPath);
    },
    handleClose (key, keyPath) {
      // console.log(key, keyPath);
    }
  },

}
</script>

<style scoped>
.el-menu-vertical-demo {
  border-right: none;
  text-align: left;
}
.el-menu-item {
  padding-right: 18px;
}
</style>
