<template>
	<view class="cart-container" v-if="cart.length !== 0">
		<!-- 收获地址区域 -->
		<my-address></my-address>
		
		<!-- 购物车商品列表的标题区域 -->
		<view class="cart-title">
		  <!-- 左侧的图标 -->
		  <uni-icons type="shop" size="18"></uni-icons>
		  <!-- 描述文本 -->
		  <text class="cart-title-text">购物车</text>
		</view>
		
		<!-- 商品列表区域 -->
		<uni-swipe-action>
			<block v-for="(goods, i) in cart" :key="i">
				<uni-swipe-action-item
				:options="options"
				@click="swiperActionClickHandler(goods)">
					<my-goods :goods="goods"
					:showRadio="true"
					:show-num="true"
					@radio-change="radioChangeHandler"
					@num-change="numberChangeHandler"></my-goods>
				</uni-swipe-action-item>
			</block>
		</uni-swipe-action>
		
		<!-- 结算区域 -->
		<view class="settle">
			<my-settle></my-settle>
		</view>
	</view>
	
	<!-- 空白购物车区域 -->
	<view class="empty-cart" v-else>
		<image src="../../static/empty_so.svg" class="empty-img"></image>
		<text class="tip-text">暂时木有内容呀~ ~</text>
	</view>
</template>

<script>
	// 导入自己封装的 mixin 模块
	import badgeMix from '@/mixins/tabbar-badge.js'
	// 按需导入 mapState 这个辅助函数
	import { mapState, mapMutations} from 'vuex'
	export default {
		// 将 badgeMix 混入到当前的页面中进行使用
		mixins: [badgeMix],
		computed: {
			// 将 m_cart 模块中的 cart 数组映射到当前页面中使用
			...mapState('m_cart', ['cart']),
		},
		data() {
			return {
				options: [{
						text: '删除',
						style: {backgroundColor: '#C00000'}
					}]
			};
		},
		methods: {
			// 商品的勾选状态发生了变化
			radioChangeHandler (e) {
				// e 表示传递过来的商品Id和勾选状态
				console.log(e);
				this.updateGoodsState(e)
			},
			
			...mapMutations('m_cart', ['updateGoodsState', 'updateGoodsCount', 'removeGoodsById']),
			
			// 商品的数量发生了变化
			numberChangeHandler (e) {
				// e 表示传递过来的商品Id和商品的最新数量
				console.log(e);
				this.updateGoodsCount(e)
			},
			swiperActionClickHandler (goods) {
				console.log(goods);
				// 调用映射的方法 removeGoodsById 传入商品id
				this.removeGoodsById(goods.goods_id)
			}
		}
	}
</script>

<style lang="scss">
.cart-container {
	padding-bottom: 50rpx;	
}
.cart-title {
		height: 40px;
		display: flex;
		align-items: center;
		font-size: 14px;
		padding-left: 5rpx;
		border-bottom: 1px solid #efefef;
		
		.cart-title-text {margin-left: 10px;}
}
.settle {
	
}

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
