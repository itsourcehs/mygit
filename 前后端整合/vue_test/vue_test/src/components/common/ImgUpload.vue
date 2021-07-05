<template>
  <el-upload class="img-upload"
  action="http://localhost:8443/api/covers"
  :on-preview="handlePreview"
  :on-remove="handleRemove"
  :before-remove="beforeRemove"
  :on-success="handleSuccess"
  multiple
  :limit="1"
  :on-exceed="handleExceed"
  :file-list="fileList"
  ref="upload">
    <el-button size="small" type="primary">点击上传</el-button>
    <div slot="tip" class="el-upload__tip">只能上传jpg/png文件,且不超过500kb</div>
  </el-upload>
</template>

<script>
export default {
  name: 'ImgUpload',
  data () {
    return {
      fileList: [],
      url: ''
    }
  }
}
</script>

<style scoped>

</style>
