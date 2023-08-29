<template>
  <div>
    <div style="box-shadow: 0 0 10px rgba(0,0,0,.1); padding: 10px 20px; border-radius: 5px; margin-bottom: 10px">
      早安，{{ user.name }}，祝你开心每一天！
    </div>

    <div style="display: flex">
      <el-card style="width: 100%;">
        <div slot="header" class="clearfix">
          <span>青哥哥带你做毕设2024</span>
        </div>
        <div>
          2024毕设正式开始了！青哥哥带你手把手敲出来！
          <div style="margin-top: 20px">
            <div style="margin: 10px 0"><strong>主题色</strong></div>
            <el-button type="primary">按钮</el-button>
            <el-button type="success">按钮</el-button>
            <el-button type="warning">按钮</el-button>
            <el-button type="danger">按钮</el-button>
            <el-button type="info">按钮</el-button>
          </div>
        </div>
      </el-card>
    </div>

  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      user: JSON.parse(localStorage.getItem('honey-user') || '{}'),
    }
  },
  created() {

  },
  methods: {}
}
</script>

<style scoped>

</style>