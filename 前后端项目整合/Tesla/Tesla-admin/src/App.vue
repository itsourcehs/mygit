<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import main from "./components/main";
export default {
  name: 'App',
  components: {main}
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
