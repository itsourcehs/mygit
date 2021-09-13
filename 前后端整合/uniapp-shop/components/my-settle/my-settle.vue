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
			...mapGetters('m_user', ['addstr']),
			...mapState('m_user', ['token']),
			// 是否全选 比较已勾选商品和总商品
			isFullCheck () {
				return this.total === this.checkedCount
			}
		},
		data() {
			return {
				
			};
		},
		methods: {
			// 把 m_cart 模块提供的 updateAllGoodsState 方法映射到当前组件中使用
			...mapMutations('m_cart', ['updateAllGoodsState']),
			
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
				
				// 3. 最后判断用户是否登录了
				if (!this.token) return uni.$showMsg('请先登录！')
			}
		}
	}
</script>

<style lang="scss">
.my-settle-container {
	position: fixed;
	// bottom: 0; // 待解决H5 小程序兼容
	bottom: 101rpx;
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
