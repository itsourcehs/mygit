<template>
	<view class="my-settle-container">
		<!-- 全选区域 -->
		<label class="radio" @click="changeAllState">
			<radio color="#C00000" :checked="isFullCheck"><text>全选</text></radio>
		</label>
		
		<!-- 合计区域 -->
		<view class="amount-box">
			合计:<text class="amount">￥{{checkedGoodsAmount}}</text>
		</view>
		
		<!-- 结算按钮 -->
		<view class="btn-settle" @click="settlement">结算({{checkedCount}})</view>
	</view>
</template>

<script>
	import { mapGetters, mapMutations, mapState} from 'vuex'
	export default {
		name:"my-settle",
		computed: {
			// 映射 m_cart 模块的getters属性到当前组件
			...mapGetters('m_cart', ['checkedCount', 'total', 'checkedGoodsAmount']),
			...mapState('m_cart', ['cart']),
			
			...mapGetters('m_user', ['addstr']),
			...mapState('m_user', ['token']),
			// 是否全选 比较已勾选商品和总商品
			isFullCheck () {
				return this.total === this.checkedCount
			}
		},
		data() {
			return {
				// 倒计时的秒数
				seconds: 3,
				// 定时器函数返回值:intervalID,传递给 clearInterval 来取消该定时
				intervalID: null
			};
		},
		methods: {
			// 把 m_cart 模块提供的 updateAllGoodsState 方法映射到当前组件中使用
			...mapMutations('m_cart', ['updateAllGoodsState']),
			// 把 m_user 模块提供的 updateRedirectInfo 方法映射到当前组件中使用
			...mapMutations('m_user', ['updateRedirectInfo']),
			
			
			changeAllState () {
				/* 
				 修改购物车中所有商品的选中状态
				 !this.isFullCheck 表示：当前全选按钮的状态取反之后，就是最新的勾选状态
				 */
				this.updateAllGoodsState(!this.isFullCheck)
			},
			
			settlement () {
				// 1. 先判断是否勾选了要结算的商品
				if (!this.checkedCount) return uni.$showMsg('请选择要结算的商品！')
				
				// 2. 再判断用户是否选择了收货地址
				if (!this.addstr) return uni.$showMsg('请选择收货地址！')
				
				/*
				 * 3. 最后判断用户是否登录了
				 * 如果没有登录,预调方法delayNavigate()进行登录页的跳转
				 */
				// if (!this.token) return uni.$showMsg('请先登录！')
				if (!this.token) return this.delayNavigate()
				
				// 4.实现微信支付
				this.payOrder()
			},
			
			// 微信支付: 1.创建订单
			async payOrder () {
				// 1.1 创建订单信息对象 order_price consignee_addr goods
				const orderInfo = {
					/*
					 * 将购物车中商品合计金额写入 this.checkedGoodsAmount
					 * 测试时,写死为0.01
					 */
					// 订单总价格
					order_price: 0.01,
					// 收货地址
					consignee_addr: this.addstr,
					// 订单列表
					goods: this.cart.filter(x => x.goods_state).map(x => ({goods_id: x.goods_id, goods_number: x.goods_count, goods_price: x.goods_price}))
				}
				
				console.log(orderInfo);
				const provider = uni.getProvider({
					service: 'payment',
					success: (res4) => {
						console.log(res4);
						console.log('调用成功.');
					},
					fail: () => {
						console.log('调用失败!!!!!');
					}
				})
				// 1.2 发起请求创建订单
				const {data: res} = await uni.$http.post('/api/public/v1/my/orders/create', orderInfo)
				// console.log(res);
				
				if (res.meta.status !== 200) return uni.$showMsg('创建订单失败!')
				// uni.$showMsg('创建订单成功.')
				
				// 1.3 从响应数据中拿到订单编号 order_number
				const orderNumber = res.message.order_number
				// console.log(orderNumber);
				
				
				// 2.订单预支付
				// 2.1 发起请求获取订单的支付信息
				const {data: result} = await uni.$http.post('/api/public/v1/my/orders/req_unifiedorder', {order_number: orderNumber})
				// console.log(result);
				
				if (result.meta.status !== 200) return uni.$showMsg('预付订单生成失败!')
				// uni.$showMsg('预付订单生成成功.')
				// 2.2 拿到订单支付相关的必要参数
				const payInfo = result.message.pay
				payInfo.provider = 'wxpay'
				payInfo.orderInfo = orderInfo
				console.log(payInfo);
				
				// 3.发起微信支付  
				// 3.1 调用 wx.requestPayment() 发起微信支付
				const [err, succ] = await wx.requestPayment(payInfo)
				if (err) return console.log(err);
				
			},
			
			// 展示倒计时的提示消息
			showTips (number) {
				// 调用uni.showToast(),展示提示消息
				uni.showToast({
					icon: 'none',
					title: '请登录后再结算!' + number + '秒后自动跳转到登录页',
					// 为页面添加透明遮罩,防止点击穿透
					mask: true,
					duration: 1500
				})
				
			},
			
			// 延迟导航到 my 页面
			delayNavigate () {
				// 0.解决多次点击"结算"未重置倒计时秒数
				this.seconds = 3
				// 1.展示提示消息 seconds 初始值为3
				this.showTips(this.seconds)
				
				// 2.创建定时器,每秒执行一次
				this.intervalID = setInterval(() => {
					// 2.1 seconds 递减1
					this.seconds--
					
					// 2.2new 当倒计时的秒数≤0时 终止定时器
					if (this.seconds <= 0) {
						// 2.2.1 调用clearInterval(intervalID) 取消定时器
						clearInterval(this.intervalID)
						
						// 2.2.2 跳转到 my 页面
						uni.switchTab({
							url: '/pages/my/my',
							
							// 2.2.3 页面跳转成功后,执行回调函数,将重定向的信息对象存储到vuex
							success: () => {
								// 调用映射过来的 updateRedirectInfo 函数
								this.updateRedirectInfo({
									// 跳转方式
									openType: 'switchTab',
									// 从哪个页面跳转过去
									from: '/pages/cart/cart'
								})
							}
						})
						
						// 2.3 当秒数等于0时,不再展示toast提示消息
						return
					}
					
					// 2.2 再根据最新的秒数进行消息提示
					this.showTips(this.seconds)
				}, 1000)
			},
			
		}
	}
</script>

<style lang="scss">
.my-settle-container {
	position: fixed;
	bottom: 0; // 待解决H5 小程序兼容
	// bottom: 101rpx;
	width: 100%;
	height: 40px;
	background-color: white;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding-left: 5px;
	font-size: 14px;
	
	.radio {
	    display: flex;
	    align-items: center;
	  }
	
	  .amount {
	    color: #c00000;
	  }
	
	  .btn-settle {
	    height: 66rpx;
	    min-width: 100px;
	    background-color: #c00000;
	    color: white;
	    line-height: 60rpx;
	    text-align: center;
	    padding: 0 10px;
	  }
}
</style>
