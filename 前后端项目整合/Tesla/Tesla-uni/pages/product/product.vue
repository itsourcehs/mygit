<template>
	<view class="page">
		
		<image class="banner" src="@/static/images/swiper/car.png" mode="widthFix"></image>
		
		<view class="description"><rich-text :nodes="product.description"></rich-text></view>
		
		<view class="product-line">
			<view class="product-config-area">
				<view class="product-config-box" v-for="(item,index) in product.product_line" :key="index">
					<view class="title">{{item.title}}</view>
					<view class="subtitle">{{item.subtitle}}</view>
					<view class="line"></view>
					<view class="config-list">
						<view class="config-box" v-for="(config,index2) in item.configList" :key="index2">
							<view class="label">{{config.label}}</view>
							<view class="value">{{config.value}}</view>
						</view>
					</view>
				</view>
			</view>
		</view>
		
		<view class="info-box">
		    贯之的高性能与高科技配置。中国制造的Model3标准续航升级版将进一步拉低Model 3的起售价格，同时保持了Tesla一以贯之的高性能与高科技配置。中国制造.
		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				product: {
					description: '特斯拉公司从事全电动汽车、能源生产和存储系统的设计、开发、制造和销售。它还提供汽车服务中心、增压器和自动驾驶功能。该公司经营的领域包括汽车、能源生产和储存。汽车部门包括电动汽车的设计、开发、制造和销售。能源生产和储存部门包括设计、制造、安装、销售和租赁固定储能产品和太阳能系统,以及向客户销售其太阳能系统产生的电力，用于家庭、商业设施和公用事业场所的储能产品。',
					product_line: [
						{
							"id": "123",
							"cltc": "556",
							"created_time": "1638859878734",
							"title": "Model3",
							"subtitle": "标准续航升级版",
							"price": 23400,
							"tire_size": 18,
							"updated_time": "1638859878734",
							configList: [
								{
									"label": "起售价格",
									"value": 4000
								},
								{
									"label": "尺寸",
									"value": "20英尺"
								},
								{
									"label": "续航能力",
									"value": "4000公里"
								}
							]
						},
						{
							"id": "123",
							"cltc": "556",
							"created_time": "1638859878734",
							"title": "Model2",
							"subtitle": "高续航版",
							"price": 23400,
							"tire_size": 18,
							"updated_time": "1638859878734",
							configList: [
								{
									"label": "起售价格",
									"value": 14000
								},
								{
									"label": "尺寸",
									"value": "30.5英尺"
								},
								{
									"label": "续航能力",
									"value": "8000公里"
								}
							]
						}
					]
				}
			}
		},
		methods: {
			
		}
	}
</script>

<style>
@import url("product.css");
</style>
