<template>
  <div class="dashboard-container">
    <div class="dashboard-editor-container">
		
		<el-row class="dashboard-el-row">
			
		</el-row>
		
		<el-row gutter="32">
			<el-col xs="24" sm="24" lg="8"></el-col>
			<el-col xs="24" sm="24" lg="8"></el-col>
			<el-col xs="24" sm="24" lg="8"></el-col>
		</el-row>
	</div>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      
    }
  }
}
</script>


<style scoped lang="scss">
.dashboard-editor-container {
	
}
.dashboard-el-row {
	background: #ff557f;
	/* background: #fff; */
	padding: 16px 16px 0;
	margin-bottom: 32px;
}
</style>
