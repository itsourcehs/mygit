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
				errorMessage: ''
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
				console.log(e.detail.value);
			},
			checkError () {
				
			},
			_handleRequired () {
				
			},
			_handleRules () {},
			_handleRule (rule) {},
			_handleEmailCheck () {},
			_handlePhoneCheck () {},
			isReady () {}
		}
	}
</script>

<style lang="scss">
@import url("tesla-input.css");
</style>
