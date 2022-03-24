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
        <div style="position: absolute;left: 0">
          <el-tag
            v-for="tag in tags"
            :key="tag.name"
            style="margin: 0 10px"
            closable
            @close="handleClose(tag)"
            @click="handleClick(tag)"
            :type="tag.type">
            {{tag.name}}
		  </el-tag>
        </div>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import AdminMenu from './AdminMenu.vue'; // 引用方法需要{} 引用组件不需要加{}

export default {
  name: "CommonViews",
  components: {
    AdminMenu,
  },
  data () {
    return {
      avatarSize: 'large',
      avatarFit: 'fit',
      avatarUrl: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      breadList: [],
      tags: [
        { 
			name: '首页',
			type: '',
			path: '/index',
		},
      ],
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

    // 删除tag标签
    handleClose (tag) {
		const tagName = tag.name
		// 首页tag不可删除
		if (tagName == '首页') return this.$message('禁止删除！');
		this.tags.splice(this.tags.indexOf(tag), 1);
		// 删除标签后，跳转到最近的路由页面
		let endPath = this.tags[this.tags.length -1].path
		this.$router.push(''+ endPath).catch(()=>{})
    },
	
    // 点击tag标签
    handleClick (tag) {
		// 1.如果当前路由跟 tag.path 不相等，则跳转路由
		if (this.$route.path == tag.path) return;
		this.$router.push('' + tag.path).catch(()=>{})
		
		// 2.激活导航菜单对应项
		// console.log(tag.path);
		this.activePath = tag.path
		console.log(this.activePath);
    }
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
