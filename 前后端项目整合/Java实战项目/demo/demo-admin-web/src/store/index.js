// 缺失此js文件 项目运行报错
import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user.js'
import permission from './modules/permission.js'

Vue.use(Vuex)

// export default new Vuex.Store({
//   state: {
		
//   },
//   mutations: {
		
//   }
// })

const store = new Vuex.Store({
	modules: {
		user,
		permission
	}
})

export default store
