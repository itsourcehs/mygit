<template>
  <el-container>
    <el-aside width="200px">
      <el-menu text-color="#fff"
               active-text-color="#ffd04b">
        <el-submenu>
          <span><i  class="el-icon-location"></i>导航一</span>
          <el-menu-item><i  class="el-icon-location"></i>选项一</el-menu-item>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container class="demo">
      <el-header></el-header>
      <el-main></el-main>
    </el-container>
  </el-container>
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
.el-aside {
  background-color: #495060;
  color: #333;
  text-align: center;
  line-height: 200px;
  height: 100%;
  padding: 0;
}
/*占满全屏*/
.el-container{
  position: absolute;
  width: 100%;
  top: 0;
  left: 0;
  bottom: 0;
  padding: 0;
  .demo {
    width: 89.5%;
    margin-left: 200px;
  }
}
.el-header {
  background-color: #ffffff;
  color: #333;
  border: 1px solid #dbdcdd;
}

.el-menu {
  margin-top: 0;
  list-style-type: none;
}
</style>
