// 导出以用于全局使用 module.exports (Json Object)
module.exports = {
	interfaceUrl: utils.interfaceUrl(),
	toast: utils.toast,
	request: utils.request,
	getToken: utils.getToken(),
	modal: utils.modal()
};

// 声明对象
const utils = {
	// 服务器域名
	// domain: 'http://localhost:8080/',
	domain: 'https://fly2you.cn/',
	// 接口地址  http://localhost:8080/platform/api/
	interfaceUrl: function() {return utils.domain + 'platform/api/'},
	
	// 封装 toast
	toast (text, duration, success) {
		uni.showToast({
			title: text || "出错啦~",
			icon: success || 'none',
			duration: duration || 2000
		})
	},
	
	// 封装弹窗 modal
	modal (title, content, showCancel = false, callback, confirmColor, confirmText, cancelColor, cancelText) {
		uni.showModal({
			title: title || '提示',
			content: content,
			showCancel: showCancel,
			cancelColor: cancelColor || "#555",
			confirmColor: confirmColor || "#e41f19",
			confirmText: confirmText || "确认",
			cancelText: cancelText || "取消",
			
			success: (res) => {
				// 如果点击确认
				if (res.confirm) {
					callback && callback(true)
				} else {
					callback && callback(false)
				}
			}
			
		})
	},
	
	// 延迟
	delayed: null,
	/*
	封装数据请求:
	1.url 请求地址
	2.param 请求参数
	3.method 请求方式
	4.contentType 请求数据格式
	5.isDelay 是否延迟显示loading
	6.hideLoading 是否隐藏loading
	*/
   request: function(url, param = {}, method = "POST", contentType = "application/x-www-form-urlencoded", isDelay, hideLoading) {
	   let loadding = false
	   utils.delayed && uni.hideLoading()
	   clearTimeout(utils.delayed);
	   utils.delayed = null;
	   
	   // 如果正在展示loading...
	   if (!hideLoading) {
		   utils.delayed = setTimeout( () => {
			uni.showLoading({
				mask: true,
				title: '请稍候....',
				success (res) {
					loadding = true
				}
			})
		   }, isDelay ? 1000 : 0)
	   }
		
		return new Promise((resolve, reject) => {
			uni.request({
				url: utils.interfaceUrl() + url,
				data: param,
				header: {
					'content-type': contentType,
					'X-Nideshop-Token': utils.getToken()
				},
				method: method,
				dataType: 'json',
				success: (res) => {
					
					if (loadding && !hideLoading) {
						uni.hideLoading()
					}
					
					if (res.statusCode === 200) {
						if (res.data.errno === 401) {
							// 弹窗提示,并跳转到登录
							utils.modal('温馨提示', '您还没有登录，是否去登录', true, (confirm) => {
								if (confirm) {
									// 重定向到登录认证页
									uni.redirectTo({
										url: '/pages/auth/btnAuth/btnAuth.vue'
									})
								} else {
									uni.navigateBack({
										delta: 1,
										fail: (res) => {
											uni.switchTab({
												url: '/pages/index/index.vue'
											})
										}
									})
								}
							})
						} else if (res.data.errno === 500) {
							utils.toast(res.data.msg)
						} else if (res.data.errno === 404) {
							utils.toast(res.data.msg)
						} else {
							// 操作成功调用 resolve
							resolve(res.data)
						}
					} else {
						// 操作失败(如果返回statusCode不是200)调用 reject
						reject(res.data.msg)
					}
				},
				fail: (res) => {
					utils.toast("网络不给力，请稍后再试~")
					reject(res)
				},
				// 接口调用结束的回调函数
				complete: (res) => {
					clearTimeout(utils.delayed)
					utils.delayed = null
					if (res.statusCode === 200) {
						if (res.data.errno === 0 || res.data.errno === 401) {
							uni.hideLoading()
						} else {
							utils.toast(res.data.msg)
						}
					} else {utils.toast('服务器开小差了~')}
				}
			})
		})
   },
   
   // 获取token
   getToken () {return uni.getStorageSync("X-Nideshop-Token")},
}