export default {
	// 为当前模块开启命名空间
	namespaced: true,
	
	// 模块的 state 数据
	state: () => ({
		// address: {} 改成下面读取本地存储的地址信息
		address: JSON.parse(uni.getStorageSync('address') || '{}')
	}),
	
	// 模块的 mutations 方法
	mutations: {
		// 更新收货地址
		updateAddress (state, address) {
			state.address = address
			// 将地址持久化保存到本地
			this.commit('m_user/saveAddressToStorage')
		},
		
		saveAddressToStorage (state) {
			uni.setStorageSync('address', JSON.stringify(state.address))
		},
	},
	
	// 模块的 getters 属性
	getters: {
		// 收货详细地址的计算属性
		addstr () {
			if (!this.address.provinceName) return ''
			
			// 拼接省市县区详细地址的字符串并返回给用户
			return this.address.provinceName + this.address.cityName + this.address.countyName + this.address.detailInfo
		},
	}
}