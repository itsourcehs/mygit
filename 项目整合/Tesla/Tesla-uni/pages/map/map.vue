<template>
	<view class="map-page">
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
	</view>
</template>

<script>
	export default {
		data() {
			return {
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
