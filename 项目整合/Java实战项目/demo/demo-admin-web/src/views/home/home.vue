<template>
	<div class="container">
		<div class="address" v-if="false">
			<el-row :gutter="20">
				<el-col :span="6">
				  <div class="out-border">
					<div class="layout-title">后台项目</div>
					<div class="color-main address-content">
					  <a href="https://github.com/macrozheng/mall">mall</a>
					</div>
				  </div>
				</el-col>
				<el-col :span="6">
				  <div class="out-border">
					<div class="layout-title">前端项目</div>
					<div class="color-main address-content">
					  <a href="https://github.com/macrozheng/mall-admin-web">mall-admin-web</a>
					</div>
				  </div>
				</el-col>
				<el-col :span="6">
				  <div class="out-border">
					<div class="layout-title">学习教程</div>
					<div class="color-main address-content">
					  <a href="https://github.com/macrozheng/mall-learning">mall-learning</a>
					</div>
				  </div>
				</el-col>
			</el-row>
		</div>
	
		<!-- 后台首页主体区域 -->
		<div class="index-container">
		  <el-row :gutter="20">
			<el-col :span="6">
			  <div class="total-frame">
				<img src="../../assets/images/home_order.png" class="total-icon">
				<div class="total-title">今日订单总数</div>
				<div class="total-value">200</div>
			  </div>
			</el-col>
			<el-col :span="6">
			  <div class="total-frame">
				<img src="../../assets/images/home_today_amount.png" class="total-icon">
				<div class="total-title">今日销售总额</div>
				<div class="total-value">￥5000.00</div>
			  </div>
			</el-col>
			<el-col :span="6">
			  <div class="total-frame">
				<img src="../../assets/images/home_yesterday_amount.png" class="total-icon">
				<div class="total-title">昨日销售总额</div>
				<div class="total-value">￥5000.00</div>
			  </div>
			</el-col>
			<!--<el-col :span="6">-->
			  <!--<div class="total-frame">-->
				<!--<svg-icon icon-class="total-week" class="total-icon">-->
				<!--</svg-icon>-->
				<!--<div class="total-title">近7天销售总额</div>-->
				<!--<div class="total-value">￥50000.00</div>-->
			  <!--</div>-->
			<!--</el-col>-->
		  </el-row>
		</div>
	
		<!--  -->
		<el-card class="mine" v-if="false">
			<div></div>
			<div></div>
			<div></div>
		</el-card>
		
		<!-- 订单处理区域 -->
		<div class="un-handle-layout">
			<div class="layout-title">待处理事务</div>
			<div class="un-handle-content">
				<el-row :gutter="20">
				  <el-col :span="8">
					<div class="un-handle-item">
					  <span class="font-medium">待付款订单</span>
					  <span style="float: right" class="color-danger">(10)</span>
					</div>
				  </el-col>
				  <el-col :span="8">
					<div class="un-handle-item">
					  <span class="font-medium">已完成订单</span>
					  <span style="float: right" class="color-danger">(10)</span>
					</div>
				  </el-col>
				  <el-col :span="8">
					<div class="un-handle-item">
					  <span class="font-medium">待确认收货订单</span>
					  <span style="float: right" class="color-danger">(10)</span>
					</div>
				  </el-col>
				  <el-col :span="8">
					<div class="un-handle-item">
					  <span class="font-medium">待发货订单</span>
					  <span style="float: right" class="color-danger">(10)</span>
					</div>
				  </el-col>
				  <el-col :span="8">
					<div class="un-handle-item">
					  <span class="font-medium">新缺货登记</span>
					  <span style="float: right" class="color-danger">(10)</span>
					</div>
				  </el-col>
				  <el-col :span="8">
					<div class="un-handle-item">
					  <span class="font-medium">待处理退款申请<</span>
					  <span style="float: right" class="color-danger">(10)</span>
					</div>
				  </el-col>
				  <el-col :span="8">
					<div class="un-handle-item">
					  <span class="font-medium">已发货订单</span>
					  <span style="float: right" class="color-danger">(10)</span>
					</div>
				  </el-col>
				  <el-col :span="8">
					<div class="un-handle-item">
					  <span class="font-medium">待处理退货订单</span>
					  <span style="float: right" class="color-danger">(10)</span>
					</div>
				  </el-col>
				  <el-col :span="8">
					<div class="un-handle-item">
					  <span class="font-medium">广告位即将到期</span>
					  <span style="float: right" class="color-danger">(10)</span>
					</div>
				  </el-col>
				</el-row>
			</div>
		</div>
		
		<!-- 商品区域 -->
		<div class="overview-layout">
			<el-row :gutter="20">
				<el-col :span="12">
				  <div class="out-border">
					<div class="layout-title">商品总览</div>
					<div style="padding: 40px">
					  <el-row>
						<el-col :span="6" class="color-danger overview-item-value">100</el-col>
						<el-col :span="6" class="color-danger overview-item-value">400</el-col>
						<el-col :span="6" class="color-danger overview-item-value">50</el-col>
						<el-col :span="6" class="color-danger overview-item-value">500</el-col>
					  </el-row>
					  <el-row class="font-medium">
						<el-col :span="6" class="overview-item-title">已下架</el-col>
						<el-col :span="6" class="overview-item-title">已上架</el-col>
						<el-col :span="6" class="overview-item-title">库存紧张</el-col>
						<el-col :span="6" class="overview-item-title">全部商品</el-col>
					  </el-row>
					</div>
				  </div>
				</el-col>
				<el-col :span="12">
				  <div class="out-border">
					<div class="layout-title">用户总览</div>
					<div style="padding: 40px">
					  <el-row>
						<el-col :span="6" class="color-danger overview-item-value">100</el-col>
						<el-col :span="6" class="color-danger overview-item-value">200</el-col>
						<el-col :span="6" class="color-danger overview-item-value">1000</el-col>
						<el-col :span="6" class="color-danger overview-item-value">5000</el-col>
					  </el-row>
					  <el-row class="font-medium">
						<el-col :span="6" class="overview-item-title">今日新增</el-col>
						<el-col :span="6" class="overview-item-title">昨日新增</el-col>
						<el-col :span="6" class="overview-item-title">本月新增</el-col>
						<el-col :span="6" class="overview-item-title">会员总数</el-col>
					  </el-row>
					</div>
				  </div>
				</el-col>
			</el-row>
		</div>
		
		<!-- 订单统计区域 -->
		<div class="statistics-layout">
			<div class="layout-title">订单统计</div>
			<el-row>
				<el-col :span="4">
				  <div style="padding: 20px">
					<div>
					  <div style="color: #909399;font-size: 14px">本月订单总数</div>
					  <div style="color: #606266;font-size: 24px;padding: 10px 0">10000</div>
					  <div>
						<span class="color-success" style="font-size: 14px">+10%</span>
						<span style="color: #C0C4CC;font-size: 14px">同比上月</span>
					  </div>
					</div>
					<div style="margin-top: 20px;">
					  <div style="color: #909399;font-size: 14px">本周订单总数</div>
					  <div style="color: #606266;font-size: 24px;padding: 10px 0">1000</div>
					  <div>
						<span class="color-danger" style="font-size: 14px">-10%</span>
						<span style="color: #C0C4CC;font-size: 14px">同比上周</span>
					  </div>
					</div>
					<div style="margin-top: 20px;">
					  <div style="color: #909399;font-size: 14px">本月销售总额</div>
					  <div style="color: #606266;font-size: 24px;padding: 10px 0">100000</div>
					  <div>
						<span class="color-success" style="font-size: 14px">+10%</span>
						<span style="color: #C0C4CC;font-size: 14px">同比上月</span>
					  </div>
					</div>
					<div style="margin-top: 20px;">
					  <div style="color: #909399;font-size: 14px">本周销售总额</div>
					  <div style="color: #606266;font-size: 24px;padding: 10px 0">50000</div>
					  <div>
						<span class="color-danger" style="font-size: 14px">-10%</span>
						<span style="color: #C0C4CC;font-size: 14px">同比上周</span>
					  </div>
					</div>
				  </div>
				</el-col>
				<el-col :span="20">
				  <div style="padding: 10px;border-left:1px solid #DCDFE6">
					<el-date-picker
					  style="float: right;z-index: 1"
					  size="small"
					  v-model="orderCountDate"
					  type="daterange"
					  align="right"
					  unlink-panels
					  range-separator="至"
					  start-placeholder="开始日期"
					  end-placeholder="结束日期"
					  @change="handleDateChange"
					  :picker-options="pickerOptions">
					</el-date-picker>
					<div>
					  <ve-line
						:data="chartData"
						:legend-visible="false"
						:loading="loading"
						:data-empty="dataEmpty"
						:settings="chartSettings"></ve-line>
					</div>
				  </div>
				</el-col>
			</el-row>
		</div>
	</div>
</template>

<script>
export default {
	name: 'home',
	data () {
		return {
			pickerOptions: {
			  shortcuts: [{
				text: '最近一周',
				onClick(picker) {
				  const end = new Date();
				  let start = new Date();
				  start.setFullYear(2018);
				  start.setMonth(10);
				  start.setDate(1);
				  end.setTime(start.getTime() + 3600 * 1000 * 24 * 7);
				  picker.$emit('pick', [start, end]);
				}
			  }, {
				text: '最近一月',
				onClick(picker) {
				  const end = new Date();
				  let start = new Date();
				  start.setFullYear(2018);
				  start.setMonth(10);
				  start.setDate(1);
				  end.setTime(start.getTime() + 3600 * 1000 * 24 * 30);
				  picker.$emit('pick', [start, end]);
				}
			  }]
			},
			// 订单统计日期
			chartData: {
				columns: [],
				rows: []
			},
			loading: false,
			dataEmpty: false,
			chartSettings: {
				xAxisType: 'time',
				area:true,
				axisSite: { 
					right: ['orderAmount'],
				},
				labelMap: {
					'orderCount': '订单数量', 'orderAmount': '订单金额',
				}
			},
			orderCountDate: '',
		}
	},
	created() {
		this.initOrderCountDate()
		this.getData()
	},
	methods: {
		handleDateChange () {this.getData()},
		
		initOrderCountDate () {
			let start = new Date();
			start.setFullYear(2018);
			start.setMonth(10);
			start.setDate(1);
			const end = new Date();
			end.setTime(start.getTime() + 1000 * 60 * 60 * 24 * 7);
			this.orderCountDate=[start,end];
		},
		
		getData () {
			setTimeout(() => {
			  this.chartData = {
				columns: ['date', 'orderCount','orderAmount'],
				rows: []
			  };
			  for(let i=0;i<DATA_FROM_BACKEND.rows.length;i++){
				let item=DATA_FROM_BACKEND.rows[i];
				let currDate=str2Date(item.date);
				let start=this.orderCountDate[0];
				let end=this.orderCountDate[1];
				if(currDate.getTime()>=start.getTime()&&currDate.getTime()<=end.getTime()){
				  this.chartData.rows.push(item);
				}
			  }
			  this.dataEmpty = false;
			  this.loading = false
			}, 1000)
		}
	}
}
</script>

<style scoped>
	.container {margin-top: 40px;margin-left: 120px;margin-right: 120px;}
	.index-container {margin-top: 20px;}
	.mine {position: absolute;right: 140px;top: 107px;width: 250px;height: 235px;}
	
	.total-frame {border: 1px solid #DCDFE6;padding: 20px;height: 100px;}
	.total-icon {color: #409EFF;width: 60px;height: 60px;}
	.total-title {position: relative;font-size: 16px;color: #909399;left: 70px;top: -50px;}
	.total-value {position: relative;font-size: 18px;color: #606266;left: 70px;top: -40px;}

	.un-handle-layout {margin-top: 20px;border: 1px solid #DCDFE6;}
	.un-handle-content {padding: 20px 40px;}
	.layout-title {color: #606266;padding: 15px 20px;background: #F2F6FC;font-weight: bold;}
	.un-handle-item {border-bottom: 1px solid #EBEEF5;padding: 10px;}
	
	.overview-layout {margin-top: 20px;}
	.overview-item-value {font-size: 24px;text-align: center;}
	.overview-item-title {margin-top: 10px;text-align: center;}
	
	.out-border {border: 1px solid #DCDFE6;}
	.statistics-layout {margin-top: 20px;border: 1px solid #DCDFE6;}
	.address-content {padding: 20px;font-size: 18px}
</style>
