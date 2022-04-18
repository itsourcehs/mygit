<!-- 编辑表单 -->
<template>
	<el-dialog title="添加" :visible.sync="dialogFormVisible" width="30%">
		<el-form v-model="form" style="text-align: left;" :label-width="formLabelWidth">
			<el-form-item label="名称:" prop="car_title">
				<el-input v-model="form.car_title" autocomplete="off"></el-input>
			</el-form-item>
			<el-form-item label="图片地址:" prop="car_title">
				<el-input v-model="form.car_imgurl" autocomplete="off"></el-input>
				<upload @onUpload="uploadImg" ref="imgUpload"></upload>
			</el-form-item>
			<el-form-item label="公里续航:" prop="car_title">
				<el-input v-model="form.car_endurance" autocomplete="off"></el-input>
			</el-form-item>
			<el-form-item label="百公里加速:" prop="car_title">
				<el-input v-model="form.car_accelerate" autocomplete="off"></el-input>
			</el-form-item>
			<el-form-item label="最高车速:" prop="car_title">
				<el-input v-model="form.car_maxspeed" autocomplete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button @click="dialogFormVisible=false">取消</el-button>
			<el-button type="primary" @click="onSubmit">确定</el-button>
		</div>
	</el-dialog>
</template>

<script>
import upload from '@/components/eupload'
export default {
	inject: ['reload'],
	components:{upload},
	name: "eform",
	data () {
		return {
			dialogFormVisible: false,
			form: {
				car_title: '',
				car_imgurl: '',
				car_endurance: '',
				car_accelerate: '',
				car_maxspeed: ''
			},
			formLabelWidth: '120px'
		}
	},
	methods: {
		//
		uploadImg () {this.form.car_imgurl = this.$refs.imgUpload.url},
		
		// 提交表单
		async onSubmit () {
			await this.$axios.post('/carAdd', {
				carTitle: this.form.car_title,
				carImgurl: this.form.car_imgurl,
				carEndurance: this.form.car_endurance,
				carAccelerate: this.form.car_accelerate,
				carMaxspeed: this.form.car_maxspeed
			}).then(res => {
				this.dialogFormVisible = false
				this.$message({
					message: ''+ res.data.msg,
					type: 'success'
				})
				// 刷新当前页面
				this.reload()
			})
		}
	}
}
</script>

<style scoped>
</style>
