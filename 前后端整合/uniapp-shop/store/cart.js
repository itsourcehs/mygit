export default {
	// 为当前模块开启命名空间
	namespaced: true,
	
	// 模块的 state 数据
	state: () => ({
		// 购物车的数组，用来存储购物车中每个商品的信息对象
		// 每个商品的信息对象，都包含如下 6 个属性：
		// { goods_id, goods_name, goods_price, goods_count, goods_small_logo, goods_state }
		
		// cart: [] 改成下面读取本地存储的购物车信息
		cart: JSON.parse(uni.getStorageSync('cart') || '[]')
	}),
	
	// 模块的 mutations 方法
	mutations: {
		// 将商品信息加入购物车
		addToCart (state, goods) {
			// 根据提交的商品的Id，查询购物车中是否存在这件商品
			// 如果不存在,则 findResult 为 undefined；否则,为查找到的商品信息对象
			const findResult = state.cart.find((x) => x.goods_id === goods.goods_id)
			
			// 如果购物车中没有这件商品，则直接 push
			if (!findResult) {state.cart.push(goods)}
			// 如果购物车中有这件商品，则只更新数量即可
			else {findResult.goods_count++}
			
			console.log(state.cart);
			
			// 通过 commit 方法，调用 m_cart 命名空间下的 saveToStorage 方法
			this.commit('m_cart/saveToStorage')
		},
		
		// 将购物车中的数据持久化存储到本地
		saveToStorage (state) {
			uni.setStorageSync('cart', JSON.stringify(state.cart))
		},
		
		// 修改对应商品的勾选状态
		updateGoodsState (state, goods) {
			// 根据 goods_id 查询购物车中对应商品的信息对象
			const findResult = state.cart.find(x => x.goods_id === goods.goods_id)
			
			// 有对应的商品信息对象
			if (findResult) {
				// 更新对应商品的勾选状态
				findResult.goods_state = goods.goods_state
				// 持久化存储到本地
				this.commit('m_cart/saveToStorage')
			}
		},
		
		// 更新购物车中商品的数量
		updateGoodsCount (state, goods) {
			// 根据 goods_id 查询购物车中对应商品的信息对象
			const findResult = state.cart.find(x => x.goods_id === goods.goods_id)
			
			if (findResult) {
				// 更新对应商品的数量
				findResult.goods_count = goods.goods_count
				// 持久化存储到本地
				this.commit('m_cart/saveToStorage')
			}
		},
		
		// 根据id从购物车中移除对应商品
		removeGoodsById (state, goods_id) {
			// 调用数组的filter进行过滤
			state.cart = state.cart.filter(x => x.goods_id !== goods_id)
			// 持久化存储到本地
			this.commit('m_cart/saveToStorage')
		}
	},
	
	// 模块的 getters 属性
	getters: {
		// 统计购物车中商品的总数量
		total (state) {
			let c = 0
			// 循环统计商品的数量，累加到变量 c 中
			state.cart.forEach(goods => c += goods.goods_count)
			return c
		}
	},
}