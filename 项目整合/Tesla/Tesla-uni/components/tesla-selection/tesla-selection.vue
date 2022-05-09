<template>
	<view class="tesla-selection">
		<view v-for="(option,index) in options" :key="index" :data-index="index" class="item" @tap="onTap">
			<view class="selection">
				<view class="selection-circle">
					<view class="check-circle" v-if="selectedIndex === index"></view>
				</view>
			</view>
			<view class="label">{{option}}</view>
		</view>
	</view>
</template>

<script>
	export default {
		name:"tesla-selection",
		data() {
			return {
				selectedIndex: 0 // 选中第一项
			};
		},
		props: {
			options: {
				type: Array,
				default: [],
			}
		},
		methods: {
			onTap (e) {
				const index = e.currentTarget.dataset.index // 获取每个选项的绑定索引值
				this.selectedIndex = index
				
				// 触发父组件上自身 change 事件,
				this.$emit('planchange',{index, label: this.$props.options[index]})
			}
		}
	}
</script>

<style lang="scss">
@import url("tesla-selection.css");
</style>
