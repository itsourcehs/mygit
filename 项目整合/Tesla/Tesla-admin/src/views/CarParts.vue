<template>
  <div class="card" style="margin-top: 20px;">
  	<el-card style="position: relative;">
  		<el-row style="text-align: left;">
			<span>零件编号: </span><el-input placeholder="请输入零件编号" clearable v-model="inputNumber"></el-input>
			<span>零件名称: </span><el-input placeholder="请输入零件名称" clearable v-model="inputName"></el-input>
			
			<div class="valbutton">
				<el-button type="primary" @click="handleSelect">查询</el-button>
				<el-button>重置</el-button>
			</div>	
  		</el-row>
		<el-row>
			<div class="vabutton">
				<el-button type="primary" icon="el-icon-plus">新增</el-button>
				<el-button icon="el-icon-delete" style="color: #FF0000;">删除</el-button>
			</div>
		</el-row>
  	<div style="margin: 60px 0;">
  		<el-table
  		    ref="multipleTable"
  		    :data="tableData"
  		    tooltip-effect="dark"
  		    style="width: 100%"
  		    @selection-change="handleSelectionChange">
  		    <el-table-column
  		      type="selection"
  		      width="55">
  		    </el-table-column>
  		    <el-table-column
  		      label="日期"
  		      width="120">
  		      <template slot-scope="scope">{{ scope.row.date }}</template>
  		    </el-table-column>
  		    <el-table-column
  		      prop="name"
  		      label="姓名"
  		      width="120">
  		    </el-table-column>
  		    <el-table-column
  		      prop="address"
  		      label="地址"
  		      show-overflow-tooltip>
  		    </el-table-column>
			
			<el-table-column
			      fixed="right"
			      label="操作"
			      width="200px">
			      <template slot-scope="scope">
			        <el-button @click="handleClick(scope.row)" type="text" size="small">修改</el-button>
			        <el-button type="text" size="small">删除</el-button>
					<el-button type="text" size="small">查看</el-button>
			      </template>
			</el-table-column>
  		  </el-table>
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
		inputNumber: '',
		inputName: '',
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
  },
  methods: {
  	handleSelect () {
  		if (this.inputNumber.length == 0 && this.inputName.length == 0) return this.$message.error('请输入查询内容!')
  	},
	handleClick (val) {
		console.log(val);
	},
	handleSelectionChange () {}
  },
}
</script>

<style scoped>
span {
	font-size: 13px;
	font-weight: 100;
}
.el-input {
	width: 30%;
	margin-right: 30px;
}
.valbutton {
	position: absolute;
	right: 0;
	top: 0;
}
.vabutton {
	position: absolute;
	left: 0;
	
}

.el-row {
	margin-bottom: 25px;
}
</style>
