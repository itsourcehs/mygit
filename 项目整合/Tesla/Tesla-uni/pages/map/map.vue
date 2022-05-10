<template>
	<view class="map-page" style="position: relative;">
		<map
		v-if="!isSearching"
		id="myMap"
		class="map"
		:latitude="latitude"
		:longitude="longitude"
		:markers="markers"
		@markertap="onMarkerTap"
		show-location></map>
		
		<image class="current-location-icon" @tap="onCurrentLocationClick" :src="locationImage"></image>
		
		<tesla-search-input @confirm="onSearch" @clear="onClear" style="position: absolute;top: 104rpx;left: 44rpx;z-index: 1;"></tesla-search-input>
		
		<!-- 可滑动区域 -->
		<scroll-view v-if="!isSearching" scroll-x class="marker-classification-area">
			<view>
				<view class="marker-classification">
					<image class="icon"></image>
					<view class="title">标题</view>
				</view>
			</view>
		</scroll-view>
		
		<view class="search-area" v-if="isSearching">
			<view class="search-content">
				<view
				class="location-box"
				v-for="(item,index) in locationResult"
				:key="index"
				@tap="gotoLocation"
				:data-location="item">
					<image class="icon" src="../../static/images/nav/map.png"></image>
					<view class="info-box">
						<view class="name">姓名</view>
						<view class="address">四川省成都市....</view>
					</view>
				</view>
			</view>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				mapKey: '754763664aa5e35f1788229a5a5d3f0b',
				latitude: 0, // 中心纬度
				longitude: 0, // 中心经度
				markers: [],
				allMarkers: [],
				markerClassifications: [],
				isSearching: false,
				locationResult: [],
				locationImage: '../../static/images/icon/location.png'
			}
		},
		methods: {
			getContent () {
				
			}
		},
		onLoad() {
			
		}
	}
</script>

<style>
@import url("map.css");
</style>
