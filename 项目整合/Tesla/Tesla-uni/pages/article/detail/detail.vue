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
				richText: 'Model 3于2017年12月前周产能均不达100辆，先前生产瓶颈为电池模组将cell贴至冷却液管上的前段组装制程(zone 1-2)，现在由人工进行，后段( zone 3-5)已全自动化，并已重新设计前段产线，目前最关键瓶颈已经逐步改善，估计未来五个月产能爬升期间仅需处理突发状况，逐步达到原始设计全线自动化生产后可望大幅提升产能。 Model 3 组装产线为高度自动化，仅有约5个部件为人工组装，多数为较软的部件如cable等(因机器人不擅长抓取软部件)。 Model 3cable长度降低一半仅1.5km系受惠于几乎无按钮仅有一个中控萤幕设计所致。'
			};
		}
	}
</script>

<style lang="scss">
@import url("detail.css");
</style>
