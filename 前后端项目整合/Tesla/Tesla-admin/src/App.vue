<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import CommonViews from "./components/CommonViews";
export default {
  name: 'App',
  components: {CommonViews}
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
