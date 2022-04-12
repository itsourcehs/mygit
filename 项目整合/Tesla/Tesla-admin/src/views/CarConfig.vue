<template>
  <div class="card" style="margin-top: 50px;">
		<el-card style="position: relative;">
			<el-row style="text-align: left;">
			  <!-- <el-button type="primary" size="medium">增加</el-button>
			  <el-button type="success" size="medium">删除</el-button>
			  <el-button type="info" size="medium">修改</el-button>
			  <el-button type="warning" size="medium">查询</el-button> -->
			</el-row>
		<div style="margin: 20px 0;">
			<el-row style="text-align: left;">
				<span>id: </span><el-input placeholder="请输入id" clearable v-model="inputId"></el-input>
			</el-row>
			
			<el-table
			:data="tableData"
			style="width: 100%">
			
			<el-table-column
			  prop="carId"
			  label="id"
			  width="180">
			</el-table-column>
			<el-table-column
			  prop="carTitle"
			  label="名称"
			  width="180">
			</el-table-column>
			
			<el-table-column
			  prop="carImgurl"
			  label="图片地址">
			   <!-- 图片的显示 -->
			   <template   slot-scope="scope">
				   <img :src="scope.row.carImgurl"  min-width="70" height="70"/>
			   </template>
			</el-table-column>
			
			<el-table-column
			  prop="carEndurance"
			  label="公里续航"
			  width="180">
			</el-table-column>
			<el-table-column
			  prop="carAccelerate"
			  label="百公里加速"
			  >
			</el-table-column>
			<el-table-column
			  prop="carMaxspeed"
			  label="最高车速"
			  >
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
	name: "CarConfig",
	data() {
		return {
		  tableData: [],
		  inputId: ''
	}
  },
  mounted() {
  	this.getCarList()
  },
  methods: {
	// 获取car列表
	async getCarList() {
		await this.$axios.get('/car/all')
		.then(res => {
			if (res.status ===200) return this.tableData = res.data.data
		})
	}
}
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
</style>
