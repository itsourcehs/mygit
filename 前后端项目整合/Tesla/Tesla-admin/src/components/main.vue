<template>
  <el-container style="height: 100%">
    <el-aside width="200px">
		
		<div style="background-color: #363e4f;padding-top: 10px;">
			<img src="@/assets/img/admin_icon.jpg" style="height: 44px;width: auto">
		</div>
      
      <admin-menu :activepath="activePath"></admin-menu>
    </el-aside>

    <el-container style="width: 89%;margin-left: 190px;">
      <el-header>
        
		<!--面包屑-->
        <div class="header-main">
          <el-row style="margin: 18px 0px 0px 18px;display: flex;">
			<span
			class="el-icon-s-fold"
			style="margin-right: 10px;"
			v-model="isCollapse"></span>
            <el-breadcrumb separator="/">
              <el-breadcrumb-item>首页</el-breadcrumb-item>
              <el-breadcrumb-item
			  v-if="item.meta.title !== '首页'"
			  v-for="(item,index) in breadList"
			  :key="index">
			  {{item.meta.title}}
			  </el-breadcrumb-item>
            </el-breadcrumb>
          </el-row>

		  <!-- 用户头像 -->
          <div class="user-avatar">
            <span style="color: #2d8cf0">hs</span>
            <el-avatar shape="circle" :size="avatarSize" :fit="avatarFit" :src="avatarUrl"></el-avatar>
          </div>
        </div>
      </el-header>
      
	  <el-main>
		<!-- 动态导航标签卡 -->
        <div style="position: absolute;left: 0">
          <admin-tab></admin-tab>
        </div>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import AdminMenu from './menu.vue'; // 引用方法需要{} 引用组件不需要加{}
import AdminTab from './tabs.vue';

export default {
  name: "main",
  components: {
    AdminMenu,
	AdminTab
  },
  data () {
    return {
      avatarSize: 'large',
      avatarFit: 'fit',
      avatarUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      breadList: [],
	  activePath: '/index',
	  isCollapse: true
    }
  },
  // 监听属性
  watch: {
    // 监听路由变化
    $route (val) {
      this.getBreadList(val)
      // this.getTagsList(val)
    }
  },

  methods: {
    // 获取路由数组 参数val为 路由参数
    getBreadList (val) {
      // 过滤路由matched对象
      if (val.matched) {
        let matched = val.matched.filter(item => item.meta && item.meta.title);
        // 拿到过滤好的路由v-for遍历出来
        this.breadList = matched;
        let item = matched[matched.length -1].meta.title
		let path = matched[matched.length -1].path
		
        let nobject = {name: ''+ item, path: '' + path}

        // 每次追加前判断 数组 tags中是否已存在该值
        if(JSON.stringify(this.tags).indexOf(JSON.stringify(nobject))==-1 && item !== '首页'){
          this.tags.push(nobject); // 进行动态的tags列表追加操作
        }
      }
    },
  }
}
</script>

<style scoped lang="scss">
.el-aside {
  background-color: #495060;
  color: #333;
  text-align: center;
  line-height: 40px;
}
/*占满全屏*/
.el-container{
  position: absolute;
  width: 100%;
  top: 0;
  left: 0;right: 0;
  bottom: 0;
  padding: 0;
  background-color: #f0f0f0;
  
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
