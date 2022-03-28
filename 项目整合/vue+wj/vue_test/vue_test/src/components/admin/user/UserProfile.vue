<template>
  <div>
    <el-dialog title="修改用户信息" :visible.sync="dialogFormVisible">
      <el-form v-model="selectedUser" style="text-align: left" ref="dataForm">
        <el-form-item prop="username" label="用户名" label-width="120px">
          <label>{{selectedUser.username}}</label>
        </el-form-item>
        <el-form-item prop="name" label="真实姓名" label-width="120px">
          <el-input v-model="selectedUser.name" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item prop="phone" label="手机号" label-width="120px">
          <el-input v-model="selectedUser.phone" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item prop="email" label="邮箱" label-width="120px">
          <el-input v-model="selectedUser.email" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item prop="password" label="密码" label-width="120px">
          <el-button type="warning" @click="resetPassword(selectedUser.username)">重置密码</el-button>
        </el-form-item>
        <el-form-item prop="roles" label="角色分配" label-width="120px">
          <el-checkbox-group v-model="selectedRolesIds">
            <el-checkbox v-for="(role, i) in roles" :key="i" :label="role.id">{{role.nameZh}}</el-checkbox>
          </el-checkbox-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible=false">取消</el-button>
        <el-button type="primary" @click="onSubmit(selectedUser)">确定</el-button>
      </div>
    </el-dialog>
    <el-row style="margin: 18px 0px 0px 18px">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{path: '/admin'}">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>用户管理</el-breadcrumb-item>
        <el-breadcrumb-item>用户信息</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <!--  备用一行,用来注册用户-->
    <bulk-registration @onSubmit="listUsers()"></bulk-registration>
    <el-card style="margin: 18px 2%;width: 95%">
      <el-table
        :data="users"
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
          prop="username"
          label="用户名"
          fit></el-table-column>
        <el-table-column
          prop="name"
          label="真实姓名"
          fit></el-table-column>
        <el-table-column
          prop="phone"
          label="手机号"
          fit></el-table-column>
        <el-table-column
          prop="email"
          label="邮箱"
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
          prop="edits"
          label="操作"
          width="120">
          <div slot-scope="scope">
            <el-button @click="editUser(scope.row)" type="text" size="small">编辑</el-button>
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
import BulkRegistration from './BulkRegistration'

export default {
  name: 'UserProfile',
  components: {BulkRegistration},
  data () {
    return {
      users: [],
      selectedUser: [],
      selectedRolesIds: [],
      roles: [],
      dialogFormVisible: false
    }
  },
  computed: {
    tableHeight () {
      return window.innerHeight - 320
    }
  },
  mounted () {
    this.listUsers()
    this.listRoles()
  },
  methods: {
    listUsers () {
      var _this = this
      this.$axios.get('/admin/user')
        .then(res => {
          if (res && res.status === 200) {
            _this.users = res.data
          }
        })
    },
    listRoles () {
      var _this = this
      this.$axios.get('/admin/role')
        .then(res => {
          if (res && res.status === 200) {
            _this.roles = res.data
          }
        })
    },
    commitStatusChange (value, user) {
      if (user.username !== 'admin') {
        this.$axios.put('/admin/user/status', {enabled: value, username: user.username})
          .then(res => {
            if (res && res.status === 200) {
              if (value) {
                this.$message('用户[' + user.username + '] 已启用')
              } else {
                this.$message('用户[' + user.username + '] 已禁用')
              }
            }
          })
      } else {
        user.enabled = true
        this.$alert('不能禁用管理员账户')
      }
    },
    editUser (user) {
      // debugger
      this.dialogFormVisible = true
      this.selectedUser = user
      let roleIds = []
      for (let i = 0; i < user.roles.length; i++) {
        roleIds.push(user.roles[i].id)
      }
      this.selectedRolesIds = roleIds
    },
    onSubmit (user) {
      let _this = this
      // 根据视图绑定的角色id,向后端传递角色信息
      let roles = []
      for (let i = 0; i < _this.selectedRolesIds.length; i++) {
        for (let j = 0; j < _this.roles.length; j++) {
          if (_this.selectedRolesIds[i] === _this.roles[j].id) {
            roles.push(_this.roles[j])
          }
        }
      }
      // 发送请求
      this.$axios.put('/admin/user', {
        username: user.username,
        name: user.name,
        phone: user.phone,
        email: user.email,
        roles: roles
      }).then(resp => {
        if (resp && resp.status === 200) {
          this.$alert('用户信息修改成功')
          this.dialogFormVisible = false
          // 修改信息后重新请求,实现视图更新
          this.listUsers()
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
