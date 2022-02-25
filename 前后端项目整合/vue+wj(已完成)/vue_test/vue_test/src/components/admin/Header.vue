<template>
  <el-card class="admin-header">
    <div style="background-color: #495060;">
      <a href="/index">
        <img src="" alt="" width="55px" style="float: left;margin-top: -5px;">
      </a>
      <span style="font-size: 32px;font-weight: bold;position: absolute;left: 100px;">Admin</span>
    </div>
    <i class="el-icon-switch-button" @click="logout" style="font-size: 40px;float: right;"></i>
  </el-card>
</template>

<script>
// import {createRouter} from '../../router/index.js'
export default {
  name: 'Header',
  methods: {
    logout () {
      var _this = this
      this.$axios.get('/logout')
        .then(res => {
          if (res && res.data.code === 200) {
            _this.$store.commit('logout')
            _this.$router.replace('/index')
            // 清空路由,防止路由重新加载
            // const newRouter = createRouter()
            // _this.$router.matcher = newRouter.matcher
          }
        }).catch(failResponse => {})
    }
  }
}
</script>

<style>
.admin-header {
  height: 80px;
  opacity: 0.85;
  line-height: 40px;
  min-width: 900px;
}

.el-icon-switch-button {
  cursor: pointer;
  outline: 0;
}
</style>
