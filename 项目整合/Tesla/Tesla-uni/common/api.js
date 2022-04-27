// 测试环境服务器域名
const BASE_URL = 'http://localhost:8081'

// 对外暴露封装的request 请求function
const request = (options) => {
	return new Promise((resolve,reject) => {
		uni.request({
			url: BASE_URL + options.url,
			method: options.method || 'GET',
			data: options.data || {},
			success: (res) => {
				resolve(res)
			},
			fail: (err) => {
				uni.showToast({
					title: '接口请求失败'
				})
				reject(err)
			}
		})
	})
}

export default request