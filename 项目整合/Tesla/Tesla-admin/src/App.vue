<template>
  <div id="app">
    <router-view v-if="isRouterAlive"/>
  </div>
</template>

<script>
import main from "./components/main";
export default {
  name: 'App',
  components: {main},
  provide () {
	  return {
		  reload: this.reload
	  }
  },
  data () {
	  return {
		 isRouterAlive: true 
	  }
  },
  methods: {
	  reload () {
		  this.isRouterAlive = false
		  this.$nextTick(function() {
			  this.isRouterAlive = true
		  })
	  }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
