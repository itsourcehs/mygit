<template>
	<view class="search-input">
		<image class="search-icon"></image>
		<input type="text" @input="onInput" placeholder="搜索" placeholder-class="placeholder" @confirm="onConfirm" :value="val"/>
		<image v-if="isClearable" @tap="onClear" class="clear-icon" :src="cancelIcon"></image>
	</view>
</template>

<script>
	export default {
		name:"tesla-search-input",
		data() {
			return {
				isClearable: false,
				val: '',
				cancelIcon: '../../static/images/icon/cancel.png'
			};
		}
	}
</script>

<style lang="scss">
@import url("tesla-search-input.css");
</style>
