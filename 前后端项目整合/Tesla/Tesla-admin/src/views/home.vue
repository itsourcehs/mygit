<template>
  <el-container
    style="height: 100vh;
    border: 1px solid #eee">
<!--    左侧导航区-->
    <el-aside
      width="200px"
      style="height: 100vh;
      background-color: rgb(73, 80, 96);">
      <img src="../assets/img/admin_icon.jpg" style="height: 44px">
    </el-aside>
<!--    右侧顶部区-->
    <el-container>
      <el-header
        style="text-align: right;
        font-size: 12px;
        height: 60px;
        background: #fff;
        border: 1px solid #eee;">

      </el-header>
      <el-main>

      </el-main>
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

</style>
