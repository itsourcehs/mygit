<template>
  <div class="card" style="margin-top: 50px;">
		<el-card style="position: relative;">
			<el-row style="text-align: left;">
			  <el-button type="primary" size="medium">增加</el-button>
			  <el-button type="success" size="medium">删除</el-button>
			  <el-button type="info" size="medium">修改</el-button>
			  <el-button type="warning" size="medium">查询</el-button>
			</el-row>
		<div style="margin: 20px 0;">
			<el-table
			:data="tableData"
			border
			style="width: 100%">
			<el-table-column
			  prop="date"
			  label="日期"
			  width="180">
			</el-table-column>
			<el-table-column
			  prop="name"
			  label="姓名"
			  width="180">
			</el-table-column>
			<el-table-column
			  prop="address"
			  label="地址">
			</el-table-column>
			</el-table>
		</div>
		
			<div class="block">
			  <el-pagination
				style="position: absolute;right: 0;bottom: 0;"
			    layout="prev, pager, next"
			    :total="1000">
			  </el-pagination>
			</div>
		</el-card>
	</div>
</template>

<script>
export default {
  name: "CarConfig",
  data() {
	return {
	  tableData: [{
		date: '2016-05-02',
		name: '王小虎',
		address: '上海市普陀区金沙江路 1518 号'
	  }, {
		date: '2016-05-04',
		name: '王小虎',
		address: '上海市普陀区金沙江路 1517 号'
	  }, {
		date: '2016-05-01',
		name: '王小虎',
		address: '上海市普陀区金沙江路 1519 号'
	  }, {
		date: '2016-05-03',
		name: '王小虎',
		address: '上海市普陀区金沙江路 1516 号'
	  }]
	}
  }
}
</script>

<style scoped>

</style>
