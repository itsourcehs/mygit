<template>
<div>
  <el-dialog
  :visible.sync="dialogFormVisible"
  title="修改角色信息">
    <el-form v-model="selectedRole" style="text-align: left" ref="dataForm">
      <el-form-item
      prop="username"
      label="角色名"
      label-width="120px">
        <el-input v-model="selectedRole.name" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item
      prop="name"
      label="角色描述"
      label-width="120px">
        <el-input v-model="selectedRole.nameZh" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item
      prop="perms"
      label="功能配置"
      label-width="120px">
        <el-checkbox-group v-model="selectedPermsIds">
          <el-checkbox v-for="(perm, i) in perms" :key="i" :label="perm.id">{{perm.desc_}}</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item
      prop="menus"
      label="菜单配置"
      label-width="120px">
        <el-tree
        :data="menus"
        :props="props"
        show-checkbox
        :default-checked-keys="selectedMenusIds"
        node-key="id"
        ref="tree"></el-tree>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible=false">取消</el-button>
      <el-button type="primary" @click="onSubmit(selectedRole)">确定</el-button>
    </div>
  </el-dialog>
  <el-row style="margin: 18px 0px 0px 18px">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{path: '/admin'}">管理中心</el-breadcrumb-item>
      <el-breadcrumb-item>用户管理</el-breadcrumb-item>
      <el-breadcrumb-item>角色配置</el-breadcrumb-item>
    </el-breadcrumb>
  </el-row>
  <!--  备用一行,用来创建角色-->
  <el-card style="margin: 18px 2%;width: 95%">
    <el-table
    :data="roles"
    stripe
    style="width: 100%"
    :max-height="tableHeight">
      <el-table-column
        type="selection"
        width="55"
        show-overflow-tooltip></el-table-column>
      <el-table-column
      prop="id"
      label="id"
      width="100"></el-table-column>
      <el-table-column
      prop="name"
      label="角色名"
      fit></el-table-column>
      <el-table-column
      prop="nameZh"
      label="角色描述"
      fit></el-table-column>
      <el-table-column
      prop="sta"
      label="状态"
      width="100">
        <div slot-scope="scope">
          <el-switch
            v-model="scope.row.enabled"
            active-color="#13ce66"
            inactive-color="#ff4949"
            @change="(value) => commitStatusChange(value, scope.row)"></el-switch>
        </div>
      </el-table-column>
      <el-table-column
      label="操作"
      width="120">
        <div slot-scope="scope">
          <el-button @click="editRole(scope.row)" type="text" size="small">编辑</el-button>
          <el-button type="text" size="small">移除</el-button>
        </div>
      </el-table-column>
    </el-table>
    <div style="margin: 20px 0 20px 0;float: left">
      <el-button>取消选择</el-button>
      <el-button>批量删除</el-button>
    </div>
  </el-card>
</div>
</template>

<script>
export default {
  name: 'Role',
  data () {
    return {
      roles: [],
      menus: [],
      selectedRole: [],
      selectedPermsIds: [],
      selectedMenusIds: [],
      perms: [],
      dialogFormVisible: false,
      props: {
        id: 'id',
        label: 'nameZh',
        children: 'children'
      }
    }
  },
  computed: {
    tableHeight () {
      return window.innerHeight - 320
    }
  },
  mounted () {
    this.listRoles()
  },
  methods: {
    listRoles () {
      var _this = this
      this.$axios.get('/admin/role')
        .then(res => {
          if (res && res.status === 200) {
            _this.roles = res.data
          }
        })
    },
    editRole (role) {
      this.dialogFormVisible = true
    },
    onSubmit (role) {},
    commitStatusChange (value, role) {},
    listPerms () {
      // 功能配置列表方法
      var _this = this
      this.$axios.get('/admin/role/perm')
        .then(res => {
          if (res && res.status === 200) {
            _this.perms = res.data
          }
        })
    },
    listMenus () {
      // 菜单配置列表方法
      var _this = this
      this.$axios.get('/admin/role/menu')
        .then(res => {
          if (res && res.status === 200) {
            _this.menus = res.data
          }
        })
    }
  }
}
</script>

<style scoped>

</style>
