import { login } from "@/api/login.js"

const user = {
	state: {
		
	},
	
	mutations: {
		
	},
	
	actions: {
		// 登录
		Login(userInfo) {
			debugger
		  const username = userInfo.username.trim()
		  return new Promise((resolve, reject) => {
			login(username, userInfo.password).then(response => {
			  const data = response.data
			  resolve()
			}).catch(error => {
			  reject(error)
			})
		  })
		},
		
		
	}
}

export default user