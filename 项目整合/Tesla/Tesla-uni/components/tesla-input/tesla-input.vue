<template>
	<view class="input-item">
		
		<view v-if="label" class="label">{{label}}</view>
		
		<!-- :disabled="!writable || disabled" -->
		<input
		:class="[isError ? 'error' : '',disabled ? 'disabled' : '']"
		auto-focus="true"
		:disabled="!writable || disabled ? 0 : 1"
		@input="onInput"
		:value="val"/>
		
		<view v-if="isError" class="error-message">{{errorMessage}}</view>
		
		<view v-if="tips" class="tips">{{tips}}</view>
		
		<view class="slot-right-item">
			<slot name="right-item"></slot>
		</view>
		
	</view>
</template>

<script>
	export default {
		name:"tesla-input",
		components: {
			multipleSlots: true // 在组件定义时的选项中启用多slot支持
		},
		data() {
			return {
				isError: false,
				errorMessage: '',
				inputValue: ''
			};
		},
		// 组件自定义属性列表
		props: {
			required: {
				type: Boolean,
				value: false
			},
			rules: {
				type: Array,
				value: []
			},
			label: {
				type:String,
				value: ''
			},
			val: {
				type:String || Number,
				value: ''
			},
			disabled: {
				type: Boolean,
				value: false
			},
			writable: {
				type: Boolean,
				value: true,
			},
			tips: {
				type: String,
				value: ''
			}
		},
		
		methods: {
			onInput (e) {
				const _value = e.detail.value
				this.checkError(_value)
				this.inputValue = _value
			},
			
			// 校验输入
			checkError (newval) {
				this.handleRequired(newval)
				this.handleRules(newval)
			},
			handleRequired (newval) {
				if (newval === '') {
					this.isError = true
					this.errorMessage = '请输入' + this.$props.label
				} else {
					this.isError = false
				}
			},
			handleRules (newval) {
				this.$props.rules.forEach(rule => {
					this.handleRule(rule,newval)
				})
			},
			handleRule (rule,newval) {
				switch (rule.type) {
					case 'email': this.handleEmailCheck(newval);break;
					case 'phone': this.handlePhoneCheck(newval);break;
				}
			},
			// 校验输入邮箱
			handleEmailCheck (newval) {
				let format = /^[A-Za-z0-9+]+[A-Za-z0-9\.\_\-+]*@([A-Za-z0-9\-]+\.)+[A-Za-z0-9]+$/;
				if (!this.$props.val.match(format) && newval === '') {
					this.isError = true
					this.errorMessage = '请输入正确的电子邮件地址...'
				} else {
					this.isError = false
				}
			},
			
			// 校验输入手机号
			handlePhoneCheck (newval) {
				if (!(/^1[3456789]\d{9}$/.test(this.$props.val)) && newval === '') {
					this.isError = true
					this.errorMessage = '请输入正确的手机号码...'
				} else {
					this.isError = false
				}
			}
		}
	}
</script>

<style lang="scss">
@import url("tesla-input.css");
</style>
