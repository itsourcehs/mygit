export default {
	// 为当前模块开启命名空间
	namespaced: true,
	
	// 模块的 state 数据
	state: () => ({
		// address: {} 改成下面读取本地存储的地址信息
		address: JSON.parse(uni.getStorageSync('address') || '{}'),
		
		// 登录成功之后的 token 字符串
		token: uni.getStorageSync('token') || '',
		
		// 微信用户基本信息
		userinfo: JSON.parse(uni.getStorageSync('userinfo') || '{}'),
	
		/*
		 * 用于重定向的 object 对象 {openType, from}
		 * openType: 表示以哪种方式跳转回原页面
		 * from: 表示原页面的url
		 */
		redirectInfo: null
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
		
		// 更新用户基本信息
		updateUserInfo (state, userinfo) {
			state.userinfo = userinfo
			// 调用 m_user 模块下的 saveUserInfoToStorage 方法，将 userinfo 对象持久化存储到本地
			this.commit('m_user/saveUserInfoToStorage')
		},
		
		// 将 userinfo 持久化存储到本地
		saveUserInfoToStorage (state) {
			uni.setStorageSync('userinfo', JSON.stringify(state.userinfo))
		},
		
		// 更新token
		updateToken (state, token) {
			state.token = token
			
			// 调用 m_user 模块下的 saveTokenToStorage 方法，将 token 字符串持久化存储到本地
			this.commit('m_user/saveTokenToStorage')
		},
		
		// 将 token 字符串持久化存储到本地
		saveTokenToStorage (state) {
			uni.setStorageSync('token', state.token)
		},
		
		// 更新重定向的信息对象
		updateRedirectInfo (state, info) {
			state.redirectInfo = info
		},
	},
	
	// 模块的 getters 属性
	getters: {
		// 收货详细地址的计算属性
		addstr (state) {
			if (!state.address.provinceName) return ''
			
			// 拼接省市县区详细地址的字符串并返回给用户
			return state.address.provinceName + state.address.cityName + state.address.countyName + state.address.detailInfo
		},
	}
}