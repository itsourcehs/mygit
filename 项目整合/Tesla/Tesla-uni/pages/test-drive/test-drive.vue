<template>
	<view class="page">
		<view class="form-tip">请填写下方申请表</view>
		
		<view class="form">
			<form action="">
				
				<view class="name-area">
					<view class="name-box">
						<tesla-input class="tesla-input" required label="姓氏" :val="lastName" ref="lastname"></tesla-input>
					</view>
					<view class="name-box">
						<tesla-input class="tesla-input" required label="名字" :val="firstName" ref="firstname"></tesla-input>
					</view>
				</view>
				
				<tesla-input class="tesla-input" required :rules="[{type: 'email'}]" label="电子邮箱" :val="email" ref="email"></tesla-input>
				
				<tesla-input class="tesla-input" required :rules="[{type: 'phone'}]" label="手机号" :val="phone" ref="phone">
					<!-- <button class="get-phone-btn" open-type="getPhoneNumber" slot="right-item" @getphonenumber="getPhoneNumber" type="primary">获取手机号码</button> -->
				</tesla-input>
				
				<picker mode="region" @change="bindProvinceChange" :value="currentProvinceIndex" :range="provincesAndCitiesTree">
					<tesla-input writable="false" required label="省份" :val="province" />
				</picker>
				
				<tesla-input writable="false" required label="城市" :val="city" />
				
				<!-- <picker mode="region" @change="bindCityChange" :value="currentCityIndex" :range="cities">
					<tesla-input writable="false" required label="城市" :val="city" />
				</picker> -->
				
				<!-- <uni-data-picker ></uni-data-picker> -->
				
				<view class="form-item">
					<checkbox value="cb" checked="true" color="#000"><view class="label">获取Tesla最新资讯</view></checkbox>
				</view>
				
				<view class="bottom-tips">
					这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示
				</view>
				
				<view class="test-drive-btn" @tap="onSubmit">预约试驾</view>
				
			</form>
		</view>
		
	</view>
</template>

<script>
	import timeFormat from '../../common/utils.js' // 引入函数不加{}
	export default {
		data() {
			return {
				lastName: '',
				firstName: '',
				email: '',
				phone: '',
				city: '',
				province: '',
				currentProductId: null,
				provincesAndCitiesTree: [],
				cities: [],
				currentProvinceIndex: 0,
				currentCityIndex: 0
			}
		},
		methods: {
			
			// 选择省份
			bindProvinceChange (e) {
				let proList = e.detail.value // ["北京市", "北京市", "丰台区"]
				this.province = proList[this.currentProvinceIndex]
				this.city = proList[this.currentProvinceIndex +1]
			},
			
			async onSubmit () {
				// 提交表单
				let subForm = {
					applyLastname: this.$refs.lastname.inputValue,
					applyFirstname: this.$refs.firstname.inputValue,
					applyEmail: this.$refs.email.inputValue,
					applyPhone: this.$refs.phone.inputValue,
					applyProvince: this.province,
					applyCity: this.city,
					applyStatus: 'to_do',
					applyProductid: '2',
					applyCreatetime: timeFormat(),
					applyUpdtetime: '2022-05-05 09:03:44'
				}
				
				// loading 提示框
				uni.showLoading({
					title: '正在提交...',
					mask: true ,// 防止穿透
				})
				
				// 请求接口处理表单数据
				await this.$api({url: '/api/v1/apply/add', method: 'POST', data: subForm}).then(res => {
					// console.log("请求成功",subForm);
					if (res.data.code === "0") {
						// 关闭loading
						setTimeout(function () {
							uni.hideLoading();
						}, 500);
						
						uni.showModal({
							title: '预约成功.',
							content: '感谢您提交Tesla试驾请求。我们的工作人员会及时跟您电话联系',
							showCancel: false,
							success() {
								uni.navigateBack({
									delta: 0
								})
							}
						})
					}
				})
			},
			
			// 只有企业主体认证的账号才能用这个api
			getPhoneNumber (e) {
				console.log(e);
			}
		}
	}
</script>

<style>
@import url("test-drive.css");
</style>
