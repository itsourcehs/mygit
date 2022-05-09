// 时间日期格式化
export default function timeFormat () {
	let date = new Date()
	let year = date.getFullYear().toString().padStart(4,"0") // 年
	let month = (date.getMonth() +1).toString().padStart(2,"0") // 月
	let day = date.getDate().toString().padStart(2,"0") // 日
	
	let hours = date.getHours().toString().padStart(2,"0") // 时
	let min = date.getMinutes().toString().padStart(2,"0") // 分
	let sec = date.getSeconds().toString().padStart(2,"0") // 秒
	return year + '-' +　month + '-' +　day +　' ' + hours + ':' + min + ':' + sec
}