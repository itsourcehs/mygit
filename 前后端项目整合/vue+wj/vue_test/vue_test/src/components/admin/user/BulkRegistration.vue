<template>
  <div style="text-align: left">
    <el-button class="add-button" type="success" @click="dialogFormVisible = true">批量添加用户</el-button>
    <el-dialog
      title="添加用户"
      :visible.sync="dialogFormVisible"
      @close="clear"
      width="25%">
      <el-form>
        <el-form-item prop="username">
          <el-input type="text" auto-complete="off" placeholder="账号" v-model="loginForm.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" auto-complete="off" placeholder="密码" v-model="loginForm.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="text" auto-complete="off" placeholder="真实姓名" v-model="loginForm.name"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="text" auto-complete="off" placeholder="电话号码" v-model="loginForm.phone"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="text" auto-complete="off" placeholder="邮箱" v-model="loginForm.email"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 40%;background: #505458;border: none" @click="register">添加</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'BulkRegistration',
  data () {
    return {
      dialogFormVisible: false,
      rules: {
        username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
        password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
      },
      loginForm: {
        username: '',
        password: '',
        name: '',
        phone: '',
        email: ''
      }
    }
  },
  methods: {
    register () {
      // 注册
      this.$axios.post('/register', {
        username: this.loginForm.username,
        password: this.loginForm.password,
        name: this.loginForm.name,
        phone: this.loginForm.phone,
        email: this.loginForm.email
      }).then(res => {
        if (res.status === 200) {
          this.$alert('注册成功', '提示', {confirmButtonText: '确定'})
          // this.clear()
          this.dialogFormVisible = false
          this.$emit('onSubmit')
        } else {
          this.$alert(res.data.message, '提示', {confirmButtonText: '确定'})
        }
      }).catch(failResponse => {
      })
    },
    clear () {
      this.loginForm = {
        username: '',
        password: '',
        name: '',
        phone: '',
        email: ''
      }
    }
  }
}
</script>

<style scoped>
.add-button {
  margin: 18px 0 0 10px;
}
</style>
