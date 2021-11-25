<template>
	<view>
		<my-tabs
		:tabs="tabs"
		@tabsItemChange="handleTabsItemChange">
			
			<!-- 订单数据区域 -->
			<view class="order" v-if="orders.length != 0">
				<view class="orders" v-for="(item, index) in orders" :key="index">
					<view class="orders_item">
						<view>订单编号</view>
						<text>{{item.order_number}}</text>
					</view>
					<view class="orders_item">
						<view>订单价格</view>
						<text class="orders_price">￥{{item.order_price}}</text>
					</view>
					<view class="orders_item">
						<view>订单日期</view>
						<text class="orders_time">{{item.create_time}}</text>
					</view>
				</view>
			</view>
			
			<!-- 没有订单数据区域 -->
			<view class="empty-cart" v-else>
				<image src="../../static/empty_so.svg" class="empty-img"></image>
				<text class="tip-text">暂时木有内容呀~ ~</text>
			</view>
		</my-tabs>
	</view>
</template>

<script>
export default {
	data() {
		return {
			tabs: [
				{
					id:1,
					value: '全部订单',
					isActive: false
				},
				{
					id:2,
					value: '待付款',
					isActive: false
				},
				{
					id:3,
					value: '待发货',
					isActive: false
				},
				{
					id:4,
					value: '退货/换货',
					isActive: false
				},
			],
			orders: [
				{
					order_number: '',
					order_price: '',
					create_time: ''
				}
			]
		}
	},
	methods: {
		// 获取订单列表
		async getOrderList (type) {
			const {data: res} = await uni.$http.get('/api/public/v1/my/orders/all', {type:type})
			this.orders = res.message.orders
		},
		
		// 父组件自定义事件
		handleTabsItemChange (index) {
			console.log(index); // 传递过来的索引 0 1 2 	1:全部订单 2:待付款 3:待发货
			this.tabs.forEach((v, i) => i + 1 === index?v.isActive = true: v.isActive = false)
			
			// 发送网络请求,返回对应列(待付款,待收货,退货,全部订单)的数据
			this.getOrderList(index)
		}
	},
	
	// 监听页面加载,参数 options 为上个页面传递的数据  坑: 生命周期函数不能使用箭头函数
	/*
	 * onShow: () => {
		生命周期钩子不能使用 箭头函数 , 官网已说明
	}
	 */
	onShow () {
		/*
		 * 通过页面栈,实现借助 onShow 函数获取页面url上的参数值
		 */
		// console.log(this);
		
		// 1.获取当前小程序的页面栈: 返回一个数组,最大长度为10页面
		let page = getCurrentPages()
		
		// 2.数组中最大索引页面为当前页面
		let currentPage = page[page.length - 1]
		
		// 3.获取 url 上的参数值
		const type = currentPage.options.type
		// debugger
		
		const tabs = this.tabs
		// 4.判断传递过来的参数与那个 tabs 项id相等,就激活哪一项
		tabs.forEach(v => {
			if (v.id == type) { // 坑: 之前写的是 ===(这个需要值和类型同时相同才会走条件) == 是比较值是否相等
				v.isActive = true
			}
			// 5.数据回填,重新设置
			// this.tabs = tabs
		})
		
		// 5.调用对应 type 的订单列表方法
		this.getOrderList(type)
	}
}
</script>

<style lang="scss">
.orders {
	padding: 22rpx;
	border: 1px solid #d6d6d6;
	margin-bottom: -1rpx;font-size: 30rpx;
	color: #947876;
}
.orders_item {
	display: flex;
	justify-content: space-between;align-items: center;
	line-height: 50rpx;
	
}
.orders_price {
	color: var(--themeColor);
	font-size: 34rpx;
}
.orders_time {color: #b1b1b1;}

/* 重复内容,需要改为全局样式 */
.empty-cart {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 150px;

  .empty-img {
    width: 164px;
    height: 142px;
  }

  .tip-text {
    font-size: 12px;
    color: gray;
    margin-top: 15px;
  }
}
</style>
