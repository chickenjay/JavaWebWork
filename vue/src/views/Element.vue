<template>
  <div>

    <el-menu router style="border: none" :default-active="$route.path">
      <el-menu-item index="/">
        <template slot="title">
          <i class="el-icon-house"></i>
          <span>系统首页</span>
        </template>
      </el-menu-item>
      <el-menu-item index="/element">Element页面</el-menu-item>
      <el-menu-item>系统首页</el-menu-item>
      <el-menu-item>系统首页</el-menu-item>
      <el-submenu>
        <template slot="title">
          <i class="el-icon-menu"></i>
          <span>信息管理</span>
        </template>
        <el-menu-item>用户信息</el-menu-item>
      </el-submenu>
    </el-menu>
<!--    <el-row :gutter="20">-->
<!--      <el-col :span="1">-->
<!--        <div style="width: 100%; height: 300px; background-color: dodgerblue"></div>-->
<!--      </el-col>-->
<!--      <el-col :span="23">-->
<!--        <div style="width: 100%; height: 300px; background-color: red"></div>-->
<!--      </el-col>-->
<!--    </el-row>-->

    <el-row>
      <el-col :span="6">
       <div style="padding: 10px; border: 1px solid #ccc; text-align: center">
         <img style="width: 80%" src="@/assets/logo.png" alt="">
         <div style="text-align: center">这是一段很牛bi的描述</div>
         <div style="color: red">价格 $99.00</div>
       </div>
      </el-col>
      <el-col :span="6">
        <div style="padding: 10px; border: 1px solid #ccc; text-align: center">
          <img style="width: 80%" src="@/assets/logo.png" alt="">
          <div style="text-align: center">这是一段很牛bi的描述</div>
          <div style="color: red">价格 $99.00</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div style="padding: 10px; border: 1px solid #ccc; text-align: center">
          <img style="width: 80%" src="@/assets/logo.png" alt="">
          <div style="text-align: center">这是一段很牛bi的描述</div>
          <div style="color: red">价格 $99.00</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div style="padding: 10px; border: 1px solid #ccc; text-align: center">
          <img style="width: 80%" src="@/assets/logo.png" alt="">
          <div style="text-align: center">这是一段很牛bi的描述</div>
          <div style="color: red">价格 $99.00</div>
        </div>
      </el-col>

    </el-row>


    <el-row>
      <el-col :span="24">
        <button>按钮</button>

        <el-button>Element独特的按钮</el-button>
        <el-button type="primary">主要的按钮</el-button>
        <el-button type="danger">危险的按钮</el-button>
        <el-button type="warning">警告的按钮</el-button>
        <el-button type="info">信息的按钮</el-button>
        <el-button type="success">成功的按钮</el-button>
        <el-button >默认的按钮</el-button>


        <el-button type="primary" plain>主要的按钮</el-button>
        <el-button type="danger" plain>主要的按钮</el-button>

        <el-button type="primary" plain round>主要的按钮圆角</el-button>


        <el-button circle icon="el-icon-edit" type="primary" ></el-button>
        <el-button circle icon="el-icon-delete" type="danger"></el-button>
      </el-col>
    </el-row>

    <el-row style="margin-top: 20px">
      <el-col>

        <el-input style="width: 200px" v-model="value" placeholder="青输入内容"></el-input>
        <el-input type="textarea" style="width: 200px" v-model="value1"></el-input>

        <el-input show-password style="width: 200px" v-model="password" placeholder="请输入密码"></el-input>

        <el-input style="width: 200px" v-model="value2" placeholder="青输入内容" prefix-icon="el-icon-search"></el-input>
        <el-input clearable style="width: 200px" v-model="value2" placeholder="青输入内容" suffix-icon="el-icon-user"></el-input>
        <el-button>搜索</el-button>

      </el-col>
    </el-row>

    <el-row style="margin: 20px 0">
      <el-autocomplete style="width: 300px" placeholder="请输入内容，我来帮你猜一猜" :fetch-suggestions="querySearch" :trigger-on-focus="false" v-model="value3"></el-autocomplete>
    </el-row>

    <el-row>
      <el-select v-model="select" @change="changeSelect">
        <el-option value="香蕉"></el-option>
        <el-option value="菠萝"></el-option>
        <el-option value="橘子"></el-option>
      </el-select>

      <el-select v-model="select1" multiple>
        <el-option v-for="item in fruits" :key="item.id" :value="item.name"></el-option>
      </el-select>

      <el-select v-model="select2" @change="changeSelectUser" filterable>
        <el-option v-for="item in users" :key="item.card" :label="item.label" :value="item.card"></el-option>
      </el-select>
    </el-row>


    <el-row>
      <el-radio-group v-model="radio" @change="selectRadio">
        <el-radio label="男"></el-radio>
        <el-radio label="女"></el-radio>
      </el-radio-group>


      <el-checkbox-group v-model="checkList" @change="selectCheckBox">
        <el-checkbox label="复选框 A"></el-checkbox>
        <el-checkbox label="复选框 B"></el-checkbox>
      </el-checkbox-group>

      <el-date-picker v-model="date" type="date" placeholder="选择日期" value-format="yyyy-MM-dd" @change="changeDate"></el-date-picker>
      <el-date-picker v-model="datetime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期时间" @change="changeDateTime"></el-date-picker>

      <el-date-picker v-model="daterange" type="daterange"
                      value-format="yyyy-MM-dd"
                      start-placeholder="开始日期"
                      end-placeholder="结束日期" @change="changeDateRange">
      </el-date-picker>

    </el-row>

    <el-row style="margin: 100px 0">
      <el-table :data="tableData" border :header-cell-style="{ background: 'aliceblue', fontSize: '16px' }">
        <el-table-column label="序号" prop="id" align="center"></el-table-column>
        <el-table-column label="名称" prop="name" align="center"></el-table-column>
        <el-table-column label="年龄" prop="age" align="center"></el-table-column>
        <el-table-column label="地址" prop="address" align="center"></el-table-column>
        <el-table-column label="操作">
          <template v-slot="scope">
            <el-button type="primary" @click="edit(scope.row)">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-row>

  </div>
</template>

<script>
export default {
  name: 'Element',
  data() {
    return {
      tableData: [
        {  name: '青哥哥哥', address: '安徽省合肥市', id: 1, age: '30' },
        {  name: '青哥哥哥', address: '安徽省合肥市', id: 1, age: '30' },
        {  name: '青哥哥哥', address: '安徽省合肥市', id: 1, age: '30' },
        {  name: '青哥哥哥', address: '安徽省合肥市', id: 1, age: '30' },
        {  name: '青哥哥哥', address: '安徽省合肥市', id: 1, age: '30' },
        {  name: '青哥哥哥', address: '安徽省合肥市', id: 1, age: '30' },
        {  name: '青哥哥哥', address: '安徽省合肥市', id: 1, age: '30' },
      ],
      value: '',
      value1: '',
      value2: '',
      value3: '',
      password: '',
      coffees: [{ value: '1星巴克咖啡' },{ value: '1栖巢咖啡' }, {value: '2瑞幸咖啡'}, {value: '3库迪咖啡'}],
      select: '',
      select1: '',
      select2: '',
      fruits: [
        { name: '苹果', id: 1 },
        { name: '橘子', id: 2 },
        { name: '香橙', id: 3 },
        { name: '青哥哥', id: 4 },
      ],
      users: [
        { label: '青哥哥', card: '1231321321321321312' },
        { label: '青哥哥小弟', card: '321321321321321321' },
        { label: '青哥哥大哥哥', card: '443525253265464598' },
      ],
      radio: '',
      checkList: [],
      date: '',
      datetime: '',
      daterange: '',
    }
  },
  methods: {
    edit(row) {
      // alert(row.name)
      // this.$message.success(row.name)
      // this.$message.warning(row.name)
      // this.$notify.success(row.name)

      this.$confirm('这是什么个玩意儿？', '提示', {
        type: 'warning'
      }).then(res => {
        this.$message.success("ok 我点击了确认")
      }).catch(() => {
        this.$message.warning("ok 我点击了取消")
      })

    },
    querySearch(query, cb) {  // callback
      let result =  query ? this.coffees.filter(v => v.value.includes(query)) : this.coffees
      console.log(result)
      cb(result);
    },
    changeSelect() {
      console.log(this.select)
    },
    changeSelectUser() {
      console.log(this.select2)
    },
    selectRadio() {
      alert(this.radio)
    },
    selectCheckBox() {
      console.log(this.checkList)
    },
    changeDate() {
      console.log(this.date)
    },
    changeDateTime() {
      console.log(this.datetime)
    },
    changeDateRange() {
      console.log(this.daterange)
    }


  }
}
</script>