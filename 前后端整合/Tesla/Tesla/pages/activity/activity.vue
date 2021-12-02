<template>
	<view>
		<button @tap="Test">拿到数据</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			Test () {
				const db = uniCloud.database();
				const collection = db.collection('tesla_index_swpierList');
				console.log(collection);
			}
		}
	}
</script>

<style>

</style>
