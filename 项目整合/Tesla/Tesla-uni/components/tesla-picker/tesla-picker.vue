<template>
	<view>
		<picker class="picker" @change="onChange" :value="index" :range="optionList">
			<tesla-input :writable="false" required :label="title" :val="value">
				<image class="icon-down" src="@/static/images/icon/ic_arrow_down.svg"></image>
			</tesla-input>
		</picker>
	</view>
</template>

<script>
	export default {
		name:"tesla-picker",
		props: {
			 title: {
				type: String,
				value: ''
			},
			labelKey: {
				type: String,
				value: ''
			},
			defaultValue: {
				type: String | Number,
				value: '',
				observer(newValue, oldValue) {
					this.initValue(newValue)
				}
			},
			options: {
				type: Array,
				value: [],
				observer() {
					this.buildOptionList()
				}
			}
		},
		data() {
			return {
				value: '',
				index: 0,
				optionList: []
			};
		},
		methods: {
			onChange (e) {
				debugger
				const val = this.optionList[e.detail.value]
				this.value = val
				this.$emit('change',{val, index: e.detail.value})
			}
		}
	}
</script>

<style>
@import url("tesla-picker.css");
</style>
