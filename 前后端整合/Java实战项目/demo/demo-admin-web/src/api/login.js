import request from '@/common/request.js'

export function login(username, password) {
	return request({
		url: '/admin/login',
		method: 'post',
		data: {
		  username,
		  password
		}
	})
}

export function getInfo() {
  return request({
    url: '/admin/info',
    method: 'get',
  })
}