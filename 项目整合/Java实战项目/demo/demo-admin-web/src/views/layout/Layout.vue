<template>
	<div class="app-wrapper">
		<!-- 侧边导航栏 -->
		<sidebar class="sidebar-container"></sidebar>
		
		<div class="main-container">
			<navbar></navbar>
			<app-main></app-main>
		</div>
	</div>
</template>

<script>
import {Navbar, Sidebar, AppMain} from './components'
export default {
	name: 'layout',
	components: {
		Navbar,
		Sidebar,
		AppMain
	},
}
</script>

<style scoped>
.app-wrapper {
	@include clearfix;
	position: relative;
	height: 100%;
	width: 100%;
}
</style>
