<template>
	<view>
		<view class="lenders-toolbox-page">
			
			<view class="head-line">金融服务</view>
			
			<view class="section product-selection-area">
				<view class="title">请选择你感兴趣的车型</view>
				<view class="form-item"><tesla-picker title="选择车系"></tesla-picker></view>
				<view class="form-item"><tesla-picker title="选择车型"></tesla-picker></view>
				<view class="form-item"><tesla-input label="车辆价格(元)"></tesla-input></view>
			</view>
			
			<view class="section" style="margin-bottom: 106rpx;">
				<view class="title">选择金融方案</view>
				<view class="form-item"><tesla-selection></tesla-selection></view>
				<view class="tips">特斯拉官方推出了全新的金融服务，消费者只需签订租赁合同，不用任何首付，即可将特斯拉新车开回家，然后每月分期付款支付租金，直至1－5年的租赁期满，便可获得该车的所有权。</view>
				<view class="form-item"><tesla-picker title="金融产品"></tesla-picker></view>
				<view class="form-item"><tesla-picker title="期数"></tesla-picker></view>
				<view class="form-item"><tesla-input label="首付/保障金比例(%)"></tesla-input></view>
				<view class="form-item"><tesla-input label="年化率(%)" disabled tips="折合年化率7.30%"></tesla-input></view>
			</view>
			
			<view class="section">
				<view class="title">查看适用金融机构</view>
				<view class="form-item"><tesla-picker title="上牌省份"></tesla-picker></view>
				<view class="form-item"><tesla-picker title="上牌城市"></tesla-picker></view>
			</view>
			
			<view class="section">
				<view class="tips">特斯拉官方推出了全新的金融服务，消费者只需签订租赁合同，不用任何首付，即可将特斯拉新车开回家，然后每月分期付款支付租金，直至1－5年的租赁期满，便可获得该车的所有权。</view>
				<view class="bank-area">
					<view class="bank-box" v-for="(item,index) in financeOrgs" :key="index">
						<image :src="item.logo" mode="heightFix"></image>
					</view>
				</view>
			</view>
		</view>
		
		<!--  -->
		<view class="occupation-box"></view>
		<view class="float-card">
			<view
			class="product-box"
			:class="[isCollapse ? collapse : '']">
				<image class="product-image" mode="widthFix" :src="currentProductImage"></image>
				<view class="product-name">{{product}}</view>
				<view class="product-line-name">{{productLine}}</view>
			</view>
			<view class="action-box">
				<view class="label">计算结果</view>
				<image
				class="icon"
				@tap="toggleCollapse"
				:src="[isCollapse ? minusCircle: plusCircle]"></image>
			</view>
			<view class="calculate-box">
				<view class="calculate-item">
					<view class="label">首付款/保障金</view>
					<view class="number">￥{{downPayment}}</view>
				</view>
				<view class="calculate-item" :class="[!isCollapse ? 'hide': '']">
					<view class="label">贷款/融资金额</view>
					<view class="number">￥{{loan}}</view>
				</view>
				<view
				class="calculate-item"
				:class="[!isCollapse ? 'hide': '']"
				:style="[isCollapse ? 'margin:35rpx 0': '']">
					<view class="label">尾款比例</view>
					<view class="number">0%</view>
				</view>
				<view class="calculate-item" :class="[!isCollapse ? 'hide': '']">
					<view class="label">尾款金额</view>
					<view class="number">￥0</view>
				</view>
				<view class="calculate-item">
					<view class="label">月供</view>
					<view class="number" style="font-size: 35rpx;">￥1000</view>
				</view>
			</view>
			<view class="test-drive-btn">预约试驾</view>
			<view
			class="tips"
			:class="[!isCollapse ? 'hide': '']">为什么试驾需要预约?为保证每位客户都享受到一对一的试驾体验，我们需要根据您提供的信息来提前安排合适的试驾地点和时间。如您填写并提交上述信息,表示您同意特斯拉按照客户隐私政策(www.tesla.cn/about/legal)收集、使用这些信息。
</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				product: 'Model3',
				products: ['Model3', 'Model Y', 'Model S'],
				productLine: '高性能版',
				productLines: ['高性能版', '标准续航版'],
				price: 0,
				priceList: [],
				financePlan: '合作贷款机构',
				financePlans: [],
				financeProduct: '标准贷款',
				financeProducts: ['标准贷款'],
				periodsOptions: ['12期', '24期'],
				periods: '12期',
				rate: 15,
				annualizedRateList: [],
				annualizedRate: '4.00',
				isCollapse: false,
				originProductData: [],
				downPayment: 0,
				loan: 0,
				allProvinces: [],
				allCities: [],
				allFinanceOrgs: [],
				financeOrgs: [
					{logo: 'https://cdn.mos.cms.futurecdn.net/BQwukuZwwwXrg27B9Le2Q6-970-80.png.webp'},
					{logo: 'https://cdn.mos.cms.futurecdn.net/BQwukuZwwwXrg27B9Le2Q6-970-80.png.webp'},
					{logo: 'https://cdn.mos.cms.futurecdn.net/BQwukuZwwwXrg27B9Le2Q6-970-80.png.webp'}
				],
				province: [],
				cities: [],
				currentProvince: '',
				currentCity: '',
				currentProductImage: 'https://cdn.mos.cms.futurecdn.net/BQwukuZwwwXrg27B9Le2Q6-970-80.png.webp',
				minusCircle: '../../static/images/icon/minus-circle.png',
				plusCircle: '../../static/images/icon/plus-circle.png'
			};
		},
		methods: {
			toggleCollapse () {}
		}
	}
</script>

<style lang="scss">
@import url("lenders-toolbox.css");
</style>
