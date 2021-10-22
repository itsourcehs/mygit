<template>
	<view>
		<view class="goods-list">
			<view v-for="(goods, i) in goodsList" :key="i" @click="gotoDetail(goods)">
				<my-goods :goods="goods"></my-goods>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				queryObj: {
					// 依次表示:查询关键词+商品分类Id+页码值+每页显示多少条数据
					query: '',
					cid: '',
					pagenum: 1,
					pagesize: 10
				},
				// 商品列表数据
				goodsList: [],
				// 商品总数量
				total: 0,
				
				// 添加节流阀,判断是否正在请求数据,以达到防止发起额外的请求
				isloading: false
			};
		},
		onLoad (options) {
			// 将页面跳转时携带的参数，转存到 queryObj 对象中
			console.log(options);
			this.queryObj.query = options.query || ''
			this.queryObj.cid = options.cid || ''
			
			this.getGoodsList()
		},
		methods: {
			async getGoodsList (cb) {
				// 发起请求前,打开节流阀
				this.isloading = true
				
				const { data: res } = await uni.$http.get('/api/public/v1/goods/search', this.queryObj)
				// 关闭节流阀
				this.isloading = false
				
				 // 只要数据请求完毕，就立即按需调用 cb 回调函数
				cb && cb()
				if (res.meta.status !== 200) return uni.$showMsg()
				
				// this.goodsList = res.message.goods
				// 为数据赋值：通过展开运算符的形式，进行新旧数据的拼接
				this.goodsList = [...this.goodsList, ...res.message.goods]
				this.total = res.message.total
			},
			gotoDetail (goods) {
				uni.navigateTo({
					url: '/subpkg/goods_detail/goods_detail?goods_id=' + goods.goods_id
				});
			}
		},
		// 触底的事件(上滑加载更多)
		onReachBottom () {
			// 判断是否还有下一页数据
			if (this.queryObj.pagenum * this.queryObj.pagesize >= this.total) return uni.$showMsg('数据加载完毕!')
			// 判断是否正在请求其它数据，如果是，则不发起额外的请求
			if (this.isloading) return
			
			// 让页码值自增 +1
			this.queryObj.pagenum += 1
			// 重新获取列表数据
			this.getGoodsList()
		},
		onPullDownRefresh () {
			// 1. 重置关键数据
			this.queryObj.pagenum = 1
			this.total = 0
			this.isloading = false
			this.goodsList = []
			
			// 2. 重新发起请求
			this.getGoodsList(() => uni.stopPullDownRefresh())
		}
	}
</script>

<style lang="scss">

</style>
