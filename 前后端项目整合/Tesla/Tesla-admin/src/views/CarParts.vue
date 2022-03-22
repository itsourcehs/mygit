<template>
  <div class="card" style="margin-top: 50px;">
  	<el-card style="position: relative;">
  		<el-row style="text-align: left;">
			<el-input placeholder="请输入菜单编号" clearable v-model="input"></el-input>
			<el-input placeholder="请输入菜单名称" clearable v-model="input"></el-input>
  		  
  		</el-row>
  	<div style="margin: 20px 0;">
  		
  	</div>
  	
  		<div class="block">
  		  <el-pagination
  			style="position: absolute;right: 0;bottom: 0;"
  			layout="prev, pager, next"
  			:total="1000"
  			>
  		  </el-pagination>
  		</div>
  	</el-card>
  </div>
</template>

<script>
export default {
  name: "CarParts",
  data () {
	return {
		input: ''
	}
  }
}
</script>

<style scoped>

</style>
