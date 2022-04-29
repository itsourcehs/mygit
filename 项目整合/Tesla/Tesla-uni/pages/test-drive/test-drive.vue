<template>
	<view class="page">
		<view class="form-tip">
		    请填写下方申请表
		</view>
		
		<view class="form">
			<form action="">
				
				<view class="name-area">
					<view class="name-box">
						<tesla-input class="tesla-input" required label="姓氏" :val="lastName"></tesla-input>
					</view>
					<view class="name-box">
						<tesla-input class="tesla-input" required label="名字" :val="firstName"></tesla-input>
					</view>
				</view>
				
				<tesla-input class="tesla-input" required :rules="[{type: 'email'}]" label="电子邮箱" :val="email"></tesla-input>
				
				<tesla-input class="tesla-input" required :rules="[{type: 'phone'}]" label="手机号" :val="phone">
					<button class="get-phone-btn" open-type="getPhoneNumber" slot="right-item" @getphonenumber="getPhoneNumber" type="primary">获取手机号码</button>
				</tesla-input>
				
				<picker mode="region" @change="bindProvinceChange" :value="currentProvinceIndex" range-key="fullname" :range="provincesAndCitiesTree">
					<tesla-input writable="false" required label="省份" :value="province" />
				</picker>
				
				<picker @change="bindCityChange" :value="currentCityIndex" range-key="fullname" :range="cities">
					<tesla-input  writable="false" required label="城市" :value="city" />
				</picker>
				
				<uni-data-picker ></uni-data-picker>
				
				<view class="form-item">
					<checkbox value="cb" checked="true" color="#000"><view class="label">获取Tesla最新资讯</view></checkbox>
				</view>
				
				<view class="bottom-tips">
					这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示这是一个简单提示
				</view>
				
				<view class="test-drive-btn" @tap="onSubmit">预约试驾</view>
				
			</form>
		</view>
		
	</view>
</template>

<script>
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
				console.log(e.detail.value); // ["北京市", "北京市", "丰台区"]
			},
			
			onSubmit () {
				console.log('试驾');
			},
			
			getPhoneNumber (e) {
				console.log(e);
			}
		}
	}
</script>

<style>
@import url("test-drive.css");
</style>
