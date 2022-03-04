<template>
  <div style="position: absolute;left: 0">
    <el-tag
      v-for="tag in tags"
      :key="tag.name"
      style="margin: 0 10px"
      closable
      @close="handleClose(tag)"
      :type="tag.type">
      {{tag.name}}
    </el-tag>
  </div>
</template>

<script>
export default {
  name: "AdminTags",
  data () {
    return {
      tags: [
        { name: '首页', type: '' },
        { name: 'Tesla配置', type: 'success' },
        { name: '标签三', type: 'info' },
        // { name: '标签四', type: 'warning' },
        // { name: '标签五', type: 'danger' }
      ]
    }
  },
  methods: {
    // 删除tag标签
    handleClose (tag) {
      const tagName = tag.name
      // 首页tag不可删除
      if (tagName !== '首页') {
        this.tags.splice(this.tags.indexOf(tag), 1);
      } else {
        this.$message('禁止删除！')
      }

    }
  }

}
</script>

<style scoped>

</style>
