<template>
	<view>
		<van-field v-model="value" placeholder="请输入用户名" />
		输入框
	</view>
</template>

<script>
	import { Field } from 'vant'
	export default {
		name:"tesla-field",
		data() {
			return {
				value: ''
			};
		}
	}
</script>

<style lang="scss">
@import url("tesla-field.css");
</style>