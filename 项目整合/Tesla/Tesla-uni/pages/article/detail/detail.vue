<template>
	<view class="page">
		<image class="cover" mode="aspectFill" :src="articleCover"></image>
		<view class="page-content">
			<view class="title">Model 3</view>
			<view class="meta">
				<view class="date">2022.03.30</view>
				<view class="views">阅览: 1000</view>
			</view>
			<rich-text :nodes="richText"></rich-text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				articleCover: 'https://cdn.mos.cms.futurecdn.net/BQwukuZwwwXrg27B9Le2Q6-970-80.png.webp',
				richText: 'Model 3于2017年12月前周产能均不达100辆，先前生产瓶颈为电池模组将cell贴至冷却液管上的前段组装制程(zone 1-2)，现在由人工进行，后段( zone 3-5)已全自动化'
			}
		}
	}
</script>

<style lang="scss">
@import url("detail.css");
</style>
