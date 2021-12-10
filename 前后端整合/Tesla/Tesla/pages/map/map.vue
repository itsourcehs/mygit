<template>
	<view>
		<view class="content">{{content}}</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				content: ''
			}
		},
		methods: {
			getContent () {
				const that = this
				uni.request({
					url: 'http://localhost:8080/hello',
					method: 'GET',
					success: res => {
						console.log(res);
						that.content = res.data
					}
				})
			}
		},
		onLoad() {
			this.getContent()
		}
	}
</script>

<style>

</style>
