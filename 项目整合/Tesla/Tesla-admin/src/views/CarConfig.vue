<template>
  <div class="card" style="margin-top: 20px;">
		<el-card style="position: relative;">
			<el-row style="text-align: left;">
			  <!-- <el-button type="primary" size="medium">增加</el-button>
			  <el-button type="warning" size="medium">查询</el-button> -->
			</el-row>
		<div style="margin: 20px 0;">
			<el-row class="config-row">
				<div>
					<span>输入id: </span><el-input placeholder="请输入id" clearable v-model="inputId" style="width: 20%;margin-right: 30px;"></el-input>
				</div>
				
				<el-button type="primary" icon="el-icon-plus" @click="handleAddCar">新增</el-button>
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
			        <el-button @click="handleAlter(scope.row)" type="text" size="small">修改</el-button>
			        <el-button @click="handleDel(scope.row)" type="text" size="small">删除</el-button>
					<el-button @click="handleView(scope.row)" type="text" size="small">查看</el-button>
			      </template>
			</el-table-column>
			</el-table>
		</div>
		
		<el-dialog :visible.sync="dialogFormVisible" width="30%" title="Tesla配置">
			<el-form :model="form" label-position="right">
				<el-form-item label="名称:" :label-width="formLabelWidth">
					<el-input :disabled="disabled" v-model="form.carTitle" autocomplete="off" style="width: 70%;"></el-input>
				</el-form-item>
			</el-form>
		</el-dialog>
		
			<div class="block">
			  <el-pagination
				style="position: absolute;right: 0;bottom: 0;"
				layout="prev, pager, next"
				:total="page.total"
				:page-size="page.pageSize"
				@current-change="handleCurrentChange"
				>
			  </el-pagination>
			</div>
		</el-card>
		
		<eform ref="edit"></eform>
	</div>
</template>

<script>
import eform from '../components/eform.vue'
export default {
	// 注入App.vue组件提供（provide）的 reload 依赖  this.reload 调用控制页面刷新
	inject: ['reload'],
	components: {eform},
	name: "CarConfig",
	data() {
		return {
		  tableData: [],
		  inputId: '',
		  dialogFormVisible: false,
		  formLabelWidth: '120px',
		  form: {},
		  page: {
			/*
			 1  0-4   当前页1-1*每页显示5条  每页显示5条
			 2  5-7   当前页2-1*每页显示5条  每页显示5条
			*/
			pageSize: 5 ,// 每页展示5条记录
			currentPage: 1, // 当前页
			total: 13 // 总条数
		  },
		  disabled: true
		}
	},
  mounted() {
	this.getCount()
	this.carByPage(1)
  },
  methods: {
	// 修改car
	handleAlter (obj) {
		console.log(obj);
		this.dialogFormVisible = true
		this.disabled = false
		this.form = obj
	},
	
	// 删除car
	async handleDel (obj) {
		let carId = obj.carId
		await this.$axios.get('/car/del/' + carId).then(res => {
			// 提示删除成功
			this.$message({
				message: '删除成功.',
				type: 'success'
			})
			// 刷新当前页面
			this.reload()
		})
	},
	
	// 添加car
	handleAddCar () {
		this.$refs.edit.dialogFormVisible = true
	},
	
	// 获取记录总数
	async getCount(){
		await this.$axios.get('/cars/count').then(res => {this.page.total = res.data})},
	  
	async handleCurrentChange (page) {this.carByPage(page)},
	
	// 查看记录
	handleView (val) {
		this.dialogFormVisible = true
		this.form = val
	},
	
	// 获取当前页car列表信息
	async carByPage (page) {
		this.page.currentPage = page
		await this.$axios.get('/cars/' + this.page.pageSize + '/'+this.page.currentPage)
		.then(res => {this.tableData = res.data.data})
	}
	}
}
</script>

<style scoped>
.el-row span {
	font-size: 15px;
	font-weight: 100;
}
.config-row {
	text-align: left;
	margin-bottom: 10px;
	display: flex;
	flex-direction: column;
}
.config-row .el-button {
	width: 8%;
	margin-top: 20px;
}
</style>
