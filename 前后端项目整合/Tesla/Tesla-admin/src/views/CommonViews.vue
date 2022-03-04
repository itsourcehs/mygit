<template>
  <el-container style="height: 100%">
    <el-aside width="200px">
      <img src="@/assets/img/admin_icon.jpg" style="height: 44px;width: auto">
      <admin-menu></admin-menu>
    </el-aside>

    <el-container style="width: 89%;margin-left: 200px">
      <el-header>
        <!--面包屑-->
        <div class="header-main">
          <el-row style="margin: 18px 0px 0px 18px">
            <el-breadcrumb separator="/">
              <el-breadcrumb-item :to="{path: '/admin'}">首页</el-breadcrumb-item>
              <el-breadcrumb-item>车辆管理</el-breadcrumb-item>
              <el-breadcrumb-item>Tesla配置</el-breadcrumb-item>
            </el-breadcrumb>
          </el-row>

          <div class="user-avatar">
            <span style="color: #2d8cf0">hs</span>
            <el-avatar shape="circle" :size="avatarSize" :fit="avatarFit" :src="avatarUrl"></el-avatar>
          </div>
        </div>
      </el-header>
      <el-main>
        <admin-tags></admin-tags>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import AdminMenu from '../components/AdminMenu.vue'; // 引用方法需要{} 引用组件不需要加{}
import AdminTags from "../components/AdminTags";
export default {
  name: "CommonViews",
  components: {
    AdminMenu,
    AdminTags
  },
  data () {
    return {
      avatarSize: 'large',
      avatarFit: 'fit',
      avatarUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
    }
  }
}
</script>

<style scoped lang="scss">
.el-aside {
  background-color: #495060;
  color: #333;
  text-align: center;
  line-height: 100px;
}
/*占满全屏*/
.el-container{
  position: absolute;
  width: 100%;
  top: 0;
  left: 0;
  bottom: 0;
  padding: 0;
}
.el-header {
  background-color: #ffffff;
  color: #333;
  padding: 0;
}
.el-main {
  background-color: #f0f0f0;
}

.header-main {
  display: flex;
  flex-direction: row;
  justify-content: space-between;

.user-avatar {
  margin-top: 10px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;

span {
  margin-right: 15px;
}
}
}
</style>
